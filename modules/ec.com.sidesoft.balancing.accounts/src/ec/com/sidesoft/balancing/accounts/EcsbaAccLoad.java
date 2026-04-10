package ec.com.sidesoft.balancing.accounts;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Tree;
import org.openbravo.model.ad.utility.TreeNode;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;

public class EcsbaAccLoad extends DalBaseProcess {
  private static final Logger log = Logger.getLogger(EcsbaAccLoad.class);
  private static ProcessLogger logger;

  // ID fijo de la tabla C_ElementValue en Openbravo (siempre es 188 para cuentas)
  private static final String C_ELEMENTVALUE_TABLE_ID = "188";

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {

    final OBError message = new OBError();
    message.setType("Success");
    message.setTitle("Proceso Ejecutado");

    try {
      OBContext.setAdminMode(true);
      logger = bundle.getLogger();

      log.info("Entro al proceso de carga masiva de cuentas contables");

      Map<String, Object> params = bundle.getParams();

      EcsbaBreakdownBalance breakdownBalance = null;

      String headerId = (String) params.get("Ecsba_Breakdown_Balance_ID");
      String detailId = (String) params.get("Ecsba_Accounting_Accounts_ID");

      if (headerId != null) {
        breakdownBalance = OBDal.getInstance().get(EcsbaBreakdownBalance.class, headerId);
      } else if (detailId != null) {
        EcsbaAccountingAccounts accAccount = OBDal.getInstance().get(EcsbaAccountingAccounts.class,
            detailId);
        if (accAccount != null) {
          breakdownBalance = accAccount.getEcsbaBreakdownBalance();
        }
      }

      if (breakdownBalance == null) {
        message.setType("Error");
        message.setTitle("Error");
        message.setMessage("No se pudo identificar el registro padre (Breakdown Balance).");
        bundle.setResult(message);
        return;
      }

      // 2. LÓGICA DE SELECCIÓN DE CUENTAS
      String accountId = (String) params.get("cElementvalueId");
      int counter = 0;

      if (accountId != null && !accountId.isEmpty()) {
        // CASE 1: Single Account Selected 

        Tree accountTree = null;
        OBCriteria<Tree> treeCrit = OBDal.getInstance().createCriteria(Tree.class);
        treeCrit.add(Restrictions.eq(Tree.PROPERTY_TABLE,
            OBDal.getInstance().getProxy(Table.class, C_ELEMENTVALUE_TABLE_ID)));
        treeCrit.add(
            Restrictions.eq(Tree.PROPERTY_CLIENT, OBContext.getOBContext().getCurrentClient()));
        treeCrit.setMaxResults(1);

        accountTree = (Tree) treeCrit.uniqueResult();
        if (accountTree == null) {
          throw new Exception(
              "No se encontró un Árbol (AD_Tree) configurado para Cuentas Contables (C_ElementValue).");
        }

        // CAMBIO PRINCIPAL: Llamada al método recursivo
        counter = processTreeNodes(accountId, accountTree, breakdownBalance);

        if (counter == 0) {
          message.setType("Warning");
          message.setMessage("La cuenta seleccionada no tiene subcuentas válidas (activas y marcadas como módulo) en ningún nivel.");
        } else {
          message.setMessage("Se agregaron " + counter + " cuentas (incluyendo todos los niveles inferiores).");
        }

      } else {
        // CASO 2: VACÍO (Buscar por ssavIsmodule globalmente)
        log.info("Carga masiva: Buscando cuentas con ssavIsmodule=Y");

        OBCriteria<ElementValue> criteria = OBDal.getInstance().createCriteria(ElementValue.class);
        criteria.add(Restrictions.eq(ElementValue.PROPERTY_CLIENT,
            OBContext.getOBContext().getCurrentClient()));
        criteria.add(Restrictions.eq(ElementValue.PROPERTY_ACTIVE, true));
        criteria.add(Restrictions.eq(ElementValue.PROPERTY_SSAVISMODULE, true));

        List<ElementValue> accounts = criteria.list();
        for (ElementValue account : accounts) {
          insertAccount(account, breakdownBalance);
          counter++;
        }

        message.setMessage("Proceso completado. Cuentas agregadas: " + counter);
      }

    } catch (Exception e) {
      log.error("Error", e);
      message.setType("Error");
      message.setTitle("Error");
      message.setMessage(e.getMessage());
      e.printStackTrace();
    } finally {
      OBContext.restorePreviousMode();
      bundle.setResult(message);
    }
  }

  // MÉTODO RECURSIVO
  // Este método busca los hijos, inserta, y luego busca dentro de los hijos
  private int processTreeNodes(String parentNodeId, Tree tree, EcsbaBreakdownBalance breakdownBalance) {
    int localCounter = 0;

    // Buscar hijos inmediatos del nodo actual (parentNodeId)
    OBCriteria<TreeNode> treeCriteria = OBDal.getInstance().createCriteria(TreeNode.class);
    treeCriteria.add(Restrictions.eq(TreeNode.PROPERTY_REPORTSET, parentNodeId)); // Buscamos quien tiene a este padre
    treeCriteria.add(Restrictions.eq(TreeNode.PROPERTY_TREE, tree));
    treeCriteria.add(Restrictions.eq(TreeNode.PROPERTY_CLIENT, OBContext.getOBContext().getCurrentClient()));

    List<TreeNode> childNodes = treeCriteria.list();

    for (TreeNode node : childNodes) {
      String childAccountId = node.getNode();
      ElementValue childAccount = OBDal.getInstance().get(ElementValue.class, childAccountId);

      if (childAccount != null && childAccount.isActive()) {
        
        // 1. Verificamos si CUMPLE la condición para insertarla
        if (Boolean.TRUE.equals(childAccount.isSsavIsmodule())) {
          insertAccount(childAccount, breakdownBalance);
          localCounter++;
        }

        // 2. Llamada Recursiva

        localCounter += processTreeNodes(childAccountId, tree, breakdownBalance);
      }
    }
    return localCounter;
  }

  private void insertAccount(ElementValue elementValue, EcsbaBreakdownBalance parentRecord) {
    // Prevent duplicates
    OBCriteria<EcsbaAccountingAccounts> check = OBDal.getInstance()
        .createCriteria(EcsbaAccountingAccounts.class);
    check.add(Restrictions.eq(EcsbaAccountingAccounts.PROPERTY_ACCOUNTELEMENT, elementValue));
    check.add(Restrictions.eq(EcsbaAccountingAccounts.PROPERTY_ECSBABREAKDOWNBALANCE, parentRecord)); 

    if (check.count() == 0) {
      EcsbaAccountingAccounts newRecord = OBProvider.getInstance()
          .get(EcsbaAccountingAccounts.class);
      newRecord.setClient(parentRecord.getClient());
      newRecord.setOrganization(parentRecord.getOrganization());
      newRecord.setActive(true);

      // Datos de negocio
      newRecord.setAccountElement(elementValue);
      newRecord.setEcsbaBreakdownBalance(parentRecord);

      OBDal.getInstance().save(newRecord);
    }
  }
}
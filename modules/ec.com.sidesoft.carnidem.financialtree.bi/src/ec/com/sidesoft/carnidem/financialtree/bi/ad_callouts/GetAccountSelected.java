package ec.com.sidesoft.carnidem.financialtree.bi.ad_callouts;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.TreeNode;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;

import ec.com.sidesoft.carnidem.financialtree.bi.Acctclassif;

import java.util.List;

public class GetAccountSelected extends SimpleCallout {
  private static final Logger logger = Logger.getLogger(GetAccountSelected.class);

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    final String acctAccountId = info.getStringParameter("inpcElementvalueId", null);

    if (acctAccountId == null || acctAccountId.isEmpty()) {
      return;
    }

    try {
      // Obtener el tipo de cuenta (accountType) desde ElementValue
      ElementValue acct = OBDal.getInstance().get(ElementValue.class, acctAccountId);
      if (acct == null || acct.getAccountType() == null) {
        info.addResult("inpscftAcctclassifId", (String) null);
        return;
      }

      // Buscar en scft_acctclassif con el mismo tipo de cuenta
      OBCriteria<Acctclassif> criteria = OBDal.getInstance().createCriteria(Acctclassif.class);
      criteria.add(Restrictions.eq(Acctclassif.PROPERTY_ACCOUNTTYPE, acct.getAccountType()));
      criteria.setMaxResults(1);

      List<Acctclassif> result = criteria.list();

      if (!result.isEmpty()) {
    	  Acctclassif classif = result.get(0);
          info.addResult("inpscftAcctclassifId", classif.getId());
          info.addResult("inpaccttype", classif.getAccountType());
      } else {
          info.addResult("inpscftAcctclassifId", (String) null);
          info.addResult("inpaccttype", (String) null);
      }

    } catch (Exception e) {
      logger.error("Error en el callout GetAccountSelected", e);
      info.addResult("inpscftAcctclassifId", (String) null);
    }
  }
}

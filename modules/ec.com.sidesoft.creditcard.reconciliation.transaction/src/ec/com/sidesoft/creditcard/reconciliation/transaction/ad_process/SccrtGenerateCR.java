package ec.com.sidesoft.creditcard.reconciliation.transaction.ad_process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;

import ec.com.sidesoft.creditcard.reconciliation.SsccrCardMatchingConf;
import ec.com.sidesoft.creditcard.reconciliation.SsccrCardMatchingConfLine;
import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRec;
import ec.com.sidesoft.creditcard.reconciliation.SsccrProcessorBanck;
import ec.com.sidesoft.creditcard.reconciliation.SsccrWithholdings;
import ec.com.sidesoft.creditcard.reconciliation.actionHandler.SSCCR_AddFinTransActionHandler;
import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadLine;
import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadTransaction;
import ec.com.sidesoft.creditcard.reconciliation.transaction.sccrt_concepts;
import ec.com.sidesoft.creditcard.reconciliation.transaction.actionHandler.SCCRT_AddFinTransActionHandler;

public class SccrtGenerateCR extends DalBaseProcess {
  private final Logger logger = Logger.getLogger(SccrtGenerateCR.class);
  private String msgError = "";
  String multilote="";
  
  @Override
  public void doExecute(ProcessBundle bundle) throws Exception {
    OBError msg = new OBError();
    msg.setType("Success");
    msg.setTitle(OBMessageUtils.messageBD("Success"));
    try {
      OBContext.setAdminMode();
      // Parametros
      final String recordId = (String) bundle.getParams().get("Sccrt_Card_Load_Transaction_ID");
      SccrtCardLoadTransaction head = OBDal.getInstance().get(SccrtCardLoadTransaction.class,
          recordId);
      // Table: ssccr_pos_card_rec, ID: D3AC9D0A1FFE40239A2ACF8AF86200CD
      DocumentType docCT = getDocumentType("D3AC9D0A1FFE40239A2ACF8AF86200CD");
      if (docCT == null) {
        throw new OBException(
            "El tipo de documento para la conciliación de tarjetas no esta configurado.");
      }
      if (head != null) {
    	  preProcessCT(head);
          validateLines(head, docCT,recordId);
      }
      msg.setMessage(msgError);

    } catch (final Exception e) {
      logger.error("Exception found in SccrtGenerateCR process: ", e);
      msg.setType("Error");
      msg.setTitle(OBMessageUtils.messageBD("Error"));
      msg.setMessage(e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
      bundle.setResult(msg);
    }
  }

	/**
	 * Inicia el proceso de las tarjetas de conciliacion
	 *
	 * @param head         The SccrtCardLoadTransaction object representing the
	 *                     transaction.
	 * @param documentType The DocumentType object representing the document type.
	 * @throws Exception If an error occurs during processing.
	 */
  public void validateLines(SccrtCardLoadTransaction head, DocumentType documentType, String recordId) throws Exception {
	    Boolean trxSuccess = true;

	    // Agrupamos las líneas por groupingBatch
	    Map<String, List<SccrtCardLoadLine>> groupedLines = head.getSccrtCardLoadLineList().stream()
	            .filter(line -> line.getFINFinaccTranssaction() != null && !line.isProcessed() && !line.isError())
	            .collect(Collectors.groupingBy(SccrtCardLoadLine::getGroupingBatch));

	    // Recorremos cada grupo
	    for (Map.Entry<String, List<SccrtCardLoadLine>> entry : groupedLines.entrySet()) {
	        List<SccrtCardLoadLine> group = entry.getValue();
	        SccrtCardLoadLine firstLine = group.get(0); // usamos la primera del grupo como referencia

	        String newHead = generateCardReconciliation(firstLine, head, documentType);

	        if (StringUtils.isNotBlank(newHead)) {
	            try {
	                // Ejecutamos los procesos solo una vez por grupo
	                generateLines(firstLine.getFINFinaccTranssaction().getId(), newHead, recordId);

	                // 🔹 Sumamos los amount del grupo
	                BigDecimal totalAmount = group.stream()
	                        .map(SccrtCardLoadLine::getAmount)
	                        .reduce(BigDecimal.ZERO, BigDecimal::add);

	                // 🔹 Procesamos SOLO la primera línea con el monto total
	                processCT(newHead, firstLine.getId(), totalAmount);

	                // 🔹 Marcamos las demás líneas como procesadas
	                SsccrPosCardRec newCT = OBDal.getInstance().get(SsccrPosCardRec.class, newHead);
	                for (int i = 1; i < group.size(); i++) {
	                    SccrtCardLoadLine line = group.get(i);
	                    FIN_FinaccTransaction trx = line.getFINFinaccTranssaction();
	                    if (newCT != null && trx != null) {
	                        line.setPOSCardReconciliation(newCT);
	                        trx.setSsccrPosCardRec(newCT);
	                        trx.setSsccrReconciled("Y");
	                        OBDal.getInstance().save(trx);
	                    }
	                    line.setProcessed(true);
	                    OBDal.getInstance().save(line);
	                }
	                OBDal.getInstance().flush();

	            } catch (Exception e) {
	                trxSuccess = false;
	                logger.info("Error in validateLines");
	                throw new OBException("<b>Recap: </b>[" + firstLine.getRecap() + "], <b>Lote: </b>["
	                        + firstLine.getLotName() + "], <b>Error</b>: " + e.getMessage());
	            } finally {
	                if (!trxSuccess) {
	                    removeCardReconciliation(newHead);
	                }
	            }
	        }
	    }

	    // Actualizamos el estado del documento a "CO" solo si todas las líneas están procesadas
	    if (trxSuccess) {
	        boolean allProcessed = head.getSccrtCardLoadLineList().stream().allMatch(SccrtCardLoadLine::isProcessed);
	        if (allProcessed) {
	            head.setDocumentStatus("CO");
	        }
	    }
	}




  public String generateCardReconciliation(SccrtCardLoadLine line, SccrtCardLoadTransaction head,
      DocumentType documentType) {
    String id = null;
    multilote=line.getGroupingBatch();
    try {
      OBContext.setAdminMode(true);
      SsccrPosCardRec newCR = OBProvider.getInstance().get(SsccrPosCardRec.class);
      // Obtenemos la secuencia del documento
      String strPaymentDocumentNo = FIN_Utility.getDocumentNo(documentType, "Ssccr_Pos_Card_Rec");
      String desc = "Generate by : Carga de Liquidacion [" + head.getDocumentNo()
          + "], Lote/Recap [" + ObjectUtils.defaultIfNull(line.getLotName(), "") + "/"
          + ObjectUtils.defaultIfNull(line.getRecap(), "") + "], Multilote: "+ObjectUtils.defaultIfNull(line.getGroupingBatch(), "No es multilote");      newCR.setOrganization(head.getOrganization());
      newCR.setFINFinancialAccountFrom(head.getFINFinancialAccountFrom());
      newCR.setFINFinancialAccountTo(head.getFINFinancialAccountTo());
      newCR.setStartDate(line.getDateDeposit());
      newCR.setENDDate(line.getDateDeposit());
      newCR.setDatePayment(line.getDateDeposit());
      newCR.setDescription(StringUtils.substring(desc, 0, 450));
      newCR.setDocumentType(documentType);
      newCR.setDocumentNo(strPaymentDocumentNo);
      newCR.setSccrtGenerateSpecial(true);
      OBDal.getInstance().save(newCR);
      id = newCR.getId();
    } catch (Exception e) {
      // TODO: handle exception
      logger.info("generateCardReconciliation: " + e.getMessage());
    } finally {
      OBDal.getInstance().flush();
      OBContext.restorePreviousMode();
    }
    return id;
  }

  public void generateLines(String line, String headId, String recordHead) throws JSONException {
    HashMap<String, Object> parameters = new HashMap<String, Object>();
    JSONObject params = new JSONObject();
    JSONArray selectedTrxs = new JSONArray();
    JSONObject paramsObj = new JSONObject();
    JSONObject ids = new JSONObject();

    JSONObject recordId = new JSONObject();
    recordId.put("id", line);
    recordId.put("procesorBank", line);

    selectedTrxs.put(recordId);
    ids.put("_selection", selectedTrxs);

    paramsObj.put("finnancial_transaction", ids);
    params.put("Ssccr_Pos_Card_Rec_ID", headId);
    params.put("Sccrt_Card_Load_Transaction_ID", recordHead);
    params.put("_params", paramsObj);
    params.put("_multilote", multilote);
    JSONObject result = new SCCRT_AddFinTransActionHandler().doExecute(parameters,
        params.toString());
    if (result.has("message")) {
      JSONObject jsonparams = result.getJSONObject("message");
      String msg = OBMessageUtils
          .messageBD(jsonparams.getString("text").replace("ERROR=", "@").trim());

      logger.info("Error in generateLines");
      throw new OBException(msg);
    }
  }

  public DocumentType getDocumentType(String tableId) {

    OBCriteria<DocumentType> obcDoc = OBDal.getInstance().createCriteria(DocumentType.class);
    obcDoc.add(Restrictions.eq(DocumentType.PROPERTY_TABLE + ".id", tableId));
    obcDoc.setMaxResults(1);
    DocumentType doctype = (DocumentType) obcDoc.uniqueResult();
    return doctype;
  }

  public void removeCardReconciliation(String recordId) {
    try {
      OBContext.setAdminMode(true);
      SsccrPosCardRec head = OBDal.getInstance().get(SsccrPosCardRec.class, recordId);
      if (head != null) {
        OBDal.getInstance().flush();
        OBDal.getInstance().refresh(head);
        if (!head.getSsccrPosCardRecLineList().isEmpty()) {
          head.getSsccrPosCardRecLineList().clear();
          head.getSsccrPosCardRecSumList().clear();
          OBDal.getInstance().save(head);
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
      logger.info("removeCardReconciliation: " + e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  
	/**
	 * Validaciones previas a la carga de la conciliacion de tarjetas.
	 * Tambien se valida retenciones por cada una de las lineas de la carga.
	 *
	 * @param head The SccrtCardLoadTransaction object representing the transaction.
	 */
	private void preProcessCT(SccrtCardLoadTransaction head) {
		String msg = "";
		try {
			for (SccrtCardLoadLine line :  head.getSccrtCardLoadLineList() ){
				if(line.getFINFinaccTranssaction() != null ) {
					line.setError(false);
					OBDal.getInstance().save(line);
					if ( !line.isProcessed()) {
						FIN_FinaccTransaction finacc = line.getFINFinaccTranssaction();
						if (finacc.getSsccrProcessorBanck() == null) {
							msg = msg + "Verificar el banco procesador para la TRX  <" +finacc.getSfadtAccsequence()+"> ";
							line.setError(true);
							line.setLOGError(msg);
							OBDal.getInstance().save(line);
						}else {
							getWithholdings(line, finacc.getSsccrProcessorBanck());
						}
					}
					OBDal.getInstance().flush();
				}
			}
		} catch (Exception e) {
			throw new OBException("Error al validar las lineas.  "+e.getMessage());
		}

	}
	
	/**
	 * Obtiene y valida que existan al menos 5 retenciones por cada banco procesador.
	 *
	 * @param SccrtCardLoadLine lineline
	 * @param processorBankId The ID of the processor bank.
	 * @return A list of sccrt_concepts objects.
	 */
	private   List<sccrt_concepts> getWithholdings(SccrtCardLoadLine line ,  SsccrProcessorBanck processorBank) {
		String msg = "";
		List<sccrt_concepts> list = processorBank.getSccrtConceptsList();
        
        if(list.size() == 0) {
        	msg = msg + "No se han encontrado los conceptos configurados para el banco procesador "+processorBank.getName();
        	line.setError(true);
        }
        
        Set<String> types = new HashSet<>();
        for (sccrt_concepts concept  : list) {
            types.add(concept.getWarehouseRuleType());
        }

        if (types.size() < 5) {
        	msg = msg + "No hay al menos 5 tipos de conceptos configiurados para el banco procesador "+processorBank.getName() ;
        	line.setError(true);
        }
        
        line.setLOGError(msg);
    	OBDal.getInstance().save(line);

        return list;
	}

  private void processCT(String documentId, String lineId, BigDecimal totalamount) {

    // Ad_Process: sccrt_process
    org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
        .get(org.openbravo.model.ad.ui.Process.class, "F0EAD7BD0B0F4BFEA2CD28031955300C");

    final ProcessInstance pInstance = CallProcess.getInstance().call(process, documentId, null);

    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
    String msg = oberror.getMessage();
    if (pInstance.getResult() == 0) {
      logger.info("Error in processCT");
      throw new OBException(msg);
    } else {
      SccrtCardLoadLine line = OBDal.getInstance().get(SccrtCardLoadLine.class, lineId);
      if (line != null) {
    	  SsccrPosCardRec newCT = OBDal.getInstance().get(SsccrPosCardRec.class, documentId);
    	  FIN_FinaccTransaction trx = line.getFINFinaccTranssaction();
    	  if(newCT  !=  null  &&  trx != null) {
    		  line.setPOSCardReconciliation(newCT);
    		  trx.setSsccrPosCardRec(newCT);
    		  trx.setSsccrReconciled("Y");
    		  OBDal.getInstance().save(trx);
    	      OBDal.getInstance().flush();
    	  }
        line.setProcessed(true);
        
        OBDal.getInstance().save(line);
        OBDal.getInstance().flush();
      }

      ;

    }

  }
  

}
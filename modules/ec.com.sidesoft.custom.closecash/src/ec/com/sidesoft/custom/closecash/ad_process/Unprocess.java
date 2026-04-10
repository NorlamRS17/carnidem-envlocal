package ec.com.sidesoft.custom.closecash.ad_process;

import org.openbravo.advpaymentmngt.process.FIN_TransactionProcess;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.custom.closecash.ScccCashClousure;

import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Unprocess extends DalBaseProcess {
	private static final Logger log = Logger.getLogger(Unprocess.class);
	
	protected ConnectionProvider conn;

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub

		VariablesSecureApp vars = bundle.getContext().toVars();
		ConnectionProvider conn = new DalConnectionProvider(false);
		String language = OBContext.getOBContext().getLanguage().getLanguage();
		OBError message  = new OBError();

		try {
			String recordId = (String) bundle.getParams().get("Sccc_Cash_Clousure_ID");
			ScccCashClousure objCloseCash = OBDal.getInstance().get(ScccCashClousure.class, recordId);

			if (objCloseCash != null) {
				//Ejecutar los puntos de extensión previos al cierre de caja
				PreCloseCashExtensionsPoints(recordId);
				//Fecha de cierre de caja
				validatePeriod(objCloseCash.getClosingdate());
				//Fecha de procesamiento del cierre de caja
				validatePeriod(objCloseCash.getProcessDate());
				//Recuperar las Transacciones afectadas por el cierre
				List<FIN_FinaccTransaction> transactions = getTransactions(recordId);
				//Desprocesar las transacciones afectadas por el cierre
				UnprocessCloseCash(objCloseCash, transactions);
				//Ejecutar los puntos de extensión posteriores al cierre de caja
				PostCloseCashExtensionsPoints(recordId);
			}

			
			message.setMessage("Cierre de caja desprocesado correctamente");
			message.setTitle(Utility.messageBD(conn, "Success", language));
			message.setType("Success");

		} catch (Exception e) {
			message.setMessage(e.getMessage());
			message.setTitle(Utility.messageBD(conn, "Error", language));
			message.setType("Error");
			OBDal.getInstance().rollbackAndClose();
		} finally {
			bundle.setResult(message);
		}

	}
	
/**
 * Valida si el periodo contable se encuentra activo y abierto
 * 
 * @param validatorDate
 * @return
 * @throws OBException
 */
public static Period validatePeriod(Date validatorDate) {
		
		// Obtener la fecha ingresada
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Guayaquil"));
		calendar.setTime(validatorDate);

		// Establecer la fecha inicial al primer día del mes
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date startDate = calendar.getTime();

		// Establecer la fecha final al último día del mes
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date endDate = calendar.getTime();
		
		// Formatear las fechas a String en el formato dd-MM-yyyy
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String startDateStr = sdf.format(startDate);
	    String endDateStr = sdf.format(endDate);

		Period obj = null;
		StringBuilder whereClause = new StringBuilder();
		whereClause.append(" WHERE ");
		whereClause.append(Period.PROPERTY_ACTIVE + " = 'Y' ");
		whereClause.append(" AND ");
		whereClause.append("DATE("+ Period.PROPERTY_STARTINGDATE  +")"+ " =  DATE( :startDate)");
		whereClause.append(" AND ");
		whereClause.append("DATE("+ Period.PROPERTY_ENDINGDATE +")"+ " = DATE( :endDate)");

		OBQuery<Period> qPeriod = OBDal.getInstance().createQuery(Period.class, whereClause.toString());
		qPeriod.setNamedParameter("startDate", startDate);
		qPeriod.setNamedParameter("endDate", endDate);

		if (qPeriod.list().size() == 1) {
			obj = qPeriod.list().get(0);
			if (!obj.getStatus().equals("O")) {
				obj = null;
			}
		}
		
		if (obj == null) {
			throw new OBException("Periodo contable cerrado "+startDateStr);
		}

		return obj;
	}


	/**
	 * Recupera las transacciones afectadas por el cierre de caja
	 * 
	 * @param closeCashID
	 * @return
	 * @throws OBException
	 */
	public List<FIN_FinaccTransaction> getTransactions(String closeCashID) {
		List<FIN_FinaccTransaction> transactions = null;
		
		StringBuilder whereClause = new StringBuilder();
		whereClause.append(" WHERE ");
		whereClause.append(FIN_FinaccTransaction.PROPERTY_ACTIVE + " = 'Y' ");
		whereClause.append(" AND ");
		whereClause.append(FIN_FinaccTransaction.PROPERTY_SCCCCASHCLOUSURE +".id"+ " =  :closeCashID");
		OBQuery<FIN_FinaccTransaction> qTransactions = OBDal.getInstance().createQuery(FIN_FinaccTransaction.class, whereClause.toString());
		qTransactions.setNamedParameter("closeCashID", closeCashID);

		if (qTransactions.list().size() > 0) {
			transactions = qTransactions.list();
		}else {
			throw new OBException("No se ha logrado recuperar las transacciones afectadas con el presente cierra de caja.");
		}

		return transactions;
	}
	
	
	/**
	 * Desprocesa las transacciones afectadas por el cierre de caja
	 * 
	 * @param objCloseCash
	 * @param transactions
	 * @throws OBException
	 */
	public void UnprocessCloseCash(ScccCashClousure objCloseCash, List<FIN_FinaccTransaction> transactions ) {
		for (FIN_FinaccTransaction transaction : transactions) {
			String posted = transaction.getPosted();
			if (posted != null && posted.equals("Y")) {
				transaction.setPosted("N");
				OBDal.getInstance().save(transaction);
			}
			
			String FinaccTransactionTabID = "4D8C3B3C31D1410DA046140C9F024D17";
			removeFaccAccount(transaction.getId(), FinaccTransactionTabID);
			
			FIN_TransactionProcess.doTransactionProcess("R", transaction);
			OBDal.getInstance().remove(transaction);
			OBDal.getInstance().flush();
		}
		//Actualiza nuevamente a registrado el estado del cierre de caja
		objCloseCash.setDocumentStatus("SCCC_RG");
		objCloseCash.setProcess("PR");
		objCloseCash.setSscccinProcessed(false);
		OBDal.getInstance().save(objCloseCash);
		OBDal.getInstance().flush();
	}
	
	/**
	 * Elimina el registro de la tabla de contabilización
	 * 
	 * @param recordID
	 * @param tableID
	 */
	private void removeFaccAccount(String  recordID, String tableID) {
		StringBuilder whereClause = new StringBuilder();
		whereClause = new StringBuilder();
		whereClause.append(" WHERE ");
		whereClause.append(AccountingFact.PROPERTY_RECORDID+ " = :recordID ");
		 whereClause.append(" AND ");
		whereClause.append(AccountingFact.PROPERTY_TABLE + ".id = :tableID");
		OBQuery<AccountingFact> qAccountingFact= OBDal.getInstance().createQuery(AccountingFact.class,whereClause.toString());
		qAccountingFact.setNamedParameter("recordID", recordID);
		qAccountingFact.setNamedParameter("tableID", tableID);
		
		if (qAccountingFact.list().size() > 0) {
			for	(AccountingFact  obj : qAccountingFact.list()) {
				OBDal.getInstance().remove(obj);
				OBDal.getInstance().flush();
			}
		}
}
	
	/**
	 * Ejecuta los puntos de extensión previos al cierre de caja
	 * 
	 * @param recordId
	 * @return
	 */
	public String PreCloseCashExtensionsPoints(String recordId) {
		//Map<String, String> parameters = new HashMap<String, String>();
	    //parameters.put("C_Order_ID", recordId);
	    org.openbravo.model.ad.ui.Process process = OBDal.getInstance().get(org.openbravo.model.ad.ui.Process.class, "C316EA7BBACC45C2B2E229A1C55269F4");
	    ProcessInstance pInstance = CallProcess.getInstance().call(process, recordId, null);
	    
	    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
	    String msg = oberror.getMessage();
	    
	    if (pInstance.getResult() == 0) {
	      throw new OBException(msg);
	    }
	    
	    return msg;
	}
	
	/**
	 * Ejecuta los puntos de extensión posteriores al cierre de caja
	 * 
	 * @param recordId
	 * @return
	 */
	public String PostCloseCashExtensionsPoints(String recordId) {
		//Map<String, String> parameters = new HashMap<String, String>();
	    //parameters.put("C_Order_ID", recordId);
	    org.openbravo.model.ad.ui.Process process = OBDal.getInstance().get(org.openbravo.model.ad.ui.Process.class, "2AEAACCCD70F4CA385942750EC208FBB");
	    ProcessInstance pInstance = CallProcess.getInstance().call(process, recordId, null);
	    
	    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
	    String msg = oberror.getMessage();
	    
	    if (pInstance.getResult() == 0) {
	      throw new OBException(msg);
	    }
	    
	    return msg;
	}

}

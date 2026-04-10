package ec.com.sidesoft.pos.imports.errors.background;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallStoredProcedure;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.retail.posterminal.OBPOSErrors;
import org.openbravo.service.importprocess.ImportEntry;
import org.openbravo.erpCommon.utility.SequenceIdData;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;


public class SSPIERS_ImportsErrors extends DalBaseProcess implements KillableProcess  {
	private final Logger logger = Logger.getLogger(SSPIERS_ImportsErrors.class);
	private boolean killProcess = false;
	
	
	
	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		OBContext.setAdminMode(true);
				
		
			try {
				OBCriteria<ImportEntry> importEntry = OBDal.getInstance().createCriteria(ImportEntry.class);
				List<String> listProcessed = new ArrayList<>();
				listProcessed.add("Processed");
				listProcessed.add("Procesado");
				listProcessed.add("Inicial");
				listProcessed.add("Initial");


				
				importEntry.add(Restrictions.not(Restrictions.in(ImportEntry.PROPERTY_IMPORTSTATUS,listProcessed)));

				List<ImportEntry> listEntry = importEntry.list();

				for(ImportEntry entry : listEntry ){
					String jsonInfo = entry.getJsonInfo();
					String typeOfData = entry.getTypeofdata();
					Boolean newLine = true;
					if(typeOfData.equals("Order")){
						String searchOrderId = getIdJSONOrder(jsonInfo);
						if(existsInOPOSErrorTable(searchOrderId)){
							newLine = false;
						}
					}

					if(newLine){
						insertNewLineInOBPOSErrorTable(entry);
					} 

					entry.setImportStatus("Processed");
					OBDal.getInstance().save(entry);	
					OBDal.getInstance().flush();			
				}			
				OBDal.getInstance().commitAndClose();
			} catch (final Exception e) {
				// TODO: handle exception
				OBDal.getInstance().rollbackAndClose();
				logger.error("Exception found in SSPIERS_ImportsErrors: ", e);
				Throwable throwable = DbUtility.getUnderlyingSQLException(e);
				String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
			}
				
	}

	private void insertNewLineInOBPOSErrorTable(ImportEntry data) throws Exception {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(data.getId());
		String jsonData = getJSONInfo(data.getJsonInfo());
		if (jsonData.length() >= 2 && (jsonData.charAt(0) == '[' && jsonData.charAt(jsonData.length() - 1) == ']')) {
		    jsonData = jsonData.substring(1, jsonData.length() - 1);
		}
		parameters.add(jsonData);
		String procedureName = "sspiers_insert_obposerror";
		String response = (String) CallStoredProcedure.getInstance().call(procedureName, parameters, null, true, true);

		if(!response.equals("Y")){
			throw new Exception(response);
		}
		
	}

	private String getJSONInfo(String json) throws Exception {
		JSONObject jsonObject = new JSONObject(json);

		if(jsonObject.has("data")){

			if(jsonObject.get("data") instanceof JSONObject){
				JSONObject data = jsonObject.getJSONObject("data");

				return data.toString();
			}

			if(jsonObject.get("data") instanceof JSONArray){
				JSONArray data = jsonObject.getJSONArray("data");
				return data.toString();
			}

			throw new Exception("Error: The \"data\" key type unknown.");
			
		}
			
	
		throw new Exception("Error: The \"data\" key does not exist in the json.");
	}

	private boolean existsInOPOSErrorTable(String searchId) throws Exception {
		ConnectionProvider conn = new DalConnectionProvider(false);
		PreparedStatement st = null;
		String sql = " SELECT COUNT(oe.OBPOS_Errors_Id) as items FROM OBPOS_Errors oe WHERE jsoninfo LIKE "
				+ "'%"+ searchId +"%'"
				;

		st = conn.getPreparedStatement(sql);
		ResultSet rs = st.executeQuery();
		int count = 0;
		if(rs != null){
			rs.first();
			count = rs.getInt("items");
		}

		rs.close();
		st.close();
		return count > 0 ? true : false;
	}

	private String getIdJSONOrder(String json){
		String regex = "\"id\":\"\\w{32}\"";
		String regexId = "\\b\\w{32}\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(json);
		if(matcher.find()){
			String prevOrderId = matcher.group();
			pattern = Pattern.compile(regexId);
			matcher = pattern.matcher(prevOrderId);
			if(matcher.find()){
				String orderId = matcher.group();
				return orderId;
			}

			return "";
		}

		return "";
	}
	
	@Override
	public void kill(ProcessBundle processBundle) throws Exception {
		// TODO Auto-generated method stub
		OBDal.getInstance().flush();
		this.killProcess = true;

	}
}

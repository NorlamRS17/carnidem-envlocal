package ec.com.sidesoft.dispatchmobile.webservices.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.betwixt.strategy.ConvertUtilsObjectStringConverter;
import org.apache.commons.lang.StringUtils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.common.plm.AttributeValue;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.pricing.pricelist.ProductPrice;
import org.openbravo.service.db.DalConnectionProvider;

import com.google.gson.JsonObject;

import ec.com.sidesoft.crm.visitplan.Scrvro_Route;
import ec.com.sidesoft.crm.visitplan.Scrvro_Visit;

import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.Location;

public class SSDPM_Utility {

  private static final ConnectionProvider connectionProvider = new DalConnectionProvider(false);
  // private static Connection conndb = null;
  private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
   
  static public List<JSONObject> getPartners(String updatedDate, String createdDate)
      throws JSONException {

    List<JSONObject> partners = new ArrayList<JSONObject>();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      Connection conndb = conn.getTransactionConnection();
      String strSql = null;
      strSql = "SELECT  m_pricelist_id,  name2,   p.name,   taxid, l.address1,bl.phone, \n" + 
      		"	   to_char(p.created,'dd-MM-yyyy HH24:MI:SS') as created, to_char(p.updated,'dd-MM-yyyy HH24:MI:SS') as updated, \n" + 
      		"	   p.c_bpartner_id, p.c_bp_group_id, p.em_eei_email, SalesRep_ID, \n" + 
      		"	   bpac.AccountNo as accountno, bt.name as bankname, bl.EM_Spinco_Latitude as latitude, bl.EM_Spinco_Longitude as longitude\n" + 
      		"	  , to_char(coalesce(em_atimdm_fechanac,now()),'yyyy-MM-dd HH24:MI:SS') as dateborn  FROM c_bpartner p\n" + 
      		"	  LEFT JOIN (SELECT c_getbplocationid(c_bpartner_id,'B') as c_bpartner_location_id, c_bpartner_id\n" + 
      		"	  FROM c_bpartner ) pl on pl.c_bpartner_id=p.c_bpartner_id\n" + 
      		"	  LEFT JOIN c_bpartner_location bl on bl.c_bpartner_location_id=pl.c_bpartner_location_id \n" + 
      		"	  LEFT JOIN c_location l on l.c_location_id=bl.c_location_id \n" + 
      		"	  LEFT JOIN C_BP_BankAccount bpac on bpac.c_bpartner_id = p.c_bpartner_id\n" + 
      		"	  LEFT JOIN ssfi_banktransfer bt on bpac.em_ssfi_banktransfer_id = bt.ssfi_banktransfer_id\n" + 
      		"	  WHERE p.isactive='Y'";
      if (updatedDate != null && !updatedDate.isEmpty()) {
        //strSql = strSql + "AND p.updated::date >= '" + updatedDate + "'::date\n";
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        //strSql = strSql + "AND p.created::date >= '" + createdDate + "'::date\n";
      }

      PreparedStatement st = null;

      st = conndb.prepareStatement(strSql+" and SalesRep_ID = 'E70' and m_pricelist_id is not null limit 50");
      ResultSet rsConsulta = st.executeQuery();

      while (rsConsulta.next()) {

        JSONObject partner = new JSONObject();

        partner.put("bpartner_id",
            rsConsulta.getString("c_bpartner_id") != null ? rsConsulta.getString("c_bpartner_id")
                : "");
        partner.put("taxid",
            rsConsulta.getString("taxid") != null ? rsConsulta.getString("taxid") : "");
        partner.put("comercial_name",
            rsConsulta.getString("name2") != null ? rsConsulta.getString("name2") : "");
        partner.put("social_name",
            rsConsulta.getString("name") != null ? rsConsulta.getString("name") : "");
        partner.put("category_id",
            rsConsulta.getString("c_bp_group_id") != null ? rsConsulta.getString("c_bp_group_id")
                : "");
        partner.put("pricelist_id",
            rsConsulta.getString("m_pricelist_id") != null ? rsConsulta.getString("m_pricelist_id")
                : "");
        partner.put("address",
            rsConsulta.getString("address1") != null ? rsConsulta.getString("address1") : "");
        partner.put("phone",
            rsConsulta.getString("phone") != null ? rsConsulta.getString("phone") : "");
        partner.put("email",
            rsConsulta.getString("em_eei_email") != null ? rsConsulta.getString("em_eei_email")
                : "");
        partner.put("map_location_long", "");
        partner.put("map_location_lat", "");
        partner.put("SalesRep_ID",
            rsConsulta.getString("SalesRep_ID") != null ? rsConsulta.getString("SalesRep_ID") : "");
        partner.put("created",
            rsConsulta.getString("created") != null ? rsConsulta.getString("created") : "");
        partner.put("updated",
            rsConsulta.getString("updated") != null ? rsConsulta.getString("updated") : "");
        
        partner.put("latitude",
                rsConsulta.getString("latitude") != null ? rsConsulta.getString("latitude") : "");
        partner.put("longitude",
                rsConsulta.getString("longitude") != null ? rsConsulta.getString("longitude") : "");
        partner.put("accountno",
                rsConsulta.getString("accountno") != null ? rsConsulta.getString("accountno") : "");
        partner.put("bankname",
                rsConsulta.getString("bankname") != null ? rsConsulta.getString("bankname") : "");
        partner.put("dateborn",
                rsConsulta.getString("dateborn") != null ? rsConsulta.getString("dateborn") : "");
        
        partners.add(partner);
      }
      // Close ConnectionProvider
      conndb.close();
      // Close PreparedStatement
      st.close();
      // Close ResultSet
      rsConsulta.close();
    } catch (Exception e) {
      System.out.println("getPartners: " + e.getMessage());
      throw new OBException("getPartners: " + e.getMessage());
    }

    return partners;

  }
 
  static public JSONObject setCoordinates(JsonObject data) throws JSONException {
	  JSONObject result = new JSONObject();
	  BusinessPartner partner = OBDal.getInstance().get(BusinessPartner.class, data.get("partner_id").getAsString());
	  List<Location> locations = partner.getBusinessPartnerLocationList();
	  
	  if(locations.size()>0) {
		  String latitude = data.get("latitude").getAsString();
		  String longitude = data.get("longitude").getAsString();
		  OBContext.setAdminMode(true);
		  Location locations2 = OBDal.getInstance().get(Location.class, locations.get(0).getId());
		  locations2.setSpincoLatitude(latitude);
		  locations2.setSpincoLongitude(longitude);
		  OBDal.getInstance().save(locations2);
		  //OBDal.getInstance().refresh(locations2);
		  OBDal.getInstance().commitAndClose();
		  
	  }
	  result.put("status", "OK");
	  result.put("message", "Correctamente creado");
	  result.put("additional", "");
	  return result;
  }

  static public List<JSONObject> inoutCreate(String strOrderID)
	      throws JSONException {


	    List<JSONObject> jsonCreateInouts = new ArrayList<JSONObject>();
	    //ConnectionProvider conn = new DalConnectionProvider(false);

	    try {
	      //Connection conndb = conn.getTransactionConnection();
	      /*String strSql = null;
	      strSql = "select coalesce((SELECT SSDPM_CREATE_INOUT('" + strOrderID + "') from dual),'') "
	    		  + " into results from dual ";
	 	      
	    */
	    	   strOrderID = strOrderID.replace("'", "");
 
		       org.openbravo.database.ConnectionProvider cn  = new DalConnectionProvider(false);
			   CallableStatement cs = cn.getConnection().prepareCall("{call SSDPM_CREATE_INOUT(?)}");
		  	   cs.setQueryTimeout(30);
			   cs.setString(1, strOrderID);
			   cs.registerOutParameter(1, Types.VARCHAR);
			   cs.execute();
		
			   String result = cs.getString(1); 
			   
			   String resultData[] = result.split(":");
			 
	
		        JSONObject createInout = new JSONObject();
	
		        createInout.put("results",
		        		!resultData[0].toString().equals("0") ? "OK"
		                : "ERROR");
			               
		        jsonCreateInouts.add(createInout);
	 
 
	    } catch (Exception e) {
	      System.out.println("inoutCreate: " + e.getMessage());
	      String strMsg = e.getMessage();
	      String resultData[] = strMsg.split("Where");
	      JSONObject createInout = new JSONObject();
	  	
	        createInout.put("results",
	        		resultData[0].toString().length()>0 ? resultData[0].toString()
	                : "ERROR");
		               
	        jsonCreateInouts.add(createInout);
	     // throw new OBException("inoutCreate: " + resultData[0].toString());

	    }

	    return jsonCreateInouts;

	  }

  static public JSONObject setNewStatusRouteVendor(JsonObject data) throws JSONException {

	  OBContext.setAdminMode(true); 

	  JSONObject result = new JSONObject();
	  
	  String strRouteID = data.get("route_id").getAsString();
	  String strStatus = data.get("status").getAsString();
	  String strStartVisit = data.get("startvisit").getAsString();
	  String strEndVisit = data.get("endvisit").getAsString();
	  String strTotalVisit = data.get("totalvisit").getAsString();
	  
	  java.util.Date dtStartDate = null;
	  java.util.Date dtEndtDate = null;
	  
	  try {
		  dtStartDate = convertStringToDate(strStartVisit);
		  dtEndtDate = convertStringToDate(strEndVisit);
		  
	  }catch(Exception e) {
		  
	  }
	  
	  Scrvro_Route sRoute = OBDal.getInstance().get(Scrvro_Route.class,strRouteID );
	  //List<Location> locations = partner.getBusinessPartnerLocationList();
	  
	  if(sRoute!=null) {
		  sRoute.setStatus(strStatus);
		  OBDal.getInstance().save(sRoute);
		  //OBDal.getInstance().refresh(locations2);
		 // OBDal.getInstance().commitAndClose();
		  
		  
		  
		  Scrvro_Visit visit = OBProvider.getInstance().get(Scrvro_Visit.class);
		  visit.setActive(true);
		  visit.setScrvroRoute(sRoute);
		  visit.set(Scrvro_Visit.PROPERTY_STARTTIMEVISIT, dtStartDate);
		  visit.set(Scrvro_Visit.PROPERTY_ENDTIMEVISIT, dtEndtDate);
		  visit.setDate(dtStartDate);
		  visit.setStatus("L");
		  visit.setTotaltimevisit(strTotalVisit);
		  visit.setLocationLink(sRoute.getLocationLink().toString());
		  visit.setLatitude(sRoute.getLatitude().toString());
		  visit.setLongitude(sRoute.getLongitude().toString());
		  
		  
		  OBDal.getInstance().save(visit);
		  OBDal.getInstance().commitAndClose();

	  }
	  result.put("status", "OK");
	  result.put("message", "Correctamente creado");
	  result.put("additional", "");
	  return result;
  }

  public static java.util.Date convertStringToDate(String strDateString ) throws ParseException {
	  
	  java.util.Date dateVisit=null;
      try {
          Calendar calendar = Calendar.getInstance();
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          calendar.setTime(dateFormat.parse(strDateString));
          java.util.Date date =   calendar.getTime();
          dateVisit= date;
      } catch (ParseException e) {
          System.out.println("Error al analizar la cadena de fecha y hora: " + e.getMessage());
      }
	    return dateVisit;
	} 
}

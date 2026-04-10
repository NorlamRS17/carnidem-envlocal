package ec.com.sidesoft.notifications.mobileandroid.ad_Process;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.xmlEngine.XmlEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ec.com.sidesoft.notifications.mobileandroid.SnmaDevices;
import ec.com.sidesoft.notifications.mobileandroid.SnmaPushNotify;

 
public class CreateNotificationsMobile extends DalBaseProcess {

  public XmlEngine xmlEngine = null;
  public static String strDireccion;
  public String StrCodigoCompra = "";
  public String Stridprov = "";
  public String StrPeriodId = "";
  public Element ventas=null;

  public void doExecute(ProcessBundle bundle) throws Exception {

    final OBError message = new OBError();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    // ConnectionProvider conn = bundle.getConnection();

    org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);
 
    OBContext.setAdminMode(true);

    String Snma_DevicesID = (String) bundle.getParams().get("Snma_Devices_ID");
    
	String strURLFCM="";
	String strServerKEY="";
	String strDeviceID="";
	 String title = "";
     String messageMain = "";
     String messageView = "";
     String notifyJson ="";
     
    OBCriteria<SnmaPushNotify> ObjPushNotityList = OBDal.getInstance()
            .createCriteria(SnmaPushNotify.class);
    ObjPushNotityList.add(Restrictions.eq(SnmaPushNotify.PROPERTY_ACTIVE, true));
    
    List<SnmaPushNotify> lstSetupNotifyMobile =ObjPushNotityList.list();
    
    
        
    // VariablesSecureApp varsAux = bundle.getContext().toVars();
    // HttpServletRequest request = RequestContext.get().getRequest();
    // HttpServletResponse response = RequestContext.get().getResponse();

    try {

      // retrieve the parameters from the bundle
      // Recupera los parametros de la seción
    	 strURLFCM="https://fcm.googleapis.com/fcm/send";
    	strServerKEY="AAAAgYWT8a8:APA91bFQT9m9DP38YQSrQoodvsoHCx93moeWOgiTEiWnWT7D6LKCu7bdJh7GeQ2fJx09YOPOoAOvtaq6QlX_dwQ8YkCG-wWKlP6FauTCbsbGWyjH5AXGscXriv_gYsoacEEFAmqxNc7_";
    	strDeviceID="dKba6XjkRmSkjj7B93FMN0:APA91bFYRCa0BJxxpvJt-T1VdNZZzeMUgn38PF6TnFBwGVMy6j3O6uHTtOmPsN8c_szzFQF1t6TsLgQjlIPGbGeevKMtvWvEiyRJw4fc9qwvw4F-IBM9v6IqygE0i_K-IF_CE9E5_Mvm";
    	title = "My First Notification";
        messageMain = "Hello, I'm push notification";
        messageView = "New push notification";
        notifyJson =  "{\n" + 
         		"  \"to\": \"DEVICEID\",\n" + 
         		"  \"notification\": {\n" + 
         		"    \"body\": \"BODYMAINCHANGE\",\n" + 
         		"    \"OrganizationId\": \"2\",\n" + 
         		"    \"content_available\": true,\n" + 
         		"    \"priority\": \"high\",\n" + 
         		"    \"subtitle\": \"Elementary School\",\n" + 
         		"    \"title\": \"TITLECHANGE\"\n" + 
         		"  },\n" + 
         		"  \"data\": {\n" + 
         		"    \"priority\": \"high\",\n" + 
         		"    \"sound\": \"app_sound.wav\",\n" + 
         		"    \"content_available\": true,\n" + 
         		"    \"bodyText\": \"BODYCHANGE\",\n" + 
         		"    \"organization\": \"Elementary school\"\n" + 
         		"  }\n" + 
         		"}";
      
        if (ObjPushNotityList.list().size()>0) {
        	
        	 strURLFCM= ObjPushNotityList.list().get(0).getURLFcm();
         	strServerKEY= ObjPushNotityList.list().get(0).getServerkey();
         	
            SnmaDevices ObdalsnmaDevice = OBDal.getInstance().get(SnmaDevices.class, Snma_DevicesID);
            
            if (ObdalsnmaDevice!= null) {
	         	
            	strDeviceID=ObdalsnmaDevice.getDevicekey();
            	notifyJson = ObjPushNotityList.list().get(0).getJsonNotify();
            	title = "My First Notification";
	         	messageMain = "Hello, I'm push notification";
	            messageView = "New push notification";
	            
	        	
	        	sendPushNotification(title, messageMain,messageView,notifyJson,strServerKEY,strDeviceID,strURLFCM);
	            
            }

        	message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
        	message.setType("Success");
        	message.setMessage(Utility.messageBD(conn, "Success", language));
        }
      /*
       * } catch (final Exception e) { e.printStackTrace(System.err);
       * 
       * message.setTitle(Utility.messageBD(conn, "Error", language)); message.setType("Error");
       * message.setMessage(e.getMessage() + e.fillInStackTrace());
       */
    } finally {
      bundle.setResult(message);
    }
  }

  protected String formatDate(java.util.Date date) {
    return new SimpleDateFormat((String) OBPropertiesProvider.getInstance().getOpenbravoProperties()
        .get(KernelConstants.DATE_FORMAT_PROPERTY)).format(date);
  }
  private static void sendPushNotification(String title, String messageMain, String messageview, String strTemplateJson,String strServerKey, String strDeviceKey, String strURLFCM) throws Exception {
      String pushMessage = strTemplateJson ;
      
      pushMessage = pushMessage.replace("BODYMAINCHANGE", messageMain);
      pushMessage = pushMessage.replace("BODYCHANGE", messageview);
      pushMessage = pushMessage.replace("TITLECHANGE", title);
      pushMessage = pushMessage.replace("DEVICEID", strDeviceKey);
      // Create connection to send FCM Message request.
      URL url = new URL(strURLFCM);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestProperty("Authorization", "key=" + strServerKey);
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);

      // Send FCM message content.
      OutputStream outputStream = conn.getOutputStream();
      outputStream.write(pushMessage.getBytes());

      System.out.println(conn.getResponseCode());
      System.out.println(conn.getResponseMessage());
  }
 
}

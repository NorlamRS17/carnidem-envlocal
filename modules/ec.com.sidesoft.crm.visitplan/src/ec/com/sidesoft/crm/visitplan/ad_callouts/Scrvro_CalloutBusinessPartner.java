package ec.com.sidesoft.crm.visitplan.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.service.db.DalConnectionProvider;

public class Scrvro_CalloutBusinessPartner extends SimpleCallout {

  /**
   * 
   */
  private static final long serialVersionUID = 12L;

  @SuppressWarnings("null")
@Override
  protected void execute(CalloutInfo info) throws ServletException {
    // TODO Auto-generated method stub

      String strBPartnerID = info.getStringParameter("inpcBpartnerId");
	  String strURL = "https://www.google.com/maps/@";
	  String strZoom = ",19z";
	  BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, strBPartnerID);
	  String strLatitude="ND";
	  String strLongitude="ND";
	  
	  if (bp!=null) {
		  
		  try { 
		  strLatitude = bp.getScrvroLatitude()==null?"ND":bp.getScrvroLatitude() ;
		  }catch (Exception e) {
			// TODO: handle exception
		  }
		  
		  try {
		  strLongitude = bp.getScrvroLongitude()==null?"ND":bp.getScrvroLongitude() ;
		  }catch (Exception e2) {
			// TODO: handle exception
		}
		  
	  }
	  
	  if ((!strLatitude.equals("ND")) && (!strLongitude.equals("ND"))){
		  info.addResult("inplatitude", strLatitude);
		  info.addResult("inplongitude",   strLongitude);
		  String strURLComplete=  strURL + strLatitude + ","+ strLongitude + strZoom;
		  info.addResult("inplocationLink",   strURLComplete);
		  info.addResult("inpstatus",   "P");
	  }else{
		  info.addResult("WARNING", "No tiene definido la ubicación GPS");
		  
	  }
	   
  }

}

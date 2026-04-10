package ec.com.sidesoft.carnidem.production.ad_callouts;

import java.lang.reflect.UndeclaredThrowableException;

import javax.servlet.ServletException;

import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.exception.NoConnectionAvailableException;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.service.db.DalConnectionProvider;
import org.apache.log4j.Logger;

public class GetDocumentNo_Measure extends SimpleCallout{
	private final Logger logger = Logger.getLogger(GetDocumentNo_Measure.class);
	
	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// TODO Auto-generated method stub
		ConnectionProvider conn = new DalConnectionProvider(false);
		String typeDoc = info.getStringParameter("inpemCrprodCDoctypetargetId", null);
		String docNo = info.getStringParameter("inpemCrprodDocumentno", null);
		if(typeDoc != null) {
			try {
				VariablesSecureApp vars = info.vars;
				docNo = Utility.getDocumentNo(conn.getConnection(), conn, vars, "",
						MeasureShift.ENTITY_NAME, typeDoc, typeDoc, false, false);
				if(docNo != null && !docNo.isEmpty()) {
					info.addResult("inpemCrprodDocumentno", docNo);
				}
				
			}catch(Exception e){
				logger.debug(e.getMessage());
			}
		}
		
		
	}

}

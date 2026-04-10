package ec.com.sidesoft.carnidem.production.ad_process;

import org.apache.log4j.Logger;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

public class CompleteDocumentMeasureFPQ extends DalBaseProcess{
	private final Logger logger = Logger.getLogger(CompleteDocumentMeasure.class);

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		OBError msg = new OBError();
		try {
			ConnectionProvider conn = new DalConnectionProvider(false);
			String recordID = (String) bundle.getParams().get("MA_Measure_Shift_ID");
			MeasureShift objMSC = OBDal.getInstance().get(MeasureShift.class, recordID);
			completeMeasureShift(objMSC);
			
			msg.setType("Success");
			msg.setTitle(OBMessageUtils.messageBD("Success"));
			msg.setMessage("Se ha completado la operación con éxito");
		}catch(Exception e) {
			OBDal.getInstance().rollbackAndClose();
			logger.debug(e.getMessage() + e);
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage("No se logró completar la operación. "+e.getMessage());
		}finally {
			bundle.setResult(msg);
		}
	}
	
	public void completeMeasureShift(MeasureShift objMSC) {
		objMSC.setSsfdcStatus("CP");
		objMSC.setSsfdcCompleted(true);
		OBDal.getInstance().save(objMSC);
		OBDal.getInstance().flush();
	}
	
}


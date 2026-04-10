package ec.com.sidesoft.mrp.ad_callouts;

import javax.servlet.ServletException;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.hibernate.criterion.Restrictions;
import org.openbravo.model.mrp.PurchasingRun;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ssmrp_calculateDate extends SimpleCallout {

    @Override
    protected void execute(CalloutInfo info) throws ServletException {
    	
        String docDateStr = info.getStringParameter("inpdatedoc");
//        String dateUntilStr = info.getStringParameter("inmepSsmrpDateDocument");
        String dateUntilStr = info.getStringParameter("inpemSsmrpDateDocument");


       Date docDate = convertStringToDate(docDateStr);
        Date dateUntil = convertStringToDate(dateUntilStr);

        // Calcular la diferencia en días entre las fechas
        long dias = diasEntreDosFechas(docDate, dateUntil);
        if(dias > 0) {
        	info.addResult("inpemScmfHistorydays", dias );
        }
    }
    
    private Date convertStringToDate(String dateString) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
   
        } catch (ParseException e) {
            throw new OBException("Error al convertir la cadena a fecha: " + dateString);
        }
    }

    private long diasEntreDosFechas(Date docDate, Date dateUntil) {
        long startTime = docDate.getTime();
        long endTime = dateUntil.getTime();
        long diasDesde = (long) Math.floor(startTime / (1000*60*60*24)); // convertimos a días, para que no afecten cambios de hora 
        long diasHasta = (long) Math.floor(endTime / (1000*60*60*24)); // convertimos a días, para que no afecten cambios de hora
        long dias = diasHasta - diasDesde;
        return dias;
    }

    private PurchasingRun getPurchasingRun(Date docDate, Date dateUntil) {
        OBCriteria<PurchasingRun> criteria = OBDal.getInstance().createCriteria(PurchasingRun.class);
        criteria.add(Restrictions.ge(PurchasingRun.PROPERTY_DOCUMENTDATE, docDate));
        criteria.add(Restrictions.lt(PurchasingRun.PROPERTY_SSMRPDATEDOCUMENT, dateUntil));
        PurchasingRun prun = (PurchasingRun) criteria.uniqueResult();
        	if(prun != null) {
        		 return prun;
        	}else {
        		return null;
        	}
       
    }
}

package ec.com.sidesoft.sanfelipe.customizations.ad_backgrounds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;

public class ssfc_DelRecErrorsTPV extends DalBaseProcess implements KillableProcess {
    private final Logger logger = Logger.getLogger(ssfc_DelRecErrorsTPV.class);
    private boolean killProcess = false;

    @Override
    public void doExecute(ProcessBundle bundle) throws Exception {
        OBContext.setAdminMode(true);
        try {
            ConnectionProvider conn = new DalConnectionProvider(false);
            deleteOrderstatusY(conn);
            OBDal.getInstance().commitAndClose();
        } catch (final Exception e) {
            OBDal.getInstance().rollbackAndClose();
            logger.error("Exception found deleting record which Status is imported successfully: ", e);
            Throwable throwable = DbUtility.getUnderlyingSQLException(e);
            String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
        } finally {
            OBContext.setAdminMode(false);
        }
    }

    private void deleteOrderstatusY(ConnectionProvider conn) throws Exception {
    	PreparedStatement st = null;
         try {
             String sql = "SELECT OBPOS_Errors_id FROM public.OBPOS_Errors WHERE Orderstatus = 'Y'";
             st = conn.getPreparedStatement(sql);
             ResultSet rs = st.executeQuery();
             while (rs.next() && !killProcess) {
                 String errorsId = rs.getString("OBPOS_Errors_id");
                 sql = "DELETE FROM public.OBPOS_Errors WHERE OBPOS_Errors_id = ? AND Orderstatus = 'Y'";
                 PreparedStatement updateSt = conn.getPreparedStatement(sql);
                 updateSt.setString(1, errorsId);
                 updateSt.executeUpdate();
                 conn.releasePreparedStatement(updateSt);
             }
         } catch (Exception e) {
            logger.error("Exception found deleting records with status Y: ", e);
            Throwable throwable = DbUtility.getUnderlyingSQLException(e);
            String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
        } finally {
            conn.releasePreparedStatement(st);
        }
    }

    @Override
    public void kill(ProcessBundle processBundle) throws Exception {
        OBDal.getInstance().flush();
        this.killProcess = true;
    }
}
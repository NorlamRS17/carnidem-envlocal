package com.sidesoft.hrm.payroll.ad_process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
//import org.openbravo.base.model.Table;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.ad.ui.Window;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.utils.Replace;

import com.sidesoft.hrm.payroll.sspr_settlement;
import com.sidesoft.hrm.payroll.ssprpayrollaut;

import ec.com.sidesoft.custom.reports.SescrTemplateReport;

public class Sspr_AutomaticPayroll extends DalBaseProcess{
	private final Logger log4j = Logger.getLogger(Sspr_AutomaticPayroll.class);
@Override
public void doExecute(ProcessBundle bundle) throws Exception {
	OBError msg = new OBError();
	msg.setType("Success");
	msg.setTitle(OBMessageUtils.messageBD("@Success@"));
	final String recordId = (String) bundle.getParams().get("Sspr_Payroll_Aut_ID");
	
	try {
		OBContext.setAdminMode(true);
		
		ssprpayrollaut aut_py = OBDal.getInstance().get(ssprpayrollaut.class, recordId);
		if(!aut_py.isProcessNow()) {
			aut_py.setProcessNow(true);
			RejectFcrCW(recordId, null);
		}
		OBDal.getInstance().refresh(aut_py);	
		OBDal.getInstance().flush();
		
		
		
	}catch (final Exception e) {
		OBDal.getInstance().rollbackAndClose();
		log4j.error("Exception found in ssprpayrollaut process: ", e);
		Throwable exception = DbUtility.getUnderlyingSQLException(e);
		String message = OBMessageUtils.translateError(exception.getMessage()).getMessage();			
		msg.setType("Error");
		msg.setTitle(OBMessageUtils.messageBD("Error"));
		msg.setMessage(message);
	} finally {
		bundle.setResult(msg);
		OBContext.restorePreviousMode();
	}
	
}

public void RejectFcrCW(String recordId, Map<String, Object> params) {
	org.openbravo.model.ad.ui.Process process = OBDal.getInstance().get(org.openbravo.model.ad.ui.Process.class,
			"FA58C3F1685A4C929EF47750A56E925B");

	final ProcessInstance pInstance = CallProcess.getInstance().callProcess(process, recordId, params);

	OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
	String msg = oberror.getMessage();
	if (pInstance.getResult() == 0) {
		throw new OBException(msg);
	}

}

}
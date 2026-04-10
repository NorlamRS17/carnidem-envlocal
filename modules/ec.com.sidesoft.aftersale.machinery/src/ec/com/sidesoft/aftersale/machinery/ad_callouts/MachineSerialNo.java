/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2001-2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.aftersale.machinery.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;

public class MachineSerialNo extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// Parameters
		String inpProjectPhaseId = info.getStringParameter("inpcProjectphaseId");
		String inpSeqNo = info.getStringParameter("inpseqno");

		ProjectPhase projectPhase = OBDal.getInstance().get(ProjectPhase.class, inpProjectPhaseId);
		if (projectPhase.getSproctmPrhasetype() != null && projectPhase.getSproctmPrhasetype().equals("E")) {
			Project project = projectPhase.getProject();
			info.addResult("inpemSatmacChassisNumber",
					project.getSearchKey() + "-" + projectPhase.getSequenceNumber() + "-" + inpSeqNo);
		}
	}
}

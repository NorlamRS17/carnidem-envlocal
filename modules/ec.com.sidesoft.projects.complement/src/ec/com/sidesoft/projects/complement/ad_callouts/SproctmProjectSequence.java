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
 * All portions are Copyright (C) 2009-2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.projects.complement.ad_callouts;

import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.Organization;

public class SproctmProjectSequence extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		String fieldChanged = info.getLastFieldChanged();
		log4j.debug("CHANGED: " + fieldChanged);

		// Parameters
		String projectTypeID = info.getStringParameter("inpcProjecttypeId", IsIDFilter.instance);
		String orgId = info.getStringParameter("inpadOrgId", IsIDFilter.instance);
		String windowId = info.getWindowId();

		Organization org = OBDal.getInstance().get(Organization.class, orgId);
		Organization baseOrg = OBDal.getInstance().get(Organization.class, "0");
		OBCriteria<Sequence> sequenceQuery = OBDal.getInstance().createCriteria(Sequence.class);
		sequenceQuery.add(Restrictions.eq(Sequence.PROPERTY_SPROCTMPROJECTSEQ, true));
		sequenceQuery.add(Restrictions.or(Restrictions.eq(Sequence.PROPERTY_ORGANIZATION, org),
				Restrictions.eq(Sequence.PROPERTY_ORGANIZATION, baseOrg)));
		sequenceQuery.addOrder(Order.desc(Sequence.PROPERTY_ORGANIZATION));
		List<Sequence> sequenceList = sequenceQuery.list();
		if (sequenceList.size() > 0) {
			Sequence sequence = sequenceList.get(0);
			String currentSequence = "";
			if (sequence.getPrefix() != null) {
				currentSequence += sequence.getPrefix().trim();
			}
			currentSequence += sequence.getNextAssignedNumber();
			info.addResult("inpvalue", "<" + currentSequence + ">");
		}

		if (StringUtils.isNotEmpty(projectTypeID)) {
			ComboTableData comboTableData = null;
			boolean isRelatedProjectType = false;
			FieldProvider[] data = null;
			try {
				comboTableData = new ComboTableData(info.vars, this, "19", "C_ProjectType_ID", "", "",
						Utility.getReferenceableOrg(info.vars, orgId),
						Utility.getContext(this, info.vars, "#User_Client", windowId), 0);
				comboTableData.fillParameters(null, windowId, "");
				data = comboTableData.select(false);
			} catch (Exception ex) {
				throw new ServletException(ex);
			}
			if (data != null && data.length > 0) {
				for (FieldProvider fp : data) {
					if (StringUtils.equalsIgnoreCase(fp.getField("ID").trim(), projectTypeID)) {
						isRelatedProjectType = true;
						break;
					}
				}
			}
			if (!isRelatedProjectType && StringUtils.equals(windowId, "130")) {
//				info.showMessage(Utility.messageBD(this, "ProjectTypeNull", info.vars.getLanguage()));
				info.addResult("ERROR", Utility.messageBD(this, "ProjectTypeNull", info.vars.getLanguage()));
			}
		}
	}
}
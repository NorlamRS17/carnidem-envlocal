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
 * All portions are Copyright (C) 2008-2012 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.customizations.ecuapack.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class Scmecu_ProbabilityStage extends SimpleCallout {
	private static final long serialVersionUID = 1L;

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		String inpadOrgId = info.getStringParameter("inpadOrgId", null);
		String inpsalesStage = info.getStringParameter("inpsalesStage", null);

		OBCriteria<ec.com.sidesoft.customizations.ecuapack.Scmecu_ProbabilityStage> qProbabilityStage = OBDal
				.getInstance().createCriteria(ec.com.sidesoft.customizations.ecuapack.Scmecu_ProbabilityStage.class);
		qProbabilityStage.add(Restrictions.eq(
				ec.com.sidesoft.customizations.ecuapack.Scmecu_ProbabilityStage.PROPERTY_SALESSTAGE, inpsalesStage));
		ec.com.sidesoft.customizations.ecuapack.Scmecu_ProbabilityStage probabilityStage = null;
		if(qProbabilityStage.list().size() > 0) {
			probabilityStage = qProbabilityStage.list().get(0);
		}
		
		if (probabilityStage != null) {
			info.addResult("inpprobability", probabilityStage.getProbability());
		} else {
			info.addResult("inpprobability", new BigDecimal("0"));
		}
	}
}

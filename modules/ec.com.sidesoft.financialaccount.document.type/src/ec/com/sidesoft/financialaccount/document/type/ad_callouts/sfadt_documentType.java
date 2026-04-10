package ec.com.sidesoft.financialaccount.document.type.ad_callouts;

import javax.servlet.ServletException;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.enterprise.DocumentType;

public class sfadt_documentType extends SimpleCallout {
	

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// info->vars->httpRequest->parameters
		String docTypeId = info.getStringParameter("inpemSfadtCDoctypeId", null);
		DocumentType docObj = OBDal.getInstance().get(DocumentType.class, docTypeId);
		if (docObj.getDocumentSequence() != null) {
		Sequence seq = docObj.getDocumentSequence();
		info.addResult("inpemSfadtDocumentno", "<" + (seq.getPrefix() != null ? seq.getPrefix() : "")
				+ seq.getNextAssignedNumber().toString() + 
				(seq.getSuffix() != null ? seq.getSuffix() : "") + ">");
		}
		
  }
}

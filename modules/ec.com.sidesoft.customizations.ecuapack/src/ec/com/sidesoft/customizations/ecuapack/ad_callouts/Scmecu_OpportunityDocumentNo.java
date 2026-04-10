package ec.com.sidesoft.customizations.ecuapack.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class Scmecu_OpportunityDocumentNo extends SimpleCallout {
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String inpemScmecuDoctypeId = info.getStringParameter("inpemScmecuDoctypeId", null);
    DocumentType docType = OBDal.getInstance().get(DocumentType.class, inpemScmecuDoctypeId);
    if (docType != null && docType.getDocumentSequence() != null) {
      Sequence seq = docType.getDocumentSequence();
      info.addResult("inpemScmecuDocumentno",
          "<" + (seq.getPrefix() != null ? seq.getPrefix() : "")
              + seq.getNextAssignedNumber().toString()
              + (seq.getSuffix() != null ? seq.getSuffix() : "") + ">");
    }
  }
}

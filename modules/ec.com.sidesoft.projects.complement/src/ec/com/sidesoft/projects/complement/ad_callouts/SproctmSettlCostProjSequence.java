package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class SproctmSettlCostProjSequence extends SimpleCallout {
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String docTypeId = info.getStringParameter("inpcDoctypeId", null);
    DocumentType docObj = OBDal.getInstance().get(DocumentType.class, docTypeId);
    if (docObj.getDocumentSequence() != null) {
      Sequence seq = docObj.getDocumentSequence();
      String documentNo = seq.getNextAssignedNumber().toString();
      info.addResult("inpdocumentno", documentNo);
    }
  }

}

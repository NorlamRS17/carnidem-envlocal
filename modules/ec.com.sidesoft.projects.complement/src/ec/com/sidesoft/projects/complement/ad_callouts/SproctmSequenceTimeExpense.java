package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class SproctmSequenceTimeExpense extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String docTypeId = info.getStringParameter("inpemSproctmCDoctypeId", null);
    DocumentType docObj = OBDal.getInstance().get(DocumentType.class, docTypeId);
    if (docObj != null) {
      if (docObj.getDocumentSequence() != null) {
        Sequence seq = docObj.getDocumentSequence();
        String documentNo = seq.getNextAssignedNumber().toString();
        info.addResult("inpdocumentno", documentNo);
      }
    }
  }

}

package ec.com.sidesoft.carnidem.crm.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class sscces_NewSequence extends SimpleCallout{

	private static final long serialVersionUID = 1L;	
	@Override
	  protected void execute(CalloutInfo info) throws ServletException {

	    // Obtener el ID del tipo de documento desde el formulario
	    String docTypeId = info.getStringParameter("inpemSsccesCDoctypetargetId", null);

	    if (docTypeId == null || docTypeId.isEmpty()) {
	      info.addResult("inpemSsccesDocumentno", "");
	      return;
	    }

	    // Buscar el tipo de documento
	    DocumentType docType = OBDal.getInstance().get(DocumentType.class, docTypeId);

	    if (docType != null && docType.getDocumentSequence() != null) {
	      Sequence seq = docType.getDocumentSequence();

	      // Armar el número formateado (sin consumir aún)
	      String documentNoPreview = "<" +
	        (seq.getPrefix() != null ? seq.getPrefix() : "") +
	        seq.getNextAssignedNumber() +
	        (seq.getSuffix() != null ? seq.getSuffix() : "") +
	        ">";

	      // Devolver el número al campo del formulario
	      info.addResult("inpemSsccesDocumentno", documentNoPreview);
	    } else {
	      info.addResult("inpemSsccesDocumentno", "");
	    }
	  }
	}
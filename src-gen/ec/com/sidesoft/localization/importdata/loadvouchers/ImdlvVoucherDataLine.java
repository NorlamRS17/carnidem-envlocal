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
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package ec.com.sidesoft.localization.importdata.loadvouchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity imdlv_voucherpurchline (stored in table imdlv_voucherpurchline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ImdlvVoucherDataLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "imdlv_voucherpurchline";
    public static final String ENTITY_NAME = "imdlv_voucherpurchline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_IMDLVVOUCHERPURCHASE = "imdlvVoucherPurchase";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DATEEMISION = "dateemision";
    public static final String PROPERTY_TAXID = "taxid";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DOCUMENTTYPE = "documenttype";
    public static final String PROPERTY_INVOICENO = "invoiceno";
    public static final String PROPERTY_SUBDOCUMENTTYPE = "subdocumenttype";
    public static final String PROPERTY_DOCUMENTAFFECTED = "documentaffected";
    public static final String PROPERTY_SUBTOTAL = "subtotal";
    public static final String PROPERTY_VAT = "vat";
    public static final String PROPERTY_TOTALINVOICE = "totalinvoice";
    public static final String PROPERTY_KEYACESS = "keyacess";
    public static final String PROPERTY_AUTHORIZATIONNO = "authorizationno";
    public static final String PROPERTY_DATEAUTHORIZATION = "dateauthorization";
    public static final String PROPERTY_STATUSINVOICE = "statusinvoice";
    public static final String PROPERTY_REFERENCEINVOICE = "referenceinvoice";
    public static final String PROPERTY_STATUSEMAIL = "statusemail";
    public static final String PROPERTY_EMAILS = "emails";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISPROCESS = "isprocess";
    public static final String PROPERTY_LOGSERROR = "logserror";
    public static final String PROPERTY_XMLSRI = "xMLSri";
    public static final String PROPERTY_ISCREATEORDER = "iscreateorder";
    public static final String PROPERTY_ISCREATEINVOICE = "iscreateinvoice";
    public static final String PROPERTY_LINEAMTVAT = "lineamtvat";
    public static final String PROPERTY_VATAMT = "vatamt";
    public static final String PROPERTY_AMOUNTRENTLINE = "amountRentLine";
    public static final String PROPERTY_WITHHRENT = "withhrent";
    public static final String PROPERTY_CODE = "code";
    public static final String PROPERTY_CODEPERCENTAGEWITHHOLDING = "codePercentageWithholding";
    public static final String PROPERTY_CODETAX = "codeTax";
    public static final String PROPERTY_NUMDOCSUSTENTO = "numdocsustento";
    public static final String PROPERTY_DATEEMISSION2 = "dateEmission2";
    public static final String PROPERTY_TIPAMT = "tipamt";
    public static final String PROPERTY_ICEAMT = "iceamt";
    public static final String PROPERTY_SUBTOTALNOTVAT = "subtotalnotvat";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";

    public ImdlvVoucherDataLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUBTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_VAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALINVOICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISPROCESS, false);
        setDefaultValue(PROPERTY_ISCREATEORDER, false);
        setDefaultValue(PROPERTY_ISCREATEINVOICE, false);
        setDefaultValue(PROPERTY_LINEAMTVAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public ImdlvVoucherData getImdlvVoucherPurchase() {
        return (ImdlvVoucherData) get(PROPERTY_IMDLVVOUCHERPURCHASE);
    }

    public void setImdlvVoucherPurchase(ImdlvVoucherData imdlvVoucherPurchase) {
        set(PROPERTY_IMDLVVOUCHERPURCHASE, imdlvVoucherPurchase);
    }

    public BigDecimal getLine() {
        return (BigDecimal) get(PROPERTY_LINE);
    }

    public void setLine(BigDecimal line) {
        set(PROPERTY_LINE, line);
    }

    public Date getDateemision() {
        return (Date) get(PROPERTY_DATEEMISION);
    }

    public void setDateemision(Date dateemision) {
        set(PROPERTY_DATEEMISION, dateemision);
    }

    public String getTaxid() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxid(String taxid) {
        set(PROPERTY_TAXID, taxid);
    }

    public String getBpartner() {
        return (String) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(String bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getDocumenttype() {
        return (String) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumenttype(String documenttype) {
        set(PROPERTY_DOCUMENTTYPE, documenttype);
    }

    public String getInvoiceno() {
        return (String) get(PROPERTY_INVOICENO);
    }

    public void setInvoiceno(String invoiceno) {
        set(PROPERTY_INVOICENO, invoiceno);
    }

    public String getSubdocumenttype() {
        return (String) get(PROPERTY_SUBDOCUMENTTYPE);
    }

    public void setSubdocumenttype(String subdocumenttype) {
        set(PROPERTY_SUBDOCUMENTTYPE, subdocumenttype);
    }

    public String getDocumentaffected() {
        return (String) get(PROPERTY_DOCUMENTAFFECTED);
    }

    public void setDocumentaffected(String documentaffected) {
        set(PROPERTY_DOCUMENTAFFECTED, documentaffected);
    }

    public BigDecimal getSubtotal() {
        return (BigDecimal) get(PROPERTY_SUBTOTAL);
    }

    public void setSubtotal(BigDecimal subtotal) {
        set(PROPERTY_SUBTOTAL, subtotal);
    }

    public BigDecimal getVat() {
        return (BigDecimal) get(PROPERTY_VAT);
    }

    public void setVat(BigDecimal vat) {
        set(PROPERTY_VAT, vat);
    }

    public BigDecimal getTotalinvoice() {
        return (BigDecimal) get(PROPERTY_TOTALINVOICE);
    }

    public void setTotalinvoice(BigDecimal totalinvoice) {
        set(PROPERTY_TOTALINVOICE, totalinvoice);
    }

    public String getKeyacess() {
        return (String) get(PROPERTY_KEYACESS);
    }

    public void setKeyacess(String keyacess) {
        set(PROPERTY_KEYACESS, keyacess);
    }

    public String getAuthorizationno() {
        return (String) get(PROPERTY_AUTHORIZATIONNO);
    }

    public void setAuthorizationno(String authorizationno) {
        set(PROPERTY_AUTHORIZATIONNO, authorizationno);
    }

    public Date getDateauthorization() {
        return (Date) get(PROPERTY_DATEAUTHORIZATION);
    }

    public void setDateauthorization(Date dateauthorization) {
        set(PROPERTY_DATEAUTHORIZATION, dateauthorization);
    }

    public String getStatusinvoice() {
        return (String) get(PROPERTY_STATUSINVOICE);
    }

    public void setStatusinvoice(String statusinvoice) {
        set(PROPERTY_STATUSINVOICE, statusinvoice);
    }

    public String getReferenceinvoice() {
        return (String) get(PROPERTY_REFERENCEINVOICE);
    }

    public void setReferenceinvoice(String referenceinvoice) {
        set(PROPERTY_REFERENCEINVOICE, referenceinvoice);
    }

    public String getStatusemail() {
        return (String) get(PROPERTY_STATUSEMAIL);
    }

    public void setStatusemail(String statusemail) {
        set(PROPERTY_STATUSEMAIL, statusemail);
    }

    public String getEmails() {
        return (String) get(PROPERTY_EMAILS);
    }

    public void setEmails(String emails) {
        set(PROPERTY_EMAILS, emails);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_ISPROCESS);
    }

    public void setProcess(Boolean isprocess) {
        set(PROPERTY_ISPROCESS, isprocess);
    }

    public String getLogserror() {
        return (String) get(PROPERTY_LOGSERROR);
    }

    public void setLogserror(String logserror) {
        set(PROPERTY_LOGSERROR, logserror);
    }

    public String getXMLSri() {
        return (String) get(PROPERTY_XMLSRI);
    }

    public void setXMLSri(String xMLSri) {
        set(PROPERTY_XMLSRI, xMLSri);
    }

    public Boolean isCreateorder() {
        return (Boolean) get(PROPERTY_ISCREATEORDER);
    }

    public void setCreateorder(Boolean iscreateorder) {
        set(PROPERTY_ISCREATEORDER, iscreateorder);
    }

    public Boolean isCreateinvoice() {
        return (Boolean) get(PROPERTY_ISCREATEINVOICE);
    }

    public void setCreateinvoice(Boolean iscreateinvoice) {
        set(PROPERTY_ISCREATEINVOICE, iscreateinvoice);
    }

    public BigDecimal getLineamtvat() {
        return (BigDecimal) get(PROPERTY_LINEAMTVAT);
    }

    public void setLineamtvat(BigDecimal lineamtvat) {
        set(PROPERTY_LINEAMTVAT, lineamtvat);
    }

    public BigDecimal getVatamt() {
        return (BigDecimal) get(PROPERTY_VATAMT);
    }

    public void setVatamt(BigDecimal vatamt) {
        set(PROPERTY_VATAMT, vatamt);
    }

    public BigDecimal getAmountRentLine() {
        return (BigDecimal) get(PROPERTY_AMOUNTRENTLINE);
    }

    public void setAmountRentLine(BigDecimal amountRentLine) {
        set(PROPERTY_AMOUNTRENTLINE, amountRentLine);
    }

    public BigDecimal getWithhrent() {
        return (BigDecimal) get(PROPERTY_WITHHRENT);
    }

    public void setWithhrent(BigDecimal withhrent) {
        set(PROPERTY_WITHHRENT, withhrent);
    }

    public String getCode() {
        return (String) get(PROPERTY_CODE);
    }

    public void setCode(String code) {
        set(PROPERTY_CODE, code);
    }

    public String getCodePercentageWithholding() {
        return (String) get(PROPERTY_CODEPERCENTAGEWITHHOLDING);
    }

    public void setCodePercentageWithholding(String codePercentageWithholding) {
        set(PROPERTY_CODEPERCENTAGEWITHHOLDING, codePercentageWithholding);
    }

    public Long getCodeTax() {
        return (Long) get(PROPERTY_CODETAX);
    }

    public void setCodeTax(Long codeTax) {
        set(PROPERTY_CODETAX, codeTax);
    }

    public String getNumdocsustento() {
        return (String) get(PROPERTY_NUMDOCSUSTENTO);
    }

    public void setNumdocsustento(String numdocsustento) {
        set(PROPERTY_NUMDOCSUSTENTO, numdocsustento);
    }

    public Date getDateEmission2() {
        return (Date) get(PROPERTY_DATEEMISSION2);
    }

    public void setDateEmission2(Date dateEmission2) {
        set(PROPERTY_DATEEMISSION2, dateEmission2);
    }

    public BigDecimal getTipamt() {
        return (BigDecimal) get(PROPERTY_TIPAMT);
    }

    public void setTipamt(BigDecimal tipamt) {
        set(PROPERTY_TIPAMT, tipamt);
    }

    public BigDecimal getIceamt() {
        return (BigDecimal) get(PROPERTY_ICEAMT);
    }

    public void setIceamt(BigDecimal iceamt) {
        set(PROPERTY_ICEAMT, iceamt);
    }

    public BigDecimal getSubtotalnotvat() {
        return (BigDecimal) get(PROPERTY_SUBTOTALNOTVAT);
    }

    public void setSubtotalnotvat(BigDecimal subtotalnotvat) {
        set(PROPERTY_SUBTOTALNOTVAT, subtotalnotvat);
    }

    @SuppressWarnings("unchecked")
    public List<Imdlv_Lines> getImdlvLinesList() {
      return (List<Imdlv_Lines>) get(PROPERTY_IMDLVLINESLIST);
    }

    public void setImdlvLinesList(List<Imdlv_Lines> imdlvLinesList) {
        set(PROPERTY_IMDLVLINESLIST, imdlvLinesList);
    }

}

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
package ec.com.sidesoft.daily.closing.charge;

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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity sdcc_daily_clossing (stored in table sdcc_daily_clossing).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SdccDailyClossing extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sdcc_daily_clossing";
    public static final String ENTITY_NAME = "sdcc_daily_clossing";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_GENERATEDCREDIT = "generatedCredit";
    public static final String PROPERTY_USEDCREDIT = "usedCredit";
    public static final String PROPERTY_WRITEOFFAMOUNT = "writeoffAmount";
    public static final String PROPERTY_EXECUTEPAYMENT = "executepayment";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_VALUEFROM = "valuefrom";
    public static final String PROPERTY_VALUETO = "valueto";
    public static final String PROPERTY_GLITEM = "gLItem";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_DOCTYPEPAYMENT = "doctypePayment";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_READYTOPROCESS = "readytoprocess";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_SDCCDAILYCLOSSINGPAYMENTLIST = "sdccDailyClossingPaymentList";
    public static final String PROPERTY_SDCCDAILYCLOSSINGLINELIST = "sdccDailyClossinglineList";

    public SdccDailyClossing() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_GENERATEDCREDIT, (long) 0);
        setDefaultValue(PROPERTY_USEDCREDIT, (long) 0);
        setDefaultValue(PROPERTY_WRITEOFFAMOUNT, (long) 0);
        setDefaultValue(PROPERTY_EXECUTEPAYMENT, "LL");
        setDefaultValue(PROPERTY_VALUEFROM, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALUETO, new BigDecimal(0));
        setDefaultValue(PROPERTY_READYTOPROCESS, "N");
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGLINELIST, new ArrayList<Object>());
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public Long getGeneratedCredit() {
        return (Long) get(PROPERTY_GENERATEDCREDIT);
    }

    public void setGeneratedCredit(Long generatedCredit) {
        set(PROPERTY_GENERATEDCREDIT, generatedCredit);
    }

    public Long getUsedCredit() {
        return (Long) get(PROPERTY_USEDCREDIT);
    }

    public void setUsedCredit(Long usedCredit) {
        set(PROPERTY_USEDCREDIT, usedCredit);
    }

    public Long getWriteoffAmount() {
        return (Long) get(PROPERTY_WRITEOFFAMOUNT);
    }

    public void setWriteoffAmount(Long writeoffAmount) {
        set(PROPERTY_WRITEOFFAMOUNT, writeoffAmount);
    }

    public String getExecutepayment() {
        return (String) get(PROPERTY_EXECUTEPAYMENT);
    }

    public void setExecutepayment(String executepayment) {
        set(PROPERTY_EXECUTEPAYMENT, executepayment);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public BigDecimal getValuefrom() {
        return (BigDecimal) get(PROPERTY_VALUEFROM);
    }

    public void setValuefrom(BigDecimal valuefrom) {
        set(PROPERTY_VALUEFROM, valuefrom);
    }

    public BigDecimal getValueto() {
        return (BigDecimal) get(PROPERTY_VALUETO);
    }

    public void setValueto(BigDecimal valueto) {
        set(PROPERTY_VALUETO, valueto);
    }

    public GLItem getGLItem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGLItem(GLItem gLItem) {
        set(PROPERTY_GLITEM, gLItem);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public DocumentType getDoctypePayment() {
        return (DocumentType) get(PROPERTY_DOCTYPEPAYMENT);
    }

    public void setDoctypePayment(DocumentType doctypePayment) {
        set(PROPERTY_DOCTYPEPAYMENT, doctypePayment);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public String getReadytoprocess() {
        return (String) get(PROPERTY_READYTOPROCESS);
    }

    public void setReadytoprocess(String readytoprocess) {
        set(PROPERTY_READYTOPROCESS, readytoprocess);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    @SuppressWarnings("unchecked")
    public List<SdccDailyClossingPayment> getSdccDailyClossingPaymentList() {
      return (List<SdccDailyClossingPayment>) get(PROPERTY_SDCCDAILYCLOSSINGPAYMENTLIST);
    }

    public void setSdccDailyClossingPaymentList(List<SdccDailyClossingPayment> sdccDailyClossingPaymentList) {
        set(PROPERTY_SDCCDAILYCLOSSINGPAYMENTLIST, sdccDailyClossingPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<Sdcc_DailyClossingLine> getSdccDailyClossinglineList() {
      return (List<Sdcc_DailyClossingLine>) get(PROPERTY_SDCCDAILYCLOSSINGLINELIST);
    }

    public void setSdccDailyClossinglineList(List<Sdcc_DailyClossingLine> sdccDailyClossinglineList) {
        set(PROPERTY_SDCCDAILYCLOSSINGLINELIST, sdccDailyClossinglineList);
    }

}

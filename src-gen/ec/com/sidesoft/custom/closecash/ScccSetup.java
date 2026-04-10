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
package ec.com.sidesoft.custom.closecash;

import ec.com.sidesoft.closecash.financial.account.SscccfaFinAccConcept;
import ec.com.sidesoft.closecash.indumot.SscccinInvoiceDoctype;
import ec.com.sidesoft.closecash.sales.order.SsccsoAccountingConcept;
import ec.com.sidesoft.closecash.sales.order.SsccsoTypeOfDocument;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
/**
 * Entity class for entity Sccc_Setup (stored in table sccc_setup).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScccSetup extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sccc_setup";
    public static final String ENTITY_NAME = "Sccc_Setup";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_DOCTYPESALES = "doctypeSales";
    public static final String PROPERTY_DOCTYPECREDITNOTES = "doctypeCreditNotes";
    public static final String PROPERTY_SSCCCINMAXIMUMDIFFERENCE = "sscccinMaximumdifference";
    public static final String PROPERTY_DOCTYPEREVERSED = "doctypeReversed";
    public static final String PROPERTY_BLIND = "blind";
    public static final String PROPERTY_PAYMENTSTODATE = "paymentstodate";
    public static final String PROPERTY_SCCCCASHCLOSURELIST = "scccCashClosureList";
    public static final String PROPERTY_SCCCPAYMENTMETHODLIST = "scccPaymentMethodList";
    public static final String PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST = "ssccsoAccountingConceptList";
    public static final String PROPERTY_SSCCSOTYPEOFDOCUMENTLIST = "ssccsoTypeOfDocumentList";
    public static final String PROPERTY_SCCCUSERLIST = "scccUserList";
    public static final String PROPERTY_SSCCCFAFINACCCONCEPTLIST = "sscccfaFinAccConceptList";
    public static final String PROPERTY_SSCCCININVOICEDOCTYPELIST = "sscccinInvoiceDoctypeList";

    public ScccSetup() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BLIND, false);
        setDefaultValue(PROPERTY_PAYMENTSTODATE, false);
        setDefaultValue(PROPERTY_SCCCCASHCLOSURELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCPAYMENTMETHODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOTYPEOFDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCCFAFINACCCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCCININVOICEDOCTYPELIST, new ArrayList<Object>());
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

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public DocumentType getDoctypeSales() {
        return (DocumentType) get(PROPERTY_DOCTYPESALES);
    }

    public void setDoctypeSales(DocumentType doctypeSales) {
        set(PROPERTY_DOCTYPESALES, doctypeSales);
    }

    public DocumentType getDoctypeCreditNotes() {
        return (DocumentType) get(PROPERTY_DOCTYPECREDITNOTES);
    }

    public void setDoctypeCreditNotes(DocumentType doctypeCreditNotes) {
        set(PROPERTY_DOCTYPECREDITNOTES, doctypeCreditNotes);
    }

    public BigDecimal getSscccinMaximumdifference() {
        return (BigDecimal) get(PROPERTY_SSCCCINMAXIMUMDIFFERENCE);
    }

    public void setSscccinMaximumdifference(BigDecimal sscccinMaximumdifference) {
        set(PROPERTY_SSCCCINMAXIMUMDIFFERENCE, sscccinMaximumdifference);
    }

    public DocumentType getDoctypeReversed() {
        return (DocumentType) get(PROPERTY_DOCTYPEREVERSED);
    }

    public void setDoctypeReversed(DocumentType doctypeReversed) {
        set(PROPERTY_DOCTYPEREVERSED, doctypeReversed);
    }

    public Boolean isBlind() {
        return (Boolean) get(PROPERTY_BLIND);
    }

    public void setBlind(Boolean blind) {
        set(PROPERTY_BLIND, blind);
    }

    public Boolean isPaymentstodate() {
        return (Boolean) get(PROPERTY_PAYMENTSTODATE);
    }

    public void setPaymentstodate(Boolean paymentstodate) {
        set(PROPERTY_PAYMENTSTODATE, paymentstodate);
    }

    @SuppressWarnings("unchecked")
    public List<ScccCashClousure> getScccCashClosureList() {
      return (List<ScccCashClousure>) get(PROPERTY_SCCCCASHCLOSURELIST);
    }

    public void setScccCashClosureList(List<ScccCashClousure> scccCashClosureList) {
        set(PROPERTY_SCCCCASHCLOSURELIST, scccCashClosureList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccPaymentMethod> getScccPaymentMethodList() {
      return (List<ScccPaymentMethod>) get(PROPERTY_SCCCPAYMENTMETHODLIST);
    }

    public void setScccPaymentMethodList(List<ScccPaymentMethod> scccPaymentMethodList) {
        set(PROPERTY_SCCCPAYMENTMETHODLIST, scccPaymentMethodList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoAccountingConcept> getSsccsoAccountingConceptList() {
      return (List<SsccsoAccountingConcept>) get(PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST);
    }

    public void setSsccsoAccountingConceptList(List<SsccsoAccountingConcept> ssccsoAccountingConceptList) {
        set(PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST, ssccsoAccountingConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoTypeOfDocument> getSsccsoTypeOfDocumentList() {
      return (List<SsccsoTypeOfDocument>) get(PROPERTY_SSCCSOTYPEOFDOCUMENTLIST);
    }

    public void setSsccsoTypeOfDocumentList(List<SsccsoTypeOfDocument> ssccsoTypeOfDocumentList) {
        set(PROPERTY_SSCCSOTYPEOFDOCUMENTLIST, ssccsoTypeOfDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccUser> getScccUserList() {
      return (List<ScccUser>) get(PROPERTY_SCCCUSERLIST);
    }

    public void setScccUserList(List<ScccUser> scccUserList) {
        set(PROPERTY_SCCCUSERLIST, scccUserList);
    }

    @SuppressWarnings("unchecked")
    public List<SscccfaFinAccConcept> getSscccfaFinAccConceptList() {
      return (List<SscccfaFinAccConcept>) get(PROPERTY_SSCCCFAFINACCCONCEPTLIST);
    }

    public void setSscccfaFinAccConceptList(List<SscccfaFinAccConcept> sscccfaFinAccConceptList) {
        set(PROPERTY_SSCCCFAFINACCCONCEPTLIST, sscccfaFinAccConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SscccinInvoiceDoctype> getSscccinInvoiceDoctypeList() {
      return (List<SscccinInvoiceDoctype>) get(PROPERTY_SSCCCININVOICEDOCTYPELIST);
    }

    public void setSscccinInvoiceDoctypeList(List<SscccinInvoiceDoctype> sscccinInvoiceDoctypeList) {
        set(PROPERTY_SSCCCININVOICEDOCTYPELIST, sscccinInvoiceDoctypeList);
    }

}

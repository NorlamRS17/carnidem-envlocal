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
package ec.com.sidesoft.creditcard.reconciliation;

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
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
/**
 * Entity class for entity Ssccr_CardMatchingConfLine (stored in table Ssccr_CardMatchingConfLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsccrCardMatchingConfLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssccr_CardMatchingConfLine";
    public static final String ENTITY_NAME = "Ssccr_CardMatchingConfLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSCCRCARDSTYPES = "ssccrCardsTypes";
    public static final String PROPERTY_SSCCRCARDMATCHINGCONF = "ssccrCardmatchingconf";
    public static final String PROPERTY_INCOMEWITHHOLDING = "incomeWithholding";
    public static final String PROPERTY_WITHHOLDINGTAX = "withholdingTax";
    public static final String PROPERTY_TYPESOFCREDIT = "typesOfCredit";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_COMITION = "comition";
    public static final String PROPERTY_FROMVALIDITY = "fromValidity";
    public static final String PROPERTY_VALIDUP = "validUp";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_SSCCRWITHHOLDINGSLIST = "ssccrWithholdingsList";

    public SsccrCardMatchingConfLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_SSCCRWITHHOLDINGSLIST, new ArrayList<Object>());
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

    public SsccrCardsTypes getSsccrCardsTypes() {
        return (SsccrCardsTypes) get(PROPERTY_SSCCRCARDSTYPES);
    }

    public void setSsccrCardsTypes(SsccrCardsTypes ssccrCardsTypes) {
        set(PROPERTY_SSCCRCARDSTYPES, ssccrCardsTypes);
    }

    public SsccrCardMatchingConf getSsccrCardmatchingconf() {
        return (SsccrCardMatchingConf) get(PROPERTY_SSCCRCARDMATCHINGCONF);
    }

    public void setSsccrCardmatchingconf(SsccrCardMatchingConf ssccrCardmatchingconf) {
        set(PROPERTY_SSCCRCARDMATCHINGCONF, ssccrCardmatchingconf);
    }

    public String getIncomeWithholding() {
        return (String) get(PROPERTY_INCOMEWITHHOLDING);
    }

    public void setIncomeWithholding(String incomeWithholding) {
        set(PROPERTY_INCOMEWITHHOLDING, incomeWithholding);
    }

    public String getWithholdingTax() {
        return (String) get(PROPERTY_WITHHOLDINGTAX);
    }

    public void setWithholdingTax(String withholdingTax) {
        set(PROPERTY_WITHHOLDINGTAX, withholdingTax);
    }

    public SsccrTypesOfCredit getTypesOfCredit() {
        return (SsccrTypesOfCredit) get(PROPERTY_TYPESOFCREDIT);
    }

    public void setTypesOfCredit(SsccrTypesOfCredit typesOfCredit) {
        set(PROPERTY_TYPESOFCREDIT, typesOfCredit);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public String getComition() {
        return (String) get(PROPERTY_COMITION);
    }

    public void setComition(String comition) {
        set(PROPERTY_COMITION, comition);
    }

    public Date getFromValidity() {
        return (Date) get(PROPERTY_FROMVALIDITY);
    }

    public void setFromValidity(Date fromValidity) {
        set(PROPERTY_FROMVALIDITY, fromValidity);
    }

    public Date getValidUp() {
        return (Date) get(PROPERTY_VALIDUP);
    }

    public void setValidUp(Date validUp) {
        set(PROPERTY_VALIDUP, validUp);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrWithholdings> getSsccrWithholdingsList() {
      return (List<SsccrWithholdings>) get(PROPERTY_SSCCRWITHHOLDINGSLIST);
    }

    public void setSsccrWithholdingsList(List<SsccrWithholdings> ssccrWithholdingsList) {
        set(PROPERTY_SSCCRWITHHOLDINGSLIST, ssccrWithholdingsList);
    }

}

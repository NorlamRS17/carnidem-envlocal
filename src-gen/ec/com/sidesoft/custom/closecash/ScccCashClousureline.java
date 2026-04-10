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

import ec.com.sidesoft.creditcard.closecash.SscrccPaymentDetailed;

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
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity Sccc_Cash_Clousureline (stored in table sccc_cash_clousureline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScccCashClousureline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sccc_cash_clousureline";
    public static final String ENTITY_NAME = "Sccc_Cash_Clousureline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SCCCCASHCLOUSURE = "scccCashClousure";
    public static final String PROPERTY_TYPEACCOUNT = "typeaccount";
    public static final String PROPERTY_ORDERNUMBER = "orderNumber";
    public static final String PROPERTY_SCCAFINANCIALACCOUNT = "sccaFinancialAccount";
    public static final String PROPERTY_SCCACARDTYPE = "sccaCardType";
    public static final String PROPERTY_SCCALOT = "sccaLot";
    public static final String PROPERTY_SCCALINETYPE = "sccaLineType";
    public static final String PROPERTY_SSCCCINDEPOSIT = "sscccinDeposit";
    public static final String PROPERTY_SCCAPAYMENTTYPE = "sccaPaymenttype";
    public static final String PROPERTY_SSCCCINREADONLY = "sscccinReadonly";
    public static final String PROPERTY_SSCRCCPAYMENTDETAILEDLIST = "sscrccPaymentDetailedList";

    public ScccCashClousureline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SCCALINETYPE, "R");
        setDefaultValue(PROPERTY_SSCCCINREADONLY, false);
        setDefaultValue(PROPERTY_SSCRCCPAYMENTDETAILEDLIST, new ArrayList<Object>());
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

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public ScccCashClousure getScccCashClousure() {
        return (ScccCashClousure) get(PROPERTY_SCCCCASHCLOUSURE);
    }

    public void setScccCashClousure(ScccCashClousure scccCashClousure) {
        set(PROPERTY_SCCCCASHCLOUSURE, scccCashClousure);
    }

    public String getTypeaccount() {
        return (String) get(PROPERTY_TYPEACCOUNT);
    }

    public void setTypeaccount(String typeaccount) {
        set(PROPERTY_TYPEACCOUNT, typeaccount);
    }

    public Long getOrderNumber() {
        return (Long) get(PROPERTY_ORDERNUMBER);
    }

    public void setOrderNumber(Long orderNumber) {
        set(PROPERTY_ORDERNUMBER, orderNumber);
    }

    public FIN_FinancialAccount getSccaFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_SCCAFINANCIALACCOUNT);
    }

    public void setSccaFinancialAccount(FIN_FinancialAccount sccaFinancialAccount) {
        set(PROPERTY_SCCAFINANCIALACCOUNT, sccaFinancialAccount);
    }

    public String getSccaCardType() {
        return (String) get(PROPERTY_SCCACARDTYPE);
    }

    public void setSccaCardType(String sccaCardType) {
        set(PROPERTY_SCCACARDTYPE, sccaCardType);
    }

    public String getSccaLot() {
        return (String) get(PROPERTY_SCCALOT);
    }

    public void setSccaLot(String sccaLot) {
        set(PROPERTY_SCCALOT, sccaLot);
    }

    public String getSccaLineType() {
        return (String) get(PROPERTY_SCCALINETYPE);
    }

    public void setSccaLineType(String sccaLineType) {
        set(PROPERTY_SCCALINETYPE, sccaLineType);
    }

    public String getSscccinDeposit() {
        return (String) get(PROPERTY_SSCCCINDEPOSIT);
    }

    public void setSscccinDeposit(String sscccinDeposit) {
        set(PROPERTY_SSCCCINDEPOSIT, sscccinDeposit);
    }

    public String getSccaPaymenttype() {
        return (String) get(PROPERTY_SCCAPAYMENTTYPE);
    }

    public void setSccaPaymenttype(String sccaPaymenttype) {
        set(PROPERTY_SCCAPAYMENTTYPE, sccaPaymenttype);
    }

    public Boolean isSscccinReadonly() {
        return (Boolean) get(PROPERTY_SSCCCINREADONLY);
    }

    public void setSscccinReadonly(Boolean sscccinReadonly) {
        set(PROPERTY_SSCCCINREADONLY, sscccinReadonly);
    }

    @SuppressWarnings("unchecked")
    public List<SscrccPaymentDetailed> getSscrccPaymentDetailedList() {
      return (List<SscrccPaymentDetailed>) get(PROPERTY_SSCRCCPAYMENTDETAILEDLIST);
    }

    public void setSscrccPaymentDetailedList(List<SscrccPaymentDetailed> sscrccPaymentDetailedList) {
        set(PROPERTY_SSCRCCPAYMENTDETAILEDLIST, sscrccPaymentDetailedList);
    }

}

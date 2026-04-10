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
package ec.com.sidesoft.custom.closecash.advanced;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity scca_cards_settlement (stored in table scca_cards_settlement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SccaCardsSettlement extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scca_cards_settlement";
    public static final String ENTITY_NAME = "scca_cards_settlement";
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
    public static final String PROPERTY_CARDTYPE = "cardType";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_DATETRANSACTION = "dateTransaction";
    public static final String PROPERTY_RECEIVEDAMOUNT = "receivedAmount";
    public static final String PROPERTY_BONDEDAMOUNT = "bondedAmount";
    public static final String PROPERTY_COMMISSIONAMOUNT = "commissionAmount";
    public static final String PROPERTY_IVARETENTION = "iVARetention";
    public static final String PROPERTY_RENTRETENTION = "rentRetention";

    public SccaCardsSettlement() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_RECEIVEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_BONDEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMMISSIONAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_IVARETENTION, new BigDecimal(0));
        setDefaultValue(PROPERTY_RENTRETENTION, new BigDecimal(0));
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

    public String getCardType() {
        return (String) get(PROPERTY_CARDTYPE);
    }

    public void setCardType(String cardType) {
        set(PROPERTY_CARDTYPE, cardType);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public Date getDateTransaction() {
        return (Date) get(PROPERTY_DATETRANSACTION);
    }

    public void setDateTransaction(Date dateTransaction) {
        set(PROPERTY_DATETRANSACTION, dateTransaction);
    }

    public BigDecimal getReceivedAmount() {
        return (BigDecimal) get(PROPERTY_RECEIVEDAMOUNT);
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        set(PROPERTY_RECEIVEDAMOUNT, receivedAmount);
    }

    public BigDecimal getBondedAmount() {
        return (BigDecimal) get(PROPERTY_BONDEDAMOUNT);
    }

    public void setBondedAmount(BigDecimal bondedAmount) {
        set(PROPERTY_BONDEDAMOUNT, bondedAmount);
    }

    public BigDecimal getCommissionAmount() {
        return (BigDecimal) get(PROPERTY_COMMISSIONAMOUNT);
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        set(PROPERTY_COMMISSIONAMOUNT, commissionAmount);
    }

    public BigDecimal getIVARetention() {
        return (BigDecimal) get(PROPERTY_IVARETENTION);
    }

    public void setIVARetention(BigDecimal iVARetention) {
        set(PROPERTY_IVARETENTION, iVARetention);
    }

    public BigDecimal getRentRetention() {
        return (BigDecimal) get(PROPERTY_RENTRETENTION);
    }

    public void setRentRetention(BigDecimal rentRetention) {
        set(PROPERTY_RENTRETENTION, rentRetention);
    }

}

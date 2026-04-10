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
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity imdlv_purchaseimp_dline (stored in table imdlv_purchaseimp_dline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ImdlvPurchaseImpDataLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "imdlv_purchaseimp_dline";
    public static final String ENTITY_NAME = "imdlv_purchaseimp_dline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_IMDLVPURCHASEIMPDATA = "imdlvPurchaseimpData";
    public static final String PROPERTY_NAMEXLS = "namexls";
    public static final String PROPERTY_DATELXLS = "datelxls";
    public static final String PROPERTY_CITYXLS = "cityxls";
    public static final String PROPERTY_PAYMENTMETHODXLS = "paymentmethodxls";
    public static final String PROPERTY_SOCIALNAMEXLS = "socialnamexls";
    public static final String PROPERTY_ADDRESSXLS = "addressxls";
    public static final String PROPERTY_PHONEXLS = "phonexls";
    public static final String PROPERTY_TAXIDXLS = "taxidxls";
    public static final String PROPERTY_REFERENCEPAYMENTXLS = "referencepaymentxls";
    public static final String PROPERTY_DATEPAYMENTXLS = "datepaymentxls";
    public static final String PROPERTY_CURRENCYXLS = "currencyxls";
    public static final String PROPERTY_BASIMRENTXLS = "basimRentxls";
    public static final String PROPERTY_PERCTRENTXLS = "perctRentxls";
    public static final String PROPERTY_PERCTVATXLS = "perctVatxls";
    public static final String PROPERTY_PRODUCTRENTXLS = "productrentxls";
    public static final String PROPERTY_PRODUCTVATXLS = "productvatxls";
    public static final String PROPERTY_INVOICENOXLS = "invoicenoxls";
    public static final String PROPERTY_COSTCENTERXLS = "costcenterxls";
    public static final String PROPERTY_ACCOUNTXLS = "accountxls";
    public static final String PROPERTY_DESCRIPTIONXLS = "descriptionxls";
    public static final String PROPERTY_LOTXLS = "lotxls";
    public static final String PROPERTY_VOUCHERXLS = "voucherxls";
    public static final String PROPERTY_EMAILXLS = "emailxls";
    public static final String PROPERTY_FAXXLS = "faxxls";
    public static final String PROPERTY_AUTHORIZATIONSRIXLS = "authorizationsrixls";
    public static final String PROPERTY_AMOUNTXLS = "amountxls";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_BASEIMPXLS = "baseimpxls";
    public static final String PROPERTY_DUEDATEXLS = "duedatexls";
    public static final String PROPERTY_USERXLS = "userxls";
    public static final String PROPERTY_DATEINVOICEDXLS = "dateinvoicedxls";
    public static final String PROPERTY_ISPROCESS = "isprocess";
    public static final String PROPERTY_LOGERROR = "logerror";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_YEARXLS = "yearxls";

    public ImdlvPurchaseImpDataLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISPROCESS, false);
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

    public ImdlvPurchaseimpData getImdlvPurchaseimpData() {
        return (ImdlvPurchaseimpData) get(PROPERTY_IMDLVPURCHASEIMPDATA);
    }

    public void setImdlvPurchaseimpData(ImdlvPurchaseimpData imdlvPurchaseimpData) {
        set(PROPERTY_IMDLVPURCHASEIMPDATA, imdlvPurchaseimpData);
    }

    public String getNamexls() {
        return (String) get(PROPERTY_NAMEXLS);
    }

    public void setNamexls(String namexls) {
        set(PROPERTY_NAMEXLS, namexls);
    }

    public String getDatelxls() {
        return (String) get(PROPERTY_DATELXLS);
    }

    public void setDatelxls(String datelxls) {
        set(PROPERTY_DATELXLS, datelxls);
    }

    public String getCityxls() {
        return (String) get(PROPERTY_CITYXLS);
    }

    public void setCityxls(String cityxls) {
        set(PROPERTY_CITYXLS, cityxls);
    }

    public String getPaymentmethodxls() {
        return (String) get(PROPERTY_PAYMENTMETHODXLS);
    }

    public void setPaymentmethodxls(String paymentmethodxls) {
        set(PROPERTY_PAYMENTMETHODXLS, paymentmethodxls);
    }

    public String getSocialnamexls() {
        return (String) get(PROPERTY_SOCIALNAMEXLS);
    }

    public void setSocialnamexls(String socialnamexls) {
        set(PROPERTY_SOCIALNAMEXLS, socialnamexls);
    }

    public String getAddressxls() {
        return (String) get(PROPERTY_ADDRESSXLS);
    }

    public void setAddressxls(String addressxls) {
        set(PROPERTY_ADDRESSXLS, addressxls);
    }

    public String getPhonexls() {
        return (String) get(PROPERTY_PHONEXLS);
    }

    public void setPhonexls(String phonexls) {
        set(PROPERTY_PHONEXLS, phonexls);
    }

    public String getTaxidxls() {
        return (String) get(PROPERTY_TAXIDXLS);
    }

    public void setTaxidxls(String taxidxls) {
        set(PROPERTY_TAXIDXLS, taxidxls);
    }

    public String getReferencepaymentxls() {
        return (String) get(PROPERTY_REFERENCEPAYMENTXLS);
    }

    public void setReferencepaymentxls(String referencepaymentxls) {
        set(PROPERTY_REFERENCEPAYMENTXLS, referencepaymentxls);
    }

    public Date getDatepaymentxls() {
        return (Date) get(PROPERTY_DATEPAYMENTXLS);
    }

    public void setDatepaymentxls(Date datepaymentxls) {
        set(PROPERTY_DATEPAYMENTXLS, datepaymentxls);
    }

    public String getCurrencyxls() {
        return (String) get(PROPERTY_CURRENCYXLS);
    }

    public void setCurrencyxls(String currencyxls) {
        set(PROPERTY_CURRENCYXLS, currencyxls);
    }

    public BigDecimal getBasimRentxls() {
        return (BigDecimal) get(PROPERTY_BASIMRENTXLS);
    }

    public void setBasimRentxls(BigDecimal basimRentxls) {
        set(PROPERTY_BASIMRENTXLS, basimRentxls);
    }

    public BigDecimal getPerctRentxls() {
        return (BigDecimal) get(PROPERTY_PERCTRENTXLS);
    }

    public void setPerctRentxls(BigDecimal perctRentxls) {
        set(PROPERTY_PERCTRENTXLS, perctRentxls);
    }

    public BigDecimal getPerctVatxls() {
        return (BigDecimal) get(PROPERTY_PERCTVATXLS);
    }

    public void setPerctVatxls(BigDecimal perctVatxls) {
        set(PROPERTY_PERCTVATXLS, perctVatxls);
    }

    public String getProductrentxls() {
        return (String) get(PROPERTY_PRODUCTRENTXLS);
    }

    public void setProductrentxls(String productrentxls) {
        set(PROPERTY_PRODUCTRENTXLS, productrentxls);
    }

    public String getProductvatxls() {
        return (String) get(PROPERTY_PRODUCTVATXLS);
    }

    public void setProductvatxls(String productvatxls) {
        set(PROPERTY_PRODUCTVATXLS, productvatxls);
    }

    public String getInvoicenoxls() {
        return (String) get(PROPERTY_INVOICENOXLS);
    }

    public void setInvoicenoxls(String invoicenoxls) {
        set(PROPERTY_INVOICENOXLS, invoicenoxls);
    }

    public String getCostcenterxls() {
        return (String) get(PROPERTY_COSTCENTERXLS);
    }

    public void setCostcenterxls(String costcenterxls) {
        set(PROPERTY_COSTCENTERXLS, costcenterxls);
    }

    public String getAccountxls() {
        return (String) get(PROPERTY_ACCOUNTXLS);
    }

    public void setAccountxls(String accountxls) {
        set(PROPERTY_ACCOUNTXLS, accountxls);
    }

    public String getDescriptionxls() {
        return (String) get(PROPERTY_DESCRIPTIONXLS);
    }

    public void setDescriptionxls(String descriptionxls) {
        set(PROPERTY_DESCRIPTIONXLS, descriptionxls);
    }

    public String getLotxls() {
        return (String) get(PROPERTY_LOTXLS);
    }

    public void setLotxls(String lotxls) {
        set(PROPERTY_LOTXLS, lotxls);
    }

    public String getVoucherxls() {
        return (String) get(PROPERTY_VOUCHERXLS);
    }

    public void setVoucherxls(String voucherxls) {
        set(PROPERTY_VOUCHERXLS, voucherxls);
    }

    public String getEmailxls() {
        return (String) get(PROPERTY_EMAILXLS);
    }

    public void setEmailxls(String emailxls) {
        set(PROPERTY_EMAILXLS, emailxls);
    }

    public String getFaxxls() {
        return (String) get(PROPERTY_FAXXLS);
    }

    public void setFaxxls(String faxxls) {
        set(PROPERTY_FAXXLS, faxxls);
    }

    public String getAuthorizationsrixls() {
        return (String) get(PROPERTY_AUTHORIZATIONSRIXLS);
    }

    public void setAuthorizationsrixls(String authorizationsrixls) {
        set(PROPERTY_AUTHORIZATIONSRIXLS, authorizationsrixls);
    }

    public BigDecimal getAmountxls() {
        return (BigDecimal) get(PROPERTY_AMOUNTXLS);
    }

    public void setAmountxls(BigDecimal amountxls) {
        set(PROPERTY_AMOUNTXLS, amountxls);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public BigDecimal getBaseimpxls() {
        return (BigDecimal) get(PROPERTY_BASEIMPXLS);
    }

    public void setBaseimpxls(BigDecimal baseimpxls) {
        set(PROPERTY_BASEIMPXLS, baseimpxls);
    }

    public Date getDuedatexls() {
        return (Date) get(PROPERTY_DUEDATEXLS);
    }

    public void setDuedatexls(Date duedatexls) {
        set(PROPERTY_DUEDATEXLS, duedatexls);
    }

    public String getUserxls() {
        return (String) get(PROPERTY_USERXLS);
    }

    public void setUserxls(String userxls) {
        set(PROPERTY_USERXLS, userxls);
    }

    public Date getDateinvoicedxls() {
        return (Date) get(PROPERTY_DATEINVOICEDXLS);
    }

    public void setDateinvoicedxls(Date dateinvoicedxls) {
        set(PROPERTY_DATEINVOICEDXLS, dateinvoicedxls);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_ISPROCESS);
    }

    public void setProcess(Boolean isprocess) {
        set(PROPERTY_ISPROCESS, isprocess);
    }

    public String getLogerror() {
        return (String) get(PROPERTY_LOGERROR);
    }

    public void setLogerror(String logerror) {
        set(PROPERTY_LOGERROR, logerror);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getYearxls() {
        return (String) get(PROPERTY_YEARXLS);
    }

    public void setYearxls(String yearxls) {
        set(PROPERTY_YEARXLS, yearxls);
    }

}

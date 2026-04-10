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
package org.openbravo.model.common.enterprise;

import com.atrums.indumot.datosmaestros.data.atimdmDivision;
import com.atrums.indumot.datosmaestros.data.atimdmZona;

import ec.com.sidesoft.commercial.dimensions.sscdimDivision;
import ec.com.sidesoft.sales.order.indumot.SssoinDatesalesprocessV;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.RoleOrganization;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.financialmgmt.calendar.PeriodControlV;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.sales.SalesRegion;
import org.openbravo.retail.config.CashManagementEvents;
import org.openbravo.retail.config.OBRETCOProductList;
import org.openbravo.retail.posterminal.OBPOS_OrgWarehouseExtra;
import org.openbravo.retail.posterminal.PrintTemplate;
/**
 * Entity class for entity Organization (stored in table AD_Org).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Organization extends BaseOBObject implements Traceable, ClientEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Org";
    public static final String ENTITY_NAME = "Organization";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_ORGANIZATIONTYPE = "organizationType";
    public static final String PROPERTY_ALLOWPERIODCONTROL = "allowPeriodControl";
    public static final String PROPERTY_CALENDAR = "calendar";
    public static final String PROPERTY_READY = "ready";
    public static final String PROPERTY_SSWHDESCRIPTION2 = "sswhDescription2";
    public static final String PROPERTY_SOCIALNAME = "socialName";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_OBRETCORETAILORGTYPE = "oBRETCORetailOrgType";
    public static final String PROPERTY_GENERALLEDGER = "generalLedger";
    public static final String PROPERTY_OBRETCOPRICELIST = "obretcoPricelist";
    public static final String PROPERTY_APRMGLITEM = "aPRMGlitem";
    public static final String PROPERTY_OBRETCOPRODUCTLIST = "obretcoProductlist";
    public static final String PROPERTY_SSRSMLOCATORTRN = "ssrsMLocatortrn";
    public static final String PROPERTY_PERIODCONTROLALLOWEDORGANIZATION = "periodControlAllowedOrganization";
    public static final String PROPERTY_CALENDAROWNERORGANIZATION = "calendarOwnerOrganization";
    public static final String PROPERTY_ATIMDMZONA = "atimdmZona";
    public static final String PROPERTY_OBRETCOCBPARTNER = "obretcoCBpartner";
    public static final String PROPERTY_SSRSMLOCATORRCP = "ssrsMLocatorrcp";
    public static final String PROPERTY_OBRETCOCBPLOCATION = "obretcoCBpLocation";
    public static final String PROPERTY_SSRSTIMETO = "ssrsTimeto";
    public static final String PROPERTY_LEGALENTITYORGANIZATION = "legalEntityOrganization";
    public static final String PROPERTY_ATIMDMDIVISION = "atimdmDivision";
    public static final String PROPERTY_OBRETCOMWAREHOUSE = "obretcoMWarehouse";
    public static final String PROPERTY_INHERITEDCALENDAR = "inheritedCalendar";
    public static final String PROPERTY_BUSINESSUNITORGANIZATION = "businessUnitOrganization";
    public static final String PROPERTY_OBRETCODBPIRULESID = "obretcoDbpIrulesid";
    public static final String PROPERTY_OBRETCODBPPTERMID = "obretcoDbpPtermid";
    public static final String PROPERTY_OBRETCODBPPMETHODID = "obretcoDbpPmethodid";
    public static final String PROPERTY_OBRETCODBPBPCATID = "obretcoDbpBpcatid";
    public static final String PROPERTY_OBRETCODBPCOUNTRYID = "obretcoDbpCountryid";
    public static final String PROPERTY_OBRETCODBPORGID = "obretcoDbpOrgid";
    public static final String PROPERTY_OBRETCOSHOWTAXID = "obretcoShowtaxid";
    public static final String PROPERTY_SFCBRBALANCESIGN1 = "sfcbrBalanceSign1";
    public static final String PROPERTY_OBPOSTICKETTEMPLATE = "obposTicketTemplate";
    public static final String PROPERTY_OBRETCOSHOWBPCATEGORY = "obretcoShowbpcategory";
    public static final String PROPERTY_SFCBRBALANCESIGN2 = "sfcbrBalanceSign2";
    public static final String PROPERTY_OBPOSCASHUPTEMPLATE = "obposCashupTemplate";
    public static final String PROPERTY_OBPOSFORMATDECIMAL = "obposFormatDecimal";
    public static final String PROPERTY_OBPOSFORMATGROUP = "obposFormatGroup";
    public static final String PROPERTY_OBPOSDATEFORMAT = "obposDateFormat";
    public static final String PROPERTY_SSRSCDOCTYPEFROM = "ssrsCDoctypefrom";
    public static final String PROPERTY_OBPOSCLOSEDRECEIPTTEMPLATE = "oBPOSClosedReceiptTemplate";
    public static final String PROPERTY_SSRSCDOCTYPETO = "ssrsCDoctypeto";
    public static final String PROPERTY_OBPOSINVOICETEMPLATE = "obposInvoiceTemplate";
    public static final String PROPERTY_OBPOSRETINVTEMPLATE = "obposRetInvTemplate";
    public static final String PROPERTY_OBPOSLAYAWAYTEMPLATE = "obposLayawayTemplate";
    public static final String PROPERTY_OBPOSRETURNTEMPLATE = "obposReturnTemplate";
    public static final String PROPERTY_EEISHOWREMISSIONGUIDE = "eeiShowRemissionGuide";
    public static final String PROPERTY_OBPOSQUOTTEMPLATE = "obposQuotTemplate";
    public static final String PROPERTY_SSCDIMDIVISION = "sscdimDivision";
    public static final String PROPERTY_EEIREACTIVATEAUTHDOCS = "eeiReactivateAuthDocs";
    public static final String PROPERTY_OBPOSCOUNTDIFFLIMIT = "obposCountDiffLimit";
    public static final String PROPERTY_SSCDIMCSALESREGION = "sscdimCSalesregion";
    public static final String PROPERTY_EEIWITHHOLDINGAGENT = "eeiWithholdingAgent";
    public static final String PROPERTY_OBPOSSELECTCCWAREHOUSE = "obposSelectCcWarehouse";
    public static final String PROPERTY_EEIDISCOUNTBYPRICELIST = "eeiDiscountbypricelist";
    public static final String PROPERTY_OBPOSINCLUDEDCCWAREHOUSES = "obposIncludedCCWarehouses";
    public static final String PROPERTY_EEIMICROBUSINESS = "eeiMicroBusiness";
    public static final String PROPERTY_SATHNCSUPERVISOR = "sathncSupervisor";
    public static final String PROPERTY_SCMFPHARMACEUTICAL = "scmfPharmaceutical";
    public static final String PROPERTY_EEIRIMPE = "eeiRimpe";
    public static final String PROPERTY_OBPOSLAYAWAYANONYMOUSBP = "obposLayawayAnonymousbp";
    public static final String PROPERTY_OBPOSLAYAWAYPARTPAID = "obposLayawayPartpaid";
    public static final String PROPERTY_OBPOSCURRENCYFORMAT = "obposCurrencyFormat";
    public static final String PROPERTY_OBPOSWELCOMETEMPLATE = "obposWelcomeTemplate";
    public static final String PROPERTY_SDINDINARDAP = "sdinDinardap";
    public static final String PROPERTY_OBPOSCASHMGMTEMPLATE = "obposCashmgmTemplate";
    public static final String PROPERTY_OBPOSCLOINVTEMPLATE = "obposCloInvTemplate";
    public static final String PROPERTY_ECSDSISDEVELOPMENT = "ecsdsIsdevelopment";
    public static final String PROPERTY_STATCBPARTNER = "statCBpartner";
    public static final String PROPERTY_SPEVCCOSTCENTER = "spevCCostcenter";
    public static final String PROPERTY_SSALPENVIRONMENT = "ssalpEnvironment";
    public static final String PROPERTY_SSALPURLAUTHOTEST = "ssalpUrlAuthoTest";
    public static final String PROPERTY_OBPOSCANCRPTTEMPLATE = "obposCancRptTemplate";
    public static final String PROPERTY_SSALPURLAUTHOPROD = "ssalpUrlAuthoProd";
    public static final String PROPERTY_SSOPOSCCOSTCENTER = "ssoposCCostcenter";
    public static final String PROPERTY_SSOPOSUSER1 = "ssoposUser1";
    public static final String PROPERTY_OBPGCCREDITTEMPLATE = "obpgcCreditTemplate";
    public static final String PROPERTY_SSFORCDOCTYPETARGET = "ssforCDoctypetarget";
    public static final String PROPERTY_SSFORMWAREHOUSE = "ssforMWarehouse";
    public static final String PROPERTY_SSFORROUTE = "ssforRoute";
    public static final String PROPERTY_SSFORCBPARTNER = "ssforCBpartner";
    public static final String PROPERTY_SSXMLGRUOPIRBP = "ssxmlGruopIrbp";
    public static final String PROPERTY_SSWHATSAMOUNT = "sswhAtsAmount";
    public static final String PROPERTY_ADROLEORGANIZATIONLIST = "aDRoleOrganizationList";
    public static final String PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST = "financialMgmtPeriodControlVList";
    public static final String PROPERTY_OBPOSORGWAREHOUSEEXTRALIST = "oBPOSOrgWarehouseExtraList";
    public static final String PROPERTY_OBRETCOCASHMANAGEMENTEVENTSLIST = "oBRETCOCashManagementEventsList";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONLIST = "organizationInformationList";
    public static final String PROPERTY_ORGANIZATIONMODULEVLIST = "organizationModuleVList";
    public static final String PROPERTY_ORGANIZATIONTREELIST = "organizationTreeList";
    public static final String PROPERTY_ORGANIZATIONWAREHOUSELIST = "organizationWarehouseList";
    public static final String PROPERTY_SSSOINDATESALESPROCESSVLIST = "sssoinDatesalesprocessVList";

    public Organization() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_ALLOWPERIODCONTROL, false);
        setDefaultValue(PROPERTY_READY, false);
        setDefaultValue(PROPERTY_OBRETCOSHOWTAXID, true);
        setDefaultValue(PROPERTY_OBRETCOSHOWBPCATEGORY, true);
        setDefaultValue(PROPERTY_EEISHOWREMISSIONGUIDE, false);
        setDefaultValue(PROPERTY_EEIREACTIVATEAUTHDOCS, false);
        setDefaultValue(PROPERTY_OBPOSSELECTCCWAREHOUSE, false);
        setDefaultValue(PROPERTY_EEIDISCOUNTBYPRICELIST, true);
        setDefaultValue(PROPERTY_SCMFPHARMACEUTICAL, false);
        setDefaultValue(PROPERTY_OBPOSLAYAWAYANONYMOUSBP, true);
        setDefaultValue(PROPERTY_OBPOSLAYAWAYPARTPAID, true);
        setDefaultValue(PROPERTY_ECSDSISDEVELOPMENT, true);
        setDefaultValue(PROPERTY_SSALPENVIRONMENT, "1");
        setDefaultValue(PROPERTY_SSALPURLAUTHOTEST, "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl");
        setDefaultValue(PROPERTY_SSALPURLAUTHOPROD, "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl");
        setDefaultValue(PROPERTY_SSWHATSAMOUNT, new BigDecimal(500));
        setDefaultValue(PROPERTY_ADROLEORGANIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSORGWAREHOUSEEXTRALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBRETCOCASHMANAGEMENTEVENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONMODULEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONTREELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONWAREHOUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSSOINDATESALESPROCESSVLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
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

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public OrganizationType getOrganizationType() {
        return (OrganizationType) get(PROPERTY_ORGANIZATIONTYPE);
    }

    public void setOrganizationType(OrganizationType organizationType) {
        set(PROPERTY_ORGANIZATIONTYPE, organizationType);
    }

    public Boolean isAllowPeriodControl() {
        return (Boolean) get(PROPERTY_ALLOWPERIODCONTROL);
    }

    public void setAllowPeriodControl(Boolean allowPeriodControl) {
        set(PROPERTY_ALLOWPERIODCONTROL, allowPeriodControl);
    }

    public Calendar getCalendar() {
        return (Calendar) get(PROPERTY_CALENDAR);
    }

    public void setCalendar(Calendar calendar) {
        set(PROPERTY_CALENDAR, calendar);
    }

    public Boolean isReady() {
        return (Boolean) get(PROPERTY_READY);
    }

    public void setReady(Boolean ready) {
        set(PROPERTY_READY, ready);
    }

    public String getSswhDescription2() {
        return (String) get(PROPERTY_SSWHDESCRIPTION2);
    }

    public void setSswhDescription2(String sswhDescription2) {
        set(PROPERTY_SSWHDESCRIPTION2, sswhDescription2);
    }

    public String getSocialName() {
        return (String) get(PROPERTY_SOCIALNAME);
    }

    public void setSocialName(String socialName) {
        set(PROPERTY_SOCIALNAME, socialName);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getOBRETCORetailOrgType() {
        return (String) get(PROPERTY_OBRETCORETAILORGTYPE);
    }

    public void setOBRETCORetailOrgType(String oBRETCORetailOrgType) {
        set(PROPERTY_OBRETCORETAILORGTYPE, oBRETCORetailOrgType);
    }

    public AcctSchema getGeneralLedger() {
        return (AcctSchema) get(PROPERTY_GENERALLEDGER);
    }

    public void setGeneralLedger(AcctSchema generalLedger) {
        set(PROPERTY_GENERALLEDGER, generalLedger);
    }

    public PriceList getObretcoPricelist() {
        return (PriceList) get(PROPERTY_OBRETCOPRICELIST);
    }

    public void setObretcoPricelist(PriceList obretcoPricelist) {
        set(PROPERTY_OBRETCOPRICELIST, obretcoPricelist);
    }

    public GLItem getAPRMGlitem() {
        return (GLItem) get(PROPERTY_APRMGLITEM);
    }

    public void setAPRMGlitem(GLItem aPRMGlitem) {
        set(PROPERTY_APRMGLITEM, aPRMGlitem);
    }

    public OBRETCOProductList getObretcoProductlist() {
        return (OBRETCOProductList) get(PROPERTY_OBRETCOPRODUCTLIST);
    }

    public void setObretcoProductlist(OBRETCOProductList obretcoProductlist) {
        set(PROPERTY_OBRETCOPRODUCTLIST, obretcoProductlist);
    }

    public Locator getSsrsMLocatortrn() {
        return (Locator) get(PROPERTY_SSRSMLOCATORTRN);
    }

    public void setSsrsMLocatortrn(Locator ssrsMLocatortrn) {
        set(PROPERTY_SSRSMLOCATORTRN, ssrsMLocatortrn);
    }

    public Organization getPeriodControlAllowedOrganization() {
        return (Organization) get(PROPERTY_PERIODCONTROLALLOWEDORGANIZATION);
    }

    public void setPeriodControlAllowedOrganization(Organization periodControlAllowedOrganization) {
        set(PROPERTY_PERIODCONTROLALLOWEDORGANIZATION, periodControlAllowedOrganization);
    }

    public Organization getCalendarOwnerOrganization() {
        return (Organization) get(PROPERTY_CALENDAROWNERORGANIZATION);
    }

    public void setCalendarOwnerOrganization(Organization calendarOwnerOrganization) {
        set(PROPERTY_CALENDAROWNERORGANIZATION, calendarOwnerOrganization);
    }

    public atimdmZona getAtimdmZona() {
        return (atimdmZona) get(PROPERTY_ATIMDMZONA);
    }

    public void setAtimdmZona(atimdmZona atimdmZona) {
        set(PROPERTY_ATIMDMZONA, atimdmZona);
    }

    public BusinessPartner getObretcoCBpartner() {
        return (BusinessPartner) get(PROPERTY_OBRETCOCBPARTNER);
    }

    public void setObretcoCBpartner(BusinessPartner obretcoCBpartner) {
        set(PROPERTY_OBRETCOCBPARTNER, obretcoCBpartner);
    }

    public Locator getSsrsMLocatorrcp() {
        return (Locator) get(PROPERTY_SSRSMLOCATORRCP);
    }

    public void setSsrsMLocatorrcp(Locator ssrsMLocatorrcp) {
        set(PROPERTY_SSRSMLOCATORRCP, ssrsMLocatorrcp);
    }

    public Location getObretcoCBpLocation() {
        return (Location) get(PROPERTY_OBRETCOCBPLOCATION);
    }

    public void setObretcoCBpLocation(Location obretcoCBpLocation) {
        set(PROPERTY_OBRETCOCBPLOCATION, obretcoCBpLocation);
    }

    public Timestamp getSsrsTimeto() {
        return (Timestamp) get(PROPERTY_SSRSTIMETO);
    }

    public void setSsrsTimeto(Timestamp ssrsTimeto) {
        set(PROPERTY_SSRSTIMETO, ssrsTimeto);
    }

    public Organization getLegalEntityOrganization() {
        return (Organization) get(PROPERTY_LEGALENTITYORGANIZATION);
    }

    public void setLegalEntityOrganization(Organization legalEntityOrganization) {
        set(PROPERTY_LEGALENTITYORGANIZATION, legalEntityOrganization);
    }

    public atimdmDivision getAtimdmDivision() {
        return (atimdmDivision) get(PROPERTY_ATIMDMDIVISION);
    }

    public void setAtimdmDivision(atimdmDivision atimdmDivision) {
        set(PROPERTY_ATIMDMDIVISION, atimdmDivision);
    }

    public Warehouse getObretcoMWarehouse() {
        return (Warehouse) get(PROPERTY_OBRETCOMWAREHOUSE);
    }

    public void setObretcoMWarehouse(Warehouse obretcoMWarehouse) {
        set(PROPERTY_OBRETCOMWAREHOUSE, obretcoMWarehouse);
    }

    public Calendar getInheritedCalendar() {
        return (Calendar) get(PROPERTY_INHERITEDCALENDAR);
    }

    public void setInheritedCalendar(Calendar inheritedCalendar) {
        set(PROPERTY_INHERITEDCALENDAR, inheritedCalendar);
    }

    public Organization getBusinessUnitOrganization() {
        return (Organization) get(PROPERTY_BUSINESSUNITORGANIZATION);
    }

    public void setBusinessUnitOrganization(Organization businessUnitOrganization) {
        set(PROPERTY_BUSINESSUNITORGANIZATION, businessUnitOrganization);
    }

    public String getObretcoDbpIrulesid() {
        return (String) get(PROPERTY_OBRETCODBPIRULESID);
    }

    public void setObretcoDbpIrulesid(String obretcoDbpIrulesid) {
        set(PROPERTY_OBRETCODBPIRULESID, obretcoDbpIrulesid);
    }

    public PaymentTerm getObretcoDbpPtermid() {
        return (PaymentTerm) get(PROPERTY_OBRETCODBPPTERMID);
    }

    public void setObretcoDbpPtermid(PaymentTerm obretcoDbpPtermid) {
        set(PROPERTY_OBRETCODBPPTERMID, obretcoDbpPtermid);
    }

    public FIN_PaymentMethod getObretcoDbpPmethodid() {
        return (FIN_PaymentMethod) get(PROPERTY_OBRETCODBPPMETHODID);
    }

    public void setObretcoDbpPmethodid(FIN_PaymentMethod obretcoDbpPmethodid) {
        set(PROPERTY_OBRETCODBPPMETHODID, obretcoDbpPmethodid);
    }

    public Category getObretcoDbpBpcatid() {
        return (Category) get(PROPERTY_OBRETCODBPBPCATID);
    }

    public void setObretcoDbpBpcatid(Category obretcoDbpBpcatid) {
        set(PROPERTY_OBRETCODBPBPCATID, obretcoDbpBpcatid);
    }

    public Country getObretcoDbpCountryid() {
        return (Country) get(PROPERTY_OBRETCODBPCOUNTRYID);
    }

    public void setObretcoDbpCountryid(Country obretcoDbpCountryid) {
        set(PROPERTY_OBRETCODBPCOUNTRYID, obretcoDbpCountryid);
    }

    public Organization getObretcoDbpOrgid() {
        return (Organization) get(PROPERTY_OBRETCODBPORGID);
    }

    public void setObretcoDbpOrgid(Organization obretcoDbpOrgid) {
        set(PROPERTY_OBRETCODBPORGID, obretcoDbpOrgid);
    }

    public Boolean isObretcoShowtaxid() {
        return (Boolean) get(PROPERTY_OBRETCOSHOWTAXID);
    }

    public void setObretcoShowtaxid(Boolean obretcoShowtaxid) {
        set(PROPERTY_OBRETCOSHOWTAXID, obretcoShowtaxid);
    }

    public BusinessPartner getSfcbrBalanceSign1() {
        return (BusinessPartner) get(PROPERTY_SFCBRBALANCESIGN1);
    }

    public void setSfcbrBalanceSign1(BusinessPartner sfcbrBalanceSign1) {
        set(PROPERTY_SFCBRBALANCESIGN1, sfcbrBalanceSign1);
    }

    public PrintTemplate getObposTicketTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSTICKETTEMPLATE);
    }

    public void setObposTicketTemplate(PrintTemplate obposTicketTemplate) {
        set(PROPERTY_OBPOSTICKETTEMPLATE, obposTicketTemplate);
    }

    public Boolean isObretcoShowbpcategory() {
        return (Boolean) get(PROPERTY_OBRETCOSHOWBPCATEGORY);
    }

    public void setObretcoShowbpcategory(Boolean obretcoShowbpcategory) {
        set(PROPERTY_OBRETCOSHOWBPCATEGORY, obretcoShowbpcategory);
    }

    public BusinessPartner getSfcbrBalanceSign2() {
        return (BusinessPartner) get(PROPERTY_SFCBRBALANCESIGN2);
    }

    public void setSfcbrBalanceSign2(BusinessPartner sfcbrBalanceSign2) {
        set(PROPERTY_SFCBRBALANCESIGN2, sfcbrBalanceSign2);
    }

    public PrintTemplate getObposCashupTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSCASHUPTEMPLATE);
    }

    public void setObposCashupTemplate(PrintTemplate obposCashupTemplate) {
        set(PROPERTY_OBPOSCASHUPTEMPLATE, obposCashupTemplate);
    }

    public String getObposFormatDecimal() {
        return (String) get(PROPERTY_OBPOSFORMATDECIMAL);
    }

    public void setObposFormatDecimal(String obposFormatDecimal) {
        set(PROPERTY_OBPOSFORMATDECIMAL, obposFormatDecimal);
    }

    public String getObposFormatGroup() {
        return (String) get(PROPERTY_OBPOSFORMATGROUP);
    }

    public void setObposFormatGroup(String obposFormatGroup) {
        set(PROPERTY_OBPOSFORMATGROUP, obposFormatGroup);
    }

    public String getObposDateFormat() {
        return (String) get(PROPERTY_OBPOSDATEFORMAT);
    }

    public void setObposDateFormat(String obposDateFormat) {
        set(PROPERTY_OBPOSDATEFORMAT, obposDateFormat);
    }

    public DocumentType getSsrsCDoctypefrom() {
        return (DocumentType) get(PROPERTY_SSRSCDOCTYPEFROM);
    }

    public void setSsrsCDoctypefrom(DocumentType ssrsCDoctypefrom) {
        set(PROPERTY_SSRSCDOCTYPEFROM, ssrsCDoctypefrom);
    }

    public PrintTemplate getOBPOSClosedReceiptTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSCLOSEDRECEIPTTEMPLATE);
    }

    public void setOBPOSClosedReceiptTemplate(PrintTemplate oBPOSClosedReceiptTemplate) {
        set(PROPERTY_OBPOSCLOSEDRECEIPTTEMPLATE, oBPOSClosedReceiptTemplate);
    }

    public DocumentType getSsrsCDoctypeto() {
        return (DocumentType) get(PROPERTY_SSRSCDOCTYPETO);
    }

    public void setSsrsCDoctypeto(DocumentType ssrsCDoctypeto) {
        set(PROPERTY_SSRSCDOCTYPETO, ssrsCDoctypeto);
    }

    public PrintTemplate getObposInvoiceTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSINVOICETEMPLATE);
    }

    public void setObposInvoiceTemplate(PrintTemplate obposInvoiceTemplate) {
        set(PROPERTY_OBPOSINVOICETEMPLATE, obposInvoiceTemplate);
    }

    public PrintTemplate getObposRetInvTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSRETINVTEMPLATE);
    }

    public void setObposRetInvTemplate(PrintTemplate obposRetInvTemplate) {
        set(PROPERTY_OBPOSRETINVTEMPLATE, obposRetInvTemplate);
    }

    public PrintTemplate getObposLayawayTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSLAYAWAYTEMPLATE);
    }

    public void setObposLayawayTemplate(PrintTemplate obposLayawayTemplate) {
        set(PROPERTY_OBPOSLAYAWAYTEMPLATE, obposLayawayTemplate);
    }

    public PrintTemplate getObposReturnTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSRETURNTEMPLATE);
    }

    public void setObposReturnTemplate(PrintTemplate obposReturnTemplate) {
        set(PROPERTY_OBPOSRETURNTEMPLATE, obposReturnTemplate);
    }

    public Boolean isEeiShowRemissionGuide() {
        return (Boolean) get(PROPERTY_EEISHOWREMISSIONGUIDE);
    }

    public void setEeiShowRemissionGuide(Boolean eeiShowRemissionGuide) {
        set(PROPERTY_EEISHOWREMISSIONGUIDE, eeiShowRemissionGuide);
    }

    public PrintTemplate getObposQuotTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSQUOTTEMPLATE);
    }

    public void setObposQuotTemplate(PrintTemplate obposQuotTemplate) {
        set(PROPERTY_OBPOSQUOTTEMPLATE, obposQuotTemplate);
    }

    public sscdimDivision getSscdimDivision() {
        return (sscdimDivision) get(PROPERTY_SSCDIMDIVISION);
    }

    public void setSscdimDivision(sscdimDivision sscdimDivision) {
        set(PROPERTY_SSCDIMDIVISION, sscdimDivision);
    }

    public Boolean isEeiReactivateAuthDocs() {
        return (Boolean) get(PROPERTY_EEIREACTIVATEAUTHDOCS);
    }

    public void setEeiReactivateAuthDocs(Boolean eeiReactivateAuthDocs) {
        set(PROPERTY_EEIREACTIVATEAUTHDOCS, eeiReactivateAuthDocs);
    }

    public BigDecimal getObposCountDiffLimit() {
        return (BigDecimal) get(PROPERTY_OBPOSCOUNTDIFFLIMIT);
    }

    public void setObposCountDiffLimit(BigDecimal obposCountDiffLimit) {
        set(PROPERTY_OBPOSCOUNTDIFFLIMIT, obposCountDiffLimit);
    }

    public SalesRegion getSscdimCSalesregion() {
        return (SalesRegion) get(PROPERTY_SSCDIMCSALESREGION);
    }

    public void setSscdimCSalesregion(SalesRegion sscdimCSalesregion) {
        set(PROPERTY_SSCDIMCSALESREGION, sscdimCSalesregion);
    }

    public String getEeiWithholdingAgent() {
        return (String) get(PROPERTY_EEIWITHHOLDINGAGENT);
    }

    public void setEeiWithholdingAgent(String eeiWithholdingAgent) {
        set(PROPERTY_EEIWITHHOLDINGAGENT, eeiWithholdingAgent);
    }

    public Boolean isObposSelectCcWarehouse() {
        return (Boolean) get(PROPERTY_OBPOSSELECTCCWAREHOUSE);
    }

    public void setObposSelectCcWarehouse(Boolean obposSelectCcWarehouse) {
        set(PROPERTY_OBPOSSELECTCCWAREHOUSE, obposSelectCcWarehouse);
    }

    public Boolean isEeiDiscountbypricelist() {
        return (Boolean) get(PROPERTY_EEIDISCOUNTBYPRICELIST);
    }

    public void setEeiDiscountbypricelist(Boolean eeiDiscountbypricelist) {
        set(PROPERTY_EEIDISCOUNTBYPRICELIST, eeiDiscountbypricelist);
    }

    public String getObposIncludedCCWarehouses() {
        return (String) get(PROPERTY_OBPOSINCLUDEDCCWAREHOUSES);
    }

    public void setObposIncludedCCWarehouses(String obposIncludedCCWarehouses) {
        set(PROPERTY_OBPOSINCLUDEDCCWAREHOUSES, obposIncludedCCWarehouses);
    }

    public String getEeiMicroBusiness() {
        return (String) get(PROPERTY_EEIMICROBUSINESS);
    }

    public void setEeiMicroBusiness(String eeiMicroBusiness) {
        set(PROPERTY_EEIMICROBUSINESS, eeiMicroBusiness);
    }

    public BusinessPartner getSathncSupervisor() {
        return (BusinessPartner) get(PROPERTY_SATHNCSUPERVISOR);
    }

    public void setSathncSupervisor(BusinessPartner sathncSupervisor) {
        set(PROPERTY_SATHNCSUPERVISOR, sathncSupervisor);
    }

    public Boolean isScmfPharmaceutical() {
        return (Boolean) get(PROPERTY_SCMFPHARMACEUTICAL);
    }

    public void setScmfPharmaceutical(Boolean scmfPharmaceutical) {
        set(PROPERTY_SCMFPHARMACEUTICAL, scmfPharmaceutical);
    }

    public String getEeiRimpe() {
        return (String) get(PROPERTY_EEIRIMPE);
    }

    public void setEeiRimpe(String eeiRimpe) {
        set(PROPERTY_EEIRIMPE, eeiRimpe);
    }

    public Boolean isObposLayawayAnonymousbp() {
        return (Boolean) get(PROPERTY_OBPOSLAYAWAYANONYMOUSBP);
    }

    public void setObposLayawayAnonymousbp(Boolean obposLayawayAnonymousbp) {
        set(PROPERTY_OBPOSLAYAWAYANONYMOUSBP, obposLayawayAnonymousbp);
    }

    public Boolean isObposLayawayPartpaid() {
        return (Boolean) get(PROPERTY_OBPOSLAYAWAYPARTPAID);
    }

    public void setObposLayawayPartpaid(Boolean obposLayawayPartpaid) {
        set(PROPERTY_OBPOSLAYAWAYPARTPAID, obposLayawayPartpaid);
    }

    public String getObposCurrencyFormat() {
        return (String) get(PROPERTY_OBPOSCURRENCYFORMAT);
    }

    public void setObposCurrencyFormat(String obposCurrencyFormat) {
        set(PROPERTY_OBPOSCURRENCYFORMAT, obposCurrencyFormat);
    }

    public PrintTemplate getObposWelcomeTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSWELCOMETEMPLATE);
    }

    public void setObposWelcomeTemplate(PrintTemplate obposWelcomeTemplate) {
        set(PROPERTY_OBPOSWELCOMETEMPLATE, obposWelcomeTemplate);
    }

    public String getSdinDinardap() {
        return (String) get(PROPERTY_SDINDINARDAP);
    }

    public void setSdinDinardap(String sdinDinardap) {
        set(PROPERTY_SDINDINARDAP, sdinDinardap);
    }

    public PrintTemplate getObposCashmgmTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSCASHMGMTEMPLATE);
    }

    public void setObposCashmgmTemplate(PrintTemplate obposCashmgmTemplate) {
        set(PROPERTY_OBPOSCASHMGMTEMPLATE, obposCashmgmTemplate);
    }

    public PrintTemplate getObposCloInvTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSCLOINVTEMPLATE);
    }

    public void setObposCloInvTemplate(PrintTemplate obposCloInvTemplate) {
        set(PROPERTY_OBPOSCLOINVTEMPLATE, obposCloInvTemplate);
    }

    public Boolean isEcsdsIsdevelopment() {
        return (Boolean) get(PROPERTY_ECSDSISDEVELOPMENT);
    }

    public void setEcsdsIsdevelopment(Boolean ecsdsIsdevelopment) {
        set(PROPERTY_ECSDSISDEVELOPMENT, ecsdsIsdevelopment);
    }

    public BusinessPartner getStatCBpartner() {
        return (BusinessPartner) get(PROPERTY_STATCBPARTNER);
    }

    public void setStatCBpartner(BusinessPartner statCBpartner) {
        set(PROPERTY_STATCBPARTNER, statCBpartner);
    }

    public Costcenter getSpevCCostcenter() {
        return (Costcenter) get(PROPERTY_SPEVCCOSTCENTER);
    }

    public void setSpevCCostcenter(Costcenter spevCCostcenter) {
        set(PROPERTY_SPEVCCOSTCENTER, spevCCostcenter);
    }

    public String getSsalpEnvironment() {
        return (String) get(PROPERTY_SSALPENVIRONMENT);
    }

    public void setSsalpEnvironment(String ssalpEnvironment) {
        set(PROPERTY_SSALPENVIRONMENT, ssalpEnvironment);
    }

    public String getSsalpUrlAuthoTest() {
        return (String) get(PROPERTY_SSALPURLAUTHOTEST);
    }

    public void setSsalpUrlAuthoTest(String ssalpUrlAuthoTest) {
        set(PROPERTY_SSALPURLAUTHOTEST, ssalpUrlAuthoTest);
    }

    public PrintTemplate getObposCancRptTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPOSCANCRPTTEMPLATE);
    }

    public void setObposCancRptTemplate(PrintTemplate obposCancRptTemplate) {
        set(PROPERTY_OBPOSCANCRPTTEMPLATE, obposCancRptTemplate);
    }

    public String getSsalpUrlAuthoProd() {
        return (String) get(PROPERTY_SSALPURLAUTHOPROD);
    }

    public void setSsalpUrlAuthoProd(String ssalpUrlAuthoProd) {
        set(PROPERTY_SSALPURLAUTHOPROD, ssalpUrlAuthoProd);
    }

    public Costcenter getSsoposCCostcenter() {
        return (Costcenter) get(PROPERTY_SSOPOSCCOSTCENTER);
    }

    public void setSsoposCCostcenter(Costcenter ssoposCCostcenter) {
        set(PROPERTY_SSOPOSCCOSTCENTER, ssoposCCostcenter);
    }

    public UserDimension1 getSsoposUser1() {
        return (UserDimension1) get(PROPERTY_SSOPOSUSER1);
    }

    public void setSsoposUser1(UserDimension1 ssoposUser1) {
        set(PROPERTY_SSOPOSUSER1, ssoposUser1);
    }

    public PrintTemplate getObpgcCreditTemplate() {
        return (PrintTemplate) get(PROPERTY_OBPGCCREDITTEMPLATE);
    }

    public void setObpgcCreditTemplate(PrintTemplate obpgcCreditTemplate) {
        set(PROPERTY_OBPGCCREDITTEMPLATE, obpgcCreditTemplate);
    }

    public DocumentType getSsforCDoctypetarget() {
        return (DocumentType) get(PROPERTY_SSFORCDOCTYPETARGET);
    }

    public void setSsforCDoctypetarget(DocumentType ssforCDoctypetarget) {
        set(PROPERTY_SSFORCDOCTYPETARGET, ssforCDoctypetarget);
    }

    public Warehouse getSsforMWarehouse() {
        return (Warehouse) get(PROPERTY_SSFORMWAREHOUSE);
    }

    public void setSsforMWarehouse(Warehouse ssforMWarehouse) {
        set(PROPERTY_SSFORMWAREHOUSE, ssforMWarehouse);
    }

    public String getSsforRoute() {
        return (String) get(PROPERTY_SSFORROUTE);
    }

    public void setSsforRoute(String ssforRoute) {
        set(PROPERTY_SSFORROUTE, ssforRoute);
    }

    public BusinessPartner getSsforCBpartner() {
        return (BusinessPartner) get(PROPERTY_SSFORCBPARTNER);
    }

    public void setSsforCBpartner(BusinessPartner ssforCBpartner) {
        set(PROPERTY_SSFORCBPARTNER, ssforCBpartner);
    }

    public String getSsxmlGruopIrbp() {
        return (String) get(PROPERTY_SSXMLGRUOPIRBP);
    }

    public void setSsxmlGruopIrbp(String ssxmlGruopIrbp) {
        set(PROPERTY_SSXMLGRUOPIRBP, ssxmlGruopIrbp);
    }

    public BigDecimal getSswhAtsAmount() {
        return (BigDecimal) get(PROPERTY_SSWHATSAMOUNT);
    }

    public void setSswhAtsAmount(BigDecimal sswhAtsAmount) {
        set(PROPERTY_SSWHATSAMOUNT, sswhAtsAmount);
    }

    @SuppressWarnings("unchecked")
    public List<RoleOrganization> getADRoleOrganizationList() {
      return (List<RoleOrganization>) get(PROPERTY_ADROLEORGANIZATIONLIST);
    }

    public void setADRoleOrganizationList(List<RoleOrganization> aDRoleOrganizationList) {
        set(PROPERTY_ADROLEORGANIZATIONLIST, aDRoleOrganizationList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlV> getFinancialMgmtPeriodControlVList() {
      return (List<PeriodControlV>) get(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST);
    }

    public void setFinancialMgmtPeriodControlVList(List<PeriodControlV> financialMgmtPeriodControlVList) {
        set(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST, financialMgmtPeriodControlVList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOS_OrgWarehouseExtra> getOBPOSOrgWarehouseExtraList() {
      return (List<OBPOS_OrgWarehouseExtra>) get(PROPERTY_OBPOSORGWAREHOUSEEXTRALIST);
    }

    public void setOBPOSOrgWarehouseExtraList(List<OBPOS_OrgWarehouseExtra> oBPOSOrgWarehouseExtraList) {
        set(PROPERTY_OBPOSORGWAREHOUSEEXTRALIST, oBPOSOrgWarehouseExtraList);
    }

    @SuppressWarnings("unchecked")
    public List<CashManagementEvents> getOBRETCOCashManagementEventsList() {
      return (List<CashManagementEvents>) get(PROPERTY_OBRETCOCASHMANAGEMENTEVENTSLIST);
    }

    public void setOBRETCOCashManagementEventsList(List<CashManagementEvents> oBRETCOCashManagementEventsList) {
        set(PROPERTY_OBRETCOCASHMANAGEMENTEVENTSLIST, oBRETCOCashManagementEventsList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationList() {
      return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONLIST);
    }

    public void setOrganizationInformationList(List<OrganizationInformation> organizationInformationList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONLIST, organizationInformationList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationModuleV> getOrganizationModuleVList() {
      return (List<OrganizationModuleV>) get(PROPERTY_ORGANIZATIONMODULEVLIST);
    }

    public void setOrganizationModuleVList(List<OrganizationModuleV> organizationModuleVList) {
        set(PROPERTY_ORGANIZATIONMODULEVLIST, organizationModuleVList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationTree> getOrganizationTreeList() {
      return (List<OrganizationTree>) get(PROPERTY_ORGANIZATIONTREELIST);
    }

    public void setOrganizationTreeList(List<OrganizationTree> organizationTreeList) {
        set(PROPERTY_ORGANIZATIONTREELIST, organizationTreeList);
    }

    @SuppressWarnings("unchecked")
    public List<OrgWarehouse> getOrganizationWarehouseList() {
      return (List<OrgWarehouse>) get(PROPERTY_ORGANIZATIONWAREHOUSELIST);
    }

    public void setOrganizationWarehouseList(List<OrgWarehouse> organizationWarehouseList) {
        set(PROPERTY_ORGANIZATIONWAREHOUSELIST, organizationWarehouseList);
    }

    @SuppressWarnings("unchecked")
    public List<SssoinDatesalesprocessV> getSssoinDatesalesprocessVList() {
      return (List<SssoinDatesalesprocessV>) get(PROPERTY_SSSOINDATESALESPROCESSVLIST);
    }

    public void setSssoinDatesalesprocessVList(List<SssoinDatesalesprocessV> sssoinDatesalesprocessVList) {
        set(PROPERTY_SSSOINDATESALESPROCESSVLIST, sssoinDatesalesprocessVList);
    }

}

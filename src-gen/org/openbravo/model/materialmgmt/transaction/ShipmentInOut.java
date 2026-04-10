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
package org.openbravo.model.materialmgmt.transaction;

import com.atrums.indumot.supervision.data.indsupOrdenDespacho;
import com.atrums.indumoto.postventa.data.atindpo_postventa;

import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_PartialDispatch;
import ec.com.sidesoft.projects.complement.SproctmInventorySettl;

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
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.manufacturing.quality.Case;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.materialmgmt.cost.LCReceipt;
import org.openbravo.model.materialmgmt.cost.LandedCostCost;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.ConditionGoods;
import org.openbravo.model.shipping.FreightCategory;
import org.openbravo.model.shipping.ShippingCompany;
/**
 * Entity class for entity MaterialMgmtShipmentInOut (stored in table M_InOut).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ShipmentInOut extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_InOut";
    public static final String ENTITY_NAME = "MaterialMgmtShipmentInOut";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_ORDERDATE = "orderDate";
    public static final String PROPERTY_PRINT = "print";
    public static final String PROPERTY_MOVEMENTTYPE = "movementType";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_DELIVERYTERMS = "deliveryTerms";
    public static final String PROPERTY_FREIGHTCOSTRULE = "freightCostRule";
    public static final String PROPERTY_FREIGHTAMOUNT = "freightAmount";
    public static final String PROPERTY_DELIVERYMETHOD = "deliveryMethod";
    public static final String PROPERTY_SHIPPINGCOMPANY = "shippingCompany";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMOUNT = "chargeAmount";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_CREATELINESFROM = "createLinesFrom";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_SALESREPRESENTATIVE = "salesRepresentative";
    public static final String PROPERTY_NUMBEROFPACKAGES = "numberOfPackages";
    public static final String PROPERTY_PICKDATE = "pickDate";
    public static final String PROPERTY_SHIPDATE = "shipDate";
    public static final String PROPERTY_TRACKINGNO = "trackingNo";
    public static final String PROPERTY_TRXORGANIZATION = "trxOrganization";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_UPDATELINES = "updateLines";
    public static final String PROPERTY_LOGISTIC = "logistic";
    public static final String PROPERTY_GENERATELINES = "generateLines";
    public static final String PROPERTY_CALCULATEFREIGHT = "calculateFreight";
    public static final String PROPERTY_DELIVERYLOCATION = "deliveryLocation";
    public static final String PROPERTY_FREIGHTCATEGORY = "freightCategory";
    public static final String PROPERTY_FREIGHTCURRENCY = "freightCurrency";
    public static final String PROPERTY_RECEIVEMATERIALS = "receiveMaterials";
    public static final String PROPERTY_SENDMATERIALS = "sendMaterials";
    public static final String PROPERTY_CONDITIONGOODS = "conditionGoods";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_PROCESSGOODSJAVA = "processGoodsJava";
    public static final String PROPERTY_ATINDPOPOSTVENTA = "atindpoPostventa";
    public static final String PROPERTY_SLCISHIPPER = "slciShipper";
    public static final String PROPERTY_ISNETTINGSHIPMENT = "isnettingshipment";
    public static final String PROPERTY_COMPLETELYINVOICED = "completelyInvoiced";
    public static final String PROPERTY_SSTPCISCONSWORKP = "sstpcIsconsworkp";
    public static final String PROPERTY_EEISENDTOSRI = "eeiSendToSri";
    public static final String PROPERTY_EEICODIGO = "eeiCodigo";
    public static final String PROPERTY_EEINUMAUTO = "eeiNumauto";
    public static final String PROPERTY_EEIFECHAAUTO = "eeiFechaauto";
    public static final String PROPERTY_EEIURLXML = "eeiUrlxml";
    public static final String PROPERTY_EEIURLRIDE = "eeiUrlride";
    public static final String PROPERTY_EEISTATUS = "eeiStatus";
    public static final String PROPERTY_EEITEMPORALSEND = "eeiTemporalsend";
    public static final String PROPERTY_SLQSGENERATECONTROL = "slqsGenerateControl";
    public static final String PROPERTY_SMVAIENDDATEOFTRANSPORT = "sMVAIEndDateOfTransport";
    public static final String PROPERTY_SWHPASSIGNMENTLOCATOR = "swhpAssignmentLocator";
    public static final String PROPERTY_SMVAICUSTOMCODE = "smvaiCustomcode";
    public static final String PROPERTY_SMVAIROUTE = "smvaiRoute";
    public static final String PROPERTY_SWHPPROCESS = "swhpProcess";
    public static final String PROPERTY_EEIDESCRIPTION = "eeiDescription";
    public static final String PROPERTY_SSPRJPROJECTPRODUCT = "sSPRJProjectProduct";
    public static final String PROPERTY_SSSOINCOMPLETED = "sssoinCompleted";
    public static final String PROPERTY_SSSOINCOMPLETEDBY = "sssoinCompletedby";
    public static final String PROPERTY_EEIDIRORIG = "eeiDirorig";
    public static final String PROPERTY_EEIDIRDEST = "eeiDirdest";
    public static final String PROPERTY_ECSPBCONFIRMATIONS = "ecspbConfirmations";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_LANDEDCOSTCOSTLIST = "landedCostCostList";
    public static final String PROPERTY_LANDEDCOSTRECEIPTLIST = "landedCostReceiptList";
    public static final String PROPERTY_MANUFACTURINGCASEEMSLQSINOUTIDLIST = "manufacturingCaseEMSlqsInoutIDList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYINOUTIDLIST = "manufacturingMeasureShiftEMSpqulyInoutIDList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST = "returnMaterialReceiptPickEditList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST = "returnMaterialShipmentPickEditList";
    public static final String PROPERTY_ECSCBBREAKDOWNLIST = "ecscbBreakdownList";
    public static final String PROPERTY_INDSUPORDDESPLIST = "indsupOrdDespList";
    public static final String PROPERTY_SPROCTMINVENTORYSETTLLIST = "sproctmInventorySettlList";
    public static final String PROPERTY_SSIPOTMPARTIALDISPATCHLIST = "ssipotmPartialDispatchList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_INVOICESTATUS = "invoiceStatus";

    public ShipmentInOut() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTACTION, "CO");
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_PRINT, false);
        setDefaultValue(PROPERTY_DELIVERYTERMS, "A");
        setDefaultValue(PROPERTY_FREIGHTCOSTRULE, "I");
        setDefaultValue(PROPERTY_FREIGHTAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DELIVERYMETHOD, "P");
        setDefaultValue(PROPERTY_CHARGEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRIORITY, "5");
        setDefaultValue(PROPERTY_CREATELINESFROM, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_UPDATELINES, false);
        setDefaultValue(PROPERTY_GENERATELINES, false);
        setDefaultValue(PROPERTY_CALCULATEFREIGHT, false);
        setDefaultValue(PROPERTY_RECEIVEMATERIALS, false);
        setDefaultValue(PROPERTY_SENDMATERIALS, false);
        setDefaultValue(PROPERTY_PROCESSGOODSJAVA, "CO");
        setDefaultValue(PROPERTY_ISNETTINGSHIPMENT, false);
        setDefaultValue(PROPERTY_COMPLETELYINVOICED, false);
        setDefaultValue(PROPERTY_SSTPCISCONSWORKP, false);
        setDefaultValue(PROPERTY_EEISENDTOSRI, false);
        setDefaultValue(PROPERTY_EEITEMPORALSEND, false);
        setDefaultValue(PROPERTY_SLQSGENERATECONTROL, false);
        setDefaultValue(PROPERTY_SWHPPROCESS, false);
        setDefaultValue(PROPERTY_SSPRJPROJECTPRODUCT, false);
        setDefaultValue(PROPERTY_ECSPBCONFIRMATIONS, false);
        setDefaultValue(PROPERTY_LANDEDCOSTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTRECEIPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGCASEEMSLQSINOUTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYINOUTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBBREAKDOWNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INDSUPORDDESPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMINVENTORYSETTLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, new ArrayList<Object>());
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

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public Date getOrderDate() {
        return (Date) get(PROPERTY_ORDERDATE);
    }

    public void setOrderDate(Date orderDate) {
        set(PROPERTY_ORDERDATE, orderDate);
    }

    public Boolean isPrint() {
        return (Boolean) get(PROPERTY_PRINT);
    }

    public void setPrint(Boolean print) {
        set(PROPERTY_PRINT, print);
    }

    public String getMovementType() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementType(String movementType) {
        set(PROPERTY_MOVEMENTTYPE, movementType);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public String getDeliveryTerms() {
        return (String) get(PROPERTY_DELIVERYTERMS);
    }

    public void setDeliveryTerms(String deliveryTerms) {
        set(PROPERTY_DELIVERYTERMS, deliveryTerms);
    }

    public String getFreightCostRule() {
        return (String) get(PROPERTY_FREIGHTCOSTRULE);
    }

    public void setFreightCostRule(String freightCostRule) {
        set(PROPERTY_FREIGHTCOSTRULE, freightCostRule);
    }

    public BigDecimal getFreightAmount() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMOUNT);
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        set(PROPERTY_FREIGHTAMOUNT, freightAmount);
    }

    public String getDeliveryMethod() {
        return (String) get(PROPERTY_DELIVERYMETHOD);
    }

    public void setDeliveryMethod(String deliveryMethod) {
        set(PROPERTY_DELIVERYMETHOD, deliveryMethod);
    }

    public ShippingCompany getShippingCompany() {
        return (ShippingCompany) get(PROPERTY_SHIPPINGCOMPANY);
    }

    public void setShippingCompany(ShippingCompany shippingCompany) {
        set(PROPERTY_SHIPPINGCOMPANY, shippingCompany);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmount() {
        return (BigDecimal) get(PROPERTY_CHARGEAMOUNT);
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        set(PROPERTY_CHARGEAMOUNT, chargeAmount);
    }

    public String getPriority() {
        return (String) get(PROPERTY_PRIORITY);
    }

    public void setPriority(String priority) {
        set(PROPERTY_PRIORITY, priority);
    }

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Boolean isCreateLinesFrom() {
        return (Boolean) get(PROPERTY_CREATELINESFROM);
    }

    public void setCreateLinesFrom(Boolean createLinesFrom) {
        set(PROPERTY_CREATELINESFROM, createLinesFrom);
    }

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public User getSalesRepresentative() {
        return (User) get(PROPERTY_SALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(User salesRepresentative) {
        set(PROPERTY_SALESREPRESENTATIVE, salesRepresentative);
    }

    public Long getNumberOfPackages() {
        return (Long) get(PROPERTY_NUMBEROFPACKAGES);
    }

    public void setNumberOfPackages(Long numberOfPackages) {
        set(PROPERTY_NUMBEROFPACKAGES, numberOfPackages);
    }

    public Date getPickDate() {
        return (Date) get(PROPERTY_PICKDATE);
    }

    public void setPickDate(Date pickDate) {
        set(PROPERTY_PICKDATE, pickDate);
    }

    public Date getShipDate() {
        return (Date) get(PROPERTY_SHIPDATE);
    }

    public void setShipDate(Date shipDate) {
        set(PROPERTY_SHIPDATE, shipDate);
    }

    public String getTrackingNo() {
        return (String) get(PROPERTY_TRACKINGNO);
    }

    public void setTrackingNo(String trackingNo) {
        set(PROPERTY_TRACKINGNO, trackingNo);
    }

    public Organization getTrxOrganization() {
        return (Organization) get(PROPERTY_TRXORGANIZATION);
    }

    public void setTrxOrganization(Organization trxOrganization) {
        set(PROPERTY_TRXORGANIZATION, trxOrganization);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public Boolean isUpdateLines() {
        return (Boolean) get(PROPERTY_UPDATELINES);
    }

    public void setUpdateLines(Boolean updateLines) {
        set(PROPERTY_UPDATELINES, updateLines);
    }

    public Boolean isLogistic() {
        return (Boolean) get(PROPERTY_LOGISTIC);
    }

    public void setLogistic(Boolean logistic) {
        set(PROPERTY_LOGISTIC, logistic);
    }

    public Boolean isGenerateLines() {
        return (Boolean) get(PROPERTY_GENERATELINES);
    }

    public void setGenerateLines(Boolean generateLines) {
        set(PROPERTY_GENERATELINES, generateLines);
    }

    public Boolean isCalculateFreight() {
        return (Boolean) get(PROPERTY_CALCULATEFREIGHT);
    }

    public void setCalculateFreight(Boolean calculateFreight) {
        set(PROPERTY_CALCULATEFREIGHT, calculateFreight);
    }

    public Location getDeliveryLocation() {
        return (Location) get(PROPERTY_DELIVERYLOCATION);
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        set(PROPERTY_DELIVERYLOCATION, deliveryLocation);
    }

    public FreightCategory getFreightCategory() {
        return (FreightCategory) get(PROPERTY_FREIGHTCATEGORY);
    }

    public void setFreightCategory(FreightCategory freightCategory) {
        set(PROPERTY_FREIGHTCATEGORY, freightCategory);
    }

    public Currency getFreightCurrency() {
        return (Currency) get(PROPERTY_FREIGHTCURRENCY);
    }

    public void setFreightCurrency(Currency freightCurrency) {
        set(PROPERTY_FREIGHTCURRENCY, freightCurrency);
    }

    public Boolean isReceiveMaterials() {
        return (Boolean) get(PROPERTY_RECEIVEMATERIALS);
    }

    public void setReceiveMaterials(Boolean receiveMaterials) {
        set(PROPERTY_RECEIVEMATERIALS, receiveMaterials);
    }

    public Boolean isSendMaterials() {
        return (Boolean) get(PROPERTY_SENDMATERIALS);
    }

    public void setSendMaterials(Boolean sendMaterials) {
        set(PROPERTY_SENDMATERIALS, sendMaterials);
    }

    public ConditionGoods getConditionGoods() {
        return (ConditionGoods) get(PROPERTY_CONDITIONGOODS);
    }

    public void setConditionGoods(ConditionGoods conditionGoods) {
        set(PROPERTY_CONDITIONGOODS, conditionGoods);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public String getProcessGoodsJava() {
        return (String) get(PROPERTY_PROCESSGOODSJAVA);
    }

    public void setProcessGoodsJava(String processGoodsJava) {
        set(PROPERTY_PROCESSGOODSJAVA, processGoodsJava);
    }

    public atindpo_postventa getAtindpoPostventa() {
        return (atindpo_postventa) get(PROPERTY_ATINDPOPOSTVENTA);
    }

    public void setAtindpoPostventa(atindpo_postventa atindpoPostventa) {
        set(PROPERTY_ATINDPOPOSTVENTA, atindpoPostventa);
    }

    public ShippingCompany getSlciShipper() {
        return (ShippingCompany) get(PROPERTY_SLCISHIPPER);
    }

    public void setSlciShipper(ShippingCompany slciShipper) {
        set(PROPERTY_SLCISHIPPER, slciShipper);
    }

    public Boolean isNettingshipment() {
        return (Boolean) get(PROPERTY_ISNETTINGSHIPMENT);
    }

    public void setNettingshipment(Boolean isnettingshipment) {
        set(PROPERTY_ISNETTINGSHIPMENT, isnettingshipment);
    }

    public Boolean isCompletelyInvoiced() {
        return (Boolean) get(PROPERTY_COMPLETELYINVOICED);
    }

    public void setCompletelyInvoiced(Boolean completelyInvoiced) {
        set(PROPERTY_COMPLETELYINVOICED, completelyInvoiced);
    }

    public Boolean isSstpcIsconsworkp() {
        return (Boolean) get(PROPERTY_SSTPCISCONSWORKP);
    }

    public void setSstpcIsconsworkp(Boolean sstpcIsconsworkp) {
        set(PROPERTY_SSTPCISCONSWORKP, sstpcIsconsworkp);
    }

    public Boolean isEeiSendToSri() {
        return (Boolean) get(PROPERTY_EEISENDTOSRI);
    }

    public void setEeiSendToSri(Boolean eeiSendToSri) {
        set(PROPERTY_EEISENDTOSRI, eeiSendToSri);
    }

    public String getEeiCodigo() {
        return (String) get(PROPERTY_EEICODIGO);
    }

    public void setEeiCodigo(String eeiCodigo) {
        set(PROPERTY_EEICODIGO, eeiCodigo);
    }

    public String getEeiNumauto() {
        return (String) get(PROPERTY_EEINUMAUTO);
    }

    public void setEeiNumauto(String eeiNumauto) {
        set(PROPERTY_EEINUMAUTO, eeiNumauto);
    }

    public Date getEeiFechaauto() {
        return (Date) get(PROPERTY_EEIFECHAAUTO);
    }

    public void setEeiFechaauto(Date eeiFechaauto) {
        set(PROPERTY_EEIFECHAAUTO, eeiFechaauto);
    }

    public String getEeiUrlxml() {
        return (String) get(PROPERTY_EEIURLXML);
    }

    public void setEeiUrlxml(String eeiUrlxml) {
        set(PROPERTY_EEIURLXML, eeiUrlxml);
    }

    public String getEeiUrlride() {
        return (String) get(PROPERTY_EEIURLRIDE);
    }

    public void setEeiUrlride(String eeiUrlride) {
        set(PROPERTY_EEIURLRIDE, eeiUrlride);
    }

    public String getEeiStatus() {
        return (String) get(PROPERTY_EEISTATUS);
    }

    public void setEeiStatus(String eeiStatus) {
        set(PROPERTY_EEISTATUS, eeiStatus);
    }

    public Boolean isEeiTemporalsend() {
        return (Boolean) get(PROPERTY_EEITEMPORALSEND);
    }

    public void setEeiTemporalsend(Boolean eeiTemporalsend) {
        set(PROPERTY_EEITEMPORALSEND, eeiTemporalsend);
    }

    public Boolean isSlqsGenerateControl() {
        return (Boolean) get(PROPERTY_SLQSGENERATECONTROL);
    }

    public void setSlqsGenerateControl(Boolean slqsGenerateControl) {
        set(PROPERTY_SLQSGENERATECONTROL, slqsGenerateControl);
    }

    public Date getSMVAIEndDateOfTransport() {
        return (Date) get(PROPERTY_SMVAIENDDATEOFTRANSPORT);
    }

    public void setSMVAIEndDateOfTransport(Date sMVAIEndDateOfTransport) {
        set(PROPERTY_SMVAIENDDATEOFTRANSPORT, sMVAIEndDateOfTransport);
    }

    public String getSwhpAssignmentLocator() {
        return (String) get(PROPERTY_SWHPASSIGNMENTLOCATOR);
    }

    public void setSwhpAssignmentLocator(String swhpAssignmentLocator) {
        set(PROPERTY_SWHPASSIGNMENTLOCATOR, swhpAssignmentLocator);
    }

    public String getSmvaiCustomcode() {
        return (String) get(PROPERTY_SMVAICUSTOMCODE);
    }

    public void setSmvaiCustomcode(String smvaiCustomcode) {
        set(PROPERTY_SMVAICUSTOMCODE, smvaiCustomcode);
    }

    public String getSmvaiRoute() {
        return (String) get(PROPERTY_SMVAIROUTE);
    }

    public void setSmvaiRoute(String smvaiRoute) {
        set(PROPERTY_SMVAIROUTE, smvaiRoute);
    }

    public Boolean isSwhpProcess() {
        return (Boolean) get(PROPERTY_SWHPPROCESS);
    }

    public void setSwhpProcess(Boolean swhpProcess) {
        set(PROPERTY_SWHPPROCESS, swhpProcess);
    }

    public String getEeiDescription() {
        return (String) get(PROPERTY_EEIDESCRIPTION);
    }

    public void setEeiDescription(String eeiDescription) {
        set(PROPERTY_EEIDESCRIPTION, eeiDescription);
    }

    public Boolean isSSPRJProjectProduct() {
        return (Boolean) get(PROPERTY_SSPRJPROJECTPRODUCT);
    }

    public void setSSPRJProjectProduct(Boolean sSPRJProjectProduct) {
        set(PROPERTY_SSPRJPROJECTPRODUCT, sSPRJProjectProduct);
    }

    public Date getSssoinCompleted() {
        return (Date) get(PROPERTY_SSSOINCOMPLETED);
    }

    public void setSssoinCompleted(Date sssoinCompleted) {
        set(PROPERTY_SSSOINCOMPLETED, sssoinCompleted);
    }

    public User getSssoinCompletedby() {
        return (User) get(PROPERTY_SSSOINCOMPLETEDBY);
    }

    public void setSssoinCompletedby(User sssoinCompletedby) {
        set(PROPERTY_SSSOINCOMPLETEDBY, sssoinCompletedby);
    }

    public String getEeiDirorig() {
        return (String) get(PROPERTY_EEIDIRORIG);
    }

    public void setEeiDirorig(String eeiDirorig) {
        set(PROPERTY_EEIDIRORIG, eeiDirorig);
    }

    public String getEeiDirdest() {
        return (String) get(PROPERTY_EEIDIRDEST);
    }

    public void setEeiDirdest(String eeiDirdest) {
        set(PROPERTY_EEIDIRDEST, eeiDirdest);
    }

    public Boolean isEcspbConfirmations() {
        return (Boolean) get(PROPERTY_ECSPBCONFIRMATIONS);
    }

    public void setEcspbConfirmations(Boolean ecspbConfirmations) {
        set(PROPERTY_ECSPBCONFIRMATIONS, ecspbConfirmations);
    }

    public BigDecimal getInvoiceStatus() {
        return (BigDecimal) get(COMPUTED_COLUMN_INVOICESTATUS);
    }

    public void setInvoiceStatus(BigDecimal invoiceStatus) {
        set(COMPUTED_COLUMN_INVOICESTATUS, invoiceStatus);
    }

    public ShipmentInOut_ComputedColumns get_computedColumns() {
        return (ShipmentInOut_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(ShipmentInOut_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostCost> getLandedCostCostList() {
      return (List<LandedCostCost>) get(PROPERTY_LANDEDCOSTCOSTLIST);
    }

    public void setLandedCostCostList(List<LandedCostCost> landedCostCostList) {
        set(PROPERTY_LANDEDCOSTCOSTLIST, landedCostCostList);
    }

    @SuppressWarnings("unchecked")
    public List<LCReceipt> getLandedCostReceiptList() {
      return (List<LCReceipt>) get(PROPERTY_LANDEDCOSTRECEIPTLIST);
    }

    public void setLandedCostReceiptList(List<LCReceipt> landedCostReceiptList) {
        set(PROPERTY_LANDEDCOSTRECEIPTLIST, landedCostReceiptList);
    }

    @SuppressWarnings("unchecked")
    public List<Case> getManufacturingCaseEMSlqsInoutIDList() {
      return (List<Case>) get(PROPERTY_MANUFACTURINGCASEEMSLQSINOUTIDLIST);
    }

    public void setManufacturingCaseEMSlqsInoutIDList(List<Case> manufacturingCaseEMSlqsInoutIDList) {
        set(PROPERTY_MANUFACTURINGCASEEMSLQSINOUTIDLIST, manufacturingCaseEMSlqsInoutIDList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMSpqulyInoutIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYINOUTIDLIST);
    }

    public void setManufacturingMeasureShiftEMSpqulyInoutIDList(List<MeasureShift> manufacturingMeasureShiftEMSpqulyInoutIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYINOUTIDLIST, manufacturingMeasureShiftEMSpqulyInoutIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialReceiptPickEdit> getReturnMaterialReceiptPickEditList() {
      return (List<ReturnMaterialReceiptPickEdit>) get(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST);
    }

    public void setReturnMaterialReceiptPickEditList(List<ReturnMaterialReceiptPickEdit> returnMaterialReceiptPickEditList) {
        set(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, returnMaterialReceiptPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialShipmentPickEdit> getReturnMaterialShipmentPickEditList() {
      return (List<ReturnMaterialShipmentPickEdit>) get(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST);
    }

    public void setReturnMaterialShipmentPickEditList(List<ReturnMaterialShipmentPickEdit> returnMaterialShipmentPickEditList) {
        set(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, returnMaterialShipmentPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_breakdown> getEcscbBreakdownList() {
      return (List<ecscb_breakdown>) get(PROPERTY_ECSCBBREAKDOWNLIST);
    }

    public void setEcscbBreakdownList(List<ecscb_breakdown> ecscbBreakdownList) {
        set(PROPERTY_ECSCBBREAKDOWNLIST, ecscbBreakdownList);
    }

    @SuppressWarnings("unchecked")
    public List<indsupOrdenDespacho> getIndsupOrdDespList() {
      return (List<indsupOrdenDespacho>) get(PROPERTY_INDSUPORDDESPLIST);
    }

    public void setIndsupOrdDespList(List<indsupOrdenDespacho> indsupOrdDespList) {
        set(PROPERTY_INDSUPORDDESPLIST, indsupOrdDespList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmInventorySettl> getSproctmInventorySettlList() {
      return (List<SproctmInventorySettl>) get(PROPERTY_SPROCTMINVENTORYSETTLLIST);
    }

    public void setSproctmInventorySettlList(List<SproctmInventorySettl> sproctmInventorySettlList) {
        set(PROPERTY_SPROCTMINVENTORYSETTLLIST, sproctmInventorySettlList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_PartialDispatch> getSsipotmPartialDispatchList() {
      return (List<Ssipotm_PartialDispatch>) get(PROPERTY_SSIPOTMPARTIALDISPATCHLIST);
    }

    public void setSsipotmPartialDispatchList(List<Ssipotm_PartialDispatch> ssipotmPartialDispatchList) {
        set(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, ssipotmPartialDispatchList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_INVOICESTATUS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getInvoiceStatus();
      }
    
      return super.get(propName);
    }
}

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
package org.openbravo.model.common.order;

import com.sidesoft.inventory.movement.frominvoice.Sinvmin_SquareBill;
import com.sidesoft.localization.ecuador.invoices.Sfpsi_ReconcileSalesOrderV;

import ec.com.sidesoft.backoffice.discount.SsbodGiftOrder;
import ec.com.sidesoft.commission.standard.scomst_unpaid_commission;
import ec.com.sidesoft.custom.mrp.forecast.ScmfPendingOrdersTmp;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_OrderLine;
import ec.com.sidesoft.localization.importdata.loadvouchers.Imdlv_Lines;
import ec.com.sidesoft.settlement.project.cost.SstpcConsumptionView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.OrderLineTax;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.enterprise.WarehouseRule;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.materialmgmt.onhandquantity.PrereservationManualPickEdit;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.onhandquantity.ReservationStock;
import org.openbravo.model.materialmgmt.onhandquantity.ReservedGoodMovementPickEdit;
import org.openbravo.model.materialmgmt.onhandquantity.SOLReservedStock;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialReceiptPickEdit;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialShipmentPickEdit;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.mrp.ProductionRunLine;
import org.openbravo.model.mrp.PurchasingRunLine;
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;
import org.openbravo.model.procurement.POInvoiceMatch;
import org.openbravo.model.procurement.RequisitionPOMatch;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.CommissionDetail;
import org.openbravo.model.shipping.ShippingCompany;
import org.openbravo.model.timeandexpense.ResourceAssignment;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardInst;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardTrans;
/**
 * Entity class for entity OrderLine (stored in table C_OrderLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OrderLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_OrderLine";
    public static final String ENTITY_NAME = "OrderLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_ORDERDATE = "orderDate";
    public static final String PROPERTY_SCHEDULEDDELIVERYDATE = "scheduledDeliveryDate";
    public static final String PROPERTY_DATEDELIVERED = "dateDelivered";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_DIRECTSHIPMENT = "directShipment";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ORDEREDQUANTITY = "orderedQuantity";
    public static final String PROPERTY_RESERVEDQUANTITY = "reservedQuantity";
    public static final String PROPERTY_DELIVEREDQUANTITY = "deliveredQuantity";
    public static final String PROPERTY_INVOICEDQUANTITY = "invoicedQuantity";
    public static final String PROPERTY_SHIPPINGCOMPANY = "shippingCompany";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_LISTPRICE = "listPrice";
    public static final String PROPERTY_UNITPRICE = "unitPrice";
    public static final String PROPERTY_PRICELIMIT = "priceLimit";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_FREIGHTAMOUNT = "freightAmount";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMOUNT = "chargeAmount";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_RESOURCEASSIGNMENT = "resourceAssignment";
    public static final String PROPERTY_SOPOREFERENCE = "sOPOReference";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_DESCRIPTIONONLY = "descriptionOnly";
    public static final String PROPERTY_ORDERQUANTITY = "orderQuantity";
    public static final String PROPERTY_ORDERUOM = "orderUOM";
    public static final String PROPERTY_PRICEADJUSTMENT = "priceAdjustment";
    public static final String PROPERTY_STANDARDPRICE = "standardPrice";
    public static final String PROPERTY_CANCELPRICEADJUSTMENT = "cancelPriceAdjustment";
    public static final String PROPERTY_ORDERDISCOUNT = "orderDiscount";
    public static final String PROPERTY_EDITLINEAMOUNT = "editLineAmount";
    public static final String PROPERTY_TAXABLEAMOUNT = "taxableAmount";
    public static final String PROPERTY_GOODSSHIPMENTLINE = "goodsShipmentLine";
    public static final String PROPERTY_RETURNREASON = "returnReason";
    public static final String PROPERTY_GROSSUNITPRICE = "grossUnitPrice";
    public static final String PROPERTY_LINEGROSSAMOUNT = "lineGrossAmount";
    public static final String PROPERTY_GROSSLISTPRICE = "grossListPrice";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_BASEGROSSUNITPRICE = "baseGrossUnitPrice";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_WAREHOUSERULE = "warehouseRule";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_QUOTATIONLINE = "quotationLine";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_CREATERESERVATION = "createReservation";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_RESERVATIONSTATUS = "reservationStatus";
    public static final String PROPERTY_MANAGERESERVATION = "manageReservation";
    public static final String PROPERTY_MANAGEPRERESERVATION = "managePrereservation";
    public static final String PROPERTY_EXPLODE = "explode";
    public static final String PROPERTY_BOMPARENT = "bOMParent";
    public static final String PROPERTY_OBPOSEPCCODE = "obposEpccode";
    public static final String PROPERTY_OBPOSISDELETED = "obposIsDeleted";
    public static final String PROPERTY_REPLACEDORDERLINE = "replacedorderline";
    public static final String PROPERTY_OBPOSQTYDELETED = "obposQtyDeleted";
    public static final String PROPERTY_OBPOSSERIALNUMBER = "obposSerialNumber";
    public static final String PROPERTY_PRINTDESCRIPTION = "printDescription";
    public static final String PROPERTY_OVERDUERETURNDAYS = "overdueReturnDays";
    public static final String PROPERTY_SELECTORDERLINE = "selectOrderLine";
    public static final String PROPERTY_OPERATIVEUOM = "operativeUOM";
    public static final String PROPERTY_OBPOSSERVICEPROPOSED = "obposServiceProposed";
    public static final String PROPERTY_OPERATIVEQUANTITY = "operativeQuantity";
    public static final String PROPERTY_SSIPOTMACCUMULATE = "ssipotmAccumulate";
    public static final String PROPERTY_SPRLIIDENTIFIER = "sprliIdentifier";
    public static final String PROPERTY_SSIPCOSTORIGIN = "ssipCostorigin";
    public static final String PROPERTY_SSIPREALCOST = "ssipRealcost";
    public static final String PROPERTY_SSBODADDGIFTS = "ssbodAddGifts";
    public static final String PROPERTY_SSIPCUSTOMER = "ssipCustomer";
    public static final String PROPERTY_SSIPSELLER = "ssipSeller";
    public static final String PROPERTY_SPROCTMADIMGTASK = "sproctmAdImgTask";
    public static final String PROPERTY_SSIPIDENTIFIER = "ssipIdentifier";
    public static final String PROPERTY_SSIPPRELIQUIDATED = "ssipPreliquidated";
    public static final String PROPERTY_SSFPSQTYORDERED = "ssfpsQtyordered";
    public static final String PROPERTY_SSIPICEVALUEICE = "ssipiceValueIce";
    public static final String PROPERTY_SSBODDISCOUNTRATE = "ssbodDiscountRate";
    public static final String PROPERTY_SSFPSQTYDELIVERED = "ssfpsQtydelivered";
    public static final String PROPERTY_SSFPSQTYINVOICED = "ssfpsQtyinvoiced";
    public static final String PROPERTY_ECSSREXECRESERVEBACKGRD = "ecssrExecreservebackgrd";
    public static final String PROPERTY_ATVEFCUOTA = "atvefCuota";
    public static final String PROPERTY_ATVEFENTRADA = "atvefEntrada";
    public static final String PROPERTY_ATVEFFINANCIAMIENTO = "atvefFinanciamiento";
    public static final String PROPERTY_ATVEFPRODUCT2 = "atvefProduct2";
    public static final String PROPERTY_ATVEFVALORCUOTA = "atvefValorcuota";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_GCNVGIFTCARDINSTLIST = "gCNVGiftCardInstList";
    public static final String PROPERTY_GCNVGIFTCARDTRANSLIST = "gCNVGiftCardTransList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_MRPPRODUCTIONRUNLINELIST = "mRPProductionRunLineList";
    public static final String PROPERTY_MRPPURCHASINGRUNLINELIST = "mRPPurchasingRunLineList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODORDERLINEIDLIST = "manufacturingMeasureShiftEMCrprodOrderlineIDList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONSTOCKLIST = "materialMgmtReservationStockList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_ORDERLINESOPOREFERENCELIST = "orderLineSOPOReferenceList";
    public static final String PROPERTY_ORDERLINEQUOTATIONLINELIST = "orderLineQuotationLineList";
    public static final String PROPERTY_ORDERLINEBOMPARENTIDLIST = "orderLineBOMParentIDList";
    public static final String PROPERTY_ORDERLINEREPLACEDORDERLINELIST = "orderLineReplacedorderlineList";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_ORDERLINEOFFERLIST = "orderLineOfferList";
    public static final String PROPERTY_ORDERLINETAXLIST = "orderLineTaxList";
    public static final String PROPERTY_ORDERLINESERVICERELATIONLIST = "orderlineServiceRelationList";
    public static final String PROPERTY_ORDERLINESERVICERELATIONCORDERLINERELATEDIDLIST = "orderlineServiceRelationCOrderlineRelatedIDList";
    public static final String PROPERTY_PRERESERVATIONMANUALPICKEDITPURCHASEORDERLINELIST = "prereservationManualPickEditPurchaseOrderLineList";
    public static final String PROPERTY_PRERESERVATIONMANUALPICKEDITSALESORDERLINELIST = "prereservationManualPickEditSalesOrderLineList";
    public static final String PROPERTY_PROCUREMENTPOINVOICEMATCHLIST = "procurementPOInvoiceMatchList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST = "procurementRequisitionPOMatchList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST = "returnMaterialReceiptPickEditList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST = "returnMaterialShipmentPickEditList";
    public static final String PROPERTY_SOLRESERVEDSTOCKLIST = "sOLReservedStockList";
    public static final String PROPERTY_SALESCOMMISSIONDETAILLIST = "salesCommissionDetailList";
    public static final String PROPERTY_SSBODGIFTORDERLIST = "ssbodGiftOrderList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";
    public static final String PROPERTY_RESERVEDGOODMNTPICKEDITLIST = "reservedgoodmntPickEditList";
    public static final String PROPERTY_SCMFPENDINGORDERSTMPLIST = "scmfPendingordersTmpList";
    public static final String PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST = "scomstUnpaidCommissionList";
    public static final String PROPERTY_SFPSIRECONCILESOVLIST = "sfpsiReconcileSoVList";
    public static final String PROPERTY_SINVMINSQUAREBILLLIST = "sinvminSquareBillList";
    public static final String PROPERTY_SSIPOTMORDERLINELIST = "ssipotmOrderlineList";
    public static final String PROPERTY_SSTPCPRELIQVLIST = "sstpcPreliqVList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_SICUSRESERVEDQUANTITY = "sICUSReservedQuantity";

    public OrderLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DIRECTSHIPMENT, false);
        setDefaultValue(PROPERTY_ORDEREDQUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_DISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CHARGEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DESCRIPTIONONLY, false);
        setDefaultValue(PROPERTY_STANDARDPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_CANCELPRICEADJUSTMENT, false);
        setDefaultValue(PROPERTY_EDITLINEAMOUNT, false);
        setDefaultValue(PROPERTY_GROSSUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_LINEGROSSAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASEGROSSUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MANAGERESERVATION, false);
        setDefaultValue(PROPERTY_MANAGEPRERESERVATION, false);
        setDefaultValue(PROPERTY_EXPLODE, false);
        setDefaultValue(PROPERTY_OBPOSISDELETED, false);
        setDefaultValue(PROPERTY_PRINTDESCRIPTION, false);
        setDefaultValue(PROPERTY_SELECTORDERLINE, false);
        setDefaultValue(PROPERTY_OBPOSSERVICEPROPOSED, false);
        setDefaultValue(PROPERTY_SSIPOTMACCUMULATE, false);
        setDefaultValue(PROPERTY_SSBODADDGIFTS, false);
        setDefaultValue(PROPERTY_SSIPPRELIQUIDATED, false);
        setDefaultValue(PROPERTY_SSBODDISCOUNTRATE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ECSSREXECRESERVEBACKGRD, false);
        setDefaultValue(PROPERTY_ATVEFCUOTA, (long) 0);
        setDefaultValue(PROPERTY_ATVEFENTRADA, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATVEFVALORCUOTA, new BigDecimal(0));
        setDefaultValue(PROPERTY_GCNVGIFTCARDINSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDTRANSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPRODUCTIONRUNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODORDERLINEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONSTOCKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINESOPOREFERENCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEQUOTATIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEBOMPARENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEREPLACEDORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEOFFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINESERVICERELATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINESERVICERELATIONCORDERLINERELATEDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRERESERVATIONMANUALPICKEDITPURCHASEORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRERESERVATIONMANUALPICKEDITSALESORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SOLRESERVEDSTOCKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RESERVEDGOODMNTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPENDINGORDERSTMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPSIRECONCILESOVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SINVMINSQUAREBILLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPRELIQVLIST, new ArrayList<Object>());
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

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
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

    public Date getOrderDate() {
        return (Date) get(PROPERTY_ORDERDATE);
    }

    public void setOrderDate(Date orderDate) {
        set(PROPERTY_ORDERDATE, orderDate);
    }

    public Date getScheduledDeliveryDate() {
        return (Date) get(PROPERTY_SCHEDULEDDELIVERYDATE);
    }

    public void setScheduledDeliveryDate(Date scheduledDeliveryDate) {
        set(PROPERTY_SCHEDULEDDELIVERYDATE, scheduledDeliveryDate);
    }

    public Date getDateDelivered() {
        return (Date) get(PROPERTY_DATEDELIVERED);
    }

    public void setDateDelivered(Date dateDelivered) {
        set(PROPERTY_DATEDELIVERED, dateDelivered);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Boolean isDirectShipment() {
        return (Boolean) get(PROPERTY_DIRECTSHIPMENT);
    }

    public void setDirectShipment(Boolean directShipment) {
        set(PROPERTY_DIRECTSHIPMENT, directShipment);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getOrderedQuantity() {
        return (BigDecimal) get(PROPERTY_ORDEREDQUANTITY);
    }

    public void setOrderedQuantity(BigDecimal orderedQuantity) {
        set(PROPERTY_ORDEREDQUANTITY, orderedQuantity);
    }

    public BigDecimal getReservedQuantity() {
        return (BigDecimal) get(PROPERTY_RESERVEDQUANTITY);
    }

    public void setReservedQuantity(BigDecimal reservedQuantity) {
        set(PROPERTY_RESERVEDQUANTITY, reservedQuantity);
    }

    public BigDecimal getDeliveredQuantity() {
        return (BigDecimal) get(PROPERTY_DELIVEREDQUANTITY);
    }

    public void setDeliveredQuantity(BigDecimal deliveredQuantity) {
        set(PROPERTY_DELIVEREDQUANTITY, deliveredQuantity);
    }

    public BigDecimal getInvoicedQuantity() {
        return (BigDecimal) get(PROPERTY_INVOICEDQUANTITY);
    }

    public void setInvoicedQuantity(BigDecimal invoicedQuantity) {
        set(PROPERTY_INVOICEDQUANTITY, invoicedQuantity);
    }

    public ShippingCompany getShippingCompany() {
        return (ShippingCompany) get(PROPERTY_SHIPPINGCOMPANY);
    }

    public void setShippingCompany(ShippingCompany shippingCompany) {
        set(PROPERTY_SHIPPINGCOMPANY, shippingCompany);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getListPrice() {
        return (BigDecimal) get(PROPERTY_LISTPRICE);
    }

    public void setListPrice(BigDecimal listPrice) {
        set(PROPERTY_LISTPRICE, listPrice);
    }

    public BigDecimal getUnitPrice() {
        return (BigDecimal) get(PROPERTY_UNITPRICE);
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        set(PROPERTY_UNITPRICE, unitPrice);
    }

    public BigDecimal getPriceLimit() {
        return (BigDecimal) get(PROPERTY_PRICELIMIT);
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        set(PROPERTY_PRICELIMIT, priceLimit);
    }

    public BigDecimal getLineNetAmount() {
        return (BigDecimal) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(BigDecimal lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
    }

    public BigDecimal getFreightAmount() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMOUNT);
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        set(PROPERTY_FREIGHTAMOUNT, freightAmount);
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

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public ResourceAssignment getResourceAssignment() {
        return (ResourceAssignment) get(PROPERTY_RESOURCEASSIGNMENT);
    }

    public void setResourceAssignment(ResourceAssignment resourceAssignment) {
        set(PROPERTY_RESOURCEASSIGNMENT, resourceAssignment);
    }

    public OrderLine getSOPOReference() {
        return (OrderLine) get(PROPERTY_SOPOREFERENCE);
    }

    public void setSOPOReference(OrderLine sOPOReference) {
        set(PROPERTY_SOPOREFERENCE, sOPOReference);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public Boolean isDescriptionOnly() {
        return (Boolean) get(PROPERTY_DESCRIPTIONONLY);
    }

    public void setDescriptionOnly(Boolean descriptionOnly) {
        set(PROPERTY_DESCRIPTIONONLY, descriptionOnly);
    }

    public BigDecimal getOrderQuantity() {
        return (BigDecimal) get(PROPERTY_ORDERQUANTITY);
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        set(PROPERTY_ORDERQUANTITY, orderQuantity);
    }

    public ProductUOM getOrderUOM() {
        return (ProductUOM) get(PROPERTY_ORDERUOM);
    }

    public void setOrderUOM(ProductUOM orderUOM) {
        set(PROPERTY_ORDERUOM, orderUOM);
    }

    public PriceAdjustment getPriceAdjustment() {
        return (PriceAdjustment) get(PROPERTY_PRICEADJUSTMENT);
    }

    public void setPriceAdjustment(PriceAdjustment priceAdjustment) {
        set(PROPERTY_PRICEADJUSTMENT, priceAdjustment);
    }

    public BigDecimal getStandardPrice() {
        return (BigDecimal) get(PROPERTY_STANDARDPRICE);
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        set(PROPERTY_STANDARDPRICE, standardPrice);
    }

    public Boolean isCancelPriceAdjustment() {
        return (Boolean) get(PROPERTY_CANCELPRICEADJUSTMENT);
    }

    public void setCancelPriceAdjustment(Boolean cancelPriceAdjustment) {
        set(PROPERTY_CANCELPRICEADJUSTMENT, cancelPriceAdjustment);
    }

    public OrderDiscount getOrderDiscount() {
        return (OrderDiscount) get(PROPERTY_ORDERDISCOUNT);
    }

    public void setOrderDiscount(OrderDiscount orderDiscount) {
        set(PROPERTY_ORDERDISCOUNT, orderDiscount);
    }

    public Boolean isEditLineAmount() {
        return (Boolean) get(PROPERTY_EDITLINEAMOUNT);
    }

    public void setEditLineAmount(Boolean editLineAmount) {
        set(PROPERTY_EDITLINEAMOUNT, editLineAmount);
    }

    public BigDecimal getTaxableAmount() {
        return (BigDecimal) get(PROPERTY_TAXABLEAMOUNT);
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        set(PROPERTY_TAXABLEAMOUNT, taxableAmount);
    }

    public ShipmentInOutLine getGoodsShipmentLine() {
        return (ShipmentInOutLine) get(PROPERTY_GOODSSHIPMENTLINE);
    }

    public void setGoodsShipmentLine(ShipmentInOutLine goodsShipmentLine) {
        set(PROPERTY_GOODSSHIPMENTLINE, goodsShipmentLine);
    }

    public ReturnReason getReturnReason() {
        return (ReturnReason) get(PROPERTY_RETURNREASON);
    }

    public void setReturnReason(ReturnReason returnReason) {
        set(PROPERTY_RETURNREASON, returnReason);
    }

    public BigDecimal getGrossUnitPrice() {
        return (BigDecimal) get(PROPERTY_GROSSUNITPRICE);
    }

    public void setGrossUnitPrice(BigDecimal grossUnitPrice) {
        set(PROPERTY_GROSSUNITPRICE, grossUnitPrice);
    }

    public BigDecimal getLineGrossAmount() {
        return (BigDecimal) get(PROPERTY_LINEGROSSAMOUNT);
    }

    public void setLineGrossAmount(BigDecimal lineGrossAmount) {
        set(PROPERTY_LINEGROSSAMOUNT, lineGrossAmount);
    }

    public BigDecimal getGrossListPrice() {
        return (BigDecimal) get(PROPERTY_GROSSLISTPRICE);
    }

    public void setGrossListPrice(BigDecimal grossListPrice) {
        set(PROPERTY_GROSSLISTPRICE, grossListPrice);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public BigDecimal getBaseGrossUnitPrice() {
        return (BigDecimal) get(PROPERTY_BASEGROSSUNITPRICE);
    }

    public void setBaseGrossUnitPrice(BigDecimal baseGrossUnitPrice) {
        set(PROPERTY_BASEGROSSUNITPRICE, baseGrossUnitPrice);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public WarehouseRule getWarehouseRule() {
        return (WarehouseRule) get(PROPERTY_WAREHOUSERULE);
    }

    public void setWarehouseRule(WarehouseRule warehouseRule) {
        set(PROPERTY_WAREHOUSERULE, warehouseRule);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public OrderLine getQuotationLine() {
        return (OrderLine) get(PROPERTY_QUOTATIONLINE);
    }

    public void setQuotationLine(OrderLine quotationLine) {
        set(PROPERTY_QUOTATIONLINE, quotationLine);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public String getCreateReservation() {
        return (String) get(PROPERTY_CREATERESERVATION);
    }

    public void setCreateReservation(String createReservation) {
        set(PROPERTY_CREATERESERVATION, createReservation);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getReservationStatus() {
        return (String) get(PROPERTY_RESERVATIONSTATUS);
    }

    public void setReservationStatus(String reservationStatus) {
        set(PROPERTY_RESERVATIONSTATUS, reservationStatus);
    }

    public Boolean isManageReservation() {
        return (Boolean) get(PROPERTY_MANAGERESERVATION);
    }

    public void setManageReservation(Boolean manageReservation) {
        set(PROPERTY_MANAGERESERVATION, manageReservation);
    }

    public Boolean isManagePrereservation() {
        return (Boolean) get(PROPERTY_MANAGEPRERESERVATION);
    }

    public void setManagePrereservation(Boolean managePrereservation) {
        set(PROPERTY_MANAGEPRERESERVATION, managePrereservation);
    }

    public Boolean isExplode() {
        return (Boolean) get(PROPERTY_EXPLODE);
    }

    public void setExplode(Boolean explode) {
        set(PROPERTY_EXPLODE, explode);
    }

    public OrderLine getBOMParent() {
        return (OrderLine) get(PROPERTY_BOMPARENT);
    }

    public void setBOMParent(OrderLine bOMParent) {
        set(PROPERTY_BOMPARENT, bOMParent);
    }

    public String getObposEpccode() {
        return (String) get(PROPERTY_OBPOSEPCCODE);
    }

    public void setObposEpccode(String obposEpccode) {
        set(PROPERTY_OBPOSEPCCODE, obposEpccode);
    }

    public Boolean isObposIsDeleted() {
        return (Boolean) get(PROPERTY_OBPOSISDELETED);
    }

    public void setObposIsDeleted(Boolean obposIsDeleted) {
        set(PROPERTY_OBPOSISDELETED, obposIsDeleted);
    }

    public OrderLine getReplacedorderline() {
        return (OrderLine) get(PROPERTY_REPLACEDORDERLINE);
    }

    public void setReplacedorderline(OrderLine replacedorderline) {
        set(PROPERTY_REPLACEDORDERLINE, replacedorderline);
    }

    public BigDecimal getObposQtyDeleted() {
        return (BigDecimal) get(PROPERTY_OBPOSQTYDELETED);
    }

    public void setObposQtyDeleted(BigDecimal obposQtyDeleted) {
        set(PROPERTY_OBPOSQTYDELETED, obposQtyDeleted);
    }

    public String getObposSerialNumber() {
        return (String) get(PROPERTY_OBPOSSERIALNUMBER);
    }

    public void setObposSerialNumber(String obposSerialNumber) {
        set(PROPERTY_OBPOSSERIALNUMBER, obposSerialNumber);
    }

    public Boolean isPrintDescription() {
        return (Boolean) get(PROPERTY_PRINTDESCRIPTION);
    }

    public void setPrintDescription(Boolean printDescription) {
        set(PROPERTY_PRINTDESCRIPTION, printDescription);
    }

    public Long getOverdueReturnDays() {
        return (Long) get(PROPERTY_OVERDUERETURNDAYS);
    }

    public void setOverdueReturnDays(Long overdueReturnDays) {
        set(PROPERTY_OVERDUERETURNDAYS, overdueReturnDays);
    }

    public Boolean isSelectOrderLine() {
        return (Boolean) get(PROPERTY_SELECTORDERLINE);
    }

    public void setSelectOrderLine(Boolean selectOrderLine) {
        set(PROPERTY_SELECTORDERLINE, selectOrderLine);
    }

    public UOM getOperativeUOM() {
        return (UOM) get(PROPERTY_OPERATIVEUOM);
    }

    public void setOperativeUOM(UOM operativeUOM) {
        set(PROPERTY_OPERATIVEUOM, operativeUOM);
    }

    public Boolean isObposServiceProposed() {
        return (Boolean) get(PROPERTY_OBPOSSERVICEPROPOSED);
    }

    public void setObposServiceProposed(Boolean obposServiceProposed) {
        set(PROPERTY_OBPOSSERVICEPROPOSED, obposServiceProposed);
    }

    public BigDecimal getOperativeQuantity() {
        return (BigDecimal) get(PROPERTY_OPERATIVEQUANTITY);
    }

    public void setOperativeQuantity(BigDecimal operativeQuantity) {
        set(PROPERTY_OPERATIVEQUANTITY, operativeQuantity);
    }

    public Boolean isSsipotmAccumulate() {
        return (Boolean) get(PROPERTY_SSIPOTMACCUMULATE);
    }

    public void setSsipotmAccumulate(Boolean ssipotmAccumulate) {
        set(PROPERTY_SSIPOTMACCUMULATE, ssipotmAccumulate);
    }

    public String getSprliIdentifier() {
        return (String) get(PROPERTY_SPRLIIDENTIFIER);
    }

    public void setSprliIdentifier(String sprliIdentifier) {
        set(PROPERTY_SPRLIIDENTIFIER, sprliIdentifier);
    }

    public BigDecimal getSsipCostorigin() {
        return (BigDecimal) get(PROPERTY_SSIPCOSTORIGIN);
    }

    public void setSsipCostorigin(BigDecimal ssipCostorigin) {
        set(PROPERTY_SSIPCOSTORIGIN, ssipCostorigin);
    }

    public BigDecimal getSsipRealcost() {
        return (BigDecimal) get(PROPERTY_SSIPREALCOST);
    }

    public void setSsipRealcost(BigDecimal ssipRealcost) {
        set(PROPERTY_SSIPREALCOST, ssipRealcost);
    }

    public Boolean isSsbodAddGifts() {
        return (Boolean) get(PROPERTY_SSBODADDGIFTS);
    }

    public void setSsbodAddGifts(Boolean ssbodAddGifts) {
        set(PROPERTY_SSBODADDGIFTS, ssbodAddGifts);
    }

    public BusinessPartner getSsipCustomer() {
        return (BusinessPartner) get(PROPERTY_SSIPCUSTOMER);
    }

    public void setSsipCustomer(BusinessPartner ssipCustomer) {
        set(PROPERTY_SSIPCUSTOMER, ssipCustomer);
    }

    public User getSsipSeller() {
        return (User) get(PROPERTY_SSIPSELLER);
    }

    public void setSsipSeller(User ssipSeller) {
        set(PROPERTY_SSIPSELLER, ssipSeller);
    }

    public Image getSproctmAdImgTask() {
        return (Image) get(PROPERTY_SPROCTMADIMGTASK);
    }

    public void setSproctmAdImgTask(Image sproctmAdImgTask) {
        set(PROPERTY_SPROCTMADIMGTASK, sproctmAdImgTask);
    }

    public String getSsipIdentifier() {
        return (String) get(PROPERTY_SSIPIDENTIFIER);
    }

    public void setSsipIdentifier(String ssipIdentifier) {
        set(PROPERTY_SSIPIDENTIFIER, ssipIdentifier);
    }

    public Boolean isSsipPreliquidated() {
        return (Boolean) get(PROPERTY_SSIPPRELIQUIDATED);
    }

    public void setSsipPreliquidated(Boolean ssipPreliquidated) {
        set(PROPERTY_SSIPPRELIQUIDATED, ssipPreliquidated);
    }

    public BigDecimal getSsfpsQtyordered() {
        return (BigDecimal) get(PROPERTY_SSFPSQTYORDERED);
    }

    public void setSsfpsQtyordered(BigDecimal ssfpsQtyordered) {
        set(PROPERTY_SSFPSQTYORDERED, ssfpsQtyordered);
    }

    public BigDecimal getSsipiceValueIce() {
        return (BigDecimal) get(PROPERTY_SSIPICEVALUEICE);
    }

    public void setSsipiceValueIce(BigDecimal ssipiceValueIce) {
        set(PROPERTY_SSIPICEVALUEICE, ssipiceValueIce);
    }

    public BigDecimal getSsbodDiscountRate() {
        return (BigDecimal) get(PROPERTY_SSBODDISCOUNTRATE);
    }

    public void setSsbodDiscountRate(BigDecimal ssbodDiscountRate) {
        set(PROPERTY_SSBODDISCOUNTRATE, ssbodDiscountRate);
    }

    public BigDecimal getSsfpsQtydelivered() {
        return (BigDecimal) get(PROPERTY_SSFPSQTYDELIVERED);
    }

    public void setSsfpsQtydelivered(BigDecimal ssfpsQtydelivered) {
        set(PROPERTY_SSFPSQTYDELIVERED, ssfpsQtydelivered);
    }

    public BigDecimal getSsfpsQtyinvoiced() {
        return (BigDecimal) get(PROPERTY_SSFPSQTYINVOICED);
    }

    public void setSsfpsQtyinvoiced(BigDecimal ssfpsQtyinvoiced) {
        set(PROPERTY_SSFPSQTYINVOICED, ssfpsQtyinvoiced);
    }

    public Boolean isEcssrExecreservebackgrd() {
        return (Boolean) get(PROPERTY_ECSSREXECRESERVEBACKGRD);
    }

    public void setEcssrExecreservebackgrd(Boolean ecssrExecreservebackgrd) {
        set(PROPERTY_ECSSREXECRESERVEBACKGRD, ecssrExecreservebackgrd);
    }

    public Long getAtvefCuota() {
        return (Long) get(PROPERTY_ATVEFCUOTA);
    }

    public void setAtvefCuota(Long atvefCuota) {
        set(PROPERTY_ATVEFCUOTA, atvefCuota);
    }

    public BigDecimal getAtvefEntrada() {
        return (BigDecimal) get(PROPERTY_ATVEFENTRADA);
    }

    public void setAtvefEntrada(BigDecimal atvefEntrada) {
        set(PROPERTY_ATVEFENTRADA, atvefEntrada);
    }

    public BigDecimal getAtvefFinanciamiento() {
        return (BigDecimal) get(PROPERTY_ATVEFFINANCIAMIENTO);
    }

    public void setAtvefFinanciamiento(BigDecimal atvefFinanciamiento) {
        set(PROPERTY_ATVEFFINANCIAMIENTO, atvefFinanciamiento);
    }

    public Product getAtvefProduct2() {
        return (Product) get(PROPERTY_ATVEFPRODUCT2);
    }

    public void setAtvefProduct2(Product atvefProduct2) {
        set(PROPERTY_ATVEFPRODUCT2, atvefProduct2);
    }

    public BigDecimal getAtvefValorcuota() {
        return (BigDecimal) get(PROPERTY_ATVEFVALORCUOTA);
    }

    public void setAtvefValorcuota(BigDecimal atvefValorcuota) {
        set(PROPERTY_ATVEFVALORCUOTA, atvefValorcuota);
    }

    public BigDecimal getSICUSReservedQuantity() {
        return (BigDecimal) get(COMPUTED_COLUMN_SICUSRESERVEDQUANTITY);
    }

    public void setSICUSReservedQuantity(BigDecimal sICUSReservedQuantity) {
        set(COMPUTED_COLUMN_SICUSRESERVEDQUANTITY, sICUSReservedQuantity);
    }

    public OrderLine_ComputedColumns get_computedColumns() {
        return (OrderLine_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(OrderLine_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardInst> getGCNVGiftCardInstList() {
      return (List<GiftCardInst>) get(PROPERTY_GCNVGIFTCARDINSTLIST);
    }

    public void setGCNVGiftCardInstList(List<GiftCardInst> gCNVGiftCardInstList) {
        set(PROPERTY_GCNVGIFTCARDINSTLIST, gCNVGiftCardInstList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardTrans> getGCNVGiftCardTransList() {
      return (List<GiftCardTrans>) get(PROPERTY_GCNVGIFTCARDTRANSLIST);
    }

    public void setGCNVGiftCardTransList(List<GiftCardTrans> gCNVGiftCardTransList) {
        set(PROPERTY_GCNVGIFTCARDTRANSLIST, gCNVGiftCardTransList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRunLine> getMRPProductionRunLineList() {
      return (List<ProductionRunLine>) get(PROPERTY_MRPPRODUCTIONRUNLINELIST);
    }

    public void setMRPProductionRunLineList(List<ProductionRunLine> mRPProductionRunLineList) {
        set(PROPERTY_MRPPRODUCTIONRUNLINELIST, mRPProductionRunLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRunLine> getMRPPurchasingRunLineList() {
      return (List<PurchasingRunLine>) get(PROPERTY_MRPPURCHASINGRUNLINELIST);
    }

    public void setMRPPurchasingRunLineList(List<PurchasingRunLine> mRPPurchasingRunLineList) {
        set(PROPERTY_MRPPURCHASINGRUNLINELIST, mRPPurchasingRunLineList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMCrprodOrderlineIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODORDERLINEIDLIST);
    }

    public void setManufacturingMeasureShiftEMCrprodOrderlineIDList(List<MeasureShift> manufacturingMeasureShiftEMCrprodOrderlineIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODORDERLINEIDLIST, manufacturingMeasureShiftEMCrprodOrderlineIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getMaterialMgmtReservationList() {
      return (List<Reservation>) get(PROPERTY_MATERIALMGMTRESERVATIONLIST);
    }

    public void setMaterialMgmtReservationList(List<Reservation> materialMgmtReservationList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONLIST, materialMgmtReservationList);
    }

    @SuppressWarnings("unchecked")
    public List<ReservationStock> getMaterialMgmtReservationStockList() {
      return (List<ReservationStock>) get(PROPERTY_MATERIALMGMTRESERVATIONSTOCKLIST);
    }

    public void setMaterialMgmtReservationStockList(List<ReservationStock> materialMgmtReservationStockList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONSTOCKLIST, materialMgmtReservationStockList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineSOPOReferenceList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINESOPOREFERENCELIST);
    }

    public void setOrderLineSOPOReferenceList(List<OrderLine> orderLineSOPOReferenceList) {
        set(PROPERTY_ORDERLINESOPOREFERENCELIST, orderLineSOPOReferenceList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineQuotationLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINEQUOTATIONLINELIST);
    }

    public void setOrderLineQuotationLineList(List<OrderLine> orderLineQuotationLineList) {
        set(PROPERTY_ORDERLINEQUOTATIONLINELIST, orderLineQuotationLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineBOMParentIDList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINEBOMPARENTIDLIST);
    }

    public void setOrderLineBOMParentIDList(List<OrderLine> orderLineBOMParentIDList) {
        set(PROPERTY_ORDERLINEBOMPARENTIDLIST, orderLineBOMParentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineReplacedorderlineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINEREPLACEDORDERLINELIST);
    }

    public void setOrderLineReplacedorderlineList(List<OrderLine> orderLineReplacedorderlineList) {
        set(PROPERTY_ORDERLINEREPLACEDORDERLINELIST, orderLineReplacedorderlineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineAccountingDimension> getOrderLineAccountingDimensionList() {
      return (List<OrderLineAccountingDimension>) get(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setOrderLineAccountingDimensionList(List<OrderLineAccountingDimension> orderLineAccountingDimensionList) {
        set(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, orderLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineOffer> getOrderLineOfferList() {
      return (List<OrderLineOffer>) get(PROPERTY_ORDERLINEOFFERLIST);
    }

    public void setOrderLineOfferList(List<OrderLineOffer> orderLineOfferList) {
        set(PROPERTY_ORDERLINEOFFERLIST, orderLineOfferList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineTax> getOrderLineTaxList() {
      return (List<OrderLineTax>) get(PROPERTY_ORDERLINETAXLIST);
    }

    public void setOrderLineTaxList(List<OrderLineTax> orderLineTaxList) {
        set(PROPERTY_ORDERLINETAXLIST, orderLineTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderlineServiceRelation> getOrderlineServiceRelationList() {
      return (List<OrderlineServiceRelation>) get(PROPERTY_ORDERLINESERVICERELATIONLIST);
    }

    public void setOrderlineServiceRelationList(List<OrderlineServiceRelation> orderlineServiceRelationList) {
        set(PROPERTY_ORDERLINESERVICERELATIONLIST, orderlineServiceRelationList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderlineServiceRelation> getOrderlineServiceRelationCOrderlineRelatedIDList() {
      return (List<OrderlineServiceRelation>) get(PROPERTY_ORDERLINESERVICERELATIONCORDERLINERELATEDIDLIST);
    }

    public void setOrderlineServiceRelationCOrderlineRelatedIDList(List<OrderlineServiceRelation> orderlineServiceRelationCOrderlineRelatedIDList) {
        set(PROPERTY_ORDERLINESERVICERELATIONCORDERLINERELATEDIDLIST, orderlineServiceRelationCOrderlineRelatedIDList);
    }

    @SuppressWarnings("unchecked")
    public List<PrereservationManualPickEdit> getPrereservationManualPickEditPurchaseOrderLineList() {
      return (List<PrereservationManualPickEdit>) get(PROPERTY_PRERESERVATIONMANUALPICKEDITPURCHASEORDERLINELIST);
    }

    public void setPrereservationManualPickEditPurchaseOrderLineList(List<PrereservationManualPickEdit> prereservationManualPickEditPurchaseOrderLineList) {
        set(PROPERTY_PRERESERVATIONMANUALPICKEDITPURCHASEORDERLINELIST, prereservationManualPickEditPurchaseOrderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PrereservationManualPickEdit> getPrereservationManualPickEditSalesOrderLineList() {
      return (List<PrereservationManualPickEdit>) get(PROPERTY_PRERESERVATIONMANUALPICKEDITSALESORDERLINELIST);
    }

    public void setPrereservationManualPickEditSalesOrderLineList(List<PrereservationManualPickEdit> prereservationManualPickEditSalesOrderLineList) {
        set(PROPERTY_PRERESERVATIONMANUALPICKEDITSALESORDERLINELIST, prereservationManualPickEditSalesOrderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<POInvoiceMatch> getProcurementPOInvoiceMatchList() {
      return (List<POInvoiceMatch>) get(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST);
    }

    public void setProcurementPOInvoiceMatchList(List<POInvoiceMatch> procurementPOInvoiceMatchList) {
        set(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST, procurementPOInvoiceMatchList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionPOMatch> getProcurementRequisitionPOMatchList() {
      return (List<RequisitionPOMatch>) get(PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST);
    }

    public void setProcurementRequisitionPOMatchList(List<RequisitionPOMatch> procurementRequisitionPOMatchList) {
        set(PROPERTY_PROCUREMENTREQUISITIONPOMATCHLIST, procurementRequisitionPOMatchList);
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
    public List<SOLReservedStock> getSOLReservedStockList() {
      return (List<SOLReservedStock>) get(PROPERTY_SOLRESERVEDSTOCKLIST);
    }

    public void setSOLReservedStockList(List<SOLReservedStock> sOLReservedStockList) {
        set(PROPERTY_SOLRESERVEDSTOCKLIST, sOLReservedStockList);
    }

    @SuppressWarnings("unchecked")
    public List<CommissionDetail> getSalesCommissionDetailList() {
      return (List<CommissionDetail>) get(PROPERTY_SALESCOMMISSIONDETAILLIST);
    }

    public void setSalesCommissionDetailList(List<CommissionDetail> salesCommissionDetailList) {
        set(PROPERTY_SALESCOMMISSIONDETAILLIST, salesCommissionDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftOrder> getSsbodGiftOrderList() {
      return (List<SsbodGiftOrder>) get(PROPERTY_SSBODGIFTORDERLIST);
    }

    public void setSsbodGiftOrderList(List<SsbodGiftOrder> ssbodGiftOrderList) {
        set(PROPERTY_SSBODGIFTORDERLIST, ssbodGiftOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
      return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLineV> getTimeAndExpenseSheetLineVList() {
      return (List<SheetLineV>) get(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST);
    }

    public void setTimeAndExpenseSheetLineVList(List<SheetLineV> timeAndExpenseSheetLineVList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, timeAndExpenseSheetLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<Imdlv_Lines> getImdlvLinesList() {
      return (List<Imdlv_Lines>) get(PROPERTY_IMDLVLINESLIST);
    }

    public void setImdlvLinesList(List<Imdlv_Lines> imdlvLinesList) {
        set(PROPERTY_IMDLVLINESLIST, imdlvLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<ReservedGoodMovementPickEdit> getReservedgoodmntPickEditList() {
      return (List<ReservedGoodMovementPickEdit>) get(PROPERTY_RESERVEDGOODMNTPICKEDITLIST);
    }

    public void setReservedgoodmntPickEditList(List<ReservedGoodMovementPickEdit> reservedgoodmntPickEditList) {
        set(PROPERTY_RESERVEDGOODMNTPICKEDITLIST, reservedgoodmntPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfPendingOrdersTmp> getScmfPendingordersTmpList() {
      return (List<ScmfPendingOrdersTmp>) get(PROPERTY_SCMFPENDINGORDERSTMPLIST);
    }

    public void setScmfPendingordersTmpList(List<ScmfPendingOrdersTmp> scmfPendingordersTmpList) {
        set(PROPERTY_SCMFPENDINGORDERSTMPLIST, scmfPendingordersTmpList);
    }

    @SuppressWarnings("unchecked")
    public List<scomst_unpaid_commission> getScomstUnpaidCommissionList() {
      return (List<scomst_unpaid_commission>) get(PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST);
    }

    public void setScomstUnpaidCommissionList(List<scomst_unpaid_commission> scomstUnpaidCommissionList) {
        set(PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST, scomstUnpaidCommissionList);
    }

    @SuppressWarnings("unchecked")
    public List<Sfpsi_ReconcileSalesOrderV> getSfpsiReconcileSoVList() {
      return (List<Sfpsi_ReconcileSalesOrderV>) get(PROPERTY_SFPSIRECONCILESOVLIST);
    }

    public void setSfpsiReconcileSoVList(List<Sfpsi_ReconcileSalesOrderV> sfpsiReconcileSoVList) {
        set(PROPERTY_SFPSIRECONCILESOVLIST, sfpsiReconcileSoVList);
    }

    @SuppressWarnings("unchecked")
    public List<Sinvmin_SquareBill> getSinvminSquareBillList() {
      return (List<Sinvmin_SquareBill>) get(PROPERTY_SINVMINSQUAREBILLLIST);
    }

    public void setSinvminSquareBillList(List<Sinvmin_SquareBill> sinvminSquareBillList) {
        set(PROPERTY_SINVMINSQUAREBILLLIST, sinvminSquareBillList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_OrderLine> getSsipotmOrderlineList() {
      return (List<Ssipotm_OrderLine>) get(PROPERTY_SSIPOTMORDERLINELIST);
    }

    public void setSsipotmOrderlineList(List<Ssipotm_OrderLine> ssipotmOrderlineList) {
        set(PROPERTY_SSIPOTMORDERLINELIST, ssipotmOrderlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcConsumptionView> getSstpcPreliqVList() {
      return (List<SstpcConsumptionView>) get(PROPERTY_SSTPCPRELIQVLIST);
    }

    public void setSstpcPreliqVList(List<SstpcConsumptionView> sstpcPreliqVList) {
        set(PROPERTY_SSTPCPRELIQVLIST, sstpcPreliqVList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_SICUSRESERVEDQUANTITY.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSICUSReservedQuantity();
      }
    
      return super.get(propName);
    }
}

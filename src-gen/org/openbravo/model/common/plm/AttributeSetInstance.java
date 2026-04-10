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
package org.openbravo.model.common.plm;

import com.atrums.indumoto.postventa.data.atindpo_postventalinea;

import ec.com.sidesoft.backoffice.discount.SsbodGiftOrder;
import ec.com.sidesoft.backoffice.discount.SsbodGiftTemp;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown_line;
import ec.com.sidesoft.custom.mrp.forecast.ScmfTransactionBalance;
import ec.com.sidesoft.inventory.blind.register.SiblrPhysicalInvtLines;
import ec.com.sidesoft.inventory.partial.out.movement.SsipotmAttributeProduct;
import ec.com.sidesoft.localization.ecuador.resupply.ssrsresupplyline;
import ec.com.sidesoft.localization.importdata.loadvouchers.Imdlv_Lines;
import ec.com.sidesoft.localization.quality.assurement.SlqsMProductStockView;
import ec.com.sidesoft.localization.quality.assurement.SlqsProductSafetyInProcessView;
import ec.com.sidesoft.production.SsprodProductLotView;
import ec.com.sidesoft.projects.Ssprj_ProjectProductV;
import ec.com.sidesoft.warehouse.product.SwhpProductStockDetailV;
import ec.com.sidesoft.workorder.consult.SSWCLWorkOrderLine;

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
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.manufacturing.quality.Case;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.manufacturing.transaction.GlobalUse;
import org.openbravo.model.materialmgmt.onhandquantity.ProductStockView;
import org.openbravo.model.materialmgmt.onhandquantity.ReferencedInventory;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.onhandquantity.ReservationStock;
import org.openbravo.model.materialmgmt.onhandquantity.ReservedGoodMovementPickEdit;
import org.openbravo.model.materialmgmt.onhandquantity.StorageDetail;
import org.openbravo.model.materialmgmt.onhandquantity.StoragePending;
import org.openbravo.model.materialmgmt.transaction.InternalConsumptionLine;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;
import org.openbravo.model.materialmgmt.transaction.MaterialTransaction;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialReceiptPickEdit;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialShipmentPickEdit;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.project.ProjectIssue;
/**
 * Entity class for entity AttributeSetInstance (stored in table M_AttributeSetInstance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AttributeSetInstance extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_AttributeSetInstance";
    public static final String ENTITY_NAME = "AttributeSetInstance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ATTRIBUTESET = "attributeSet";
    public static final String PROPERTY_SERIALNO = "serialNo";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_LOT = "lot";
    public static final String PROPERTY_ISLOCKED = "islocked";
    public static final String PROPERTY_LOCKDESCRIPTION = "lockDescription";
    public static final String PROPERTY_REFERENCEDINVENTORY = "referencedInventory";
    public static final String PROPERTY_PARENTATTRIBUTESETINSTANCE = "parentAttributeSetInstance";
    public static final String PROPERTY_CSLJDATEJULIAN = "csljDatejulian";
    public static final String PROPERTY_ATTRIBUTEINSTANCELIST = "attributeInstanceList";
    public static final String PROPERTY_ATTRIBUTESETINSTANCEPARENTATTRIBUTESETINSTANCEIDLIST = "attributeSetInstanceParentAttributeSetInstanceIDList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST = "financialMgmtAssetList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_MANUFACTURINGCASELIST = "manufacturingCaseList";
    public static final String PROPERTY_MANUFACTURINGGLOBALUSELIST = "manufacturingGlobalUseList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYATTRSIIDLIST = "manufacturingMeasureShiftEMSpqulyAttrsiIDList";
    public static final String PROPERTY_MANUFACTURINGPRODUCTIONLINELIST = "manufacturingProductionLineList";
    public static final String PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST = "materialMgmtInternalConsumptionLineList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST = "materialMgmtInternalMovementLineList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEMATTRIBUTESETINSTANCETOIDLIST = "materialMgmtInternalMovementLineMAttributeSetInstanceToIDList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST = "materialMgmtInventoryCountLineList";
    public static final String PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST = "materialMgmtMaterialTransactionList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONSTOCKLIST = "materialMgmtReservationStockList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEDETAILLIST = "materialMgmtStorageDetailList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST = "materialMgmtStoragePendingList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINELIST = "procurementRequisitionLineList";
    public static final String PROPERTY_PRODUCTLIST = "productList";
    public static final String PROPERTY_PRODUCTSTOCKVIEWLIST = "productStockViewList";
    public static final String PROPERTY_PROJECTISSUELIST = "projectIssueList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST = "returnMaterialReceiptPickEditList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST = "returnMaterialShipmentPickEditList";
    public static final String PROPERTY_SIBLRPHYSICALINVTLINESLIST = "siblrPhysicalInvtLinesList";
    public static final String PROPERTY_SSBODGIFTORDERLIST = "ssbodGiftOrderList";
    public static final String PROPERTY_SSBODGIFTTEMPLIST = "ssbodGiftTempList";
    public static final String PROPERTY_ATINDPOPOSTVENTALINEALIST = "atindpoPostventalineaList";
    public static final String PROPERTY_ECSCBBREAKDOWNLIST = "ecscbBreakdownList";
    public static final String PROPERTY_ECSCBBREAKDOWNLINELIST = "ecscbBreakdownLineList";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";
    public static final String PROPERTY_RESERVEDGOODMNTPICKEDITLIST = "reservedgoodmntPickEditList";
    public static final String PROPERTY_SCMFTRANSACTIONBALANCELIST = "scmfTransactionBalanceList";
    public static final String PROPERTY_SLQSMPRODUCTSTOCKVLIST = "slqsMProductStockVList";
    public static final String PROPERTY_SLQSPRDSAFETYVLIST = "slqsPrdSafetyVList";
    public static final String PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST = "ssipotmAttributeProductList";
    public static final String PROPERTY_SSPRJPROJECTPRODUCTVLIST = "ssprjProjectProductVList";
    public static final String PROPERTY_SSPRODPRODUCTLOTVLIST = "ssprodProductLotVList";
    public static final String PROPERTY_SSRSRESUPPLYLINELIST = "ssrsResupplylineList";
    public static final String PROPERTY_SSWCLWORKORDERLINEVLIST = "sswclWorkOrderlineVList";
    public static final String PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST = "swhpProductStockDetailVList";

    public AttributeSetInstance() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISLOCKED, false);
        setDefaultValue(PROPERTY_ATTRIBUTEINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATTRIBUTESETINSTANCEPARENTATTRIBUTESETINSTANCEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGCASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGGLOBALUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYATTRSIIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEMATTRIBUTESETINSTANCETOIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONSTOCKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSTOCKVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTISSUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIBLRPHYSICALINVTLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTTEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTALINEALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBBREAKDOWNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBBREAKDOWNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RESERVEDGOODMNTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFTRANSACTIONBALANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLQSMPRODUCTSTOCKVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLQSPRDSAFETYVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRJPROJECTPRODUCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRODPRODUCTLOTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSRSRESUPPLYLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST, new ArrayList<Object>());
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

    public AttributeSet getAttributeSet() {
        return (AttributeSet) get(PROPERTY_ATTRIBUTESET);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        set(PROPERTY_ATTRIBUTESET, attributeSet);
    }

    public String getSerialNo() {
        return (String) get(PROPERTY_SERIALNO);
    }

    public void setSerialNo(String serialNo) {
        set(PROPERTY_SERIALNO, serialNo);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Lot getLot() {
        return (Lot) get(PROPERTY_LOT);
    }

    public void setLot(Lot lot) {
        set(PROPERTY_LOT, lot);
    }

    public Boolean isLocked() {
        return (Boolean) get(PROPERTY_ISLOCKED);
    }

    public void setLocked(Boolean islocked) {
        set(PROPERTY_ISLOCKED, islocked);
    }

    public String getLockDescription() {
        return (String) get(PROPERTY_LOCKDESCRIPTION);
    }

    public void setLockDescription(String lockDescription) {
        set(PROPERTY_LOCKDESCRIPTION, lockDescription);
    }

    public ReferencedInventory getReferencedInventory() {
        return (ReferencedInventory) get(PROPERTY_REFERENCEDINVENTORY);
    }

    public void setReferencedInventory(ReferencedInventory referencedInventory) {
        set(PROPERTY_REFERENCEDINVENTORY, referencedInventory);
    }

    public AttributeSetInstance getParentAttributeSetInstance() {
        return (AttributeSetInstance) get(PROPERTY_PARENTATTRIBUTESETINSTANCE);
    }

    public void setParentAttributeSetInstance(AttributeSetInstance parentAttributeSetInstance) {
        set(PROPERTY_PARENTATTRIBUTESETINSTANCE, parentAttributeSetInstance);
    }

    public String getCsljDatejulian() {
        return (String) get(PROPERTY_CSLJDATEJULIAN);
    }

    public void setCsljDatejulian(String csljDatejulian) {
        set(PROPERTY_CSLJDATEJULIAN, csljDatejulian);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeInstance> getAttributeInstanceList() {
      return (List<AttributeInstance>) get(PROPERTY_ATTRIBUTEINSTANCELIST);
    }

    public void setAttributeInstanceList(List<AttributeInstance> attributeInstanceList) {
        set(PROPERTY_ATTRIBUTEINSTANCELIST, attributeInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<AttributeSetInstance> getAttributeSetInstanceParentAttributeSetInstanceIDList() {
      return (List<AttributeSetInstance>) get(PROPERTY_ATTRIBUTESETINSTANCEPARENTATTRIBUTESETINSTANCEIDLIST);
    }

    public void setAttributeSetInstanceParentAttributeSetInstanceIDList(List<AttributeSetInstance> attributeSetInstanceParentAttributeSetInstanceIDList) {
        set(PROPERTY_ATTRIBUTESETINSTANCEPARENTATTRIBUTESETINSTANCEIDLIST, attributeSetInstanceParentAttributeSetInstanceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETLIST);
    }

    public void setFinancialMgmtAssetList(List<Asset> financialMgmtAssetList) {
        set(PROPERTY_FINANCIALMGMTASSETLIST, financialMgmtAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Case> getManufacturingCaseList() {
      return (List<Case>) get(PROPERTY_MANUFACTURINGCASELIST);
    }

    public void setManufacturingCaseList(List<Case> manufacturingCaseList) {
        set(PROPERTY_MANUFACTURINGCASELIST, manufacturingCaseList);
    }

    @SuppressWarnings("unchecked")
    public List<GlobalUse> getManufacturingGlobalUseList() {
      return (List<GlobalUse>) get(PROPERTY_MANUFACTURINGGLOBALUSELIST);
    }

    public void setManufacturingGlobalUseList(List<GlobalUse> manufacturingGlobalUseList) {
        set(PROPERTY_MANUFACTURINGGLOBALUSELIST, manufacturingGlobalUseList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMSpqulyAttrsiIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYATTRSIIDLIST);
    }

    public void setManufacturingMeasureShiftEMSpqulyAttrsiIDList(List<MeasureShift> manufacturingMeasureShiftEMSpqulyAttrsiIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYATTRSIIDLIST, manufacturingMeasureShiftEMSpqulyAttrsiIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionLine> getManufacturingProductionLineList() {
      return (List<ProductionLine>) get(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST);
    }

    public void setManufacturingProductionLineList(List<ProductionLine> manufacturingProductionLineList) {
        set(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST, manufacturingProductionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalConsumptionLine> getMaterialMgmtInternalConsumptionLineList() {
      return (List<InternalConsumptionLine>) get(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST);
    }

    public void setMaterialMgmtInternalConsumptionLineList(List<InternalConsumptionLine> materialMgmtInternalConsumptionLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST, materialMgmtInternalConsumptionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST);
    }

    public void setMaterialMgmtInternalMovementLineList(List<InternalMovementLine> materialMgmtInternalMovementLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, materialMgmtInternalMovementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineMAttributeSetInstanceToIDList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEMATTRIBUTESETINSTANCETOIDLIST);
    }

    public void setMaterialMgmtInternalMovementLineMAttributeSetInstanceToIDList(List<InternalMovementLine> materialMgmtInternalMovementLineMAttributeSetInstanceToIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEMATTRIBUTESETINSTANCETOIDLIST, materialMgmtInternalMovementLineMAttributeSetInstanceToIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCountLine> getMaterialMgmtInventoryCountLineList() {
      return (List<InventoryCountLine>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST);
    }

    public void setMaterialMgmtInventoryCountLineList(List<InventoryCountLine> materialMgmtInventoryCountLineList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST, materialMgmtInventoryCountLineList);
    }

    @SuppressWarnings("unchecked")
    public List<MaterialTransaction> getMaterialMgmtMaterialTransactionList() {
      return (List<MaterialTransaction>) get(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST);
    }

    public void setMaterialMgmtMaterialTransactionList(List<MaterialTransaction> materialMgmtMaterialTransactionList) {
        set(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST, materialMgmtMaterialTransactionList);
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
    public List<StorageDetail> getMaterialMgmtStorageDetailList() {
      return (List<StorageDetail>) get(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST);
    }

    public void setMaterialMgmtStorageDetailList(List<StorageDetail> materialMgmtStorageDetailList) {
        set(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, materialMgmtStorageDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<StoragePending> getMaterialMgmtStoragePendingList() {
      return (List<StoragePending>) get(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST);
    }

    public void setMaterialMgmtStoragePendingList(List<StoragePending> materialMgmtStoragePendingList) {
        set(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, materialMgmtStoragePendingList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINELIST);
    }

    public void setProcurementRequisitionLineList(List<RequisitionLine> procurementRequisitionLineList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINELIST, procurementRequisitionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
      return (List<Product>) get(PROPERTY_PRODUCTLIST);
    }

    public void setProductList(List<Product> productList) {
        set(PROPERTY_PRODUCTLIST, productList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductStockView> getProductStockViewList() {
      return (List<ProductStockView>) get(PROPERTY_PRODUCTSTOCKVIEWLIST);
    }

    public void setProductStockViewList(List<ProductStockView> productStockViewList) {
        set(PROPERTY_PRODUCTSTOCKVIEWLIST, productStockViewList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectIssue> getProjectIssueList() {
      return (List<ProjectIssue>) get(PROPERTY_PROJECTISSUELIST);
    }

    public void setProjectIssueList(List<ProjectIssue> projectIssueList) {
        set(PROPERTY_PROJECTISSUELIST, projectIssueList);
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
    public List<SiblrPhysicalInvtLines> getSiblrPhysicalInvtLinesList() {
      return (List<SiblrPhysicalInvtLines>) get(PROPERTY_SIBLRPHYSICALINVTLINESLIST);
    }

    public void setSiblrPhysicalInvtLinesList(List<SiblrPhysicalInvtLines> siblrPhysicalInvtLinesList) {
        set(PROPERTY_SIBLRPHYSICALINVTLINESLIST, siblrPhysicalInvtLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftOrder> getSsbodGiftOrderList() {
      return (List<SsbodGiftOrder>) get(PROPERTY_SSBODGIFTORDERLIST);
    }

    public void setSsbodGiftOrderList(List<SsbodGiftOrder> ssbodGiftOrderList) {
        set(PROPERTY_SSBODGIFTORDERLIST, ssbodGiftOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftTemp> getSsbodGiftTempList() {
      return (List<SsbodGiftTemp>) get(PROPERTY_SSBODGIFTTEMPLIST);
    }

    public void setSsbodGiftTempList(List<SsbodGiftTemp> ssbodGiftTempList) {
        set(PROPERTY_SSBODGIFTTEMPLIST, ssbodGiftTempList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventalinea> getAtindpoPostventalineaList() {
      return (List<atindpo_postventalinea>) get(PROPERTY_ATINDPOPOSTVENTALINEALIST);
    }

    public void setAtindpoPostventalineaList(List<atindpo_postventalinea> atindpoPostventalineaList) {
        set(PROPERTY_ATINDPOPOSTVENTALINEALIST, atindpoPostventalineaList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_breakdown> getEcscbBreakdownList() {
      return (List<ecscb_breakdown>) get(PROPERTY_ECSCBBREAKDOWNLIST);
    }

    public void setEcscbBreakdownList(List<ecscb_breakdown> ecscbBreakdownList) {
        set(PROPERTY_ECSCBBREAKDOWNLIST, ecscbBreakdownList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_breakdown_line> getEcscbBreakdownLineList() {
      return (List<ecscb_breakdown_line>) get(PROPERTY_ECSCBBREAKDOWNLINELIST);
    }

    public void setEcscbBreakdownLineList(List<ecscb_breakdown_line> ecscbBreakdownLineList) {
        set(PROPERTY_ECSCBBREAKDOWNLINELIST, ecscbBreakdownLineList);
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
    public List<ScmfTransactionBalance> getScmfTransactionBalanceList() {
      return (List<ScmfTransactionBalance>) get(PROPERTY_SCMFTRANSACTIONBALANCELIST);
    }

    public void setScmfTransactionBalanceList(List<ScmfTransactionBalance> scmfTransactionBalanceList) {
        set(PROPERTY_SCMFTRANSACTIONBALANCELIST, scmfTransactionBalanceList);
    }

    @SuppressWarnings("unchecked")
    public List<SlqsMProductStockView> getSlqsMProductStockVList() {
      return (List<SlqsMProductStockView>) get(PROPERTY_SLQSMPRODUCTSTOCKVLIST);
    }

    public void setSlqsMProductStockVList(List<SlqsMProductStockView> slqsMProductStockVList) {
        set(PROPERTY_SLQSMPRODUCTSTOCKVLIST, slqsMProductStockVList);
    }

    @SuppressWarnings("unchecked")
    public List<SlqsProductSafetyInProcessView> getSlqsPrdSafetyVList() {
      return (List<SlqsProductSafetyInProcessView>) get(PROPERTY_SLQSPRDSAFETYVLIST);
    }

    public void setSlqsPrdSafetyVList(List<SlqsProductSafetyInProcessView> slqsPrdSafetyVList) {
        set(PROPERTY_SLQSPRDSAFETYVLIST, slqsPrdSafetyVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsipotmAttributeProduct> getSsipotmAttributeProductList() {
      return (List<SsipotmAttributeProduct>) get(PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST);
    }

    public void setSsipotmAttributeProductList(List<SsipotmAttributeProduct> ssipotmAttributeProductList) {
        set(PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST, ssipotmAttributeProductList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssprj_ProjectProductV> getSsprjProjectProductVList() {
      return (List<Ssprj_ProjectProductV>) get(PROPERTY_SSPRJPROJECTPRODUCTVLIST);
    }

    public void setSsprjProjectProductVList(List<Ssprj_ProjectProductV> ssprjProjectProductVList) {
        set(PROPERTY_SSPRJPROJECTPRODUCTVLIST, ssprjProjectProductVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprodProductLotView> getSsprodProductLotVList() {
      return (List<SsprodProductLotView>) get(PROPERTY_SSPRODPRODUCTLOTVLIST);
    }

    public void setSsprodProductLotVList(List<SsprodProductLotView> ssprodProductLotVList) {
        set(PROPERTY_SSPRODPRODUCTLOTVLIST, ssprodProductLotVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssrsresupplyline> getSsrsResupplylineList() {
      return (List<ssrsresupplyline>) get(PROPERTY_SSRSRESUPPLYLINELIST);
    }

    public void setSsrsResupplylineList(List<ssrsresupplyline> ssrsResupplylineList) {
        set(PROPERTY_SSRSRESUPPLYLINELIST, ssrsResupplylineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrderLine> getSswclWorkOrderlineVList() {
      return (List<SSWCLWorkOrderLine>) get(PROPERTY_SSWCLWORKORDERLINEVLIST);
    }

    public void setSswclWorkOrderlineVList(List<SSWCLWorkOrderLine> sswclWorkOrderlineVList) {
        set(PROPERTY_SSWCLWORKORDERLINEVLIST, sswclWorkOrderlineVList);
    }

    @SuppressWarnings("unchecked")
    public List<SwhpProductStockDetailV> getSwhpProductStockDetailVList() {
      return (List<SwhpProductStockDetailV>) get(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST);
    }

    public void setSwhpProductStockDetailVList(List<SwhpProductStockDetailV> swhpProductStockDetailVList) {
        set(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST, swhpProductStockDetailVList);
    }

}

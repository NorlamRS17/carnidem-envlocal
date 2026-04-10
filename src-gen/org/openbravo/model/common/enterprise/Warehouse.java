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

import com.atrums.indumoto.postventa.data.atindpo_postventa;

import ec.com.sidesoft.backoffice.discount.SsbodGiftOrder;
import ec.com.sidesoft.backoffice.discount.SsbodGiftTemp;
import ec.com.sidesoft.custom.order.verifystock.SOVSLdmProd;
import ec.com.sidesoft.custom.order.verifystock.SOVSLdmTemp;
import ec.com.sidesoft.inventory.adjustment.SIVAPhysicalInventory;
import ec.com.sidesoft.inventory.blind.register.SiblrPhysicalInventory;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_Accumulated;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_OrderLine;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_PartialDispatch;
import ec.com.sidesoft.localization.adjustment.inventory.pdv.SsipdvMWarehouse;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPurchaseIinvoice;
import ec.com.sidesoft.localization.quality.assurement.SlqsMProductStockView;
import ec.com.sidesoft.projects.Ssprj_ProjectProductV;
import ec.com.sidesoft.report.salesinvoice.SRSISalesInvoiceV;
import ec.com.sidesoft.sales.order.indumot.SssoinDatesalesprocessV;
import ec.com.sidesoft.settlement.project.cost.SstpcConsumptionView;
import ec.com.sidesoft.settlement.project.cost.SstpcMatConProjView;
import ec.com.sidesoft.settlement.project.cost.SstpcMatProjVoidView;
import ec.com.sidesoft.settlement.project.cost.SstpcMovementProductView;
import ec.com.sidesoft.warehouse.product.SwhpProductStockDetailV;
import ec.com.sidesoft.workorder.consult.SSWCLWorkOrder;
import ec.com.sidesoft.ws.ordercreate.data.SWSOCConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.client.widgets.OBWCL_StockByWarehouseView;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.alert.Alert;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductByPriceAndWarehouse;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.materialmgmt.cost.CostingRuleInit;
import org.openbravo.model.materialmgmt.cost.InvAmtUpdLnInventories;
import org.openbravo.model.materialmgmt.cost.InventoryAmountUpdateLine;
import org.openbravo.model.materialmgmt.cost.StockValuation;
import org.openbravo.model.materialmgmt.onhandquantity.ProductStockView;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.onhandquantity.StoragePending;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.TransactionLast;
import org.openbravo.model.pos.ExternalPOS;
import org.openbravo.model.project.Project;
import org.openbravo.model.timeandexpense.Resource;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.retail.posterminal.OBPOS_OrgWarehouseExtra;
/**
 * Entity class for entity Warehouse (stored in table M_Warehouse).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Warehouse extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Warehouse";
    public static final String ENTITY_NAME = "Warehouse";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_LOCATIONADDRESS = "locationAddress";
    public static final String PROPERTY_STORAGEBINSEPARATOR = "storageBinSeparator";
    public static final String PROPERTY_SHIPMENTVEHICLE = "shipmentVehicle";
    public static final String PROPERTY_SHIPPERCODE = "shipperCode";
    public static final String PROPERTY_FROMDOCUMENTNO = "fromDocumentNo";
    public static final String PROPERTY_TODOCUMENTNO = "toDocumentNo";
    public static final String PROPERTY_RETURNLOCATOR = "returnlocator";
    public static final String PROPERTY_WAREHOUSERULE = "warehouseRule";
    public static final String PROPERTY_ALLOCATED = "allocated";
    public static final String PROPERTY_SLCIISCONSIGNMENT = "slciIsconsignment";
    public static final String PROPERTY_SPATMPISMP = "spatmpIsmp";
    public static final String PROPERTY_EEIIDENTIFIER = "eeiIdentifier";
    public static final String PROPERTY_SSVSVIRTUALSTORAGE = "ssvsVirtualstorage";
    public static final String PROPERTY_SWHPTRANSIT = "swhpTransit";
    public static final String PROPERTY_SSVSMAIN = "sSVSMain";
    public static final String PROPERTY_SSFINISPRODWH = "ssfinIsprodWh";
    public static final String PROPERTY_SSXMLLOWIBP = "ssxmlLowIbp";
    public static final String PROPERTY_ADALERTLIST = "aDAlertList";
    public static final String PROPERTY_ADUSERDEFAULTWAREHOUSELIST = "aDUserDefaultWarehouseList";
    public static final String PROPERTY_COSTINGRULEINITLIST = "costingRuleInitList";
    public static final String PROPERTY_EXTERNALPOSLIST = "externalPOSList";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELINELIST = "inventoryAmountUpdateLineList";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST = "inventoryAmountUpdateLineInventoriesList";
    public static final String PROPERTY_LOCATORLIST = "locatorList";
    public static final String PROPERTY_STOCKVALUATIONLIST = "stockValuationList";
    public static final String PROPERTY_MATERIALMGMTCOSTINGLIST = "materialMgmtCostingList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST = "materialMgmtInventoryCountList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST = "materialMgmtStoragePendingList";
    public static final String PROPERTY_OBPOSORGWAREHOUSEEXTRALIST = "oBPOSOrgWarehouseExtraList";
    public static final String PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST = "oBWCLStockByWarehouseViewList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORGANIZATIONEMOBRETCOMWAREHOUSEIDLIST = "organizationEMObretcoMWarehouseIDList";
    public static final String PROPERTY_ORGANIZATIONEMSSFORMWAREHOUSEIDLIST = "organizationEMSsforMWarehouseIDList";
    public static final String PROPERTY_ORGANIZATIONWAREHOUSELIST = "organizationWarehouseList";
    public static final String PROPERTY_PRODUCTEMSSRSMWAREHOUSEIDLIST = "productEMSsrsMWarehouseIDList";
    public static final String PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST = "productByPriceAndWarehouseList";
    public static final String PROPERTY_PRODUCTSTOCKVIEWLIST = "productStockViewList";
    public static final String PROPERTY_PROJECTLIST = "projectList";
    public static final String PROPERTY_RESOURCELIST = "resourceList";
    public static final String PROPERTY_SIVAPHYSICALINVENTORYLIST = "sIVAPhysicalInventoryList";
    public static final String PROPERTY_SOVSLDMPRODLIST = "sOVSLdmProdList";
    public static final String PROPERTY_SOVSLDMTEMPLIST = "sOVSLdmTempList";
    public static final String PROPERTY_SRSISALESINVOICEVLIST = "sRSISalesInvoiceVList";
    public static final String PROPERTY_SWSOCCONFIGLIST = "sWSOCConfigList";
    public static final String PROPERTY_SIBLRPHYSICALINVENTORYLIST = "siblrPhysicalInventoryList";
    public static final String PROPERTY_SSBODGIFTORDERLIST = "ssbodGiftOrderList";
    public static final String PROPERTY_SSBODGIFTTEMPLIST = "ssbodGiftTempList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLIST = "timeAndExpenseSheetList";
    public static final String PROPERTY_TRANSACTIONLASTLIST = "transactionLastList";
    public static final String PROPERTY_WAREHOUSEACCOUNTSLIST = "warehouseAccountsList";
    public static final String PROPERTY_WAREHOUSESHIPPERLIST = "warehouseShipperList";
    public static final String PROPERTY_ATINDPOPOSTVENTALIST = "atindpoPostventaList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICELIST = "imdlvPurchaseInvoiceList";
    public static final String PROPERTY_SLQSMPRODUCTSTOCKVLIST = "slqsMProductStockVList";
    public static final String PROPERTY_SSIPDVWAREHOUSELIST = "ssipdvWarehouseList";
    public static final String PROPERTY_SSIPOTMACCUMULATEDLIST = "ssipotmAccumulatedList";
    public static final String PROPERTY_SSIPOTMORDERLINELIST = "ssipotmOrderlineList";
    public static final String PROPERTY_SSIPOTMPARTIALDISPATCHLIST = "ssipotmPartialDispatchList";
    public static final String PROPERTY_SSPRJPROJECTPRODUCTVLIST = "ssprjProjectProductVList";
    public static final String PROPERTY_SSSOINDATESALESPROCESSVLIST = "sssoinDatesalesprocessVList";
    public static final String PROPERTY_SSTPCMATCONPROJVLIST = "sstpcMatConProjVList";
    public static final String PROPERTY_SSTPCMATPROJVOIDVLIST = "sstpcMatProjVoidVList";
    public static final String PROPERTY_SSTPCMOVPRODVLIST = "sstpcMovProdVList";
    public static final String PROPERTY_SSTPCPRELIQVLIST = "sstpcPreliqVList";
    public static final String PROPERTY_SSWCLWORKORDERVLIST = "sswclWorkOrderVList";
    public static final String PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST = "swhpProductStockDetailVList";

    public Warehouse() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STORAGEBINSEPARATOR, "*");
        setDefaultValue(PROPERTY_SHIPMENTVEHICLE, false);
        setDefaultValue(PROPERTY_ALLOCATED, false);
        setDefaultValue(PROPERTY_SLCIISCONSIGNMENT, false);
        setDefaultValue(PROPERTY_SPATMPISMP, false);
        setDefaultValue(PROPERTY_EEIIDENTIFIER, "000");
        setDefaultValue(PROPERTY_SSVSVIRTUALSTORAGE, false);
        setDefaultValue(PROPERTY_SWHPTRANSIT, false);
        setDefaultValue(PROPERTY_SSVSMAIN, false);
        setDefaultValue(PROPERTY_SSFINISPRODWH, false);
        setDefaultValue(PROPERTY_SSXMLLOWIBP, false);
        setDefaultValue(PROPERTY_ADALERTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSERDEFAULTWAREHOUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTINGRULEINITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LOCATORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STOCKVALUATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTCOSTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSORGWAREHOUSEEXTRALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMOBRETCOMWAREHOUSEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSSFORMWAREHOUSEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONWAREHOUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTEMSSRSMWAREHOUSEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSTOCKVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RESOURCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIVAPHYSICALINVENTORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SOVSLDMPRODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SOVSLDMTEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSOCCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIBLRPHYSICALINVENTORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTTEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONLASTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WAREHOUSEACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WAREHOUSESHIPPERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLQSMPRODUCTSTOCKVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPDVWAREHOUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMACCUMULATEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRJPROJECTPRODUCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSSOINDATESALESPROCESSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMATCONPROJVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMATPROJVOIDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMOVPRODVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPRELIQVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERVLIST, new ArrayList<Object>());
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

    public Location getLocationAddress() {
        return (Location) get(PROPERTY_LOCATIONADDRESS);
    }

    public void setLocationAddress(Location locationAddress) {
        set(PROPERTY_LOCATIONADDRESS, locationAddress);
    }

    public String getStorageBinSeparator() {
        return (String) get(PROPERTY_STORAGEBINSEPARATOR);
    }

    public void setStorageBinSeparator(String storageBinSeparator) {
        set(PROPERTY_STORAGEBINSEPARATOR, storageBinSeparator);
    }

    public Boolean isShipmentVehicle() {
        return (Boolean) get(PROPERTY_SHIPMENTVEHICLE);
    }

    public void setShipmentVehicle(Boolean shipmentVehicle) {
        set(PROPERTY_SHIPMENTVEHICLE, shipmentVehicle);
    }

    public String getShipperCode() {
        return (String) get(PROPERTY_SHIPPERCODE);
    }

    public void setShipperCode(String shipperCode) {
        set(PROPERTY_SHIPPERCODE, shipperCode);
    }

    public Long getFromDocumentNo() {
        return (Long) get(PROPERTY_FROMDOCUMENTNO);
    }

    public void setFromDocumentNo(Long fromDocumentNo) {
        set(PROPERTY_FROMDOCUMENTNO, fromDocumentNo);
    }

    public Long getToDocumentNo() {
        return (Long) get(PROPERTY_TODOCUMENTNO);
    }

    public void setToDocumentNo(Long toDocumentNo) {
        set(PROPERTY_TODOCUMENTNO, toDocumentNo);
    }

    public Locator getReturnlocator() {
        return (Locator) get(PROPERTY_RETURNLOCATOR);
    }

    public void setReturnlocator(Locator returnlocator) {
        set(PROPERTY_RETURNLOCATOR, returnlocator);
    }

    public WarehouseRule getWarehouseRule() {
        return (WarehouseRule) get(PROPERTY_WAREHOUSERULE);
    }

    public void setWarehouseRule(WarehouseRule warehouseRule) {
        set(PROPERTY_WAREHOUSERULE, warehouseRule);
    }

    public Boolean isAllocated() {
        return (Boolean) get(PROPERTY_ALLOCATED);
    }

    public void setAllocated(Boolean allocated) {
        set(PROPERTY_ALLOCATED, allocated);
    }

    public Boolean isSlciIsconsignment() {
        return (Boolean) get(PROPERTY_SLCIISCONSIGNMENT);
    }

    public void setSlciIsconsignment(Boolean slciIsconsignment) {
        set(PROPERTY_SLCIISCONSIGNMENT, slciIsconsignment);
    }

    public Boolean isSpatmpIsmp() {
        return (Boolean) get(PROPERTY_SPATMPISMP);
    }

    public void setSpatmpIsmp(Boolean spatmpIsmp) {
        set(PROPERTY_SPATMPISMP, spatmpIsmp);
    }

    public String getEeiIdentifier() {
        return (String) get(PROPERTY_EEIIDENTIFIER);
    }

    public void setEeiIdentifier(String eeiIdentifier) {
        set(PROPERTY_EEIIDENTIFIER, eeiIdentifier);
    }

    public Boolean isSsvsVirtualstorage() {
        return (Boolean) get(PROPERTY_SSVSVIRTUALSTORAGE);
    }

    public void setSsvsVirtualstorage(Boolean ssvsVirtualstorage) {
        set(PROPERTY_SSVSVIRTUALSTORAGE, ssvsVirtualstorage);
    }

    public Boolean isSwhpTransit() {
        return (Boolean) get(PROPERTY_SWHPTRANSIT);
    }

    public void setSwhpTransit(Boolean swhpTransit) {
        set(PROPERTY_SWHPTRANSIT, swhpTransit);
    }

    public Boolean isSSVSMain() {
        return (Boolean) get(PROPERTY_SSVSMAIN);
    }

    public void setSSVSMain(Boolean sSVSMain) {
        set(PROPERTY_SSVSMAIN, sSVSMain);
    }

    public Boolean isSsfinIsprodWh() {
        return (Boolean) get(PROPERTY_SSFINISPRODWH);
    }

    public void setSsfinIsprodWh(Boolean ssfinIsprodWh) {
        set(PROPERTY_SSFINISPRODWH, ssfinIsprodWh);
    }

    public Boolean isSsxmlLowIbp() {
        return (Boolean) get(PROPERTY_SSXMLLOWIBP);
    }

    public void setSsxmlLowIbp(Boolean ssxmlLowIbp) {
        set(PROPERTY_SSXMLLOWIBP, ssxmlLowIbp);
    }

    @SuppressWarnings("unchecked")
    public List<Alert> getADAlertList() {
      return (List<Alert>) get(PROPERTY_ADALERTLIST);
    }

    public void setADAlertList(List<Alert> aDAlertList) {
        set(PROPERTY_ADALERTLIST, aDAlertList);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserDefaultWarehouseList() {
      return (List<User>) get(PROPERTY_ADUSERDEFAULTWAREHOUSELIST);
    }

    public void setADUserDefaultWarehouseList(List<User> aDUserDefaultWarehouseList) {
        set(PROPERTY_ADUSERDEFAULTWAREHOUSELIST, aDUserDefaultWarehouseList);
    }

    @SuppressWarnings("unchecked")
    public List<CostingRuleInit> getCostingRuleInitList() {
      return (List<CostingRuleInit>) get(PROPERTY_COSTINGRULEINITLIST);
    }

    public void setCostingRuleInitList(List<CostingRuleInit> costingRuleInitList) {
        set(PROPERTY_COSTINGRULEINITLIST, costingRuleInitList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOS> getExternalPOSList() {
      return (List<ExternalPOS>) get(PROPERTY_EXTERNALPOSLIST);
    }

    public void setExternalPOSList(List<ExternalPOS> externalPOSList) {
        set(PROPERTY_EXTERNALPOSLIST, externalPOSList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryAmountUpdateLine> getInventoryAmountUpdateLineList() {
      return (List<InventoryAmountUpdateLine>) get(PROPERTY_INVENTORYAMOUNTUPDATELINELIST);
    }

    public void setInventoryAmountUpdateLineList(List<InventoryAmountUpdateLine> inventoryAmountUpdateLineList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELINELIST, inventoryAmountUpdateLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvAmtUpdLnInventories> getInventoryAmountUpdateLineInventoriesList() {
      return (List<InvAmtUpdLnInventories>) get(PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST);
    }

    public void setInventoryAmountUpdateLineInventoriesList(List<InvAmtUpdLnInventories> inventoryAmountUpdateLineInventoriesList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELINEINVENTORIESLIST, inventoryAmountUpdateLineInventoriesList);
    }

    @SuppressWarnings("unchecked")
    public List<Locator> getLocatorList() {
      return (List<Locator>) get(PROPERTY_LOCATORLIST);
    }

    public void setLocatorList(List<Locator> locatorList) {
        set(PROPERTY_LOCATORLIST, locatorList);
    }

    @SuppressWarnings("unchecked")
    public List<StockValuation> getStockValuationList() {
      return (List<StockValuation>) get(PROPERTY_STOCKVALUATIONLIST);
    }

    public void setStockValuationList(List<StockValuation> stockValuationList) {
        set(PROPERTY_STOCKVALUATIONLIST, stockValuationList);
    }

    @SuppressWarnings("unchecked")
    public List<Costing> getMaterialMgmtCostingList() {
      return (List<Costing>) get(PROPERTY_MATERIALMGMTCOSTINGLIST);
    }

    public void setMaterialMgmtCostingList(List<Costing> materialMgmtCostingList) {
        set(PROPERTY_MATERIALMGMTCOSTINGLIST, materialMgmtCostingList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCount> getMaterialMgmtInventoryCountList() {
      return (List<InventoryCount>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST);
    }

    public void setMaterialMgmtInventoryCountList(List<InventoryCount> materialMgmtInventoryCountList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, materialMgmtInventoryCountList);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getMaterialMgmtReservationList() {
      return (List<Reservation>) get(PROPERTY_MATERIALMGMTRESERVATIONLIST);
    }

    public void setMaterialMgmtReservationList(List<Reservation> materialMgmtReservationList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONLIST, materialMgmtReservationList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<StoragePending> getMaterialMgmtStoragePendingList() {
      return (List<StoragePending>) get(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST);
    }

    public void setMaterialMgmtStoragePendingList(List<StoragePending> materialMgmtStoragePendingList) {
        set(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, materialMgmtStoragePendingList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOS_OrgWarehouseExtra> getOBPOSOrgWarehouseExtraList() {
      return (List<OBPOS_OrgWarehouseExtra>) get(PROPERTY_OBPOSORGWAREHOUSEEXTRALIST);
    }

    public void setOBPOSOrgWarehouseExtraList(List<OBPOS_OrgWarehouseExtra> oBPOSOrgWarehouseExtraList) {
        set(PROPERTY_OBPOSORGWAREHOUSEEXTRALIST, oBPOSOrgWarehouseExtraList);
    }

    @SuppressWarnings("unchecked")
    public List<OBWCL_StockByWarehouseView> getOBWCLStockByWarehouseViewList() {
      return (List<OBWCL_StockByWarehouseView>) get(PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST);
    }

    public void setOBWCLStockByWarehouseViewList(List<OBWCL_StockByWarehouseView> oBWCLStockByWarehouseViewList) {
        set(PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST, oBWCLStockByWarehouseViewList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMObretcoMWarehouseIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMOBRETCOMWAREHOUSEIDLIST);
    }

    public void setOrganizationEMObretcoMWarehouseIDList(List<Organization> organizationEMObretcoMWarehouseIDList) {
        set(PROPERTY_ORGANIZATIONEMOBRETCOMWAREHOUSEIDLIST, organizationEMObretcoMWarehouseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMSsforMWarehouseIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSSFORMWAREHOUSEIDLIST);
    }

    public void setOrganizationEMSsforMWarehouseIDList(List<Organization> organizationEMSsforMWarehouseIDList) {
        set(PROPERTY_ORGANIZATIONEMSSFORMWAREHOUSEIDLIST, organizationEMSsforMWarehouseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OrgWarehouse> getOrganizationWarehouseList() {
      return (List<OrgWarehouse>) get(PROPERTY_ORGANIZATIONWAREHOUSELIST);
    }

    public void setOrganizationWarehouseList(List<OrgWarehouse> organizationWarehouseList) {
        set(PROPERTY_ORGANIZATIONWAREHOUSELIST, organizationWarehouseList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductEMSsrsMWarehouseIDList() {
      return (List<Product>) get(PROPERTY_PRODUCTEMSSRSMWAREHOUSEIDLIST);
    }

    public void setProductEMSsrsMWarehouseIDList(List<Product> productEMSsrsMWarehouseIDList) {
        set(PROPERTY_PRODUCTEMSSRSMWAREHOUSEIDLIST, productEMSsrsMWarehouseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductByPriceAndWarehouse> getProductByPriceAndWarehouseList() {
      return (List<ProductByPriceAndWarehouse>) get(PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST);
    }

    public void setProductByPriceAndWarehouseList(List<ProductByPriceAndWarehouse> productByPriceAndWarehouseList) {
        set(PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST, productByPriceAndWarehouseList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductStockView> getProductStockViewList() {
      return (List<ProductStockView>) get(PROPERTY_PRODUCTSTOCKVIEWLIST);
    }

    public void setProductStockViewList(List<ProductStockView> productStockViewList) {
        set(PROPERTY_PRODUCTSTOCKVIEWLIST, productStockViewList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectList() {
      return (List<Project>) get(PROPERTY_PROJECTLIST);
    }

    public void setProjectList(List<Project> projectList) {
        set(PROPERTY_PROJECTLIST, projectList);
    }

    @SuppressWarnings("unchecked")
    public List<Resource> getResourceList() {
      return (List<Resource>) get(PROPERTY_RESOURCELIST);
    }

    public void setResourceList(List<Resource> resourceList) {
        set(PROPERTY_RESOURCELIST, resourceList);
    }

    @SuppressWarnings("unchecked")
    public List<SIVAPhysicalInventory> getSIVAPhysicalInventoryList() {
      return (List<SIVAPhysicalInventory>) get(PROPERTY_SIVAPHYSICALINVENTORYLIST);
    }

    public void setSIVAPhysicalInventoryList(List<SIVAPhysicalInventory> sIVAPhysicalInventoryList) {
        set(PROPERTY_SIVAPHYSICALINVENTORYLIST, sIVAPhysicalInventoryList);
    }

    @SuppressWarnings("unchecked")
    public List<SOVSLdmProd> getSOVSLdmProdList() {
      return (List<SOVSLdmProd>) get(PROPERTY_SOVSLDMPRODLIST);
    }

    public void setSOVSLdmProdList(List<SOVSLdmProd> sOVSLdmProdList) {
        set(PROPERTY_SOVSLDMPRODLIST, sOVSLdmProdList);
    }

    @SuppressWarnings("unchecked")
    public List<SOVSLdmTemp> getSOVSLdmTempList() {
      return (List<SOVSLdmTemp>) get(PROPERTY_SOVSLDMTEMPLIST);
    }

    public void setSOVSLdmTempList(List<SOVSLdmTemp> sOVSLdmTempList) {
        set(PROPERTY_SOVSLDMTEMPLIST, sOVSLdmTempList);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVLIST);
    }

    public void setSRSISalesInvoiceVList(List<SRSISalesInvoiceV> sRSISalesInvoiceVList) {
        set(PROPERTY_SRSISALESINVOICEVLIST, sRSISalesInvoiceVList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSOCConfig> getSWSOCConfigList() {
      return (List<SWSOCConfig>) get(PROPERTY_SWSOCCONFIGLIST);
    }

    public void setSWSOCConfigList(List<SWSOCConfig> sWSOCConfigList) {
        set(PROPERTY_SWSOCCONFIGLIST, sWSOCConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<SiblrPhysicalInventory> getSiblrPhysicalInventoryList() {
      return (List<SiblrPhysicalInventory>) get(PROPERTY_SIBLRPHYSICALINVENTORYLIST);
    }

    public void setSiblrPhysicalInventoryList(List<SiblrPhysicalInventory> siblrPhysicalInventoryList) {
        set(PROPERTY_SIBLRPHYSICALINVENTORYLIST, siblrPhysicalInventoryList);
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
    public List<Sheet> getTimeAndExpenseSheetList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETLIST);
    }

    public void setTimeAndExpenseSheetList(List<Sheet> timeAndExpenseSheetList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLIST, timeAndExpenseSheetList);
    }

    @SuppressWarnings("unchecked")
    public List<TransactionLast> getTransactionLastList() {
      return (List<TransactionLast>) get(PROPERTY_TRANSACTIONLASTLIST);
    }

    public void setTransactionLastList(List<TransactionLast> transactionLastList) {
        set(PROPERTY_TRANSACTIONLASTLIST, transactionLastList);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseAccounts> getWarehouseAccountsList() {
      return (List<WarehouseAccounts>) get(PROPERTY_WAREHOUSEACCOUNTSLIST);
    }

    public void setWarehouseAccountsList(List<WarehouseAccounts> warehouseAccountsList) {
        set(PROPERTY_WAREHOUSEACCOUNTSLIST, warehouseAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseShipper> getWarehouseShipperList() {
      return (List<WarehouseShipper>) get(PROPERTY_WAREHOUSESHIPPERLIST);
    }

    public void setWarehouseShipperList(List<WarehouseShipper> warehouseShipperList) {
        set(PROPERTY_WAREHOUSESHIPPERLIST, warehouseShipperList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventa> getAtindpoPostventaList() {
      return (List<atindpo_postventa>) get(PROPERTY_ATINDPOPOSTVENTALIST);
    }

    public void setAtindpoPostventaList(List<atindpo_postventa> atindpoPostventaList) {
        set(PROPERTY_ATINDPOPOSTVENTALIST, atindpoPostventaList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICELIST);
    }

    public void setImdlvPurchaseInvoiceList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceList) {
        set(PROPERTY_IMDLVPURCHASEINVOICELIST, imdlvPurchaseInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SlqsMProductStockView> getSlqsMProductStockVList() {
      return (List<SlqsMProductStockView>) get(PROPERTY_SLQSMPRODUCTSTOCKVLIST);
    }

    public void setSlqsMProductStockVList(List<SlqsMProductStockView> slqsMProductStockVList) {
        set(PROPERTY_SLQSMPRODUCTSTOCKVLIST, slqsMProductStockVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsipdvMWarehouse> getSsipdvWarehouseList() {
      return (List<SsipdvMWarehouse>) get(PROPERTY_SSIPDVWAREHOUSELIST);
    }

    public void setSsipdvWarehouseList(List<SsipdvMWarehouse> ssipdvWarehouseList) {
        set(PROPERTY_SSIPDVWAREHOUSELIST, ssipdvWarehouseList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_Accumulated> getSsipotmAccumulatedList() {
      return (List<Ssipotm_Accumulated>) get(PROPERTY_SSIPOTMACCUMULATEDLIST);
    }

    public void setSsipotmAccumulatedList(List<Ssipotm_Accumulated> ssipotmAccumulatedList) {
        set(PROPERTY_SSIPOTMACCUMULATEDLIST, ssipotmAccumulatedList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_OrderLine> getSsipotmOrderlineList() {
      return (List<Ssipotm_OrderLine>) get(PROPERTY_SSIPOTMORDERLINELIST);
    }

    public void setSsipotmOrderlineList(List<Ssipotm_OrderLine> ssipotmOrderlineList) {
        set(PROPERTY_SSIPOTMORDERLINELIST, ssipotmOrderlineList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_PartialDispatch> getSsipotmPartialDispatchList() {
      return (List<Ssipotm_PartialDispatch>) get(PROPERTY_SSIPOTMPARTIALDISPATCHLIST);
    }

    public void setSsipotmPartialDispatchList(List<Ssipotm_PartialDispatch> ssipotmPartialDispatchList) {
        set(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, ssipotmPartialDispatchList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssprj_ProjectProductV> getSsprjProjectProductVList() {
      return (List<Ssprj_ProjectProductV>) get(PROPERTY_SSPRJPROJECTPRODUCTVLIST);
    }

    public void setSsprjProjectProductVList(List<Ssprj_ProjectProductV> ssprjProjectProductVList) {
        set(PROPERTY_SSPRJPROJECTPRODUCTVLIST, ssprjProjectProductVList);
    }

    @SuppressWarnings("unchecked")
    public List<SssoinDatesalesprocessV> getSssoinDatesalesprocessVList() {
      return (List<SssoinDatesalesprocessV>) get(PROPERTY_SSSOINDATESALESPROCESSVLIST);
    }

    public void setSssoinDatesalesprocessVList(List<SssoinDatesalesprocessV> sssoinDatesalesprocessVList) {
        set(PROPERTY_SSSOINDATESALESPROCESSVLIST, sssoinDatesalesprocessVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcMatConProjView> getSstpcMatConProjVList() {
      return (List<SstpcMatConProjView>) get(PROPERTY_SSTPCMATCONPROJVLIST);
    }

    public void setSstpcMatConProjVList(List<SstpcMatConProjView> sstpcMatConProjVList) {
        set(PROPERTY_SSTPCMATCONPROJVLIST, sstpcMatConProjVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcMatProjVoidView> getSstpcMatProjVoidVList() {
      return (List<SstpcMatProjVoidView>) get(PROPERTY_SSTPCMATPROJVOIDVLIST);
    }

    public void setSstpcMatProjVoidVList(List<SstpcMatProjVoidView> sstpcMatProjVoidVList) {
        set(PROPERTY_SSTPCMATPROJVOIDVLIST, sstpcMatProjVoidVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcMovementProductView> getSstpcMovProdVList() {
      return (List<SstpcMovementProductView>) get(PROPERTY_SSTPCMOVPRODVLIST);
    }

    public void setSstpcMovProdVList(List<SstpcMovementProductView> sstpcMovProdVList) {
        set(PROPERTY_SSTPCMOVPRODVLIST, sstpcMovProdVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcConsumptionView> getSstpcPreliqVList() {
      return (List<SstpcConsumptionView>) get(PROPERTY_SSTPCPRELIQVLIST);
    }

    public void setSstpcPreliqVList(List<SstpcConsumptionView> sstpcPreliqVList) {
        set(PROPERTY_SSTPCPRELIQVLIST, sstpcPreliqVList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrder> getSswclWorkOrderVList() {
      return (List<SSWCLWorkOrder>) get(PROPERTY_SSWCLWORKORDERVLIST);
    }

    public void setSswclWorkOrderVList(List<SSWCLWorkOrder> sswclWorkOrderVList) {
        set(PROPERTY_SSWCLWORKORDERVLIST, sswclWorkOrderVList);
    }

    @SuppressWarnings("unchecked")
    public List<SwhpProductStockDetailV> getSwhpProductStockDetailVList() {
      return (List<SwhpProductStockDetailV>) get(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST);
    }

    public void setSwhpProductStockDetailVList(List<SwhpProductStockDetailV> swhpProductStockDetailVList) {
        set(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST, swhpProductStockDetailVList);
    }

}

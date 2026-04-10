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
package org.openbravo.model.project;

import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;

import ec.com.sidesoft.aftersale.machinery.Satmac_MachineType;
import ec.com.sidesoft.projects.Ssprj_ProjectProductV;
import ec.com.sidesoft.projects.complement.SproctmImpWorkforce;
import ec.com.sidesoft.projects.complement.SproctmInventorySettl;
import ec.com.sidesoft.projects.complement.SproctmSettlementCost;
import ec.com.sidesoft.projects.complement.SproctmTaskCif;
import ec.com.sidesoft.projects.complement.SproctmTaskContract;
import ec.com.sidesoft.projects.complement.SproctmTaskMachine;
import ec.com.sidesoft.projects.complement.SproctmTaskProd;
import ec.com.sidesoft.projects.complement.SproctmTaskWorkforce;
import ec.com.sidesoft.workorder.simplified.SswosYear;

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
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Brand;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.procurement.Requisition;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
/**
 * Entity class for entity ProjectTask (stored in table C_ProjectTask).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectTask extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ProjectTask";
    public static final String ENTITY_NAME = "ProjectTask";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_STANDARDTASK = "standardTask";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEQUENCENUMBER = "sequenceNumber";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_HELPCOMMENT = "helpComment";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PROJECTPHASE = "projectPhase";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_COMPLETE = "complete";
    public static final String PROPERTY_UNITPRICE = "unitPrice";
    public static final String PROPERTY_CONTRACTAMOUNT = "contractAmount";
    public static final String PROPERTY_PRICECEILING = "priceCeiling";
    public static final String PROPERTY_CONTRACTDATE = "contractDate";
    public static final String PROPERTY_SPROCTMADIMAGE = "sproctmAdImage";
    public static final String PROPERTY_SPROCTMCORDER = "sproctmCOrder";
    public static final String PROPERTY_SPROCTMMARGIN = "sproctmMargin";
    public static final String PROPERTY_SPROCTMCREATEQUOTATION = "sproctmCreateQuotation";
    public static final String PROPERTY_SPROCTMISNATIONALPROD = "sproctmIsnationalprod";
    public static final String PROPERTY_SPROCTMADDREQUISITION = "sproctmAddRequisition";
    public static final String PROPERTY_SATMACMACHINETYPE = "sATMACMachineType";
    public static final String PROPERTY_SATMACBRAND = "satmacBrand";
    public static final String PROPERTY_SATMACMODELPROD = "satmacModelProd";
    public static final String PROPERTY_SATMACYEAR = "satmacYear";
    public static final String PROPERTY_SATMACCHASSISNUMBER = "satmacChassisNumber";
    public static final String PROPERTY_SPROCTMCODETAILS = "sproctmCoDetails";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTTASKIDLIST = "materialMgmtShipmentInOutLineEMSproctmCProjecttaskIDList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTTASKIDLIST = "procurementRequisitionEMSproctmCProjecttaskIDList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTTASKIDLIST = "procurementRequisitionLineEMSproctmCProjecttaskIDList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTTASKIDLIST = "timeAndExpenseSheetEMSproctmCProjecttaskIDList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_SPROCTMIMPWORKFORCELIST = "sproctmImpWorkforceList";
    public static final String PROPERTY_SPROCTMINVENTORYSETTLLIST = "sproctmInventorySettlList";
    public static final String PROPERTY_SPROCTMSETTLEMENTCOSTLIST = "sproctmSettlementCostList";
    public static final String PROPERTY_SPROCTMTASKCIFLIST = "sproctmTaskCifList";
    public static final String PROPERTY_SPROCTMTASKCONTRACTLIST = "sproctmTaskContractList";
    public static final String PROPERTY_SPROCTMTASKMACHINELIST = "sproctmTaskMachineList";
    public static final String PROPERTY_SPROCTMTASKPRODLIST = "sproctmTaskProdList";
    public static final String PROPERTY_SPROCTMTASKWORKFORCELIST = "sproctmTaskWorkforceList";
    public static final String PROPERTY_SSPRJPROJECTPRODUCTVLIST = "ssprjProjectProductVList";

    public ProjectTask() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_COMPLETE, false);
        setDefaultValue(PROPERTY_PRICECEILING, false);
        setDefaultValue(PROPERTY_SPROCTMMARGIN, (long) 0);
        setDefaultValue(PROPERTY_SPROCTMCREATEQUOTATION, false);
        setDefaultValue(PROPERTY_SPROCTMISNATIONALPROD, false);
        setDefaultValue(PROPERTY_SPROCTMADDREQUISITION, false);
        setDefaultValue(PROPERTY_SPROCTMCODETAILS, false);
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTTASKIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTTASKIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTTASKIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTTASKIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMIMPWORKFORCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMINVENTORYSETTLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMSETTLEMENTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKCIFLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKMACHINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKPRODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKWORKFORCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRJPROJECTPRODUCTVLIST, new ArrayList<Object>());
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

    public StandardTask getStandardTask() {
        return (StandardTask) get(PROPERTY_STANDARDTASK);
    }

    public void setStandardTask(StandardTask standardTask) {
        set(PROPERTY_STANDARDTASK, standardTask);
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

    public Long getSequenceNumber() {
        return (Long) get(PROPERTY_SEQUENCENUMBER);
    }

    public void setSequenceNumber(Long sequenceNumber) {
        set(PROPERTY_SEQUENCENUMBER, sequenceNumber);
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

    public String getHelpComment() {
        return (String) get(PROPERTY_HELPCOMMENT);
    }

    public void setHelpComment(String helpComment) {
        set(PROPERTY_HELPCOMMENT, helpComment);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public ProjectPhase getProjectPhase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        set(PROPERTY_PROJECTPHASE, projectPhase);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public Boolean isComplete() {
        return (Boolean) get(PROPERTY_COMPLETE);
    }

    public void setComplete(Boolean complete) {
        set(PROPERTY_COMPLETE, complete);
    }

    public BigDecimal getUnitPrice() {
        return (BigDecimal) get(PROPERTY_UNITPRICE);
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        set(PROPERTY_UNITPRICE, unitPrice);
    }

    public BigDecimal getContractAmount() {
        return (BigDecimal) get(PROPERTY_CONTRACTAMOUNT);
    }

    public void setContractAmount(BigDecimal contractAmount) {
        set(PROPERTY_CONTRACTAMOUNT, contractAmount);
    }

    public Boolean isPriceCeiling() {
        return (Boolean) get(PROPERTY_PRICECEILING);
    }

    public void setPriceCeiling(Boolean priceCeiling) {
        set(PROPERTY_PRICECEILING, priceCeiling);
    }

    public Date getContractDate() {
        return (Date) get(PROPERTY_CONTRACTDATE);
    }

    public void setContractDate(Date contractDate) {
        set(PROPERTY_CONTRACTDATE, contractDate);
    }

    public Image getSproctmAdImage() {
        return (Image) get(PROPERTY_SPROCTMADIMAGE);
    }

    public void setSproctmAdImage(Image sproctmAdImage) {
        set(PROPERTY_SPROCTMADIMAGE, sproctmAdImage);
    }

    public Order getSproctmCOrder() {
        return (Order) get(PROPERTY_SPROCTMCORDER);
    }

    public void setSproctmCOrder(Order sproctmCOrder) {
        set(PROPERTY_SPROCTMCORDER, sproctmCOrder);
    }

    public Long getSproctmMargin() {
        return (Long) get(PROPERTY_SPROCTMMARGIN);
    }

    public void setSproctmMargin(Long sproctmMargin) {
        set(PROPERTY_SPROCTMMARGIN, sproctmMargin);
    }

    public Boolean isSproctmCreateQuotation() {
        return (Boolean) get(PROPERTY_SPROCTMCREATEQUOTATION);
    }

    public void setSproctmCreateQuotation(Boolean sproctmCreateQuotation) {
        set(PROPERTY_SPROCTMCREATEQUOTATION, sproctmCreateQuotation);
    }

    public Boolean isSproctmIsnationalprod() {
        return (Boolean) get(PROPERTY_SPROCTMISNATIONALPROD);
    }

    public void setSproctmIsnationalprod(Boolean sproctmIsnationalprod) {
        set(PROPERTY_SPROCTMISNATIONALPROD, sproctmIsnationalprod);
    }

    public Boolean isSproctmAddRequisition() {
        return (Boolean) get(PROPERTY_SPROCTMADDREQUISITION);
    }

    public void setSproctmAddRequisition(Boolean sproctmAddRequisition) {
        set(PROPERTY_SPROCTMADDREQUISITION, sproctmAddRequisition);
    }

    public Satmac_MachineType getSATMACMachineType() {
        return (Satmac_MachineType) get(PROPERTY_SATMACMACHINETYPE);
    }

    public void setSATMACMachineType(Satmac_MachineType sATMACMachineType) {
        set(PROPERTY_SATMACMACHINETYPE, sATMACMachineType);
    }

    public Brand getSatmacBrand() {
        return (Brand) get(PROPERTY_SATMACBRAND);
    }

    public void setSatmacBrand(Brand satmacBrand) {
        set(PROPERTY_SATMACBRAND, satmacBrand);
    }

    public SsfiModelProduct getSatmacModelProd() {
        return (SsfiModelProduct) get(PROPERTY_SATMACMODELPROD);
    }

    public void setSatmacModelProd(SsfiModelProduct satmacModelProd) {
        set(PROPERTY_SATMACMODELPROD, satmacModelProd);
    }

    public SswosYear getSatmacYear() {
        return (SswosYear) get(PROPERTY_SATMACYEAR);
    }

    public void setSatmacYear(SswosYear satmacYear) {
        set(PROPERTY_SATMACYEAR, satmacYear);
    }

    public String getSatmacChassisNumber() {
        return (String) get(PROPERTY_SATMACCHASSISNUMBER);
    }

    public void setSatmacChassisNumber(String satmacChassisNumber) {
        set(PROPERTY_SATMACCHASSISNUMBER, satmacChassisNumber);
    }

    public Boolean isSproctmCoDetails() {
        return (Boolean) get(PROPERTY_SPROCTMCODETAILS);
    }

    public void setSproctmCoDetails(Boolean sproctmCoDetails) {
        set(PROPERTY_SPROCTMCODETAILS, sproctmCoDetails);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineEMSproctmCProjecttaskIDList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTTASKIDLIST);
    }

    public void setMaterialMgmtShipmentInOutLineEMSproctmCProjecttaskIDList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineEMSproctmCProjecttaskIDList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTTASKIDLIST, materialMgmtShipmentInOutLineEMSproctmCProjecttaskIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Requisition> getProcurementRequisitionEMSproctmCProjecttaskIDList() {
      return (List<Requisition>) get(PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTTASKIDLIST);
    }

    public void setProcurementRequisitionEMSproctmCProjecttaskIDList(List<Requisition> procurementRequisitionEMSproctmCProjecttaskIDList) {
        set(PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTTASKIDLIST, procurementRequisitionEMSproctmCProjecttaskIDList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineEMSproctmCProjecttaskIDList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTTASKIDLIST);
    }

    public void setProcurementRequisitionLineEMSproctmCProjecttaskIDList(List<RequisitionLine> procurementRequisitionLineEMSproctmCProjecttaskIDList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTTASKIDLIST, procurementRequisitionLineEMSproctmCProjecttaskIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Sheet> getTimeAndExpenseSheetEMSproctmCProjecttaskIDList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTTASKIDLIST);
    }

    public void setTimeAndExpenseSheetEMSproctmCProjecttaskIDList(List<Sheet> timeAndExpenseSheetEMSproctmCProjecttaskIDList) {
        set(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTTASKIDLIST, timeAndExpenseSheetEMSproctmCProjecttaskIDList);
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
    public List<SproctmImpWorkforce> getSproctmImpWorkforceList() {
      return (List<SproctmImpWorkforce>) get(PROPERTY_SPROCTMIMPWORKFORCELIST);
    }

    public void setSproctmImpWorkforceList(List<SproctmImpWorkforce> sproctmImpWorkforceList) {
        set(PROPERTY_SPROCTMIMPWORKFORCELIST, sproctmImpWorkforceList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmInventorySettl> getSproctmInventorySettlList() {
      return (List<SproctmInventorySettl>) get(PROPERTY_SPROCTMINVENTORYSETTLLIST);
    }

    public void setSproctmInventorySettlList(List<SproctmInventorySettl> sproctmInventorySettlList) {
        set(PROPERTY_SPROCTMINVENTORYSETTLLIST, sproctmInventorySettlList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmSettlementCost> getSproctmSettlementCostList() {
      return (List<SproctmSettlementCost>) get(PROPERTY_SPROCTMSETTLEMENTCOSTLIST);
    }

    public void setSproctmSettlementCostList(List<SproctmSettlementCost> sproctmSettlementCostList) {
        set(PROPERTY_SPROCTMSETTLEMENTCOSTLIST, sproctmSettlementCostList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskCif> getSproctmTaskCifList() {
      return (List<SproctmTaskCif>) get(PROPERTY_SPROCTMTASKCIFLIST);
    }

    public void setSproctmTaskCifList(List<SproctmTaskCif> sproctmTaskCifList) {
        set(PROPERTY_SPROCTMTASKCIFLIST, sproctmTaskCifList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskContract> getSproctmTaskContractList() {
      return (List<SproctmTaskContract>) get(PROPERTY_SPROCTMTASKCONTRACTLIST);
    }

    public void setSproctmTaskContractList(List<SproctmTaskContract> sproctmTaskContractList) {
        set(PROPERTY_SPROCTMTASKCONTRACTLIST, sproctmTaskContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskMachine> getSproctmTaskMachineList() {
      return (List<SproctmTaskMachine>) get(PROPERTY_SPROCTMTASKMACHINELIST);
    }

    public void setSproctmTaskMachineList(List<SproctmTaskMachine> sproctmTaskMachineList) {
        set(PROPERTY_SPROCTMTASKMACHINELIST, sproctmTaskMachineList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskProd> getSproctmTaskProdList() {
      return (List<SproctmTaskProd>) get(PROPERTY_SPROCTMTASKPRODLIST);
    }

    public void setSproctmTaskProdList(List<SproctmTaskProd> sproctmTaskProdList) {
        set(PROPERTY_SPROCTMTASKPRODLIST, sproctmTaskProdList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskWorkforce> getSproctmTaskWorkforceList() {
      return (List<SproctmTaskWorkforce>) get(PROPERTY_SPROCTMTASKWORKFORCELIST);
    }

    public void setSproctmTaskWorkforceList(List<SproctmTaskWorkforce> sproctmTaskWorkforceList) {
        set(PROPERTY_SPROCTMTASKWORKFORCELIST, sproctmTaskWorkforceList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssprj_ProjectProductV> getSsprjProjectProductVList() {
      return (List<Ssprj_ProjectProductV>) get(PROPERTY_SSPRJPROJECTPRODUCTVLIST);
    }

    public void setSsprjProjectProductVList(List<Ssprj_ProjectProductV> ssprjProjectProductVList) {
        set(PROPERTY_SSPRJPROJECTPRODUCTVLIST, ssprjProjectProductVList);
    }

}

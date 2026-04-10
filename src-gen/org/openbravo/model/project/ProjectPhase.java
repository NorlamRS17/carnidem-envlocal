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

import ec.com.sidesoft.projects.Ssprj_ProjectProductV;
import ec.com.sidesoft.projects.complement.SproctmImpWorkforce;
import ec.com.sidesoft.projects.complement.SproctmInventorySettl;
import ec.com.sidesoft.projects.complement.SproctmSettlementCost;

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
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.manufacturing.cost.CostCenter;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.procurement.Requisition;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
/**
 * Entity class for entity ProjectPhase (stored in table C_ProjectPhase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ProjectPhase extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_ProjectPhase";
    public static final String ENTITY_NAME = "ProjectPhase";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_COMPLETE = "complete";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_UNITPRICE = "unitPrice";
    public static final String PROPERTY_GENERATEORDER = "generateOrder";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_STANDARDPHASE = "standardPhase";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_HELPCOMMENT = "helpComment";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_SEQUENCENUMBER = "sequenceNumber";
    public static final String PROPERTY_CONTRACTAMOUNT = "contractAmount";
    public static final String PROPERTY_PRICECEILING = "priceCeiling";
    public static final String PROPERTY_CONTRACTDATE = "contractDate";
    public static final String PROPERTY_SPROCTMPRHASETYPE = "sproctmPrhasetype";
    public static final String PROPERTY_SPROCTMCORDER = "sproctmCOrder";
    public static final String PROPERTY_SPROCTMMARGIN = "sproctmMargin";
    public static final String PROPERTY_SPROCTMCREATEQUOT = "sproctmCreateQuot";
    public static final String PROPERTY_SPROCTMASIGNEDCE = "sproctmAsignedCe";
    public static final String PROPERTY_SPROCTMMACOSTCENTER = "sproctmMaCostcenter";
    public static final String PROPERTY_SPROCTMPHASEEXECUTE = "sproctmPhaseExecute";
    public static final String PROPERTY_SPROCTMGENERATEDEXEC = "sproctmGeneratedExec";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTPHASEIDLIST = "materialMgmtShipmentInOutLineEMSproctmCProjectphaseIDList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTPHASEIDLIST = "procurementRequisitionEMSproctmCProjectphaseIDList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTPHASEIDLIST = "procurementRequisitionLineEMSproctmCProjectphaseIDList";
    public static final String PROPERTY_PROJECTLIST = "projectList";
    public static final String PROPERTY_PROJECTTASKLIST = "projectTaskList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTPHASEIDLIST = "timeAndExpenseSheetEMSproctmCProjectphaseIDList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_SPROCTMIMPWORKFORCELIST = "sproctmImpWorkforceList";
    public static final String PROPERTY_SPROCTMINVENTORYSETTLLIST = "sproctmInventorySettlList";
    public static final String PROPERTY_SPROCTMSETTLEMENTCOSTLIST = "sproctmSettlementCostList";
    public static final String PROPERTY_SSPRJPROJECTPRODUCTVLIST = "ssprjProjectProductVList";

    public ProjectPhase() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_COMPLETE, false);
        setDefaultValue(PROPERTY_GENERATEORDER, false);
        setDefaultValue(PROPERTY_QUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_PRICECEILING, false);
        setDefaultValue(PROPERTY_SPROCTMMARGIN, (long) 0);
        setDefaultValue(PROPERTY_SPROCTMCREATEQUOT, false);
        setDefaultValue(PROPERTY_SPROCTMASIGNEDCE, false);
        setDefaultValue(PROPERTY_SPROCTMPHASEEXECUTE, false);
        setDefaultValue(PROPERTY_SPROCTMGENERATEDEXEC, false);
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTPHASEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTPHASEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTPHASEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTTASKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTPHASEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMIMPWORKFORCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMINVENTORYSETTLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMSETTLEMENTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRJPROJECTPRODUCTVLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getUnitPrice() {
        return (BigDecimal) get(PROPERTY_UNITPRICE);
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        set(PROPERTY_UNITPRICE, unitPrice);
    }

    public Boolean isGenerateOrder() {
        return (Boolean) get(PROPERTY_GENERATEORDER);
    }

    public void setGenerateOrder(Boolean generateOrder) {
        set(PROPERTY_GENERATEORDER, generateOrder);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public StandardPhase getStandardPhase() {
        return (StandardPhase) get(PROPERTY_STANDARDPHASE);
    }

    public void setStandardPhase(StandardPhase standardPhase) {
        set(PROPERTY_STANDARDPHASE, standardPhase);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getHelpComment() {
        return (String) get(PROPERTY_HELPCOMMENT);
    }

    public void setHelpComment(String helpComment) {
        set(PROPERTY_HELPCOMMENT, helpComment);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Long getSequenceNumber() {
        return (Long) get(PROPERTY_SEQUENCENUMBER);
    }

    public void setSequenceNumber(Long sequenceNumber) {
        set(PROPERTY_SEQUENCENUMBER, sequenceNumber);
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

    public String getSproctmPrhasetype() {
        return (String) get(PROPERTY_SPROCTMPRHASETYPE);
    }

    public void setSproctmPrhasetype(String sproctmPrhasetype) {
        set(PROPERTY_SPROCTMPRHASETYPE, sproctmPrhasetype);
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

    public Boolean isSproctmCreateQuot() {
        return (Boolean) get(PROPERTY_SPROCTMCREATEQUOT);
    }

    public void setSproctmCreateQuot(Boolean sproctmCreateQuot) {
        set(PROPERTY_SPROCTMCREATEQUOT, sproctmCreateQuot);
    }

    public Boolean isSproctmAsignedCe() {
        return (Boolean) get(PROPERTY_SPROCTMASIGNEDCE);
    }

    public void setSproctmAsignedCe(Boolean sproctmAsignedCe) {
        set(PROPERTY_SPROCTMASIGNEDCE, sproctmAsignedCe);
    }

    public CostCenter getSproctmMaCostcenter() {
        return (CostCenter) get(PROPERTY_SPROCTMMACOSTCENTER);
    }

    public void setSproctmMaCostcenter(CostCenter sproctmMaCostcenter) {
        set(PROPERTY_SPROCTMMACOSTCENTER, sproctmMaCostcenter);
    }

    public Boolean isSproctmPhaseExecute() {
        return (Boolean) get(PROPERTY_SPROCTMPHASEEXECUTE);
    }

    public void setSproctmPhaseExecute(Boolean sproctmPhaseExecute) {
        set(PROPERTY_SPROCTMPHASEEXECUTE, sproctmPhaseExecute);
    }

    public Boolean isSproctmGeneratedExec() {
        return (Boolean) get(PROPERTY_SPROCTMGENERATEDEXEC);
    }

    public void setSproctmGeneratedExec(Boolean sproctmGeneratedExec) {
        set(PROPERTY_SPROCTMGENERATEDEXEC, sproctmGeneratedExec);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineEMSproctmCProjectphaseIDList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTPHASEIDLIST);
    }

    public void setMaterialMgmtShipmentInOutLineEMSproctmCProjectphaseIDList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineEMSproctmCProjectphaseIDList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSPROCTMCPROJECTPHASEIDLIST, materialMgmtShipmentInOutLineEMSproctmCProjectphaseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Requisition> getProcurementRequisitionEMSproctmCProjectphaseIDList() {
      return (List<Requisition>) get(PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTPHASEIDLIST);
    }

    public void setProcurementRequisitionEMSproctmCProjectphaseIDList(List<Requisition> procurementRequisitionEMSproctmCProjectphaseIDList) {
        set(PROPERTY_PROCUREMENTREQUISITIONEMSPROCTMCPROJECTPHASEIDLIST, procurementRequisitionEMSproctmCProjectphaseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineEMSproctmCProjectphaseIDList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTPHASEIDLIST);
    }

    public void setProcurementRequisitionLineEMSproctmCProjectphaseIDList(List<RequisitionLine> procurementRequisitionLineEMSproctmCProjectphaseIDList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMCPROJECTPHASEIDLIST, procurementRequisitionLineEMSproctmCProjectphaseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectList() {
      return (List<Project>) get(PROPERTY_PROJECTLIST);
    }

    public void setProjectList(List<Project> projectList) {
        set(PROPERTY_PROJECTLIST, projectList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectTask> getProjectTaskList() {
      return (List<ProjectTask>) get(PROPERTY_PROJECTTASKLIST);
    }

    public void setProjectTaskList(List<ProjectTask> projectTaskList) {
        set(PROPERTY_PROJECTTASKLIST, projectTaskList);
    }

    @SuppressWarnings("unchecked")
    public List<Sheet> getTimeAndExpenseSheetEMSproctmCProjectphaseIDList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTPHASEIDLIST);
    }

    public void setTimeAndExpenseSheetEMSproctmCProjectphaseIDList(List<Sheet> timeAndExpenseSheetEMSproctmCProjectphaseIDList) {
        set(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCPROJECTPHASEIDLIST, timeAndExpenseSheetEMSproctmCProjectphaseIDList);
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
    public List<Ssprj_ProjectProductV> getSsprjProjectProductVList() {
      return (List<Ssprj_ProjectProductV>) get(PROPERTY_SSPRJPROJECTPRODUCTVLIST);
    }

    public void setSsprjProjectProductVList(List<Ssprj_ProjectProductV> ssprjProjectProductVList) {
        set(PROPERTY_SSPRJPROJECTPRODUCTVLIST, ssprjProjectProductVList);
    }

}

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
package ec.com.sidesoft.settlement.project.cost;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.project.Project;
/**
 * Entity class for entity sstpc_liquidation_projects (stored in table sstpc_liquidation_projects).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class LiquidationProjects extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sstpc_liquidation_projects";
    public static final String ENTITY_NAME = "sstpc_liquidation_projects";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DATELIQPROJ = "dateliqproj";
    public static final String PROPERTY_DESCRIPTIONLIQ = "descriptionLiq";
    public static final String PROPERTY_TYPELIQUIDATION = "typeLiquidation";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_TOTALCOST = "totalCost";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_TOTALPAY = "totalPay";
    public static final String PROPERTY_DOCSTATUSLIST = "docstatuslist";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PRELIQUIDATION = "pRELiquidation";
    public static final String PROPERTY_LIQUIDATE = "liquidate";
    public static final String PROPERTY_POSTLIQUIDATION = "postLiquidation";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_DATEDOC = "datedoc";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DESPROCESSED = "desprocessed";
    public static final String PROPERTY_COSTTOTAL = "costTotal";
    public static final String PROPERTY_TOTALPAYMENTIN = "totalPaymentin";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_SPROCTMCPROJECT = "sproctmCProject";
    public static final String PROPERTY_SPROCTMINVENTORYSETTLLIST = "sproctmInventorySettlList";
    public static final String PROPERTY_SSTPCCONSUMPTIONLINELIST = "sstpcConsumptionLineList";
    public static final String PROPERTY_SSTPCPAYMENTLIST = "sstpcPaymentList";
    public static final String PROPERTY_SSTPCRELATEDCOSTSLIST = "sstpcRelatedCostsList";
    public static final String PROPERTY_SSTPCRELATEDREVENUELIST = "sstpcRelatedRevenueList";

    public LiquidationProjects() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCSTATUS, "PL");
        setDefaultValue(PROPERTY_TOTALCOST, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALPAY, new BigDecimal(0));
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PRELIQUIDATION, false);
        setDefaultValue(PROPERTY_LIQUIDATE, "N");
        setDefaultValue(PROPERTY_POSTLIQUIDATION, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_STATUS, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_DESPROCESSED, false);
        setDefaultValue(PROPERTY_COSTTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALPAYMENTIN, new BigDecimal(0));
        setDefaultValue(PROPERTY_SPROCTMINVENTORYSETTLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCCONSUMPTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDCOSTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDREVENUELIST, new ArrayList<Object>());
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

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getDateliqproj() {
        return (Date) get(PROPERTY_DATELIQPROJ);
    }

    public void setDateliqproj(Date dateliqproj) {
        set(PROPERTY_DATELIQPROJ, dateliqproj);
    }

    public String getDescriptionLiq() {
        return (String) get(PROPERTY_DESCRIPTIONLIQ);
    }

    public void setDescriptionLiq(String descriptionLiq) {
        set(PROPERTY_DESCRIPTIONLIQ, descriptionLiq);
    }

    public String getTypeLiquidation() {
        return (String) get(PROPERTY_TYPELIQUIDATION);
    }

    public void setTypeLiquidation(String typeLiquidation) {
        set(PROPERTY_TYPELIQUIDATION, typeLiquidation);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public BigDecimal getTotalCost() {
        return (BigDecimal) get(PROPERTY_TOTALCOST);
    }

    public void setTotalCost(BigDecimal totalCost) {
        set(PROPERTY_TOTALCOST, totalCost);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public BigDecimal getTotalPay() {
        return (BigDecimal) get(PROPERTY_TOTALPAY);
    }

    public void setTotalPay(BigDecimal totalPay) {
        set(PROPERTY_TOTALPAY, totalPay);
    }

    public String getDocstatuslist() {
        return (String) get(PROPERTY_DOCSTATUSLIST);
    }

    public void setDocstatuslist(String docstatuslist) {
        set(PROPERTY_DOCSTATUSLIST, docstatuslist);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isPRELiquidation() {
        return (Boolean) get(PROPERTY_PRELIQUIDATION);
    }

    public void setPRELiquidation(Boolean pRELiquidation) {
        set(PROPERTY_PRELIQUIDATION, pRELiquidation);
    }

    public String getLiquidate() {
        return (String) get(PROPERTY_LIQUIDATE);
    }

    public void setLiquidate(String liquidate) {
        set(PROPERTY_LIQUIDATE, liquidate);
    }

    public Boolean isPostLiquidation() {
        return (Boolean) get(PROPERTY_POSTLIQUIDATION);
    }

    public void setPostLiquidation(Boolean postLiquidation) {
        set(PROPERTY_POSTLIQUIDATION, postLiquidation);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isStatus() {
        return (Boolean) get(PROPERTY_STATUS);
    }

    public void setStatus(Boolean status) {
        set(PROPERTY_STATUS, status);
    }

    public Date getDatedoc() {
        return (Date) get(PROPERTY_DATEDOC);
    }

    public void setDatedoc(Date datedoc) {
        set(PROPERTY_DATEDOC, datedoc);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isDesprocessed() {
        return (Boolean) get(PROPERTY_DESPROCESSED);
    }

    public void setDesprocessed(Boolean desprocessed) {
        set(PROPERTY_DESPROCESSED, desprocessed);
    }

    public BigDecimal getCostTotal() {
        return (BigDecimal) get(PROPERTY_COSTTOTAL);
    }

    public void setCostTotal(BigDecimal costTotal) {
        set(PROPERTY_COSTTOTAL, costTotal);
    }

    public BigDecimal getTotalPaymentin() {
        return (BigDecimal) get(PROPERTY_TOTALPAYMENTIN);
    }

    public void setTotalPaymentin(BigDecimal totalPaymentin) {
        set(PROPERTY_TOTALPAYMENTIN, totalPaymentin);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Project getSproctmCProject() {
        return (Project) get(PROPERTY_SPROCTMCPROJECT);
    }

    public void setSproctmCProject(Project sproctmCProject) {
        set(PROPERTY_SPROCTMCPROJECT, sproctmCProject);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmInventorySettl> getSproctmInventorySettlList() {
      return (List<SproctmInventorySettl>) get(PROPERTY_SPROCTMINVENTORYSETTLLIST);
    }

    public void setSproctmInventorySettlList(List<SproctmInventorySettl> sproctmInventorySettlList) {
        set(PROPERTY_SPROCTMINVENTORYSETTLLIST, sproctmInventorySettlList);
    }

    @SuppressWarnings("unchecked")
    public List<ConsumptionLine> getSstpcConsumptionLineList() {
      return (List<ConsumptionLine>) get(PROPERTY_SSTPCCONSUMPTIONLINELIST);
    }

    public void setSstpcConsumptionLineList(List<ConsumptionLine> sstpcConsumptionLineList) {
        set(PROPERTY_SSTPCCONSUMPTIONLINELIST, sstpcConsumptionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PaymentLiquidationProject> getSstpcPaymentList() {
      return (List<PaymentLiquidationProject>) get(PROPERTY_SSTPCPAYMENTLIST);
    }

    public void setSstpcPaymentList(List<PaymentLiquidationProject> sstpcPaymentList) {
        set(PROPERTY_SSTPCPAYMENTLIST, sstpcPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcRelatedCosts> getSstpcRelatedCostsList() {
      return (List<SstpcRelatedCosts>) get(PROPERTY_SSTPCRELATEDCOSTSLIST);
    }

    public void setSstpcRelatedCostsList(List<SstpcRelatedCosts> sstpcRelatedCostsList) {
        set(PROPERTY_SSTPCRELATEDCOSTSLIST, sstpcRelatedCostsList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcRelatedRevenue> getSstpcRelatedRevenueList() {
      return (List<SstpcRelatedRevenue>) get(PROPERTY_SSTPCRELATEDREVENUELIST);
    }

    public void setSstpcRelatedRevenueList(List<SstpcRelatedRevenue> sstpcRelatedRevenueList) {
        set(PROPERTY_SSTPCRELATEDREVENUELIST, sstpcRelatedRevenueList);
    }

}

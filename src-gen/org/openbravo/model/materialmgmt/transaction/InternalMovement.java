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

import ec.com.sidesoft.localization.ecuador.resupply.ssrsresupply;
import ec.com.sidesoft.workorder.simplified.SswosTransfer;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.manufacturing.quality.Case;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.shipping.ShippingCompany;
/**
 * Entity class for entity MaterialMgmtInternalMovement (stored in table M_Movement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InternalMovement extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Movement";
    public static final String ENTITY_NAME = "MaterialMgmtInternalMovement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_TRXORGANIZATION = "trxOrganization";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_MOVEBETWEENLOCATORS = "moveBetweenLocators";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_SSRSRESUPPLY = "ssrsResupply";
    public static final String PROPERTY_SSRSISRESUPPLY = "ssrsIsresupply";
    public static final String PROPERTY_SSRSTYPERESUPPLY = "ssrsTyperesupply";
    public static final String PROPERTY_SSRSCDOCTYPE = "ssrsCDoctype";
    public static final String PROPERTY_EEISENDTOSRI = "eeiSendToSri";
    public static final String PROPERTY_SSRSMSHIPPER = "ssrsMShipper";
    public static final String PROPERTY_EEICODIGO = "eeiCodigo";
    public static final String PROPERTY_EEINUMAUTO = "eeiNumauto";
    public static final String PROPERTY_EEIFECHAAUTO = "eeiFechaauto";
    public static final String PROPERTY_EEIURLXML = "eeiUrlxml";
    public static final String PROPERTY_EEIURLRIDE = "eeiUrlride";
    public static final String PROPERTY_EEISTATUS = "eeiStatus";
    public static final String PROPERTY_SSVSBPREPOSITION = "ssvsBpreposition";
    public static final String PROPERTY_EEITEMPORALSEND = "eeiTemporalsend";
    public static final String PROPERTY_EEIDESCRIPTION = "eeiDescription";
    public static final String PROPERTY_SLQSMAPCCASE = "slqsMaPcCase";
    public static final String PROPERTY_SSINDOCTYPE = "ssinDoctype";
    public static final String PROPERTY_SSINDOCUMENTNO = "ssinDocumentno";
    public static final String PROPERTY_STATGENERATECODE = "statGenerateCode";
    public static final String PROPERTY_STATCODEAUTHORIZATION = "statCodeAuthorization";
    public static final String PROPERTY_SWHPMLOCATOR = "swhpMLocator";
    public static final String PROPERTY_SSPRJPROJECTPRODUCT = "ssprjProjectProduct";
    public static final String PROPERTY_STATCREATECODEDATE = "statCreateCodeDate";
    public static final String PROPERTY_STATPROCESSING = "statProcessing";
    public static final String PROPERTY_SWHPUBICACIONGENERAL = "swhpUbicaciongeneral";
    public static final String PROPERTY_SMVAIENDDATEOFTRANSPORT = "smvaiEnddateoftransport";
    public static final String PROPERTY_SMVAIROUTE = "sMVAIRoute";
    public static final String PROPERTY_SSFINMAWORKREQ = "ssfinMaWorkreq";
    public static final String PROPERTY_SPQULYISREFUND = "spqulyIsrefund";
    public static final String PROPERTY_SMVWHLOCATIONTRANSIT = "smvwhLocationTransit";
    public static final String PROPERTY_SMVWHGENERATEDRECEP = "smvwhGeneratedrecep";
    public static final String PROPERTY_SMVWHLOCATIONTO = "smvwhLocationTo";
    public static final String PROPERTY_SMVWHLOCATIONFROM = "smvwhLocationFrom";
    public static final String PROPERTY_SMVWHCREATELINES = "smvwhCreatelines";
    public static final String PROPERTY_SMVWHRECEIPDATE = "smvwhReceipdate";
    public static final String PROPERTY_CRPRODPRODPLAN = "crprodProdplan";
    public static final String PROPERTY_ECSPBCONFIRMATIONS = "ecspbConfirmations";
    public static final String PROPERTY_CRPRODLABEL = "crprodLabel";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODMOVEMENTIDLIST = "manufacturingMeasureShiftEMCrprodMovementIDList";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTEMSSPRODPMOVEMENTIDLIST = "manufacturingWorkRequirementEMSsprodpMovementIDList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST = "materialMgmtInternalMovementLineList";
    public static final String PROPERTY_SSWOSTRANSFERLIST = "sswosTransferList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_ECSPBPOSTED = "ecspbPosted";

    public InternalMovement() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_MOVEBETWEENLOCATORS, false);
        setDefaultValue(PROPERTY_SSRSISRESUPPLY, false);
        setDefaultValue(PROPERTY_SSRSTYPERESUPPLY, false);
        setDefaultValue(PROPERTY_EEISENDTOSRI, false);
        setDefaultValue(PROPERTY_SSVSBPREPOSITION, false);
        setDefaultValue(PROPERTY_EEITEMPORALSEND, false);
        setDefaultValue(PROPERTY_STATGENERATECODE, false);
        setDefaultValue(PROPERTY_SSPRJPROJECTPRODUCT, false);
        setDefaultValue(PROPERTY_STATPROCESSING, false);
        setDefaultValue(PROPERTY_SWHPUBICACIONGENERAL, false);
        setDefaultValue(PROPERTY_SPQULYISREFUND, false);
        setDefaultValue(PROPERTY_SMVWHGENERATEDRECEP, false);
        setDefaultValue(PROPERTY_SMVWHCREATELINES, false);
        setDefaultValue(PROPERTY_ECSPBCONFIRMATIONS, false);
        setDefaultValue(PROPERTY_CRPRODLABEL, false);
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODMOVEMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTEMSSPRODPMOVEMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSTRANSFERLIST, new ArrayList<Object>());
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

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
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

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
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

    public Boolean isMoveBetweenLocators() {
        return (Boolean) get(PROPERTY_MOVEBETWEENLOCATORS);
    }

    public void setMoveBetweenLocators(Boolean moveBetweenLocators) {
        set(PROPERTY_MOVEBETWEENLOCATORS, moveBetweenLocators);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public ssrsresupply getSsrsResupply() {
        return (ssrsresupply) get(PROPERTY_SSRSRESUPPLY);
    }

    public void setSsrsResupply(ssrsresupply ssrsResupply) {
        set(PROPERTY_SSRSRESUPPLY, ssrsResupply);
    }

    public Boolean isSsrsIsresupply() {
        return (Boolean) get(PROPERTY_SSRSISRESUPPLY);
    }

    public void setSsrsIsresupply(Boolean ssrsIsresupply) {
        set(PROPERTY_SSRSISRESUPPLY, ssrsIsresupply);
    }

    public Boolean isSsrsTyperesupply() {
        return (Boolean) get(PROPERTY_SSRSTYPERESUPPLY);
    }

    public void setSsrsTyperesupply(Boolean ssrsTyperesupply) {
        set(PROPERTY_SSRSTYPERESUPPLY, ssrsTyperesupply);
    }

    public DocumentType getSsrsCDoctype() {
        return (DocumentType) get(PROPERTY_SSRSCDOCTYPE);
    }

    public void setSsrsCDoctype(DocumentType ssrsCDoctype) {
        set(PROPERTY_SSRSCDOCTYPE, ssrsCDoctype);
    }

    public Boolean isEeiSendToSri() {
        return (Boolean) get(PROPERTY_EEISENDTOSRI);
    }

    public void setEeiSendToSri(Boolean eeiSendToSri) {
        set(PROPERTY_EEISENDTOSRI, eeiSendToSri);
    }

    public ShippingCompany getSsrsMShipper() {
        return (ShippingCompany) get(PROPERTY_SSRSMSHIPPER);
    }

    public void setSsrsMShipper(ShippingCompany ssrsMShipper) {
        set(PROPERTY_SSRSMSHIPPER, ssrsMShipper);
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

    public Boolean isSsvsBpreposition() {
        return (Boolean) get(PROPERTY_SSVSBPREPOSITION);
    }

    public void setSsvsBpreposition(Boolean ssvsBpreposition) {
        set(PROPERTY_SSVSBPREPOSITION, ssvsBpreposition);
    }

    public Boolean isEeiTemporalsend() {
        return (Boolean) get(PROPERTY_EEITEMPORALSEND);
    }

    public void setEeiTemporalsend(Boolean eeiTemporalsend) {
        set(PROPERTY_EEITEMPORALSEND, eeiTemporalsend);
    }

    public String getEeiDescription() {
        return (String) get(PROPERTY_EEIDESCRIPTION);
    }

    public void setEeiDescription(String eeiDescription) {
        set(PROPERTY_EEIDESCRIPTION, eeiDescription);
    }

    public Case getSlqsMaPcCase() {
        return (Case) get(PROPERTY_SLQSMAPCCASE);
    }

    public void setSlqsMaPcCase(Case slqsMaPcCase) {
        set(PROPERTY_SLQSMAPCCASE, slqsMaPcCase);
    }

    public DocumentType getSsinDoctype() {
        return (DocumentType) get(PROPERTY_SSINDOCTYPE);
    }

    public void setSsinDoctype(DocumentType ssinDoctype) {
        set(PROPERTY_SSINDOCTYPE, ssinDoctype);
    }

    public String getSsinDocumentno() {
        return (String) get(PROPERTY_SSINDOCUMENTNO);
    }

    public void setSsinDocumentno(String ssinDocumentno) {
        set(PROPERTY_SSINDOCUMENTNO, ssinDocumentno);
    }

    public Boolean isStatGenerateCode() {
        return (Boolean) get(PROPERTY_STATGENERATECODE);
    }

    public void setStatGenerateCode(Boolean statGenerateCode) {
        set(PROPERTY_STATGENERATECODE, statGenerateCode);
    }

    public String getStatCodeAuthorization() {
        return (String) get(PROPERTY_STATCODEAUTHORIZATION);
    }

    public void setStatCodeAuthorization(String statCodeAuthorization) {
        set(PROPERTY_STATCODEAUTHORIZATION, statCodeAuthorization);
    }

    public Locator getSwhpMLocator() {
        return (Locator) get(PROPERTY_SWHPMLOCATOR);
    }

    public void setSwhpMLocator(Locator swhpMLocator) {
        set(PROPERTY_SWHPMLOCATOR, swhpMLocator);
    }

    public Boolean isSsprjProjectProduct() {
        return (Boolean) get(PROPERTY_SSPRJPROJECTPRODUCT);
    }

    public void setSsprjProjectProduct(Boolean ssprjProjectProduct) {
        set(PROPERTY_SSPRJPROJECTPRODUCT, ssprjProjectProduct);
    }

    public Date getStatCreateCodeDate() {
        return (Date) get(PROPERTY_STATCREATECODEDATE);
    }

    public void setStatCreateCodeDate(Date statCreateCodeDate) {
        set(PROPERTY_STATCREATECODEDATE, statCreateCodeDate);
    }

    public Boolean isStatProcessing() {
        return (Boolean) get(PROPERTY_STATPROCESSING);
    }

    public void setStatProcessing(Boolean statProcessing) {
        set(PROPERTY_STATPROCESSING, statProcessing);
    }

    public Boolean isSwhpUbicaciongeneral() {
        return (Boolean) get(PROPERTY_SWHPUBICACIONGENERAL);
    }

    public void setSwhpUbicaciongeneral(Boolean swhpUbicaciongeneral) {
        set(PROPERTY_SWHPUBICACIONGENERAL, swhpUbicaciongeneral);
    }

    public Date getSmvaiEnddateoftransport() {
        return (Date) get(PROPERTY_SMVAIENDDATEOFTRANSPORT);
    }

    public void setSmvaiEnddateoftransport(Date smvaiEnddateoftransport) {
        set(PROPERTY_SMVAIENDDATEOFTRANSPORT, smvaiEnddateoftransport);
    }

    public String getSMVAIRoute() {
        return (String) get(PROPERTY_SMVAIROUTE);
    }

    public void setSMVAIRoute(String sMVAIRoute) {
        set(PROPERTY_SMVAIROUTE, sMVAIRoute);
    }

    public WorkRequirement getSsfinMaWorkreq() {
        return (WorkRequirement) get(PROPERTY_SSFINMAWORKREQ);
    }

    public void setSsfinMaWorkreq(WorkRequirement ssfinMaWorkreq) {
        set(PROPERTY_SSFINMAWORKREQ, ssfinMaWorkreq);
    }

    public Boolean isSpqulyIsrefund() {
        return (Boolean) get(PROPERTY_SPQULYISREFUND);
    }

    public void setSpqulyIsrefund(Boolean spqulyIsrefund) {
        set(PROPERTY_SPQULYISREFUND, spqulyIsrefund);
    }

    public Locator getSmvwhLocationTransit() {
        return (Locator) get(PROPERTY_SMVWHLOCATIONTRANSIT);
    }

    public void setSmvwhLocationTransit(Locator smvwhLocationTransit) {
        set(PROPERTY_SMVWHLOCATIONTRANSIT, smvwhLocationTransit);
    }

    public Boolean isSmvwhGeneratedrecep() {
        return (Boolean) get(PROPERTY_SMVWHGENERATEDRECEP);
    }

    public void setSmvwhGeneratedrecep(Boolean smvwhGeneratedrecep) {
        set(PROPERTY_SMVWHGENERATEDRECEP, smvwhGeneratedrecep);
    }

    public Locator getSmvwhLocationTo() {
        return (Locator) get(PROPERTY_SMVWHLOCATIONTO);
    }

    public void setSmvwhLocationTo(Locator smvwhLocationTo) {
        set(PROPERTY_SMVWHLOCATIONTO, smvwhLocationTo);
    }

    public Locator getSmvwhLocationFrom() {
        return (Locator) get(PROPERTY_SMVWHLOCATIONFROM);
    }

    public void setSmvwhLocationFrom(Locator smvwhLocationFrom) {
        set(PROPERTY_SMVWHLOCATIONFROM, smvwhLocationFrom);
    }

    public Boolean isSmvwhCreatelines() {
        return (Boolean) get(PROPERTY_SMVWHCREATELINES);
    }

    public void setSmvwhCreatelines(Boolean smvwhCreatelines) {
        set(PROPERTY_SMVWHCREATELINES, smvwhCreatelines);
    }

    public Date getSmvwhReceipdate() {
        return (Date) get(PROPERTY_SMVWHRECEIPDATE);
    }

    public void setSmvwhReceipdate(Date smvwhReceipdate) {
        set(PROPERTY_SMVWHRECEIPDATE, smvwhReceipdate);
    }

    public ProductionPlan getCrprodProdplan() {
        return (ProductionPlan) get(PROPERTY_CRPRODPRODPLAN);
    }

    public void setCrprodProdplan(ProductionPlan crprodProdplan) {
        set(PROPERTY_CRPRODPRODPLAN, crprodProdplan);
    }

    public Boolean isEcspbConfirmations() {
        return (Boolean) get(PROPERTY_ECSPBCONFIRMATIONS);
    }

    public void setEcspbConfirmations(Boolean ecspbConfirmations) {
        set(PROPERTY_ECSPBCONFIRMATIONS, ecspbConfirmations);
    }

    public Boolean isCrprodLabel() {
        return (Boolean) get(PROPERTY_CRPRODLABEL);
    }

    public void setCrprodLabel(Boolean crprodLabel) {
        set(PROPERTY_CRPRODLABEL, crprodLabel);
    }

    public String getEcspbPosted() {
        return (String) get(COMPUTED_COLUMN_ECSPBPOSTED);
    }

    public void setEcspbPosted(String ecspbPosted) {
        set(COMPUTED_COLUMN_ECSPBPOSTED, ecspbPosted);
    }

    public InternalMovement_ComputedColumns get_computedColumns() {
        return (InternalMovement_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(InternalMovement_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMCrprodMovementIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODMOVEMENTIDLIST);
    }

    public void setManufacturingMeasureShiftEMCrprodMovementIDList(List<MeasureShift> manufacturingMeasureShiftEMCrprodMovementIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODMOVEMENTIDLIST, manufacturingMeasureShiftEMCrprodMovementIDList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirement> getManufacturingWorkRequirementEMSsprodpMovementIDList() {
      return (List<WorkRequirement>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTEMSSPRODPMOVEMENTIDLIST);
    }

    public void setManufacturingWorkRequirementEMSsprodpMovementIDList(List<WorkRequirement> manufacturingWorkRequirementEMSsprodpMovementIDList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTEMSSPRODPMOVEMENTIDLIST, manufacturingWorkRequirementEMSsprodpMovementIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST);
    }

    public void setMaterialMgmtInternalMovementLineList(List<InternalMovementLine> materialMgmtInternalMovementLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, materialMgmtInternalMovementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosTransfer> getSswosTransferList() {
      return (List<SswosTransfer>) get(PROPERTY_SSWOSTRANSFERLIST);
    }

    public void setSswosTransferList(List<SswosTransfer> sswosTransferList) {
        set(PROPERTY_SSWOSTRANSFERLIST, sswosTransferList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_ECSPBPOSTED.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getEcspbPosted();
      }
    
      return super.get(propName);
    }
}

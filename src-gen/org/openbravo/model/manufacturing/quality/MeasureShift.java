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
package org.openbravo.model.manufacturing.quality;

import ec.com.sidesoft.carnidem.production.quality.crprqy_paramsstatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
/**
 * Entity class for entity ManufacturingMeasureShift (stored in table MA_Measure_Shift).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MeasureShift extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Measure_Shift";
    public static final String ENTITY_NAME = "ManufacturingMeasureShift";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SHIFT = "shift";
    public static final String PROPERTY_MEASUREMENTDATE = "measurementDate";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_EDITMEASUREMENTS = "editMeasurements";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SPQULYQUALITYCONTROLTYPE = "spqulyQualitycontroltype";
    public static final String PROPERTY_SSPQRQUALITYREPORT = "sspqrQualityReport";
    public static final String PROPERTY_SSPQRQUALITYCONTROLRPT = "sspqrQualityControlRpt";
    public static final String PROPERTY_SSFDCSTATUS = "ssfdcStatus";
    public static final String PROPERTY_SSFDCCOMPLETED = "ssfdcCompleted";
    public static final String PROPERTY_SSFDCCANCELLED = "ssfdcCancelled";
    public static final String PROPERTY_CRPRODCDOCTYPETARGET = "crprodCDoctypetarget";
    public static final String PROPERTY_CRPRODDOCUMENTNO = "crprodDocumentno";
    public static final String PROPERTY_SPQULYSUPPLIER = "spqulySupplier";
    public static final String PROPERTY_SPQULYINOUT = "spqulyInout";
    public static final String PROPERTY_CRPRODCOMPLETED = "crprodCompleted";
    public static final String PROPERTY_SPQULYPRODUCT = "spqulyProduct";
    public static final String PROPERTY_CRPRODSTATUS = "crprodStatus";
    public static final String PROPERTY_SPQULYDELIVERDATE = "spqulyDeliverdate";
    public static final String PROPERTY_CRPRODORDERLINE = "crprodOrderline";
    public static final String PROPERTY_SPQULYLICENSEPLATE = "spqulyLicenseplate";
    public static final String PROPERTY_CRPRODUNITPRICE = "crprodUnitprice";
    public static final String PROPERTY_SPQULYCHECKIN = "spqulyCheckin";
    public static final String PROPERTY_CRPRODMOVEMENT = "crprodMovement";
    public static final String PROPERTY_CRPRODSAFETYQUALITYRPT = "crprodSafetyqualityrpt";
    public static final String PROPERTY_SPQULYTOTALQTY = "spqulyTotalqty";
    public static final String PROPERTY_CRPRODCOMPLETEDFPQ = "crprodCompletedfpq";
    public static final String PROPERTY_SPQULYUOM = "spqulyUom";
    public static final String PROPERTY_SPQULYATTRSI = "spqulyAttrsi";
    public static final String PROPERTY_SPQULYSAMPLESIZE = "spqulySamplesize";
    public static final String PROPERTY_SPQULYOUTSIDECLEANLINESS = "spqulyOutsidecleanliness";
    public static final String PROPERTY_SPQULYINSIDECLEANLINESS = "spqulyInsidecleanliness";
    public static final String PROPERTY_SPQULYPROTECTIONPOLLUTION = "spqulyProtectionpollution";
    public static final String PROPERTY_SPQULYTAKES = "spqulyTakes";
    public static final String PROPERTY_SPQULYSTATES = "spqulyStates";
    public static final String PROPERTY_SPQULYFINISHEDPROD = "spqulyFinishedprod";
    public static final String PROPERTY_SPQULYWORKREQ = "spqulyWorkreq";
    public static final String PROPERTY_SPQULYWORKEFFORT = "spqulyWorkeffort";
    public static final String PROPERTY_SPQULYSTARTTIME = "spqulyStarttime";
    public static final String PROPERTY_SPQULYENDTIME = "spqulyEndtime";
    public static final String PROPERTY_SPQULYFREQUENCY = "spqulyFrequency";
    public static final String PROPERTY_SPQULYPRODLEADER = "spqulyProdleader";
    public static final String PROPERTY_SPQULYQANALYST = "spqulyQanalyst";
    public static final String PROPERTY_SPQULYSALESPRICE = "spqulySalesprice";
    public static final String PROPERTY_SPQULYIRBP = "spqulyIrbp";
    public static final String PROPERTY_SPQULYCCP = "spqulyCcp";
    public static final String PROPERTY_MANUFACTURINGMEASUREGROUPLIST = "manufacturingMeasureGroupList";

    public MeasureShift() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_EDITMEASUREMENTS, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_SPQULYQUALITYCONTROLTYPE, "RMQ");
        setDefaultValue(PROPERTY_SSPQRQUALITYREPORT, false);
        setDefaultValue(PROPERTY_SSPQRQUALITYCONTROLRPT, false);
        setDefaultValue(PROPERTY_SSFDCSTATUS, "DR");
        setDefaultValue(PROPERTY_SSFDCCOMPLETED, false);
        setDefaultValue(PROPERTY_SSFDCCANCELLED, false);
        setDefaultValue(PROPERTY_CRPRODCOMPLETED, false);
        setDefaultValue(PROPERTY_CRPRODUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_CRPRODSAFETYQUALITYRPT, false);
        setDefaultValue(PROPERTY_CRPRODCOMPLETEDFPQ, false);
        setDefaultValue(PROPERTY_MANUFACTURINGMEASUREGROUPLIST, new ArrayList<Object>());
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

    public String getShift() {
        return (String) get(PROPERTY_SHIFT);
    }

    public void setShift(String shift) {
        set(PROPERTY_SHIFT, shift);
    }

    public Date getMeasurementDate() {
        return (Date) get(PROPERTY_MEASUREMENTDATE);
    }

    public void setMeasurementDate(Date measurementDate) {
        set(PROPERTY_MEASUREMENTDATE, measurementDate);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Boolean isEditMeasurements() {
        return (Boolean) get(PROPERTY_EDITMEASUREMENTS);
    }

    public void setEditMeasurements(Boolean editMeasurements) {
        set(PROPERTY_EDITMEASUREMENTS, editMeasurements);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getSpqulyQualitycontroltype() {
        return (String) get(PROPERTY_SPQULYQUALITYCONTROLTYPE);
    }

    public void setSpqulyQualitycontroltype(String spqulyQualitycontroltype) {
        set(PROPERTY_SPQULYQUALITYCONTROLTYPE, spqulyQualitycontroltype);
    }

    public Boolean isSspqrQualityReport() {
        return (Boolean) get(PROPERTY_SSPQRQUALITYREPORT);
    }

    public void setSspqrQualityReport(Boolean sspqrQualityReport) {
        set(PROPERTY_SSPQRQUALITYREPORT, sspqrQualityReport);
    }

    public Boolean isSspqrQualityControlRpt() {
        return (Boolean) get(PROPERTY_SSPQRQUALITYCONTROLRPT);
    }

    public void setSspqrQualityControlRpt(Boolean sspqrQualityControlRpt) {
        set(PROPERTY_SSPQRQUALITYCONTROLRPT, sspqrQualityControlRpt);
    }

    public String getSsfdcStatus() {
        return (String) get(PROPERTY_SSFDCSTATUS);
    }

    public void setSsfdcStatus(String ssfdcStatus) {
        set(PROPERTY_SSFDCSTATUS, ssfdcStatus);
    }

    public Boolean isSsfdcCompleted() {
        return (Boolean) get(PROPERTY_SSFDCCOMPLETED);
    }

    public void setSsfdcCompleted(Boolean ssfdcCompleted) {
        set(PROPERTY_SSFDCCOMPLETED, ssfdcCompleted);
    }

    public Boolean isSsfdcCancelled() {
        return (Boolean) get(PROPERTY_SSFDCCANCELLED);
    }

    public void setSsfdcCancelled(Boolean ssfdcCancelled) {
        set(PROPERTY_SSFDCCANCELLED, ssfdcCancelled);
    }

    public DocumentType getCrprodCDoctypetarget() {
        return (DocumentType) get(PROPERTY_CRPRODCDOCTYPETARGET);
    }

    public void setCrprodCDoctypetarget(DocumentType crprodCDoctypetarget) {
        set(PROPERTY_CRPRODCDOCTYPETARGET, crprodCDoctypetarget);
    }

    public String getCrprodDocumentno() {
        return (String) get(PROPERTY_CRPRODDOCUMENTNO);
    }

    public void setCrprodDocumentno(String crprodDocumentno) {
        set(PROPERTY_CRPRODDOCUMENTNO, crprodDocumentno);
    }

    public BusinessPartner getSpqulySupplier() {
        return (BusinessPartner) get(PROPERTY_SPQULYSUPPLIER);
    }

    public void setSpqulySupplier(BusinessPartner spqulySupplier) {
        set(PROPERTY_SPQULYSUPPLIER, spqulySupplier);
    }

    public ShipmentInOut getSpqulyInout() {
        return (ShipmentInOut) get(PROPERTY_SPQULYINOUT);
    }

    public void setSpqulyInout(ShipmentInOut spqulyInout) {
        set(PROPERTY_SPQULYINOUT, spqulyInout);
    }

    public Boolean isCrprodCompleted() {
        return (Boolean) get(PROPERTY_CRPRODCOMPLETED);
    }

    public void setCrprodCompleted(Boolean crprodCompleted) {
        set(PROPERTY_CRPRODCOMPLETED, crprodCompleted);
    }

    public Product getSpqulyProduct() {
        return (Product) get(PROPERTY_SPQULYPRODUCT);
    }

    public void setSpqulyProduct(Product spqulyProduct) {
        set(PROPERTY_SPQULYPRODUCT, spqulyProduct);
    }

    public crprqy_paramsstatus getCrprodStatus() {
        return (crprqy_paramsstatus) get(PROPERTY_CRPRODSTATUS);
    }

    public void setCrprodStatus(crprqy_paramsstatus crprodStatus) {
        set(PROPERTY_CRPRODSTATUS, crprodStatus);
    }

    public Date getSpqulyDeliverdate() {
        return (Date) get(PROPERTY_SPQULYDELIVERDATE);
    }

    public void setSpqulyDeliverdate(Date spqulyDeliverdate) {
        set(PROPERTY_SPQULYDELIVERDATE, spqulyDeliverdate);
    }

    public OrderLine getCrprodOrderline() {
        return (OrderLine) get(PROPERTY_CRPRODORDERLINE);
    }

    public void setCrprodOrderline(OrderLine crprodOrderline) {
        set(PROPERTY_CRPRODORDERLINE, crprodOrderline);
    }

    public String getSpqulyLicenseplate() {
        return (String) get(PROPERTY_SPQULYLICENSEPLATE);
    }

    public void setSpqulyLicenseplate(String spqulyLicenseplate) {
        set(PROPERTY_SPQULYLICENSEPLATE, spqulyLicenseplate);
    }

    public BigDecimal getCrprodUnitprice() {
        return (BigDecimal) get(PROPERTY_CRPRODUNITPRICE);
    }

    public void setCrprodUnitprice(BigDecimal crprodUnitprice) {
        set(PROPERTY_CRPRODUNITPRICE, crprodUnitprice);
    }

    public String getSpqulyCheckin() {
        return (String) get(PROPERTY_SPQULYCHECKIN);
    }

    public void setSpqulyCheckin(String spqulyCheckin) {
        set(PROPERTY_SPQULYCHECKIN, spqulyCheckin);
    }

    public InternalMovement getCrprodMovement() {
        return (InternalMovement) get(PROPERTY_CRPRODMOVEMENT);
    }

    public void setCrprodMovement(InternalMovement crprodMovement) {
        set(PROPERTY_CRPRODMOVEMENT, crprodMovement);
    }

    public Boolean isCrprodSafetyqualityrpt() {
        return (Boolean) get(PROPERTY_CRPRODSAFETYQUALITYRPT);
    }

    public void setCrprodSafetyqualityrpt(Boolean crprodSafetyqualityrpt) {
        set(PROPERTY_CRPRODSAFETYQUALITYRPT, crprodSafetyqualityrpt);
    }

    public BigDecimal getSpqulyTotalqty() {
        return (BigDecimal) get(PROPERTY_SPQULYTOTALQTY);
    }

    public void setSpqulyTotalqty(BigDecimal spqulyTotalqty) {
        set(PROPERTY_SPQULYTOTALQTY, spqulyTotalqty);
    }

    public Boolean isCrprodCompletedfpq() {
        return (Boolean) get(PROPERTY_CRPRODCOMPLETEDFPQ);
    }

    public void setCrprodCompletedfpq(Boolean crprodCompletedfpq) {
        set(PROPERTY_CRPRODCOMPLETEDFPQ, crprodCompletedfpq);
    }

    public UOM getSpqulyUom() {
        return (UOM) get(PROPERTY_SPQULYUOM);
    }

    public void setSpqulyUom(UOM spqulyUom) {
        set(PROPERTY_SPQULYUOM, spqulyUom);
    }

    public AttributeSetInstance getSpqulyAttrsi() {
        return (AttributeSetInstance) get(PROPERTY_SPQULYATTRSI);
    }

    public void setSpqulyAttrsi(AttributeSetInstance spqulyAttrsi) {
        set(PROPERTY_SPQULYATTRSI, spqulyAttrsi);
    }

    public String getSpqulySamplesize() {
        return (String) get(PROPERTY_SPQULYSAMPLESIZE);
    }

    public void setSpqulySamplesize(String spqulySamplesize) {
        set(PROPERTY_SPQULYSAMPLESIZE, spqulySamplesize);
    }

    public String getSpqulyOutsidecleanliness() {
        return (String) get(PROPERTY_SPQULYOUTSIDECLEANLINESS);
    }

    public void setSpqulyOutsidecleanliness(String spqulyOutsidecleanliness) {
        set(PROPERTY_SPQULYOUTSIDECLEANLINESS, spqulyOutsidecleanliness);
    }

    public String getSpqulyInsidecleanliness() {
        return (String) get(PROPERTY_SPQULYINSIDECLEANLINESS);
    }

    public void setSpqulyInsidecleanliness(String spqulyInsidecleanliness) {
        set(PROPERTY_SPQULYINSIDECLEANLINESS, spqulyInsidecleanliness);
    }

    public String getSpqulyProtectionpollution() {
        return (String) get(PROPERTY_SPQULYPROTECTIONPOLLUTION);
    }

    public void setSpqulyProtectionpollution(String spqulyProtectionpollution) {
        set(PROPERTY_SPQULYPROTECTIONPOLLUTION, spqulyProtectionpollution);
    }

    public Long getSpqulyTakes() {
        return (Long) get(PROPERTY_SPQULYTAKES);
    }

    public void setSpqulyTakes(Long spqulyTakes) {
        set(PROPERTY_SPQULYTAKES, spqulyTakes);
    }

    public String getSpqulyStates() {
        return (String) get(PROPERTY_SPQULYSTATES);
    }

    public void setSpqulyStates(String spqulyStates) {
        set(PROPERTY_SPQULYSTATES, spqulyStates);
    }

    public Product getSpqulyFinishedprod() {
        return (Product) get(PROPERTY_SPQULYFINISHEDPROD);
    }

    public void setSpqulyFinishedprod(Product spqulyFinishedprod) {
        set(PROPERTY_SPQULYFINISHEDPROD, spqulyFinishedprod);
    }

    public WorkRequirement getSpqulyWorkreq() {
        return (WorkRequirement) get(PROPERTY_SPQULYWORKREQ);
    }

    public void setSpqulyWorkreq(WorkRequirement spqulyWorkreq) {
        set(PROPERTY_SPQULYWORKREQ, spqulyWorkreq);
    }

    public ProductionTransaction getSpqulyWorkeffort() {
        return (ProductionTransaction) get(PROPERTY_SPQULYWORKEFFORT);
    }

    public void setSpqulyWorkeffort(ProductionTransaction spqulyWorkeffort) {
        set(PROPERTY_SPQULYWORKEFFORT, spqulyWorkeffort);
    }

    public Timestamp getSpqulyStarttime() {
        return (Timestamp) get(PROPERTY_SPQULYSTARTTIME);
    }

    public void setSpqulyStarttime(Timestamp spqulyStarttime) {
        set(PROPERTY_SPQULYSTARTTIME, spqulyStarttime);
    }

    public Timestamp getSpqulyEndtime() {
        return (Timestamp) get(PROPERTY_SPQULYENDTIME);
    }

    public void setSpqulyEndtime(Timestamp spqulyEndtime) {
        set(PROPERTY_SPQULYENDTIME, spqulyEndtime);
    }

    public Timestamp getSpqulyFrequency() {
        return (Timestamp) get(PROPERTY_SPQULYFREQUENCY);
    }

    public void setSpqulyFrequency(Timestamp spqulyFrequency) {
        set(PROPERTY_SPQULYFREQUENCY, spqulyFrequency);
    }

    public BusinessPartner getSpqulyProdleader() {
        return (BusinessPartner) get(PROPERTY_SPQULYPRODLEADER);
    }

    public void setSpqulyProdleader(BusinessPartner spqulyProdleader) {
        set(PROPERTY_SPQULYPRODLEADER, spqulyProdleader);
    }

    public BusinessPartner getSpqulyQanalyst() {
        return (BusinessPartner) get(PROPERTY_SPQULYQANALYST);
    }

    public void setSpqulyQanalyst(BusinessPartner spqulyQanalyst) {
        set(PROPERTY_SPQULYQANALYST, spqulyQanalyst);
    }

    public BigDecimal getSpqulySalesprice() {
        return (BigDecimal) get(PROPERTY_SPQULYSALESPRICE);
    }

    public void setSpqulySalesprice(BigDecimal spqulySalesprice) {
        set(PROPERTY_SPQULYSALESPRICE, spqulySalesprice);
    }

    public BigDecimal getSpqulyIrbp() {
        return (BigDecimal) get(PROPERTY_SPQULYIRBP);
    }

    public void setSpqulyIrbp(BigDecimal spqulyIrbp) {
        set(PROPERTY_SPQULYIRBP, spqulyIrbp);
    }

    public CheckPointSet getSpqulyCcp() {
        return (CheckPointSet) get(PROPERTY_SPQULYCCP);
    }

    public void setSpqulyCcp(CheckPointSet spqulyCcp) {
        set(PROPERTY_SPQULYCCP, spqulyCcp);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureGroup> getManufacturingMeasureGroupList() {
      return (List<MeasureGroup>) get(PROPERTY_MANUFACTURINGMEASUREGROUPLIST);
    }

    public void setManufacturingMeasureGroupList(List<MeasureGroup> manufacturingMeasureGroupList) {
        set(PROPERTY_MANUFACTURINGMEASUREGROUPLIST, manufacturingMeasureGroupList);
    }

}

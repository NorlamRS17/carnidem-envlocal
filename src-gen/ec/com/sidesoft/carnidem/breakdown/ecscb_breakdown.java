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
package ec.com.sidesoft.carnidem.breakdown;

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
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
/**
 * Entity class for entity ecscb_breakdown (stored in table ecscb_breakdown).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ecscb_breakdown extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ecscb_breakdown";
    public static final String ENTITY_NAME = "ecscb_breakdown";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TRANSACTIONDOCUMENT = "transactionDocument";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_CONSULTATIONDATE = "consultationDate";
    public static final String PROPERTY_GOODSSHIPMENT = "goodsShipment";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_RECORDTYPE = "recordType";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_WAREHOUSEENTRYNO = "warehouseEntryNo";
    public static final String PROPERTY_ENTRYDATE = "entryDate";
    public static final String PROPERTY_CARCASSBREAKDOWNDATE = "carcassBreakdownDate";
    public static final String PROPERTY_TOTALMASS = "totalMass";
    public static final String PROPERTY_NUMBEROFPIECES = "numberOfPieces";
    public static final String PROPERTY_MASSPERPIECE = "massPerPiece";
    public static final String PROPERTY_UNITCOST = "unitCost";
    public static final String PROPERTY_PURCHASEVALUE = "purchaseValue";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_BTNCOMPLETE = "bTNComplete";
    public static final String PROPERTY_BTNTYPEBREAKDOWN = "bTNTypeBreakdown";
    public static final String PROPERTY_ECSCBPROCESSCODE = "ecscbProcessCode";
    public static final String PROPERTY_BTNCREATEINVENTORY = "bTNCreateInventory";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTEMECSCBBREAKDOWNIDLIST = "materialMgmtInventoryCountEMEcscbBreakdownIDList";
    public static final String PROPERTY_ECSCBBREAKDOWNLINELIST = "ecscbBreakdownLineList";

    public ecscb_breakdown() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_BTNCOMPLETE, false);
        setDefaultValue(PROPERTY_BTNTYPEBREAKDOWN, false);
        setDefaultValue(PROPERTY_BTNCREATEINVENTORY, false);
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTEMECSCBBREAKDOWNIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBBREAKDOWNLINELIST, new ArrayList<Object>());
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

    public DocumentType getTransactionDocument() {
        return (DocumentType) get(PROPERTY_TRANSACTIONDOCUMENT);
    }

    public void setTransactionDocument(DocumentType transactionDocument) {
        set(PROPERTY_TRANSACTIONDOCUMENT, transactionDocument);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getConsultationDate() {
        return (Date) get(PROPERTY_CONSULTATIONDATE);
    }

    public void setConsultationDate(Date consultationDate) {
        set(PROPERTY_CONSULTATIONDATE, consultationDate);
    }

    public ShipmentInOut getGoodsShipment() {
        return (ShipmentInOut) get(PROPERTY_GOODSSHIPMENT);
    }

    public void setGoodsShipment(ShipmentInOut goodsShipment) {
        set(PROPERTY_GOODSSHIPMENT, goodsShipment);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public ecscb_TypeBreakdown getRecordType() {
        return (ecscb_TypeBreakdown) get(PROPERTY_RECORDTYPE);
    }

    public void setRecordType(ecscb_TypeBreakdown recordType) {
        set(PROPERTY_RECORDTYPE, recordType);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getWarehouseEntryNo() {
        return (String) get(PROPERTY_WAREHOUSEENTRYNO);
    }

    public void setWarehouseEntryNo(String warehouseEntryNo) {
        set(PROPERTY_WAREHOUSEENTRYNO, warehouseEntryNo);
    }

    public Date getEntryDate() {
        return (Date) get(PROPERTY_ENTRYDATE);
    }

    public void setEntryDate(Date entryDate) {
        set(PROPERTY_ENTRYDATE, entryDate);
    }

    public Date getCarcassBreakdownDate() {
        return (Date) get(PROPERTY_CARCASSBREAKDOWNDATE);
    }

    public void setCarcassBreakdownDate(Date carcassBreakdownDate) {
        set(PROPERTY_CARCASSBREAKDOWNDATE, carcassBreakdownDate);
    }

    public BigDecimal getTotalMass() {
        return (BigDecimal) get(PROPERTY_TOTALMASS);
    }

    public void setTotalMass(BigDecimal totalMass) {
        set(PROPERTY_TOTALMASS, totalMass);
    }

    public Long getNumberOfPieces() {
        return (Long) get(PROPERTY_NUMBEROFPIECES);
    }

    public void setNumberOfPieces(Long numberOfPieces) {
        set(PROPERTY_NUMBEROFPIECES, numberOfPieces);
    }

    public BigDecimal getMassPerPiece() {
        return (BigDecimal) get(PROPERTY_MASSPERPIECE);
    }

    public void setMassPerPiece(BigDecimal massPerPiece) {
        set(PROPERTY_MASSPERPIECE, massPerPiece);
    }

    public BigDecimal getUnitCost() {
        return (BigDecimal) get(PROPERTY_UNITCOST);
    }

    public void setUnitCost(BigDecimal unitCost) {
        set(PROPERTY_UNITCOST, unitCost);
    }

    public BigDecimal getPurchaseValue() {
        return (BigDecimal) get(PROPERTY_PURCHASEVALUE);
    }

    public void setPurchaseValue(BigDecimal purchaseValue) {
        set(PROPERTY_PURCHASEVALUE, purchaseValue);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Boolean isBTNComplete() {
        return (Boolean) get(PROPERTY_BTNCOMPLETE);
    }

    public void setBTNComplete(Boolean bTNComplete) {
        set(PROPERTY_BTNCOMPLETE, bTNComplete);
    }

    public Boolean isBTNTypeBreakdown() {
        return (Boolean) get(PROPERTY_BTNTYPEBREAKDOWN);
    }

    public void setBTNTypeBreakdown(Boolean bTNTypeBreakdown) {
        set(PROPERTY_BTNTYPEBREAKDOWN, bTNTypeBreakdown);
    }

    public ecscb_processCode getEcscbProcessCode() {
        return (ecscb_processCode) get(PROPERTY_ECSCBPROCESSCODE);
    }

    public void setEcscbProcessCode(ecscb_processCode ecscbProcessCode) {
        set(PROPERTY_ECSCBPROCESSCODE, ecscbProcessCode);
    }

    public Boolean isBTNCreateInventory() {
        return (Boolean) get(PROPERTY_BTNCREATEINVENTORY);
    }

    public void setBTNCreateInventory(Boolean bTNCreateInventory) {
        set(PROPERTY_BTNCREATEINVENTORY, bTNCreateInventory);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCount> getMaterialMgmtInventoryCountEMEcscbBreakdownIDList() {
      return (List<InventoryCount>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTEMECSCBBREAKDOWNIDLIST);
    }

    public void setMaterialMgmtInventoryCountEMEcscbBreakdownIDList(List<InventoryCount> materialMgmtInventoryCountEMEcscbBreakdownIDList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTEMECSCBBREAKDOWNIDLIST, materialMgmtInventoryCountEMEcscbBreakdownIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_breakdown_line> getEcscbBreakdownLineList() {
      return (List<ecscb_breakdown_line>) get(PROPERTY_ECSCBBREAKDOWNLINELIST);
    }

    public void setEcscbBreakdownLineList(List<ecscb_breakdown_line> ecscbBreakdownLineList) {
        set(PROPERTY_ECSCBBREAKDOWNLINELIST, ecscbBreakdownLineList);
    }

}

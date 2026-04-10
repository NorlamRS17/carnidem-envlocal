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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
/**
 * Entity class for entity ManufacturingCase (stored in table MA_PC_Case).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Case extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_PC_Case";
    public static final String ENTITY_NAME = "ManufacturingCase";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PERIODICQUALITYCONTROL = "periodicQualityControl";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_INSERTED = "inserted";
    public static final String PROPERTY_SLQSBATCH = "slqsBatch";
    public static final String PROPERTY_SLQSUNIT = "slqsUnit";
    public static final String PROPERTY_SLQSINOUT = "slqsInout";
    public static final String PROPERTY_SLQSDOCUMENTTYPE = "slqsDocumentType";
    public static final String PROPERTY_SLQSDOCUMENTNO = "slqsDocumentno";
    public static final String PROPERTY_SLQSSTATUS = "slqsStatus";
    public static final String PROPERTY_SLQSPROCESSED = "slqsProcessed";
    public static final String PROPERTY_SLQSTRANSFER = "slqsTransfer";
    public static final String PROPERTY_SLQSMPRODLINE = "slqsMProdLine";
    public static final String PROPERTY_MANUFACTURINGVALUELIST = "manufacturingValueList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSLQSMAPCCASEIDLIST = "materialMgmtInternalMovementEMSlqsMaPcCaseIDList";

    public Case() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_INSERTED, false);
        setDefaultValue(PROPERTY_SLQSTRANSFER, false);
        setDefaultValue(PROPERTY_MANUFACTURINGVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSLQSMAPCCASEIDLIST, new ArrayList<Object>());
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

    public PeriodicControl getPeriodicQualityControl() {
        return (PeriodicControl) get(PROPERTY_PERIODICQUALITYCONTROL);
    }

    public void setPeriodicQualityControl(PeriodicControl periodicQualityControl) {
        set(PROPERTY_PERIODICQUALITYCONTROL, periodicQualityControl);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
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

    public Boolean isInserted() {
        return (Boolean) get(PROPERTY_INSERTED);
    }

    public void setInserted(Boolean inserted) {
        set(PROPERTY_INSERTED, inserted);
    }

    public String getSlqsBatch() {
        return (String) get(PROPERTY_SLQSBATCH);
    }

    public void setSlqsBatch(String slqsBatch) {
        set(PROPERTY_SLQSBATCH, slqsBatch);
    }

    public UOM getSlqsUnit() {
        return (UOM) get(PROPERTY_SLQSUNIT);
    }

    public void setSlqsUnit(UOM slqsUnit) {
        set(PROPERTY_SLQSUNIT, slqsUnit);
    }

    public ShipmentInOut getSlqsInout() {
        return (ShipmentInOut) get(PROPERTY_SLQSINOUT);
    }

    public void setSlqsInout(ShipmentInOut slqsInout) {
        set(PROPERTY_SLQSINOUT, slqsInout);
    }

    public DocumentType getSlqsDocumentType() {
        return (DocumentType) get(PROPERTY_SLQSDOCUMENTTYPE);
    }

    public void setSlqsDocumentType(DocumentType slqsDocumentType) {
        set(PROPERTY_SLQSDOCUMENTTYPE, slqsDocumentType);
    }

    public String getSlqsDocumentno() {
        return (String) get(PROPERTY_SLQSDOCUMENTNO);
    }

    public void setSlqsDocumentno(String slqsDocumentno) {
        set(PROPERTY_SLQSDOCUMENTNO, slqsDocumentno);
    }

    public String getSlqsStatus() {
        return (String) get(PROPERTY_SLQSSTATUS);
    }

    public void setSlqsStatus(String slqsStatus) {
        set(PROPERTY_SLQSSTATUS, slqsStatus);
    }

    public String getSlqsProcessed() {
        return (String) get(PROPERTY_SLQSPROCESSED);
    }

    public void setSlqsProcessed(String slqsProcessed) {
        set(PROPERTY_SLQSPROCESSED, slqsProcessed);
    }

    public Boolean isSlqsTransfer() {
        return (Boolean) get(PROPERTY_SLQSTRANSFER);
    }

    public void setSlqsTransfer(Boolean slqsTransfer) {
        set(PROPERTY_SLQSTRANSFER, slqsTransfer);
    }

    public ProductionLine getSlqsMProdLine() {
        return (ProductionLine) get(PROPERTY_SLQSMPRODLINE);
    }

    public void setSlqsMProdLine(ProductionLine slqsMProdLine) {
        set(PROPERTY_SLQSMPRODLINE, slqsMProdLine);
    }

    @SuppressWarnings("unchecked")
    public List<Value> getManufacturingValueList() {
      return (List<Value>) get(PROPERTY_MANUFACTURINGVALUELIST);
    }

    public void setManufacturingValueList(List<Value> manufacturingValueList) {
        set(PROPERTY_MANUFACTURINGVALUELIST, manufacturingValueList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovement> getMaterialMgmtInternalMovementEMSlqsMaPcCaseIDList() {
      return (List<InternalMovement>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSLQSMAPCCASEIDLIST);
    }

    public void setMaterialMgmtInternalMovementEMSlqsMaPcCaseIDList(List<InternalMovement> materialMgmtInternalMovementEMSlqsMaPcCaseIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSLQSMAPCCASEIDLIST, materialMgmtInternalMovementEMSlqsMaPcCaseIDList);
    }

}

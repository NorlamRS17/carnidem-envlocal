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
package ec.com.sidesoft.production.auto.transfer.mp;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.manufacturing.processplan.ProcessPlan;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.manufacturing.transaction.WorkRequirementProduct;
/**
 * Entity class for entity spatmp_transfer (stored in table spatmp_transfer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class spatmp_transfer extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "spatmp_transfer";
    public static final String ENTITY_NAME = "spatmp_transfer";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_WORKREQUIREMENT = "workRequirement";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROCESSPLAN = "processPlan";
    public static final String PROPERTY_RELEASEDATE = "releaseDate";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_WRPRODUCTPHASE = "wRProductPhase";
    public static final String PROPERTY_CODE = "code";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTIONTYPE = "productionType";
    public static final String PROPERTY_COMPONENTAMOUNTFORMULA = "componentAmountFormula";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_TOTALAMOUNTRECUESTED = "totalAmountRecuested";
    public static final String PROPERTY_AMOUNTTOPP = "amountToPp";
    public static final String PROPERTY_HOLE = "hole";
    public static final String PROPERTY_MOVEDTO = "movedTo";
    public static final String PROPERTY_SENT = "sent";
    public static final String PROPERTY_GENERATETRANSFER = "generateTransfer";

    public spatmp_transfer() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SENT, false);
        setDefaultValue(PROPERTY_GENERATETRANSFER, false);
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

    public WorkRequirement getWorkRequirement() {
        return (WorkRequirement) get(PROPERTY_WORKREQUIREMENT);
    }

    public void setWorkRequirement(WorkRequirement workRequirement) {
        set(PROPERTY_WORKREQUIREMENT, workRequirement);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public ProcessPlan getProcessPlan() {
        return (ProcessPlan) get(PROPERTY_PROCESSPLAN);
    }

    public void setProcessPlan(ProcessPlan processPlan) {
        set(PROPERTY_PROCESSPLAN, processPlan);
    }

    public Date getReleaseDate() {
        return (Date) get(PROPERTY_RELEASEDATE);
    }

    public void setReleaseDate(Date releaseDate) {
        set(PROPERTY_RELEASEDATE, releaseDate);
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

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public WorkRequirementProduct getWRProductPhase() {
        return (WorkRequirementProduct) get(PROPERTY_WRPRODUCTPHASE);
    }

    public void setWRProductPhase(WorkRequirementProduct wRProductPhase) {
        set(PROPERTY_WRPRODUCTPHASE, wRProductPhase);
    }

    public Product getCode() {
        return (Product) get(PROPERTY_CODE);
    }

    public void setCode(Product code) {
        set(PROPERTY_CODE, code);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProductionType() {
        return (String) get(PROPERTY_PRODUCTIONTYPE);
    }

    public void setProductionType(String productionType) {
        set(PROPERTY_PRODUCTIONTYPE, productionType);
    }

    public BigDecimal getComponentAmountFormula() {
        return (BigDecimal) get(PROPERTY_COMPONENTAMOUNTFORMULA);
    }

    public void setComponentAmountFormula(BigDecimal componentAmountFormula) {
        set(PROPERTY_COMPONENTAMOUNTFORMULA, componentAmountFormula);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getTotalAmountRecuested() {
        return (BigDecimal) get(PROPERTY_TOTALAMOUNTRECUESTED);
    }

    public void setTotalAmountRecuested(BigDecimal totalAmountRecuested) {
        set(PROPERTY_TOTALAMOUNTRECUESTED, totalAmountRecuested);
    }

    public BigDecimal getAmountToPp() {
        return (BigDecimal) get(PROPERTY_AMOUNTTOPP);
    }

    public void setAmountToPp(BigDecimal amountToPp) {
        set(PROPERTY_AMOUNTTOPP, amountToPp);
    }

    public Locator getHole() {
        return (Locator) get(PROPERTY_HOLE);
    }

    public void setHole(Locator hole) {
        set(PROPERTY_HOLE, hole);
    }

    public Locator getMovedTo() {
        return (Locator) get(PROPERTY_MOVEDTO);
    }

    public void setMovedTo(Locator movedTo) {
        set(PROPERTY_MOVEDTO, movedTo);
    }

    public Boolean isSent() {
        return (Boolean) get(PROPERTY_SENT);
    }

    public void setSent(Boolean sent) {
        set(PROPERTY_SENT, sent);
    }

    public Boolean isGenerateTransfer() {
        return (Boolean) get(PROPERTY_GENERATETRANSFER);
    }

    public void setGenerateTransfer(Boolean generateTransfer) {
        set(PROPERTY_GENERATETRANSFER, generateTransfer);
    }

}

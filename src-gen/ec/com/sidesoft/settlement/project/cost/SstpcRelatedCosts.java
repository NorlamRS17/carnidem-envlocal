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

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Product;
/**
 * Entity class for entity sstpc_related_costs (stored in table sstpc_related_costs).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SstpcRelatedCosts extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sstpc_related_costs";
    public static final String ENTITY_NAME = "sstpc_related_costs";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICELINE = "invoiceline";
    public static final String PROPERTY_POREFERENCE = "poreference";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DATEINVOICED = "dateinvoiced";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_ISLIQUIDATE = "isliquidate";
    public static final String PROPERTY_SSTPCLIQUIDATIONPROJECTS = "sstpcLiquidationProjects";

    public SstpcRelatedCosts() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISLIQUIDATE, false);
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

    public InvoiceLine getInvoiceline() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceline(InvoiceLine invoiceline) {
        set(PROPERTY_INVOICELINE, invoiceline);
    }

    public String getPoreference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPoreference(String poreference) {
        set(PROPERTY_POREFERENCE, poreference);
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

    public Date getDateinvoiced() {
        return (Date) get(PROPERTY_DATEINVOICED);
    }

    public void setDateinvoiced(Date dateinvoiced) {
        set(PROPERTY_DATEINVOICED, dateinvoiced);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Boolean isLiquidate() {
        return (Boolean) get(PROPERTY_ISLIQUIDATE);
    }

    public void setLiquidate(Boolean isliquidate) {
        set(PROPERTY_ISLIQUIDATE, isliquidate);
    }

    public LiquidationProjects getSstpcLiquidationProjects() {
        return (LiquidationProjects) get(PROPERTY_SSTPCLIQUIDATIONPROJECTS);
    }

    public void setSstpcLiquidationProjects(LiquidationProjects sstpcLiquidationProjects) {
        set(PROPERTY_SSTPCLIQUIDATIONPROJECTS, sstpcLiquidationProjects);
    }

}

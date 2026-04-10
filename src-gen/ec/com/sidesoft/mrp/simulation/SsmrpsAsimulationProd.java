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
package ec.com.sidesoft.mrp.simulation;

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
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.calendar.Period;
/**
 * Entity class for entity ssmrps_asimulation_prod (stored in table ssmrps_asimulation_prod).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsmrpsAsimulationProd extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssmrps_asimulation_prod";
    public static final String ENTITY_NAME = "ssmrps_asimulation_prod";
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
    public static final String PROPERTY_PERIODFROM = "periodfrom";
    public static final String PROPERTY_PERIODTO = "periodto";
    public static final String PROPERTY_PERIODPROJECTION = "periodprojection";
    public static final String PROPERTY_MONTHNOTCONS = "monthnotcons";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_GENERATESIM = "generateSim";
    public static final String PROPERTY_GENERATEORDERS = "generateOrders";
    public static final String PROPERTY_PLANORDERS = "planOrders";
    public static final String PROPERTY_SSMRPSASIMLINESLIST = "ssmrpsAsimLinesList";
    public static final String PROPERTY_SSMRPSLINESTMPLIST = "ssmrpsLinesTmpList";
    public static final String PROPERTY_SSMRPSMONTHSNOTCONSLIST = "ssmrpsMonthsnotconsList";

    public SsmrpsAsimulationProd() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_MONTHNOTCONS, false);
        setDefaultValue(PROPERTY_DOCSTATUS, "CS");
        setDefaultValue(PROPERTY_GENERATESIM, "CS");
        setDefaultValue(PROPERTY_GENERATEORDERS, "CS");
        setDefaultValue(PROPERTY_PLANORDERS, "PP");
        setDefaultValue(PROPERTY_SSMRPSASIMLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPSLINESTMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPSMONTHSNOTCONSLIST, new ArrayList<Object>());
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

    public Period getPeriodfrom() {
        return (Period) get(PROPERTY_PERIODFROM);
    }

    public void setPeriodfrom(Period periodfrom) {
        set(PROPERTY_PERIODFROM, periodfrom);
    }

    public Period getPeriodto() {
        return (Period) get(PROPERTY_PERIODTO);
    }

    public void setPeriodto(Period periodto) {
        set(PROPERTY_PERIODTO, periodto);
    }

    public Period getPeriodprojection() {
        return (Period) get(PROPERTY_PERIODPROJECTION);
    }

    public void setPeriodprojection(Period periodprojection) {
        set(PROPERTY_PERIODPROJECTION, periodprojection);
    }

    public Boolean isMonthnotcons() {
        return (Boolean) get(PROPERTY_MONTHNOTCONS);
    }

    public void setMonthnotcons(Boolean monthnotcons) {
        set(PROPERTY_MONTHNOTCONS, monthnotcons);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public String getGenerateSim() {
        return (String) get(PROPERTY_GENERATESIM);
    }

    public void setGenerateSim(String generateSim) {
        set(PROPERTY_GENERATESIM, generateSim);
    }

    public String getGenerateOrders() {
        return (String) get(PROPERTY_GENERATEORDERS);
    }

    public void setGenerateOrders(String generateOrders) {
        set(PROPERTY_GENERATEORDERS, generateOrders);
    }

    public String getPlanOrders() {
        return (String) get(PROPERTY_PLANORDERS);
    }

    public void setPlanOrders(String planOrders) {
        set(PROPERTY_PLANORDERS, planOrders);
    }

    @SuppressWarnings("unchecked")
    public List<ssmrps_asim_lines> getSsmrpsAsimLinesList() {
      return (List<ssmrps_asim_lines>) get(PROPERTY_SSMRPSASIMLINESLIST);
    }

    public void setSsmrpsAsimLinesList(List<ssmrps_asim_lines> ssmrpsAsimLinesList) {
        set(PROPERTY_SSMRPSASIMLINESLIST, ssmrpsAsimLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpsLinesTmp> getSsmrpsLinesTmpList() {
      return (List<SsmrpsLinesTmp>) get(PROPERTY_SSMRPSLINESTMPLIST);
    }

    public void setSsmrpsLinesTmpList(List<SsmrpsLinesTmp> ssmrpsLinesTmpList) {
        set(PROPERTY_SSMRPSLINESTMPLIST, ssmrpsLinesTmpList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpsMonthsNotCons> getSsmrpsMonthsnotconsList() {
      return (List<SsmrpsMonthsNotCons>) get(PROPERTY_SSMRPSMONTHSNOTCONSLIST);
    }

    public void setSsmrpsMonthsnotconsList(List<SsmrpsMonthsNotCons> ssmrpsMonthsnotconsList) {
        set(PROPERTY_SSMRPSMONTHSNOTCONSLIST, ssmrpsMonthsnotconsList);
    }

}

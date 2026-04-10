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
package ec.com.sidesoft.ecuador.asset.allocation.advanced;

import com.sidesoft.ecuador.asset.allocation.ssal_unit;
import com.sidesoft.ecuador.asset.allocation.ssalbuilding;
import com.sidesoft.ecuador.asset.allocation.ssaldepartment;

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
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
/**
 * Entity class for entity csaaa_custodian (stored in table csaaa_custodian).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CsaaaCustodian extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "csaaa_custodian";
    public static final String ENTITY_NAME = "csaaa_custodian";
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
    public static final String PROPERTY_CUSTODIAN = "custodian";
    public static final String PROPERTY_DATETRANSACTION = "datetransaction";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_LOADLINES = "loadlines";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_BUILDING = "building";
    public static final String PROPERTY_UNIT = "unit";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_CSAAACUSTODIANLINELIST = "csaaaCustodianlineList";

    public CsaaaCustodian() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_LOADLINES, false);
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINELIST, new ArrayList<Object>());
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

    public BusinessPartner getCustodian() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN);
    }

    public void setCustodian(BusinessPartner custodian) {
        set(PROPERTY_CUSTODIAN, custodian);
    }

    public Date getDatetransaction() {
        return (Date) get(PROPERTY_DATETRANSACTION);
    }

    public void setDatetransaction(Date datetransaction) {
        set(PROPERTY_DATETRANSACTION, datetransaction);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isLoadlines() {
        return (Boolean) get(PROPERTY_LOADLINES);
    }

    public void setLoadlines(Boolean loadlines) {
        set(PROPERTY_LOADLINES, loadlines);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public UserDimension1 getUser1() {
        return (UserDimension1) get(PROPERTY_USER1);
    }

    public void setUser1(UserDimension1 user1) {
        set(PROPERTY_USER1, user1);
    }

    public UserDimension2 getUser2() {
        return (UserDimension2) get(PROPERTY_USER2);
    }

    public void setUser2(UserDimension2 user2) {
        set(PROPERTY_USER2, user2);
    }

    public ssalbuilding getBuilding() {
        return (ssalbuilding) get(PROPERTY_BUILDING);
    }

    public void setBuilding(ssalbuilding building) {
        set(PROPERTY_BUILDING, building);
    }

    public ssal_unit getUnit() {
        return (ssal_unit) get(PROPERTY_UNIT);
    }

    public void setUnit(ssal_unit unit) {
        set(PROPERTY_UNIT, unit);
    }

    public ssaldepartment getDepartment() {
        return (ssaldepartment) get(PROPERTY_DEPARTMENT);
    }

    public void setDepartment(ssaldepartment department) {
        set(PROPERTY_DEPARTMENT, department);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINELIST);
    }

    public void setCsaaaCustodianlineList(List<CsaaaCustodianLine> csaaaCustodianlineList) {
        set(PROPERTY_CSAAACUSTODIANLINELIST, csaaaCustodianlineList);
    }

}

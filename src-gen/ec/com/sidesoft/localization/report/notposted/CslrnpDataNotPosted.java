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
package ec.com.sidesoft.localization.report.notposted;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity cslrnp_data_notposted (stored in table cslrnp_data_notposted).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CslrnpDataNotPosted extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "cslrnp_data_notposted";
    public static final String ENTITY_NAME = "cslrnp_data_notposted";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_TABLENAME = "tablename";
    public static final String PROPERTY_CBPID = "cbpid";
    public static final String PROPERTY_GRANDTOTAL = "grandtotal";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTNO2 = "documentno2";
    public static final String PROPERTY_TAB = "tAB";
    public static final String PROPERTY_DOCBASETYPE = "docbasetype";
    public static final String PROPERTY_RECORD = "record";
    public static final String PROPERTY_PROCESSID = "processid";

    public CslrnpDataNotPosted() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_GRANDTOTAL, new BigDecimal(0));
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

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public String getTablename() {
        return (String) get(PROPERTY_TABLENAME);
    }

    public void setTablename(String tablename) {
        set(PROPERTY_TABLENAME, tablename);
    }

    public String getCbpid() {
        return (String) get(PROPERTY_CBPID);
    }

    public void setCbpid(String cbpid) {
        set(PROPERTY_CBPID, cbpid);
    }

    public BigDecimal getGrandtotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandtotal(BigDecimal grandtotal) {
        set(PROPERTY_GRANDTOTAL, grandtotal);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentno2() {
        return (String) get(PROPERTY_DOCUMENTNO2);
    }

    public void setDocumentno2(String documentno2) {
        set(PROPERTY_DOCUMENTNO2, documentno2);
    }

    public Tab getTAB() {
        return (Tab) get(PROPERTY_TAB);
    }

    public void setTAB(Tab tAB) {
        set(PROPERTY_TAB, tAB);
    }

    public String getDocbasetype() {
        return (String) get(PROPERTY_DOCBASETYPE);
    }

    public void setDocbasetype(String docbasetype) {
        set(PROPERTY_DOCBASETYPE, docbasetype);
    }

    public String getRecord() {
        return (String) get(PROPERTY_RECORD);
    }

    public void setRecord(String record) {
        set(PROPERTY_RECORD, record);
    }

    public String getProcessid() {
        return (String) get(PROPERTY_PROCESSID);
    }

    public void setProcessid(String processid) {
        set(PROPERTY_PROCESSID, processid);
    }

}

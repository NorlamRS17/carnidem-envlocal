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
package ec.com.sidesoft.dinardap.advanced;

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
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sdindp_dinardap (stored in table sdindp_dinardap).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Sdindp_Dinardap extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sdindp_dinardap";
    public static final String ENTITY_NAME = "sdindp_dinardap";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_BTNLOADLINES = "bTNLoadLines";
    public static final String PROPERTY_BTNDEBUGINFO = "bTNDebugInfo";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_BTNGENTXT = "bTNGenTXT";
    public static final String PROPERTY_SDINDPDINARDAPDISCARDLIST = "sdindpDinardapDiscardList";
    public static final String PROPERTY_SDINDPDINARDAPLINELIST = "sdindpDinardapLineList";

    public Sdindp_Dinardap() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BTNLOADLINES, false);
        setDefaultValue(PROPERTY_BTNDEBUGINFO, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_BTNGENTXT, false);
        setDefaultValue(PROPERTY_SDINDPDINARDAPDISCARDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDINDPDINARDAPLINELIST, new ArrayList<Object>());
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

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public Date getDateTo() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateTo(Date dateTo) {
        set(PROPERTY_DATETO, dateTo);
    }

    public Boolean isBTNLoadLines() {
        return (Boolean) get(PROPERTY_BTNLOADLINES);
    }

    public void setBTNLoadLines(Boolean bTNLoadLines) {
        set(PROPERTY_BTNLOADLINES, bTNLoadLines);
    }

    public Boolean isBTNDebugInfo() {
        return (Boolean) get(PROPERTY_BTNDEBUGINFO);
    }

    public void setBTNDebugInfo(Boolean bTNDebugInfo) {
        set(PROPERTY_BTNDEBUGINFO, bTNDebugInfo);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isBTNGenTXT() {
        return (Boolean) get(PROPERTY_BTNGENTXT);
    }

    public void setBTNGenTXT(Boolean bTNGenTXT) {
        set(PROPERTY_BTNGENTXT, bTNGenTXT);
    }

    @SuppressWarnings("unchecked")
    public List<Sdindp_DinardapDiscard> getSdindpDinardapDiscardList() {
      return (List<Sdindp_DinardapDiscard>) get(PROPERTY_SDINDPDINARDAPDISCARDLIST);
    }

    public void setSdindpDinardapDiscardList(List<Sdindp_DinardapDiscard> sdindpDinardapDiscardList) {
        set(PROPERTY_SDINDPDINARDAPDISCARDLIST, sdindpDinardapDiscardList);
    }

    @SuppressWarnings("unchecked")
    public List<Sdindp_DinardapLine> getSdindpDinardapLineList() {
      return (List<Sdindp_DinardapLine>) get(PROPERTY_SDINDPDINARDAPLINELIST);
    }

    public void setSdindpDinardapLineList(List<Sdindp_DinardapLine> sdindpDinardapLineList) {
        set(PROPERTY_SDINDPDINARDAPLINELIST, sdindpDinardapLineList);
    }

}

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
package ec.com.sidesoft.payroll.telecommuting.dialing;

import java.sql.Timestamp;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity ssptdl_telecomm_dialing (stored in table ssptdl_telecomm_dialing).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsptdlTelecommDialing extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssptdl_telecomm_dialing";
    public static final String ENTITY_NAME = "ssptdl_telecomm_dialing";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEMOVEMENT = "datemovement";
    public static final String PROPERTY_ENTRYHOURM = "entryhourM";
    public static final String PROPERTY_EXITHOURM = "exithourM";
    public static final String PROPERTY_ENTRYHOURA = "entryhourA";
    public static final String PROPERTY_EXITHOURA = "exithourA";
    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_IDENTIFY = "identify";
    public static final String PROPERTY_LOCATIONMARKING = "locationMarking";
    public static final String PROPERTY_GEOLOCATION = "geolocation";
    public static final String PROPERTY_REMOTEDIALING = "remoteDialing";
    public static final String PROPERTY_PROCESSDIALING = "processDialing";
    public static final String PROPERTY_CATCHLOCATIONGPS = "catchLocationGps";
    public static final String PROPERTY_ISACTIONBUTTOM = "isactionbuttom";

    public SsptdlTelecommDialing() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATE, "DR");
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_REMOTEDIALING, false);
        setDefaultValue(PROPERTY_PROCESSDIALING, false);
        setDefaultValue(PROPERTY_CATCHLOCATIONGPS, false);
        setDefaultValue(PROPERTY_ISACTIONBUTTOM, false);
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

    public Date getDatemovement() {
        return (Date) get(PROPERTY_DATEMOVEMENT);
    }

    public void setDatemovement(Date datemovement) {
        set(PROPERTY_DATEMOVEMENT, datemovement);
    }

    public Timestamp getEntryhourM() {
        return (Timestamp) get(PROPERTY_ENTRYHOURM);
    }

    public void setEntryhourM(Timestamp entryhourM) {
        set(PROPERTY_ENTRYHOURM, entryhourM);
    }

    public Date getExithourM() {
        return (Date) get(PROPERTY_EXITHOURM);
    }

    public void setExithourM(Date exithourM) {
        set(PROPERTY_EXITHOURM, exithourM);
    }

    public Date getEntryhourA() {
        return (Date) get(PROPERTY_ENTRYHOURA);
    }

    public void setEntryhourA(Date entryhourA) {
        set(PROPERTY_ENTRYHOURA, entryhourA);
    }

    public Date getExithourA() {
        return (Date) get(PROPERTY_EXITHOURA);
    }

    public void setExithourA(Date exithourA) {
        set(PROPERTY_EXITHOURA, exithourA);
    }

    public String getState() {
        return (String) get(PROPERTY_STATE);
    }

    public void setState(String state) {
        set(PROPERTY_STATE, state);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getIdentify() {
        return (String) get(PROPERTY_IDENTIFY);
    }

    public void setIdentify(String identify) {
        set(PROPERTY_IDENTIFY, identify);
    }

    public String getLocationMarking() {
        return (String) get(PROPERTY_LOCATIONMARKING);
    }

    public void setLocationMarking(String locationMarking) {
        set(PROPERTY_LOCATIONMARKING, locationMarking);
    }

    public String getGeolocation() {
        return (String) get(PROPERTY_GEOLOCATION);
    }

    public void setGeolocation(String geolocation) {
        set(PROPERTY_GEOLOCATION, geolocation);
    }

    public Boolean isRemoteDialing() {
        return (Boolean) get(PROPERTY_REMOTEDIALING);
    }

    public void setRemoteDialing(Boolean remoteDialing) {
        set(PROPERTY_REMOTEDIALING, remoteDialing);
    }

    public Boolean isProcessDialing() {
        return (Boolean) get(PROPERTY_PROCESSDIALING);
    }

    public void setProcessDialing(Boolean processDialing) {
        set(PROPERTY_PROCESSDIALING, processDialing);
    }

    public Boolean isCatchLocationGps() {
        return (Boolean) get(PROPERTY_CATCHLOCATIONGPS);
    }

    public void setCatchLocationGps(Boolean catchLocationGps) {
        set(PROPERTY_CATCHLOCATIONGPS, catchLocationGps);
    }

    public Boolean isActionbuttom() {
        return (Boolean) get(PROPERTY_ISACTIONBUTTOM);
    }

    public void setActionbuttom(Boolean isactionbuttom) {
        set(PROPERTY_ISACTIONBUTTOM, isactionbuttom);
    }

}

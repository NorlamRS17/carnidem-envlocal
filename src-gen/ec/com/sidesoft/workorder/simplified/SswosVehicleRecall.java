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
package ec.com.sidesoft.workorder.simplified;

import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Brand;
/**
 * Entity class for entity Sswos_Vehicle_Recall (stored in table Sswos_Vehicle_Recall).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswosVehicleRecall extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswos_Vehicle_Recall";
    public static final String ENTITY_NAME = "Sswos_Vehicle_Recall";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VEHICLETYPE = "vehicleType";
    public static final String PROPERTY_BRAND = "brand";
    public static final String PROPERTY_MODEL = "model";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_ENGINENUMBER = "engineNumber";
    public static final String PROPERTY_CHASSISNUMBER = "chassisNumber";
    public static final String PROPERTY_ISRECALLDONE = "isrecalldone";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";

    public SswosVehicleRecall() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISRECALLDONE, false);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
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

    public String getVehicleType() {
        return (String) get(PROPERTY_VEHICLETYPE);
    }

    public void setVehicleType(String vehicleType) {
        set(PROPERTY_VEHICLETYPE, vehicleType);
    }

    public Brand getBrand() {
        return (Brand) get(PROPERTY_BRAND);
    }

    public void setBrand(Brand brand) {
        set(PROPERTY_BRAND, brand);
    }

    public SsfiModelProduct getModel() {
        return (SsfiModelProduct) get(PROPERTY_MODEL);
    }

    public void setModel(SsfiModelProduct model) {
        set(PROPERTY_MODEL, model);
    }

    public SswosYear getYear() {
        return (SswosYear) get(PROPERTY_YEAR);
    }

    public void setYear(SswosYear year) {
        set(PROPERTY_YEAR, year);
    }

    public String getEngineNumber() {
        return (String) get(PROPERTY_ENGINENUMBER);
    }

    public void setEngineNumber(String engineNumber) {
        set(PROPERTY_ENGINENUMBER, engineNumber);
    }

    public String getChassisNumber() {
        return (String) get(PROPERTY_CHASSISNUMBER);
    }

    public void setChassisNumber(String chassisNumber) {
        set(PROPERTY_CHASSISNUMBER, chassisNumber);
    }

    public Boolean isRecalldone() {
        return (Boolean) get(PROPERTY_ISRECALLDONE);
    }

    public void setRecalldone(Boolean isrecalldone) {
        set(PROPERTY_ISRECALLDONE, isrecalldone);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

}

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
package ec.com.sidesoft.localization.geography;

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
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationInformation;
import org.openbravo.model.common.geography.Region;
/**
 * Entity class for entity secpm_canton (stored in table secpm_canton).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class secpm_canton extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "secpm_canton";
    public static final String ENTITY_NAME = "secpm_canton";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_IDENTIFICADOR = "identificador";
    public static final String PROPERTY_DESCRIPCION = "descripcion";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_VALORDEFAULT = "valorDefault";
    public static final String PROPERTY_BUSINESSPARTNERLOCATIONEMSECPMCANTONIDLIST = "businessPartnerLocationEMSecpmCantonIDList";
    public static final String PROPERTY_LOCATIONEMSDINCCCANTONIDLIST = "locationEMSdinccCantonIDList";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONEMSORGICANTONIDLIST = "organizationInformationEMSorgiCantonIDList";
    public static final String PROPERTY_SECPMPARROQUIALIST = "secpmParroquiaList";

    public secpm_canton() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_VALORDEFAULT, false);
        setDefaultValue(PROPERTY_BUSINESSPARTNERLOCATIONEMSECPMCANTONIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LOCATIONEMSDINCCCANTONIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONEMSORGICANTONIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SECPMPARROQUIALIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getIdentificador() {
        return (String) get(PROPERTY_IDENTIFICADOR);
    }

    public void setIdentificador(String identificador) {
        set(PROPERTY_IDENTIFICADOR, identificador);
    }

    public String getDescripcion() {
        return (String) get(PROPERTY_DESCRIPCION);
    }

    public void setDescripcion(String descripcion) {
        set(PROPERTY_DESCRIPCION, descripcion);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public Boolean isValorDefault() {
        return (Boolean) get(PROPERTY_VALORDEFAULT);
    }

    public void setValorDefault(Boolean valorDefault) {
        set(PROPERTY_VALORDEFAULT, valorDefault);
    }

    @SuppressWarnings("unchecked")
    public List<Location> getBusinessPartnerLocationEMSecpmCantonIDList() {
      return (List<Location>) get(PROPERTY_BUSINESSPARTNERLOCATIONEMSECPMCANTONIDLIST);
    }

    public void setBusinessPartnerLocationEMSecpmCantonIDList(List<Location> businessPartnerLocationEMSecpmCantonIDList) {
        set(PROPERTY_BUSINESSPARTNERLOCATIONEMSECPMCANTONIDLIST, businessPartnerLocationEMSecpmCantonIDList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.geography.Location> getLocationEMSdinccCantonIDList() {
      return (List<org.openbravo.model.common.geography.Location>) get(PROPERTY_LOCATIONEMSDINCCCANTONIDLIST);
    }

    public void setLocationEMSdinccCantonIDList(List<org.openbravo.model.common.geography.Location> locationEMSdinccCantonIDList) {
        set(PROPERTY_LOCATIONEMSDINCCCANTONIDLIST, locationEMSdinccCantonIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationEMSorgiCantonIDList() {
      return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONEMSORGICANTONIDLIST);
    }

    public void setOrganizationInformationEMSorgiCantonIDList(List<OrganizationInformation> organizationInformationEMSorgiCantonIDList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONEMSORGICANTONIDLIST, organizationInformationEMSorgiCantonIDList);
    }

    @SuppressWarnings("unchecked")
    public List<secpm_parroquia> getSecpmParroquiaList() {
      return (List<secpm_parroquia>) get(PROPERTY_SECPMPARROQUIALIST);
    }

    public void setSecpmParroquiaList(List<secpm_parroquia> secpmParroquiaList) {
        set(PROPERTY_SECPMPARROQUIALIST, secpmParroquiaList);
    }

}

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

import ec.com.sidesoft.aftersale.machinery.Satmac_Machine;
import ec.com.sidesoft.aftersale.machinery.Satmac_MachineType;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Brand;
import org.openbravo.model.project.Project;
/**
 * Entity class for entity Sswos_Vehicle (stored in table Sswos_Vehicle).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswosVehicle extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswos_Vehicle";
    public static final String ENTITY_NAME = "Sswos_Vehicle";
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
    public static final String PROPERTY_SSWOSYEAR = "sswosYear";
    public static final String PROPERTY_ENGINENUMBER = "engineNumber";
    public static final String PROPERTY_CHASSISNUMBER = "chassisNumber";
    public static final String PROPERTY_PLATE = "plate";
    public static final String PROPERTY_SSWOSCOLOR = "sswosColor";
    public static final String PROPERTY_KILOMETERHOURS = "kilometerHours";
    public static final String PROPERTY_SALEDATE = "saleDate";
    public static final String PROPERTY_ORGSALE = "orgSale";
    public static final String PROPERTY_PROVIDER = "provider";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_SATMACSALESREP = "satmacSalesRep";
    public static final String PROPERTY_SATMACPROJECT = "satmacProject";
    public static final String PROPERTY_SATMACMACHINETYPE = "satmacMachineType";
    public static final String PROPERTY_SATMACORIGIN = "satmacOrigin";
    public static final String PROPERTY_SATMACINVOICE = "satmacInvoice";
    public static final String PROPERTY_SATMACINVOICELINE = "satmacInvoiceline";
    public static final String PROPERTY_SATMACNAME = "satmacName";
    public static final String PROPERTY_SATMACOBSERVATIONS = "satmacObservations";
    public static final String PROPERTY_SATMACMACHINELIST = "satmacMachineList";

    public SswosVehicle() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_SATMACORIGIN, "O");
        setDefaultValue(PROPERTY_SATMACMACHINELIST, new ArrayList<Object>());
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

    public SswosYear getSswosYear() {
        return (SswosYear) get(PROPERTY_SSWOSYEAR);
    }

    public void setSswosYear(SswosYear sswosYear) {
        set(PROPERTY_SSWOSYEAR, sswosYear);
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

    public String getPlate() {
        return (String) get(PROPERTY_PLATE);
    }

    public void setPlate(String plate) {
        set(PROPERTY_PLATE, plate);
    }

    public SswosColor getSswosColor() {
        return (SswosColor) get(PROPERTY_SSWOSCOLOR);
    }

    public void setSswosColor(SswosColor sswosColor) {
        set(PROPERTY_SSWOSCOLOR, sswosColor);
    }

    public Long getKilometerHours() {
        return (Long) get(PROPERTY_KILOMETERHOURS);
    }

    public void setKilometerHours(Long kilometerHours) {
        set(PROPERTY_KILOMETERHOURS, kilometerHours);
    }

    public Date getSaleDate() {
        return (Date) get(PROPERTY_SALEDATE);
    }

    public void setSaleDate(Date saleDate) {
        set(PROPERTY_SALEDATE, saleDate);
    }

    public Organization getOrgSale() {
        return (Organization) get(PROPERTY_ORGSALE);
    }

    public void setOrgSale(Organization orgSale) {
        set(PROPERTY_ORGSALE, orgSale);
    }

    public BusinessPartner getProvider() {
        return (BusinessPartner) get(PROPERTY_PROVIDER);
    }

    public void setProvider(BusinessPartner provider) {
        set(PROPERTY_PROVIDER, provider);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public User getSatmacSalesRep() {
        return (User) get(PROPERTY_SATMACSALESREP);
    }

    public void setSatmacSalesRep(User satmacSalesRep) {
        set(PROPERTY_SATMACSALESREP, satmacSalesRep);
    }

    public Project getSatmacProject() {
        return (Project) get(PROPERTY_SATMACPROJECT);
    }

    public void setSatmacProject(Project satmacProject) {
        set(PROPERTY_SATMACPROJECT, satmacProject);
    }

    public Satmac_MachineType getSatmacMachineType() {
        return (Satmac_MachineType) get(PROPERTY_SATMACMACHINETYPE);
    }

    public void setSatmacMachineType(Satmac_MachineType satmacMachineType) {
        set(PROPERTY_SATMACMACHINETYPE, satmacMachineType);
    }

    public String getSatmacOrigin() {
        return (String) get(PROPERTY_SATMACORIGIN);
    }

    public void setSatmacOrigin(String satmacOrigin) {
        set(PROPERTY_SATMACORIGIN, satmacOrigin);
    }

    public Invoice getSatmacInvoice() {
        return (Invoice) get(PROPERTY_SATMACINVOICE);
    }

    public void setSatmacInvoice(Invoice satmacInvoice) {
        set(PROPERTY_SATMACINVOICE, satmacInvoice);
    }

    public InvoiceLine getSatmacInvoiceline() {
        return (InvoiceLine) get(PROPERTY_SATMACINVOICELINE);
    }

    public void setSatmacInvoiceline(InvoiceLine satmacInvoiceline) {
        set(PROPERTY_SATMACINVOICELINE, satmacInvoiceline);
    }

    public String getSatmacName() {
        return (String) get(PROPERTY_SATMACNAME);
    }

    public void setSatmacName(String satmacName) {
        set(PROPERTY_SATMACNAME, satmacName);
    }

    public String getSatmacObservations() {
        return (String) get(PROPERTY_SATMACOBSERVATIONS);
    }

    public void setSatmacObservations(String satmacObservations) {
        set(PROPERTY_SATMACOBSERVATIONS, satmacObservations);
    }

    @SuppressWarnings("unchecked")
    public List<Satmac_Machine> getSatmacMachineList() {
      return (List<Satmac_Machine>) get(PROPERTY_SATMACMACHINELIST);
    }

    public void setSatmacMachineList(List<Satmac_Machine> satmacMachineList) {
        set(PROPERTY_SATMACMACHINELIST, satmacMachineList);
    }

}

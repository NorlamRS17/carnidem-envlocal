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
package org.openbravo.model.manufacturing.maintenance;

import java.math.BigDecimal;
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
import org.openbravo.model.manufacturing.floorshop.Machine;
import org.openbravo.model.manufacturing.floorshop.MachineType;
import org.openbravo.model.materialmgmt.transaction.InternalConsumption;
/**
 * Entity class for entity ManufacturingMaintenanceSchedule (stored in table MA_Maint_Scheduled).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MaintenanceSchedule extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MA_Maint_Scheduled";
    public static final String ENTITY_NAME = "ManufacturingMaintenanceSchedule";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MAINTENANCE = "maintenance";
    public static final String PROPERTY_MAINTENANCEORDER = "maintenanceOrder";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_MACHINECATEGORY = "machineCategory";
    public static final String PROPERTY_MAINTENANCETYPE = "maintenanceType";
    public static final String PROPERTY_PLANNEDDATE = "plannedDate";
    public static final String PROPERTY_CONFIRMATION = "confirmation";
    public static final String PROPERTY_SHIFT = "shift";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_TIMEUSED = "timeUsed";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_MAINTENANCETASK = "maintenanceTask";
    public static final String PROPERTY_INTERNALCONSUMPTION = "internalConsumption";
    public static final String PROPERTY_SCMASTARTPERIODICITY = "scmaStartPeriodicity";
    public static final String PROPERTY_SCMAENDPERIODICITY = "scmaEndPeriodicity";
    public static final String PROPERTY_SCMAINFRASTRUCTURE = "scmaInfrastructure";
    public static final String PROPERTY_SCMAAREA = "scmaArea";
    public static final String PROPERTY_SCMATEMPSOLUTION = "scmaTempsolution";
    public static final String PROPERTY_SCMACHANGEPROPOSAL = "scmaChangeproposal";
    public static final String PROPERTY_SCMAACTUALCHANGE = "scmaActualchange";
    public static final String PROPERTY_SCMADEFINITIVESOLUTION = "scmaDefinitivesolution";
    public static final String PROPERTY_SCMAACCEPTARRANGEMENT = "scmaAcceptarrangement";
    public static final String PROPERTY_SCMAACCEPTNAME = "scmaAcceptname";
    public static final String PROPERTY_SCMAWORKBEDONE = "scmaWorkbedone";
    public static final String PROPERTY_SCMACLEANORDER = "scmaCleanorder";
    public static final String PROPERTY_SCMACLEANDESPROD = "scmaCleandesprod";
    public static final String PROPERTY_SCMAPOLLUTANT = "scmaPollutant";
    public static final String PROPERTY_SCMAUSEDPARTS = "scmaUsedparts";
    public static final String PROPERTY_SCMACORRECTAREA = "scmaCorrectArea";
    public static final String PROPERTY_SCMACORRECTCLEAN = "scmaCorrectClean";
    public static final String PROPERTY_SCMACORRECTTOOLS = "scmaCorrectTools";

    public MaintenanceSchedule() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CONFIRMATION, false);
        setDefaultValue(PROPERTY_RESULT, false);
        setDefaultValue(PROPERTY_SCMATEMPSOLUTION, false);
        setDefaultValue(PROPERTY_SCMADEFINITIVESOLUTION, false);
        setDefaultValue(PROPERTY_SCMAACCEPTARRANGEMENT, false);
        setDefaultValue(PROPERTY_SCMACLEANORDER, false);
        setDefaultValue(PROPERTY_SCMACLEANDESPROD, false);
        setDefaultValue(PROPERTY_SCMAPOLLUTANT, false);
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

    public Maintenance getMaintenance() {
        return (Maintenance) get(PROPERTY_MAINTENANCE);
    }

    public void setMaintenance(Maintenance maintenance) {
        set(PROPERTY_MAINTENANCE, maintenance);
    }

    public MainteanceOrder getMaintenanceOrder() {
        return (MainteanceOrder) get(PROPERTY_MAINTENANCEORDER);
    }

    public void setMaintenanceOrder(MainteanceOrder maintenanceOrder) {
        set(PROPERTY_MAINTENANCEORDER, maintenanceOrder);
    }

    public Machine getMachine() {
        return (Machine) get(PROPERTY_MACHINE);
    }

    public void setMachine(Machine machine) {
        set(PROPERTY_MACHINE, machine);
    }

    public MachineType getMachineCategory() {
        return (MachineType) get(PROPERTY_MACHINECATEGORY);
    }

    public void setMachineCategory(MachineType machineCategory) {
        set(PROPERTY_MACHINECATEGORY, machineCategory);
    }

    public String getMaintenanceType() {
        return (String) get(PROPERTY_MAINTENANCETYPE);
    }

    public void setMaintenanceType(String maintenanceType) {
        set(PROPERTY_MAINTENANCETYPE, maintenanceType);
    }

    public Date getPlannedDate() {
        return (Date) get(PROPERTY_PLANNEDDATE);
    }

    public void setPlannedDate(Date plannedDate) {
        set(PROPERTY_PLANNEDDATE, plannedDate);
    }

    public Boolean isConfirmation() {
        return (Boolean) get(PROPERTY_CONFIRMATION);
    }

    public void setConfirmation(Boolean confirmation) {
        set(PROPERTY_CONFIRMATION, confirmation);
    }

    public String getShift() {
        return (String) get(PROPERTY_SHIFT);
    }

    public void setShift(String shift) {
        set(PROPERTY_SHIFT, shift);
    }

    public Boolean isResult() {
        return (Boolean) get(PROPERTY_RESULT);
    }

    public void setResult(Boolean result) {
        set(PROPERTY_RESULT, result);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public BigDecimal getTimeUsed() {
        return (BigDecimal) get(PROPERTY_TIMEUSED);
    }

    public void setTimeUsed(BigDecimal timeUsed) {
        set(PROPERTY_TIMEUSED, timeUsed);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Task getMaintenanceTask() {
        return (Task) get(PROPERTY_MAINTENANCETASK);
    }

    public void setMaintenanceTask(Task maintenanceTask) {
        set(PROPERTY_MAINTENANCETASK, maintenanceTask);
    }

    public InternalConsumption getInternalConsumption() {
        return (InternalConsumption) get(PROPERTY_INTERNALCONSUMPTION);
    }

    public void setInternalConsumption(InternalConsumption internalConsumption) {
        set(PROPERTY_INTERNALCONSUMPTION, internalConsumption);
    }

    public Timestamp getScmaStartPeriodicity() {
        return (Timestamp) get(PROPERTY_SCMASTARTPERIODICITY);
    }

    public void setScmaStartPeriodicity(Timestamp scmaStartPeriodicity) {
        set(PROPERTY_SCMASTARTPERIODICITY, scmaStartPeriodicity);
    }

    public Timestamp getScmaEndPeriodicity() {
        return (Timestamp) get(PROPERTY_SCMAENDPERIODICITY);
    }

    public void setScmaEndPeriodicity(Timestamp scmaEndPeriodicity) {
        set(PROPERTY_SCMAENDPERIODICITY, scmaEndPeriodicity);
    }

    public String getScmaInfrastructure() {
        return (String) get(PROPERTY_SCMAINFRASTRUCTURE);
    }

    public void setScmaInfrastructure(String scmaInfrastructure) {
        set(PROPERTY_SCMAINFRASTRUCTURE, scmaInfrastructure);
    }

    public String getScmaArea() {
        return (String) get(PROPERTY_SCMAAREA);
    }

    public void setScmaArea(String scmaArea) {
        set(PROPERTY_SCMAAREA, scmaArea);
    }

    public Boolean isScmaTempsolution() {
        return (Boolean) get(PROPERTY_SCMATEMPSOLUTION);
    }

    public void setScmaTempsolution(Boolean scmaTempsolution) {
        set(PROPERTY_SCMATEMPSOLUTION, scmaTempsolution);
    }

    public Date getScmaChangeproposal() {
        return (Date) get(PROPERTY_SCMACHANGEPROPOSAL);
    }

    public void setScmaChangeproposal(Date scmaChangeproposal) {
        set(PROPERTY_SCMACHANGEPROPOSAL, scmaChangeproposal);
    }

    public Date getScmaActualchange() {
        return (Date) get(PROPERTY_SCMAACTUALCHANGE);
    }

    public void setScmaActualchange(Date scmaActualchange) {
        set(PROPERTY_SCMAACTUALCHANGE, scmaActualchange);
    }

    public Boolean isScmaDefinitivesolution() {
        return (Boolean) get(PROPERTY_SCMADEFINITIVESOLUTION);
    }

    public void setScmaDefinitivesolution(Boolean scmaDefinitivesolution) {
        set(PROPERTY_SCMADEFINITIVESOLUTION, scmaDefinitivesolution);
    }

    public Boolean isScmaAcceptarrangement() {
        return (Boolean) get(PROPERTY_SCMAACCEPTARRANGEMENT);
    }

    public void setScmaAcceptarrangement(Boolean scmaAcceptarrangement) {
        set(PROPERTY_SCMAACCEPTARRANGEMENT, scmaAcceptarrangement);
    }

    public BusinessPartner getScmaAcceptname() {
        return (BusinessPartner) get(PROPERTY_SCMAACCEPTNAME);
    }

    public void setScmaAcceptname(BusinessPartner scmaAcceptname) {
        set(PROPERTY_SCMAACCEPTNAME, scmaAcceptname);
    }

    public String getScmaWorkbedone() {
        return (String) get(PROPERTY_SCMAWORKBEDONE);
    }

    public void setScmaWorkbedone(String scmaWorkbedone) {
        set(PROPERTY_SCMAWORKBEDONE, scmaWorkbedone);
    }

    public Boolean isScmaCleanorder() {
        return (Boolean) get(PROPERTY_SCMACLEANORDER);
    }

    public void setScmaCleanorder(Boolean scmaCleanorder) {
        set(PROPERTY_SCMACLEANORDER, scmaCleanorder);
    }

    public Boolean isScmaCleandesprod() {
        return (Boolean) get(PROPERTY_SCMACLEANDESPROD);
    }

    public void setScmaCleandesprod(Boolean scmaCleandesprod) {
        set(PROPERTY_SCMACLEANDESPROD, scmaCleandesprod);
    }

    public Boolean isScmaPollutant() {
        return (Boolean) get(PROPERTY_SCMAPOLLUTANT);
    }

    public void setScmaPollutant(Boolean scmaPollutant) {
        set(PROPERTY_SCMAPOLLUTANT, scmaPollutant);
    }

    public String getScmaUsedparts() {
        return (String) get(PROPERTY_SCMAUSEDPARTS);
    }

    public void setScmaUsedparts(String scmaUsedparts) {
        set(PROPERTY_SCMAUSEDPARTS, scmaUsedparts);
    }

    public String getScmaCorrectArea() {
        return (String) get(PROPERTY_SCMACORRECTAREA);
    }

    public void setScmaCorrectArea(String scmaCorrectArea) {
        set(PROPERTY_SCMACORRECTAREA, scmaCorrectArea);
    }

    public String getScmaCorrectClean() {
        return (String) get(PROPERTY_SCMACORRECTCLEAN);
    }

    public void setScmaCorrectClean(String scmaCorrectClean) {
        set(PROPERTY_SCMACORRECTCLEAN, scmaCorrectClean);
    }

    public String getScmaCorrectTools() {
        return (String) get(PROPERTY_SCMACORRECTTOOLS);
    }

    public void setScmaCorrectTools(String scmaCorrectTools) {
        set(PROPERTY_SCMACORRECTTOOLS, scmaCorrectTools);
    }

}

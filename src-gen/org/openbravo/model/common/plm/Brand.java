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
package org.openbravo.model.common.plm;

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;

import ec.com.sidesoft.custom.mrp.forecast.ScmfBrandtype;
import ec.com.sidesoft.workorder.consult.SSWCLWorkOrder;
import ec.com.sidesoft.workorder.simplified.SswosVehicle;
import ec.com.sidesoft.workorder.simplified.SswosVehicleRecall;

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
import org.openbravo.model.mrp.PurchasingRun;
import org.openbravo.model.project.ProjectTask;
/**
 * Entity class for entity Brand (stored in table M_Brand).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Brand extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Brand";
    public static final String ENTITY_NAME = "Brand";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SIBLRTYPE = "siblrType";
    public static final String PROPERTY_MRPPURCHASINGRUNEMSSMRPBRANDIDLIST = "mRPPurchasingRunEMSsmrpBrandIDList";
    public static final String PROPERTY_PRODUCTLIST = "productList";
    public static final String PROPERTY_PROJECTTASKEMSATMACBRANDIDLIST = "projectTaskEMSatmacBrandIDList";
    public static final String PROPERTY_SSWOSVEHICLELIST = "sswosVehicleList";
    public static final String PROPERTY_SSWOSVEHICLERECALLLIST = "sswosVehicleRecallList";
    public static final String PROPERTY_ATINDPOPOSTVENTAEMSSWOSMBRANDIDLIST = "atindpoPostventaEMSswosMBrandIDList";
    public static final String PROPERTY_SCMFBRANDTYPELIST = "scmfBrandtypeList";
    public static final String PROPERTY_SSFIMODELPRODLIST = "ssfiModelProdList";
    public static final String PROPERTY_SSWCLWORKORDERVLIST = "sswclWorkOrderVList";

    public Brand() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNEMSSMRPBRANDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTTASKEMSATMACBRANDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSVEHICLELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSVEHICLERECALLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTAEMSSWOSMBRANDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFBRANDTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIMODELPRODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERVLIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getSiblrType() {
        return (String) get(PROPERTY_SIBLRTYPE);
    }

    public void setSiblrType(String siblrType) {
        set(PROPERTY_SIBLRTYPE, siblrType);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRun> getMRPPurchasingRunEMSsmrpBrandIDList() {
      return (List<PurchasingRun>) get(PROPERTY_MRPPURCHASINGRUNEMSSMRPBRANDIDLIST);
    }

    public void setMRPPurchasingRunEMSsmrpBrandIDList(List<PurchasingRun> mRPPurchasingRunEMSsmrpBrandIDList) {
        set(PROPERTY_MRPPURCHASINGRUNEMSSMRPBRANDIDLIST, mRPPurchasingRunEMSsmrpBrandIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
      return (List<Product>) get(PROPERTY_PRODUCTLIST);
    }

    public void setProductList(List<Product> productList) {
        set(PROPERTY_PRODUCTLIST, productList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectTask> getProjectTaskEMSatmacBrandIDList() {
      return (List<ProjectTask>) get(PROPERTY_PROJECTTASKEMSATMACBRANDIDLIST);
    }

    public void setProjectTaskEMSatmacBrandIDList(List<ProjectTask> projectTaskEMSatmacBrandIDList) {
        set(PROPERTY_PROJECTTASKEMSATMACBRANDIDLIST, projectTaskEMSatmacBrandIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosVehicle> getSswosVehicleList() {
      return (List<SswosVehicle>) get(PROPERTY_SSWOSVEHICLELIST);
    }

    public void setSswosVehicleList(List<SswosVehicle> sswosVehicleList) {
        set(PROPERTY_SSWOSVEHICLELIST, sswosVehicleList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosVehicleRecall> getSswosVehicleRecallList() {
      return (List<SswosVehicleRecall>) get(PROPERTY_SSWOSVEHICLERECALLLIST);
    }

    public void setSswosVehicleRecallList(List<SswosVehicleRecall> sswosVehicleRecallList) {
        set(PROPERTY_SSWOSVEHICLERECALLLIST, sswosVehicleRecallList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventa> getAtindpoPostventaEMSswosMBrandIDList() {
      return (List<atindpo_postventa>) get(PROPERTY_ATINDPOPOSTVENTAEMSSWOSMBRANDIDLIST);
    }

    public void setAtindpoPostventaEMSswosMBrandIDList(List<atindpo_postventa> atindpoPostventaEMSswosMBrandIDList) {
        set(PROPERTY_ATINDPOPOSTVENTAEMSSWOSMBRANDIDLIST, atindpoPostventaEMSswosMBrandIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfBrandtype> getScmfBrandtypeList() {
      return (List<ScmfBrandtype>) get(PROPERTY_SCMFBRANDTYPELIST);
    }

    public void setScmfBrandtypeList(List<ScmfBrandtype> scmfBrandtypeList) {
        set(PROPERTY_SCMFBRANDTYPELIST, scmfBrandtypeList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiModelProduct> getSsfiModelProdList() {
      return (List<SsfiModelProduct>) get(PROPERTY_SSFIMODELPRODLIST);
    }

    public void setSsfiModelProdList(List<SsfiModelProduct> ssfiModelProdList) {
        set(PROPERTY_SSFIMODELPRODLIST, ssfiModelProdList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrder> getSswclWorkOrderVList() {
      return (List<SSWCLWorkOrder>) get(PROPERTY_SSWCLWORKORDERVLIST);
    }

    public void setSswclWorkOrderVList(List<SSWCLWorkOrder> sswclWorkOrderVList) {
        set(PROPERTY_SSWCLWORKORDERVLIST, sswclWorkOrderVList);
    }

}

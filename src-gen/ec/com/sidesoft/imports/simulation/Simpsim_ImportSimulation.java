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
package ec.com.sidesoft.imports.simulation;

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
import org.openbravo.model.pricing.pricelist.PriceList;
/**
 * Entity class for entity simpsim_import_simulation (stored in table simpsim_import_simulation).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Simpsim_ImportSimulation extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "simpsim_import_simulation";
    public static final String ENTITY_NAME = "simpsim_import_simulation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BTNPRESETTLE = "bTNPreSettle";
    public static final String PROPERTY_BTNPROCESS = "bTNProcess";
    public static final String PROPERTY_BTNCREATEORDER = "bTNCreateOrder";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_SIMPSIMIMPSIMCOSTLIST = "simpsimImpSimCostList";
    public static final String PROPERTY_SIMPSIMIMPSIMLINELIST = "simpsimImpSimLineList";

    public Simpsim_ImportSimulation() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BTNPRESETTLE, false);
        setDefaultValue(PROPERTY_BTNPROCESS, false);
        setDefaultValue(PROPERTY_BTNCREATEORDER, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_SIMPSIMIMPSIMCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPSIMIMPSIMLINELIST, new ArrayList<Object>());
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isBTNPreSettle() {
        return (Boolean) get(PROPERTY_BTNPRESETTLE);
    }

    public void setBTNPreSettle(Boolean bTNPreSettle) {
        set(PROPERTY_BTNPRESETTLE, bTNPreSettle);
    }

    public Boolean isBTNProcess() {
        return (Boolean) get(PROPERTY_BTNPROCESS);
    }

    public void setBTNProcess(Boolean bTNProcess) {
        set(PROPERTY_BTNPROCESS, bTNProcess);
    }

    public Boolean isBTNCreateOrder() {
        return (Boolean) get(PROPERTY_BTNCREATEORDER);
    }

    public void setBTNCreateOrder(Boolean bTNCreateOrder) {
        set(PROPERTY_BTNCREATEORDER, bTNCreateOrder);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    @SuppressWarnings("unchecked")
    public List<Simpsim_ImpSimCost> getSimpsimImpSimCostList() {
      return (List<Simpsim_ImpSimCost>) get(PROPERTY_SIMPSIMIMPSIMCOSTLIST);
    }

    public void setSimpsimImpSimCostList(List<Simpsim_ImpSimCost> simpsimImpSimCostList) {
        set(PROPERTY_SIMPSIMIMPSIMCOSTLIST, simpsimImpSimCostList);
    }

    @SuppressWarnings("unchecked")
    public List<Simpsim_ImpSimLine> getSimpsimImpSimLineList() {
      return (List<Simpsim_ImpSimLine>) get(PROPERTY_SIMPSIMIMPSIMLINELIST);
    }

    public void setSimpsimImpSimLineList(List<Simpsim_ImpSimLine> simpsimImpSimLineList) {
        set(PROPERTY_SIMPSIMIMPSIMLINELIST, simpsimImpSimLineList);
    }

}

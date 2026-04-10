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
package ec.com.sidesoft.imports;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
/**
 * Entity class for entity SSIP_Importdata (stored in table SSIP_Importdata).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSIPImportdata extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSIP_Importdata";
    public static final String ENTITY_NAME = "SSIP_Importdata";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MEANSTRANSPORT = "meansTransport";
    public static final String PROPERTY_OUTPUTPORT = "outputPort";
    public static final String PROPERTY_ARRIVALPORT = "arrivalPort";
    public static final String PROPERTY_NUMREFADUANA = "numRefAduana";
    public static final String PROPERTY_NUMBERDUI = "numberDUI";
    public static final String PROPERTY_PAYMENTDATEDUI = "paymentDateDUI";
    public static final String PROPERTY_RELEASEDATEDUI = "releaseDateDUI";
    public static final String PROPERTY_NUMBERCHECKED = "numberChecked";
    public static final String PROPERTY_TRADINGDATA = "tradingData";
    public static final String PROPERTY_APPLIESINSURANCE = "appliesInsurance";
    public static final String PROPERTY_DATEDISPATCH = "dateDispatch";
    public static final String PROPERTY_ARRIVALDATE = "arrivalDate";
    public static final String PROPERTY_ORDER = "order";

    public SSIPImportdata() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_APPLIESINSURANCE, false);
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

    public SSIPMeanstransport getMeansTransport() {
        return (SSIPMeanstransport) get(PROPERTY_MEANSTRANSPORT);
    }

    public void setMeansTransport(SSIPMeanstransport meansTransport) {
        set(PROPERTY_MEANSTRANSPORT, meansTransport);
    }

    public SSIPPorttype getOutputPort() {
        return (SSIPPorttype) get(PROPERTY_OUTPUTPORT);
    }

    public void setOutputPort(SSIPPorttype outputPort) {
        set(PROPERTY_OUTPUTPORT, outputPort);
    }

    public SSIPPorttype getArrivalPort() {
        return (SSIPPorttype) get(PROPERTY_ARRIVALPORT);
    }

    public void setArrivalPort(SSIPPorttype arrivalPort) {
        set(PROPERTY_ARRIVALPORT, arrivalPort);
    }

    public String getNumRefAduana() {
        return (String) get(PROPERTY_NUMREFADUANA);
    }

    public void setNumRefAduana(String numRefAduana) {
        set(PROPERTY_NUMREFADUANA, numRefAduana);
    }

    public String getNumberDUI() {
        return (String) get(PROPERTY_NUMBERDUI);
    }

    public void setNumberDUI(String numberDUI) {
        set(PROPERTY_NUMBERDUI, numberDUI);
    }

    public Date getPaymentDateDUI() {
        return (Date) get(PROPERTY_PAYMENTDATEDUI);
    }

    public void setPaymentDateDUI(Date paymentDateDUI) {
        set(PROPERTY_PAYMENTDATEDUI, paymentDateDUI);
    }

    public Date getReleaseDateDUI() {
        return (Date) get(PROPERTY_RELEASEDATEDUI);
    }

    public void setReleaseDateDUI(Date releaseDateDUI) {
        set(PROPERTY_RELEASEDATEDUI, releaseDateDUI);
    }

    public String getNumberChecked() {
        return (String) get(PROPERTY_NUMBERCHECKED);
    }

    public void setNumberChecked(String numberChecked) {
        set(PROPERTY_NUMBERCHECKED, numberChecked);
    }

    public String getTradingData() {
        return (String) get(PROPERTY_TRADINGDATA);
    }

    public void setTradingData(String tradingData) {
        set(PROPERTY_TRADINGDATA, tradingData);
    }

    public Boolean isAppliesInsurance() {
        return (Boolean) get(PROPERTY_APPLIESINSURANCE);
    }

    public void setAppliesInsurance(Boolean appliesInsurance) {
        set(PROPERTY_APPLIESINSURANCE, appliesInsurance);
    }

    public Date getDateDispatch() {
        return (Date) get(PROPERTY_DATEDISPATCH);
    }

    public void setDateDispatch(Date dateDispatch) {
        set(PROPERTY_DATEDISPATCH, dateDispatch);
    }

    public Date getArrivalDate() {
        return (Date) get(PROPERTY_ARRIVALDATE);
    }

    public void setArrivalDate(Date arrivalDate) {
        set(PROPERTY_ARRIVALDATE, arrivalDate);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

}

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
package ec.com.sidesoft.app.order;

import ec.com.sidesoft.payment.in.transit.SspitraCollectionTransit;

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
import org.openbravo.model.common.order.Order;
/**
 * Entity class for entity ssappor_log (stored in table Ssappor_log).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsapporLog extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssappor_log";
    public static final String ENTITY_NAME = "ssappor_log";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_JSONINFO = "jsoninfo";
    public static final String PROPERTY_ERROR = "error";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_ISGENERATE = "isgenerate";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_SSPITRACOLLECTIONTRANSIT = "sspitraCollectiontransit";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_ORDEREMSSAPPORLOGIDLIST = "orderEMSsapporLogIDList";

    public SsapporLog() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISGENERATE, false);
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_ORDEREMSSAPPORLOGIDLIST, new ArrayList<Object>());
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

    public String getJsoninfo() {
        return (String) get(PROPERTY_JSONINFO);
    }

    public void setJsoninfo(String jsoninfo) {
        set(PROPERTY_JSONINFO, jsoninfo);
    }

    public String getError() {
        return (String) get(PROPERTY_ERROR);
    }

    public void setError(String error) {
        set(PROPERTY_ERROR, error);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public Boolean isGenerate() {
        return (Boolean) get(PROPERTY_ISGENERATE);
    }

    public void setGenerate(Boolean isgenerate) {
        set(PROPERTY_ISGENERATE, isgenerate);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public SspitraCollectionTransit getSspitraCollectiontransit() {
        return (SspitraCollectionTransit) get(PROPERTY_SSPITRACOLLECTIONTRANSIT);
    }

    public void setSspitraCollectiontransit(SspitraCollectionTransit sspitraCollectiontransit) {
        set(PROPERTY_SSPITRACOLLECTIONTRANSIT, sspitraCollectiontransit);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderEMSsapporLogIDList() {
      return (List<Order>) get(PROPERTY_ORDEREMSSAPPORLOGIDLIST);
    }

    public void setOrderEMSsapporLogIDList(List<Order> orderEMSsapporLogIDList) {
        set(PROPERTY_ORDEREMSSAPPORLOGIDLIST, orderEMSsapporLogIDList);
    }

}

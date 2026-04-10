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
package ec.com.sidesoft.mrp;

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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
/**
 * Entity class for entity ssmrp_sales_forecast (stored in table ssmrp_sales_forecast).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsmrpSalesForecast extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssmrp_sales_forecast";
    public static final String ENTITY_NAME = "ssmrp_sales_forecast";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_FORECASTPERIOD = "forecastPeriod";
    public static final String PROPERTY_FORECASTMETHOD = "forecastMethod";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYPERIOD = "qTYPeriod";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_SSMRPFORECASTLOGLIST = "ssmrpForecastLogList";

    public SsmrpSalesForecast() {
        setDefaultValue(PROPERTY_QTYPERIOD, (long) 1);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_PROCESS, true);
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SSMRPFORECASTLOGLIST, new ArrayList<Object>());
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

    public String getForecastPeriod() {
        return (String) get(PROPERTY_FORECASTPERIOD);
    }

    public void setForecastPeriod(String forecastPeriod) {
        set(PROPERTY_FORECASTPERIOD, forecastPeriod);
    }

    public String getForecastMethod() {
        return (String) get(PROPERTY_FORECASTMETHOD);
    }

    public void setForecastMethod(String forecastMethod) {
        set(PROPERTY_FORECASTMETHOD, forecastMethod);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Long getQTYPeriod() {
        return (Long) get(PROPERTY_QTYPERIOD);
    }

    public void setQTYPeriod(Long qTYPeriod) {
        set(PROPERTY_QTYPERIOD, qTYPeriod);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpForecastLog> getSsmrpForecastLogList() {
      return (List<SsmrpForecastLog>) get(PROPERTY_SSMRPFORECASTLOGLIST);
    }

    public void setSsmrpForecastLogList(List<SsmrpForecastLog> ssmrpForecastLogList) {
        set(PROPERTY_SSMRPFORECASTLOGLIST, ssmrpForecastLogList);
    }

}

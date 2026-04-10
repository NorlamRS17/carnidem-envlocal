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
package ec.com.sidesoft.dinardap.advanced;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sdindp_dinardap_config (stored in table sdindp_dinardap_config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Sdindp_DinardapConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sdindp_dinardap_config";
    public static final String ENTITY_NAME = "sdindp_dinardap_config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SQL = "sQL";
    public static final String PROPERTY_CODIGOENTIDAD = "codigoEntidad";
    public static final String PROPERTY_MAXDAYMONTH = "mAXDayMonth";
    public static final String PROPERTY_MINTRADEVALUE = "mINTradeValue";
    public static final String PROPERTY_MINVALUEBALANCEOPERATION = "mINValueBalanceOperation";
    public static final String PROPERTY_MAXDAYMONTHFEBRUARY = "mAXDayMonthFebruary";

    public Sdindp_DinardapConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CODIGOENTIDAD, "SR02700");
        setDefaultValue(PROPERTY_MAXDAYMONTH, (long) 30);
        setDefaultValue(PROPERTY_MINTRADEVALUE, new BigDecimal(60.00));
        setDefaultValue(PROPERTY_MINVALUEBALANCEOPERATION, new BigDecimal(1.00));
        setDefaultValue(PROPERTY_MAXDAYMONTHFEBRUARY, (long) 28);
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

    public String getSQL() {
        return (String) get(PROPERTY_SQL);
    }

    public void setSQL(String sQL) {
        set(PROPERTY_SQL, sQL);
    }

    public String getCodigoEntidad() {
        return (String) get(PROPERTY_CODIGOENTIDAD);
    }

    public void setCodigoEntidad(String codigoEntidad) {
        set(PROPERTY_CODIGOENTIDAD, codigoEntidad);
    }

    public Long getMAXDayMonth() {
        return (Long) get(PROPERTY_MAXDAYMONTH);
    }

    public void setMAXDayMonth(Long mAXDayMonth) {
        set(PROPERTY_MAXDAYMONTH, mAXDayMonth);
    }

    public BigDecimal getMINTradeValue() {
        return (BigDecimal) get(PROPERTY_MINTRADEVALUE);
    }

    public void setMINTradeValue(BigDecimal mINTradeValue) {
        set(PROPERTY_MINTRADEVALUE, mINTradeValue);
    }

    public BigDecimal getMINValueBalanceOperation() {
        return (BigDecimal) get(PROPERTY_MINVALUEBALANCEOPERATION);
    }

    public void setMINValueBalanceOperation(BigDecimal mINValueBalanceOperation) {
        set(PROPERTY_MINVALUEBALANCEOPERATION, mINValueBalanceOperation);
    }

    public Long getMAXDayMonthFebruary() {
        return (Long) get(PROPERTY_MAXDAYMONTHFEBRUARY);
    }

    public void setMAXDayMonthFebruary(Long mAXDayMonthFebruary) {
        set(PROPERTY_MAXDAYMONTHFEBRUARY, mAXDayMonthFebruary);
    }

}

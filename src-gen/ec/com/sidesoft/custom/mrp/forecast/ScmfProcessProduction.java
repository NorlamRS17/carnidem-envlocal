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
package ec.com.sidesoft.custom.mrp.forecast;

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
import org.openbravo.model.common.plm.Product;
/**
 * Entity class for entity scmf_process_production (stored in table scmf_process_production).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScmfProcessProduction extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scmf_process_production";
    public static final String ENTITY_NAME = "scmf_process_production";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_PROCCESSDATE = "proccessdate";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_HISTORYDAYS = "historydays";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_PERCENTAGEGROWTH = "percentageGrowth";
    public static final String PROPERTY_MEDIUM = "medium";
    public static final String PROPERTY_HALF = "half";
    public static final String PROPERTY_STANDARDDEVIATION = "standardDeviation";
    public static final String PROPERTY_MINIMUMSTOCK = "minimumStock";
    public static final String PROPERTY_INCREASEPROCENTAGE = "increaseProcentage";
    public static final String PROPERTY_STOCKMINEND = "stockMinEnd";
    public static final String PROPERTY_MEDIANX = "medianX";
    public static final String PROPERTY_MEDIANY = "medianY";
    public static final String PROPERTY_COVARIANCE = "covariance";
    public static final String PROPERTY_VARIANCE = "variance";
    public static final String PROPERTY_VARIANCEX = "varianceX";
    public static final String PROPERTY_INCLINE = "incline";
    public static final String PROPERTY_COEFFICIENTOFVARIATION = "coefficientOfVariation";
    public static final String PROPERTY_MINUMUMCYCLE = "minumumCycle";

    public ScmfProcessProduction() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public Date getProccessdate() {
        return (Date) get(PROPERTY_PROCCESSDATE);
    }

    public void setProccessdate(Date proccessdate) {
        set(PROPERTY_PROCCESSDATE, proccessdate);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getHistorydays() {
        return (BigDecimal) get(PROPERTY_HISTORYDAYS);
    }

    public void setHistorydays(BigDecimal historydays) {
        set(PROPERTY_HISTORYDAYS, historydays);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Long getPercentageGrowth() {
        return (Long) get(PROPERTY_PERCENTAGEGROWTH);
    }

    public void setPercentageGrowth(Long percentageGrowth) {
        set(PROPERTY_PERCENTAGEGROWTH, percentageGrowth);
    }

    public BigDecimal getMedium() {
        return (BigDecimal) get(PROPERTY_MEDIUM);
    }

    public void setMedium(BigDecimal medium) {
        set(PROPERTY_MEDIUM, medium);
    }

    public BigDecimal getHalf() {
        return (BigDecimal) get(PROPERTY_HALF);
    }

    public void setHalf(BigDecimal half) {
        set(PROPERTY_HALF, half);
    }

    public BigDecimal getStandardDeviation() {
        return (BigDecimal) get(PROPERTY_STANDARDDEVIATION);
    }

    public void setStandardDeviation(BigDecimal standardDeviation) {
        set(PROPERTY_STANDARDDEVIATION, standardDeviation);
    }

    public BigDecimal getMinimumStock() {
        return (BigDecimal) get(PROPERTY_MINIMUMSTOCK);
    }

    public void setMinimumStock(BigDecimal minimumStock) {
        set(PROPERTY_MINIMUMSTOCK, minimumStock);
    }

    public BigDecimal getIncreaseProcentage() {
        return (BigDecimal) get(PROPERTY_INCREASEPROCENTAGE);
    }

    public void setIncreaseProcentage(BigDecimal increaseProcentage) {
        set(PROPERTY_INCREASEPROCENTAGE, increaseProcentage);
    }

    public BigDecimal getStockMinEnd() {
        return (BigDecimal) get(PROPERTY_STOCKMINEND);
    }

    public void setStockMinEnd(BigDecimal stockMinEnd) {
        set(PROPERTY_STOCKMINEND, stockMinEnd);
    }

    public BigDecimal getMedianX() {
        return (BigDecimal) get(PROPERTY_MEDIANX);
    }

    public void setMedianX(BigDecimal medianX) {
        set(PROPERTY_MEDIANX, medianX);
    }

    public BigDecimal getMedianY() {
        return (BigDecimal) get(PROPERTY_MEDIANY);
    }

    public void setMedianY(BigDecimal medianY) {
        set(PROPERTY_MEDIANY, medianY);
    }

    public BigDecimal getCovariance() {
        return (BigDecimal) get(PROPERTY_COVARIANCE);
    }

    public void setCovariance(BigDecimal covariance) {
        set(PROPERTY_COVARIANCE, covariance);
    }

    public BigDecimal getVariance() {
        return (BigDecimal) get(PROPERTY_VARIANCE);
    }

    public void setVariance(BigDecimal variance) {
        set(PROPERTY_VARIANCE, variance);
    }

    public BigDecimal getVarianceX() {
        return (BigDecimal) get(PROPERTY_VARIANCEX);
    }

    public void setVarianceX(BigDecimal varianceX) {
        set(PROPERTY_VARIANCEX, varianceX);
    }

    public BigDecimal getIncline() {
        return (BigDecimal) get(PROPERTY_INCLINE);
    }

    public void setIncline(BigDecimal incline) {
        set(PROPERTY_INCLINE, incline);
    }

    public BigDecimal getCoefficientOfVariation() {
        return (BigDecimal) get(PROPERTY_COEFFICIENTOFVARIATION);
    }

    public void setCoefficientOfVariation(BigDecimal coefficientOfVariation) {
        set(PROPERTY_COEFFICIENTOFVARIATION, coefficientOfVariation);
    }

    public String getMinumumCycle() {
        return (String) get(PROPERTY_MINUMUMCYCLE);
    }

    public void setMinumumCycle(String minumumCycle) {
        set(PROPERTY_MINUMUMCYCLE, minumumCycle);
    }

}

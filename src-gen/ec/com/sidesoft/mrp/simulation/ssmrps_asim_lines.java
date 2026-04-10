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
package ec.com.sidesoft.mrp.simulation;

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
 * Entity class for entity ssmrps_asim_lines (stored in table ssmrps_asim_lines).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssmrps_asim_lines extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssmrps_asim_lines";
    public static final String ENTITY_NAME = "ssmrps_asim_lines";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSMRPSASIMULATIONPROD = "ssmrpsAsimulationProd";
    public static final String PROPERTY_STOCKMIN = "stockMin";
    public static final String PROPERTY_STOCKTOTAL = "stockTotal";
    public static final String PROPERTY_AVGSALES = "aVGSales";
    public static final String PROPERTY_ORDERPURCHASE1 = "orderpurchase1";
    public static final String PROPERTY_ORDERPURCHASE2 = "orderpurchase2";
    public static final String PROPERTY_ORDERPURCHASE3 = "orderpurchase3";
    public static final String PROPERTY_ORDERPURCHASE4 = "orderpurchase4";
    public static final String PROPERTY_ORDERPURCHASE5 = "orderpurchase5";
    public static final String PROPERTY_ORDERPURCHASE6 = "orderpurchase6";
    public static final String PROPERTY_ORDERPURCHASE7 = "orderpurchase7";
    public static final String PROPERTY_ORDERPURCHASE8 = "orderpurchase8";
    public static final String PROPERTY_ORDERPURCHASE9 = "orderpurchase9";
    public static final String PROPERTY_ORDERPURCHASE10 = "orderpurchase10";
    public static final String PROPERTY_ORDERPURCHASE11 = "orderpurchase11";
    public static final String PROPERTY_ORDERPURCHASE12 = "orderpurchase12";
    public static final String PROPERTY_STOCKSECURITY = "stockSecurity";
    public static final String PROPERTY_QTYORDERED = "qtyordered";
    public static final String PROPERTY_QTYORDEREDROUND = "qtyorderedRound";
    public static final String PROPERTY_FINALORDER = "finalorder";
    public static final String PROPERTY_YEARSALES = "yearsales";
    public static final String PROPERTY_MONTHSALES = "monthsales";
    public static final String PROPERTY_PRODUCTID = "productid";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_STOCKTOTAL2 = "stockTotal2";
    public static final String PROPERTY_NECESSARYQTY = "necessaryQty";
    public static final String PROPERTY_TYPEPARETO = "typePareto";
    public static final String PROPERTY_PARETO = "pareto";
    public static final String PROPERTY_PARETOTOTAL = "paretoTotal";
    public static final String PROPERTY_QTYORDEREDPURCHASE = "qtyorderedpurchase";
    public static final String PROPERTY_QTYORDEREDSALES = "qtyorderedsales";
    public static final String PROPERTY_PARTIALORDERED = "partialOrdered";

    public ssmrps_asim_lines() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_YEARSALES, (long) 0);
        setDefaultValue(PROPERTY_MONTHSALES, (long) 0);
        setDefaultValue(PROPERTY_DURATION, new BigDecimal(0));
        setDefaultValue(PROPERTY_STOCKTOTAL2, new BigDecimal(0));
        setDefaultValue(PROPERTY_NECESSARYQTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARETO, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARETOTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYORDEREDPURCHASE, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYORDEREDSALES, new BigDecimal(0));
        setDefaultValue(PROPERTY_PARTIALORDERED, new BigDecimal(0));
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

    public SsmrpsAsimulationProd getSsmrpsAsimulationProd() {
        return (SsmrpsAsimulationProd) get(PROPERTY_SSMRPSASIMULATIONPROD);
    }

    public void setSsmrpsAsimulationProd(SsmrpsAsimulationProd ssmrpsAsimulationProd) {
        set(PROPERTY_SSMRPSASIMULATIONPROD, ssmrpsAsimulationProd);
    }

    public BigDecimal getStockMin() {
        return (BigDecimal) get(PROPERTY_STOCKMIN);
    }

    public void setStockMin(BigDecimal stockMin) {
        set(PROPERTY_STOCKMIN, stockMin);
    }

    public BigDecimal getStockTotal() {
        return (BigDecimal) get(PROPERTY_STOCKTOTAL);
    }

    public void setStockTotal(BigDecimal stockTotal) {
        set(PROPERTY_STOCKTOTAL, stockTotal);
    }

    public BigDecimal getAVGSales() {
        return (BigDecimal) get(PROPERTY_AVGSALES);
    }

    public void setAVGSales(BigDecimal aVGSales) {
        set(PROPERTY_AVGSALES, aVGSales);
    }

    public BigDecimal getOrderpurchase1() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE1);
    }

    public void setOrderpurchase1(BigDecimal orderpurchase1) {
        set(PROPERTY_ORDERPURCHASE1, orderpurchase1);
    }

    public BigDecimal getOrderpurchase2() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE2);
    }

    public void setOrderpurchase2(BigDecimal orderpurchase2) {
        set(PROPERTY_ORDERPURCHASE2, orderpurchase2);
    }

    public BigDecimal getOrderpurchase3() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE3);
    }

    public void setOrderpurchase3(BigDecimal orderpurchase3) {
        set(PROPERTY_ORDERPURCHASE3, orderpurchase3);
    }

    public BigDecimal getOrderpurchase4() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE4);
    }

    public void setOrderpurchase4(BigDecimal orderpurchase4) {
        set(PROPERTY_ORDERPURCHASE4, orderpurchase4);
    }

    public BigDecimal getOrderpurchase5() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE5);
    }

    public void setOrderpurchase5(BigDecimal orderpurchase5) {
        set(PROPERTY_ORDERPURCHASE5, orderpurchase5);
    }

    public BigDecimal getOrderpurchase6() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE6);
    }

    public void setOrderpurchase6(BigDecimal orderpurchase6) {
        set(PROPERTY_ORDERPURCHASE6, orderpurchase6);
    }

    public BigDecimal getOrderpurchase7() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE7);
    }

    public void setOrderpurchase7(BigDecimal orderpurchase7) {
        set(PROPERTY_ORDERPURCHASE7, orderpurchase7);
    }

    public BigDecimal getOrderpurchase8() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE8);
    }

    public void setOrderpurchase8(BigDecimal orderpurchase8) {
        set(PROPERTY_ORDERPURCHASE8, orderpurchase8);
    }

    public BigDecimal getOrderpurchase9() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE9);
    }

    public void setOrderpurchase9(BigDecimal orderpurchase9) {
        set(PROPERTY_ORDERPURCHASE9, orderpurchase9);
    }

    public BigDecimal getOrderpurchase10() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE10);
    }

    public void setOrderpurchase10(BigDecimal orderpurchase10) {
        set(PROPERTY_ORDERPURCHASE10, orderpurchase10);
    }

    public BigDecimal getOrderpurchase11() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE11);
    }

    public void setOrderpurchase11(BigDecimal orderpurchase11) {
        set(PROPERTY_ORDERPURCHASE11, orderpurchase11);
    }

    public BigDecimal getOrderpurchase12() {
        return (BigDecimal) get(PROPERTY_ORDERPURCHASE12);
    }

    public void setOrderpurchase12(BigDecimal orderpurchase12) {
        set(PROPERTY_ORDERPURCHASE12, orderpurchase12);
    }

    public BigDecimal getStockSecurity() {
        return (BigDecimal) get(PROPERTY_STOCKSECURITY);
    }

    public void setStockSecurity(BigDecimal stockSecurity) {
        set(PROPERTY_STOCKSECURITY, stockSecurity);
    }

    public BigDecimal getQtyordered() {
        return (BigDecimal) get(PROPERTY_QTYORDERED);
    }

    public void setQtyordered(BigDecimal qtyordered) {
        set(PROPERTY_QTYORDERED, qtyordered);
    }

    public BigDecimal getQtyorderedRound() {
        return (BigDecimal) get(PROPERTY_QTYORDEREDROUND);
    }

    public void setQtyorderedRound(BigDecimal qtyorderedRound) {
        set(PROPERTY_QTYORDEREDROUND, qtyorderedRound);
    }

    public BigDecimal getFinalorder() {
        return (BigDecimal) get(PROPERTY_FINALORDER);
    }

    public void setFinalorder(BigDecimal finalorder) {
        set(PROPERTY_FINALORDER, finalorder);
    }

    public Long getYearsales() {
        return (Long) get(PROPERTY_YEARSALES);
    }

    public void setYearsales(Long yearsales) {
        set(PROPERTY_YEARSALES, yearsales);
    }

    public Long getMonthsales() {
        return (Long) get(PROPERTY_MONTHSALES);
    }

    public void setMonthsales(Long monthsales) {
        set(PROPERTY_MONTHSALES, monthsales);
    }

    public Product getProductid() {
        return (Product) get(PROPERTY_PRODUCTID);
    }

    public void setProductid(Product productid) {
        set(PROPERTY_PRODUCTID, productid);
    }

    public BigDecimal getDuration() {
        return (BigDecimal) get(PROPERTY_DURATION);
    }

    public void setDuration(BigDecimal duration) {
        set(PROPERTY_DURATION, duration);
    }

    public BigDecimal getStockTotal2() {
        return (BigDecimal) get(PROPERTY_STOCKTOTAL2);
    }

    public void setStockTotal2(BigDecimal stockTotal2) {
        set(PROPERTY_STOCKTOTAL2, stockTotal2);
    }

    public BigDecimal getNecessaryQty() {
        return (BigDecimal) get(PROPERTY_NECESSARYQTY);
    }

    public void setNecessaryQty(BigDecimal necessaryQty) {
        set(PROPERTY_NECESSARYQTY, necessaryQty);
    }

    public String getTypePareto() {
        return (String) get(PROPERTY_TYPEPARETO);
    }

    public void setTypePareto(String typePareto) {
        set(PROPERTY_TYPEPARETO, typePareto);
    }

    public BigDecimal getPareto() {
        return (BigDecimal) get(PROPERTY_PARETO);
    }

    public void setPareto(BigDecimal pareto) {
        set(PROPERTY_PARETO, pareto);
    }

    public BigDecimal getParetoTotal() {
        return (BigDecimal) get(PROPERTY_PARETOTOTAL);
    }

    public void setParetoTotal(BigDecimal paretoTotal) {
        set(PROPERTY_PARETOTOTAL, paretoTotal);
    }

    public BigDecimal getQtyorderedpurchase() {
        return (BigDecimal) get(PROPERTY_QTYORDEREDPURCHASE);
    }

    public void setQtyorderedpurchase(BigDecimal qtyorderedpurchase) {
        set(PROPERTY_QTYORDEREDPURCHASE, qtyorderedpurchase);
    }

    public BigDecimal getQtyorderedsales() {
        return (BigDecimal) get(PROPERTY_QTYORDEREDSALES);
    }

    public void setQtyorderedsales(BigDecimal qtyorderedsales) {
        set(PROPERTY_QTYORDEREDSALES, qtyorderedsales);
    }

    public BigDecimal getPartialOrdered() {
        return (BigDecimal) get(PROPERTY_PARTIALORDERED);
    }

    public void setPartialOrdered(BigDecimal partialOrdered) {
        set(PROPERTY_PARTIALORDERED, partialOrdered);
    }

}

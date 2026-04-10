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
 * All portions are Copyright (C) 2013-2017 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.common.invoice;

import java.math.BigDecimal;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Virtual entity class to hold computed columns for entity Invoice.
 *
 * NOTE: This class should not be instantiated directly.
 */
public class Invoice_ComputedColumns extends BaseOBObject implements ClientEnabled , OrganizationEnabled {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "Invoice_ComputedColumns";
    
    public static final String PROPERTY_SSPPINVPASSSELECTED = "ssppinvPassSelected";
    public static final String PROPERTY_SFPSICANCELEDDOCUMENT = "sFPSICanceledDocument";
    public static final String PROPERTY_SFPSIGRANDTOTAL = "sFPSIGrandTotal";
    public static final String PROPERTY_SFPSIOUTSTANDINGAMT = "sFPSIOutstandingAmt";
    public static final String PROPERTY_SFPSITOTALDISCOUNT = "sFPSITotalDiscount";
    public static final String PROPERTY_SFPSITOTALLINES = "sFPSITotalLines";
    public static final String PROPERTY_SFPSITOTALVAT = "sFPSITotalVAT";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Boolean isSsppinvPassSelected() {
      return (Boolean) get(PROPERTY_SSPPINVPASSSELECTED);
    }

    public void setSsppinvPassSelected(Boolean ssppinvPassSelected) {
      set(PROPERTY_SSPPINVPASSSELECTED, ssppinvPassSelected);
    }
    public Invoice getSFPSICanceledDocument() {
      return (Invoice) get(PROPERTY_SFPSICANCELEDDOCUMENT);
    }

    public void setSFPSICanceledDocument(Invoice sFPSICanceledDocument) {
      set(PROPERTY_SFPSICANCELEDDOCUMENT, sFPSICanceledDocument);
    }
    public BigDecimal getSFPSIGrandTotal() {
      return (BigDecimal) get(PROPERTY_SFPSIGRANDTOTAL);
    }

    public void setSFPSIGrandTotal(BigDecimal sFPSIGrandTotal) {
      set(PROPERTY_SFPSIGRANDTOTAL, sFPSIGrandTotal);
    }
    public BigDecimal getSFPSIOutstandingAmt() {
      return (BigDecimal) get(PROPERTY_SFPSIOUTSTANDINGAMT);
    }

    public void setSFPSIOutstandingAmt(BigDecimal sFPSIOutstandingAmt) {
      set(PROPERTY_SFPSIOUTSTANDINGAMT, sFPSIOutstandingAmt);
    }
    public BigDecimal getSFPSITotalDiscount() {
      return (BigDecimal) get(PROPERTY_SFPSITOTALDISCOUNT);
    }

    public void setSFPSITotalDiscount(BigDecimal sFPSITotalDiscount) {
      set(PROPERTY_SFPSITOTALDISCOUNT, sFPSITotalDiscount);
    }
    public BigDecimal getSFPSITotalLines() {
      return (BigDecimal) get(PROPERTY_SFPSITOTALLINES);
    }

    public void setSFPSITotalLines(BigDecimal sFPSITotalLines) {
      set(PROPERTY_SFPSITOTALLINES, sFPSITotalLines);
    }
    public BigDecimal getSFPSITotalVAT() {
      return (BigDecimal) get(PROPERTY_SFPSITOTALVAT);
    }

    public void setSFPSITotalVAT(BigDecimal sFPSITotalVAT) {
      set(PROPERTY_SFPSITOTALVAT, sFPSITotalVAT);
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
}

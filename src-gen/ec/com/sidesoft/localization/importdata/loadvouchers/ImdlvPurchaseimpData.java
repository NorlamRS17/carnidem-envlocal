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
package ec.com.sidesoft.localization.importdata.loadvouchers;

import java.math.BigDecimal;
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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity imdlv_purchaseimp_data (stored in table imdlv_purchaseimp_data).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ImdlvPurchaseimpData extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "imdlv_purchaseimp_data";
    public static final String ENTITY_NAME = "imdlv_purchaseimp_data";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DATEIMPORT = "dateimport";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_DATALOAD = "dataload";
    public static final String PROPERTY_PROCESSDATA = "processdata";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TOTALBASEIMP = "totalbaseimp";
    public static final String PROPERTY_TOTALBASEIMPVAT = "totalbaseimpvat";
    public static final String PROPERTY_TOTALWITHHVAT = "totalwithhvat";
    public static final String PROPERTY_TOTALWHITHREN = "totalwhithren";
    public static final String PROPERTY_FILENAME = "filename";
    public static final String PROPERTY_IMDLVPURCHASEIMPDLINELIST = "imdlvPurchaseimpDlineList";

    public ImdlvPurchaseimpData() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_IMDLVPURCHASEIMPDLINELIST, new ArrayList<Object>());
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

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getDateimport() {
        return (Date) get(PROPERTY_DATEIMPORT);
    }

    public void setDateimport(Date dateimport) {
        set(PROPERTY_DATEIMPORT, dateimport);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public String getDataload() {
        return (String) get(PROPERTY_DATALOAD);
    }

    public void setDataload(String dataload) {
        set(PROPERTY_DATALOAD, dataload);
    }

    public String getProcessdata() {
        return (String) get(PROPERTY_PROCESSDATA);
    }

    public void setProcessdata(String processdata) {
        set(PROPERTY_PROCESSDATA, processdata);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getTotalbaseimp() {
        return (BigDecimal) get(PROPERTY_TOTALBASEIMP);
    }

    public void setTotalbaseimp(BigDecimal totalbaseimp) {
        set(PROPERTY_TOTALBASEIMP, totalbaseimp);
    }

    public BigDecimal getTotalbaseimpvat() {
        return (BigDecimal) get(PROPERTY_TOTALBASEIMPVAT);
    }

    public void setTotalbaseimpvat(BigDecimal totalbaseimpvat) {
        set(PROPERTY_TOTALBASEIMPVAT, totalbaseimpvat);
    }

    public BigDecimal getTotalwithhvat() {
        return (BigDecimal) get(PROPERTY_TOTALWITHHVAT);
    }

    public void setTotalwithhvat(BigDecimal totalwithhvat) {
        set(PROPERTY_TOTALWITHHVAT, totalwithhvat);
    }

    public BigDecimal getTotalwhithren() {
        return (BigDecimal) get(PROPERTY_TOTALWHITHREN);
    }

    public void setTotalwhithren(BigDecimal totalwhithren) {
        set(PROPERTY_TOTALWHITHREN, totalwhithren);
    }

    public String getFilename() {
        return (String) get(PROPERTY_FILENAME);
    }

    public void setFilename(String filename) {
        set(PROPERTY_FILENAME, filename);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseImpDataLine> getImdlvPurchaseimpDlineList() {
      return (List<ImdlvPurchaseImpDataLine>) get(PROPERTY_IMDLVPURCHASEIMPDLINELIST);
    }

    public void setImdlvPurchaseimpDlineList(List<ImdlvPurchaseImpDataLine> imdlvPurchaseimpDlineList) {
        set(PROPERTY_IMDLVPURCHASEIMPDLINELIST, imdlvPurchaseimpDlineList);
    }

}

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
 * Entity class for entity imdlv_voucher_purchase (stored in table imdlv_voucher_purchase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ImdlvVoucherData extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "imdlv_voucher_purchase";
    public static final String ENTITY_NAME = "imdlv_voucher_purchase";
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
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_DATALOAD = "dataload";
    public static final String PROPERTY_PROCESSDATA = "processdata";
    public static final String PROPERTY_FILENAMEDATA = "filenamedata";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DATALOADVOUCHER = "dataloadvoucher";
    public static final String PROPERTY_CREATELINES = "createlines";
    public static final String PROPERTY_CREATETRX = "createtrx";
    public static final String PROPERTY_DATETRX = "datetrx";
    public static final String PROPERTY_CREATETRX2 = "createtrx2";
    public static final String PROPERTY_FORMATO = "formato";
    public static final String PROPERTY_TYPEFILE = "typeFile";
    public static final String PROPERTY_IMDLVVOUCHERPURCHLINELIST = "imdlvVoucherpurchlineList";

    public ImdlvVoucherData() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_DATALOAD, false);
        setDefaultValue(PROPERTY_PROCESSDATA, false);
        setDefaultValue(PROPERTY_CREATELINES, false);
        setDefaultValue(PROPERTY_CREATETRX, false);
        setDefaultValue(PROPERTY_CREATETRX2, "CT");
        setDefaultValue(PROPERTY_FORMATO, "text/plain");
        setDefaultValue(PROPERTY_IMDLVVOUCHERPURCHLINELIST, new ArrayList<Object>());
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

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public Boolean isDataload() {
        return (Boolean) get(PROPERTY_DATALOAD);
    }

    public void setDataload(Boolean dataload) {
        set(PROPERTY_DATALOAD, dataload);
    }

    public Boolean isProcessdata() {
        return (Boolean) get(PROPERTY_PROCESSDATA);
    }

    public void setProcessdata(Boolean processdata) {
        set(PROPERTY_PROCESSDATA, processdata);
    }

    public String getFilenamedata() {
        return (String) get(PROPERTY_FILENAMEDATA);
    }

    public void setFilenamedata(String filenamedata) {
        set(PROPERTY_FILENAMEDATA, filenamedata);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDataloadvoucher() {
        return (String) get(PROPERTY_DATALOADVOUCHER);
    }

    public void setDataloadvoucher(String dataloadvoucher) {
        set(PROPERTY_DATALOADVOUCHER, dataloadvoucher);
    }

    public Boolean isCreatelines() {
        return (Boolean) get(PROPERTY_CREATELINES);
    }

    public void setCreatelines(Boolean createlines) {
        set(PROPERTY_CREATELINES, createlines);
    }

    public Boolean isCreatetrx() {
        return (Boolean) get(PROPERTY_CREATETRX);
    }

    public void setCreatetrx(Boolean createtrx) {
        set(PROPERTY_CREATETRX, createtrx);
    }

    public Date getDatetrx() {
        return (Date) get(PROPERTY_DATETRX);
    }

    public void setDatetrx(Date datetrx) {
        set(PROPERTY_DATETRX, datetrx);
    }

    public String getCreatetrx2() {
        return (String) get(PROPERTY_CREATETRX2);
    }

    public void setCreatetrx2(String createtrx2) {
        set(PROPERTY_CREATETRX2, createtrx2);
    }

    public String getFormato() {
        return (String) get(PROPERTY_FORMATO);
    }

    public void setFormato(String formato) {
        set(PROPERTY_FORMATO, formato);
    }

    public String getTypeFile() {
        return (String) get(PROPERTY_TYPEFILE);
    }

    public void setTypeFile(String typeFile) {
        set(PROPERTY_TYPEFILE, typeFile);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvVoucherDataLine> getImdlvVoucherpurchlineList() {
      return (List<ImdlvVoucherDataLine>) get(PROPERTY_IMDLVVOUCHERPURCHLINELIST);
    }

    public void setImdlvVoucherpurchlineList(List<ImdlvVoucherDataLine> imdlvVoucherpurchlineList) {
        set(PROPERTY_IMDLVVOUCHERPURCHLINELIST, imdlvVoucherpurchlineList);
    }

}

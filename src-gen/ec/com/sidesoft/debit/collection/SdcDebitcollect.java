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
package ec.com.sidesoft.debit.collection;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity sdc_debitcollect (stored in table sdc_debitcollect).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SdcDebitcollect extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sdc_debitcollect";
    public static final String ENTITY_NAME = "sdc_debitcollect";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TRANSACDATE = "transacDate";
    public static final String PROPERTY_ACREDITDATE = "acreditDate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_COLLECTIONPROPOSAL = "collectionproposal";
    public static final String PROPERTY_LOADLINES = "loadlines";
    public static final String PROPERTY_RECONCILE = "reconcile";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_CREATECOLLECTION = "createcollection";
    public static final String PROPERTY_CONDITION = "condition";
    public static final String PROPERTY_TYPELOAD = "typeload";
    public static final String PROPERTY_ACREDITDATEFROM = "acreditDateFrom";
    public static final String PROPERTY_REMOVELINES = "removeLines";
    public static final String PROPERTY_ISBULKUPLOAD = "isbulkupload";
    public static final String PROPERTY_FINFINANCIALACCOUNTFILE = "fINFinancialAccountFile";
    public static final String PROPERTY_SDCDCCONFIRMATIONSLIST = "sdcDcConfirmationsList";
    public static final String PROPERTY_SDCDCDETAILLIST = "sdcDcDetailList";
    public static final String PROPERTY_SDCDCPROPOCOLLECTLIST = "sdcDcPropocollectList";

    public SdcDebitcollect() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_COLLECTIONPROPOSAL, false);
        setDefaultValue(PROPERTY_LOADLINES, false);
        setDefaultValue(PROPERTY_RECONCILE, false);
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_CREATECOLLECTION, false);
        setDefaultValue(PROPERTY_REMOVELINES, false);
        setDefaultValue(PROPERTY_ISBULKUPLOAD, false);
        setDefaultValue(PROPERTY_SDCDCCONFIRMATIONSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCDCDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCDCPROPOCOLLECTLIST, new ArrayList<Object>());
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

    public Date getTransacDate() {
        return (Date) get(PROPERTY_TRANSACDATE);
    }

    public void setTransacDate(Date transacDate) {
        set(PROPERTY_TRANSACDATE, transacDate);
    }

    public Date getAcreditDate() {
        return (Date) get(PROPERTY_ACREDITDATE);
    }

    public void setAcreditDate(Date acreditDate) {
        set(PROPERTY_ACREDITDATE, acreditDate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public Boolean isCollectionproposal() {
        return (Boolean) get(PROPERTY_COLLECTIONPROPOSAL);
    }

    public void setCollectionproposal(Boolean collectionproposal) {
        set(PROPERTY_COLLECTIONPROPOSAL, collectionproposal);
    }

    public Boolean isLoadlines() {
        return (Boolean) get(PROPERTY_LOADLINES);
    }

    public void setLoadlines(Boolean loadlines) {
        set(PROPERTY_LOADLINES, loadlines);
    }

    public Boolean isReconcile() {
        return (Boolean) get(PROPERTY_RECONCILE);
    }

    public void setReconcile(Boolean reconcile) {
        set(PROPERTY_RECONCILE, reconcile);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isCreatecollection() {
        return (Boolean) get(PROPERTY_CREATECOLLECTION);
    }

    public void setCreatecollection(Boolean createcollection) {
        set(PROPERTY_CREATECOLLECTION, createcollection);
    }

    public String getCondition() {
        return (String) get(PROPERTY_CONDITION);
    }

    public void setCondition(String condition) {
        set(PROPERTY_CONDITION, condition);
    }

    public String getTypeload() {
        return (String) get(PROPERTY_TYPELOAD);
    }

    public void setTypeload(String typeload) {
        set(PROPERTY_TYPELOAD, typeload);
    }

    public Date getAcreditDateFrom() {
        return (Date) get(PROPERTY_ACREDITDATEFROM);
    }

    public void setAcreditDateFrom(Date acreditDateFrom) {
        set(PROPERTY_ACREDITDATEFROM, acreditDateFrom);
    }

    public Boolean isRemoveLines() {
        return (Boolean) get(PROPERTY_REMOVELINES);
    }

    public void setRemoveLines(Boolean removeLines) {
        set(PROPERTY_REMOVELINES, removeLines);
    }

    public Boolean isBulkupload() {
        return (Boolean) get(PROPERTY_ISBULKUPLOAD);
    }

    public void setBulkupload(Boolean isbulkupload) {
        set(PROPERTY_ISBULKUPLOAD, isbulkupload);
    }

    public FIN_FinancialAccount getFINFinancialAccountFile() {
        return (FIN_FinancialAccount) get(PROPERTY_FINFINANCIALACCOUNTFILE);
    }

    public void setFINFinancialAccountFile(FIN_FinancialAccount fINFinancialAccountFile) {
        set(PROPERTY_FINFINANCIALACCOUNTFILE, fINFinancialAccountFile);
    }

    @SuppressWarnings("unchecked")
    public List<SdcDcConfirmations> getSdcDcConfirmationsList() {
      return (List<SdcDcConfirmations>) get(PROPERTY_SDCDCCONFIRMATIONSLIST);
    }

    public void setSdcDcConfirmationsList(List<SdcDcConfirmations> sdcDcConfirmationsList) {
        set(PROPERTY_SDCDCCONFIRMATIONSLIST, sdcDcConfirmationsList);
    }

    @SuppressWarnings("unchecked")
    public List<SdcDcDetail> getSdcDcDetailList() {
      return (List<SdcDcDetail>) get(PROPERTY_SDCDCDETAILLIST);
    }

    public void setSdcDcDetailList(List<SdcDcDetail> sdcDcDetailList) {
        set(PROPERTY_SDCDCDETAILLIST, sdcDcDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SdcDcPropocollect> getSdcDcPropocollectList() {
      return (List<SdcDcPropocollect>) get(PROPERTY_SDCDCPROPOCOLLECTLIST);
    }

    public void setSdcDcPropocollectList(List<SdcDcPropocollect> sdcDcPropocollectList) {
        set(PROPERTY_SDCDCPROPOCOLLECTLIST, sdcDcPropocollectList);
    }

}

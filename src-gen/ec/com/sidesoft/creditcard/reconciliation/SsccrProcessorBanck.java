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
package ec.com.sidesoft.creditcard.reconciliation;

import ec.com.sidesoft.creditcard.reconciliation.transaction.sccrt_concepts;

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
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
/**
 * Entity class for entity Ssccr_Processor_Banck (stored in table Ssccr_Processor_Banck).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsccrProcessorBanck extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssccr_Processor_Banck";
    public static final String ENTITY_NAME = "Ssccr_Processor_Banck";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_FINFINACCTRANSACTIONEMSSCCRPROCESSORBANCKIDLIST = "fINFinaccTransactionEMSsccrProcessorBanckIDList";
    public static final String PROPERTY_SSCCRCARDMATCHINGCONFLIST = "ssccrCardMatchingConfList";
    public static final String PROPERTY_SSCCRCARDSTYPESLIST = "ssccrCardsTypesList";
    public static final String PROPERTY_SSCCRFINACCTRANSVLIST = "ssccrFinaccTransVList";
    public static final String PROPERTY_SSCCRPOSCARDRECLINELIST = "ssccrPosCardRecLineList";
    public static final String PROPERTY_SSCCRPOSCARDRECSUMLIST = "ssccrPosCardRecSumList";
    public static final String PROPERTY_SCCRTCONCEPTSLIST = "sccrtConceptsList";
    public static final String PROPERTY_SSCCRCARDRECDETAILVLIST = "ssccrCardRecDetailVList";

    public SsccrProcessorBanck() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONEMSSCCRPROCESSORBANCKIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRCARDMATCHINGCONFLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRCARDSTYPESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRFINACCTRANSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRPOSCARDRECLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRPOSCARDRECSUMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCRTCONCEPTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRCARDRECDETAILVLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionEMSsccrProcessorBanckIDList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONEMSSCCRPROCESSORBANCKIDLIST);
    }

    public void setFINFinaccTransactionEMSsccrProcessorBanckIDList(List<FIN_FinaccTransaction> fINFinaccTransactionEMSsccrProcessorBanckIDList) {
        set(PROPERTY_FINFINACCTRANSACTIONEMSSCCRPROCESSORBANCKIDLIST, fINFinaccTransactionEMSsccrProcessorBanckIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrCardMatchingConf> getSsccrCardMatchingConfList() {
      return (List<SsccrCardMatchingConf>) get(PROPERTY_SSCCRCARDMATCHINGCONFLIST);
    }

    public void setSsccrCardMatchingConfList(List<SsccrCardMatchingConf> ssccrCardMatchingConfList) {
        set(PROPERTY_SSCCRCARDMATCHINGCONFLIST, ssccrCardMatchingConfList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrCardsTypes> getSsccrCardsTypesList() {
      return (List<SsccrCardsTypes>) get(PROPERTY_SSCCRCARDSTYPESLIST);
    }

    public void setSsccrCardsTypesList(List<SsccrCardsTypes> ssccrCardsTypesList) {
        set(PROPERTY_SSCCRCARDSTYPESLIST, ssccrCardsTypesList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrFinaccTransV> getSsccrFinaccTransVList() {
      return (List<SsccrFinaccTransV>) get(PROPERTY_SSCCRFINACCTRANSVLIST);
    }

    public void setSsccrFinaccTransVList(List<SsccrFinaccTransV> ssccrFinaccTransVList) {
        set(PROPERTY_SSCCRFINACCTRANSVLIST, ssccrFinaccTransVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrPosCardRecLine> getSsccrPosCardRecLineList() {
      return (List<SsccrPosCardRecLine>) get(PROPERTY_SSCCRPOSCARDRECLINELIST);
    }

    public void setSsccrPosCardRecLineList(List<SsccrPosCardRecLine> ssccrPosCardRecLineList) {
        set(PROPERTY_SSCCRPOSCARDRECLINELIST, ssccrPosCardRecLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrPosCardRecSum> getSsccrPosCardRecSumList() {
      return (List<SsccrPosCardRecSum>) get(PROPERTY_SSCCRPOSCARDRECSUMLIST);
    }

    public void setSsccrPosCardRecSumList(List<SsccrPosCardRecSum> ssccrPosCardRecSumList) {
        set(PROPERTY_SSCCRPOSCARDRECSUMLIST, ssccrPosCardRecSumList);
    }

    @SuppressWarnings("unchecked")
    public List<sccrt_concepts> getSccrtConceptsList() {
      return (List<sccrt_concepts>) get(PROPERTY_SCCRTCONCEPTSLIST);
    }

    public void setSccrtConceptsList(List<sccrt_concepts> sccrtConceptsList) {
        set(PROPERTY_SCCRTCONCEPTSLIST, sccrtConceptsList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssccr_CardRecDetailV> getSsccrCardRecDetailVList() {
      return (List<Ssccr_CardRecDetailV>) get(PROPERTY_SSCCRCARDRECDETAILVLIST);
    }

    public void setSsccrCardRecDetailVList(List<Ssccr_CardRecDetailV> ssccrCardRecDetailVList) {
        set(PROPERTY_SSCCRCARDRECDETAILVLIST, ssccrCardRecDetailVList);
    }

}

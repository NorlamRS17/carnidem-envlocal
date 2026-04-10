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
package ec.com.sidesoft.document.sequence;

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
import org.openbravo.retail.posterminal.OBPOSApplications;
/**
 * Entity class for entity ECSDS_PointOfSaleSeq (stored in table ecsds_psale_seq).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PointOfSaleSeq extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ecsds_psale_seq";
    public static final String ENTITY_NAME = "ECSDS_PointOfSaleSeq";
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
    public static final String PROPERTY_ECSDSCOMPROTYPE = "ecsdsComproType";
    public static final String PROPERTY_STORE = "store";
    public static final String PROPERTY_SEQUENCEFROM = "sequenceFrom";
    public static final String PROPERTY_SEQUENCETO = "sequenceTo";
    public static final String PROPERTY_GENERATED = "generated";
    public static final String PROPERTY_INVOICESEQ = "invoiceSeq";
    public static final String PROPERTY_POSTERMINAL = "pOSTerminal";
    public static final String PROPERTY_ECSDSPOINOFSALESEQUENCELINELIST = "eCSDSPoinOfSaleSequenceLineList";

    public PointOfSaleSeq() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_GENERATED, false);
        setDefaultValue(PROPERTY_ECSDSPOINOFSALESEQUENCELINELIST, new ArrayList<Object>());
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

    public ComprobanteType getEcsdsComproType() {
        return (ComprobanteType) get(PROPERTY_ECSDSCOMPROTYPE);
    }

    public void setEcsdsComproType(ComprobanteType ecsdsComproType) {
        set(PROPERTY_ECSDSCOMPROTYPE, ecsdsComproType);
    }

    public String getStore() {
        return (String) get(PROPERTY_STORE);
    }

    public void setStore(String store) {
        set(PROPERTY_STORE, store);
    }

    public Long getSequenceFrom() {
        return (Long) get(PROPERTY_SEQUENCEFROM);
    }

    public void setSequenceFrom(Long sequenceFrom) {
        set(PROPERTY_SEQUENCEFROM, sequenceFrom);
    }

    public Long getSequenceTo() {
        return (Long) get(PROPERTY_SEQUENCETO);
    }

    public void setSequenceTo(Long sequenceTo) {
        set(PROPERTY_SEQUENCETO, sequenceTo);
    }

    public Boolean isGenerated() {
        return (Boolean) get(PROPERTY_GENERATED);
    }

    public void setGenerated(Boolean generated) {
        set(PROPERTY_GENERATED, generated);
    }

    public Boolean isInvoiceSeq() {
        return (Boolean) get(PROPERTY_INVOICESEQ);
    }

    public void setInvoiceSeq(Boolean invoiceSeq) {
        set(PROPERTY_INVOICESEQ, invoiceSeq);
    }

    public OBPOSApplications getPOSTerminal() {
        return (OBPOSApplications) get(PROPERTY_POSTERMINAL);
    }

    public void setPOSTerminal(OBPOSApplications pOSTerminal) {
        set(PROPERTY_POSTERMINAL, pOSTerminal);
    }

    @SuppressWarnings("unchecked")
    public List<PoinOfSaleSequenceLine> getECSDSPoinOfSaleSequenceLineList() {
      return (List<PoinOfSaleSequenceLine>) get(PROPERTY_ECSDSPOINOFSALESEQUENCELINELIST);
    }

    public void setECSDSPoinOfSaleSequenceLineList(List<PoinOfSaleSequenceLine> eCSDSPoinOfSaleSequenceLineList) {
        set(PROPERTY_ECSDSPOINOFSALESEQUENCELINELIST, eCSDSPoinOfSaleSequenceLineList);
    }

}

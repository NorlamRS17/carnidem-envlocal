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
 * Entity class for entity scmf_season_product (stored in table scmf_season_product).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScmfSeasonProduct extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scmf_season_product";
    public static final String ENTITY_NAME = "scmf_season_product";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_SEASONTYPE = "seasonType";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_PERCENTAGE = "percentage";
    public static final String PROPERTY_SUBCATEGORYLIST = "subcategorylist";
    public static final String PROPERTY_PRODUCTLIST = "productlist";
    public static final String PROPERTY_BRANDTYPE = "brandtype";
    public static final String PROPERTY_CATEGORYLIST = "categorylist";
    public static final String PROPERTY_SCMFBRANDTYPELIST = "scmfBrandtypeList";
    public static final String PROPERTY_SCMFPRODUCTLIST = "scmfProductList";
    public static final String PROPERTY_SCMFPRODUCTCATEGORYLIST = "scmfProductCategoryList";
    public static final String PROPERTY_SCMFPRODUCTSUBCATEGORYLIST = "scmfProductSubcategoryList";

    public ScmfSeasonProduct() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SCMFBRANDTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPRODUCTCATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPRODUCTSUBCATEGORYLIST, new ArrayList<Object>());
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

    public String getSeasonType() {
        return (String) get(PROPERTY_SEASONTYPE);
    }

    public void setSeasonType(String seasonType) {
        set(PROPERTY_SEASONTYPE, seasonType);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public BigDecimal getPercentage() {
        return (BigDecimal) get(PROPERTY_PERCENTAGE);
    }

    public void setPercentage(BigDecimal percentage) {
        set(PROPERTY_PERCENTAGE, percentage);
    }

    public String getSubcategorylist() {
        return (String) get(PROPERTY_SUBCATEGORYLIST);
    }

    public void setSubcategorylist(String subcategorylist) {
        set(PROPERTY_SUBCATEGORYLIST, subcategorylist);
    }

    public String getProductlist() {
        return (String) get(PROPERTY_PRODUCTLIST);
    }

    public void setProductlist(String productlist) {
        set(PROPERTY_PRODUCTLIST, productlist);
    }

    public String getBrandtype() {
        return (String) get(PROPERTY_BRANDTYPE);
    }

    public void setBrandtype(String brandtype) {
        set(PROPERTY_BRANDTYPE, brandtype);
    }

    public String getCategorylist() {
        return (String) get(PROPERTY_CATEGORYLIST);
    }

    public void setCategorylist(String categorylist) {
        set(PROPERTY_CATEGORYLIST, categorylist);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfBrandtype> getScmfBrandtypeList() {
      return (List<ScmfBrandtype>) get(PROPERTY_SCMFBRANDTYPELIST);
    }

    public void setScmfBrandtypeList(List<ScmfBrandtype> scmfBrandtypeList) {
        set(PROPERTY_SCMFBRANDTYPELIST, scmfBrandtypeList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfProduct> getScmfProductList() {
      return (List<ScmfProduct>) get(PROPERTY_SCMFPRODUCTLIST);
    }

    public void setScmfProductList(List<ScmfProduct> scmfProductList) {
        set(PROPERTY_SCMFPRODUCTLIST, scmfProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfProductCategory> getScmfProductCategoryList() {
      return (List<ScmfProductCategory>) get(PROPERTY_SCMFPRODUCTCATEGORYLIST);
    }

    public void setScmfProductCategoryList(List<ScmfProductCategory> scmfProductCategoryList) {
        set(PROPERTY_SCMFPRODUCTCATEGORYLIST, scmfProductCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfProductSubcategory> getScmfProductSubcategoryList() {
      return (List<ScmfProductSubcategory>) get(PROPERTY_SCMFPRODUCTSUBCATEGORYLIST);
    }

    public void setScmfProductSubcategoryList(List<ScmfProductSubcategory> scmfProductSubcategoryList) {
        set(PROPERTY_SCMFPRODUCTSUBCATEGORYLIST, scmfProductSubcategoryList);
    }

}

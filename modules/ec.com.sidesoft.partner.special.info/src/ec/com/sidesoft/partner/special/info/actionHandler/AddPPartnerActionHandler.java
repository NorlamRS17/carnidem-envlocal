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
 * All portions are Copyright (C) 2014-2016 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.partner.special.info.actionHandler;

import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.actionHandler.AddPaymentActionHandler;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.geography.Region;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.service.db.DbUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.localization.geography.secpm_canton;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPartner;
import it.openia.crm.OpcrmConfig;
import it.openia.crm.Opcrmopportunities;
import org.openbravo.model.pricing.pricelist.PriceList;

public class AddPPartnerActionHandler extends AddPaymentActionHandler {
  final private static Logger log = LoggerFactory.getLogger(AddPPartnerActionHandler.class);

  @Override
  protected JSONObject doExecute(Map<String, Object> parameters, String content) {
    // super.execute(info);
    JSONObject jsonResponse = new JSONObject();
    JSONArray actions = new JSONArray();
    OBContext.setAdminMode(true);
    boolean openedFromMenu = false;
    String comingFrom = null;
    try {

      VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
      // Get Params
      JSONObject jsonRequest = new JSONObject(content);
      JSONObject jsonparams = jsonRequest.getJSONObject("_params");
      OBCriteria<BusinessPartner> partner = OBDal.getInstance()
          .createCriteria(BusinessPartner.class);
      partner.add(Restrictions.or(
          Restrictions.eq(BusinessPartner.PROPERTY_SEARCHKEY, jsonparams.getString("taxid")),
          Restrictions.eq(BusinessPartner.PROPERTY_TAXID, jsonparams.getString("taxid"))));
      if (partner.count() == 0) {

        BusinessPartner partneer = addNewPartner(jsonparams);
        String message = "Tercero creado: " + partneer.getTaxID() + " - " + partneer.getName();
        // Mensaje de EXITO
        JSONObject msgInBPTab = new JSONObject();
        msgInBPTab.put("msgType", "success");
        msgInBPTab.put("msgTitle", "ProcessOK");
        msgInBPTab.put("msgText", message);

        JSONObject msgInBPTabAction = new JSONObject();
        msgInBPTabAction.put("showMsgInView", msgInBPTab);

        // Campos Cambiados del grid
        JSONObject setSelectorValueFromRecord = new JSONObject();
        JSONObject record = new JSONObject();
        JSONObject responseActions = new JSONObject();
        record.put("value", partneer.getId());
        record.put("map", partneer.getIdentifier());
        setSelectorValueFromRecord.put("record", record);
        responseActions.put("setSelectorValueFromRecord", setSelectorValueFromRecord);
        responseActions.put("reloadParameters", setSelectorValueFromRecord);
        actions.put(responseActions);
        actions.put(msgInBPTabAction);

        jsonResponse.put("responseActions", actions);
      } else {
        jsonResponse = new JSONObject();
        String message = "Ya existe un cliente " + partner.list().get(0).getName()
            + " con # de cédula/RUC " + partner.list().get(0).getTaxID();
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("severity", "error");
        errorMessage.put("text", message);
        jsonResponse.put("retryExecution", openedFromMenu);
        jsonResponse.put("message", errorMessage);

      }
      ;

    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      log.error("Exception handling the new payment", e);

      try {
        jsonResponse = new JSONObject();
        Throwable ex = DbUtility.getUnderlyingSQLException(e);
        String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("severity", "error");
        errorMessage.put("text", message);
        jsonResponse.put("retryExecution", openedFromMenu);
        jsonResponse.put("message", errorMessage);

      } catch (Exception ignore) {
      }
    } finally {
      OBContext.restorePreviousMode();
      // super.execute(info);
    }
    return jsonResponse;
  }

  private BusinessPartner addNewPartner(JSONObject opportunity) throws OBException, JSONException {
    //log.error(opportunity);
    

    String strFirstName = opportunity.getString("name1");
    strFirstName = strFirstName.length() > 60 ? strFirstName.substring(0, 60) : strFirstName;
    String strFirstName2 = opportunity.getString("name2");
    strFirstName2 = strFirstName2.length() > 60 ? strFirstName2.substring(0, 60) : strFirstName2;
    String strFullName = "";
    strFullName = strFirstName + " " + strFirstName2;
    String strUser1 = opportunity.getString("em_ssfc_user1_id");
    String strMprice = opportunity.getString("M_PriceList_ID");

    strFullName = strFullName.length() > 60 ? strFullName.substring(0, 60) : strFullName;
    BusinessPartner newPartner = OBProvider.getInstance().get(BusinessPartner.class);
    Organization objOrganization = OBDal.getInstance().get(Organization.class, "0");
    UserDimension1 objUser1 =  OBDal.getInstance().get(UserDimension1.class, strUser1);
    PriceList objMprice =  OBDal.getInstance().get(PriceList.class, strMprice);
    
    OBCriteria<ImdlvPartner> bpConfig = OBDal.getInstance().createCriteria(ImdlvPartner.class);
    bpConfig.add(Restrictions.eq(ImdlvPartner.PROPERTY_PRICELIST, objMprice));
    bpConfig.setMaxResults(1);
    ImdlvPartner config = (ImdlvPartner) bpConfig.uniqueResult();
    
    if(bpConfig.count() == 0)
    {
    	throw new OBException("La tarifa no esta configurada en la ventana de Datos por defecto creciòn Terceros");
    }
    
    newPartner.setOrganization(objOrganization);
    newPartner.setSearchKey(opportunity.getString("taxid"));
    newPartner.setTaxID(opportunity.getString("taxid"));
    newPartner.setSspsiOrigin(opportunity.getString("EM_Sspsi_Origin"));
    newPartner.setSsfcUser1(objUser1);
    newPartner.setPriceList(objMprice);
    newPartner.setName(strFullName);
    newPartner.setName2(strFullName);
    newPartner.setBusinessPartnerCategory(config.getBpGroup());
    newPartner.setSswhTaxidtype(opportunity.getString("document_type"));
    newPartner.setOpcrmBpEmail(opportunity.getString("email"));
    newPartner.setEEIEmail(opportunity.getString("email"));
    newPartner.setAtimdmEmail(opportunity.getString("email"));
    newPartner.setPaymentTerms(config.getPaymentterm());
    newPartner.setPaymentMethod(config.getFINPaymentmethod());
    OBDal.getInstance().save(newPartner);
    OBDal.getInstance().flush();

    addNewPartnerLocation(opportunity, newPartner, objOrganization);
    return newPartner;

  }

  private void addNewPartnerLocation(JSONObject opportunity, BusinessPartner bp,
      Organization objOrganization) throws OBException, JSONException {
    Location location = OBProvider.getInstance().get(Location.class);
    location.setOrganization(objOrganization);
    location.setAddressLine1(opportunity.getString("first_line"));
    location.setAddressLine2(opportunity.getString("second_line"));
    location.setPostalCode(opportunity.getString("postal_code"));
    location.setCityName(opportunity.getString("location"));
    Country countryvalue = OBDal.getInstance().get(Country.class,
        opportunity.getString("c_country_id"));
    location.setCountry(countryvalue);
    Region objRegion = OBDal.getInstance().get(Region.class, opportunity.getString("c_region_id"));
    location.setRegion(objRegion);
    OBDal.getInstance().save(location);
    OBDal.getInstance().flush();

    org.openbravo.model.common.businesspartner.Location bpLocation = OBProvider.getInstance()
        .get(org.openbravo.model.common.businesspartner.Location.class);
    bpLocation.setBusinessPartner(bp);
    bpLocation.setOrganization(objOrganization);
    bpLocation.setPhone(opportunity.getString("phone"));
    bpLocation
        .setSspsiLatitude(opportunity.has("latitude") ? opportunity.getString("latitude") : "");
    bpLocation
        .setSspsiLongitude(opportunity.has("longitude") ? opportunity.getString("longitude") : "");
    bpLocation.setLocationAddress(location);
    OBDal.getInstance().save(bpLocation);
    OBDal.getInstance().flush();

  }

}



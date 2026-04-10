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
 * All portions are Copyright (C) 2011-2012 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.carnidem.inheritance.attribute.ad_actionButton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.reference.PInstanceProcessData;
import org.openbravo.erpCommon.utility.AttributeSetInstanceValue;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.plm.Attribute;
import org.openbravo.model.common.plm.AttributeInstance;
import org.openbravo.model.common.plm.AttributeSet;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.AttributeUse;
import org.openbravo.model.common.plm.AttributeValue;
import org.openbravo.model.manufacturing.processplan.OperationProduct;
import org.openbravo.model.manufacturing.processplan.OperationProductAttribute;
import org.openbravo.model.manufacturing.transaction.WorkRequirementProduct;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.Replace;

public class CreateStandardsCustom implements org.openbravo.scheduling.Process {

  private static final String AD_MESSAGE_NOT_ENOUGH_STOCKED = "@NotEnoughStocked@";
  private static final String AD_MESSAGE_NOT_ENOUGH_STOCKED_WH_RULE = "@NotEnoughStockedDueWHRule@";

  private static final String lotSearchKey = "LOT";
  private static final String serialNoSearchKey = "SNO";
  private static final String expirationDateSearchKey = "EXD";
  private static final String julydate = "JD";
  private static final Logger log4j = Logger.getLogger(CreateStandardsCustom.class);
  protected ConnectionProvider connx;

  @Override
  public void execute(ProcessBundle bundle) throws Exception {
 
    final String strMProductionPlanID = (String) bundle.getParams().get("M_ProductionPlan_ID");
    final ConnectionProvider conn = bundle.getConnection();
    final VariablesSecureApp vars = bundle.getContext().toVars();
    this.connx = new DalConnectionProvider(false);

    try {
      ProductionPlan productionPlan = OBDal.getInstance().get(ProductionPlan.class,
          strMProductionPlanID);

      //SE VALIDAN QUE ESTOS CAMPOS NO SEAN NULL  
      Date start = productionPlan.getStartingTime();
      Date end = productionPlan.getEndingTime();
      if(start == null || end == null) {
        throw new OBException("Los campos Comienzo y Fin son obligatorios");
      }

      final ProcessInstance standardsPi = callCreateStandardsProcess(productionPlan, conn, vars);

      OBDal.getInstance().save(productionPlan);
      OBDal.getInstance().flush();

      copyAttributes(conn, vars, productionPlan);
      createInstanciableAttributes(conn, vars, productionPlan);

      final OBError stdMsg = Utility.getProcessInstanceMessage(conn, vars,
          PInstanceProcessData.select(new DalConnectionProvider(false), standardsPi.getId()));
      final OBError msg = new OBError();
      final String lang = bundle.getContext().getLanguage();
      if (standardsPi.getResult() == 2L) {
        msg.setType("Warning");
        msg.setTitle("Advertencia de Inventario");
        msg.setMessage(stdMsg.getMessage());
      } else {
        msg.setType("Success");
        msg.setTitle(Utility.messageBD(conn, "Success", lang));
        msg.setMessage(Utility.messageBD(conn, "Success", lang));
      }
      bundle.setResult(msg);
    } catch (final Exception e) {
      OBDal.getInstance().rollbackAndClose();
      log4j.error("Error creating standards", e);
      final OBError msg = new OBError();
      msg.setType("Error");
      msg.setMessage(e.getMessage());
      msg.setTitle(Utility.messageBD(conn, "Error", bundle.getContext().getLanguage()));
      bundle.setResult(msg);
    }
  }

  private ProcessInstance callCreateStandardsProcess(ProductionPlan productionplan, ConnectionProvider conn,
      VariablesSecureApp vars) throws Exception {
    try {
      OBContext.setAdminMode(true);

      org.openbravo.model.ad.ui.Process process = OBDal.getInstance().get(
          org.openbravo.model.ad.ui.Process.class, "7FB264CB33524B35BFBCE3B0702EC2BB");

      final ProcessInstance pInstance = CallProcess.getInstance().call(process,
          productionplan.getId(), null);

      if (pInstance.getResult() == 0) {
        // error processing
        OBError myMessage = Utility.getProcessInstanceMessage(conn, vars,
            PInstanceProcessData.select(new DalConnectionProvider(), pInstance.getId()));
        if (isInsufficientStockMessageFromProcess(pInstance, myMessage)) {
        } else {
          String err = myMessage != null ? myMessage.getMessage() : null;
          throw new OBException(err != null ? err : "");
        }
      }
      return pInstance;
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  private static boolean isInsufficientStockMessageFromProcess(ProcessInstance pInstance,
      OBError myMessage) {
    String fromDb = null;
    if (pInstance != null && pInstance.getId() != null) {
      ProcessInstance row = OBDal.getInstance().get(ProcessInstance.class, pInstance.getId());
      if (row != null) {
        fromDb = row.getErrorMsg();
      }
    }
    String fromUi = myMessage != null ? myMessage.getMessage() : null;
    return messageIndicatesInsufficientStock(fromDb) || messageIndicatesInsufficientStock(fromUi);
  }

  private static boolean messageIndicatesInsufficientStock(String text) {
    if (text == null || text.isEmpty()) {
      return false;
    }
    return text.contains(AD_MESSAGE_NOT_ENOUGH_STOCKED)
        || text.contains(AD_MESSAGE_NOT_ENOUGH_STOCKED_WH_RULE);
  }

  private void copyAttributes(ConnectionProvider conn, VariablesSecureApp vars,
      ProductionPlan productionPlan) throws Exception {
    try {
      OBContext.setAdminMode(true);
      String productionid= productionPlan.getId(); 
      //ProductStockCustomData[] julydateXsql = ProductStockCustomData.attributehered(this.connx,productionid);
      ProductStockCustomData[] julydateXsql = ProductStockCustomData.attributehered(this.connx,productionid);
      String julyday = "";
      for (ProductStockCustomData julydateData : julydateXsql) {
          julyday = julydateData.emCsljDatejulian;
        }
      // if phase does not exist do nothing.
      if (productionPlan.getWRPhase() == null
          || productionPlan.getWRPhase().getMASequence() == null) {
        return;
      }

      // loop production lines
      for (OperationProduct opProduct : productionPlan.getWRPhase().getMASequence()
          .getManufacturingOperationProductList()) {
        // only production type + and has attset and has attlist
        if (opProduct.getProductionType() == null || !opProduct.getProductionType().equals("+")
            || opProduct.getManufacturingOperationProductAttributeList().isEmpty()
            || opProduct.getProduct() == null || opProduct.getProduct().getAttributeSet() == null) {
          continue;
        }
        // new Attribute
        AttributeSetInstanceValue attSetInstanceTo = new AttributeSetInstanceValue();
        HashMap<String, String> attValues = new HashMap<String, String>();

        // loop attributes
        for (OperationProductAttribute opProductAtt : opProduct
            .getManufacturingOperationProductAttributeList()) {

          if (opProductAtt.getProductFrom() == null) {
            continue;
          }

          AttributeSetInstance attSetInstanceFrom = null;

          OBCriteria<ProductionLine> productionLineCriteria = OBDal.getInstance().createCriteria(
              ProductionLine.class);
          productionLineCriteria.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONPLAN,
              productionPlan));
          productionLineCriteria.add(Restrictions
              .isNotNull(ProductionLine.PROPERTY_ATTRIBUTESETVALUE));
          productionLineCriteria.createAlias(ProductionLine.PROPERTY_WRPRODUCTPHASE, "wrpp");
          productionLineCriteria.add(Restrictions.eq("wrpp."
              + WorkRequirementProduct.PROPERTY_SEQUENCEPRODUCT, opProductAtt.getProductFrom()));

          List<ProductionLine> plinesToCopyFrom = productionLineCriteria.list();
          if (!plinesToCopyFrom.isEmpty()) {
            AttributeSetInstance oldestAsi = null;
            Integer oldestJd = null;
            for (ProductionLine fromLine : plinesToCopyFrom) {
              AttributeSetInstance asi = fromLine.getAttributeSetValue();
              if (asi == null || "0".equals(asi.getId())) {
                continue;
              }
              //Proceso para obtener el dia juliano de la linea de produccion mas antiguo
              String jdStr = asi.getCsljDatejulian();
              Integer jdVal = null;
              try {
                if (jdStr != null && !jdStr.isEmpty()) {
                  jdVal = Integer.valueOf(jdStr);
                }
              } catch (NumberFormatException nfe) {
                jdVal = null;
              }
              if (oldestAsi == null) {
                oldestAsi = asi;
                oldestJd = jdVal;
              } else if (jdVal != null && (oldestJd == null || jdVal < oldestJd)) {
                oldestAsi = asi;
                oldestJd = jdVal;
              }
            }
            if (oldestAsi != null) {
              attSetInstanceFrom = oldestAsi;
            } else {
              attSetInstanceFrom = plinesToCopyFrom.get(0).getAttributeSetValue();
            }
          }

          // a partir de aquí, TODO lo que se copie (lote, serie, fecha, attrs normales)
          // viene únicamente de attSetInstanceFrom, es decir, del P-
          if (opProductAtt.isSpecialatt()) {
              if (opProductAtt.getSpecialatt().equals(lotSearchKey)) {
                if (attSetInstanceFrom != null && !"0".equals(attSetInstanceFrom.getId())) {
                  if (opProductAtt.isCopySpecialIntoNormal()) {
                    attValues.put(replace(opProductAtt.getAttributeuseto().getAttribute().getName()),
                        attSetInstanceFrom.getLotName());
                  } else {
                    attSetInstanceTo.setLot(attSetInstanceFrom.getLotName());
                  }
                }
              } else if (opProductAtt.getSpecialatt().equals(serialNoSearchKey)) {
                if (attSetInstanceFrom != null && !"0".equals(attSetInstanceFrom.getId())) {
                  if (opProductAtt.isCopySpecialIntoNormal()) {
                    attValues.put(replace(opProductAtt.getAttributeuseto().getAttribute().getName()),
                        attSetInstanceFrom.getSerialNo());
                  } else {
                    attSetInstanceTo.setSerialNumber(attSetInstanceFrom.getSerialNo());
                  }
                }
              } else if (opProductAtt.getSpecialatt().equals(expirationDateSearchKey)) {
                if (attSetInstanceFrom != null && !"0".equals(attSetInstanceFrom.getId())) {
                  attSetInstanceTo.setGuaranteeDate(dateToString(attSetInstanceFrom
                      .getExpirationDate()));
                }
              } else if (opProductAtt.getSpecialatt().equals(julydate)) {
                String valorAFijar = "";
                  if (attSetInstanceFrom != null && !"0".equals(attSetInstanceFrom.getId())) {
                    OBDal.getInstance().getSession().refresh(attSetInstanceFrom);
                    valorAFijar = attSetInstanceFrom.getCsljDatejulian();
                  }
                 if (valorAFijar == null || valorAFijar.isEmpty()) {
                    valorAFijar = julyday != null ? julyday : "";
                  }
                attSetInstanceTo.setJulianDate(valorAFijar);
                attValues.put(replace(opProductAtt.getAttributeuseto().getAttribute().getName()), valorAFijar);
              }
            } else {
              if (attSetInstanceFrom != null && !"0".equals(attSetInstanceFrom.getId())
                  && opProductAtt.getAttributeuseto() != null
                  && opProductAtt.getAttributeuseto().getAttribute() != null) {
                // getValue from
                OBCriteria<AttributeInstance> attributeInstanceCriteria = OBDal.getInstance()
                    .createCriteria(AttributeInstance.class);
                attributeInstanceCriteria.add(Restrictions.eq(
                    AttributeInstance.PROPERTY_ATTRIBUTESETVALUE, attSetInstanceFrom));
                attributeInstanceCriteria.add(Restrictions.eq(AttributeInstance.PROPERTY_ATTRIBUTE,
                    opProductAtt.getAttributeUse().getAttribute()));
                List<AttributeInstance> AttributeInstanceList = attributeInstanceCriteria.list();
                // add value
                if (!AttributeInstanceList.isEmpty()) {
                  if (AttributeInstanceList.get(0).getAttributeValue() == null) {
                    attValues.put(
                        replace(opProductAtt.getAttributeuseto().getAttribute().getName()),
                        AttributeInstanceList.get(0).getSearchKey());
                  } else {
                    attValues.put(
                        replace(opProductAtt.getAttributeuseto().getAttribute().getName()),
                        AttributeInstanceList.get(0).getAttributeValue().getId());
                  }

                }
              }
            }
         // }
        } // end loop attributes

        // update lines

        OBCriteria<ProductionLine> ProductionLineCriteria = OBDal.getInstance().createCriteria(
            ProductionLine.class);
        ProductionLineCriteria.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONPLAN,
            productionPlan));
        ProductionLineCriteria.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONTYPE, "+"));
        ProductionLineCriteria.createAlias(ProductionLine.PROPERTY_WRPRODUCTPHASE, "wrpp");
        ProductionLineCriteria.add(Restrictions.eq("wrpp."
            + WorkRequirementProduct.PROPERTY_SEQUENCEPRODUCT, opProduct));

        List<ProductionLine> plinesToCopyTo = ProductionLineCriteria.list();

        for (ProductionLine pline : plinesToCopyTo) {
          AttributeSet attrSet = pline.getProduct().getAttributeSet();

          // create attribute
          if (attrSet.isExpirationDate()
              && (attSetInstanceTo.getGuaranteeDate() == null || attSetInstanceTo
                  .getGuaranteeDate().equals("")) && attrSet.getGuaranteedDays() != null
              && attrSet.getGuaranteedDays() != 0L) {
            // set guaranteeDate if is not copied
            Date movementdate = ((productionPlan.getProductionplandate() != null) ? productionPlan
                .getProductionplandate() : productionPlan.getProduction().getMovementDate());
            int days = attrSet.getGuaranteedDays().intValue();
            attSetInstanceTo.setGuaranteeDate(dateToString(addDays(movementdate, days)));
          }
          fillMandatoryAttributeDefaults(attrSet, attValues);
          OBError createAttributeInstanceError = attSetInstanceTo.setAttributeInstance(conn, vars,
              opProduct.getProduct().getAttributeSet().getId(), "", "", "Y", opProduct.getProduct()
                  .getId(), attValues);
          if (!createAttributeInstanceError.getType().equals("Success")) {
            throw new OBException(createAttributeInstanceError.getMessage());
          }

          OBDal.getInstance().flush();

          AttributeSetInstance newAttSetinstance = OBDal.getInstance().get(
              AttributeSetInstance.class, attSetInstanceTo.getAttSetInstanceId());

          pline.setAttributeSetValue(newAttSetinstance);
          OBDal.getInstance().save(pline);
        }
        OBDal.getInstance().flush();

      }
  
    } finally {
      OBContext.restorePreviousMode();
    }
  }
 
  // Obtiene los valores por defecto en caso de que la configuración no exista,
  // asegurando el cumplimiento cuando el campo está definido como obligatorio.	
  private void fillMandatoryAttributeDefaults(AttributeSet attrSet, HashMap<String, String> attValues) {
    if (attrSet == null || attValues == null) {
      return;
    }
    List<AttributeUse> useList = attrSet.getAttributeUseList();
    if (useList == null) {
      return;
    }
    for (AttributeUse use : useList) {
      Attribute attr = use.getAttribute();
      if (attr == null || !Boolean.TRUE.equals(attr.isMandatory())) {
        continue;
      }
      String name = attr.getName();
      if (name == null) {
        continue;
      }
      String key = replace(name);
      if (key.isEmpty()) {
        continue;
      }
      String existing = attValues.get(key);
      if (existing != null && !existing.isEmpty()) {
        continue;
      }
      List<AttributeValue> vals = attr.getAttributeValueList();
      if (vals != null && !vals.isEmpty()) {
        AttributeValue first = vals.get(0);
        if (Boolean.TRUE.equals(attr.isList())) {
          attValues.put(key, first.getId());
        } else {
          String sk = first.getSearchKey();
          attValues.put(key, sk != null && !sk.isEmpty() ? sk : first.getId());
        }
      } else {
        String fallback = "";
        String nameUpper = name.toUpperCase();
        if (nameUpper.contains("LOTE") || nameUpper.contains("CONSTANTE")) {
          fallback = "L";
        }
        attValues.put(key, fallback);
      }
    }
  }

  private void createInstanciableAttributes(ConnectionProvider conn, VariablesSecureApp vars,
      ProductionPlan productionPlan) throws Exception {
    try {
    	log4j.info("entra al createInstanciableAttributes");
      OBContext.setAdminMode(true);
      OBCriteria<ProductionLine> ProductionLineCriteria = OBDal.getInstance().createCriteria(
          ProductionLine.class);
      ProductionLineCriteria.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONPLAN,
          productionPlan));
      ProductionLineCriteria.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONTYPE, "+"));
      List<ProductionLine> plines = ProductionLineCriteria.list();
    	log4j.info("antes del for");
      for (ProductionLine line : plines) {
      	log4j.info("line===>"+line);
    	log4j.info("line===>"+plines);
        AttributeSet attSet = line.getProduct().getAttributeSet();
        // check has empty attribute

    	log4j.info("antes del if del for");

    	log4j.info("attSet===>"+attSet);
    	log4j.info("line.getAttributeSetValue()===>"+line.getAttributeSetValue());
        if (attSet != null && line.getAttributeSetValue() == null) {

          // check if has automatic attributes
          if ((attSet.isLot() && attSet.getLotControl() != null)
              || (attSet.isSerialNo() && attSet.getSerialNoControl() != null)
              || (attSet.isExpirationDate() && attSet.getGuaranteedDays() != null && attSet
                  .getGuaranteedDays() != 0L)) {

            AttributeSetInstanceValue attSetInstance = new AttributeSetInstanceValue();
            HashMap<String, String> attValues = new HashMap<String, String>();

            if (attSet.isExpirationDate()) {
              Date movementdate = ((productionPlan.getProductionplandate() != null) ? productionPlan
                  .getProductionplandate() : productionPlan.getProduction().getMovementDate());
              int days = (attSet.getGuaranteedDays() == null ? 0 : attSet.getGuaranteedDays()
                  .intValue());
              attSetInstance.setGuaranteeDate(dateToString(addDays(movementdate, days)));
            }
        	log4j.info("antes del if");

            //seccion para dia juliano
            if (attSet.isCsljJuliandate()) {
                LocalDate today = LocalDate.now();
                int julianDay = today.getDayOfYear();
                int year = today.getYear();
                String julyday = String.format("%02d%03d", year % 100, julianDay);
                attSetInstance.setJulianDate(julyday);
            }

            fillMandatoryAttributeDefaults(attSet, attValues);
            OBError createAttributeInstanceError = attSetInstance.setAttributeInstance(conn, vars,
                attSet.getId(), "", "", "N", line.getProduct().getId(), attValues);
            if (!createAttributeInstanceError.getType().equals("Success"))
              throw new OBException(createAttributeInstanceError.getMessage());

            OBDal.getInstance().flush();

            AttributeSetInstance newAttSetinstance = OBDal.getInstance().get(
                AttributeSetInstance.class, attSetInstance.getAttSetInstanceId());

            line.setAttributeSetValue(newAttSetinstance);
            OBDal.getInstance().save(line);
          }
          OBDal.getInstance().flush();
        }
      }

    } finally {
      OBContext.restorePreviousMode();
    }
  }

  private String replace(String strIni) {
    // delete characters: " ","&",","
    return Replace.replace(Replace.replace(Replace.replace(
        Replace.replace(Replace.replace(Replace.replace(strIni, "#", ""), " ", ""), "&", ""), ",",
        ""), "(", ""), ")", "");
  }

  private String dateToString(Date date) throws Exception {
    if (date == null)
      return "";
    String dateformat = OBPropertiesProvider.getInstance().getOpenbravoProperties()
        .getProperty("dateFormat.java");
    SimpleDateFormat formater = new SimpleDateFormat(dateformat);
    return formater.format(date);
  }

  private Date addDays(Date date, int days) throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, days);
    Date gdate = calendar.getTime();
    return gdate;
  }
}

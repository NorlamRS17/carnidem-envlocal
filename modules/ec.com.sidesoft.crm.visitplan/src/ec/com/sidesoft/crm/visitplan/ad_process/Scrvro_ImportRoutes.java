/*
 ************************************************************************************
 * Copyright (C) 2009-2010 Openbravo S.L.U.
 * Licensed under the Openbravo Commercial License version 1.0
 * You may obtain a copy of the License at http://www.openbravo.com/legal/obcl.html
 * or in the legal folder of this module distribution.
 ************************************************************************************
 */

package ec.com.sidesoft.crm.visitplan.ad_process;

import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.module.idljava.proc.IdlServiceJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ec.com.sidesoft.crm.visitplan.Scrvro_Route;
import ec.com.sidesoft.crm.visitplan.Scrvro_RouteDay;
import ec.com.sidesoft.crm.visitplan.Scrvro_RoutePeriod;
import ec.com.sidesoft.crm.visitplan.Scrvro_RouteWeek;


/**
 * 
 * @author Carlos Chiza
 */
public class Scrvro_ImportRoutes extends IdlServiceJava {

  private static final String DATE_PATTERN = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
  private static final String DATE_PATTERNF = "yyyy-MM-dd";


  public String getEntityName() {
    return "Simple Products";
  }

  public Parameter[] getParameters() {
    return new Parameter[] { new Parameter("Vendedor", Parameter.STRING), // 0
        new Parameter("Fecha Ruta", Parameter.STRING), // 1
        new Parameter("Cliente", Parameter.STRING)   };// 2

  }

  protected Object[] validateProcess(Validator validator, String... values) throws Exception {

    validator.checkString(values[0], 13);
    validator.checkString(values[1], 20);
    validator.checkString(values[2], 13);
    return values;

  }

  public BaseOBObject internalProcess(Object... values) throws Exception {

    return uploadRoutes((String) values[0], (String) values[1], (String) values[2]);
  }

  public BaseOBObject uploadRoutes(final String strVendor, final String strDateRoute,
      final String strClient)
      throws Exception {
	  
	  OBContext.setAdminMode(true);
	  
	  
	  int intYear = extractDateComponents(strDateRoute,"yyyy");
	  int intMonth = extractDateComponents(strDateRoute,"mm");
	  
	  Year yearobj = findDALInstance(false, Year.class, new Value("fiscalYear",String.valueOf(intYear )));
	  Period obdalPeriod = findDALInstance(false, Period.class,
		        new Value(Period.PROPERTY_YEAR, yearobj),
		        new Value(Period.PROPERTY_PERIODNO, Long.parseLong( String.valueOf(intMonth) ))
			  );
	  
	  BusinessPartner obdalVendor = findDALInstance(false, BusinessPartner.class,
		        new Value(BusinessPartner.PROPERTY_TAXID, strVendor) 
			  );
	  
	  BusinessPartner obdalClient = findDALInstance(false, BusinessPartner.class,
		        new Value(BusinessPartner.PROPERTY_TAXID, strClient) 
			  );
	  
	  if (obdalVendor == null || obdalVendor.equals("")) {
	      throw new OBException("No existe el vendor con ruc: " + strVendor + ".");
	  }

	  if (obdalClient == null || obdalClient.equals("")) {
	      throw new OBException("No existe el cliente con ruc: " + strClient + ".");
	  }
  
	  
	  if (obdalPeriod == null || obdalPeriod.equals("")) {
	      throw new OBException("No existe un periodo para esta fecha: " + strDateRoute + ".\nRevise el periodo de la fecha según corresponda.");
	    }

	  
	  Scrvro_RoutePeriod obdalRoutPeriod = findDALInstance(false, Scrvro_RoutePeriod.class,
		        new Value(Scrvro_RoutePeriod.PROPERTY_PERIOD, obdalPeriod) 
			  );
	  if (obdalRoutPeriod == null || obdalRoutPeriod.equals("")) {
	      throw new OBException("La rutas con fecha: " + strDateRoute + " no puede ser ingresada.\nRevise si existe creado una ruta para el periodo de la fecha según corresponda.");
	    }
	 
	  String strLatitudeGPS="ND";
	  try {
		  strLatitudeGPS=obdalClient.getScrvroLatitude().toString();
	  }catch (Exception e) {
		  strLatitudeGPS="ND";
	  }
	  String strLongitudeGPS="ND";
	  try {
		  strLongitudeGPS=obdalClient.getScrvroLongitude().toString();
	  }catch (Exception e) {
		  strLongitudeGPS="ND";
	  }
	  
	  if (strLatitudeGPS.equals("ND") || strLongitudeGPS.equals("ND")) {
	      throw new OBException("Actualice la ubicación GPS de " + strClient);
	  }
	  
	 
	  Date convertedDate = convertStringToDate(strDateRoute.trim());
	  String strURL = "https://www.google.com/maps/@";
	  String strZoom = ",19z";
	  String strURLComplete=  strURL + obdalClient.getScrvroLatitude() + ","+ obdalClient.getScrvroLongitude()+ strZoom;
	  String strLatitude=obdalClient.getScrvroLatitude();
      String strLongitude=obdalClient.getScrvroLongitude();
      
	  boolean blSearchClient=false;
	  
	  
		OBCriteria<Scrvro_Route> obcRoutePeriod = OBDal.getInstance().createCriteria(Scrvro_Route.class);
		//obcRoutePeriod.add(Restrictions.ne(Scrvro_Route.PROPERTY_BUSINESSPARTNER, obdalClient));
		obcRoutePeriod.createAlias( Scrvro_Route.PROPERTY_SCRVROROUTEDAY, "rd");
		obcRoutePeriod.add(Restrictions.eq( "rd." + Scrvro_RouteDay.PROPERTY_DATE, convertedDate));
		obcRoutePeriod.createAlias( "rd." + Scrvro_RouteDay.PROPERTY_SCRVROROUTEWEEK, "rw");
		obcRoutePeriod.add(Restrictions.eq( "rw." + Scrvro_RouteWeek.PROPERTY_BUSINESSAGENT,obdalVendor));
		obcRoutePeriod.createAlias( "rw." +  Scrvro_RouteWeek.PROPERTY_SCRVROROUTEPERIOD, "rp");
		//obcRoutePeriod.add(Restrictions.eq( "rp." + Scrvro_RoutePeriod.PROPERTY_PERIOD,obdalPeriod));

		

		

		
		if (obcRoutePeriod.list().size()==0) {
			blSearchClient=true;
			
			
		}else {
			List<Scrvro_Route> sr2 = obcRoutePeriod.list();
			for(Scrvro_Route ruta: sr2) {
				BusinessPartner bp = ruta.getBusinessPartner(); 
				if(bp.getTaxID().equals(obdalClient.getTaxID())) {
					blSearchClient=false;					
					break;
				}else {
					blSearchClient=true;
				}
			}

		}



	  Scrvro_Route newScrvro_Route = OBProvider.getInstance()
		        .get(Scrvro_Route.class);
	  
		try {
		  // Metodo de pago
		 
		  // ValorDepositado
		 // ObjSccaCardsSettlement.setBondedAmount(Parameter.BIGDECIMAL.parse(changeFormatBigDecimal(ValorDepositado)));
		
			  if (blSearchClient) {
				  
					OBCriteria<Scrvro_RouteDay> obcRouteByDate = OBDal.getInstance().createCriteria(Scrvro_RouteDay.class);
					obcRouteByDate.add(Restrictions.eq(Scrvro_RouteDay.PROPERTY_DATE, convertedDate));
					obcRouteByDate.createAlias(Scrvro_RouteDay.PROPERTY_SCRVROROUTEWEEK, "rw");
					obcRouteByDate.add(Restrictions.eq( "rw." + Scrvro_RouteWeek.PROPERTY_BUSINESSAGENT,obdalVendor));
					obcRouteByDate.createAlias( "rw." +  Scrvro_RouteWeek.PROPERTY_SCRVROROUTEPERIOD, "rp");
					//obcRouteByDate.add(Restrictions.eq( "rp." + Scrvro_RoutePeriod.PROPERTY_PERIOD,obdalPeriod));

					Scrvro_RouteDay obdalRD= obcRouteByDate.list().get(0);
					
					if(obdalRD!= null) {
						OBCriteria<Scrvro_Route> obcRouteMax = OBDal.getInstance().createCriteria(Scrvro_Route.class);
						obcRouteMax.add(Restrictions.eq(Scrvro_Route.PROPERTY_SCRVROROUTEDAY, obdalRD));
						//obcRouteMax.setProjection(Projections.max(Scrvro_Route.PROPERTY_VISITORDER));
						//obcRouteMax.setMaxResults(1);
						obcRouteMax.addOrderBy(Scrvro_Route.PROPERTY_VISITORDER, false);
						
						 
						long SeqVisit =1;
						int intVisitOrder = 0;
						
						List<Scrvro_Route> srl = obcRouteMax.list();

						
						if (srl.size()>0) {
							
							Comparator<Scrvro_Route> visitOrderComparator = new Comparator<Scrvro_Route>() {
							    @Override
							    public int compare(Scrvro_Route r1, Scrvro_Route r2) {
							        return Long.compare(r1.getVisitOrder(), r2.getVisitOrder());
							    }
							};

							Collections.sort(srl, visitOrderComparator);
							
							for(Scrvro_Route rutaCount: srl) {
								SeqVisit=rutaCount.getVisitOrder();
							}
							SeqVisit++;
						}
					
				  newScrvro_Route.setBusinessPartner(obdalClient);
				  
				  newScrvro_Route.setLocationLink(strURLComplete);
				  newScrvro_Route.setLatitude(strLatitude);
				  newScrvro_Route.setLongitude(strLongitude);
				  newScrvro_Route.setScrvroRouteDay(obdalRD);
				  newScrvro_Route.setVisitOrder(SeqVisit);
				  newScrvro_Route.setDebt(new BigDecimal("0"));
				  newScrvro_Route.setDuration(new BigDecimal("0"));
				  newScrvro_Route.setDistance(new BigDecimal("0"));
				  newScrvro_Route.setStatus("P");
			      OBDal.getInstance().save(newScrvro_Route);
			      OBDal.getInstance().flush();
					}
			  }
		
		
		} catch (Exception e) {
		  e.printStackTrace();
		}

    OBDal.getInstance().commitAndClose();
    return newScrvro_Route;
  }

  public String changeFormatBigDecimal(String numbers) {
    String Remplace = "0";

    Remplace = numbers.replace(".", "");
    Remplace = numbers.replace(",", ".");

    return Remplace;
  }
  

  public static boolean isValidDateFormat(String date) {
      Pattern pattern = Pattern.compile(DATE_PATTERN);
      Matcher matcher = pattern.matcher(date);
      return matcher.matches();
  }
  
  public static int extractDateComponents(String dateString, String strData) {
      SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERNF);
      int dataDate =0;
      try {
          Date date = dateFormat.parse(dateString);
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(date);
          
          if (strData.equals("yyyy")) {
        	  dataDate = calendar.get(Calendar.YEAR);
          }
          if (strData.equals("mm")) {
        	  dataDate= calendar.get(Calendar.MONTH) + 1;
          }
          if (strData.equals("dd")) {
        	  dataDate = calendar.get(Calendar.DAY_OF_MONTH);
          }
          
          
      } catch (ParseException e) {
          System.out.println("Invalid date format: " + dateString);
          dataDate=0;
      }
      return dataDate;
  }
  
  public static Date convertStringToDate(String dateString) {
      SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERNF);
      try {
          return dateFormat.parse(dateString);
      } catch (ParseException e) {
          System.out.println("Invalid date format: " + dateString);
          return null;
      }
  }
  

}

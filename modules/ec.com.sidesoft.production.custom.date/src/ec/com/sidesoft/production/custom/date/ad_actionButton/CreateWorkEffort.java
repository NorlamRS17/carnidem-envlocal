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
 * All portions are Copyright (C) 2011-2018 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.production.custom.date.ad_actionButton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.manufacturing.cost.CostcenterVersion;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.manufacturing.transaction.WorkRequirementOperation;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.scheduling.ProcessBundle;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CreateWorkEffort implements org.openbravo.scheduling.Process {

  private static final Logger log4j = Logger.getLogger(CreateWorkEffort.class);

  @Override
  public void execute(ProcessBundle bundle) throws Exception {

    final String strWorkRequirement = (String) bundle.getParams().get("MA_Workrequirement_ID");
    final String strdate = (String) bundle.getParams().get("date");
    String strStartTime = (String) bundle.getParams().get("starttime");
    String strEndTime = (String) bundle.getParams().get("endtime");
    final ConnectionProvider conn = bundle.getConnection();
    final VariablesSecureApp vars = bundle.getContext().toVars();

    try {

      // ConvertVariables
      String dateFormat = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("dateFormat.java");

      SimpleDateFormat dateformater = new SimpleDateFormat(dateFormat);
      SimpleDateFormat dateTimeformater = new SimpleDateFormat("yyyy-MM-dd");

      Date date = dateformater.parse(strdate);
      String dateformatTime = dateTimeformater.format(date);
      if (strStartTime == null || strStartTime.equals("")) {
        strStartTime = "00:00:00";
      }
      if (strEndTime == null || strEndTime.equals("")) {
        strEndTime = "00:00:00";
      }
      
      /*
       * NUEVO CAMBIO
       * */
      
      //java.util.Date now = dateTimeformater.parse(dateformatTime);

//	  Object[] objDate = diffHours(strStartTime,strEndTime );
      Object[] objDate = objNewTime(strStartTime,strEndTime );
	  
	  if (objDate!=null) {
		   String strFlag= objDate[0].toString();
		   if (strFlag.equals("TRUE")) {
			   Date newDateprocess = addDaysinDate(date,Integer.parseInt(objDate[5].toString()) ,Integer.parseInt(objDate[3].toString()), Integer.parseInt(objDate[4].toString()));
			   //String[] strDatesProcess = newDates(newDateprocess,dateFormat, objDate[2].toString(),objDate[1].toString() );
		       //System.out.println ("Fecha Inicio: " + strDatesProcess[0]  );
		       //System.out.println ("Fecha Fin: " + strDatesProcess[1]  );
		       dateformatTime = dateTimeformater.format(newDateprocess);
		       date = newDateprocess;
		       strStartTime = String.valueOf(objDate[2].toString());
		       strEndTime =  String.valueOf(objDate[1].toString());
		   }
	  }
      
      
      
      Timestamp starttime = Timestamp.valueOf(dateformatTime + " " + strStartTime + ".0");
      Timestamp endtime = Timestamp.valueOf(dateformatTime + " " + strEndTime + ".0");

      // Search Phases To Be Created
      WorkRequirement workReq = OBDal.getInstance().get(WorkRequirement.class, strWorkRequirement);

      OBCriteria<WorkRequirementOperation> workReqOpCriteria = OBDal.getInstance().createCriteria(
          WorkRequirementOperation.class);
      workReqOpCriteria.add(Restrictions.eq(WorkRequirementOperation.PROPERTY_WORKREQUIREMENT,
          workReq));
      workReqOpCriteria.add(Restrictions.le(WorkRequirementOperation.PROPERTY_STARTINGDATE, date));
      workReqOpCriteria.add(Restrictions.eq(WorkRequirementOperation.PROPERTY_CLOSED, false));
      workReqOpCriteria.addOrderBy(WorkRequirementOperation.PROPERTY_SEQUENCENUMBER, true);

      List<WorkRequirementOperation> workReqOpList = workReqOpCriteria.list();

      int counter = 0;
      for (WorkRequirementOperation wrOp : workReqOpList) {
        // Check if exits one not processed;

        OBCriteria<ProductionPlan> productionPlanCriteria = OBDal.getInstance().createCriteria(
            ProductionPlan.class);
        productionPlanCriteria.add(Restrictions.eq(ProductionPlan.PROPERTY_WRPHASE, wrOp));
        productionPlanCriteria.createAlias(ProductionPlan.PROPERTY_PRODUCTION, "pro");
        productionPlanCriteria.add(Restrictions.eq("pro."
            + ProductionTransaction.PROPERTY_MOVEMENTDATE, date));
        productionPlanCriteria.add(Restrictions.eq("pro."
            + ProductionTransaction.PROPERTY_PROCESSED, false));
        List<ProductionPlan> pplanList = productionPlanCriteria.list();

        if (pplanList.isEmpty()) {
          counter++;
          // Create ProductionTransaction
          ProductionTransaction productionTransaction = OBProvider.getInstance().get(
              ProductionTransaction.class);
          productionTransaction.setClient(wrOp.getClient());
          productionTransaction.setOrganization(wrOp.getOrganization());
          productionTransaction.setMovementDate(date);
          productionTransaction.setStartingTime(starttime);
          productionTransaction.setEndingTime(endtime);
          String documentNo = Utility.getDocumentNo(conn, wrOp.getClient().getId(), "M_Production",
              true);
          productionTransaction.setDocumentNo(documentNo);

          OBDal.getInstance().save(productionTransaction);
          OBDal.getInstance().flush();

          // Crete ProductionPlan
          ProductionPlan productionPlan = OBProvider.getInstance().get(ProductionPlan.class);
          productionPlan.setProduction(productionTransaction);
          productionPlan.setOrganization(productionTransaction.getOrganization());
          productionPlan.setClient(productionTransaction.getClient());
          // Only one line per ProductionTransaction
          productionPlan.setLineNo(10L);
          productionPlan.setWRPhase(wrOp);
          productionPlan.setProductionplandate(date);

          productionPlan.setRunTime(0L);
          productionPlan.setClosephase(false);
          BigDecimal requiredQty = wrOp.getQuantity().subtract(wrOp.getCompletedQuantity());

          if (wrOp.isCreateStandards()) {
            productionPlan.setProductionQuantity(requiredQty);
            BigDecimal estimatedTime = BigDecimal.ZERO;
            if (wrOp.getEstimatedTime() != null && wrOp.getQuantity() != null
                && wrOp.getQuantity().compareTo(BigDecimal.ZERO) != 0) {
              estimatedTime = wrOp.getEstimatedTime().multiply(requiredQty)
                  .divide(wrOp.getQuantity(), RoundingMode.HALF_UP);
            }
            productionPlan.setEstimatedTime(new BigDecimal(estimatedTime.longValue()));
          } else {
            productionPlan.setProductionQuantity(BigDecimal.ZERO);
            productionPlan.setEstimatedTime(BigDecimal.ZERO);
          }

          productionPlan.setRejectedQuantity(BigDecimal.ZERO);
          productionPlan.setCostCenterUse(BigDecimal.ZERO);

          productionPlan.setStartingTime(starttime);
          productionPlan.setEndingTime(endtime);

          productionPlan.setRequiredQuantity(requiredQty);
          productionPlan.setProcessUnit(wrOp.getWorkRequirement().getProcessUnit());
          if (wrOp.getWorkRequirement().getConversionRate() != null
              && wrOp.getWorkRequirement().getConversionRate().compareTo(BigDecimal.ZERO) != 0) {
            productionPlan.setConversionRate(wrOp.getWorkRequirement().getConversionRate());
          }
          if (wrOp.getWorkRequirement().getSsprodpStop() != null) {
            productionPlan.setSsprodpStop(wrOp.getWorkRequirement().getSsprodpStop());
          }


          // Get CostCenterVersion
          OBCriteria<CostcenterVersion> costcenterVersionCriteria = OBDal.getInstance()
              .createCriteria(CostcenterVersion.class);
          costcenterVersionCriteria.add(Restrictions.eq(CostcenterVersion.PROPERTY_COSTCENTER, wrOp
              .getActivity().getCostCenter()));
          costcenterVersionCriteria.add(Restrictions.lt(CostcenterVersion.PROPERTY_VALIDFROMDATE,
              date));
          costcenterVersionCriteria.addOrderBy(CostcenterVersion.PROPERTY_VALIDFROMDATE, false);
          List<CostcenterVersion> costcenterVersionList = costcenterVersionCriteria.list();
          if (!costcenterVersionList.isEmpty()) {
            productionPlan.setCostCenterVersion(costcenterVersionList.get(0));
          }

          productionPlan.setOutsourced((wrOp.isOutsourced() == null) ? false : wrOp.isOutsourced());

          OBDal.getInstance().save(productionPlan);
          OBDal.getInstance().flush();

          if (wrOp.isCreateStandards()) {
            String strProcessId = "FF80818132A4F6AD0132A573DD7A0021";
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("M_ProductionPlan_ID", productionPlan.getId());
            ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(conn);
            pb.setParams(params);
            new org.openbravo.erpCommon.ad_actionButton.CreateStandards().execute(pb);
            OBError pbResult = (OBError) pb.getResult();
            if (!pbResult.getType().equals("Success")) {
              throw new OBException(pbResult.getMessage());
            }
          }

        }

      }

      final OBError msg = new OBError();

      msg.setType("Success");
      msg.setTitle(Utility.messageBD(conn, "Success", bundle.getContext().getLanguage()));
      msg.setMessage(counter + " "
          + Utility.messageBD(conn, "WorkEffortCreated", bundle.getContext().getLanguage())
          + strdate);
      bundle.setResult(msg);
    } catch (final Exception e) {
      OBDal.getInstance().rollbackAndClose();
      log4j.error("Error creating work effort", e);
      final OBError msg = new OBError();
      msg.setType("Error");
      if (e instanceof org.hibernate.exception.GenericJDBCException) {
        msg.setMessage(((org.hibernate.exception.GenericJDBCException) e).getSQLException()
            .getNextException().getMessage());
      } else if (e instanceof org.hibernate.exception.ConstraintViolationException) {
        msg.setMessage(((org.hibernate.exception.ConstraintViolationException) e).getSQLException()
            .getNextException().getMessage());
      } else {
        msg.setMessage(e.getMessage());
      }
      msg.setTitle(Utility.messageBD(conn, "Error", bundle.getContext().getLanguage()));
      bundle.setResult(msg);
    }
  }

	static Object[] diffHours(String startTime, String endTime) {
		Object[] objTime = new Object[6];
		
		Object[] objStartTime = startTime.split(":");
		Object[] objEndtTime = endTime.split(":");
		
		int hour = Integer.parseInt(String.valueOf(objStartTime[0]));
		int minute = Integer.parseInt(String.valueOf(objStartTime[1]));
		
		int hourCompare =  Integer.parseInt(String.valueOf(objEndtTime[0]));
		int minuteCompare =  Integer.parseInt(String.valueOf(objEndtTime[1]));
		
		int AcumMinute =0;
		int AcumHour =0;
		int AcumHour2=0; 
		int CountHour=0;
		
		int AuxHour=0;
		
		boolean blEndTime = true;
		boolean blTime = false;
		boolean blFirstHour= false;
		boolean blAddDays = false;
		
		AcumHour= hour;
		AcumMinute = minute;
		
		int AuxMinute = 0;
		while (blEndTime) {
			
			if (AcumMinute>=0 && AcumMinute<60) {
				if  (AcumMinute==59) {
					AcumMinute=0;
					AcumHour++;
					AuxHour++;
					CountHour++;
				}else {
					AcumMinute++;
					
					if (AcumMinute==59 && !blFirstHour) {
						
						blFirstHour= true;
						AuxMinute= ((minute+1)-60);
						if (AuxMinute==0) {
							AuxMinute= (((minute)-60)*-1);

						}else {
							AuxMinute= (60 - minute)+1;
						}
					}
				}
			}
			
			if (AcumHour==24) {
				AcumHour2=CountHour;
				AcumHour=0;
				blTime=true;
			}
			if (blTime) {
				if (AcumHour==hourCompare &&  AcumMinute==minuteCompare) {
					blEndTime=false;
				}
			}
			
		    //System.out.println ( "AcumHour: "+ AcumHour );

			
			if (AcumHour==hourCompare && AcumHour<24 &&  !blTime ) {
				blEndTime=false;
				AcumHour2=AuxHour;
				AuxMinute=minuteCompare;
			}
		  
		}
  
	    if (!blEndTime) {
	    	
	    	//System.out.println ( "Horas acumuladas: "+ AuxHour + ":" + AcumMinute);
	    	
	    	if(blTime) {
	    		
	    		//Date dtNewDate = addDaysinDate(Date now, 1);
	    		AcumMinute=(AcumMinute + AuxMinute)+1;

	    		if (AcumMinute==60) {
	    			AcumMinute=0;
	    			AcumHour++;
	    			AuxHour++;
	    		}

	    		if (AuxHour>=24) {
	    			
	    			if (AuxHour>24) {
	    				AuxHour= 24 - AuxHour;
	    			}else {
	    				if (AuxHour==24) {
	    					AuxHour=0;
	    				}
	    				
	    			}
	    	  //  	System.out.println ( "Horas RESTADA: "+ AuxHour + ":" + AcumMinute);
	    			if (AuxHour>0) {
	    				blAddDays=true;
	    			}
		    		if (AuxMinute>=60) {
		    			AuxMinute= 59;
		    		}
	    			

	    		}
    		
	    		String NewHour= AcumHour>=0 && AcumHour<=9 ? "0"+ String.valueOf(AcumHour==0? "0": AcumHour ):String.valueOf(AcumHour);
	    		String NewMinute= AuxMinute>0 && AuxMinute<=9 ? "0"+ String.valueOf(AuxMinute):String.valueOf(AuxMinute);
	    		String NewTime = NewHour + ":" + NewMinute +":00";
	    		
	    		if (AcumHour>AcumHour2) {
	
		    		NewHour= AuxHour>=0 && AuxHour<=9 ? "0"+ String.valueOf(AuxHour):String.valueOf(AuxHour);
		    		NewTime = NewHour + ":" + NewMinute +":00";
			    	//	System.out.println ( "Horas RESTADA 2: "+ NewTime);
			    		
			    	 //   System.out.println ( "Hora: "+ AcumHour + ":" + AcumMinute);


	    		}
	    		/*
	    		 * GRUPO TIEMPO
	    		 * */
	    		String NewTimeFirst ="";
	    		int diffHour=0;
	    		if (AcumHour2>AcumHour) {
	    			
	    					if((hour-AcumHour)==0) {
	    						NewHour="23";
	    						if(minute==0) {
	    							NewMinute="59";
	    						}
	    						
	    					}else {
		    					NewHour= (hour-AcumHour)>=0 && (hour-AcumHour)<=9 ? "0"+ String.valueOf((hour-AcumHour)):String.valueOf((hour-AcumHour));
		    					NewMinute= (minute>=0 && minute<=9 ? "0"+String.valueOf(minute): String.valueOf(minute) );
		    					if(minute==0) {
	    							NewMinute="59";
	    						}
	    					}
	    			
	  			    		NewTime = NewHour  + ":" +  NewMinute +":00";
	  			    		
	  			    		if((hourCompare-AcumHour)==0) {
	    						NewHour="23";
	    						if(minuteCompare==0) {
	    							NewMinute="59";
	    						}
	    						
	    					}else {
		    					NewHour= (hourCompare-AcumHour)>=0 && (hourCompare-AcumHour)<=9 ? "0"+ String.valueOf((hourCompare-AcumHour)):String.valueOf((hourCompare-AcumHour));
		    					NewMinute= (minuteCompare>=0 && minuteCompare<=9 ? "0"+String.valueOf(minuteCompare): String.valueOf(minuteCompare) );
		    					if(minute==0) {
	    							NewMinute="59";
	    						}
	    					}
	  			    		
	  			    		
	  			    		NewTimeFirst =  NewHour + ":" + NewMinute +":00";
	  			    		blAddDays=false;
	  			    		
				    	  //  System.out.println ( "Hora 1.1: "+ NewTimeFirst);
				    	  //  System.out.println ( "Hora 2.1: "+ NewTime);

	    		}else {
	    			if (AcumHour>AcumHour2) {
	    				if ((AuxMinute+1)==60) {
	    					AuxMinute=59;
	    					if((AuxHour+1)==24) {
	    						AuxHour=23;
	    					}
	    					
	    				}
	    				
	    				blAddDays=true;
	    				AuxHour=AuxHour-1;
			    		NewHour= AuxHour>=0 && AuxHour<=9 ? "0"+ String.valueOf(AuxHour):String.valueOf(AuxHour);
			    		NewMinute= (AuxMinute>=0 && AuxMinute<=9 ? "0"+String.valueOf(AuxMinute): String.valueOf(AuxMinute) );
  			    		NewTime = (NewHour) + ":" + AuxMinute +":00";
  			    		NewTimeFirst = "00:01:00";
  			    		
  			    	  //  System.out.println ( "Hora 1.2: "+ NewTimeFirst);
			    	   // System.out.println ( "Hora 2.2: "+ NewTime);

  					
	    			}
	    		}
	    		
	    		
	    		
	    		objTime[0] = "TRUE";
	    		objTime[1] = NewTime ;
	    		objTime[2] = NewTimeFirst ;
	    		objTime[3] = String.valueOf(AcumHour) ;
	    		objTime[4] = String.valueOf(AuxMinute) ;
	    		if (blAddDays) {
	    			objTime[5] = "1";
	    		}else {
	    			objTime[5] = "0";
		    		objTime[1] = NewTimeFirst ;
		    		objTime[2] = NewTime ;
	    		}
	    		
	    	}else {
	    		objTime=null;
	    	} 
	    }else {
    		objTime=null;
    	}

		
		return  objTime ;
	}
	public static Date addDaysinDate(Date fecha, int dias,int hours, int minute){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      calendar.set(Calendar.HOUR,   hours);
	      calendar.set(Calendar.MINUTE, minute);
		
	      return calendar.getTime(); 
	}
	
	public static String[] newDates(Date date, String dateFormat, String TimeStart, String TimeEnd){
			String[] strDates = new String[2];   
			SimpleDateFormat dateformater = new SimpleDateFormat(dateFormat);
		    SimpleDateFormat dateTimeformater = new SimpleDateFormat("yyyy-MM-dd");
		    String dateformatTimeStart = dateTimeformater.format(date);
		    String strNewStartDateTime  = dateformatTimeStart + " " + TimeStart+ ".0";
		    String strNewEndDateTime  = dateformatTimeStart + " " + TimeEnd+ ".0";
		    strDates[0]= strNewStartDateTime;
		    strDates[1]= strNewEndDateTime;
	      return strDates; 
	}

	public static Object[] objNewTime(String startTime, String endTime) {
		
		Object[] objResult = new Object[6];
		Object[] objStartTime = startTime.split(":");
		Object[] objEndtTime = endTime.split(":");
		
		double   dblHourStart = Integer.parseInt(String.valueOf(objStartTime[0]));
		double   dblMinuteStart = Integer.parseInt(String.valueOf(objStartTime[1]));
		
		double   dblHourEnd = Integer.parseInt(String.valueOf(objEndtTime[0]));
		double   dblMinuteEnd = Integer.parseInt(String.valueOf(objEndtTime[1]));


		
		double dblMinuteStart60= 60-dblMinuteStart;
		double dblMinuteEnd60= 60-dblMinuteEnd;
		// Si los minutos inicio son menores a los minutos finales, se suma 60
		if (dblMinuteStart60<dblMinuteEnd60) {
			
			dblMinuteStart60= dblMinuteStart60+60;
			
		}
		

		// hourtmp1 se resta 1 hora,
		//si el cálculo del minuto dblMinuteStart60 sigue siendo menor al minuto final(dblMinuteEnd)

		double hourtmp1 = ((60-dblMinuteStart)<(60-dblMinuteEnd))? (dblHourEnd-1):dblHourEnd;
		
		//si hora inicial es mayor a la horatmp1 se añade 24 
		double hourtmp2 = (dblHourStart>hourtmp1)? (hourtmp1+24): hourtmp1;
		
		
		// Resta de la hora inicial menos la hourtmp2
		double hourtmp3 = dblHourStart- hourtmp2;
		
		double   dblNewHour= hourtmp3<0?hourtmp3*-1:hourtmp3;
		
		// se obtiene los minutos finales
		double  dblNewMinuteStart= dblMinuteStart60-dblMinuteEnd60;
		
	

		// Salvamos la hora y minutos del calculo entre las 2 horas restadas
		double dblHourtmp = dblNewHour;
		double dblMinutetmp = dblNewMinuteStart;
		

		// Se identica en que día/hora se encuentra el mayor número de horas
		// dblTime24Start = 21:55:00 -> 24 tiene 2:05:00
		// dblTime24End = 01:05:00 -> de 00:00(24)  a 1:05 es solo 1 hora,
		// en el ejemplo se deduce que en la hora inicio(dblTime24Start) tiene más horas,
		// por lo tanto la fecha fin sera: 00:01:00
		
		double dblTime24Start = (dblHourStart>0 & dblHourStart> dblHourEnd)? 24-dblHourStart:dblHourStart -dblHourEnd ;
		double dblTime24End = (dblHourEnd<dblHourStart & dblHourEnd>0)?dblHourEnd: 24 - dblHourEnd;
		
		
		double dblhour_s=0;
		double dblhour_e=0;
		boolean flag =false;
		boolean flagobj =false;
		
		//si hora final es menor a la hora inicio
		
		if(dblHourEnd<dblHourStart) {
			
			flagobj=true;
			// Dependiendo el número de horas se asignara la hora inicio y fin respectivamente
			if (dblTime24Start>dblTime24End) {
				
				dblhour_s=23;
				dblhour_e=59;
				flag=true;		
			}else {
				dblhour_s=00;
				dblhour_e=01;
			}
		}
		
		if (!flagobj) {
			return null;
		}
		String strNewHourStart="";
		String strNewHourEnd="";
		
		if (flag) {
			dblNewHour=dblhour_s- dblNewHour;
			dblNewMinuteStart = dblhour_e-dblNewMinuteStart;
			
			int inthour = (int)dblNewHour;
			int intminute = (int)dblNewMinuteStart;
			
			
			strNewHourStart= ((dblNewHour>0 & dblNewHour<9)? "0"+String.valueOf(inthour):String.valueOf(inthour))
					+ ((dblNewMinuteStart>0 & dblNewMinuteStart<9)? ":0"+String.valueOf(intminute):":"+String.valueOf(intminute ))
					+":00"; 
			strNewHourEnd="23:59:00";
			
			objResult[1] = strNewHourEnd;
			objResult[2] =  strNewHourStart ;
			objResult[5] = "0";
		}else {
			
			dblNewHour=dblhour_s+ dblNewHour;
			dblNewMinuteStart = dblhour_e+dblNewMinuteStart;
			if (dblNewMinuteStart==60) {
				dblNewHour++;
				dblNewMinuteStart=0;
			}
			
			int inthour = (int)dblNewHour;
			int intminute = (int)dblNewMinuteStart;
			
			strNewHourEnd = ((dblNewHour>0 & dblNewHour<9)? "0"+String.valueOf(inthour):String.valueOf(inthour))
					+ ((dblNewMinuteStart>0 & dblNewMinuteStart<9)? ":0"+String.valueOf(intminute):":"+String.valueOf(intminute))
					+":00"; 
			strNewHourStart="00:01:00";
			
			
			objResult[1] = strNewHourEnd ;
			objResult[2] = strNewHourStart ;
			objResult[5] = "1";
		}
		
		objResult[0] = "TRUE";
		objResult[3] = String.valueOf((int)dblHourtmp) ;
		objResult[4] = String.valueOf((int)dblMinutetmp) ;

		//System.out.println("Hora Inicio: " + strNewHourStart);
		//System.out.println("Hora Fin: " + strNewHourEnd);

		return  objResult;
		
		
	}
	
	
}

//Sqlc generated V1.O00-1
package ec.com.sidesoft.dinardap.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchDinardapData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchDinardapData.class);
  private String InitRecordNumber="0";
  public String rucorg;
  public String codigoentidad;
  public String tipoidentificacion;
  public String identificacionsujeto;
  public String nombresujeto;
  public String clasesujeto;
  public String provincia;
  public String canton;
  public String parroquia;
  public String sexo;
  public String estadocivil;
  public String origeningresos;
  public String numerooperacion;
  public String valoroperacion;
  public String saldooperacion;
  public String fechaconcesion;
  public String fechavencimiento;
  public String fechaexigible;
  public String plazooperacion;
  public String periodicidadpagos;
  public String diasmorosidad;
  public String montomorosidad;
  public String montointeresenmora;
  public String valorxvencer1a30;
  public String valorxvencer31a90;
  public String valorxvencer91a180;
  public String valorxvencer181a360;
  public String valorxvencermas360;
  public String valorvencido1a30;
  public String valorvencido31a90;
  public String valorvencido91a180;
  public String valorvencido181a360;
  public String valorvencidomas360;
  public String valorendemandajudicial;
  public String carteracastigada;
  public String cuotacredito;
  public String fechacancelacion;
  public String formacancelacion;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("rucorg"))
      return rucorg;
    else if (fieldName.equalsIgnoreCase("codigoentidad"))
      return codigoentidad;
    else if (fieldName.equalsIgnoreCase("tipoidentificacion"))
      return tipoidentificacion;
    else if (fieldName.equalsIgnoreCase("identificacionsujeto"))
      return identificacionsujeto;
    else if (fieldName.equalsIgnoreCase("nombresujeto"))
      return nombresujeto;
    else if (fieldName.equalsIgnoreCase("clasesujeto"))
      return clasesujeto;
    else if (fieldName.equalsIgnoreCase("provincia"))
      return provincia;
    else if (fieldName.equalsIgnoreCase("canton"))
      return canton;
    else if (fieldName.equalsIgnoreCase("parroquia"))
      return parroquia;
    else if (fieldName.equalsIgnoreCase("sexo"))
      return sexo;
    else if (fieldName.equalsIgnoreCase("estadocivil"))
      return estadocivil;
    else if (fieldName.equalsIgnoreCase("origeningresos"))
      return origeningresos;
    else if (fieldName.equalsIgnoreCase("numerooperacion"))
      return numerooperacion;
    else if (fieldName.equalsIgnoreCase("valoroperacion"))
      return valoroperacion;
    else if (fieldName.equalsIgnoreCase("saldooperacion"))
      return saldooperacion;
    else if (fieldName.equalsIgnoreCase("fechaconcesion"))
      return fechaconcesion;
    else if (fieldName.equalsIgnoreCase("fechavencimiento"))
      return fechavencimiento;
    else if (fieldName.equalsIgnoreCase("fechaexigible"))
      return fechaexigible;
    else if (fieldName.equalsIgnoreCase("plazooperacion"))
      return plazooperacion;
    else if (fieldName.equalsIgnoreCase("periodicidadpagos"))
      return periodicidadpagos;
    else if (fieldName.equalsIgnoreCase("diasmorosidad"))
      return diasmorosidad;
    else if (fieldName.equalsIgnoreCase("montomorosidad"))
      return montomorosidad;
    else if (fieldName.equalsIgnoreCase("montointeresenmora"))
      return montointeresenmora;
    else if (fieldName.equalsIgnoreCase("valorxvencer1a30"))
      return valorxvencer1a30;
    else if (fieldName.equalsIgnoreCase("valorxvencer31a90"))
      return valorxvencer31a90;
    else if (fieldName.equalsIgnoreCase("valorxvencer91a180"))
      return valorxvencer91a180;
    else if (fieldName.equalsIgnoreCase("valorxvencer181a360"))
      return valorxvencer181a360;
    else if (fieldName.equalsIgnoreCase("valorxvencermas360"))
      return valorxvencermas360;
    else if (fieldName.equalsIgnoreCase("valorvencido1a30"))
      return valorvencido1a30;
    else if (fieldName.equalsIgnoreCase("valorvencido31a90"))
      return valorvencido31a90;
    else if (fieldName.equalsIgnoreCase("valorvencido91a180"))
      return valorvencido91a180;
    else if (fieldName.equalsIgnoreCase("valorvencido181a360"))
      return valorvencido181a360;
    else if (fieldName.equalsIgnoreCase("valorvencidomas360"))
      return valorvencidomas360;
    else if (fieldName.equalsIgnoreCase("valorendemandajudicial"))
      return valorendemandajudicial;
    else if (fieldName.equalsIgnoreCase("carteracastigada"))
      return carteracastigada;
    else if (fieldName.equalsIgnoreCase("cuotacredito"))
      return cuotacredito;
    else if (fieldName.equalsIgnoreCase("fechacancelacion"))
      return fechacancelacion;
    else if (fieldName.equalsIgnoreCase("formacancelacion"))
      return formacancelacion;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchDinardapData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID1, String C_YEAR_ID2, String C_YEAR_ID3, String C_YEAR_ID4, String C_YEAR_ID5, String C_YEAR_ID6, String C_YEAR_ID7, String C_YEAR_ID8, String C_YEAR_ID9, String C_YEAR_ID10, String C_YEAR_ID11, String C_YEAR_ID12, String C_YEAR_ID13, String C_YEAR_ID14, String C_YEAR_ID15, String C_YEAR_ID16, String C_YEAR_ID17, String C_YEAR_ID18, String C_YEAR_ID19, String C_YEAR_ID20, String C_YEAR_ID21, String C_YEAR_ID22, String startdate, String startdate2, String C_YEAR_ID)    throws ServletException {
    return select(connectionProvider, C_YEAR_ID1, C_YEAR_ID2, C_YEAR_ID3, C_YEAR_ID4, C_YEAR_ID5, C_YEAR_ID6, C_YEAR_ID7, C_YEAR_ID8, C_YEAR_ID9, C_YEAR_ID10, C_YEAR_ID11, C_YEAR_ID12, C_YEAR_ID13, C_YEAR_ID14, C_YEAR_ID15, C_YEAR_ID16, C_YEAR_ID17, C_YEAR_ID18, C_YEAR_ID19, C_YEAR_ID20, C_YEAR_ID21, C_YEAR_ID22, startdate, startdate2, C_YEAR_ID, 0, 0);
  }

  public static ArchDinardapData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID1, String C_YEAR_ID2, String C_YEAR_ID3, String C_YEAR_ID4, String C_YEAR_ID5, String C_YEAR_ID6, String C_YEAR_ID7, String C_YEAR_ID8, String C_YEAR_ID9, String C_YEAR_ID10, String C_YEAR_ID11, String C_YEAR_ID12, String C_YEAR_ID13, String C_YEAR_ID14, String C_YEAR_ID15, String C_YEAR_ID16, String C_YEAR_ID17, String C_YEAR_ID18, String C_YEAR_ID19, String C_YEAR_ID20, String C_YEAR_ID21, String C_YEAR_ID22, String startdate, String startdate2, String C_YEAR_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select" +
      "	* " +
      "	from(" +
      "	  SELECT AI.TAXID AS RUCORG, AO.EM_SDIN_DINARDAP_ID AS CODIGOENTIDAD, " +
      "     CASE WHEN  (UPPER(CB.EM_SSWH_TAXIDTYPE)='P') THEN" +
      "        'E'" +
      "     WHEN (UPPER(CB.EM_SSWH_TAXIDTYPE)='D') THEN" +
      "        'C'" +
      "     ELSE" +
      "        UPPER(CB.EM_SSWH_TAXIDTYPE)" +
      "     END AS TIPOIDENTIFICACION," +
      "     CB.TAXID AS IDENTIFICACIONSUJETO , CB.NAME AS NOMBRESUJETO, " +
      "    COALESCE(CB.EM_SDIN_SUBJET_CLASS,'N') AS CLASESUJETO, COALESCE(CR.VALUE,'17') AS PROVINCIA,COALESCE(SUBSTR(SC.IDENTIFICADOR,LENGTH(SC.IDENTIFICADOR)-1,LENGTH(SC.IDENTIFICADOR)),'01') AS CANTON," +
      "     COALESCE(SUBSTR(SP.IDENTIFICADOR,LENGTH(SP.IDENTIFICADOR)-1,LENGTH(SP.IDENTIFICADOR)),'55') AS PARROQUIA, " +
      "    CASE WHEN (COALESCE(CB.EM_SDIN_SUBJET_CLASS,'N') ='N') THEN " +
      "    COALESCE(CB.EM_SBPC_GENDER,'M') " +
      "    ELSE " +
      "    '' " +
      "    END AS SEXO, " +
      "    CASE WHEN (COALESCE(CB.EM_SDIN_SUBJET_CLASS,'N')='N') THEN " +
      "        COALESCE(CB.EM_SBPC_CIVIL_STATUS,'S') " +
      "    ELSE " +
      "    '' " +
      "    END AS ESTADOCIVIL, " +
      "    CASE WHEN (COALESCE(CB.EM_SDIN_SUBJET_CLASS,'N')='N') THEN " +
      "        COALESCE(CB.EM_SDIN_SOURCE_OF_INCOME,'V') " +
      "    ELSE " +
      "    '' " +
      "    END AS ORIGENINGRESOS, INVOICE AS NUMEROOPERACION," +
      "     COALESCE(ABS(ROUND(AVG(I.GRANDTOTAL), 2)),0) AS VALOROPERACION,  " +
      "    COALESCE(ABS(ROUND(SUM(V.GRANDTOTAL), 2)),0) AS SALDOOPERACION," +
      "     TO_CHAR(I.DATEINVOICED,'dd/MM/yyyy') AS FECHACONCESION," +
      "     TO_CHAR(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)),'dd/MM/yyyy') AS FECHAVENCIMIENTO," +
      "      TO_CHAR(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)),'dd/MM/yyyy') AS FECHAEXIGIBLE, " +
      "     ( case when upper(pt.name) like '%MES%' then 30 else  to_number(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-I.DATEINVOICED)  " +
      "	 end) AS PLAZOOPERACION," +
      "   case when ( case when upper(pt.name) like '%MES%' then 30 else PT.NETDAYS end) >30 then 30 else " +
      "	( case when upper(pt.name) like '%MES%' then 30 else PT.NETDAYS end) end " +
      "   AS PERIODICIDADPAGOS, " +
      "    CASE   " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) > 0 THEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))))" +
      "        ELSE 0" +
      "    END AS DIASMOROSIDAD, " +
      "    COALESCE(" +
      "    CASE   " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) > 0 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS MONTOMOROSIDAD," +
      "    COALESCE(ABS(ROUND(0, 2)),0)  AS MONTOINTERESENMORA,  " +
      "    COALESCE(CASE    " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) >= 0 AND FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) <= 30 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORXVENCER1A30,  " +
      "    COALESCE(CASE   " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) >= 31 AND FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) <= 90 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORXVENCER31A90, " +
      "    COALESCE(CASE    " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) >= 91 AND FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) <= 180 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORXVENCER91A180,  " +
      "    COALESCE(CASE   " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) >= 181 AND FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) <= 360 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORXVENCER181A360, " +
      "    COALESCE(CASE  " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-TO_DATE(?))) > 360 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORXVENCERMAS360, " +
      "    COALESCE(CASE  " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) >= 1 AND FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) <= 30 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORVENCIDO1A30, " +
      "    COALESCE(CASE   " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) >= 31 AND FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) <= 90 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORVENCIDO31A90," +
      "    COALESCE(CASE  " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) >= 91 AND FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) <= 180 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORVENCIDO91A180, " +
      "    COALESCE(CASE  " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) >= 181 AND FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)))) <= 360 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))   " +
      "    END,0) AS VALORVENCIDO181A360, " +
      "    COALESCE(CASE  " +
      "        WHEN FLOOR(TO_NUMBER(TO_DATE(?)-TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))))>= 360 THEN ABS(ROUND(SUM(V.GRANDTOTAL), 2))" +
      "        ELSE ABS(ROUND(0, 2))     " +
      "    END,0) AS VALORVENCIDOMAS360, " +
      "    COALESCE(ABS(ROUND(I.EM_SDIN_LAWSUIT, 2)),ABS(ROUND(0, 2)) ,0) AS VALORENDEMANDAJUDICIAL, " +
      "    COALESCE (ABS(ROUND(CB.EM_SDIN_WALLET_PUNISHED, 2)),ABS(ROUND(0, 2)),0 ) as CARTERACASTIGADA, " +
      "    COALESCE(ABS(ROUND(AVG(V.GRANDTOTAL), 2)),0) as CUOTACREDITO," +
      "    CASE WHEN ((TO_DATE(sdin_cancellationdate(I.C_INVOICE_ID)))<= ?) THEN" +
      "    TO_CHAR(TO_DATE(sdin_cancellationdate(I.C_INVOICE_ID)),'dd/MM/yyyy')" +
      "    ELSE " +
      "    TO_CHAR('')" +
      "    END" +
      "   AS FECHACANCELACION," +
      " SUBSTR(sdin_cancelpaymentmethod(I.C_INVOICE_ID),1,1 )     AS FORMACANCELACION " +
      "    FROM sswh_acct_receivab_payab_v V " +
      "    INNER JOIN C_BPARTNER CB ON V.C_BPARTNER_ID = CB.C_BPARTNER_ID   " +
      "    LEFT JOIN C_INVOICE I ON V.INVOICE = I.DOCUMENTNO AND I.ISSOTRX = 'Y' " +
      "    LEFT JOIN C_DOCTYPE DT ON I.C_DOCTYPE_ID = DT.C_DOCTYPE_ID" +
      "    LEFT JOIN AD_ORG AO ON I.AD_ORG_ID= AO.AD_ORG_ID " +
      "    LEFT JOIN C_BPARTNER_LOCATION PL ON CB.C_BPARTNER_ID = PL.C_BPARTNER_ID " +
      "    LEFT JOIN C_LOCATION CL ON PL.C_LOCATION_ID = CL.C_LOCATION_ID " +
      "    LEFT JOIN C_REGION CR ON CL.C_REGION_ID = CR.C_REGION_ID" +
      "    LEFT JOIN SECPM_CANTON SC ON PL.EM_SECPM_CANTON_ID = SC.SECPM_CANTON_ID  " +
      "    LEFT JOIN SECPM_PARROQUIA SP ON PL.EM_SECPM_PARROQUIA_ID = SP.SECPM_PARROQUIA_ID   " +
      "        LEFT JOIN AD_ORGINFO AI ON AO.AD_ORG_ID = AI.AD_ORG_ID" +
      "    INNER JOIN C_PAYMENTTERM PT ON I.C_PAYMENTTERM_ID = PT.C_PAYMENTTERM_ID" +
      "    WHERE  (DOCUMENTDATE >= ? or ? is null)" +
      "        AND DOCUMENTDATE <= ?  " +
      "    AND DOC_CODE IN ('FC', 'CC', 'AC', 'RC')" +
      "    AND DT.EM_SDIN_APPLYDINARDAP = 'Y'" +
      "	AND PT.NAME NOT LIKE '%CONTADO%'  " +
      "    GROUP BY AI.TAXID, INVOICE, EM_SSWH_TAXIDTYPE, CB.TAXID, CB.NAME, I.DATEINVOICED, TO_DATE(SDIN_DUE_INVOICE(V.INVOICE)), PT.NETDAYS,  " +
      "    AO.EM_SDIN_DINARDAP_ID,CB.EM_SDIN_SUBJET_CLASS, CB.EM_SBPC_GENDER ,CB.EM_SBPC_CIVIL_STATUS,CB.EM_SDIN_SOURCE_OF_INCOME,I.EM_SDIN_LAWSUIT, CB.EM_SDIN_WALLET_PUNISHED,CR.VALUE ,SC.IDENTIFICADOR,SP.IDENTIFICADOR  " +
      "    ,I.C_INVOICE_ID  , ( case when upper(pt.name) like '%MES%' then 30 else  to_number(TO_DATE(SDIN_DUE_INVOICE(V.INVOICE))-I.DATEINVOICED)  " +
      "	  end) ,	 " +
      "   (case when ( case when upper(pt.name) like '%MES%' then 30 else PT.NETDAYS end) >30 then 30 else " +
      "	( case when upper(pt.name) like '%MES%' then 30 else PT.NETDAYS end) end )   " +
      "    ORDER BY CB.NAME " +
      "    ) rep" +
      "    where" +
      "    (case when (valorxvencer1a30=0 OR  valorxvencer1a30>0.10)" +
      "               and (valorxvencer31a90=0 OR  valorxvencer31a90>0.10)" +
      "               and (valorxvencer91a180=0 OR  valorxvencer91a180>0.10)" +
      "               and (valorxvencer181a360=0 OR  valorxvencer181a360>0.10)" +
      "               and (valorxvencermas360=0 OR  valorxvencermas360>0.10)" +
      "               and (valorvencido1a30=0 OR  valorvencido1a30>0.10)" +
      "               and (valorvencido31a90=0 OR  valorvencido31a90>0.10)" +
      "               and (valorvencido91a180=0 OR  valorvencido91a180>0.10)" +
      "               and (valorvencido181a360=0 OR  valorvencido181a360>0.10)" +
      "               and (valorvencidomas360=0 OR  valorvencidomas360>0.10)" +
      "     then 'Y'" +
      "     else 'N'" +
      "     end ) ='Y' " +
      "	 and VALOROPERACION >= 60 and SaldoOperacion > 0 and clasesujeto ='J' " +
      "	 AND TO_DATE(FECHACONCESION)<= TO_DATE(?) " +
      "     AND TIPOIDENTIFICACION not in ('E')" +
      "     order by nombresujeto";

    ResultSet result;
    Vector<ArchDinardapData> vector = new Vector<ArchDinardapData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID8);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID9);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID10);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID11);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID13);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID14);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID15);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID16);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID17);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID18);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID19);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID20);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID21);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID22);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ArchDinardapData objectArchDinardapData = new ArchDinardapData();
        objectArchDinardapData.rucorg = UtilSql.getValue(result, "rucorg");
        objectArchDinardapData.codigoentidad = UtilSql.getValue(result, "codigoentidad");
        objectArchDinardapData.tipoidentificacion = UtilSql.getValue(result, "tipoidentificacion");
        objectArchDinardapData.identificacionsujeto = UtilSql.getValue(result, "identificacionsujeto");
        objectArchDinardapData.nombresujeto = UtilSql.getValue(result, "nombresujeto");
        objectArchDinardapData.clasesujeto = UtilSql.getValue(result, "clasesujeto");
        objectArchDinardapData.provincia = UtilSql.getValue(result, "provincia");
        objectArchDinardapData.canton = UtilSql.getValue(result, "canton");
        objectArchDinardapData.parroquia = UtilSql.getValue(result, "parroquia");
        objectArchDinardapData.sexo = UtilSql.getValue(result, "sexo");
        objectArchDinardapData.estadocivil = UtilSql.getValue(result, "estadocivil");
        objectArchDinardapData.origeningresos = UtilSql.getValue(result, "origeningresos");
        objectArchDinardapData.numerooperacion = UtilSql.getValue(result, "numerooperacion");
        objectArchDinardapData.valoroperacion = UtilSql.getValue(result, "valoroperacion");
        objectArchDinardapData.saldooperacion = UtilSql.getValue(result, "saldooperacion");
        objectArchDinardapData.fechaconcesion = UtilSql.getValue(result, "fechaconcesion");
        objectArchDinardapData.fechavencimiento = UtilSql.getValue(result, "fechavencimiento");
        objectArchDinardapData.fechaexigible = UtilSql.getValue(result, "fechaexigible");
        objectArchDinardapData.plazooperacion = UtilSql.getValue(result, "plazooperacion");
        objectArchDinardapData.periodicidadpagos = UtilSql.getValue(result, "periodicidadpagos");
        objectArchDinardapData.diasmorosidad = UtilSql.getValue(result, "diasmorosidad");
        objectArchDinardapData.montomorosidad = UtilSql.getValue(result, "montomorosidad");
        objectArchDinardapData.montointeresenmora = UtilSql.getValue(result, "montointeresenmora");
        objectArchDinardapData.valorxvencer1a30 = UtilSql.getValue(result, "valorxvencer1a30");
        objectArchDinardapData.valorxvencer31a90 = UtilSql.getValue(result, "valorxvencer31a90");
        objectArchDinardapData.valorxvencer91a180 = UtilSql.getValue(result, "valorxvencer91a180");
        objectArchDinardapData.valorxvencer181a360 = UtilSql.getValue(result, "valorxvencer181a360");
        objectArchDinardapData.valorxvencermas360 = UtilSql.getValue(result, "valorxvencermas360");
        objectArchDinardapData.valorvencido1a30 = UtilSql.getValue(result, "valorvencido1a30");
        objectArchDinardapData.valorvencido31a90 = UtilSql.getValue(result, "valorvencido31a90");
        objectArchDinardapData.valorvencido91a180 = UtilSql.getValue(result, "valorvencido91a180");
        objectArchDinardapData.valorvencido181a360 = UtilSql.getValue(result, "valorvencido181a360");
        objectArchDinardapData.valorvencidomas360 = UtilSql.getValue(result, "valorvencidomas360");
        objectArchDinardapData.valorendemandajudicial = UtilSql.getValue(result, "valorendemandajudicial");
        objectArchDinardapData.carteracastigada = UtilSql.getValue(result, "carteracastigada");
        objectArchDinardapData.cuotacredito = UtilSql.getValue(result, "cuotacredito");
        objectArchDinardapData.fechacancelacion = UtilSql.getValue(result, "fechacancelacion");
        objectArchDinardapData.formacancelacion = UtilSql.getValue(result, "formacancelacion");
        objectArchDinardapData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchDinardapData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    ArchDinardapData objectArchDinardapData[] = new ArchDinardapData[vector.size()];
    vector.copyInto(objectArchDinardapData);
    return(objectArchDinardapData);
  }
}

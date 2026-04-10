//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.create_xml;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SswhRptcWithCardData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhRptcWithCardData.class);
  private String InitRecordNumber="0";
  public String year;
  public String month;
  public String taxidtype;
  public String taxid;
  public String relatedpart;
  public String codetrxt;
  public String iselectronic;
  public String vouchersNumber;
  public String basenogiva;
  public String baseimp;
  public String baseimpg;
  public String montoiva;
  public String montoice;
  public String retIva;
  public String retRen;
  public String codeats;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("year"))
      return year;
    else if (fieldName.equalsIgnoreCase("month"))
      return month;
    else if (fieldName.equalsIgnoreCase("taxidtype"))
      return taxidtype;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("relatedpart"))
      return relatedpart;
    else if (fieldName.equalsIgnoreCase("codetrxt"))
      return codetrxt;
    else if (fieldName.equalsIgnoreCase("iselectronic"))
      return iselectronic;
    else if (fieldName.equalsIgnoreCase("vouchers_number") || fieldName.equals("vouchersNumber"))
      return vouchersNumber;
    else if (fieldName.equalsIgnoreCase("basenogiva"))
      return basenogiva;
    else if (fieldName.equalsIgnoreCase("baseimp"))
      return baseimp;
    else if (fieldName.equalsIgnoreCase("baseimpg"))
      return baseimpg;
    else if (fieldName.equalsIgnoreCase("montoiva"))
      return montoiva;
    else if (fieldName.equalsIgnoreCase("montoice"))
      return montoice;
    else if (fieldName.equalsIgnoreCase("ret_iva") || fieldName.equals("retIva"))
      return retIva;
    else if (fieldName.equalsIgnoreCase("ret_ren") || fieldName.equals("retRen"))
      return retRen;
    else if (fieldName.equalsIgnoreCase("codeats"))
      return codeats;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhRptcWithCardData[] select(ConnectionProvider connectionProvider, String year, String month)    throws ServletException {
    return select(connectionProvider, year, month, 0, 0);
  }

  public static SswhRptcWithCardData[] select(ConnectionProvider connectionProvider, String year, String month, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT" +
      "            year," +
      "            month," +
      "            taxidtype," +
      "            taxid," +
      "            relatedpart," +
      "            codetrxt," +
      "            iselectronic," +
      "            SUM(vouchers_number) AS vouchers_number," +
      "            '0.00' AS basenogiva," +
      "            '0.00' AS baseimp," +
      "            '0.00' AS baseimpg," +
      "            '0.00' AS montoiva," +
      "            '0.00' AS montoice," +
      "            SUM(ret_iva) ret_iva," +
      "            SUM(ret_ren) ret_ren," +
      "            codeats" +
      "        FROM (" +
      "            SELECT" +
      "                CAST(EXTRACT(YEAR FROM whc.date_doc) AS varchar) AS year," +
      "                CAST(EXTRACT(MONTH FROM whc.date_doc) AS varchar) AS month," +
      "                CASE WHEN bp.EM_Sswh_Taxidtype = 'R' THEN" +
      "                    '04'" +
      "                ELSE" +
      "                    '05'" +
      "                END AS taxidtype," +
      "                bp.TaxID," +
      "                CASE WHEN txp.Relatedpart = 'Y' THEN" +
      "                    'SI'" +
      "                ELSE" +
      "                    'NO'" +
      "                END AS Relatedpart," +
      "                trxt.code AS codetrxt," +
      "                CASE WHEN trxt.Iselectronic = 'Y' THEN" +
      "                    'E'" +
      "                ELSE" +
      "                    'F'" +
      "                END iselectronic," +
      "                whc.Vouchers_Number," +
      "                whc.Withh_Vat AS ret_iva," +
      "                whc.Withh_Rent AS ret_ren," +
      "                fpm.EM_Sswh_Codeats AS codeats" +
      "            FROM" +
      "                sswh_withh_card_credit whc" +
      "                JOIN c_bpartner bp ON bp.c_bpartner_id = whc.c_bpartner_id" +
      "                JOIN SSWH_Taxpayer txp ON txp.SSWH_Taxpayer_id = bp.EM_SSWH_Taxpayer_ID" +
      "                JOIN Sswh_Transaction_Type trxt ON trxt.Sswh_Transaction_Type_ID = whc.Sswh_Transaction_Type_ID" +
      "                JOIN FIN_Paymentmethod fpm ON fpm.FIN_Paymentmethod_ID = whc.FIN_Paymentmethod_ID" +
      "            WHERE" +
      "                whc.status = 'CO'" +
      "                AND CAST(EXTRACT(YEAR FROM whc.date_doc) AS varchar) = ?" +
      "                AND CAST(EXTRACT(MONTH FROM whc.date_doc) AS varchar) = ?) x" +
      "        GROUP BY" +
      "            TaxID," +
      "            year," +
      "            month," +
      "            taxidtype," +
      "            relatedpart," +
      "            codetrxt," +
      "            iselectronic," +
      "            codeats";

    ResultSet result;
    Vector<SswhRptcWithCardData> vector = new Vector<SswhRptcWithCardData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, month);

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
        SswhRptcWithCardData objectSswhRptcWithCardData = new SswhRptcWithCardData();
        objectSswhRptcWithCardData.year = UtilSql.getValue(result, "year");
        objectSswhRptcWithCardData.month = UtilSql.getValue(result, "month");
        objectSswhRptcWithCardData.taxidtype = UtilSql.getValue(result, "taxidtype");
        objectSswhRptcWithCardData.taxid = UtilSql.getValue(result, "taxid");
        objectSswhRptcWithCardData.relatedpart = UtilSql.getValue(result, "relatedpart");
        objectSswhRptcWithCardData.codetrxt = UtilSql.getValue(result, "codetrxt");
        objectSswhRptcWithCardData.iselectronic = UtilSql.getValue(result, "iselectronic");
        objectSswhRptcWithCardData.vouchersNumber = UtilSql.getValue(result, "vouchers_number");
        objectSswhRptcWithCardData.basenogiva = UtilSql.getValue(result, "basenogiva");
        objectSswhRptcWithCardData.baseimp = UtilSql.getValue(result, "baseimp");
        objectSswhRptcWithCardData.baseimpg = UtilSql.getValue(result, "baseimpg");
        objectSswhRptcWithCardData.montoiva = UtilSql.getValue(result, "montoiva");
        objectSswhRptcWithCardData.montoice = UtilSql.getValue(result, "montoice");
        objectSswhRptcWithCardData.retIva = UtilSql.getValue(result, "ret_iva");
        objectSswhRptcWithCardData.retRen = UtilSql.getValue(result, "ret_ren");
        objectSswhRptcWithCardData.codeats = UtilSql.getValue(result, "codeats");
        objectSswhRptcWithCardData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhRptcWithCardData);
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
    SswhRptcWithCardData objectSswhRptcWithCardData[] = new SswhRptcWithCardData[vector.size()];
    vector.copyInto(objectSswhRptcWithCardData);
    return(objectSswhRptcWithCardData);
  }
}

//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.tenth.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchTenthGuayaquilData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchTenthGuayaquilData.class);
  private String InitRecordNumber="0";
  public String cuenta;
  public String cliente;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("cuenta"))
      return cuenta;
    else if (fieldName.equalsIgnoreCase("cliente"))
      return cliente;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchTenthGuayaquilData[] select(ConnectionProvider connectionProvider, String id, String bank)    throws ServletException {
    return select(connectionProvider, id, bank, 0, 0);
  }

  public static ArchTenthGuayaquilData[] select(ConnectionProvider connectionProvider, String id, String bank, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT CASE WHEN bankaccounttype='S' THEN 'A'  ELSE 'C' END || " +
      "    LPAD(to_char(accountno),10,'0') || " +
      "    LPAD(replace(to_char(round(adjustedamt,2)),'.',''),15,'0')||" +
      "    'XX'||" +
      "    'Y'||" +
      "    '01' as cuenta" +
      "    ,RPAD(substr(upper(cb.name2),0,19),18,' ')||'EEV' as cliente" +
      "    FROM SSPH_Tenth_Settlement t " +
      "    JOIN ssph_tenth_settlement_line  tl on tl.ssph_tenth_settlement_id=t.ssph_tenth_settlement_id" +
      "    JOIN c_bpartner cb on cb.c_bpartner_id=tl.c_bpartner_id" +
      "    JOIN c_bp_bankaccount c on c.c_bpartner_id=tl.c_bpartner_id" +
      "    WHERE t.ssph_tenth_settlement_id = ?" +
      "    AND EM_SSPR_Typeofincome='D'" +
      "    AND em_ssfi_banktransfer_id = ?" +
      "    ORDER BY 2";

    ResultSet result;
    Vector<ArchTenthGuayaquilData> vector = new Vector<ArchTenthGuayaquilData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bank);

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
        ArchTenthGuayaquilData objectArchTenthGuayaquilData = new ArchTenthGuayaquilData();
        objectArchTenthGuayaquilData.cuenta = UtilSql.getValue(result, "cuenta");
        objectArchTenthGuayaquilData.cliente = UtilSql.getValue(result, "cliente");
        objectArchTenthGuayaquilData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchTenthGuayaquilData);
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
    ArchTenthGuayaquilData objectArchTenthGuayaquilData[] = new ArchTenthGuayaquilData[vector.size()];
    vector.copyInto(objectArchTenthGuayaquilData);
    return(objectArchTenthGuayaquilData);
  }
}

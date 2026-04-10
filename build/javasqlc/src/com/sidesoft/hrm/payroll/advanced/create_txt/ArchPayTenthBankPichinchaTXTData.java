//Sqlc generated V1.O00-1
package  com.sidesoft.hrm.payroll.advanced.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchPayTenthBankPichinchaTXTData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPayTenthBankPichinchaTXTData.class);
  private String InitRecordNumber="0";
  public String codorientacion;
  public String contrapartida;
  public String moneda;
  public String valor;
  public String formapc;
  public String tipocuenta;
  public String numerocuenta;
  public String referencia;
  public String tipoidclie;
  public String numidclie;
  public String nomclie;
  public String codbanco;
  public String codigo;
  public String transfer;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("codorientacion"))
      return codorientacion;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("formapc"))
      return formapc;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("numerocuenta"))
      return numerocuenta;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("tipoidclie"))
      return tipoidclie;
    else if (fieldName.equalsIgnoreCase("numidclie"))
      return numidclie;
    else if (fieldName.equalsIgnoreCase("nomclie"))
      return nomclie;
    else if (fieldName.equalsIgnoreCase("codbanco"))
      return codbanco;
    else if (fieldName.equalsIgnoreCase("codigo"))
      return codigo;
    else if (fieldName.equalsIgnoreCase("transfer"))
      return transfer;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchPayTenthBankPichinchaTXTData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID, String SSFI_BANKTRANSFER_ID, String EM_Sspr_Category_Acct_ID, String CostCenter)    throws ServletException {
    return select(connectionProvider, C_YEAR_ID, SSFI_BANKTRANSFER_ID, EM_Sspr_Category_Acct_ID, CostCenter, 0, 0);
  }

  public static ArchPayTenthBankPichinchaTXTData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID, String SSFI_BANKTRANSFER_ID, String EM_Sspr_Category_Acct_ID, String CostCenter, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select " +
      "            bt.Paymentmethod as codorientacion, " +
      "            p.EM_SSPR_DocumentNo as contrapartida," +
      "            m.ISO_CODE AS moneda, " +
      "            ROUND(tl.Adjustedamt,2) as valor, " +
      "            'CTA' as formapc, " +
      "            case when b.BankAccountType = 'S' then 'AHO'" +
      "            when b.BankAccountType = 'C' then 'CTE' end" +
      "            as tipocuenta, " +
      "            b.AccountNo as numerocuenta, " +
      "            t.Description as referencia," +
      "            case when p.EM_SSPR_Documenttype = 'NI' then 'C'" +
      "            when p.EM_SSPR_Documenttype = 'SRT' then 'R'" +
      "            when p.EM_SSPR_Documenttype = 'P' then 'P' end" +
      "            as tipoidclie, " +
      "            p.EM_SSPR_DocumentNo as numidclie," +
      "            p.name as nomclie, " +
      "            bt.code as codbanco," +
      "            bt.CODE AS CODIGO," +
      "	        bt.NAME AS TRANSFER" +
      "            from SSPH_Tenth_Settlement_Line tl" +
      "        left join SSPH_Tenth_Settlement t on t.SSPH_Tenth_Settlement_id=tl.SSPH_Tenth_Settlement_id" +
      "                left join ad_org o on t.ad_org_id=o.ad_org_id" +
      "                left join c_currency m on m.c_currency_id=o.c_currency_id" +
      "                left join C_bpartner p on tl.c_bpartner_id=p.c_bpartner_id" +
      "                left join c_year y on t.c_year_id=y.c_year_id" +
      "                left join C_BP_BankAccount b on p.c_bpartner_id=b.c_bpartner_id" +
      "                left join ssfi_banktransfer bt on b.em_ssfi_banktransfer_id=bt.ssfi_banktransfer_id" +
      "                left join Sspr_Category_Acct c on c.Sspr_Category_Acct_ID=p.EM_Sspr_Category_Acct_ID" +
      "                left join sspr_configurationutility cu on cu.c_year_id=y.c_year_id" +
      "            where " +
      "                t.documentno like ? " +
      "                 AND (bt.ssfi_banktransfer_id = ? OR COALESCE(?,'') = '')" +
      "                AND (p.EM_Sspr_Category_Acct_ID = ? OR COALESCE(?,'') = '')" +
      "                AND (p.EM_Sspr_Costcenter_ID = ? OR COALESCE(?,'') = '')" +
      "            order by" +
      "                p.name asc";

    ResultSet result;
    Vector<ArchPayTenthBankPichinchaTXTData> vector = new Vector<ArchPayTenthBankPichinchaTXTData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SSFI_BANKTRANSFER_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SSFI_BANKTRANSFER_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, EM_Sspr_Category_Acct_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, EM_Sspr_Category_Acct_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CostCenter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CostCenter);

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
        ArchPayTenthBankPichinchaTXTData objectArchPayTenthBankPichinchaTXTData = new ArchPayTenthBankPichinchaTXTData();
        objectArchPayTenthBankPichinchaTXTData.codorientacion = UtilSql.getValue(result, "codorientacion");
        objectArchPayTenthBankPichinchaTXTData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectArchPayTenthBankPichinchaTXTData.moneda = UtilSql.getValue(result, "moneda");
        objectArchPayTenthBankPichinchaTXTData.valor = UtilSql.getValue(result, "valor");
        objectArchPayTenthBankPichinchaTXTData.formapc = UtilSql.getValue(result, "formapc");
        objectArchPayTenthBankPichinchaTXTData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectArchPayTenthBankPichinchaTXTData.numerocuenta = UtilSql.getValue(result, "numerocuenta");
        objectArchPayTenthBankPichinchaTXTData.referencia = UtilSql.getValue(result, "referencia");
        objectArchPayTenthBankPichinchaTXTData.tipoidclie = UtilSql.getValue(result, "tipoidclie");
        objectArchPayTenthBankPichinchaTXTData.numidclie = UtilSql.getValue(result, "numidclie");
        objectArchPayTenthBankPichinchaTXTData.nomclie = UtilSql.getValue(result, "nomclie");
        objectArchPayTenthBankPichinchaTXTData.codbanco = UtilSql.getValue(result, "codbanco");
        objectArchPayTenthBankPichinchaTXTData.codigo = UtilSql.getValue(result, "codigo");
        objectArchPayTenthBankPichinchaTXTData.transfer = UtilSql.getValue(result, "transfer");
        objectArchPayTenthBankPichinchaTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPayTenthBankPichinchaTXTData);
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
    ArchPayTenthBankPichinchaTXTData objectArchPayTenthBankPichinchaTXTData[] = new ArchPayTenthBankPichinchaTXTData[vector.size()];
    vector.copyInto(objectArchPayTenthBankPichinchaTXTData);
    return(objectArchPayTenthBankPichinchaTXTData);
  }
}

//Sqlc generated V1.O00-1
package ec.com.sidesoft.custom.payments.partialpayment.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SsppDownloadPaymentFileData implements FieldProvider {
static Logger log4j = Logger.getLogger(SsppDownloadPaymentFileData.class);
  private String InitRecordNumber="0";
  public String secuencial;
  public String codOrientacion;
  public String contrapartida;
  public String moneda;
  public String valor;
  public String formaPago;
  public String numComprobante;
  public String tipoCuenta;
  public String numCuenta;
  public String pago;
  public String tipoIdCliente;
  public String numIdCliente;
  public String nombreCliente;
  public String codigoBanco;
  public String cuentaEmpresa;
  public String blankColumn;
  public String referenciaAdicional;
  public String referencia;
  public String valorTxt;
  public String codigoBancoCpl;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("secuencial"))
      return secuencial;
    else if (fieldName.equalsIgnoreCase("cod_orientacion") || fieldName.equals("codOrientacion"))
      return codOrientacion;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("forma_pago") || fieldName.equals("formaPago"))
      return formaPago;
    else if (fieldName.equalsIgnoreCase("num_comprobante") || fieldName.equals("numComprobante"))
      return numComprobante;
    else if (fieldName.equalsIgnoreCase("tipo_cuenta") || fieldName.equals("tipoCuenta"))
      return tipoCuenta;
    else if (fieldName.equalsIgnoreCase("num_cuenta") || fieldName.equals("numCuenta"))
      return numCuenta;
    else if (fieldName.equalsIgnoreCase("pago"))
      return pago;
    else if (fieldName.equalsIgnoreCase("tipo_id_cliente") || fieldName.equals("tipoIdCliente"))
      return tipoIdCliente;
    else if (fieldName.equalsIgnoreCase("num_id_cliente") || fieldName.equals("numIdCliente"))
      return numIdCliente;
    else if (fieldName.equalsIgnoreCase("nombre_cliente") || fieldName.equals("nombreCliente"))
      return nombreCliente;
    else if (fieldName.equalsIgnoreCase("codigo_banco") || fieldName.equals("codigoBanco"))
      return codigoBanco;
    else if (fieldName.equalsIgnoreCase("cuenta_empresa") || fieldName.equals("cuentaEmpresa"))
      return cuentaEmpresa;
    else if (fieldName.equalsIgnoreCase("blank_column") || fieldName.equals("blankColumn"))
      return blankColumn;
    else if (fieldName.equalsIgnoreCase("referencia_adicional") || fieldName.equals("referenciaAdicional"))
      return referenciaAdicional;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("valor_txt") || fieldName.equals("valorTxt"))
      return valorTxt;
    else if (fieldName.equalsIgnoreCase("codigo_banco_cpl") || fieldName.equals("codigoBancoCpl"))
      return codigoBancoCpl;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SsppDownloadPaymentFileData[] selectDetailled(ConnectionProvider connectionProvider, String ssppp_payment_id)    throws ServletException {
    return selectDetailled(connectionProvider, ssppp_payment_id, 0, 0);
  }

  public static SsppDownloadPaymentFileData[] selectDetailled(ConnectionProvider connectionProvider, String ssppp_payment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT " +
      "    ROW_NUMBER () OVER (ORDER BY TRAS.code) as secuencial" +
      "    ,to_char('PA') as cod_orientacion" +
      "    ,to_char(FAC.genericaccountno) as contrapartida" +
      "    ,CURR.ISO_Code as moneda" +
      "    ,SUM(PAYL.Amount) as valor" +
      "    ,to_char('CTA') as forma_pago" +
      "    , '' as num_comprobante" +
      "    ,CASE WHEN BANK.BankAccountType = 'C' THEN to_char('CTE') " +
      "        WHEN BANK.BankAccountType = 'S' THEN to_char('AHO') " +
      "        ELSE to_char('---') " +
      "    END as tipo_cuenta " +
      "    ,coalesce(CASE WHEN LENGTH(BANK.AccountNo)<10 THEN LPAD(BANK.AccountNo,10,'0') ELSE BANK.AccountNo END,' ') as num_cuenta     " +
      "    ,to_char(coalesce(PAY.description,' '))  as  pago " +
      "    ,CASE WHEN BANK.em_sswh_taxidType = 'D' THEN to_char('C') " +
      "         ELSE BANK.em_sswh_taxidType " +
      "    END as tipo_id_cliente  " +
      "    ,BANK.em_sswh_taxidno as num_id_cliente " +
      "    ,BPAR.name as nombre_cliente " +
      "    ,TRAS.code as codigo_banco " +
      "    ,LPAD(bk_org.cuenta_empresa,10,'0') as cuenta_empresa" +
      "    ,' ' as blank_column" +
      "    ,substring(COALESCE(PAYL.documentno,'')||'|'||COALESCE(BPAR.em_eei_email,''),1,100) as referencia_adicional " +
      "    ,substring(COALESCE(PAYL.documentno,''),1,200) as referencia " +
      "    ,LPAD(regexp_replace(to_char(round(SUM(PAYL.Amount),2)), '[^0-9]+', '', 'g'),13,'0') as valor_txt" +
      "    ,CASE WHEN TRAS.code IS NULL THEN '' ELSE LPAD(TRAS.code,4,'0') END AS codigo_banco_cpl" +
      "    FROM  sspp_payments PAY   " +
      "        inner join ad_client ENTI on PAY.ad_client_id = ENTI.ad_client_id  " +
      "        INNER JOIN C_Currency CURR on CURR.C_Currency_ID =ENTI.C_Currency_ID  " +
      "        inner join SSPP_PAYMENTSLINE PAYL on PAYL.sspp_payments_id = PAY.sspp_payments_id " +
      "        inner JOIN FIN_Financial_Account FAC on FAC.FIN_Financial_Account_ID = PAY.FIN_Financial_Account_ID  " +
      "        LEFT JOIN c_bpartner BPAR on  BPAR.c_bpartner_id = PAYL.c_bpartner_id  " +
      "        LEFT JOIN C_BP_BankAccount BANK on BANK.c_bpartner_id=BPAR.c_bpartner_id and BANK.isactive='Y'  " +
      "        LEFT JOIN ssfi_banktransfer TRAS on TRAS.ssfi_banktransfer_id = BANK.em_ssfi_banktransfer_id  " +
      "        LEFT JOIN (SELECT COALESCE(bk.AccountNo,' ') as cuenta_empresa     " +
      "            FROM ad_orginfo org" +
      "            JOIN c_bpartner bp ON bp.c_bpartner_id=org.c_bpartner_id" +
      "            LEFT JOIN C_BP_BankAccount bk on bk.c_bpartner_id=bp.c_bpartner_id and bk.isactive='Y'  " +
      "            WHERE EXISTS (" +
      "                SELECT 1 FROM ad_org_tree WHERE  levelno=2 AND ad_parent_org_id='0' AND org.ad_org_id=ad_org_id )" +
      "        ) bk_org ON 1=1 " +
      "    WHERE PAY.sspp_payments_id = ?  " +
      "    GROUP BY cod_orientacion,contrapartida,moneda,forma_pago,tipo_cuenta " +
      "    ,num_cuenta,tipo_id_cliente,num_id_cliente,BPAR.c_bpartner_id,TRAS.code,pago " +
      "    ,bk_org.cuenta_empresa,PAYL.description,PAYL.documentno";

    ResultSet result;
    Vector<SsppDownloadPaymentFileData> vector = new Vector<SsppDownloadPaymentFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssppp_payment_id);

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
        SsppDownloadPaymentFileData objectSsppDownloadPaymentFileData = new SsppDownloadPaymentFileData();
        objectSsppDownloadPaymentFileData.secuencial = UtilSql.getValue(result, "secuencial");
        objectSsppDownloadPaymentFileData.codOrientacion = UtilSql.getValue(result, "cod_orientacion");
        objectSsppDownloadPaymentFileData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectSsppDownloadPaymentFileData.moneda = UtilSql.getValue(result, "moneda");
        objectSsppDownloadPaymentFileData.valor = UtilSql.getValue(result, "valor");
        objectSsppDownloadPaymentFileData.formaPago = UtilSql.getValue(result, "forma_pago");
        objectSsppDownloadPaymentFileData.numComprobante = UtilSql.getValue(result, "num_comprobante");
        objectSsppDownloadPaymentFileData.tipoCuenta = UtilSql.getValue(result, "tipo_cuenta");
        objectSsppDownloadPaymentFileData.numCuenta = UtilSql.getValue(result, "num_cuenta");
        objectSsppDownloadPaymentFileData.pago = UtilSql.getValue(result, "pago");
        objectSsppDownloadPaymentFileData.tipoIdCliente = UtilSql.getValue(result, "tipo_id_cliente");
        objectSsppDownloadPaymentFileData.numIdCliente = UtilSql.getValue(result, "num_id_cliente");
        objectSsppDownloadPaymentFileData.nombreCliente = UtilSql.getValue(result, "nombre_cliente");
        objectSsppDownloadPaymentFileData.codigoBanco = UtilSql.getValue(result, "codigo_banco");
        objectSsppDownloadPaymentFileData.cuentaEmpresa = UtilSql.getValue(result, "cuenta_empresa");
        objectSsppDownloadPaymentFileData.blankColumn = UtilSql.getValue(result, "blank_column");
        objectSsppDownloadPaymentFileData.referenciaAdicional = UtilSql.getValue(result, "referencia_adicional");
        objectSsppDownloadPaymentFileData.referencia = UtilSql.getValue(result, "referencia");
        objectSsppDownloadPaymentFileData.valorTxt = UtilSql.getValue(result, "valor_txt");
        objectSsppDownloadPaymentFileData.codigoBancoCpl = UtilSql.getValue(result, "codigo_banco_cpl");
        objectSsppDownloadPaymentFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsppDownloadPaymentFileData);
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
    SsppDownloadPaymentFileData objectSsppDownloadPaymentFileData[] = new SsppDownloadPaymentFileData[vector.size()];
    vector.copyInto(objectSsppDownloadPaymentFileData);
    return(objectSsppDownloadPaymentFileData);
  }

  public static SsppDownloadPaymentFileData[] select(ConnectionProvider connectionProvider, String ssppp_payment_id)    throws ServletException {
    return select(connectionProvider, ssppp_payment_id, 0, 0);
  }

  public static SsppDownloadPaymentFileData[] select(ConnectionProvider connectionProvider, String ssppp_payment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT " +
      "ROW_NUMBER () OVER (ORDER BY TRAS.code) as secuencial" +
      ",to_char('PA') as cod_orientacion" +
      ",to_char(FAC.genericaccountno) as contrapartida" +
      ",CURR.ISO_Code as moneda" +
      ",SUM(PAYL.Amount) as valor" +
      ",to_char('CTA') as forma_pago" +
      ", '' as num_comprobante" +
      ",CASE WHEN BANK.BankAccountType = 'C' THEN to_char('CTE') " +
      "    WHEN BANK.BankAccountType = 'S' THEN to_char('AHO') " +
      "    ELSE to_char('---') " +
      "END as tipo_cuenta " +
      ",coalesce(BANK.AccountNo,' ') as num_cuenta     " +
      ",to_char(coalesce(PAY.description,' '))  as  pago " +
      ",CASE WHEN BANK.em_sswh_taxidType = 'D' THEN to_char('C') " +
      "     ELSE BANK.em_sswh_taxidType " +
      "END as tipo_id_cliente  " +
      ",BANK.em_sswh_taxidno as num_id_cliente " +
      ",BPAR.name as nombre_cliente " +
      ",TRAS.code as codigo_banco " +
      "FROM  sspp_payments PAY   " +
      "    inner join ad_client ENTI on PAY.ad_client_id = ENTI.ad_client_id  " +
      "    INNER JOIN C_Currency CURR on CURR.C_Currency_ID =ENTI.C_Currency_ID  " +
      "    inner join SSPP_PAYMENTSLINE PAYL on PAYL.sspp_payments_id = PAY.sspp_payments_id " +
      "    inner JOIN FIN_Financial_Account FAC on FAC.FIN_Financial_Account_ID = PAY.FIN_Financial_Account_ID  " +
      "    LEFT JOIN c_bpartner BPAR on  BPAR.c_bpartner_id = PAYL.c_bpartner_id  " +
      "    LEFT JOIN C_BP_BankAccount BANK on BANK.c_bpartner_id=BPAR.c_bpartner_id and BANK.isactive='Y'  " +
      "    LEFT JOIN ssfi_banktransfer TRAS on TRAS.ssfi_banktransfer_id = BANK.em_ssfi_banktransfer_id  " +
      "WHERE PAY.sspp_payments_id = ?  " +
      "GROUP BY cod_orientacion,contrapartida,moneda,forma_pago,tipo_cuenta,num_cuenta,tipo_id_cliente,num_id_cliente,nombre_cliente,Codigo_banco,pago   ";

    ResultSet result;
    Vector<SsppDownloadPaymentFileData> vector = new Vector<SsppDownloadPaymentFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssppp_payment_id);

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
        SsppDownloadPaymentFileData objectSsppDownloadPaymentFileData = new SsppDownloadPaymentFileData();
        objectSsppDownloadPaymentFileData.secuencial = UtilSql.getValue(result, "secuencial");
        objectSsppDownloadPaymentFileData.codOrientacion = UtilSql.getValue(result, "cod_orientacion");
        objectSsppDownloadPaymentFileData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectSsppDownloadPaymentFileData.moneda = UtilSql.getValue(result, "moneda");
        objectSsppDownloadPaymentFileData.valor = UtilSql.getValue(result, "valor");
        objectSsppDownloadPaymentFileData.formaPago = UtilSql.getValue(result, "forma_pago");
        objectSsppDownloadPaymentFileData.numComprobante = UtilSql.getValue(result, "num_comprobante");
        objectSsppDownloadPaymentFileData.tipoCuenta = UtilSql.getValue(result, "tipo_cuenta");
        objectSsppDownloadPaymentFileData.numCuenta = UtilSql.getValue(result, "num_cuenta");
        objectSsppDownloadPaymentFileData.pago = UtilSql.getValue(result, "pago");
        objectSsppDownloadPaymentFileData.tipoIdCliente = UtilSql.getValue(result, "tipo_id_cliente");
        objectSsppDownloadPaymentFileData.numIdCliente = UtilSql.getValue(result, "num_id_cliente");
        objectSsppDownloadPaymentFileData.nombreCliente = UtilSql.getValue(result, "nombre_cliente");
        objectSsppDownloadPaymentFileData.codigoBanco = UtilSql.getValue(result, "codigo_banco");
        objectSsppDownloadPaymentFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsppDownloadPaymentFileData);
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
    SsppDownloadPaymentFileData objectSsppDownloadPaymentFileData[] = new SsppDownloadPaymentFileData[vector.size()];
    vector.copyInto(objectSsppDownloadPaymentFileData);
    return(objectSsppDownloadPaymentFileData);
  }
}

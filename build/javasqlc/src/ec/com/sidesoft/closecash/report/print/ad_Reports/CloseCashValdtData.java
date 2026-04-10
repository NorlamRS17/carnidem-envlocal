//Sqlc generated V1.O00-1
package ec.com.sidesoft.closecash.report.print.ad_Reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class CloseCashValdtData implements FieldProvider {
static Logger log4j = Logger.getLogger(CloseCashValdtData.class);
  private String InitRecordNumber="0";
  public String fechat;
  public String caja;
  public String doc;
  public String cliente;
  public String mpago;
  public String tdoc;
  public String sum;
  public String cd;
  public String grupo;
  public String cgrupo;
  public String texto;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fechat"))
      return fechat;
    else if (fieldName.equalsIgnoreCase("caja"))
      return caja;
    else if (fieldName.equalsIgnoreCase("doc"))
      return doc;
    else if (fieldName.equalsIgnoreCase("cliente"))
      return cliente;
    else if (fieldName.equalsIgnoreCase("mpago"))
      return mpago;
    else if (fieldName.equalsIgnoreCase("tdoc"))
      return tdoc;
    else if (fieldName.equalsIgnoreCase("sum"))
      return sum;
    else if (fieldName.equalsIgnoreCase("cd"))
      return cd;
    else if (fieldName.equalsIgnoreCase("grupo"))
      return grupo;
    else if (fieldName.equalsIgnoreCase("cgrupo"))
      return cgrupo;
    else if (fieldName.equalsIgnoreCase("texto"))
      return texto;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CloseCashValdtData[] select(ConnectionProvider connectionProvider, String noDoc, String noDoc2, String noDoc3, String noDoc4, String noDoc5, String noDoc6)    throws ServletException {
    return select(connectionProvider, noDoc, noDoc2, noDoc3, noDoc4, noDoc5, noDoc6, 0, 0);
  }

  public static CloseCashValdtData[] select(ConnectionProvider connectionProvider, String noDoc, String noDoc2, String noDoc3, String noDoc4, String noDoc5, String noDoc6, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select * from ( select fechat,caja,doc,cliente,mpago,tdoc,sum(total),cd,grupo,cgrupo,texto from ( " +
      "	SELECT" +
      "		CASE WHEN cir.documentno is null AND pd.C_Glitem_ID is null THEN TO_CHAR(ci.dateinvoiced,'dd/MM/yyyy')" +
      "			WHEN pd.C_Glitem_ID is not null  THEN TO_CHAR(p.paymentdate,'dd/MM/yyyy')" +
      "			ELSE TO_CHAR(cir.dateinvoiced,'dd/MM/yyyy')" +
      "		END as fechat" +
      "		, sccc_cash_clousure_id as caja" +
      "		, p.documentno as doc" +
      "		, bp.name as cliente" +
      "		, pm.name as mpago" +
      "		, dt.name as tdoc" +
      "		, psd.fin_payment_detail_id as factura" +
      "		,CASE WHEN round(p.amount,3) = 0  THEN psd.amount" +
      "			WHEN round(p.amount,3) > round(psd.amount,3) THEN psd.amount" +
      "			ELSE p.amount" +
      "		END as total" +
      "		, true as cd" +
      "		, 'COBROS CONTADO' as grupo" +
      "		, 2 as cgrupo" +
      "		, 'Subtotal' as texto" +
      "	FROM FIN_Payment p" +
      "		left Join c_bpartner bp on bp.c_bpartner_id = p.c_bpartner_id" +
      "		left Join FIN_Paymentmethod pm on pm.FIN_Paymentmethod_ID = p.FIN_Paymentmethod_ID" +
      "		left Join C_DocType dt on dt.C_DocType_id = p.C_DocType_id" +
      "		left join fin_payment_detail pd on p.FIN_Payment_id=pd.FIN_Payment_id" +
      "		left join fin_payment_scheduledetail psd on pd.fin_payment_detail_id=psd.fin_payment_detail_id" +
      "		left join FIN_Payment_Schedule ps on psd.fin_payment_schedule_invoice=ps.fin_payment_schedule_id" +
      "		left join c_invoice ci on ci.c_invoice_id=ps.c_invoice_id" +
      "		left Join c_invoice cir on cir.c_invoice_id = ci.em_scnr_invoice_id" +
      "		inner join ad_org org on org.ad_org_id=p.ad_org_id" +
      "		inner join Sccc_Setup ss on ss.ad_org_id=p.ad_org_id" +
      "		inner join Ssccso_Type_Of_Document sd on sd.Sccc_Setup_ID = ss.Sccc_Setup_ID AND dt.C_DocType_id=sd.C_DocType_id" +
      "		inner join sccc_cash_clousure cc on cc.Sccc_Setup_ID=ss.Sccc_Setup_ID" +
      "	WHERE (pd.C_Glitem_ID is not null or ci.dateinvoiced::date=p.paymentdate::date )" +
      "	AND CASE WHEN cir.documentno is null AND pd.C_Glitem_ID is null THEN ci.dateinvoiced::date" +
      "			WHEN pd.C_Glitem_ID is not null  THEN p.paymentdate::date" +
      "			ELSE cir.dateinvoiced::date" +
      "		END = cc.Closingdate::date" +
      "		AND CASE WHEN cir.documentno is null AND pd.C_Glitem_ID is null THEN TO_CHAR(ci.dateinvoiced,'dd/MM/yyyy')" +
      "			WHEN pd.C_Glitem_ID is not null  THEN TO_CHAR(p.paymentdate,'dd/MM/yyyy')" +
      "			ELSE TO_CHAR(cir.dateinvoiced,'dd/MM/yyyy')" +
      "		END = ?" +
      "		AND sccc_cash_clousure_ID=?" +
      "		AND  P.STATUS<>'RPR') x " +
      "	group by fechat,doc,caja,cliente,mpago,tdoc,cd,grupo,cgrupo,texto" +
      "	UNION" +
      "	SELECT fechat,caja,doc,cliente,mpago,tdoc,sum(total),cd,grupo,cgrupo,texto from (" +
      "	SELECT TO_CHAR(p.paymentdate,'dd/MM/yyyy') as fechat" +
      "		, sccc_cash_clousure_id as caja" +
      "		, p.documentno as doc" +
      "		, CASE WHEN P.STATUS = 'RPVOID' THEN 'ANULADO' ELSE bp.name END as cliente" +
      "		, pm.name as mpago" +
      "		, dt.name as tdoc,'' as factura" +
      "		, sum(COALESCE(CASE WHEN (round(p.amount,3)=0 AND p.status<>'RPR') THEN psd.amount" +
      "			WHEN (round(p.amount,3)=0 AND p.status='RPR') THEN 0" +
      "			WHEN round(psd.amount,3)<round(p.amount,3)  THEN psd.amount" +
      "			WHEN P.STATUS = 'RPVOID' Then 0" +
      "			ELSE p.amount" +
      "		END,0)) as total" +
      "		, true as cd" +
      "		, 'OTROS COBROS Y ANTICIPOS' as grupo" +
      "		, 3 as cgrupo" +
      "		, 'Total  Otros Cobros' as texto" +
      "	FROM FIN_Payment p" +
      "		left Join c_bpartner bp on bp.c_bpartner_id = p.c_bpartner_id" +
      "		left Join FIN_Paymentmethod pm on pm.FIN_Paymentmethod_ID = p.FIN_Paymentmethod_ID" +
      "		left Join C_DocType dt on dt.C_DocType_id = p.C_DocType_id" +
      "		left join fin_payment_detail pd on p.FIN_Payment_id=pd.FIN_Payment_id" +
      "		left join fin_payment_scheduledetail psd on pd.fin_payment_detail_id=psd.fin_payment_detail_id" +
      "		left join FIN_Payment_Schedule ps on psd.fin_payment_schedule_invoice=ps.fin_payment_schedule_id" +
      "		left join c_invoice ci on ci.c_invoice_id=ps.c_invoice_id" +
      "		left Join c_invoice cir on cir.c_invoice_id = ci.em_scnr_invoice_id" +
      "		inner join ad_org org on org.ad_org_id=p.ad_org_id" +
      "		inner join Sccc_Setup ss on ss.ad_org_id=p.ad_org_id" +
      "		inner join Ssccso_Type_Of_Document sd on sd.Sccc_Setup_ID = ss.Sccc_Setup_ID AND dt.C_DocType_id=sd.C_DocType_id" +
      "		inner join sccc_cash_clousure cc on cc.Sccc_Setup_ID=ss.Sccc_Setup_ID" +
      "		WHERE (ci.dateinvoiced::date<>p.paymentdate::date or cir.dateinvoiced::date<>p.paymentdate::date)" +
      "			AND (P.STATUS<>'RPAP') AND p.paymentdate=cc.Closingdate::date" +
      "		AND TO_CHAR(p.paymentdate,'dd/MM/yyyy')=?" +
      "		AND sccc_cash_clousure_ID=?" +
      "		GROUP BY fechat,doc,cliente,caja,mpago,tdoc" +
      "	UNION" +
      "	SELECT TO_CHAR(p.paymentdate,'dd/MM/yyyy') as fechat" +
      "		, sccc_cash_clousure_id as caja" +
      "		, p.documentno as doc" +
      "		, bp.name as cliente" +
      "		, pm.name as mpago" +
      "		, dt.name as tdoc,'' as factura" +
      "		, sum(CASE WHEN (round(p.amount,3)=0 AND p.status<>'RPR') THEN psd.amount" +
      "			WHEN (round(p.amount,3)=0 AND p.status='RPR') THEN 0" +
      "			WHEN round(psd.amount,3)<round(p.amount,3)  THEN psd.amount" +
      "			ELSE p.amount" +
      "		END) as total" +
      "		, true as cd" +
      "		, 'OTROS COBROS Y ANTICIPOS' as grupo" +
      "		, 3 as cgrupo" +
      "		, 'Total  Otros Cobros' as texto" +
      "	FROM FIN_Payment p" +
      "		left Join c_bpartner bp on bp.c_bpartner_id = p.c_bpartner_id" +
      "		left Join FIN_Paymentmethod pm on pm.FIN_Paymentmethod_ID = p.FIN_Paymentmethod_ID" +
      "		left Join C_DocType dt on dt.C_DocType_id = p.C_DocType_id" +
      "		left join fin_payment_detail pd on p.FIN_Payment_id=pd.FIN_Payment_id" +
      "		left join fin_payment_scheduledetail psd on pd.fin_payment_detail_id=psd.fin_payment_detail_id" +
      "		left join FIN_Payment_Schedule ps on psd.fin_payment_schedule_invoice=ps.fin_payment_schedule_id" +
      "		left join c_invoice ci on ci.c_invoice_id=ps.c_invoice_id" +
      "		left Join c_invoice cir on cir.c_invoice_id = ci.em_scnr_invoice_id" +
      "		inner join ad_org org on org.ad_org_id=p.ad_org_id" +
      "		inner join Sccc_Setup ss on ss.ad_org_id=p.ad_org_id" +
      "		inner join Ssccso_Type_Of_Document sd on sd.Sccc_Setup_ID = ss.Sccc_Setup_ID AND dt.C_DocType_id=sd.C_DocType_id" +
      "		inner join sccc_cash_clousure cc on cc.Sccc_Setup_ID=ss.Sccc_Setup_ID" +
      "	WHERE  (ci.c_invoice_id is null AND cir.c_invoice_id is null)" +
      "		AND P.STATUS<>'RPVOID' AND  P.STATUS<>'RPAP'" +
      "		AND round(p.generated_credit,4)>0 AND p.paymentdate=cc.Closingdate::date" +
      "		AND TO_CHAR(p.paymentdate,'dd/MM/yyyy')=?" +
      "		AND sccc_cash_clousure_ID=? " +
      "	GROUP BY fechat,doc,cliente,caja,mpago,tdoc ) x  " +
      "	GROUP BY fechat,doc,cliente,caja,mpago,tdoc,cd,grupo,cgrupo,texto ) x";

    ResultSet result;
    Vector<CloseCashValdtData> vector = new Vector<CloseCashValdtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noDoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noDoc2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noDoc3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noDoc4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noDoc5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noDoc6);

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
        CloseCashValdtData objectCloseCashValdtData = new CloseCashValdtData();
        objectCloseCashValdtData.fechat = UtilSql.getValue(result, "fechat");
        objectCloseCashValdtData.caja = UtilSql.getValue(result, "caja");
        objectCloseCashValdtData.doc = UtilSql.getValue(result, "doc");
        objectCloseCashValdtData.cliente = UtilSql.getValue(result, "cliente");
        objectCloseCashValdtData.mpago = UtilSql.getValue(result, "mpago");
        objectCloseCashValdtData.tdoc = UtilSql.getValue(result, "tdoc");
        objectCloseCashValdtData.sum = UtilSql.getValue(result, "sum");
        objectCloseCashValdtData.cd = UtilSql.getValue(result, "cd");
        objectCloseCashValdtData.grupo = UtilSql.getValue(result, "grupo");
        objectCloseCashValdtData.cgrupo = UtilSql.getValue(result, "cgrupo");
        objectCloseCashValdtData.texto = UtilSql.getValue(result, "texto");
        objectCloseCashValdtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCloseCashValdtData);
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
    CloseCashValdtData objectCloseCashValdtData[] = new CloseCashValdtData[vector.size()];
    vector.copyInto(objectCloseCashValdtData);
    return(objectCloseCashValdtData);
  }
}

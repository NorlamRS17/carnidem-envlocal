//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.finance.reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class InitialBalanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(InitialBalanceData.class);
  private String InitRecordNumber="0";
  public String ibalance;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ibalance"))
      return ibalance;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InitialBalanceData[] select(ConnectionProvider connectionProvider, String issotrx, String bpartnerId, String dateFrom, String accountids)    throws ServletException {
    return select(connectionProvider, issotrx, bpartnerId, dateFrom, accountids, 0, 0);
  }

  public static InitialBalanceData[] select(ConnectionProvider connectionProvider, String issotrx, String bpartnerId, String dateFrom, String accountids, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select sum(abs(debit) - abs(credit)) as ibalance " +
      "	           from (" +
      "				select fa.amtacctdr as debit , fa.amtacctcr as credit" +
      "				 from fact_acct fa " +
      "				  inner join c_invoice ci on ci.c_invoice_id = fa.record_id " +
      "				  inner join c_doctype cd on cd.c_doctype_id = ci.c_doctype_id" +
      "				  inner join (select fps3.ExpectedDate, fps3.c_invoice_id " +
      "								from fin_payment_schedule fps3" +
      "							   where fps3.ExpectedDate = (select max(ExpectedDate) " +
      "								 from fin_payment_schedule fps4 where fps4.c_invoice_id = fps3.c_invoice_id )) as fpi on fpi.c_invoice_id = ci.c_invoice_id" +
      "				  where fa.ad_table_id = '318' " +
      "				     and ci.issotrx = ? " +
      "				     and ci.c_bpartner_id = ?" +
      "				     and ci.dateinvoiced < TO_DATE(?)" +
      "					 and (fa.account_id in (";
    strSql = strSql + ((accountids==null || accountids.equals(""))?"":accountids);
    strSql = strSql + 
      "))" +
      "				 union" +
      "				 select fa2.amtacctdr as debit , fa2.amtacctcr as credit" +
      "				   from fact_acct fa2 " +
      "					inner join fin_payment fp on fp.fin_payment_id = fa2.record_id" +
      "					inner join fin_payment_detail fpd on fpd.fin_payment_id  = fp.fin_payment_id " +
      "					inner join fin_payment_scheduledetail fps on fps.fin_payment_detail_id = fpd.fin_payment_detail_id " +
      "					left join fin_payment_schedule fps2 on fps2.fin_payment_schedule_id = fps.fin_payment_schedule_invoice " +
      "					left join c_invoice ci2 on ci2.c_invoice_id = fps2.c_invoice_id " +
      "				   where fa2.ad_table_id = 'D1A97202E832470285C9B1EB026D54E2' " +
      "				        and fp.isReceipt = ? " +
      "				        and fp.c_bpartner_id = ?" +
      "				        and fp.paymentdate < TO_DATE(?)" +
      "					    and (fa2.account_id in (";
    strSql = strSql + ((accountids==null || accountids.equals(""))?"":accountids);
    strSql = strSql + 
      "))" +
      "						and case when ci2.em_scnr_isref_inv = 'Y' " +
      "					             then not exists( select 1 " +
      "                                                     from fin_payment fp01 " +
      "		                                              inner join fin_payment_detail fpd01 on fpd01.fin_payment_id  = fp01.fin_payment_id " +
      "													  inner join fin_payment_scheduledetail fps01 on fps01.fin_payment_detail_id = fpd01.fin_payment_detail_id " +
      "													  inner join fin_payment_schedule fps201 on fps201.fin_payment_schedule_id = fps01.fin_payment_schedule_invoice" +
      "													  inner join c_invoice ci201 on ci201.c_invoice_id = fps201.c_invoice_id" +
      "												   	 where fp01.fin_payment_id = fp.fin_payment_id and ci201.c_invoice_id <> ci2.c_invoice_id  and ci201.em_scnr_isref_inv = 'N'" +
      "													)" +
      "					             else not exists (select 1 " +
      "                                                   from fin_payment fp02 " +
      "                                                     inner join fin_payment_detail fpd02 on fpd02.fin_payment_id  = fp02.fin_payment_id " +
      "													 inner join fin_payment_scheduledetail fps02 on fps02.fin_payment_detail_id = fpd02.fin_payment_detail_id " +
      "													 inner join fin_payment_schedule fps202 on fps202.fin_payment_schedule_id = fps02.fin_payment_schedule_invoice" +
      "													 inner join c_invoice ci202 on ci202.c_invoice_id = fps202.c_invoice_id" +
      "												    where fp02.fin_payment_id = fp.fin_payment_id and ci202.c_invoice_id <> ci2.c_invoice_id  and ci202.em_scnr_isref_inv = 'Y') end  " +
      "													group by fa2.amtacctdr, fa2.amtacctcr, fa2.account_id" +
      "				union " +
      "			select fa3.amtacctdr as debit, fa3.amtacctcr as credit" +
      "			  from fact_acct fa3" +
      "			   inner join SSWS_WithholdingSale wh on wh.ssws_withholdingsale_id  = fa3.record_id " +
      "			   inner join c_invoice ci3 on ci3.c_invoice_id = wh.c_invoice_id " +
      "			   left  join (select fps3.Duedate as ExpectedDate, fps3.c_invoice_id " +
      "							from fin_payment_schedule fps3" +
      "						   where fps3.Duedate = (select max(Duedate) " +
      "							 from fin_payment_schedule fps4 where fps4.c_invoice_id = fps3.c_invoice_id )) as fpi1 on fpi1.c_invoice_id = ci3.c_invoice_id" +
      "			where fa3.ad_table_id = '211492B753264EAEBE328BA4FED1F066'   " +
      "			 and ci3.issotrx = ?" +
      "			 and ci3.c_bpartner_id = ?" +
      "			 and ci3.dateinvoiced  <= TO_DATE(?)  " +
      "			 and (fa3.account_id in (";
    strSql = strSql + ((accountids==null || accountids.equals(""))?"":accountids);
    strSql = strSql + 
      "))					 " +
      "			) as  pp      ";

    ResultSet result;
    Vector<InitialBalanceData> vector = new Vector<InitialBalanceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (accountids != null && !(accountids.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (accountids != null && !(accountids.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      if (accountids != null && !(accountids.equals(""))) {
        }

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
        InitialBalanceData objectInitialBalanceData = new InitialBalanceData();
        objectInitialBalanceData.ibalance = UtilSql.getValue(result, "ibalance");
        objectInitialBalanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInitialBalanceData);
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
    InitialBalanceData objectInitialBalanceData[] = new InitialBalanceData[vector.size()];
    vector.copyInto(objectInitialBalanceData);
    return(objectInitialBalanceData);
  }
}

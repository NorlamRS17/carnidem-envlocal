//Sqlc generated V1.O00-1
package ec.com.sidesoft.app.production.quality.webservices;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SsapqDataCollectionProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(SsapqDataCollectionProductData.class);
  private String InitRecordNumber="0";
  public String turn;
  public String qualityControl;
  public String typeControl;
  public String manufacturingOrder;
  public String documentno;
  public String finishingProduct;
  public String prodStarttime;
  public String productionLeader;
  public String qualityAnalyst;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("turn"))
      return turn;
    else if (fieldName.equalsIgnoreCase("quality_control") || fieldName.equals("qualityControl"))
      return qualityControl;
    else if (fieldName.equalsIgnoreCase("type_control") || fieldName.equals("typeControl"))
      return typeControl;
    else if (fieldName.equalsIgnoreCase("manufacturing_order") || fieldName.equals("manufacturingOrder"))
      return manufacturingOrder;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("finishing_product") || fieldName.equals("finishingProduct"))
      return finishingProduct;
    else if (fieldName.equalsIgnoreCase("prod_starttime") || fieldName.equals("prodStarttime"))
      return prodStarttime;
    else if (fieldName.equalsIgnoreCase("production_leader") || fieldName.equals("productionLeader"))
      return productionLeader;
    else if (fieldName.equalsIgnoreCase("quality_analyst") || fieldName.equals("qualityAnalyst"))
      return qualityAnalyst;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SsapqDataCollectionProductData[] dataProduct(ConnectionProvider connectionProvider)    throws ServletException {
    return dataProduct(connectionProvider, 0, 0);
  }

  public static SsapqDataCollectionProductData[] dataProduct(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT" +
      "		    tr.name AS turn," +
      "		    qc.name AS quality_control," +
      "		    cg.name AS type_control," +
      "		    CONCAT_WS(' - ', wq.DocumentNo, pp.value, pp.name) AS manufacturing_order," +
      "		    pdt.documentno AS documentno," +
      "		    CONCAT_WS(' - ', mpd.value, mpd.name) AS finishing_product," +
      "		    TO_CHAR(ms.EM_Spquly_Starttime, 'HH24:MI:SS') AS prod_starttime," +
      "		    CONCAT_WS(' - ', bpt.value, bpt.name) AS production_leader," +
      "		    CONCAT_WS(' - ', bpta.value, bpta.name) AS quality_analyst" +
      "		FROM" +
      "		    MA_Measure_Shift ms" +
      "		    LEFT JOIN ma_ccp_group cg ON cg.ma_ccp_group_id = ms.EM_Spquly_Ccp_ID" +
      "		    LEFT JOIN ma_workrequirement wq ON wq.ma_workrequirement_id = ms.EM_Spquly_Workreq_ID" +
      "		    LEFT JOIN ma_processplan pp ON pp.ma_processplan_id = wq.ma_processplan_id" +
      "		    LEFT JOIN m_production pdt ON pdt.m_production_id = ms.em_spquly_workeffort_id" +
      "		    LEFT JOIN m_product mpd ON mpd.m_product_id = ms.em_spquly_finishedprod_id" +
      "		    LEFT JOIN c_bpartner bpt ON bpt.c_bpartner_id = em_spquly_prodleader_id" +
      "		    LEFT JOIN c_bpartner bpta ON bpta.c_bpartner_id = em_spquly_qanalyst_id" +
      "		    LEFT JOIN (" +
      "		        SELECT" +
      "		            rlt.name," +
      "		            rl.value" +
      "		        FROM" +
      "		            ad_ref_list rl" +
      "		            LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id = rlt.ad_ref_list_id" +
      "		        WHERE" +
      "		            ad_reference_id = '800038') tr ON tr.value = ms.Shift" +
      "		    LEFT JOIN (" +
      "		        SELECT" +
      "		            rlt.name," +
      "		            rl.value" +
      "		        FROM" +
      "		            ad_ref_list rl" +
      "		            LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id = rlt.ad_ref_list_id" +
      "		        WHERE" +
      "		            ad_reference_id = '209EBF768B314A8D86D78725A82D7F46') qc ON qc.value = ms.EM_Spquly_Qualitycontroltype" +
      "		WHERE" +
      "		    ms.EM_Spquly_Qualitycontroltype = 'FPQ'" +
      "		ORDER BY" +
      "		    tr.name";

    ResultSet result;
    Vector<SsapqDataCollectionProductData> vector = new Vector<SsapqDataCollectionProductData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        SsapqDataCollectionProductData objectSsapqDataCollectionProductData = new SsapqDataCollectionProductData();
        objectSsapqDataCollectionProductData.turn = UtilSql.getValue(result, "turn");
        objectSsapqDataCollectionProductData.qualityControl = UtilSql.getValue(result, "quality_control");
        objectSsapqDataCollectionProductData.typeControl = UtilSql.getValue(result, "type_control");
        objectSsapqDataCollectionProductData.manufacturingOrder = UtilSql.getValue(result, "manufacturing_order");
        objectSsapqDataCollectionProductData.documentno = UtilSql.getValue(result, "documentno");
        objectSsapqDataCollectionProductData.finishingProduct = UtilSql.getValue(result, "finishing_product");
        objectSsapqDataCollectionProductData.prodStarttime = UtilSql.getValue(result, "prod_starttime");
        objectSsapqDataCollectionProductData.productionLeader = UtilSql.getValue(result, "production_leader");
        objectSsapqDataCollectionProductData.qualityAnalyst = UtilSql.getValue(result, "quality_analyst");
        objectSsapqDataCollectionProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsapqDataCollectionProductData);
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
    SsapqDataCollectionProductData objectSsapqDataCollectionProductData[] = new SsapqDataCollectionProductData[vector.size()];
    vector.copyInto(objectSsapqDataCollectionProductData);
    return(objectSsapqDataCollectionProductData);
  }
}

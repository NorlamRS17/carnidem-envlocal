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

public class SsapqDataCollectionData implements FieldProvider {
static Logger log4j = Logger.getLogger(SsapqDataCollectionData.class);
  private String InitRecordNumber="0";
  public String status;
  public String turn;
  public String qualityControl;
  public String typeControl;
  public String supplier;
  public String supplierInout;
  public String material;
  public String deliveryDate;
  public String totalMaterial;
  public String lote;
  public String exteriorCleaning;
  public String interiorCleaning;
  public String protectContamination;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("turn"))
      return turn;
    else if (fieldName.equalsIgnoreCase("quality_control") || fieldName.equals("qualityControl"))
      return qualityControl;
    else if (fieldName.equalsIgnoreCase("type_control") || fieldName.equals("typeControl"))
      return typeControl;
    else if (fieldName.equalsIgnoreCase("supplier"))
      return supplier;
    else if (fieldName.equalsIgnoreCase("supplier_inout") || fieldName.equals("supplierInout"))
      return supplierInout;
    else if (fieldName.equalsIgnoreCase("material"))
      return material;
    else if (fieldName.equalsIgnoreCase("delivery_date") || fieldName.equals("deliveryDate"))
      return deliveryDate;
    else if (fieldName.equalsIgnoreCase("total_material") || fieldName.equals("totalMaterial"))
      return totalMaterial;
    else if (fieldName.equalsIgnoreCase("lote"))
      return lote;
    else if (fieldName.equalsIgnoreCase("exterior_cleaning") || fieldName.equals("exteriorCleaning"))
      return exteriorCleaning;
    else if (fieldName.equalsIgnoreCase("interior_cleaning") || fieldName.equals("interiorCleaning"))
      return interiorCleaning;
    else if (fieldName.equalsIgnoreCase("protect_contamination") || fieldName.equals("protectContamination"))
      return protectContamination;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SsapqDataCollectionData[] dataCollection(ConnectionProvider connectionProvider)    throws ServletException {
    return dataCollection(connectionProvider, 0, 0);
  }

  public static SsapqDataCollectionData[] dataCollection(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT" +
      "		    st.name AS status," +
      "		    tr.name AS turn," +
      "		    qc.name AS quality_control," +
      "		    cg.name AS type_control," +
      "		    CONCAT_WS(' - ', cbp.taxid, cbp.name) AS supplier," +
      "		    CONCAT_WS(' - ', io.documentno, TRUNC(io.MovementDate), cbp.name) AS supplier_inout," +
      "		    CONCAT_WS(' - ', pd.value, pd.name) AS material," +
      "		    TRUNC(io.MovementDate) AS delivery_date," +
      "		    ms.EM_Spquly_Totalqty AS total_material," +
      "		    atb.description AS lote," +
      "		    exc.name AS exterior_cleaning," +
      "		    itc.name AS interior_cleaning," +
      "		    ptc.name AS protect_contamination" +
      "		FROM" +
      "		    MA_Measure_Shift ms" +
      "		    LEFT JOIN ma_ccp_group cg ON cg.ma_ccp_group_id = ms.EM_Spquly_Ccp_ID" +
      "		    LEFT JOIN (" +
      "		        SELECT" +
      "		            rlt.name," +
      "		            rl.value" +
      "		        FROM" +
      "		            ad_ref_list rl" +
      "		            LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id = rlt.ad_ref_list_id" +
      "		        WHERE" +
      "		            ad_reference_id = 'A05C9373FCCB4AD9AC75D95DEAC358DA') st ON st.value = ms.EM_Ssfdc_Status" +
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
      "		    LEFT JOIN c_bpartner cbp ON cbp.c_bpartner_id = ms.em_spquly_supplier_id" +
      "		    LEFT JOIN m_inout io ON io.m_inout_id = ms.EM_Spquly_Inout_ID" +
      "		    LEFT JOIN c_bpartner cbpi ON cbpi.c_bpartner_id = io.c_bpartner_id" +
      "		    LEFT JOIN m_product pd ON pd.m_product_id = ms.EM_Spquly_Product_ID" +
      "		    LEFT JOIN m_attributesetinstance atb ON atb.m_attributesetinstance_id = ms.EM_Spquly_Attrsi_ID" +
      "		    LEFT JOIN (" +
      "		        SELECT" +
      "		            rlt.name," +
      "		            rl.value" +
      "		        FROM" +
      "		            ad_ref_list rl" +
      "		            LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id = rlt.ad_ref_list_id" +
      "		        WHERE" +
      "		            ad_reference_id = 'DE5CDC5D3265477AAECB1A73220331FD') exc ON exc.value = ms.EM_Spquly_Outsidecleanliness" +
      "		    LEFT JOIN (" +
      "		        SELECT" +
      "		            rlt.name," +
      "		            rl.value" +
      "		        FROM" +
      "		            ad_ref_list rl" +
      "		            LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id = rlt.ad_ref_list_id" +
      "		        WHERE" +
      "		            ad_reference_id = 'DE5CDC5D3265477AAECB1A73220331FD') itc ON itc.value = ms.EM_Spquly_Insidecleanliness" +
      "		    LEFT JOIN (" +
      "		        SELECT" +
      "		            rlt.name," +
      "		            rl.value" +
      "		        FROM" +
      "		            ad_ref_list rl" +
      "		            LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id = rlt.ad_ref_list_id" +
      "		        WHERE" +
      "		            ad_reference_id = 'DE5CDC5D3265477AAECB1A73220331FD') ptc ON ptc.value = ms.EM_Spquly_Protectionpollution" +
      "		WHERE" +
      "		    ms.EM_Spquly_Qualitycontroltype = 'RMQ'" +
      "		ORDER BY" +
      "		    tr.name";

    ResultSet result;
    Vector<SsapqDataCollectionData> vector = new Vector<SsapqDataCollectionData>(0);
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
        SsapqDataCollectionData objectSsapqDataCollectionData = new SsapqDataCollectionData();
        objectSsapqDataCollectionData.status = UtilSql.getValue(result, "status");
        objectSsapqDataCollectionData.turn = UtilSql.getValue(result, "turn");
        objectSsapqDataCollectionData.qualityControl = UtilSql.getValue(result, "quality_control");
        objectSsapqDataCollectionData.typeControl = UtilSql.getValue(result, "type_control");
        objectSsapqDataCollectionData.supplier = UtilSql.getValue(result, "supplier");
        objectSsapqDataCollectionData.supplierInout = UtilSql.getValue(result, "supplier_inout");
        objectSsapqDataCollectionData.material = UtilSql.getValue(result, "material");
        objectSsapqDataCollectionData.deliveryDate = UtilSql.getDateValue(result, "delivery_date", "dd-MM-yyyy");
        objectSsapqDataCollectionData.totalMaterial = UtilSql.getValue(result, "total_material");
        objectSsapqDataCollectionData.lote = UtilSql.getValue(result, "lote");
        objectSsapqDataCollectionData.exteriorCleaning = UtilSql.getValue(result, "exterior_cleaning");
        objectSsapqDataCollectionData.interiorCleaning = UtilSql.getValue(result, "interior_cleaning");
        objectSsapqDataCollectionData.protectContamination = UtilSql.getValue(result, "protect_contamination");
        objectSsapqDataCollectionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsapqDataCollectionData);
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
    SsapqDataCollectionData objectSsapqDataCollectionData[] = new SsapqDataCollectionData[vector.size()];
    vector.copyInto(objectSsapqDataCollectionData);
    return(objectSsapqDataCollectionData);
  }
}

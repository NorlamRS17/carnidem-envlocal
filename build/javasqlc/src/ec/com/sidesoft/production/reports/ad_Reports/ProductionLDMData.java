//Sqlc generated V1.O00-1
package ec.com.sidesoft.production.reports.ad_Reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ProductionLDMData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductionLDMData.class);
  private String InitRecordNumber="0";
  public String mProductionId;
  public String mProductionplanId;
  public String mProductId;
  public String documentno;
  public String adOrgId;
  public String movementdate;
  public String tipodoc;
  public String categoria;
  public String codProducto;
  public String producto;
  public String cantidad;
  public String unidad;
  public String costototal;
  public String costounitario;
  public String puntoventa;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_production_id") || fieldName.equals("mProductionId"))
      return mProductionId;
    else if (fieldName.equalsIgnoreCase("m_productionplan_id") || fieldName.equals("mProductionplanId"))
      return mProductionplanId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("tipodoc"))
      return tipodoc;
    else if (fieldName.equalsIgnoreCase("categoria"))
      return categoria;
    else if (fieldName.equalsIgnoreCase("cod_producto") || fieldName.equals("codProducto"))
      return codProducto;
    else if (fieldName.equalsIgnoreCase("producto"))
      return producto;
    else if (fieldName.equalsIgnoreCase("cantidad"))
      return cantidad;
    else if (fieldName.equalsIgnoreCase("unidad"))
      return unidad;
    else if (fieldName.equalsIgnoreCase("costototal"))
      return costototal;
    else if (fieldName.equalsIgnoreCase("costounitario"))
      return costounitario;
    else if (fieldName.equalsIgnoreCase("puntoventa"))
      return puntoventa;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductionLDMData[] select(ConnectionProvider connectionProvider, String AD_ORG_ID, String DATEFROM, String DATETO, String C_DOCTYPE_ID, String M_PRODUCT_CATEGORY_ID, String M_PRODUCT_ID)    throws ServletException {
    return select(connectionProvider, AD_ORG_ID, DATEFROM, DATETO, C_DOCTYPE_ID, M_PRODUCT_CATEGORY_ID, M_PRODUCT_ID, 0, 0);
  }

  public static ProductionLDMData[] select(ConnectionProvider connectionProvider, String AD_ORG_ID, String DATEFROM, String DATETO, String C_DOCTYPE_ID, String M_PRODUCT_CATEGORY_ID, String M_PRODUCT_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select a.m_production_id," +
      "b.m_productionplan_id," +
      "b.m_product_id," +
      "a.documentno," +
      "a.ad_org_id," +
      "a.MovementDate," +
      "c.name as tipodoc," +
      "j.name as categoria," +
      "d.value as cod_producto," +
      "d.name as producto," +
      "b.productionqty as cantidad," +
      "coalesce(f.name,e.name) as unidad," +
      "sum(i.cost) as costototal," +
      "sum(i.cost)/b.productionqty as costounitario ," +
      "k.name as puntoventa   " +
      "from m_production a    " +
      "left join m_productionplan b on a.m_production_id = b.m_production_id    " +
      "left join c_doctype c on a.em_spdai_c_doctype_id = c.c_doctype_id    " +
      "left join m_product d on b.m_product_id = d.m_product_id    " +
      "left join c_uom e on d.c_uom_id = e.c_uom_id    " +
      "left join c_uom_trl f on e.c_uom_id = f.c_uom_id    " +
      "left join m_productionline g on b.m_productionplan_id = g.m_productionplan_id and g.movementqty = b.productionqty      " +
      "left join m_transaction h on g.m_productionline_id = h.m_productionline_id and h.movementqty = b.productionqty         " +
      "left join m_transaction_cost i on h.m_transaction_id = i.m_transaction_id    " +
      "left join M_product_category j on d.M_product_category_id = j.M_product_category_id        " +
      "LEFT JOIN AD_ORG k on a.ad_org_id = k.ad_org_id    " +
      "where a.ad_org_id = ?    " +
      "and (a.MovementDate between ? and ?)    " +
      "and ( a.em_spdai_c_doctype_id = ? or ? is null)    " +
      "and ( d.M_product_category_id = ? or ? is null)    " +
      "and ( b.m_product_id = ? or ? is null)      " +
      "group by a.m_production_id,b.m_productionplan_id,b.m_product_id,a.documentno,d.value,d.name,b.productionqty,coalesce(f.name,e.name) ,c.name,j.name,k.name        " +
      "order by 1,2,3";

    ResultSet result;
    Vector<ProductionLDMData> vector = new Vector<ProductionLDMData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ORG_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DATEFROM);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DATETO);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DOCTYPE_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_DOCTYPE_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCT_CATEGORY_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCT_CATEGORY_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCT_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCT_ID);

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
        ProductionLDMData objectProductionLDMData = new ProductionLDMData();
        objectProductionLDMData.mProductionId = UtilSql.getValue(result, "m_production_id");
        objectProductionLDMData.mProductionplanId = UtilSql.getValue(result, "m_productionplan_id");
        objectProductionLDMData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductionLDMData.documentno = UtilSql.getValue(result, "documentno");
        objectProductionLDMData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductionLDMData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectProductionLDMData.tipodoc = UtilSql.getValue(result, "tipodoc");
        objectProductionLDMData.categoria = UtilSql.getValue(result, "categoria");
        objectProductionLDMData.codProducto = UtilSql.getValue(result, "cod_producto");
        objectProductionLDMData.producto = UtilSql.getValue(result, "producto");
        objectProductionLDMData.cantidad = UtilSql.getValue(result, "cantidad");
        objectProductionLDMData.unidad = UtilSql.getValue(result, "unidad");
        objectProductionLDMData.costototal = UtilSql.getValue(result, "costototal");
        objectProductionLDMData.costounitario = UtilSql.getValue(result, "costounitario");
        objectProductionLDMData.puntoventa = UtilSql.getValue(result, "puntoventa");
        objectProductionLDMData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionLDMData);
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
    ProductionLDMData objectProductionLDMData[] = new ProductionLDMData[vector.size()];
    vector.copyInto(objectProductionLDMData);
    return(objectProductionLDMData);
  }
}

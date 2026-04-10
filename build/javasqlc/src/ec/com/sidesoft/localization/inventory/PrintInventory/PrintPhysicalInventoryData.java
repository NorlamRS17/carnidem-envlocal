//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.inventory.PrintInventory;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PrintPhysicalInventoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintPhysicalInventoryData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String fechamovimiento;
  public String documentno;
  public String documentnoN;
  public String tipodoc;
  public String codigobarras;
  public String producto;
  public String clasecontable;
  public String unidad;
  public String costolinea;
  public String costolineaAbs;
  public String cantidad;
  public String importe;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("fechamovimiento"))
      return fechamovimiento;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("documentno_n") || fieldName.equals("documentnoN"))
      return documentnoN;
    else if (fieldName.equalsIgnoreCase("tipodoc"))
      return tipodoc;
    else if (fieldName.equalsIgnoreCase("codigobarras"))
      return codigobarras;
    else if (fieldName.equalsIgnoreCase("producto"))
      return producto;
    else if (fieldName.equalsIgnoreCase("clasecontable"))
      return clasecontable;
    else if (fieldName.equalsIgnoreCase("unidad"))
      return unidad;
    else if (fieldName.equalsIgnoreCase("costolinea"))
      return costolinea;
    else if (fieldName.equalsIgnoreCase("costolinea_abs") || fieldName.equals("costolineaAbs"))
      return costolineaAbs;
    else if (fieldName.equalsIgnoreCase("cantidad"))
      return cantidad;
    else if (fieldName.equalsIgnoreCase("importe"))
      return importe;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PrintPhysicalInventoryData[] select(ConnectionProvider connectionProvider, String inventoryid)    throws ServletException {
    return select(connectionProvider, inventoryid, 0, 0);
  }

  public static PrintPhysicalInventoryData[] select(ConnectionProvider connectionProvider, String inventoryid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select a.ad_org_id as organizationid," +
      "to_char(a.movementdate,'dd-MM-yyyy') as fechamovimiento," +
      "a.documentno," +
      "a.em_ssin_documentno as documentno_n," +
      "d.name as tipodoc," +
      "c.upc as codigobarras," +
      "c.name as producto," +
      "e.value|| '/' ||e.name as clasecontable," +
      "f.name as unidad," +
      "coalesce(b.cost,round((g.TransactionCost/g.movementqty),4)) as costolinea," +
      "case when (coalesce(b.cost,round((g.TransactionCost/g.movementqty),4)))<0 then (coalesce(b.cost,round((g.TransactionCost/g.movementqty),4))) * (-1)  else (coalesce(b.cost,round((g.TransactionCost/g.movementqty),4))) end as costolinea_abs," +
      "g.movementqty as cantidad," +
      "g.TransactionCost as importe," +
      "a.description From M_Inventory a left join M_InventoryLine b on a.M_Inventory_id = b.M_Inventory_id" +
      "    left join m_product c on b.m_product_id = c.m_product_id" +
      "    left join c_doctype d on a.em_ssin_doctype_id = d.c_doctype_id" +
      "    left join m_product_category e on c.m_product_category_id = e.m_product_category_id" +
      "    left join c_uom f on c.c_uom_id = f.c_uom_id        " +
      "    left join m_transaction g on b.M_InventoryLine_id = g.M_InventoryLine_id WHERE a.M_Inventory_id = ? order by a.ad_org_id,a.documentno,e.value|| '/' ||e.name,c.name";

    ResultSet result;
    Vector<PrintPhysicalInventoryData> vector = new Vector<PrintPhysicalInventoryData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inventoryid);

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
        PrintPhysicalInventoryData objectPrintPhysicalInventoryData = new PrintPhysicalInventoryData();
        objectPrintPhysicalInventoryData.organizationid = UtilSql.getValue(result, "organizationid");
        objectPrintPhysicalInventoryData.fechamovimiento = UtilSql.getValue(result, "fechamovimiento");
        objectPrintPhysicalInventoryData.documentno = UtilSql.getValue(result, "documentno");
        objectPrintPhysicalInventoryData.documentnoN = UtilSql.getValue(result, "documentno_n");
        objectPrintPhysicalInventoryData.tipodoc = UtilSql.getValue(result, "tipodoc");
        objectPrintPhysicalInventoryData.codigobarras = UtilSql.getValue(result, "codigobarras");
        objectPrintPhysicalInventoryData.producto = UtilSql.getValue(result, "producto");
        objectPrintPhysicalInventoryData.clasecontable = UtilSql.getValue(result, "clasecontable");
        objectPrintPhysicalInventoryData.unidad = UtilSql.getValue(result, "unidad");
        objectPrintPhysicalInventoryData.costolinea = UtilSql.getValue(result, "costolinea");
        objectPrintPhysicalInventoryData.costolineaAbs = UtilSql.getValue(result, "costolinea_abs");
        objectPrintPhysicalInventoryData.cantidad = UtilSql.getValue(result, "cantidad");
        objectPrintPhysicalInventoryData.importe = UtilSql.getValue(result, "importe");
        objectPrintPhysicalInventoryData.description = UtilSql.getValue(result, "description");
        objectPrintPhysicalInventoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintPhysicalInventoryData);
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
    PrintPhysicalInventoryData objectPrintPhysicalInventoryData[] = new PrintPhysicalInventoryData[vector.size()];
    vector.copyInto(objectPrintPhysicalInventoryData);
    return(objectPrintPhysicalInventoryData);
  }

  public static PrintPhysicalInventoryData[] set()    throws ServletException {
    PrintPhysicalInventoryData objectPrintPhysicalInventoryData[] = new PrintPhysicalInventoryData[1];
    objectPrintPhysicalInventoryData[0] = new PrintPhysicalInventoryData();
    objectPrintPhysicalInventoryData[0].organizationid = "";
    objectPrintPhysicalInventoryData[0].fechamovimiento = "";
    objectPrintPhysicalInventoryData[0].documentno = "";
    objectPrintPhysicalInventoryData[0].documentnoN = "";
    objectPrintPhysicalInventoryData[0].tipodoc = "";
    objectPrintPhysicalInventoryData[0].codigobarras = "";
    objectPrintPhysicalInventoryData[0].producto = "";
    objectPrintPhysicalInventoryData[0].clasecontable = "";
    objectPrintPhysicalInventoryData[0].unidad = "";
    objectPrintPhysicalInventoryData[0].costolinea = "";
    objectPrintPhysicalInventoryData[0].costolineaAbs = "";
    objectPrintPhysicalInventoryData[0].cantidad = "";
    objectPrintPhysicalInventoryData[0].importe = "";
    objectPrintPhysicalInventoryData[0].description = "";
    return objectPrintPhysicalInventoryData;
  }
}

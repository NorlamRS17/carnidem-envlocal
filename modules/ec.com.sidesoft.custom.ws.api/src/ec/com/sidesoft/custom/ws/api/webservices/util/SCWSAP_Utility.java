package ec.com.sidesoft.custom.ws.api.webservices.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.service.db.DalConnectionProvider;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.sidesoft.custom.ws.api.utils.SCWSAP_Helper;

public class SCWSAP_Utility {

  private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
  // private static final Logger logger = Logger.getLogger(SCWSAP_Utility.class);

  static public List<JSONObject> getProducts(String updatedDate, String createdDate)
      throws Exception {

    List<JSONObject> products = new ArrayList<JSONObject>();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      ArrayList<String> arrayProductList = new ArrayList<String>();
      Connection conndb = conn.getTransactionConnection();

      if (updatedDate != null || createdDate != null) {
        String strSqlpl = null;
        strSqlpl = "SELECT  m_product_id FROM m_pricelist pl \n"
            + "JOIN m_pricelist_version l on l.m_pricelist_version_id=m_get_pricelist_version(pl.m_pricelist_id,now()::date)\n"
            + "JOIN m_productprice p on p.m_pricelist_version_id=l.m_pricelist_version_id\n"
            + "WHERE p.isactive = 'Y' AND pl.isactive = 'Y' AND pl.issopricelist='Y' ";
        if (updatedDate != null && !updatedDate.isEmpty()) {
          strSqlpl = strSqlpl + "AND pl.updated::date >= '" + updatedDate + "'::date\n";
        }
        if (createdDate != null && !createdDate.isEmpty()) {
          strSqlpl = strSqlpl + "AND pl.created::date >= '" + createdDate + "'::date\n";
        }
        strSqlpl = strSqlpl + "GROUP BY 1";

        PreparedStatement stpl = null;

        stpl = conndb.prepareStatement(strSqlpl);
        ResultSet rsConsultapl = stpl.executeQuery();
        while (rsConsultapl.next()) {
          arrayProductList.add(rsConsultapl.getString("m_product_id"));
        }
        // Close Connection
        conndb.close();
        // Close PreparedStatement
        stpl.close();
        // Close ResultSet
        rsConsultapl.close();
      }

      String productList = StringUtils.join(arrayProductList, ",");
      Connection connp = conn.getTransactionConnection();
      String strSql = null;

      strSql = "SELECT p.m_product_id, p.value as code, p.name \n"
          + " , u.name as unidad, pc.m_product_category_id , encode(i.binarydata, 'base64') as binarydata, mimetype,i.width \n"
          + " ,i.height, p.created as created0, stock.created as created1, pricelist.created as created2, \n"
          + " stock.updated as updated0, pricelist.updated as updated1, p.updated as updated2 \n"
          + " FROM m_product p \n"
          + " JOIN m_product_category pc on pc.m_product_category_id = p.m_product_category_id \n"
          + " LEFT JOIN ad_image i on i.ad_image_id = p.ad_image_id \n"
          + " LEFT JOIN c_uom_trl u on u.c_uom_id=p.c_uom_id AND ad_language='es_ES' \n"
          + " LEFT JOIN (\n"
          + " SELECT sum(msd.qtyonhand) as stock, max(msd.updated) as updated, max(msd.created) as created, m_product_id FROM m_storage_detail msd\n"
          + " JOIN m_locator ml on ml.m_locator_id=msd.m_locator_id\n"
          + " JOIN m_warehouse mw on mw.m_warehouse_id=ml.m_warehouse_id\n"
          + " WHERE mw.em_ssvs_virtualstorage='N' GROUP BY m_product_id\n"
          + " ) stock on stock.m_product_id = p.m_product_id\n"
          + " LEFT JOIN ( SELECT max(p.updated) as updated, max(p.created) as created, p.m_product_id FROM m_pricelist pl\n"
          + " JOIN m_pricelist_version l on l.m_pricelist_version_id=m_get_pricelist_version(pl.m_pricelist_id,now()::date)\n"
          + " JOIN m_productprice p on p.m_pricelist_version_id=l.m_pricelist_version_id\n"
          + " WHERE p.isactive = 'Y' AND pl.isactive = 'Y' AND pl.issopricelist='Y' GROUP BY p.m_product_id\n"
          + " ) pricelist on pricelist.m_product_id = p.m_product_id\n"
          + " WHERE p.isactive='Y' AND em_scwsap_available_app_orders='Y' \n";
      if (updatedDate != null && !updatedDate.isEmpty()) {
        strSql = strSql + "AND p.updated::date >= '" + updatedDate + "'::date\n";
        if (!productList.isEmpty()) {
          strSql = strSql + "OR m_product_id in (select a from regexp_split_to_table('"
              + productList + "',',') a)\n";
        }
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        strSql = strSql + "AND p.created::date >= '" + createdDate + "'::date\n";
        if (!productList.isEmpty()) {
          strSql = strSql + "OR m_product_id in (select a from regexp_split_to_table('"
              + productList + "',',') a)\n";
        }
      }

      PreparedStatement st = null;

      st = connp.prepareStatement(strSql);
      ResultSet rsConsulta = st.executeQuery();

      while (rsConsulta.next()) {
        JSONObject product = new JSONObject();
        List<JSONObject> productsPriceList = new ArrayList<JSONObject>();

        product.put("product_id",
            rsConsulta.getString("m_product_id") != null ? rsConsulta.getString("m_product_id")
                : "");
        product.put("code",
            rsConsulta.getString("code") != null ? rsConsulta.getString("code") : "");
        product.put("name",
            rsConsulta.getString("name") != null ? rsConsulta.getString("name") : "");
        product.put("image",
            rsConsulta.getString("binarydata") != null ? rsConsulta.getString("binarydata") : "");

        Connection connst = conn.getTransactionConnection();

        String strSqltk = null;
        strSqltk = "SELECT sum(qtyonhand) as stock FROM m_storage_detail msd\n"
            + "JOIN m_locator ml on ml.m_locator_id=msd.m_locator_id\n"
            + "JOIN m_warehouse mw on mw.m_warehouse_id=ml.m_warehouse_id\n"
            + "WHERE mw.em_ssvs_virtualstorage='N' AND msd.m_product_id='"
            + rsConsulta.getString("m_product_id") + "' GROUP BY m_product_id";

        PreparedStatement st1k = null;
        st1k = connst.prepareStatement(strSqltk);
        ResultSet rsConsultastk = st1k.executeQuery();

        while (rsConsultastk.next()) {
          product.put("stock", rsConsultastk.getInt("stock"));
        }
        // Close Connection
        connst.close();
        // Close PreparedStatement
        st1k.close();
        // Close ResultSet
        rsConsultastk.close();

        product.put("unit",
            rsConsulta.getString("unidad") != null ? rsConsulta.getString("unidad") : "");
        product.put("category_id",
            rsConsulta.getString("m_product_category_id") != null
                ? rsConsulta.getString("m_product_category_id")
                : "");

        Connection connpl = conn.getTransactionConnection();

        String strSqlp = null;
        strSqlp = "SELECT pl.name,coalesce(p.pricestd,0) as price, pl.m_pricelist_id, istaxincluded, isdefault FROM m_pricelist pl \n"
            + "JOIN m_pricelist_version l on l.m_pricelist_version_id=m_get_pricelist_version(pl.m_pricelist_id,now()::date)\n"
            + "JOIN m_productprice p on p.m_pricelist_version_id=l.m_pricelist_version_id\n"
            + "WHERE p.isactive = 'Y' AND m_product_id = '" + rsConsulta.getString("m_product_id")
            + "' AND pl.isactive = 'Y' AND pl.issopricelist='Y' ORDER BY pl.name";

        PreparedStatement st1 = null;
        st1 = connpl.prepareStatement(strSqlp);
        ResultSet rsConsulta1 = st1.executeQuery();

        while (rsConsulta1.next()) {
          JSONObject productprice = new JSONObject();
          productprice.put("pricelist_id",
              rsConsulta1.getString("m_pricelist_id") != null
                  ? rsConsulta1.getString("m_pricelist_id")
                  : "");
          productprice.put("pricelist_name",
              rsConsulta1.getString("name") != null ? rsConsulta1.getString("name") : "");
          productprice.put("price", rsConsulta1.getDouble("price"));
          productprice.put("istaxincluded",
              rsConsulta1.getString("istaxincluded") != null
                  ? (rsConsulta1.getString("istaxincluded").equals("Y") ? true : false)
                  : "");
          productprice.put("isdefault",
              rsConsulta1.getString("isdefault") != null
                  ? (rsConsulta1.getString("isdefault").equals("Y") ? true : false)
                  : "");
          productsPriceList.add(productprice);
        }
        // Close Connection
        connpl.close();
        // Close PreparedStatement
        st1.close();
        // Close ResultSet
        rsConsulta1.close();

        product.put("price_list", productsPriceList);
        products.add(product);
      }
      // Close Connection
      connp.close();
      // Close PreparedStatement
      st.close();
      // Close ResultSet
      rsConsulta.close();

    } catch (Exception e) {
      System.out.println("getProducts: " + e.getMessage());
      throw new OBException("getProducts: " + e.getMessage());
    } finally {
      conn.destroy();
    }

    return products;
  }

  static public List<JSONObject> getProductsCategory(String updatedDate, String createdDate)
      throws JSONException {

    List<JSONObject> productsCt = new ArrayList<JSONObject>();

    try {
      OBCriteria<ProductCategory> productList = OBDal.getInstance()
          .createCriteria(ProductCategory.class);
      productList.add(Restrictions.eq(ProductCategory.PROPERTY_SCWSAPAVAILABLEAPPORDERS, true));
      productList.addOrder(Order.asc(ProductCategory.PROPERTY_NAME));

      if (updatedDate != null && !updatedDate.isEmpty()) {
        productList.add(Restrictions.ge(Product.PROPERTY_UPDATED, formatDate.parse(updatedDate)));
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        productList
            .add(Restrictions.ge(Product.PROPERTY_CREATIONDATE, formatDate.parse(createdDate)));
      }

      for (ProductCategory p : productList.list()) {
        JSONObject productCt = new JSONObject();

        productCt.put("category_id", p.getId() != null ? p.getId() : "");
        productCt.put("name", p.getName() != null ? p.getName() : "");

        productsCt.add(productCt);
      }
    } catch (Exception e) {
      System.out.println("getProductsCategory: " + e.getMessage());
      throw new OBException("getProductsCategory: " + e.getMessage());
    }

    return productsCt;

  }

  static public List<JSONObject> getPartners(String updatedDate, String createdDate)
      throws JSONException {

    List<JSONObject> partners = new ArrayList<JSONObject>();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      Connection conndb = conn.getTransactionConnection();
      String strSql = null;
      strSql = "SELECT  m_pricelist_id,  name2,   p.name,   taxid, l.address1,bl.phone, \n"
          + "	   to_char(p.created,'dd-MM-yyyy HH24:MI:SS') as created, to_char(p.updated,'dd-MM-yyyy HH24:MI:SS') as updated, \n"
          + "	   p.c_bpartner_id, p.c_bp_group_id, p.em_eei_email, SalesRep_ID, \n"
          + "      p.so_creditused as creditused, p.so_creditlimit as creditlimit, p.em_ssfpf_iswithholding_agent as withholdingagent, \n"
          + "      pm.name as paymentmethod, p.customer_blocking as customerblocking, \n"
          + "	   bpac.AccountNo as accountno, bt.name as bankname, bl.EM_Spinco_Latitude as latitude, bl.EM_Spinco_Longitude as longitude\n"
          + "	  , to_char(coalesce(p.em_sbpc_datebirth,now()),'yyyy-MM-dd HH24:MI:SS') as dateborn  FROM c_bpartner p\n"
          + "	  LEFT JOIN (SELECT c_getbplocationid(c_bpartner_id,'B') as c_bpartner_location_id, c_bpartner_id\n"
          + "	  FROM c_bpartner ) pl on pl.c_bpartner_id=p.c_bpartner_id\n"
          + "	  LEFT JOIN c_bpartner_location bl on bl.c_bpartner_location_id=pl.c_bpartner_location_id \n"
          + "	  LEFT JOIN c_location l on l.c_location_id=bl.c_location_id \n"
          + "	  LEFT JOIN C_BP_BankAccount bpac on bpac.c_bpartner_id = p.c_bpartner_id\n"
          + "	  LEFT JOIN ssfi_banktransfer bt on bpac.em_ssfi_banktransfer_id = bt.ssfi_banktransfer_id\n"
          + "     LEFT JOIN fin_paymentmethod pm on pm.fin_paymentmethod_id = p.fin_paymentmethod_id \n"
          + "	  WHERE p.isactive='Y'";
      if (updatedDate != null && !updatedDate.isEmpty()) {
        strSql = strSql + "AND p.updated::date >= '" + updatedDate + "'::date\n";
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        strSql = strSql + "AND p.created::date >= '" + createdDate + "'::date\n";
      }

      PreparedStatement st = null;

      st = conndb.prepareStatement(strSql);
      ResultSet rsConsulta = st.executeQuery();

      while (rsConsulta.next()) {

        JSONObject partner = new JSONObject();

        partner.put("bpartner_id",
            rsConsulta.getString("c_bpartner_id") != null ? rsConsulta.getString("c_bpartner_id")
                : "");
        partner.put("taxid",
            rsConsulta.getString("taxid") != null ? rsConsulta.getString("taxid") : "");
        partner.put("comercial_name",
            rsConsulta.getString("name2") != null ? rsConsulta.getString("name2") : "");
        partner.put("social_name",
            rsConsulta.getString("name") != null ? rsConsulta.getString("name") : "");
        partner.put("category_id",
            rsConsulta.getString("c_bp_group_id") != null ? rsConsulta.getString("c_bp_group_id")
                : "");
        partner.put("pricelist_id",
            rsConsulta.getString("m_pricelist_id") != null ? rsConsulta.getString("m_pricelist_id")
                : "");
        partner.put("address",
            rsConsulta.getString("address1") != null ? rsConsulta.getString("address1") : "");
        partner.put("phone",
            rsConsulta.getString("phone") != null ? rsConsulta.getString("phone") : "");
        partner.put("email",
            rsConsulta.getString("em_eei_email") != null ? rsConsulta.getString("em_eei_email")
                : "");
        partner.put("map_location_long", "");
        partner.put("map_location_lat", "");
        partner.put("SalesRep_ID",
            rsConsulta.getString("SalesRep_ID") != null ? rsConsulta.getString("SalesRep_ID") : "");
        partner.put("created",
            rsConsulta.getString("created") != null ? rsConsulta.getString("created") : "");
        partner.put("updated",
            rsConsulta.getString("updated") != null ? rsConsulta.getString("updated") : "");

        partner.put("latitude",
            rsConsulta.getString("latitude") != null ? rsConsulta.getString("latitude") : "");
        partner.put("longitude",
            rsConsulta.getString("longitude") != null ? rsConsulta.getString("longitude") : "");
        partner.put("accountno",
            rsConsulta.getString("accountno") != null ? rsConsulta.getString("accountno") : "");
        partner.put("bankname",
            rsConsulta.getString("bankname") != null ? rsConsulta.getString("bankname") : "");

        partner.put("dateborn",
            rsConsulta.getString("dateborn") != null ? rsConsulta.getString("dateborn") : "");

        partner.put("creditused",
            rsConsulta.getString("creditused") != null ? rsConsulta.getString("creditused") : "");
        partner.put("creditlimit",
            rsConsulta.getString("creditlimit") != null ? rsConsulta.getString("creditlimit") : "");
        partner.put("withholdingagent",
            rsConsulta.getString("withholdingagent") != null
                ? rsConsulta.getString("withholdingagent")
                : "");
        partner.put("paymentmethod",
            rsConsulta.getString("paymentmethod") != null ? rsConsulta.getString("paymentmethod")
                : "");
        partner.put("customerblocking",
            rsConsulta.getString("customerblocking") != null
                ? rsConsulta.getString("customerblocking")
                : "");

        partners.add(partner);
      }
      // Close ConnectionProvider
      conndb.close();
      // Close PreparedStatement
      st.close();
      // Close ResultSet
      rsConsulta.close();
    } catch (Exception e) {
      System.out.println("getPartners: " + e.getMessage());
      throw new OBException("getPartners: " + e.getMessage());
    }

    return partners;

  }

  static public List<JSONObject> getPartnersPT(String updatedDate, String createdDate,
      String paymentterm) throws JSONException {

    List<JSONObject> partners = new ArrayList<JSONObject>();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      Connection conndb = conn.getTransactionConnection();
      String strSql = null;
      strSql = "SELECT  m_pricelist_id,  name2,   p.name,   taxid, l.address1,bl.phone,\n"
          + " to_char(p.created,'dd-MM-yyyy HH24:MI:SS') as created, to_char(p.updated,'dd-MM-yyyy HH24:MI:SS') as updated, \n"
          + " p.c_bpartner_id, p.c_bp_group_id, p.em_eei_email, SalesRep_ID, pt.c_paymentterm_id  FROM c_bpartner p\n"
          + "LEFT JOIN c_paymentterm pt on pt.c_paymentterm_id=p.c_paymentterm_id\n"
          + "LEFT JOIN (SELECT c_getbplocationid(c_bpartner_id,'B') as c_bpartner_location_id, c_bpartner_id\n"
          + "FROM c_bpartner ) pl on pl.c_bpartner_id=p.c_bpartner_id\n"
          + "LEFT JOIN c_bpartner_location bl on bl.c_bpartner_location_id=pl.c_bpartner_location_id\n"
          + "LEFT JOIN c_location l on l.c_location_id=bl.c_location_id\n" + "WHERE p.isactive='Y'";
      if (updatedDate != null && !updatedDate.isEmpty()) {
        strSql = strSql + "AND p.updated::date >= '" + updatedDate + "'::date\n";
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        strSql = strSql + "AND p.created::date >= '" + createdDate + "'::date\n";
      }
      if (paymentterm != null && !paymentterm.isEmpty()) {
        strSql = strSql + "AND pt.c_paymentterm_id = '" + paymentterm + "'\n";
      }
      PreparedStatement st = null;

      st = conndb.prepareStatement(strSql);
      ResultSet rsConsulta = st.executeQuery();

      while (rsConsulta.next()) {

        JSONObject partner = new JSONObject();

        partner.put("bpartner_id",
            rsConsulta.getString("c_bpartner_id") != null ? rsConsulta.getString("c_bpartner_id")
                : "");
        partner.put("taxid",
            rsConsulta.getString("taxid") != null ? rsConsulta.getString("taxid") : "");
        partner.put("comercial_name",
            rsConsulta.getString("name2") != null ? rsConsulta.getString("name2") : "");
        partner.put("social_name",
            rsConsulta.getString("name") != null ? rsConsulta.getString("name") : "");
        partner.put("category_id",
            rsConsulta.getString("c_bp_group_id") != null ? rsConsulta.getString("c_bp_group_id")
                : "");
        partner.put("pricelist_id",
            rsConsulta.getString("m_pricelist_id") != null ? rsConsulta.getString("m_pricelist_id")
                : "");
        partner.put("address",
            rsConsulta.getString("address1") != null ? rsConsulta.getString("address1") : "");
        partner.put("phone",
            rsConsulta.getString("phone") != null ? rsConsulta.getString("phone") : "");
        partner.put("email",
            rsConsulta.getString("em_eei_email") != null ? rsConsulta.getString("em_eei_email")
                : "");
        partner.put("map_location_long", "");
        partner.put("map_location_lat", "");
        partner.put("SalesRep_ID",
            rsConsulta.getString("SalesRep_ID") != null ? rsConsulta.getString("SalesRep_ID") : "");
        partner.put("paymentTerm_id",
            rsConsulta.getString("c_paymentterm_id") != null
                ? rsConsulta.getString("c_paymentterm_id")
                : "");
        partner.put("created",
            rsConsulta.getString("created") != null ? rsConsulta.getString("created") : "");
        partner.put("updated",
            rsConsulta.getString("updated") != null ? rsConsulta.getString("updated") : "");

        partners.add(partner);
      }
      // Close ConnectionProvider
      conndb.close();
      // Close PreparedStatement
      st.close();
      // Close ResultSet
      rsConsulta.close();
    } catch (Exception e) {
      System.out.println("getPartners: " + e.getMessage());
      throw new OBException("getPartners: " + e.getMessage());
    }

    return partners;

  }

  static public JSONObject setCoordinates(JsonObject data) throws JSONException {
    String status = "OK";
    String msg = "BusinessPartner coordinates correctly updated.";

    JSONObject result = new JSONObject();
    BusinessPartner partner = OBDal.getInstance().get(BusinessPartner.class,
        data.get("partner_id").getAsString());

    if (partner == null) {
      status = "Error";
      msg = "BusinessPartner not found with taxId:" + data.get("partner_id").getAsString();
    } else {
      if (partner.getBusinessPartnerLocationList().size() > 0) {
        List<Location> locations = partner.getBusinessPartnerLocationList();
        if (locations.size() > 0) {
          String latitude = data.get("latitude").getAsString();
          String longitude = data.get("longitude").getAsString();
          try {
            OBContext.setAdminMode();
            Location locations2 = OBDal.getInstance().get(Location.class, locations.get(0).getId());
            locations2.setSpincoLatitude(latitude);
            locations2.setSpincoLongitude(longitude);
            OBDal.getInstance().save(locations2);
            // OBDal.getInstance().refresh(locations2);
            partner.setScrvroLatitude(latitude);
            partner.setScrvroLongitude(longitude);
            OBDal.getInstance().save(partner);

            OBDal.getInstance().commitAndClose();
          } finally {
            OBContext.restorePreviousMode();
          }

        }
      } else {
        status = "Error";
        msg = "BusinessPartner with taxId:" + data.get("partner_id").getAsString()
            + " no address available.";
      }
    }

    result.put("status", status);
    result.put("message", msg);
    result.put("additional", "");
    return result;
  }

  static public JSONObject setDataPartner(JsonObject data) throws JSONException {
    JSONObject result = new JSONObject();

    JsonParser parser = new JsonParser();
    JsonElement element = parser.parse(data.toString()); // data es el string del JSON
    if (element.isJsonObject()) {
      JsonObject jsonObject = element.getAsJsonObject();
      if (jsonObject.has("data") && jsonObject.get("data").isJsonArray()) {
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
        for (JsonElement jsonElement : jsonArray) {
          if (jsonElement.isJsonObject()) {
            JsonObject dataObject = jsonElement.getAsJsonObject();
            String clientDateBorn = dataObject.get("client_date_born").getAsString();
            String clientIdentifier = dataObject.get("client_identifier").getAsString();
            System.out.println("Client Date Born: " + clientDateBorn);
            System.out.println("Client Identifier: " + clientIdentifier);
            BusinessPartner partner = OBDal.getInstance().get(BusinessPartner.class,
                clientIdentifier);
            if (partner != null) {
              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
              Date date = null;
              try {
                date = format.parse(clientDateBorn);
              } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
              partner.setBirthDay(date);

              try {
                partner.setSbpcDatebirth(date);
              } catch (Exception e) {

              }
              try {
                partner.setSSPRBirthday(date);
              } catch (Exception e) {

              }
              OBDal.getInstance().save(partner);
            }
          }
        }
      }
    }

    result.put("status", "OK");
    result.put("message", "Correctamente creado");
    result.put("additional", "");
    return result;
  }

  static public List<JSONObject> getPartnersCategory(String updatedDate, String createdDate)
      throws JSONException {

    List<JSONObject> partnersCt = new ArrayList<JSONObject>();

    try {
      OBCriteria<Category> partnersCtList = OBDal.getInstance().createCriteria(Category.class);
      partnersCtList.addOrder(Order.asc(Category.PROPERTY_NAME));

      if (updatedDate != null && !updatedDate.isEmpty()) {
        partnersCtList
            .add(Restrictions.ge(Product.PROPERTY_UPDATED, formatDate.parse(updatedDate)));
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        partnersCtList
            .add(Restrictions.ge(Product.PROPERTY_CREATIONDATE, formatDate.parse(createdDate)));
      }
      for (Category p : partnersCtList.list()) {
        JSONObject pCt = new JSONObject();

        pCt.put("category_id", p.getId() != null ? p.getId() : "");
        pCt.put("name", p.getName() != null ? p.getName() : "");

        partnersCt.add(pCt);
      }
    } catch (Exception e) {
      System.out.println("getPartnersCategory: " + e.getMessage());
      throw new OBException("getPartnersCategory: " + e.getMessage());
    }

    return partnersCt;

  }

  static public List<JSONObject> getPriceList(String updatedDate, String createdDate)
      throws JSONException {

    List<JSONObject> priceList = new ArrayList<JSONObject>();

    try {
      OBCriteria<PriceList> productListCt = OBDal.getInstance().createCriteria(PriceList.class);
      productListCt.add(Restrictions.eq(PriceList.PROPERTY_SALESPRICELIST, true));
      productListCt.addOrder(Order.asc(PriceList.PROPERTY_NAME));

      if (updatedDate != null && !updatedDate.isEmpty()) {
        productListCt
            .add(Restrictions.ge(PriceList.PROPERTY_UPDATED, formatDate.parse(updatedDate)));
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        productListCt
            .add(Restrictions.ge(PriceList.PROPERTY_CREATIONDATE, formatDate.parse(createdDate)));
      }

      for (PriceList p : productListCt.list()) {
        JSONObject pl = new JSONObject();

        pl.put("pricelist_id", p.getId() != null ? p.getId() : "");
        pl.put("name", p.getName() != null ? p.getName() : "");

        priceList.add(pl);
      }
    } catch (Exception e) {
      System.out.println("getPriceList: " + e.getMessage());
      throw new OBException("getPriceList: " + e.getMessage());
    }

    return priceList;

  }

  static public List<JSONObject> getProductsOrgWh(String updatedDate, String createdDate,
      String orgid, String whid) throws JSONException {

    List<JSONObject> products = new ArrayList<JSONObject>();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      ArrayList<String> arrayProductList = new ArrayList<String>();
      Connection conndb = conn.getTransactionConnection();

      if (updatedDate != null || createdDate != null) {
        String strSqlpl = null;
        strSqlpl = "SELECT  m_product_id FROM m_pricelist pl \n"
            + "JOIN m_pricelist_version l on l.m_pricelist_version_id=m_get_pricelist_version(pl.m_pricelist_id,now()::date)\n"
            + "JOIN m_productprice p on p.m_pricelist_version_id=l.m_pricelist_version_id\n"
            + "WHERE p.isactive = 'Y' AND pl.isactive = 'Y' AND pl.issopricelist='Y' ";
        if (updatedDate != null && !updatedDate.isEmpty()) {
          strSqlpl = strSqlpl + "AND pl.updated::date >= '" + updatedDate + "'::date\n";
        }
        if (createdDate != null && !createdDate.isEmpty()) {
          strSqlpl = strSqlpl + "AND pl.created::date >= '" + createdDate + "'::date\n";
        }
        strSqlpl = strSqlpl + "GROUP BY 1";

        PreparedStatement stpl = null;

        stpl = conndb.prepareStatement(strSqlpl);
        ResultSet rsConsultapl = stpl.executeQuery();
        while (rsConsultapl.next()) {
          arrayProductList.add(rsConsultapl.getString("m_product_id"));
        }
        // Close Connection
        conndb.close();
        // Close PreparedStatement
        stpl.close();
        // Close ResultSet
        rsConsultapl.close();

      }

      String additionalFields = SCWSAP_Helper.existModule("it.openia.crm")
          ? ", p.em_opcrm_upc2 as upc2, p.em_opcrm_upc2 as upc3 "
          : " ,'' as upc2, '' as upc3";

      String productList = StringUtils.join(arrayProductList, ",");
      Connection connp = conn.getTransactionConnection();
      String strSql = null;

      strSql = "SELECT p.m_product_id, p.value as code, p.name \n"
          + "  , u.name as unidad, pc.m_product_category_id , encode(i.binarydata, 'base64') as binarydata, mimetype,i.width \n"
          + "  ,i.height, p.created as created0, stock.created as created1, pricelist.created as created2, \n"
          + "  stock.updated as updated0, pricelist.updated as updated1, p.updated as updated2, p.upc \n "
          + " ,stock.stock,stock.m_attributesetinstance_id,stock.description as attribute_value"
          + " ,stock.m_locator_id, stock.m_warehouse_id" + additionalFields
          + "  FROM m_product  p \n"
          + "  JOIN m_product_category pc on pc.m_product_category_id = p.m_product_category_id \n"
          + "  LEFT JOIN ad_image i on i.ad_image_id = p.ad_image_id \n"
          + "  LEFT JOIN c_uom_trl u on u.c_uom_id=p.c_uom_id AND ad_language='es_ES' \n"
          + "  LEFT JOIN (\n"
          + "	  SELECT msd.qtyonhand as stock, msd.updated as updated, msd.created as created"
          + "                   , m_product_id, msd.m_attributesetinstance_id, att.description"
          + "                   , msd.m_locator_id, mw.m_warehouse_id"
          + "                   FROM m_storage_detail msd\n"
          + "			JOIN m_locator ml on ml.m_locator_id=msd.m_locator_id\n"
          + "			JOIN m_warehouse mw on mw.m_warehouse_id=ml.m_warehouse_id\n"
          + "                   LEFT JOIN m_attributesetinstance att ON att.m_attributesetinstance_id=msd.m_attributesetinstance_id\n"
          + "			WHERE mw.em_ssvs_virtualstorage='N'\n"
          + "  ) stock on stock.m_product_id = p.m_product_id\n" + "  LEFT JOIN (\n"
          + "		SELECT max(p.updated) as updated, max(p.created) as created, p.m_product_id FROM m_pricelist pl\n"
          + "				JOIN m_pricelist_version l on l.m_pricelist_version_id=m_get_pricelist_version(pl.m_pricelist_id,now()::date)\n"
          + "				JOIN m_productprice p on p.m_pricelist_version_id=l.m_pricelist_version_id\n"
          + "				WHERE p.isactive = 'Y' AND pl.isactive = 'Y' AND pl.issopricelist='Y' GROUP BY p.m_product_id\n"
          + "  ) pricelist on pricelist.m_product_id = p.m_product_id\n"
          + "  WHERE p.isactive='Y' AND em_scwsap_available_app_orders='Y' \n";
      if (updatedDate != null && !updatedDate.isEmpty()) {
        strSql = strSql + "AND p.updated::date >= '" + updatedDate + "'::date\n";
        if (!productList.isEmpty()) {
          strSql = strSql + "OR m_product_id in (select a from regexp_split_to_table('"
              + productList + "',',') a)\n";
        }
      }
      if (createdDate != null && !createdDate.isEmpty()) {
        strSql = strSql + "AND p.created::date >= '" + createdDate + "'::date\n";
        if (!productList.isEmpty()) {
          strSql = strSql + "OR m_product_id in (select a from regexp_split_to_table('"
              + productList + "',',') a)\n";
        }
      }

      PreparedStatement st = null;

      st = connp.prepareStatement(strSql);
      ResultSet rsConsulta = st.executeQuery();

      while (rsConsulta.next()) {
        JSONObject product = new JSONObject();
        List<JSONObject> productsPriceList = new ArrayList<JSONObject>();
        List<JSONObject> productsAUMList = new ArrayList<JSONObject>();

        product.put("product_id",
            rsConsulta.getString("m_product_id") != null ? rsConsulta.getString("m_product_id")
                : "");
        product.put("code",
            rsConsulta.getString("code") != null ? rsConsulta.getString("code") : "");
        product.put("name",
            rsConsulta.getString("name") != null ? rsConsulta.getString("name") : "");
        product.put("image",
            rsConsulta.getString("binarydata") != null ? rsConsulta.getString("binarydata") : "");
        product.put("upc", rsConsulta.getString("upc") != null ? rsConsulta.getString("upc") : "");
        product.put("upc2",
            rsConsulta.getString("upc2") != null ? rsConsulta.getString("upc2") : "");
        product.put("upc3",
            rsConsulta.getString("upc3") != null ? rsConsulta.getString("upc3") : "");
        product.put("stock", rsConsulta.getInt("stock"));
        product.put("attributesetinstance_id",
            rsConsulta.getString("m_attributesetinstance_id") != null
                ? rsConsulta.getString("m_attributesetinstance_id")
                : "");
        product.put("attribute_value",
            rsConsulta.getString("attribute_value") != null
                ? rsConsulta.getString("attribute_value")
                : "");
        product.put("locator_id",
            rsConsulta.getString("m_locator_id") != null ? rsConsulta.getString("m_locator_id")
                : "");
        product.put("warehouse_id",
            rsConsulta.getString("m_warehouse_id") != null ? rsConsulta.getString("m_warehouse_id")
                : "");

        // Connection connst = conn.getTransactionConnection();

        // String strSqltk = null;
        // strSqltk = "SELECT sum(qtyonhand) as stock FROM m_storage_detail msd\n"
        // + "JOIN m_locator ml on ml.m_locator_id=msd.m_locator_id\n"
        // + "JOIN m_warehouse mw on mw.m_warehouse_id=ml.m_warehouse_id\n"
        // + "JOIN ad_org og on og.ad_org_id = ml.ad_org_id\n"
        // + "WHERE mw.em_ssvs_virtualstorage='N' \n" + "AND msd.m_product_id='"
        // + rsConsulta.getString("m_product_id") + "'\n";
        //
        // if (orgid != null && !orgid.isEmpty()) {
        // strSqltk = strSqltk + "AND og.ad_org_id = '" + orgid + "'\n";
        // }
        // if (whid != null && !whid.isEmpty()) {
        // strSqltk = strSqltk + "AND mw.m_warehouse_id = '" + whid + "'\n";
        // }
        // strSqltk = strSqltk + "GROUP BY m_product_id";
        //
        // PreparedStatement st1k = null;
        // st1k = connst.prepareStatement(strSqltk);
        // ResultSet rsConsultastk = st1k.executeQuery();
        //
        // while (rsConsultastk.next()) {
        // product.put("stock", rsConsultastk.getInt("stock"));
        // }
        // // Close Connection
        // connst.close();
        // // Close PreparedStatement
        // st1k.close();
        // // Close ResultSet
        // rsConsultastk.close();

        product.put("unit",
            rsConsulta.getString("unidad") != null ? rsConsulta.getString("unidad") : "");
        product.put("category_id",
            rsConsulta.getString("m_product_category_id") != null
                ? rsConsulta.getString("m_product_category_id")
                : "");

        Connection connpl = conn.getTransactionConnection();

        String strSqlp = null;
        strSqlp = "SELECT pl.name,coalesce(p.pricestd,0) as price, pl.m_pricelist_id, istaxincluded, isdefault FROM m_pricelist pl \n"
            + "JOIN m_pricelist_version l on l.m_pricelist_version_id=m_get_pricelist_version(pl.m_pricelist_id,now()::date)\n"
            + "JOIN m_productprice p on p.m_pricelist_version_id=l.m_pricelist_version_id\n"
            + "WHERE p.isactive = 'Y' AND m_product_id = '" + rsConsulta.getString("m_product_id")
            + "' AND pl.isactive = 'Y' AND pl.issopricelist='Y' ORDER BY pl.name";

        PreparedStatement st1 = null;
        st1 = connpl.prepareStatement(strSqlp);
        ResultSet rsConsulta1 = st1.executeQuery();

        while (rsConsulta1.next()) {
          JSONObject productprice = new JSONObject();
          productprice.put("pricelist_id",
              rsConsulta1.getString("m_pricelist_id") != null
                  ? rsConsulta1.getString("m_pricelist_id")
                  : "");
          productprice.put("pricelist_name",
              rsConsulta1.getString("name") != null ? rsConsulta1.getString("name") : "");
          productprice.put("price", rsConsulta1.getDouble("price"));
          productprice.put("istaxincluded",
              rsConsulta1.getString("istaxincluded") != null
                  ? (rsConsulta1.getString("istaxincluded").equals("Y") ? true : false)
                  : "");
          productprice.put("isdefault",
              rsConsulta1.getString("isdefault") != null
                  ? (rsConsulta1.getString("isdefault").equals("Y") ? true : false)
                  : "");
          productsPriceList.add(productprice);
        }
        // Close Connection
        connpl.close();
        // Close PreparedStatement
        st1.close();
        // Close ResultSet
        rsConsulta1.close();

        product.put("price_list", productsPriceList);

        // Get AUM llst by product
        Connection conn_aum = conn.getTransactionConnection();

        String strSql_aum = null;
        strSql_aum = "SELECT u.name,m_product_id,conversionrate,gtin,rl.name as sales\n"
            + "FROM m_product_aum au\n"
            + "JOIN c_uom_trl u ON u.c_uom_id=au.c_uom_id AND ad_language='es_ES'\n"
            + "LEFT JOIN (SELECT rlt.name,value FROM ad_ref_list  rl\n"
            + "        LEFT JOIN ad_ref_list_trl rlt ON rl.ad_ref_list_id=rlt.ad_ref_list_id\n"
            + "        WHERE ad_reference_id  ='B7B8495A15AE4904A88CAD93A2A1FD4B' AND ad_language='es_ES') rl ON rl.value=au.sales\n"
            + "WHERE au.m_product_id='" + rsConsulta.getString("m_product_id")
            + "' ORDER BY u.name";

        PreparedStatement st_aum = null;
        st_aum = conn_aum.prepareStatement(strSql_aum);
        ResultSet rsConsulta_aum = st_aum.executeQuery();

        while (rsConsulta_aum.next()) {
          JSONObject product_aum = new JSONObject();
          product_aum.put("name",
              rsConsulta_aum.getString("name") != null ? rsConsulta_aum.getString("name") : "");
          product_aum.put("conversionrate", rsConsulta_aum.getDouble("conversionrate"));
          product_aum.put("gtin", rsConsulta_aum.getString("gtin") != null
              ? (rsConsulta_aum.getString("gtin") != null ? rsConsulta_aum.getString("gtin") : "")
              : "");
          product_aum.put("sales", rsConsulta_aum.getString("sales") != null
              ? (rsConsulta_aum.getString("sales") != null ? rsConsulta_aum.getString("sales") : "")
              : "");
          productsAUMList.add(product_aum);
        }
        // Close Connection
        conn_aum.close();
        // Close PreparedStatement
        st_aum.close();
        // Close ResultSet
        rsConsulta_aum.close();

        product.put("aum_list", productsAUMList);
        // End get AUM list

        products.add(product);
      }
      // Close Connection
      connp.close();
      // Close PreparedStatement
      st.close();
      // Close ResultSet
      rsConsulta.close();

    } catch (Exception e) {
      System.out.println("getProducts: " + e.getMessage());
      throw new OBException("getProducts: " + e.getMessage());
    }

    return products;
  }

}

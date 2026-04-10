package ec.com.sidesoft.imports.pricelist.ad_model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openbravo.model.common.plm.Product;

public class Temp {

  Product producto;
  BigDecimal precioPOE;
  BigDecimal precioPVP;

  public Product getProducto() {
    return this.producto;
  }

  public void setProducto(Product producto) {
    this.producto = producto;
  }

  public BigDecimal getPrecioPOE() {
    return this.precioPOE;
  }

  public void setPrecioPOE(BigDecimal precioPOE) {
    this.precioPOE = precioPOE;
  }

  public BigDecimal getPrecioPVP() {
    return this.precioPVP;
  }

  public void setPrecioPVP(BigDecimal precioPVP) {
    this.precioPVP = precioPVP;
  }

  @Override
  public String toString() {
    return "{" + " producto='" + getProducto() + "'" + ", precioPOE='" + getPrecioPOE() + "'"
        + ", precioPVP='" + getPrecioPVP() + "'" + "}";
  }

}
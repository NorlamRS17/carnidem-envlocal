package ec.com.sidesoft.imports.pricelist.ad_model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openbravo.model.common.plm.Product;
import org.openbravo.model.pricing.pricelist.PriceListVersion;

public class TempProductPL {

  Product producto;
  BigDecimal precioPOE;
  BigDecimal precioPVP;
  Date validFrom;
  PriceListVersion priceListVersion;

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

  public Date getValidFrom() {
    return this.validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public PriceListVersion getPriceListVersion() {
    return this.priceListVersion;
  }

  public void setPriceListVersion(PriceListVersion priceListVersion) {
    this.priceListVersion = priceListVersion;
  }

  @Override
  public String toString() {
    return "{" + " producto='" + getProducto() + "'" + ", precioPOE='" + getPrecioPOE() + "'"
        + ", precioPVP='" + getPrecioPVP() + "'" + ", validFrom='" + getValidFrom() + "'"
        + ", priceListVersion='" + getPriceListVersion() + "'" + "}";
  }

}
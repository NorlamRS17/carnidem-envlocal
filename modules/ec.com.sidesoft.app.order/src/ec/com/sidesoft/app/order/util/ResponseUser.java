package ec.com.sidesoft.app.order.util;

import java.util.Set;

public class ResponseUser {
  private String status = null;
  private String name = null;
  private String email = null;
  private String phone = null;
  private String address = null;
  private String currency = null;
  private String tax = null;
  private String ad_user_id = null;
  private String c_bpartner_id = null;
  private String user_type = null;
  private boolean production_user_app = false;
  private Set<String> organizationList = null;

  public ResponseUser() {

  }

  public ResponseUser(String status, String name, String email, String phone, String address,
      String currency, String tax, String ad_user_id, String c_bpartner_id, String user_type,
      Set<String> organizationList, boolean production_user_app) {
    super();
    this.status = status;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.currency = currency;
    this.tax = tax;
    this.ad_user_id = ad_user_id;
    this.c_bpartner_id = c_bpartner_id;
    this.user_type = user_type;
    this.organizationList = organizationList;
    this.production_user_app = production_user_app;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getTax() {
    return tax;
  }

  public void setTax(String tax) {
    this.tax = tax;
  }

  public String getAd_user_id() {
    return ad_user_id;
  }

  public void setAd_user_id(String ad_user_id) {
    this.ad_user_id = ad_user_id;
  }

  public boolean getProduction_user_app() {
    return production_user_app;
  }

  public void setProduction_user_app(boolean production_user_app) {
    this.production_user_app = production_user_app;
  }

  public String getC_bpartner_id() {
    return c_bpartner_id;
  }

  public void setC_bpartner_id(String c_bpartner_id) {
    this.c_bpartner_id = c_bpartner_id;
  }

  public String getUser_type() {
    return user_type;
  }

  public void setUser_type(String user_type) {
    this.user_type = user_type;
  }

  public Set<String> getOrganizationList() {
    return organizationList;
  }

  public void setOrganizationList(Set<String> organizationList) {
    this.organizationList = organizationList;
  }

  @Override
  public String toString() {
    return "ResponseUser [status=" + status + ", name=" + name + ", email=" + email + ", phone="
        + phone + ", address=" + address + ", currency=" + currency + ", tax=" + tax
        + ", ad_user_id=" + ad_user_id + ", c_bpartner_id=" + c_bpartner_id + ", user_type="
        + user_type + ", production_user_app=" + production_user_app + ", organizationList="
        + organizationList + "]";
  }

}

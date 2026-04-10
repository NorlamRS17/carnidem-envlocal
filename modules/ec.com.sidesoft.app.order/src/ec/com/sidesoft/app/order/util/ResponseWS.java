package ec.com.sidesoft.app.order.util;

public class ResponseWS {
  private String status = null;
  private String message = null;

  public ResponseWS() {
  
  }
  
  public ResponseWS(String status, String message) {
	this.status = status;
	this.message = message;
  }
  
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

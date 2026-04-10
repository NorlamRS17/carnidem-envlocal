package ec.com.sidesoft.web.services.order.route.service.utils;

public class Response {

    private String description = "";
    private int status = 0;

    public Response(String description, int status) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

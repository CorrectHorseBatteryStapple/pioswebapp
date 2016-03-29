package hr.tvz.car.parts.shop.model.dto;

public class SimpleCarPartBackendResponse {

    private Object object;
    private String statusMessage;
    
    public SimpleCarPartBackendResponse() {
        //
    }
    
    public SimpleCarPartBackendResponse(Object object, String statusMessage) {
        this.object = object;
        this.statusMessage = statusMessage;
    }

    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
    
}

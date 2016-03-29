package hr.tvz.car.parts.shop.model.dto;

public class SimpleCarPartBackendResponse {

    private Object data;
    private String statusMessage;
    
    public SimpleCarPartBackendResponse() {
        //
    }
    
    public SimpleCarPartBackendResponse(Object data, String statusMessage) {
        this.data = data;
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
}

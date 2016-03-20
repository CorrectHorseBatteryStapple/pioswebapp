package hr.tvz.car.parts.shop.model;

public class Product {

    private String name;
    private String type;
    private String serialNumber;
    private String dimension;
    private double price;
    
    public Product(String name, String type, String serialNumber, String dimension, double price) {
        super();
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.dimension = dimension;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    } 

}

package hr.tvz.car.parts.shop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT", schema = "CPU")
public class Product {

    @Id
    @Column(name = "ID_PRODUCT")
    @GeneratedValue
    private Long            id;

    @Column(name = "NAME")
    private String          name;

    @Column(name = "MANUFACTURER")
    private String          manufacturer;

    @Column(name = "TYPE")
    private String          type;

    @Column(name = "SERIAL_NUMBER")
    private String          serialNumber;

    @Column(name = "DIMENSION")
    private String          dimension;

    @Column(name = "IMAGE_PATH")
    private String          imagePath;

    @Column(name = "STOCK_COUNT")
    private Long            stockCount;

    @Column(name = "SOLD_COUNT")
    private Long            soldCount;

    @Column(name = "FAVOURITE_COUNT")
    private Long            favouriteCount;

    @Column(name = "RATING")
    private BigDecimal      rating;

    @Column(name = "PRICE")
    private BigDecimal      price;

    @Column(name = "ACTIVE")
    private Boolean         active;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT_CATEGORY")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "ID_CAR_BRAND")
    private CarBrand        carBrand;

    public Product() {
        //
    }

    public Product(String name, String type, String serialNumber, String dimension, BigDecimal price) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }

    public Long getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Long soldCount) {
        this.soldCount = soldCount;
    }

    public Long getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(Long favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}

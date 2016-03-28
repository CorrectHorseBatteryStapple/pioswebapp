package hr.tvz.car.parts.shop.model.dto;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.car.parts.shop.model.OrderStatus;
import hr.tvz.car.parts.shop.model.Product;

public class CartOrderDto {

    private Long id;
    private String timestamp;
    private OrderStatus orderStatus;
    private List<Product> cartProductList;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Product> getCartProductList() {
        return cartProductList == null ? new ArrayList<Product>() : cartProductList;
    }
    public void setCartProductList(List<Product> cartProductList) {
        this.cartProductList = cartProductList;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

package hr.tvz.car.parts.shop.model.dto;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.car.parts.shop.model.OrderStatus;
import hr.tvz.car.parts.shop.model.Product;

public class CartOrderDto {

    private Long          cartOrderId;
    private Long          userId;
    private String        timestamp;
    private OrderStatus   orderStatus;
    private List<Product> cartProductList;

    public List<Product> getCartProductList() {
        if (cartProductList == null) {
            this.cartProductList = new ArrayList<>();
        }
        return cartProductList;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCartOrderId() {
        return cartOrderId;
    }

    public void setCartOrderId(Long cartOrderId) {
        this.cartOrderId = cartOrderId;
    }
}

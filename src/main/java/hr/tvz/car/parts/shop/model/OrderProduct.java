package hr.tvz.car.parts.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {

    @Id
    @Column(name = "ID_ORDER_PRODUCT")
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CART_ORDER")
    private CartOrder order;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartOrder getOrder() {
        return order;
    }

    public void setOrder(CartOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}

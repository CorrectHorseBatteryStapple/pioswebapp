package hr.tvz.car.parts.shop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "CART_ORDER", schema = "CPU")
public class CartOrder {

    @Id
    @GeneratedValue
    @Column(name = "ID_CART_ORDER")
    private Long id;
    
    @Column(name = "ORDER_TIMESTAMP")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime timestamp;
    
    @ManyToOne
    @JoinColumn(name = "ID_ORDER_STATUS")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "ORDER_PRODUCT", 
//        joinColumns = {@JoinColumn(name = "ID_CART_ORDER", referencedColumnName = "ID_CART_ORDER")},
//        inverseJoinColumns = {@JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID_PRODUCT")})
//    private List<Product> orderedProductsList;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<OrderProduct> orderProductList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
 
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> ordeProductList) {
        this.orderProductList = ordeProductList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}

package hr.tvz.car.parts.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus {
    
    @Id
    @GeneratedValue
    @Column(name = "ID_ORDER_STATUS")
    private Long id;
    
    @Column(name = "STATUS")
    private String status;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

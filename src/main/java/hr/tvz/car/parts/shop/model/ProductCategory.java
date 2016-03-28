package hr.tvz.car.parts.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "PRODOUCT_CATEGORY")
public class ProductCategory {

    @Id
    @Column(name = "ID_PRODUCT_CATEGORY")
    @GeneratedValue
    private Long id;
    
    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

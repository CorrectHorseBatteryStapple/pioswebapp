package hr.tvz.car.parts.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_BRAND", schema = "CPU")
public class CarBrand {
    
    @Id
    @Column(name = "ID_CAR_BRAND")
    @GeneratedValue
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "IMAGE_PATH")
    private String imagePath;
    
    @Column(name = "LOGO_PATH")
    private String logoPath;
    
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
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getLogoPath() {
        return logoPath;
    }
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
    
}

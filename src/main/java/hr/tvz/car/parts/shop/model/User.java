package hr.tvz.car.parts.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID_USER")
    private Long id;
    
    @Column(name="USERNAME")
    private String username;
    
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="FIRST_NAME")
    private String firstname;
    
    @Column(name="LAST_NAME")
    private String lastname;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    
    @ManyToOne
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    private Role role;

//    @ManyToOne
//    @JoinColumn(name = "ID_CART_ORDER", referencedColumnName = "ID_CART_ORDER")
//    private CartOrder order;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}

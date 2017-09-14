package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "selersequence")
@Entity
@Table(name = "seller")
public class Seller implements Serializable {

    private static final long serialVersionUID = -2766873791972479486L;
    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "deliveryaddress")
    private String deliveryAddress;

    public Seller() {
    }

    public Seller(int id, String firstName, String middleName, String lastName, Date birthDate, String email, String deliveryAddress) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}

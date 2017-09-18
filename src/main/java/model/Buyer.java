package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "buyersequence")
@Entity
@Table(name = "buyer")
public class Buyer implements Serializable {

    private static final long serialVersionUID = -4665355705722204062L;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "livingaddress")
    private String livingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyerid")
    private Discount discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saleid")
    private Sale sale;

    public Buyer() {
    }

    public Buyer(int id, String firstName, String middleName, String lastName, Date birthDate, String phoneNumber, String livingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.livingAddress = livingAddress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }
}
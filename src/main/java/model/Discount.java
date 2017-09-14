package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "discountsequence")
@Entity
@Table(name = "discount")
public class Discount implements Serializable {

    private static final long serialVersionUID = -2952730516290458737L;
    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "buyerid",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Buyer.class)
    private Set<Buyer> buyers = new HashSet<Buyer>();

    @OneToMany(mappedBy = "productid",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Product.class)
    private Set<Product> products = new HashSet<Product>();

    @Column(name = "actingfrom")
    private Date actualFrom;

    @Column(name = "actingto")
    private Date actualTo;

    public Discount() {
    }

    public Discount(int id, Set<Buyer> buyers, Set<Product> products, Date actualFrom, Date actualTo) {
        this.id = id;
        this.buyers = buyers;
        this.products = products;
        this.actualFrom = actualFrom;
        this.actualTo = actualTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(Set<Buyer> buyers) {
        this.buyers = buyers;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Date getActualFrom() {
        return actualFrom;
    }

    public void setActualFrom(Date actualFrom) {
        this.actualFrom = actualFrom;
    }

    public Date getActualTo() {
        return actualTo;
    }

    public void setActualTo(Date actualTo) {
        this.actualTo = actualTo;
    }
}

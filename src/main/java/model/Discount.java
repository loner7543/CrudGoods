package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "discountsequence")
@Entity
@Table(name = "discount")
public class Discount implements Serializable {

    private static final long serialVersionUID = -2952730516290458737L;
    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    private int id;

    private Buyer buyer;
    private Product product;

    @Column(name = "actingfrom")
    private Date actualFrom;

    @Column(name = "actingto")
    private Date actualTo;

    public Discount() {
    }

    public Discount(int id, Buyer buyer, Product product, Date actualFrom, Date actualTo) {
        this.id = id;
        this.buyer = buyer;
        this.product = product;
        this.actualFrom = actualFrom;
        this.actualTo = actualTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

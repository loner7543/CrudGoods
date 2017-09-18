package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "salesequence")
@Entity
@Table(name = "sale")
public class Sale implements Serializable {

    private static final long serialVersionUID = -1346203997433464035L;
    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name ="orderdate")
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "deliverydare")
    private Date deliveryDate;


    @Column(name = "amountproduct")
    private int amountProduct;

    public Sale() {
    }

    public Sale(int id, Date orderDate, Date deliveryDate, Set<Product> products, Set<Buyer> buyers, Set<Seller> sellers, int amountProduct) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.amountProduct = amountProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProduct(Set<Product> products) {
//        this.products = products;
//    }
//
//    public Set<Buyer> getBuyers() {
//        return buyers;
//    }
//
//    public void setBuyers(Set<Buyer> buyers) {
//        this.buyers = buyers;
//    }
//
//    public Set<Seller> getSeller() {
//        return sellers;
//    }
//
//    public void setSeller(Set<Seller> sellers) {
//        this.sellers = sellers;
//    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }
}

package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "salesequence")
@Entity
@Table(name = "sale")
public class Sale implements Serializable {

    private static final long serialVersionUID = -1346203997433464035L;
    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    private int id;

    @Column(name ="orderdate")
    private Date orderDate;

    @Column(name = "deliverydare")
    private Date deliveryDate;
    private Product product;
    private List<Buyer> buyers;
    private Seller seller;

    @Column(name = "amountproduct")
    private int amountProduct;

    public Sale() {
    }

    public Sale(int id, Date orderDate, Date deliveryDate, Product product, List<Buyer> buyers, Seller seller, int amountProduct) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.product = product;
        this.buyers = buyers;
        this.seller = seller;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Buyer> getBuyer() {
        return buyers;
    }

    public void setBuyer(List<Buyer> buyer) {
        this.buyers = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }
}

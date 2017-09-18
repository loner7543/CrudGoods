package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "SEQ_ID", sequenceName = "productsequence")
@Entity
@Table(name = "product")
public class Product implements Serializable{
    private static final long serialVersionUID = -372011220359696447L;
    @Id
    @GeneratedValue(generator = "SEQ_ID")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unitcoast")
    private int unitCoast;

    @Column(name = "unitname")
    private String unitName;
//
//    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name = "discount_id")
//    private Discount discount;


    public Product() {
    }

    public Product(String name, int unitCoast, String unitName) {
        this.name = name;
        this.unitCoast = unitCoast;
        this.unitName = unitName;
    }

    public Product(int id, String name, int unitCoast, String unitName) {
        this.id = id;
        this.name = name;
        this.unitCoast = unitCoast;
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitCoast() {
        return unitCoast;
    }

    public void setUnitCoast(int unitCoast) {
        this.unitCoast = unitCoast;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

//    public Discount getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(Discount discount) {
//        this.discount = discount;
//    }
}


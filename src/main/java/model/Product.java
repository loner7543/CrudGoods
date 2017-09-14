package model;

import javax.persistence.*;
import java.io.Serializable;

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

    public Product() {
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
}

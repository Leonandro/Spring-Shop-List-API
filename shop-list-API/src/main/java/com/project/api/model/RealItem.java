package com.project.api.model;

import javax.persistence.*;

@Entity(name = "realitem")
@Table(name = "realitem")
public class RealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REAL_ITEM")
    @SequenceGenerator(name = "SEQ_REAL_ITEM", sequenceName = "id_real_item", allocationSize = 1)
    private long id;

    private String name;

    private double price;

    private  Boolean perishable;

    private  Boolean active;

    @ManyToOne
    private  RealItem realItem;

    @ManyToOne
    private List list;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPerishable() {
        return perishable;
    }

    public void setPerishable(Boolean perishable) {
        this.perishable = perishable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public RealItem getRealItem() {
        return realItem;
    }

    public void setRealItem(RealItem realItem) {
        this.realItem = realItem;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
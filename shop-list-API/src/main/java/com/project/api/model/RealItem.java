package com.project.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    private  Boolean active;


    @ManyToOne
    private Item item;

    @JsonIgnore
    @ManyToOne
    private ItemsList list;


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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemsList getList() {
        return list;
    }

    public void setList(ItemsList list) {
        this.list = list;
    }
}

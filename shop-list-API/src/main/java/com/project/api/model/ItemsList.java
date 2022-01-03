package com.project.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "itemslist")
public class ItemsList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIST")
    @SequenceGenerator(name = "SEQ_LIST", sequenceName = "id_list", allocationSize = 1)
    private long id;

    private String name;

    private Double totalPrice;

    @JsonIgnore
    private Boolean active;

    @OneToMany(mappedBy = "list")
    private java.util.List<RealItem> items;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<RealItem> getItems() {
        return items;
    }

    public void setItems(List<RealItem> items) {
        this.items = items;
    }
}

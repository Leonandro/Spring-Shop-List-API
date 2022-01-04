package com.project.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.api.model.DTO.RealItemDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "item")
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM")
    @SequenceGenerator(name = "SEQ_ITEM", sequenceName = "id_item", allocationSize = 1)
    private long id;

    private String name;

    private double price;

    private Boolean perishable;

    @JsonIgnore
    private Boolean active;

    @OneToMany(mappedBy = "item")
    private List<RealItem> realItems;

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


    public boolean isCompatibleWith(RealItemDTO realItemDTO) {
        System.out.println(realItemDTO.getName().toLowerCase().contains(this.name.toLowerCase()) + " - " + (this.perishable == realItemDTO.getPerishable()));
        return realItemDTO.getName().toLowerCase().contains(this.name) &&
                this.perishable == realItemDTO.getPerishable();
    }

}

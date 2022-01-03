package com.project.api.model;

import javax.persistence.*;

@Entity
@Table(name = "list")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIST")
    @SequenceGenerator(name = "SEQ_LIST", sequenceName = "id_list", allocationSize = 1)
    private long id;

    private String name;

    private Double totalPrice;

    private Boolean active;

    @OneToMany(mappedBy = "list")
    private java.util.List<RealItem> items;
}

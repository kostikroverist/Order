package com.example.order.domain;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private double totalPrice;


    @OneToMany(fetch = FetchType.EAGER, cascade = {ALL}, mappedBy = "orders")
    @Column(nullable = false)
    private List<Items> items;
    @JsonIgnore
    @Column(nullable = false)
    private Date created;
    @JsonIgnore
    @Column(nullable = false)
    private boolean validityOrders = true;


    public Orders() {
    }

    public Orders(double totalPrice, List<Items> items) {
        this.totalPrice = totalPrice;
        this.items = items;
    }

    @PrePersist
    public void onCreate() {
        this.created = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isValidityOrders() {
        return validityOrders;
    }

    public void setValidityOrders(boolean validityOrders) {
        this.validityOrders = validityOrders;
    }
}

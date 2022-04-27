package com.codegym.quan_ly_tinh.model;

import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.List;

@Entity
public class Provinces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Provinces() {
    }

    public Provinces(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
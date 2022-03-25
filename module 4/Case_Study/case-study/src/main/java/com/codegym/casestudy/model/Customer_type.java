package com.codegym.casestudy.model;

import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer_type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name_id;
    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Customer_type() {
    }

    public Customer_type(long id, String name_id) {
        this.id = id;
        this.name_id = name_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }
}
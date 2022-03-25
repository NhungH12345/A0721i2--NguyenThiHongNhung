package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String birthday;
    private boolean gender;
    private String card;
    private String phone;
    private String email;
    private String address;
    @ManyToOne(targetEntity = Customer_type.class)
    private Customer_type customer_type;


    public Customer() {
    }

    public Customer(long id, String name, String birthday, boolean gender, String card, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


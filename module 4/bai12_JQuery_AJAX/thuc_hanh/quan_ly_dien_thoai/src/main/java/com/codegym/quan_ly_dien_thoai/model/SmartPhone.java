package com.codegym.quan_ly_dien_thoai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String producer;
    public String model;
    public double price;

    public SmartPhone() {
    }

    public SmartPhone(Long id, String producer, String model, double price) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return producer + ": " + model + " with price " + price;
    }

}

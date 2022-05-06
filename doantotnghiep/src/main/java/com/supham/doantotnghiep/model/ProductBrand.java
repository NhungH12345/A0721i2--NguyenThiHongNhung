package com.supham.doantotnghiep.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    @OneToMany(mappedBy = "id")
    private Set<Product> products;

    public ProductBrand() {
    }

    public ProductBrand(Long id, String name, String status, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.products = products;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

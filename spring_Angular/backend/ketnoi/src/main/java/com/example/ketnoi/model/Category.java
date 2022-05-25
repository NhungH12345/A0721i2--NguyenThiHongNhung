package com.example.ketnoi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Không được để trống")
    private String nameCategory;

//    @OneToMany(mappedBy = "product")
//    private Set<Product> products;
@OneToMany(mappedBy = "id")
private Set<Product> products;
    public Category() {
    }

    public Category(int id, @NotEmpty(message = "Không được để trống") String nameCategory, Set<Product> products) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

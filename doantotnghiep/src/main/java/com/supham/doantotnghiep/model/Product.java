package com.supham.doantotnghiep.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String quantity;
    private String image_list;
    private float price;
    private float discount;
    private String status;
    private String content;
    @ManyToOne(targetEntity = ProductType.class)
    private ProductType productType;
    @ManyToOne(targetEntity = ProductBrand.class)
    private ProductBrand productBrand;

    public Product() {
    }

    public Product(Long id, String name, String quantity, String image_list, float price, float discount, String status, String content, ProductType productType, ProductBrand productBrand) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.image_list = image_list;
        this.price = price;
        this.discount = discount;
        this.status = status;
        this.content = content;
        this.productType = productType;
        this.productBrand = productBrand;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImage_list() {
        return image_list;
    }

    public void setImage_list(String image_list) {
        this.image_list = image_list;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductBrand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        this.productBrand = productBrand;
    }
}

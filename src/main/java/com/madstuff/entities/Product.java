package com.madstuff.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prodId;

    private String name;
    private String brand;
    private Category category;
    private Double cost;

    public Product() {
    }

    public Product(String name, String brand, Category category, Double cost) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.cost = cost;
    }

    public Product(Product product) {
        this.name = product.getName();
        this.brand = product.getBrand();
        this.cost = product.getCost();
        this.setCategory(product.getCategory());
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category.getCategoryValue();
    }

    public void setCategory(String category) {

         this.category = Category.DEFAULT.getCategory(category);
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}


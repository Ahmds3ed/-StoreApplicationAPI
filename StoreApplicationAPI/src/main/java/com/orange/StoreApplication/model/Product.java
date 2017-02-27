/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ahmd Sa3ed
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private int id;
    private String name;
    private String description;
    private Integer price;
    private Integer quentity;
    
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product(String name, String description, Integer price, Integer quentity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quentity = quentity;
    }

    
    public Product(String name, String description, Integer price, Integer quentity, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quentity = quentity;
        this.category = category;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuentity() {
        return quentity;
    }

    public void setQuentity(Integer quentity) {
        this.quentity = quentity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", quentity=" + quentity + ", category=" + category.getName() + '}';
    }
    
    public boolean isEmpty(Product product){
        return product.getId()==0 && product.getName()== null && product.getDescription() == null && product.getPrice() == null && product.getQuentity() == null;
    }
    
    public static StringBuilder  ListProduct(List<Product> productList){
        StringBuilder sb = new StringBuilder();
        for (Product product : productList) {
          sb.append(product.toString());
          sb.append("\n");
        }
        return sb;
    }
}

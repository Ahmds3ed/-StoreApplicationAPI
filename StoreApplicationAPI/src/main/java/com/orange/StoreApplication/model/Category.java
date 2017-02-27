/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ahmd Sa3ed
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {
    }

    public Category(String name, String description, List<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }
    

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public boolean isEmpty(Category category){
        return category.getId()==0 && category.getName()== null && category.getDescription() == null ;
    }
    public static StringBuilder  ListCategory(List<Category> categoryList){
        StringBuilder sb = new StringBuilder();
        for (Category category : categoryList) {
          sb.append(category.toString());
          sb.append("\n");
        }
        return sb;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
}

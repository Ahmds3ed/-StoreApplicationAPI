/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.dao;

import com.orange.StoreApplication.model.Product;
import java.util.List;

/**
 *
 * @author Ahmd Sa3ed
 */
public interface ProductDao {
    
    public int addProduct(Product product);
    public Product getProduct(String name);
    public int deleteProduct(String name);
    public Product updateProduct(String productName, Product product);
    public List<Product> getAllProductFromCategory(String categoryName);
    public List<Product> getAllProduct();
}

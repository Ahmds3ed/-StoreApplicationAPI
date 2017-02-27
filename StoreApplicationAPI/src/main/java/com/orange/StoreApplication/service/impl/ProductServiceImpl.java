/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.service.impl;

import com.orange.StoreApplication.dao.ProductDao;
import com.orange.StoreApplication.model.Product;
import com.orange.StoreApplication.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmd Sa3ed
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product getProduct(String name) {
        return productDao.getProduct(name);
    }

    @Override
    @Transactional
    public int deleteProduct(String name) {
       return  productDao.deleteProduct(name);
    }

    @Override
    @Transactional
    public Product updateProduct(String productName, Product product) {
        return productDao.updateProduct(productName, product);
    }

    @Override
    public List<Product> getAllProductFromCategory(String categoryName) {
        return productDao.getAllProductFromCategory(categoryName);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

}

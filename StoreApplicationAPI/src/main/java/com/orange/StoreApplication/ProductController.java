/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import com.orange.StoreApplication.model.Category;
import com.orange.StoreApplication.model.Product;
import com.orange.StoreApplication.service.CategoryService;
import com.orange.StoreApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmd Sa3ed
 */
@RestController
//@Scope("LoggedUser")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/addProduct/{categoryName}")
    public String addProduct(@PathVariable(name = "categoryName", required = true) String categoryName, @RequestParam(value = "name", required = true) String name, @RequestParam(value = "desc", required = true) String description, @RequestParam(value = "price") int price, @RequestParam(value = "quentity") int quentity) {
        Category category = categoryService.getCategory(categoryName);
        if (category.isEmpty(category)) {
            return "Product Must Be In Category . Plz Enter a vaild Category. ";
        }
        Product product = new Product(name, description, price, quentity, category);
        int result = productService.addProduct(product);
        if (result == 0) {
            return "Product Added Failed ...";
        }
        return "Product Added Successfully ...";
    }

    @RequestMapping("/getProduct/{productName}")
    public Product getProduct(@PathVariable(name = "productName", required = true) String productName) {

        return productService.getProduct(productName);
    }

    @RequestMapping("/updateProduct/{productName}")
    public Product updateProduct(@PathVariable("productName") String productName, @RequestParam(value = "category", required = false) String categoryName, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "desc", required = false) String description, @RequestParam(value = "price", required = false) Integer price, @RequestParam(value = "quentity", required = false) Integer quentity) {
        Product product = new Product();
        if (name != null) {
            product.setName(name);
        }
        if (description != null) {
            product.setDescription(description);
        }
        if (price != null) {
            product.setPrice(price);
        }
        if (quentity != null) {
            product.setQuentity(quentity);
        }
        if (categoryName != null) {
            product.setCategory(categoryService.getCategory(categoryName));
        }

        return productService.updateProduct(productName, product);
    }

    @RequestMapping("/deleteProduct/{productName}")
    public String deleteProduct(@PathVariable(name = "productName", required = true) String productName) {
        int result = productService.deleteProduct(productName);
        if (result == 0) {
            return "Product Deleted Failed ...";
        }
        return "Product Deleted Successfully ...";
    }

    @RequestMapping("/Products/{categoryName}")
    public StringBuilder getAllProductsFromCategoey(@PathVariable(name = "categoryName", required = true) String categoryName) {
        return Product.ListProduct(productService.getAllProductFromCategory(categoryName));
    }

    @RequestMapping("/allProducts")
    public StringBuilder getAllProducts() {
        return Product.ListProduct(productService.getAllProduct());
    }
}

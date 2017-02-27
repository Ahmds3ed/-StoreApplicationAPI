/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.dao.impl;

import com.orange.StoreApplication.dao.ProductDao;
import com.orange.StoreApplication.model.Category;
import com.orange.StoreApplication.model.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmd Sa3ed
 */

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int addProduct(Product product) {
        try{
        entityManager.persist(product);
        }catch(Exception ex){
            return 0;
        }
        
        return 1;
    }

    @Override
    public Product getProduct(String name) {
        Query q = entityManager.createQuery("SELECT p FROM Product p WHERE p.name=:name ");
        q.setParameter("name", name);

        return (Product) q.getSingleResult();
    }

    @Override
    public int deleteProduct(String name) {
        Query q = entityManager.createQuery("DELETE FROM Product p WHERE P.name=:name");
        q.setParameter("name", name);
        return q.executeUpdate();
    }

    @Override
    public Product updateProduct(String productName, Product product) {
        Product p = getProduct(productName);
        if (!p.isEmpty(p)) {

            String query = "";
            if (product.getName() != null) {
                query += (query.equals("") ? " name='" + product.getName() + "'" : " , name='" + product.getName() + "'");
            }
            if (product.getDescription() != null) {
                query += (query.equals("") ? " description='" + product.getDescription() + "'" : " , description='" + product.getDescription() + "'");
            }
            if (product.getPrice() != null) {
                query += (query.equals("") ? " price=" + product.getPrice() : " , price=" + product.getPrice());
            }
            if (product.getQuentity() != null) {
                query += (query.equals("") ? " quentity=" + product.getQuentity() : " , quentity=" + product.getQuentity());
            }
            if (product.getCategory() != null) {
                query += (query.equals("") ? " category_id=" + product.getCategory().getId() : " , category_id=" + product.getCategory().getId());
            }
//        if(product.getCategory()!= null){
//         query+=(query.equals("")?" P.category.id="+product.getCategory().getId()+" , P.category.description="+product.getCategory().getDescription()+" , P.category.name="+product.getCategory().getName():" , P.category.id="+product.getCategory().getId()+" , P.category.description="+product.getCategory().getDescription()+" , P.category.name="+product.getCategory().getName());
//        }
            String nativeQuery = " UPDATE product  SET " + query + " WHERE id=" + p.getId();
            Query q = entityManager.createNativeQuery(nativeQuery, Product.class);
            q.executeUpdate();
        }
        return getProduct(product.getName());
    }

    @Override
    public List<Product> getAllProductFromCategory(String categoryName) {
        Query q = entityManager.createQuery("SELECT p FROM Product p WHERE P.category.name=:name");
        q.setParameter("name", categoryName);
        return q.getResultList();
    }

    @Override
    public List<Product> getAllProduct() {
        Query q = entityManager.createQuery("SELECT p FROM Product p");
        return q.getResultList();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.dao.impl;

import com.orange.StoreApplication.dao.CategoryDao;
import com.orange.StoreApplication.model.Category;
import java.util.List;
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
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int addCategory(Category category) {
        try{
        entityManager.persist(category);
        }catch (Exception ex){
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteCategory(String name) {
        Query q=entityManager.createQuery("DELETE  FROM Category c WHERE c.name=:name ");
        q.setParameter("name", name);
        return q.executeUpdate();
    }

    @Override
    public Category getCategory(String name) {
        Query q=entityManager.createQuery("SELECT c FROM Category c WHERE c.name=:name ");
        q.setParameter("name", name);
        return (Category) q.getSingleResult();
    }

    @Override
    public int renameCategory(String oldName, String newName) {
        
        Query q=entityManager.createNativeQuery("UPDATE Category set name='"+newName+"' where name='"+oldName+"'", Category.class);
        return q.executeUpdate();
    }

    @Override
    public List<Category> getAllCategory() {
        Query q = entityManager.createQuery("SELECT c FROM Category c");
        
        return q.getResultList();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.service.impl;

import com.orange.StoreApplication.dao.CategoryDao;
import com.orange.StoreApplication.model.Category;
import com.orange.StoreApplication.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmd Sa3ed
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public int deleteCategory(String name) {
        return categoryDao.deleteCategory(name);
    }

    @Override
    public Category getCategory(String name) {
        return categoryDao.getCategory(name);
    }

    @Override
    @Transactional
    public int renameCategory(String oldName, String newName) {
        return categoryDao.renameCategory(oldName, newName);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

}

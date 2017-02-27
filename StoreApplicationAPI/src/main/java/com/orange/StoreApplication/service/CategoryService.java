/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication.service;

import com.orange.StoreApplication.model.Category;
import java.util.List;

/**
 *
 * @author Ahmd Sa3ed
 */
public interface CategoryService {
   
    public int addCategory(Category category);
    public int deleteCategory(String name);
    public Category getCategory(String name);
    public int renameCategory(String oldName, String newName);
    public List<Category> getAllCategory();
    
}

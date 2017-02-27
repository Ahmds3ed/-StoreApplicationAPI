/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import com.orange.StoreApplication.model.Category;
import com.orange.StoreApplication.service.CategoryService;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/addCategory")
    public String addCategory(@RequestParam(value = "name", required = true) String categoryName, @RequestParam(value = "desc", required = true) String description) {
        Category category = new Category(categoryName, description);
        int result = categoryService.addCategory(category);
        if (result == 0) {
            return "Category Added Failed ...";
        }
        return "Category Added Successfully ...";
    }

    @RequestMapping("/getCategory/{categoryName}")
    public Category getCategory(@PathVariable(value = "categoryName", required = true) String categoryName) {
        
        return categoryService.getCategory(categoryName);
    }

    @RequestMapping("/renameCategory/{oldName}/{newName}")
    public String renameCategory(@PathVariable(name = "oldName", required = true) String oldName, @PathVariable(name = "newName", required = true) String newName) {
        
        int result = categoryService.renameCategory(oldName, newName);
        if (result == 0) {
            return "Category Rename Failed ...";
        }
        return "Category Rename Successfully ...";
    }

    @RequestMapping("/deleteCategory/{categoryName}")
    public String deleteCategory(@PathVariable(name = "categoryName", required = true) String categoryName) {
        int result = categoryService.deleteCategory(categoryName);
        if (result == 0) {
            return "Category Deleted Failed ...";
        }
        return "Category Deleted Successfully ...";
    }

    @RequestMapping("/allCategory")
    public StringBuilder getAllCategory() {
        return Category.ListCategory(categoryService.getAllCategory());
    }

}

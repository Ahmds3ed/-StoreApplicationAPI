/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import com.orange.StoreApplication.model.Category;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asaied
 */
public class JunitCategoryTest {
    
    public JunitCategoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
//    @Test
    public void addCategory(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/addCategory?name=cat1&desc=desc%20cat1");
        Assert.assertTrue("Category Added Successfully ...".equals(rs.get(String.class)));
    }
    
//    @Test
    public void renameCategory(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/renameCategory/cat1/category1");
        Assert.assertTrue("Category Rename Successfully ...".equals(rs.get(String.class)));
    }
    
//    @Test
    public void deleteCategory(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/deleteCategory/category1");
        Assert.assertTrue("Category Deleted Successfully ...".equals(rs.get(String.class)));
    }
    
    
}

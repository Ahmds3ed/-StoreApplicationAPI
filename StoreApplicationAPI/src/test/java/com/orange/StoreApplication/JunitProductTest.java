/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asaied
 */
public class JunitProductTest {
    
    public JunitProductTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
//    @Test
    public void addProduct(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/addProduct/toy1?name=book1&desc=book%20desc&price=20&quentity=5");
        Assert.assertTrue("Product Deleted Successfully ...".equals(rs.get(String.class)));
    }
    

    
//    @Test
    public void deleteProduct(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/deleteProduct/book1");
        Assert.assertTrue("Product Deleted Successfully ...".equals(rs.get(String.class)));
    }
}

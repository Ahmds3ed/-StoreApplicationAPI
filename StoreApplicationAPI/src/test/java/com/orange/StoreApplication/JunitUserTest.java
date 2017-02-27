/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import org.junit.Test;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import junit.framework.Assert;

/**
 *
 * @author asaied
 */
public class JunitUserTest {
    
    public JunitUserTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
//    @Test
    public void loginUser(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/login/asaied/asaied");
        Assert.assertTrue("User Login SucessFully ...".equals(rs.get(String.class)));
   
    }
    
//    @Test
    public void addUser(){
        Client client = Client.create();
        WebResource rs = client.resource("http://localhost:8080/StoreApplicationAPI/addUser?name=ahmedsaied&pass=asaied&mail=test@test.com&address=test&phone=01100928802");
        Assert.assertTrue("User Added Successfully ...".equals(rs.get(String.class)));
    }
}

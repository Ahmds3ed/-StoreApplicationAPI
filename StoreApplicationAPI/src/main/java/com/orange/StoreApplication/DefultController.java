/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lap
 */
@Controller
public class DefultController {
    
        
    @RequestMapping( value = "/")
    public String defult(){

        return "index";
    }
    
    @RequestMapping( value = "/login")
    public String login(){

        return "login";
    }
        
    
}

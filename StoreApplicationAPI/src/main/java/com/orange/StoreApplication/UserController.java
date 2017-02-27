/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.StoreApplication;

import com.orange.StoreApplication.model.User;
import com.orange.StoreApplication.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmd Sa3ed
 */
@RestController
public class UserController {

    @Autowired
    private UserService userservice;
    
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "pass", required = true) String pass, HttpServletRequest request) {
        User user = userservice.getUser(username, pass);
        request.getSession().setAttribute("LoggedUser", user);
        String login = "User Login SucessFully ...";
        if (user.isEmpty(user)) {
            login = "Login Failed !!! ";
        }
        return login;
    }
    
    @RequestMapping(value = "/login/{username}/{pass}")
    public String loginUser(@PathVariable(name = "username", required = true) String username, @PathVariable(name = "pass", required = true) String pass, HttpServletRequest request) {
        User user = userservice.getUser(username, pass);
        request.getSession().setAttribute("LoggedUser", user);
        String login = "User Login SucessFully ...";
        if (user.isEmpty(user)) {
            login = "Login Failed !!! ";
        }
        return login;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam(value = "name",required = true) String name, @RequestParam(value = "pass",required = true) String pass, @RequestParam(value = "mail",required = true) String mail, @RequestParam(value = "address",required = true) String address, @RequestParam(value = "phone",required = true) String phone) {
        User user = new User(name, pass, mail, address, phone);
        int result = userservice.insertUser(user);
        if (result == 0) {
            return "User Added Failed ...";
        }
        return "User Added Successfully ...";
    }

//    @RequestMapping("/allUser")
    public StringBuilder getAllUsers() {
        return User.ListUser(userservice.findAllUsers());
    }
    
    
    @RequestMapping( value = "/logout")
    public String logout(HttpServletRequest request){
        
        request.getSession().setAttribute("LoggedUser", null);
        return "User Logged out Successfully ";
    }
}

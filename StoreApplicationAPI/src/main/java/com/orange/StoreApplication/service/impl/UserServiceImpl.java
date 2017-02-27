package com.orange.StoreApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orange.StoreApplication.dao.UserDAO;
import com.orange.StoreApplication.model.User;
import com.orange.StoreApplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public User getUser(String name, String pass) {
        return userDAO.getUser(name, pass);
    }

}

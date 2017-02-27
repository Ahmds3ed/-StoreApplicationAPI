package com.orange.StoreApplication.service;

import java.util.List;

import com.orange.StoreApplication.model.User;

public interface UserService {

	int insertUser(User user);
        public User getUser(String name, String pass);
	List<User> findAllUsers();
}

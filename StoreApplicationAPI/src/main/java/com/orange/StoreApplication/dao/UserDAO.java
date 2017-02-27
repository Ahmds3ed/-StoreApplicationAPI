package com.orange.StoreApplication.dao;

import java.util.List;

import com.orange.StoreApplication.model.User;

public interface UserDAO {

	public int insertUser(User user);
        public User getUser(String name, String pass);
	public List<User> findAllUsers();
}

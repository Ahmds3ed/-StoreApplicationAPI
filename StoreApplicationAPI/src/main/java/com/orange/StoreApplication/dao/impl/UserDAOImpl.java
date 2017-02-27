package com.orange.StoreApplication.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.orange.StoreApplication.dao.UserDAO;
import com.orange.StoreApplication.model.User;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int insertUser(User user) {
            try{
		entityManager.persist(user);
            }catch(Exception ex){
                return 0;
            }
            return 1;
	}

	@Override
	public List<User> findAllUsers() {
		Query q=entityManager.createQuery("SELECT u FROM User u");
                return q.getResultList();
	}

    @Override
    public User getUser(String name, String pass) {
        Query q = entityManager.createQuery("SELECT u FROM User u WHERE u.name=:name AND u.password=:pass ");
        q.setParameter("name", name);
        q.setParameter("pass", pass);

        return (User) q.getSingleResult();
    }

}

package com.excilys.training.persistence.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.excilys.training.core.User;
import com.excilys.training.persistence.AbstractDao;
import com.excilys.training.persistence.contract.UserDao;

public class UserDaoImpl extends AbstractDao implements UserDao{

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<User> users = new ArrayList<User>();
		
		users = session
			.createQuery("from User where username=?")
			.setParameter(0, username).getResultList();
		for(User elem:users) {
			System.out.println(elem.getUsername());
			System.out.println(elem.getPassword());
			System.out.println(elem.isEnabled());
			System.out.println(elem.getUserRole());
		}
		session.close();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}

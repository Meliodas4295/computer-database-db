package com.excilys.training.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;

public abstract class AbstractDao {
	
	private static SessionFactory sessionFactory;

	protected static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		AbstractDao.sessionFactory = sessionFactory;
	}
	
	private static EntityManagerFactory entityManagerFactory;
	
	

	protected static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		AbstractDao.entityManagerFactory = entityManagerFactory;
	}

	private static EntityManager entityManager;

	protected static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void setEntityManager(EntityManager entityManager) {
		AbstractDao.entityManager = entityManager;
	}
	
	


}

package com.excilys.training.service;

import com.excilys.training.persistence.DAOFactory;

public abstract class AbstractService {
	private static DAOFactory daoFactory;

	protected static DAOFactory getDaoFactory() {
		return daoFactory;
	}

	public static void setDaoFactory(DAOFactory daoFactory) {
		AbstractService.daoFactory = daoFactory;
	}
	
}

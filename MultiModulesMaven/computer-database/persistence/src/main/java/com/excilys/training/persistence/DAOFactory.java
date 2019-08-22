package com.excilys.training.persistence;


import com.excilys.training.persistence.contract.CompanyDAO;
import com.excilys.training.persistence.contract.ComputerDAO;
import com.excilys.training.persistence.contract.UserDao;

public class DAOFactory {
	private ComputerDAO computerDao;
	public ComputerDAO getComputerDao() {
		return computerDao;
	}
	public void setComputerDao(ComputerDAO computerDao) {
		this.computerDao = computerDao;
	}
	
	private CompanyDAO companyDao;
	public CompanyDAO getCompanyDao() {
		return companyDao;
	}
	public void setCompanyDao(CompanyDAO companyDao) {
		this.companyDao = companyDao;
	}
	
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}

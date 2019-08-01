package com.excilys.training.persistence;


import com.excilys.training.persistence.contract.CompanyDAO;
import com.excilys.training.persistence.contract.ComputerDAO;

public class DAOFactory {
	private ComputerDAO computerDao;
	public ComputerDAO getComputerDao() {
		return computerDao;
	}
	public void setComputerDao(ComputerDAO computerDao) {
		this.computerDao = computerDao;
	}
	public CompanyDAO getCompanyDao() {
		return companyDao;
	}
	public void setCompanyDao(CompanyDAO companyDao) {
		this.companyDao = companyDao;
	}
	private CompanyDAO companyDao;
	
	
}

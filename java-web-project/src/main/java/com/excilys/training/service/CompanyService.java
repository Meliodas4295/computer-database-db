package com.excilys.training.service;

import java.util.List;

import com.excilys.training.model.Company;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.web.controller.dto.CompanyDto;
import com.excilys.training.web.controller.mapper.CompanyMapper;

public class CompanyService {
<<<<<<< HEAD
	/**
	 * objet de type CompanyDao
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private CompanyDao companyDao;
=======
	private CompanyDao company;
>>>>>>> develop
=======
	private CompanyDao company;
>>>>>>> develop
	
	/**
	 * Constructeur de la classe CompanyService, 
	 * instanciant le singleton de la classe CompanyDao
	 * @throws SQLException 
	 */
	public CompanyService() throws SQLException {
<<<<<<< HEAD
<<<<<<< HEAD
		this.companyDao = CompanyDao.getInstance();
=======
=======
>>>>>>> develop
=======
	private CompanyDao company;

	public CompanyService() {
>>>>>>> parent of 09d7b74... Add HikariCP
		super();
		this.company = CompanyDao.getInstance();
>>>>>>> develop
	}
	public Company displayCompany(int id) {
		return this.companyDao.find(id);
	}
	public List<Company> displayAllCompany() {
<<<<<<< HEAD
		return this.companyDao.displayAll();
	}
	
	public void deleteCompany(Company company) {
		this.companyDao.delete(company);
=======
		return this.getCompany().displayAll();
	}
	public CompanyDao getCompany() {
		return company;
	}

	public void setCompany(CompanyDao company) {
		this.company = company;
>>>>>>> develop
	}
	
	

}

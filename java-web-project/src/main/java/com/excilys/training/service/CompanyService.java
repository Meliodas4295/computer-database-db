package com.excilys.training.service;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.model.Company;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.web.controller.dto.CompanyDto;
import com.excilys.training.web.controller.mapper.CompanyMapper;

public class CompanyService {

	/**
	 * objet de type CompanyDao
	 */

	private CompanyDao companyDao;

	private CompanyDao company;

	private CompanyDao company;

	
	/**
	 * Constructeur de la classe CompanyService, 
	 * instanciant le singleton de la classe CompanyDao
	 * @throws SQLException 
	 */
	public CompanyService() throws SQLException {

		this.companyDao = CompanyDao.getInstance();

	private CompanyDao company;

	public CompanyService() {

	/**
	 * objet de type CompanyDao
	 */
	private CompanyDao company;
	
	/**
	 * Constructeur de la classe CompanyService, 
	 * instanciant le singleton de la classe CompanyDao
	 * @throws SQLException 
	 */
	public CompanyService() throws SQLException {
		super();
		this.company = CompanyDao.getInstance();
	}
	
	/**
	 * Permet de récupérer une Company de la BDD.
	 * @param id
	 * @return la Company ayant pour id la valeur de l'id mis en paramètre.
	 */
	public Company displayCompany(int id) {
		return this.companyDao.find(id);
	}
	/**
	 * Permet de récupérer toutes les Company de la BDD.
	 * @return la liste des Company.
	 */
	public List<Company> displayAllCompany() {
		return this.companyDao.displayAll();
	}
	
	public void deleteCompany(Company company) {
		this.companyDao.delete(company);
		return this.getCompany().displayAll();
	}
	
	/**
	 * 
	 * @return la CompanyDao.  
	 */
	public CompanyDao getCompany() {
		return company;
	}

	/**
	 * Écrit une CompanyDao.
	 * @param company
	 */
	public void setCompany(CompanyDao company) {
		this.company = company;
	}
	
	

}

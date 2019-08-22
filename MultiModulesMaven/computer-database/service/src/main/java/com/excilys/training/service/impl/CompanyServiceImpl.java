package com.excilys.training.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.core.Company;
import com.excilys.training.service.AbstractService;
import com.excilys.training.service.contract.CompanyService;

public class CompanyServiceImpl extends AbstractService implements CompanyService{
	
	/**
	 * Permet de récupérer une Company de la BDD.
	 * @param id
	 * @return la Company ayant pour id la valeur de l'id mis en paramètre.
	 * @throws SQLException 
	 */
	@Override
	public Company displayCompany(int id) throws SQLException {
		return getDaoFactory().getCompanyDao().find(id);
	}
	/**
	 * Permet de récupérer toutes les Company de la BDD.
	 * @return la liste des Company.
	 * @throws SQLException 
	 */
	@Override
	public List<Company> displayAllCompany() throws SQLException {
		return getDaoFactory().getCompanyDao().displayAll();
	}
	
	@Override
	public void deleteCompany(Company company) throws SQLException {
		getDaoFactory().getCompanyDao().delete(company);
	}
}

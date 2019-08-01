package com.excilys.training.service.impl;

import java.util.List;

import com.excilys.training.model.Company;
import com.excilys.training.service.AbstractService;
import com.excilys.training.service.contract.CompanyService;

public class CompanyServiceImpl extends AbstractService implements CompanyService{
	
	/**
	 * Permet de récupérer une Company de la BDD.
	 * @param id
	 * @return la Company ayant pour id la valeur de l'id mis en paramètre.
	 */
	@Override
	public Company displayCompany(int id) {
		return getDaoFactory().getCompanyDao().find(id);
	}
	/**
	 * Permet de récupérer toutes les Company de la BDD.
	 * @return la liste des Company.
	 */
	@Override
	public List<Company> displayAllCompany() {
		return getDaoFactory().getCompanyDao().displayAll();
	}
	
	@Override
	public void deleteCompany(Company company) {
		getDaoFactory().getCompanyDao().delete(company);
	}
}

package com.excilys.training.service;

import com.excilys.training.model.Company;
import com.excilys.training.persistence.CompanyDao;

public class CompanyService {
	private CompanyDao company;

	public CompanyService() {
		super();
		this.company = CompanyDao.getInstance();
	}
	public Company displayCompany(int id) {
		return this.getCompany().find(id);
	}
	public void displayAllCompany() {
		System.out.println(this.getCompany().displayAll());
	}
	public CompanyDao getCompany() {
		return company;
	}

	public void setCompany(CompanyDao company) {
		this.company = company;
	}
	

}

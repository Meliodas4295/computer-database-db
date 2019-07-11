package main.java.com.excilys.training.service;

import main.java.com.excilys.training.model.Company;
import main.java.com.excilys.training.persistence.CompanyDao;

public class CompanyService {
	private CompanyDao company;

	public CompanyService(CompanyDao company) {
		super();
		this.company = company;
	}
	public Company displayCompany(int id) {
		return this.getCompany().display(id);
	}
	public void displayAllCompany() {
		this.getCompany().displayAll();
	}
	public CompanyDao getCompany() {
		return company;
	}

	public void setCompany(CompanyDao company) {
		this.company = company;
	}
	

}

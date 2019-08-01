package com.excilys.training.service.contract;

import java.util.List;

import com.excilys.training.model.Company;

public interface CompanyService {

	void deleteCompany(Company company);

	List<Company> displayAllCompany();

	Company displayCompany(int id);

}

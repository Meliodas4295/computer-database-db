package com.excilys.training.persistence.contract;

import java.util.List;

import com.excilys.training.model.Company;

public interface CompanyDAO {

	List<Company> displayPagination(int limit, int offset);

	List<Company> displayAll();

	Company update(Company obj);

	void delete(Company company);

	Company create(Company obj);

	Company find(int id);

}

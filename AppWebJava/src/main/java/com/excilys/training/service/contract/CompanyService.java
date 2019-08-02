package com.excilys.training.service.contract;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.model.Company;

public interface CompanyService {

	void deleteCompany(Company company) throws SQLException;

	List<Company> displayAllCompany() throws SQLException;

	Company displayCompany(int id) throws SQLException;

}

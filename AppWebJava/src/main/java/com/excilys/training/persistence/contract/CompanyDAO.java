package com.excilys.training.persistence.contract;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.model.Company;

public interface CompanyDAO {

	List<Company> displayPagination(int limit, int offset);

	List<Company> displayAll() throws SQLException;

	Company update(Company obj);

	void delete(Company company) throws SQLException;

	Company create(Company obj);

	Company find(int id) throws SQLException;

}

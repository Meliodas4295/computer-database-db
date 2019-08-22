package com.excilys.training.persistence.contract;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.core.Company;

public interface CompanyDAO {

	List<Company> displayPagination(int limit, int offset);

	List<Company> displayAll() throws SQLException;

	void update(Company obj);

	void delete(Company company) throws SQLException;

	void create(Company obj);

	Company find(int id) throws SQLException;

}

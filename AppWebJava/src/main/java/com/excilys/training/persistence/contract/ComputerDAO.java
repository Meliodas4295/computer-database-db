package com.excilys.training.persistence.contract;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;

public interface ComputerDAO {

	List<Computer> displayPagination(int limit, int offset) throws SQLException;

	List<Computer> displayAll() throws SQLException;

	void update(Computer obj) throws SQLException;

	void delete(int id) throws SQLException;

	void create(Computer obj) throws SQLException;

	Computer find(int id) throws SQLException;

	void deleteByCompany(Company company) throws SQLException;
	
	List<Computer> searchByNameAsc(String searchName, String lettre, int limit, int offset) throws SQLException;
	
	int countAll() throws SQLException;
	

}

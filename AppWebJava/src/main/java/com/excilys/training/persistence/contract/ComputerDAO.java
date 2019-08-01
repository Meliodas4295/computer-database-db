package com.excilys.training.persistence.contract;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;

public interface ComputerDAO {

	List<Computer> displayPagination(int limit, int offset);

	List<Computer> displayAll();

	Computer update(Computer obj);

	void delete(int id);

	Computer create(Computer obj);

	Computer find(int id);

	void deleteByCompany(Company company);
	

}

package com.excilys.training.persistence.contract;

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
	
	List<Computer> SearchByNameAsc(String searchName, String lettre, int limit, int offset);
	

}

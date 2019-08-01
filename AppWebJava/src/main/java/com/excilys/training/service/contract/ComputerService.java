package com.excilys.training.service.contract;

import java.util.List;

import com.excilys.training.model.Computer;

public interface ComputerService {

	void updateComputer(Computer c);

	void deleteComputer(int id);

	void createNewComputer(Computer c);

	List<Computer> displayComputersPagination(int limit, int offset);

	List<Computer> displayAllcomputer();
	
	List<Computer> SearchComputerByName(String searchName, String lettre, int limit, int offset);

}

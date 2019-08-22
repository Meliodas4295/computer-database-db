package com.excilys.training.service.contract;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.core.Computer;

public interface ComputerService {

	void updateComputer(Computer c) throws SQLException;

	void deleteComputer(int id) throws SQLException;

	void createNewComputer(Computer c) throws SQLException;

	List<Computer> displayComputersPagination(int limit, int offset) throws SQLException;

	List<Computer> displayAllcomputer() throws SQLException;
	
	List<Computer> searchComputerByName(String searchName, String lettre, int limit, int offset) throws SQLException;
	
	Long countAllComputers() throws SQLException;

}

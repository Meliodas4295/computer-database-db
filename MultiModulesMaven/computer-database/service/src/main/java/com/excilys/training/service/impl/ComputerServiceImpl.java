package com.excilys.training.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.excilys.training.core.Computer;
import com.excilys.training.service.AbstractService;
import com.excilys.training.service.contract.ComputerService;

public class ComputerServiceImpl extends AbstractService implements ComputerService{
	
	public Long countAllComputers() throws SQLException{
		return getDaoFactory().getComputerDao().countAll();
	}
	/**
	 * Permet de récupérer toutes les Computer de la BDD.
	 * @return la liste des Computer.
	 * @throws SQLException 
	 */
	public List<Computer> displayAllcomputer() throws SQLException {
		return getDaoFactory().getComputerDao().displayAll();
	}
	
	/**
	 * Permet de récupérer toutes les Computer paginées de la BDD.
	 * @param limit
	 * @param offset
	 * @return une liste paginée des Computer.
	 * @throws SQLException 
	 */
	public List<Computer> displayComputersPagination(int limit, int offset) throws SQLException{
		return getDaoFactory().getComputerDao().displayPagination(limit, offset);
	}
	
	/**
	 * Permet de créer un Computer dans la BDD.
	 * @param c
	 * @throws SQLException 
	 */
	public void createNewComputer(Computer c) throws SQLException {
		getDaoFactory().getComputerDao().create(c);
	}
	
	/**
	 * Permet d'effacer un Computer dans la BDD.
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteComputer(int id) throws SQLException {
		getDaoFactory().getComputerDao().delete(id);
	}
	
	/**
	 * Permet de modifier un Computer dans la BDD.
	 * @param c
	 * @throws SQLException 
	 */
	public void updateComputer(Computer c) throws SQLException {
		getDaoFactory().getComputerDao().update(c);
	}
	
	public List<Computer> searchComputerByName(String searchName, String lettre, int limit, int offset) throws SQLException {
		return getDaoFactory().getComputerDao().searchByNameAsc(searchName, lettre, limit, offset);
	}
}

package com.excilys.training.service.impl;

import java.util.List;

import com.excilys.training.model.Computer;
import com.excilys.training.service.AbstractService;
import com.excilys.training.service.contract.ComputerService;

public class ComputerServiceImpl extends AbstractService implements ComputerService{
	/**
	 * Permet de récupérer toutes les Computer de la BDD.
	 * @return la liste des Computer.
	 */
	public List<Computer> displayAllcomputer() {
		return getDaoFactory().getComputerDao().displayAll();
	}
	
	/**
	 * Permet de récupérer toutes les Computer paginées de la BDD.
	 * @param limit
	 * @param offset
	 * @return une liste paginée des Computer.
	 */
	public List<Computer> displayComputersPagination(int limit, int offset){
		return getDaoFactory().getComputerDao().displayPagination(limit, offset);
	}
	
	/**
	 * Permet de créer un Computer dans la BDD.
	 * @param c
	 */
	public void createNewComputer(Computer c) {
		getDaoFactory().getComputerDao().create(c);
	}
	
	/**
	 * Permet d'effacer un Computer dans la BDD.
	 * @param id
	 */
	public void deleteComputer(int id) {
		getDaoFactory().getComputerDao().delete(id);
	}
	
	/**
	 * Permet de modifier un Computer dans la BDD.
	 * @param c
	 */
	public void updateComputer(Computer c) {
		getDaoFactory().getComputerDao().update(c);
	}
}

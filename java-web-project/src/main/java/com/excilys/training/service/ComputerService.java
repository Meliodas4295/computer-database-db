package com.excilys.training.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.mapper.ComputerMapper;

public class ComputerService {
	/**
	 * objet de type ComputerDao
	 */
	private ComputerDao computerDao;
	/**
	 * Constructeur de la classe ComputerService, 
	 * instanciant le singleton de la classe ComputerDao et ComputerMapper.
	 * @throws SQLException 
	 */
	public ComputerService() throws SQLException {
		super();
		this.computerDao = ComputerDao.getInstance();
	}
	
	/**
	 * Permet de récupérer un Computer de la BDD.
	 * @param name
	 * @return le Computer ayant pour id la valeur de l'id mis en paramètre.
	 */
	public Computer displayComputer(String name) {
		List<Computer> listComputer = computerDao.displayAll();
		List<Computer> computers = listComputer.stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
		return computers.get(0);
	}
	
	/**
	 * Permet de récupérer toutes les Computer de la BDD.
	 * @return la liste des Computer.
	 */
	public List<Computer> displayAllcomputer() {
		return this.computerDao.displayAll();
	}
	
	/**
	 * Permet de récupérer toutes les Computer paginées de la BDD.
	 * @param limit
	 * @param offset
	 * @return une liste paginée des Computer.
	 */
	public List<Computer> displayComputersPagination(int limit, int offset){
		return this.computerDao.displayPagination(limit, offset);
	}
	
	/**
	 * Permet de créer un Computer dans la BDD.
	 * @param c
	 */
	public void createNewComputer(Computer c) {
		this.computerDao.create(c);
	}
	
	/**
	 * Permet d'effacer un Computer dans la BDD.
	 * @param id
	 */
	public void deleteComputer(int id) {
		this.computerDao.delete(id);
	}
	
	/**
	 * Permet de modifier un Computer dans la BDD.
	 * @param c
	 */
	public void updateComputer(Computer c) {
		this.computerDao.update(c);
	}
	

}

package com.excilys.training.service;

import java.sql.SQLException;
import java.util.List;

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
	 * objet de type ComputerMapper
	 */
	private ComputerMapper computerMapper;

	/**
	 * Constructeur de la classe ComputerService, 
	 * instanciant le singleton de la classe ComputerDao et ComputerMapper.
	 * @throws SQLException 
	 */
	public ComputerService() throws SQLException {
		super();
		this.computerDao = ComputerDao.getInstance();
		this.computerMapper = ComputerMapper.getInstance();
	}
	
	/**
	 * Permet de récupérer un Computer de la BDD.
	 * @param name
	 * @return le Computer ayant pour id la valeur de l'id mis en paramètre.
	 */
	public Computer displayComputer(String name) {
		int id=0;
		List<Computer> listComputer = computerDao.displayAll();
		for(int i = 0;i<listComputer.size();i++) {
			if(listComputer.get(i).getName().equals(name)) {
				id = listComputer.get(i).getId(); 
				System.out.print(id);
			}
		}
		return this.getComputerDao().find(id);
	}
	
	/**
	 * Permet de récupérer toutes les Computer de la BDD.
	 * @return la liste des Computer.
	 */
	public List<Computer> displayAllcomputer() {
		return this.getComputerDao().displayAll();
	}
	
	/**
	 * Permet de récupérer toutes les Computer paginées de la BDD.
	 * @param limit
	 * @param offset
	 * @return une liste paginée des Computer.
	 */
	public List<Computer> displayComputersPagination(int limit, int offset){
		return this.getComputerDao().displayPagination(limit, offset);
	}
	
	/**
	 * Permet de créer un Computer dans la BDD.
	 * @param c
	 */
	public void createNewComputer(ComputerDto c) {
		this.getComputerDao().create(this.getComputerMapper().computerDtoToComputer(c));
	}
	
	/**
	 * Permet d'effacer un Computer dans la BDD.
	 * @param id
	 */
	public void deleteComputer(int id) {
		this.getComputerDao().delete(id);
	}
	
	/**
	 * Permet de modifier un Computer dans la BDD.
	 * @param c
	 */
	public void updateComputer(ComputerDto c) {
		this.getComputerDao().update(this.getComputerMapper().computerDtoToComputerWithId(c));
	}

	/**
	 * 
	 * @return la ComputerDao.
	 */
	public ComputerDao getComputerDao() {
		return computerDao;
	}

	/**
	 * Écrit un ComputerDao.
	 * @param computer
	 */
	public void setComputerDao(ComputerDao computer) {
		this.computerDao = computer;
	}
	
	/**
	 * 
	 * @return Le ComputerMapper.
	 */
	public ComputerMapper getComputerMapper() {
		return computerMapper;
	}
	
	/**
	 * Écrit une ComputerDao.
	 * @param computerMapper
	 */
	public void setComputerMapper(ComputerMapper computerMapper) {
		this.computerMapper = computerMapper;
	}
	

}

package com.excilys.training.service;

import java.util.List;
import java.util.stream.Collectors;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.mapper.ComputerMapper;

public class ComputerService {
	private ComputerDao computerDao;
<<<<<<< HEAD
	/**
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> develop
	 * objet de type ComputerMapper
	 */
	private ComputerMapper computerMapper;

	/**
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * Constructeur de la classe ComputerService, 
	 * instanciant le singleton de la classe ComputerDao et ComputerMapper.
	 * @throws SQLException 
	 */
	public ComputerService() throws SQLException {
=======
	private ComputerMapper computerMapper;

	public ComputerService() {
>>>>>>> parent of 09d7b74... Add HikariCP
		super();
		this.computerDao = ComputerDao.getInstance();
	}
<<<<<<< HEAD
	
	/**
	 * Permet de récupérer un Computer de la BDD.
	 * @param name
	 * @return le Computer ayant pour id la valeur de l'id mis en paramètre.
	 */
	public Computer displayComputer(String name) {
<<<<<<< HEAD
<<<<<<< HEAD
		List<Computer> listComputer = computerDao.displayAll();
		List<Computer> computers = listComputer.stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
		return computers.get(0);
=======
=======
>>>>>>> develop
		int id=0;
		List<Computer> listComputer = computerDao.displayAll();
		for(int i = 0;i<listComputer.size();i++) {
			if(listComputer.get(i).getName().equals(name)) {
				id = listComputer.get(i).getId(); 
				System.out.print(id);
			}
		}
=======
	public Computer displayComputer(int id) {
>>>>>>> parent of 09d7b74... Add HikariCP
		return this.getComputerDao().find(id);
>>>>>>> develop
	}
	
	public List<Computer> displayAllcomputer() {
		return this.computerDao.displayAll();
	}
	
	public List<Computer> displayComputersPagination(int limit, int offset){
		return this.computerDao.displayPagination(limit, offset);
	}
	
<<<<<<< HEAD
	/**
	 * Permet de créer un Computer dans la BDD.
	 * @param c
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	public void createNewComputer(Computer c) {
		this.computerDao.create(c);
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	public void createNewComputer(ComputerDto c) {
		this.getComputerDao().create(this.getComputerMapper().computerDtoToComputer(c));
>>>>>>> develop
	}
	
	public void deleteComputer(int id) {
		this.computerDao.delete(id);
	}
	
<<<<<<< HEAD
	/**
	 * Permet de modifier un Computer dans la BDD.
	 * @param c
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	public void updateComputer(Computer c) {
		this.computerDao.update(c);
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	public void updateComputer(ComputerDto c) {
		this.getComputerDao().update(this.getComputerMapper().computerDtoToComputerWithId(c));
	}

	public ComputerDao getComputerDao() {
		return computerDao;
	}

	public void setComputerDao(ComputerDao computer) {
		this.computerDao = computer;
	}
	public ComputerMapper getComputerMapper() {
		return computerMapper;
	}
	public void setComputerMapper(ComputerMapper computerMapper) {
		this.computerMapper = computerMapper;
>>>>>>> develop
	}
	

}

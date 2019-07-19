package com.excilys.training.service;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.ComputerDao;

public class ComputerService {
	private ComputerDao computer;

	public ComputerService() {
		super();
		this.computer = ComputerDao.getInstance();
	}
	public Computer displayComputer(int id) {
		return this.getComputer().find(id);
	}
	
	public void displayAllcomputer() {
		System.out.println(this.getComputer().displayAll());
	}
	
	public void createNewComputer(Computer c) {
		this.getComputer().create(c);
	}
	
	public void deleteComputer(Computer c) {
		this.getComputer().delete(c);
	}
	
	public void updateComputer(Computer c) {
		this.getComputer().update(c);
	}

	public ComputerDao getComputer() {
		return computer;
	}

	public void setComputer(ComputerDao computer) {
		this.computer = computer;
	}
	

}

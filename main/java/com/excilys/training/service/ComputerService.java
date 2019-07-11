package main.java.com.excilys.training.service;

import main.java.com.excilys.training.model.Computer;
import main.java.com.excilys.training.persistence.ComputerDao;

public class ComputerService {
	private ComputerDao computer;

	public ComputerService(ComputerDao computer) {
		super();
		this.computer = computer;
	}
	public Computer displayComputer(int id) {
		return this.getComputer().display(id);
	}
	
	public void displayAllcomputer() {
		this.getComputer().displayAll();
	}
	
	public void createNewComputer(Computer c) {
		this.getComputer().create(c);
	}
	
	public void deleteComputer(Computer c) {
		this.getComputer().delete(c);
	}
	
	public void updateComputer(Computer c, String column, String newValue) {
		this.getComputer().update(c, column, newValue);
	}

	public ComputerDao getComputer() {
		return computer;
	}

	public void setComputer(ComputerDao computer) {
		this.computer = computer;
	}
	

}

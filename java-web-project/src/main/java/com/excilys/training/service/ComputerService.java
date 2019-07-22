package com.excilys.training.service;

import java.util.List;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.mapper.ComputerMapper;

public class ComputerService {
	private ComputerDao computerDao;
	private ComputerMapper computerMapper;

	public ComputerService() {
		super();
		this.computerDao = ComputerDao.getInstance();
		this.computerMapper = ComputerMapper.getInstance();
	}
	public Computer displayComputer(int id) {
		return this.getComputerDao().find(id);
	}
	
	public List<Computer> displayAllcomputer() {
		return this.getComputerDao().displayAll();
	}
	
	public List<Computer> displayComputersPagination(int limit, int offset){
		return this.getComputerDao().displayPagination(limit, offset);
	}
	
	public void createNewComputer(ComputerDto c) {
		this.getComputerDao().create(this.getComputerMapper().computerDtoToComputer(c));
	}
	
	public void deleteComputer(ComputerDto c) {
		this.getComputerDao().delete(this.getComputerMapper().computerDtoToComputer(c));
	}
	
	public void updateComputer(ComputerDto c) {
		this.getComputerDao().update(this.getComputerMapper().computerDtoToComputer(c));
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
	}
	

}

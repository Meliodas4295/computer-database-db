package com.excilys.training.service;

import com.excilys.training.service.contract.CompanyService;
import com.excilys.training.service.contract.ComputerService;

public class ServiceFactory {
	
	private ComputerService computerService;
	private CompanyService companyService;
	public ComputerService getComputerService() {
		return computerService;
	}
	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	

}

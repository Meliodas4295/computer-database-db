package com.excilys.training.web.controller.mapper;

import com.excilys.training.model.Company;
import com.excilys.training.web.controller.dto.CompanyDto;

public class CompanyMapper {
	/**
	 * instance de la classe ComputerMapper.
	 */
	private static CompanyMapper instance;
	
	/**
	 * 
	 * @return l'instance de la classe ComputerMapper.
	 * Si l'instance est null, créer une nouvelle instance.
	 */
	public static CompanyMapper getInstance() {
	    if (instance == null) {
	      instance = new CompanyMapper();
	    }
	    return instance;
	  }
	
	public Company convertCompanyDtoToCompany(CompanyDto companyDto) {
		Company company = new Company.CompanyBuilder(companyDto.getId()).name(companyDto.getName()).build();
		return company;
	}
}

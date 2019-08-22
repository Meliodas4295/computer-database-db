package com.excilys.training.binding.mapper;

import com.excilys.training.core.Company;
import com.excilys.training.binding.dto.CompanyDTO;

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
	
	public Company convertCompanyDtoToCompany(CompanyDTO companyDto) {
		Company company = new Company.CompanyBuilder(companyDto.getId()).name(companyDto.getName()).build();
		return company;
	}
}

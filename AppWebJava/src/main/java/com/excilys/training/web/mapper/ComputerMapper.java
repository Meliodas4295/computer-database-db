package com.excilys.training.web.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.model.Company.CompanyBuilder;
import com.excilys.training.model.Computer.ComputerBuilder;
import com.excilys.training.web.dto.ComputerDTO;

public class ComputerMapper {
	
	/**
	 * Transforme un String en LocalDateTime.
	 * @param s
	 * @return un LocalDateTime.
	 */
	public LocalDateTime convert(String s) {
		
		if(s.equals("NULL")) {
			return null;
		}
		else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(s, formatter);
			return dateTime;
		}
		
	}
	
	/**
	 * Transforme un String en Integer.
	 * @param s
	 * @return un Integer.
	 */
	public Company convertCompanyId(String s) {
		if(s.equals("NULL")) {
			return null;
		}
		CompanyBuilder companyId = new Company.CompanyBuilder(Integer.parseInt(s)); 
		return companyId.build();
	}
	
	/**
	 * Transforme un ComputerDto en Computer.
	 * @param computer (ComputerDto)
	 * @return un Computer
	 */
	public Computer computerDtoToComputer(ComputerDTO computerDto) {
		int id = computerDto.getId();
		String name = computerDto.getName();
		LocalDateTime introduced = convert(computerDto.getIntroduced());
		LocalDateTime discontinued = convert(computerDto.getDiscontinued());
		Company companyId = convertCompanyId(computerDto.getCompanyId());
		ComputerBuilder computer = new Computer.ComputerBuilder().id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
		return computer.build();
	}
}

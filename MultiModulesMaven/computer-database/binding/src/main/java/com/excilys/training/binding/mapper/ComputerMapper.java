package com.excilys.training.binding.mapper;

import java.sql.Timestamp;
import com.excilys.training.core.Company;
import com.excilys.training.core.Computer;
import com.excilys.training.core.Company.CompanyBuilder;
import com.excilys.training.core.Computer.ComputerBuilder;
import com.excilys.training.binding.dto.ComputerDTO;

public class ComputerMapper {
	
	/**
	 * Transforme un String en LocalDateTime.
	 * @param s
	 * @return un LocalDateTime.
	 */
	public Timestamp convert(String s) {
		
		if(s.equals("NULL")) {
			return null;
		}
		else {
			Timestamp dateTime = Timestamp.valueOf(s);
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
		Timestamp introduced = convert(computerDto.getIntroduced());
		Timestamp discontinued = convert(computerDto.getDiscontinued());
		Company companyId = convertCompanyId(computerDto.getCompanyId());
		ComputerBuilder computer = new Computer.ComputerBuilder().id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
		return computer.build();
	}
}

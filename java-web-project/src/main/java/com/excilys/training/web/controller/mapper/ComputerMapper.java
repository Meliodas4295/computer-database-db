package com.excilys.training.web.controller.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.web.controller.dto.ComputerDto;

public class ComputerMapper {
	private static ComputerMapper instance;
	
	public static ComputerMapper getInstance() {
	    if (instance == null) {
	      instance = new ComputerMapper();
	    }
	    return instance;
	  }
	

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
	public Integer convertCompanyId(String s) {
		if(s.equals("NULL")) {
			return null;
		}
		Integer i = Integer.valueOf(s);
		return i;
	}
	
	public Computer computerDtoToComputer(ComputerDto computer) {
		Computer c =new Computer(computer.getName(),convert(computer.getIntroduced()), convert(computer.getDiscontinued()), convertCompanyId(computer.getCompany_id()));
		return c;
	}
	
	
}

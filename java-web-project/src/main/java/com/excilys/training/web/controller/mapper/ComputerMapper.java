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
		Computer c = new Computer();
		if(computer.getCompany_id()!=null) {
			if(computer.getIntroduced()==null && computer.getDiscontinued()!=null) {
				c =new Computer(computer.getName(),null, convert(computer.getDiscontinued()), convertCompanyId(computer.getCompany_id()));
			}
			else if(computer.getIntroduced()!=null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getName(),convert(computer.getIntroduced()), null, convertCompanyId(computer.getCompany_id()));
			}
			else if(computer.getIntroduced()==null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getName(),null, null, convertCompanyId(computer.getCompany_id()));
			}
			else {
				c =new Computer(computer.getName(),convert(computer.getIntroduced()), convert(computer.getDiscontinued()), convertCompanyId(computer.getCompany_id()));
			}
		}
		else {
			if(computer.getIntroduced()==null && computer.getDiscontinued()!=null) {
				c =new Computer(computer.getName(),null, convert(computer.getDiscontinued()), null);
			}
			else if(computer.getIntroduced()!=null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getName(),convert(computer.getIntroduced()), null, null);
			}
			else if(computer.getIntroduced()==null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getName(),null, null, null);
			}
			else {
				c =new Computer(computer.getName(),convert(computer.getIntroduced()), convert(computer.getDiscontinued()), null);
			}
		}
		return c;
	}
	public Computer computerDtoToComputerWithId(ComputerDto computer) {
		Computer c = new Computer();
		if(computer.getCompany_id()!=null) {
			if(computer.getIntroduced()==null && computer.getDiscontinued()!=null) {
				c =new Computer(computer.getId(),computer.getName(),null, convert(computer.getDiscontinued()), convertCompanyId(computer.getCompany_id()));
			}
			else if(computer.getIntroduced()!=null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getId(),computer.getName(),convert(computer.getIntroduced()), null, convertCompanyId(computer.getCompany_id()));
			}
			else if(computer.getIntroduced()==null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getId(),computer.getName(),null, null, convertCompanyId(computer.getCompany_id()));
			}
			else {
				c =new Computer(computer.getId(),computer.getName(),convert(computer.getIntroduced()), convert(computer.getDiscontinued()), convertCompanyId(computer.getCompany_id()));
			}
		}
		else {
			if(computer.getIntroduced()==null && computer.getDiscontinued()!=null) {
				c =new Computer(computer.getId(),computer.getName(),null, convert(computer.getDiscontinued()), null);
			}
			else if(computer.getIntroduced()!=null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getId(),computer.getName(),convert(computer.getIntroduced()), null, null);
			}
			else if(computer.getIntroduced()==null && computer.getDiscontinued()==null) {
				c =new Computer(computer.getId(),computer.getName(),null, null, null);
			}
			else {
				c =new Computer(computer.getName(),convert(computer.getIntroduced()), convert(computer.getDiscontinued()), null);
			}
		}
		return c;
	}
	
}

package main.java.com.excilys.training.web.controller.mapper;

import java.sql.Date;

import main.java.com.excilys.training.web.controller.dto.ComputerDto;

public class ComputerMapper {
	ComputerDto compterDto;
	
	


	public ComputerMapper(ComputerDto compterDto) {
		super();
		this.compterDto = compterDto;
	}




	public Date convert(String s) {
		
		if(s=="NULL" || s=="null") {
			return null;
		}
		
		return Date.valueOf(s);
		
		
	}
	




	public ComputerDto getCompterDto() {
		return compterDto;
	}




	public void setCompterDto(ComputerDto compterDto) {
		this.compterDto = compterDto;
	}
	
	
}

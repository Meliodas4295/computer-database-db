package main.java.com.excilys.training.web.controller.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import main.java.com.excilys.training.web.controller.dto.ComputerDto;

public class ComputerMapper {
	private ComputerDto compterDto;
	
	public ComputerMapper(ComputerDto compterDto) {
		super();
		this.compterDto = compterDto;
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
	
	public ComputerDto getCompterDto() {
		return compterDto;
	}

	public void setCompterDto(ComputerDto compterDto) {
		this.compterDto = compterDto;
	}
	
	
}

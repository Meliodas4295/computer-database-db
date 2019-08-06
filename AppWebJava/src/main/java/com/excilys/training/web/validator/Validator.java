package com.excilys.training.web.validator;

import java.time.LocalDateTime;

import com.excilys.training.web.dto.ComputerDTO;
import com.excilys.training.web.exception.ComputerException;
import com.excilys.training.web.exception.DateOrderException;
import com.excilys.training.web.exception.EmptyNameException;

public class Validator extends AbstractValidator{
	public void checkDate(LocalDateTime dateIntroduced, LocalDateTime dateDiscontinued) throws ComputerException{
		if(dateIntroduced!=null && dateDiscontinued!=null && dateDiscontinued.isAfter(dateIntroduced)) {
			throw new DateOrderException(
					"Date " + dateIntroduced.toString() + " must be after " + dateDiscontinued.toString());
		}
	}
	public void checkName(String name) throws ComputerException{
		if("".equals(name)) {
			throw new EmptyNameException("Name must not be empty");
		}
	}
	
	public void Validate(ComputerDTO computerDto) throws ComputerException {
		checkDate(getComputerMapper().convert(computerDto.getIntroduced()), getComputerMapper().convert(computerDto.getDiscontinued()));
		checkName(computerDto.getName());
	}
}

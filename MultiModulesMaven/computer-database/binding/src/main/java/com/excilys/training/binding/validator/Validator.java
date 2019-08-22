package com.excilys.training.binding.validator;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.excilys.training.binding.dto.ComputerDTO;
import com.excilys.training.binding.exception.ComputerException;
import com.excilys.training.binding.exception.DateOrderException;
import com.excilys.training.binding.exception.EmptyNameException;

public class Validator extends AbstractValidator{
	public void checkDate(Timestamp dateIntroduced, Timestamp dateDiscontinued) throws ComputerException{
		if(dateIntroduced!=null && dateDiscontinued!=null && dateDiscontinued.after(dateIntroduced)) {
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

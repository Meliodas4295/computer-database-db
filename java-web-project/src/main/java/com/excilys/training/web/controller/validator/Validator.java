package com.excilys.training.web.controller.validator;

import java.time.LocalDateTime;

import com.excilys.training.web.controller.exceptions.DateOrderException;
import com.excilys.training.web.controller.exceptions.EmptyNameException;

public class Validator {
	public void checkDate(LocalDateTime dateIntroduced, LocalDateTime dateDiscontinued) throws DateOrderException{
		if(dateIntroduced!=null && dateDiscontinued!=null && dateDiscontinued.isAfter(dateIntroduced)) {
			throw new DateOrderException(
					"Date " + dateIntroduced.toString() + " must be after " + dateDiscontinued.toString());
		}
	}
	public void checkName(String name) throws EmptyNameException{
		if(name==null || "".equals(name)) {
			throw new EmptyNameException("Name must not be empty");
		}
	}
}

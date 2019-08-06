package com.excilys.training.web.validator;

import com.excilys.training.web.mapper.ComputerMapper;

public abstract class AbstractValidator {
	private static ComputerMapper computerMapper;

	protected static ComputerMapper getComputerMapper() {
		return computerMapper;
	}

	public static void setComputerMapper(ComputerMapper computerMapper) {
		AbstractValidator.computerMapper = computerMapper;
	}
}

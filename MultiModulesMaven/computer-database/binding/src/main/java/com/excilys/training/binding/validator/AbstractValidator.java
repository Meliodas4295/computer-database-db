package com.excilys.training.binding.validator;

import com.excilys.training.binding.mapper.ComputerMapper;

public abstract class AbstractValidator {
	private static ComputerMapper computerMapper;

	protected static ComputerMapper getComputerMapper() {
		return computerMapper;
	}

	public static void setComputerMapper(ComputerMapper computerMapper) {
		AbstractValidator.computerMapper = computerMapper;
	}
}

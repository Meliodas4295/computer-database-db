package com.excilys.training.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.training.model.Computer;
import com.excilys.training.service.ComputerService;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.mapper.ComputerMapper;

public class AddComputer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
	    String introduced = request.getParameter("introduced") + " 00:00:00";
	    String discontinued = request.getParameter("discontinued") + " 00:00:00";
	    String companyId = request.getParameter("companyId");
	    ComputerDto computerDto = new ComputerDto(Integer.parseInt(id), name, introduced, discontinued, companyId );
  		ComputerService computer = new ComputerService();
  		computer.createNewComputer(computerDto);
	}
}

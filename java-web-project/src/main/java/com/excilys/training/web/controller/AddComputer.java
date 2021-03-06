package com.excilys.training.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.service.CompanyService;
import com.excilys.training.service.ComputerService;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.dto.ComputerDto.ComputerDtoBuilder;
import com.excilys.training.web.controller.mapper.ComputerMapper;

public class AddComputer extends HttpServlet {
	

	private CompanyService companyService;
	private ComputerService computerService;

	private ComputerMapper computerMapper;

	
	public AddComputer() throws SQLException {
		super();
		this.companyService = new CompanyService();
		this.computerService = new ComputerService();

		this.computerMapper = ComputerMapper.getInstance();

	}
	private CompanyService companyService = new CompanyService();
	private ComputerService computerService = new ComputerService();
	
	private CompanyService companyService;
	private ComputerService computerService;
	
	public AddComputer() throws SQLException {
		super();
		this.companyService = new CompanyService();
		this.computerService = new ComputerService();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		String name = request.getParameter("computerName");
	    String introduced = request.getParameter("introduced");
	    String discontinued = request.getParameter("discontinued");
	    String companyId = request.getParameter("companyId");
	    ComputerDtoBuilder computerDto = new ComputerDto.ComputerDtoBuilder(name, introduced, discontinued, companyId );
	    computerService.createNewComputer(this.computerMapper.computerDtoToComputer(computerDto.build()));

	    ComputerDto computerDto = new ComputerDto(name, introduced, discontinued, companyId );

  		computerService.createNewComputer(computerDto);

  		ComputerService computer = new ComputerService();
  		computer.createNewComputer(computerDto);

  		computerService.createNewComputer(computerDto);

  		ServletContext context = getServletContext();
  	    RequestDispatcher rd = context.getRequestDispatcher("/DashboardServlet");
  	    rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
		List<Company> companies = companyService.displayAllCompany();
		req.setAttribute("companies", companies);
		this.getServletContext().getRequestDispatcher("/addComputer.jsp").forward(req, resp);
	}
}

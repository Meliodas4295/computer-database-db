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
import com.excilys.training.service.CompanyService;
import com.excilys.training.service.ComputerService;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.dto.ComputerDto.ComputerDtoBuilder;
import com.excilys.training.web.controller.mapper.ComputerMapper;

public class EditComputer extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CompanyService companyService;
	private ComputerService computerService;
	private ComputerMapper computerMapper;
	private CompanyService companyService;
	private ComputerService computerService;

	private CompanyService companyService;
	private ComputerService computerService;

	private CompanyService companyService;
	private ComputerService computerService;
	
	public EditComputer() throws SQLException {
		super();
		this.companyService = new CompanyService();
		this.computerService = new ComputerService();

		this.computerMapper = ComputerMapper.getInstance();

		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
	}
	private CompanyService companyService = new CompanyService();
	private ComputerService computerService = new ComputerService();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> companies = companyService.displayAllCompany();
		req.setAttribute("companies", companies);
		String id  = req.getParameter("computerId");
		req.setAttribute("id", id);
		this.getServletContext().getRequestDispatcher("/editComputer.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id  = req.getParameter("computerId");
		String name = req.getParameter("computerName");
	    String introduced = req.getParameter("introduced");
	    String discontinued = req.getParameter("discontinued");
	    String companyId = req.getParameter("companyId");
	    ComputerDtoBuilder computerDto = new ComputerDto.ComputerDtoBuilder(name, introduced, discontinued, companyId ).id(Integer.parseInt(id));
  		computerService.updateComputer(this.computerMapper.computerDtoToComputer(computerDto.build()));
	    ComputerDto computerDto = new ComputerDto(Integer.parseInt(id),name, introduced, discontinued, companyId );

  		computerService.updateComputer(computerDto);


	    ComputerService computer = new ComputerService();
  		computer.updateComputer(computerDto);

  		computerService.updateComputer(computerDto);

  		ServletContext context = getServletContext();
  	    RequestDispatcher rd = context.getRequestDispatcher("/DashboardServlet");
  	    rd.forward(req, resp);
	}

}

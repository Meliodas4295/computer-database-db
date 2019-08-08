package com.excilys.training.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.training.model.Company;
import com.excilys.training.web.dto.ComputerDTO;
import com.excilys.training.web.dto.ComputerDTO.ComputerDTOBuilder;
import com.excilys.training.web.mapper.ComputerMapper;

public class AddComputer extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AddComputer() throws SQLException {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		String name = request.getParameter("computerName");
	    String introduced = request.getParameter("introduced");
	    String discontinued = request.getParameter("discontinued");
	    String companyId = request.getParameter("companyId");
	    ComputerDTOBuilder computerDto = new ComputerDTO.ComputerDTOBuilder(name, introduced, discontinued, companyId );
	    ComputerMapper computerMapper = new ComputerMapper();
	    try {
			AbstractServlet.getServiceFactory().getComputerService().createNewComputer(computerMapper.computerDtoToComputer(computerDto.build()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		ServletContext context = getServletContext();
  	    RequestDispatcher rd = context.getRequestDispatcher("/DashboardServlet");
  	    rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
		List<Company> companies = new ArrayList<Company>();
		try {
			companies = AbstractServlet.getServiceFactory().getCompanyService().displayAllCompany();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("companies", companies);
		this.getServletContext().getRequestDispatcher("/addComputer.jsp").forward(req, resp);
	}
}

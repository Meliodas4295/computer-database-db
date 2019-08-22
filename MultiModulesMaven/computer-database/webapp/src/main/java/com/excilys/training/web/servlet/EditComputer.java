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

import com.excilys.training.core.Company;
import com.excilys.training.binding.dto.ComputerDTO;
import com.excilys.training.binding.dto.ComputerDTO.ComputerDTOBuilder;
import com.excilys.training.binding.mapper.ComputerMapper;

public class EditComputer extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EditComputer() throws SQLException {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> companies = new ArrayList<Company>();
		try {
			companies = AbstractServlet.getServiceFactory().getCompanyService().displayAllCompany();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	    ComputerDTOBuilder computerDto = new ComputerDTO.ComputerDTOBuilder(name, introduced, discontinued, companyId ).id(Integer.parseInt(id));
	    ComputerMapper computerMapper = new ComputerMapper();
	    try {
			AbstractServlet.getServiceFactory().getComputerService().updateComputer(computerMapper.computerDtoToComputer(computerDto.build()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		ServletContext context = getServletContext();
  	    RequestDispatcher rd = context.getRequestDispatcher("/DashboardServlet");
  	    rd.forward(req, resp);
	}

}

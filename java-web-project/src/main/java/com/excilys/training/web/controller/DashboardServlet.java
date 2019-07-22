package com.excilys.training.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.service.ComputerService;

public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComputerService computerService = new ComputerService();
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
			List<Computer> computers = computerService.displayAllcomputer();
			int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
			List<Computer> computerPage = computerService.displayComputersPagination(25, (queryPage-1)*25);
		    req.setAttribute("list", computerPage);
		    int nbPc = computers.size();
		    int pageSize = computerPage.size();
		    int divider = pageSize != 0 ? pageSize : 1;
		    int nbPage = nbPc / divider;
		    req.setAttribute("size", nbPc);
		    req.setAttribute("nbPages", nbPage);
		    this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
			
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      doGet(request, response);
		    }
}

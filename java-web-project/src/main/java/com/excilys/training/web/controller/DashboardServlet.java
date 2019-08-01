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
<<<<<<< HEAD
	private ComputerService computerService;
	
	   public DashboardServlet() throws SQLException {
		super();
		this.computerService = new ComputerService();
<<<<<<< HEAD
<<<<<<< HEAD
=======
		// TODO Auto-generated constructor stub
>>>>>>> develop
=======
		// TODO Auto-generated constructor stub
>>>>>>> develop
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
=======
	private ComputerService computerService = new ComputerService();
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
>>>>>>> parent of 09d7b74... Add HikariCP
	         throws ServletException, IOException {
		   String[] valeurs = req.getParameterValues("selection");
		    if(valeurs!=null) {
		    	for(int i = 0; i<valeurs.length;i++) {
		    		computerService.deleteComputer(Integer.parseInt(valeurs[i]));
		    	}
		    }
<<<<<<< HEAD
		   String search = req.getParameter("search");
		   List<Computer> searchComputer = new ArrayList<Computer>();
		    if(search!=null && search!="") {
		    	searchComputer.add(computerService.displayComputer(search));
		    	req.setAttribute("list", searchComputer);
<<<<<<< HEAD
<<<<<<< HEAD
=======
		    	System.out.println(search);
>>>>>>> develop
=======
		    	System.out.println(search);
>>>>>>> develop
		    	int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
			    int nbPc = searchComputer.size();
			    int pageSize = searchComputer.size();
			    int divider = pageSize != 0 ? pageSize : 1;
			    int nbPage = nbPc / divider;
			    req.setAttribute("size", nbPc);
			    if(nbPc%divider==0) {
			    	req.setAttribute("nbPages", nbPage);
			    }
			    else {
			    	req.setAttribute("nbPages", nbPage+1);
			    }
		    }
		    else {
<<<<<<< HEAD
<<<<<<< HEAD
		    	int nombreValeurParPage = 50;
				List<Computer> computers = computerService.displayAllcomputer();
				int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
				List<Computer> computerPage = computerService.displayComputersPagination(nombreValeurParPage, (queryPage-1)*nombreValeurParPage);
			    req.setAttribute("list", computerPage);
			    int nbPc = computers.size();
			    int pageSize = nombreValeurParPage;
=======
=======
>>>>>>> develop
				List<Computer> computers = computerService.displayAllcomputer();
				int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
				List<Computer> computerPage = computerService.displayComputersPagination(25, (queryPage-1)*25);
			    req.setAttribute("list", computerPage);
			    int nbPc = computers.size();
			    int pageSize = computerPage.size();
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
			    int divider = pageSize != 0 ? pageSize : 1;
			    int nbPage = nbPc / divider;
			    req.setAttribute("size", nbPc);
			    if(nbPc%divider==0) {
			    	req.setAttribute("nbPages", nbPage);
			    }
			    else {
			    	req.setAttribute("nbPages", nbPage+1);
			    }
=======
			List<Computer> computers = computerService.displayAllcomputer();
			int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
			List<Computer> computerPage = computerService.displayComputersPagination(25, (queryPage-1)*25);
		    req.setAttribute("list", computerPage);
		    int nbPc = computers.size();
		    int pageSize = computerPage.size();
		    int divider = pageSize != 0 ? pageSize : 1;
		    int nbPage = nbPc / divider;
		    req.setAttribute("size", nbPc);
		    if(nbPc%divider==0) {
		    	req.setAttribute("nbPages", nbPage);
		    }
		    else {
		    	req.setAttribute("nbPages", nbPage+1);
>>>>>>> parent of 09d7b74... Add HikariCP
		    }
		    this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
			
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      doGet(request, response);
		    }
}

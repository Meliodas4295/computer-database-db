package com.excilys.training.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.training.model.Computer;

public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   public DashboardServlet() throws SQLException {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
		   String[] valeurs = req.getParameterValues("selection");
		    if(valeurs!=null) {
		    	System.out.println(valeurs[0]);
		    	for(int i = 0; i<valeurs.length;i++) {
		    		try {
						AbstractServlet.getServiceFactory().getComputerService().deleteComputer(Integer.parseInt(valeurs[i]));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
		    String search = req.getParameter("search");
			List<Computer> searchComputer = new ArrayList<Computer>();
			if(search!=null && search!=""){
				int nombreValeurParPage = 1;
		    	int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
		    	try {
					searchComputer = AbstractServlet.getServiceFactory().getComputerService().searchComputerByName(search, search ,nombreValeurParPage, (queryPage-1)*nombreValeurParPage);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	req.setAttribute("list", searchComputer);
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
			    int nombreValeurParPage = 50;
				List<Computer> computers = new ArrayList<Computer>();
				try {
					computers = AbstractServlet.getServiceFactory().getComputerService().displayAllcomputer();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int queryPage = req.getParameter("page") != null ? Integer.parseInt(req.getParameter("page")) : 1;
				List<Computer> computerPage = new ArrayList<Computer>();
				try {
					computerPage = AbstractServlet.getServiceFactory().getComputerService().displayComputersPagination(nombreValeurParPage, (queryPage-1)*nombreValeurParPage);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    req.setAttribute("list", computerPage);
			    int nbPc = computers.size();
			    int pageSize = nombreValeurParPage;
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
		    this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
			
	   }
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      doGet(request, response);
		    }
}

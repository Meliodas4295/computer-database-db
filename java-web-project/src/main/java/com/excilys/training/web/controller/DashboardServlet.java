package com.excilys.training.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.service.ComputerService;

public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String url = "jdbc:mysql://localhost:3306/computer-database-db";
	private static final String user = "admincdb";
	private static final String passwd = "qwerty1234";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private Connection conn;
	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
			
			
		
			try {
			      Class.forName(driver);
			      conn = DriverManager.getConnection(url, user, passwd);
			      ComputerDao computerDao = new ComputerDao();
		      	  ComputerService computerService = new ComputerService();
		      	  computerService.displayAllcomputer();
		      	  System.out.println(computerDao.displayPagination(10, 0));
			      }
			catch (Exception e) {
				      e.printStackTrace();
				    } 
			
	   }
}

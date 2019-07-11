package main.java.com.excilys.training.web.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import main.java.com.excilys.training.model.Computer;
import main.java.com.excilys.training.persistence.CompanyDao;
import main.java.com.excilys.training.persistence.ComputerDao;
import main.java.com.excilys.training.service.CompanyService;
import main.java.com.excilys.training.service.ComputerService;
import main.java.com.excilys.training.web.controller.dto.ComputerDto;
import main.java.com.excilys.training.web.controller.mapper.ComputerMapper;


public class App{
	
	

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/computer-database-db";
		String user = "admincdb";
		String passwd = "qwerty1234";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection conn;
		
		
	
		try {
		      Class.forName(driver);
		      System.out.println("Driver O.K.");

		      conn = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");
		      
		      System.out.println("-------------------------------");
		      System.out.println("              MENU             ");
		      System.out.println("-------------------------------");
		      System.out.println("1- Afficher la liste des entreprises");
		      System.out.println("2- Afficher la liste des ordinateurs");
		      System.out.println("3- Créer un nouvel ordinateur");
		      System.out.println("4- Effacer un ordinateur");
		      System.out.println("5- Modifier un ordinateur");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("Veuillez choisir une action (un nombre entre 1 et 5) :");
		      int action = sc.nextInt();
		      if(action==1) {
		    	  CompanyDao companyDao = new CompanyDao(conn);
		      	  CompanyService companyService = new CompanyService(companyDao);
		      	  companyService.displayAllCompany();
		      }
		      else if(action==2) {
		    	  ComputerDao computerDao = new ComputerDao(conn);
		      	  ComputerService computerService = new ComputerService(computerDao);
		      	  computerService.displayAllcomputer();
		      }
		      else {
			      switch(action) {
			      	
			      	case 3:
			      		Scanner sc10 = new Scanner(System.in);
			      		System.out.print("Veuillez insérer un id :");
			      		int id = sc10.nextInt();
			      		Scanner sc20 = new Scanner(System.in);
			      		System.out.print("Veuillez insérer un name :");
			      		String name = sc20.nextLine();
			      		Scanner sc30 = new Scanner(System.in);
			      		System.out.print("Veuillez insérer une date d'introduction:");
			      		String introduced = sc30.nextLine();
			      		Scanner sc40 = new Scanner(System.in);
			      		System.out.print("Veuillez insérer une date d'arrêt:");
			      		String discontinued = sc40.nextLine();
			      		Scanner sc50 = new Scanner(System.in);
			      		System.out.print("Veuillez insérer une date d'arrêt:");
			      		int company_id = sc50.nextInt();
			      		ComputerDto computerDto = new ComputerDto(id, name, introduced, discontinued, company_id );
			      		ComputerMapper computerMapper = new ComputerMapper(computerDto);
			      		Computer computer = new Computer(computerDto.getId(), computerDto.getName(),computerMapper.convert(computerDto.getIntroduced()), computerMapper.convert(computerDto.getDiscontinued()), computerDto.getCompany_id());
			      		ComputerDao computerDaoCreate = new ComputerDao(conn);
			      		ComputerService computerServiceCreate = new ComputerService(computerDaoCreate);
			      		computerServiceCreate.createNewComputer(computer);
			      		break;
			      	case 4:
			      		
			      		
			      }
		      
		      }
		      
		    } 
		catch (Exception e) {
		      e.printStackTrace();
		    }      
}
}

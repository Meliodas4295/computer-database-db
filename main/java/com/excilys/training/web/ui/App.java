package main.java.com.excilys.training.web.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.Month;
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
		      String choix;
		      do {
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
			      	  System.out.println(computerDao.computers());
			      }
			      else {
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
			      	  System.out.print("Veuillez insérer l'id de l'entreprise:");
			      	  int company_id = sc50.nextInt();
			      	  
			      	ComputerDto computerDto = new ComputerDto(id, name, introduced, discontinued, company_id );
		      		ComputerMapper computerMapper = new ComputerMapper(computerDto);
		      		Computer computer = new Computer(computerDto.getId(), computerDto.getName(),computerMapper.convert(computerDto.getIntroduced()), computerMapper.convert(computerDto.getDiscontinued()), computerDto.getCompany_id());
				      switch(action) {
				      	
				      	case 3:
				      		
				      		ComputerDao computerDaoCreate = new ComputerDao(conn);
				      		ComputerService computerServiceCreate = new ComputerService(computerDaoCreate);
				      		computerServiceCreate.createNewComputer(computer);
				      		break;
				      	case 4:
				      		ComputerDao computerDaoDelete = new ComputerDao(conn);
				      		ComputerService computerServiceDelete = new ComputerService(computerDaoDelete);
				      		computerServiceDelete.deleteComputer(computer);
				      		break;
				      		
				      	case 5:
				      		ComputerDao computerDaoUpdate = new ComputerDao(conn);
				      		ComputerService computerServiceUpdate = new ComputerService(computerDaoUpdate);
				      		computerServiceUpdate.deleteComputer(computer);
				      		break;
				      		
				      }
			      
			      }
		      Scanner scan = new Scanner(System.in);
		      System.out.println("Voulez-vous effecter une autre action?(oui/non):");
		      choix = scan.nextLine();
		      }while(choix.equals("oui"));
			      
			    } 
			catch (Exception e) {
			      e.printStackTrace();
			    }  
}
}

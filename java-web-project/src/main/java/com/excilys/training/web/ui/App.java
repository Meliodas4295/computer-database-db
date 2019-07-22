package com.excilys.training.web.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

import com.excilys.training.model.Computer;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.service.CompanyService;
import com.excilys.training.service.ComputerService;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.mapper.ComputerMapper;


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
			      	  CompanyService companyService = new CompanyService();
			      	  companyService.displayAllCompany();
			      }
			      else if(action==2) {
			    	  ComputerDao computerDao = new ComputerDao();
			      	  ComputerService computerService = new ComputerService();
			      	  List<Computer> comp = computerService.displayComputersPagination(10, 0);
			      	  for(int i = 0;i<comp.size();i++) {
			      		  System.out.println(comp.get(i));
			      	  }
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
			      	  String company_id = sc50.nextLine();
			      	  
			      	ComputerDto computerDto = new ComputerDto(id, name, introduced, discontinued, company_id );
		      		ComputerMapper computerMapper = new ComputerMapper();
		      		Computer computer = new Computer(computerDto.getId(), computerDto.getName(),computerMapper.convert(computerDto.getIntroduced()), computerMapper.convert(computerDto.getDiscontinued()), computerMapper.convertCompanyId(computerDto.getCompany_id()));
				      switch(action) {
				      	
				      	case 3:
				      		
				      		ComputerDao computerDaoCreate = new ComputerDao();
				      		ComputerService computerServiceCreate = new ComputerService();
				      		computerServiceCreate.createNewComputer(computerDto);
				      		break;
				      	case 4:
				      		ComputerDao computerDaoDelete = new ComputerDao();
				      		ComputerService computerServiceDelete = new ComputerService();
				      		computerServiceDelete.deleteComputer(computerDto);
				      		break;
				      		
				      	case 5:
				      		ComputerDao computerDaoUpdate = new ComputerDao();
				      		ComputerService computerServiceUpdate = new ComputerService();
				      		computerServiceUpdate.deleteComputer(computerDto);
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

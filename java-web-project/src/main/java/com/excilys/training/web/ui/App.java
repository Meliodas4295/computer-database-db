package com.excilys.training.web.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.model.Computer.ComputerBuilder;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.persistence.ComputerDao;
import com.excilys.training.service.CompanyService;
import com.excilys.training.service.ComputerService;
import com.excilys.training.web.controller.dto.CompanyDto;
import com.excilys.training.web.controller.dto.CompanyDto.CompanyDtoBuilder;
import com.excilys.training.web.controller.dto.ComputerDto;
import com.excilys.training.web.controller.dto.ComputerDto.ComputerDtoBuilder;
import com.excilys.training.web.controller.mapper.CompanyMapper;
import com.excilys.training.web.controller.mapper.ComputerMapper;


public class App{
	

	public static void main(String[] args) {

		try {
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
			      System.out.println("6- Effacer une entreprise");
			      Scanner sc = new Scanner(System.in);
			      System.out.print("Veuillez choisir une action (un nombre entre 1 et 5) :");
			      int action = sc.nextInt();
			      if(action==1) {
			      	  CompanyService companyService = new CompanyService();
			      	  List<Company> companyList =companyService.displayAllCompany();
			      	  for(int i = 0;i<companyList.size();i++) {
			      		  System.out.println(companyList.get(i));
			      	  }
			      }
			      else if(action==2) {
			      	  ComputerService computerService = new ComputerService();
			      	  List<Computer> computerList = computerService.displayAllcomputer();
			      	  for(int i = 0;i<computerList.size();i++) {
			      		  System.out.println(computerList.get(i));
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
			      	  
			      	ComputerDtoBuilder computerDto = new ComputerDto.ComputerDtoBuilder(name, introduced, discontinued, company_id ).id(id);
			      	CompanyDto company = new CompanyDto.CompanyDtoBuilder(Integer.parseInt(company_id)).build();
			      	ComputerMapper computerMapper = ComputerMapper.getInstance();
			      	CompanyMapper companyMapper = CompanyMapper.getInstance();
				      switch(action) {
				      	
				      	case 3:
				      		ComputerService computerServiceCreate = new ComputerService();
				      		computerServiceCreate.createNewComputer(computerMapper.computerDtoToComputer(computerDto.build()));
				      		break;
				      	case 4:
				      		ComputerService computerServiceDelete = new ComputerService();
				      		computerServiceDelete.deleteComputer(computerDto.build().getId());
				      		break;
				      		
				      	case 5:
				      		ComputerService computerServiceUpdate = new ComputerService();
				      		computerServiceUpdate.updateComputer(computerMapper.computerDtoToComputer(computerDto.build()));
				      		break;
				      	case 6:
				      		CompanyService companyServiceDelete = new CompanyService();
				      		companyServiceDelete.deleteCompany(companyMapper.convertCompanyDtoToCompany(company));
				      		
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

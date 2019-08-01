package com.excilys.training.web.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.excilys.training.jdbc.ConnectionMySQL;
import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.persistence.DAOFactory;
import com.excilys.training.persistence.impl.CompanyDAOImpl;
import com.excilys.training.persistence.impl.ComputerDAOImpl;
import com.excilys.training.service.AbstractService;
import com.excilys.training.service.ServiceFactory;
import com.excilys.training.service.impl.CompanyServiceImpl;
import com.excilys.training.service.impl.ComputerServiceImpl;
import com.excilys.training.web.dto.ComputerDTO;
import com.excilys.training.web.dto.ComputerDTO.ComputerDTOBuilder;
import com.excilys.training.web.mapper.ComputerMapper;

public class App extends AbstractUi{
	
	public static void main(String[] args) {
		
		DAOFactory daoFactory = new DAOFactory();
		ServiceFactory serviceFactory = new ServiceFactory();
		
		try {
			daoFactory.setCompanyDao(CompanyDAOImpl.getInstance());
			daoFactory.setComputerDao(ComputerDAOImpl.getInstance());
			serviceFactory.setCompanyService(new CompanyServiceImpl());
			serviceFactory.setComputerService(new ComputerServiceImpl());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		AbstractService.setDaoFactory(daoFactory);
		AbstractUi.setServiceFactory(serviceFactory);

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
			      	  List<Company> companyList = getServiceFactory().getCompanyService().displayAllCompany();
			      	  for(int i = 0;i<companyList.size();i++) {
			      		  System.out.println(companyList.get(i));
			      	  }
			      }
			      else if(action==2) {
			      	  List<Computer> computerList = getServiceFactory().getComputerService().displayAllcomputer();
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
			      	  
			      	ComputerDTOBuilder computerDto = new ComputerDTO.ComputerDTOBuilder(name, introduced, discontinued, company_id ).id(id);
			      	//CompanyDTO company = new CompanyDTO.CompanyDtoBuilder(Integer.parseInt(company_id)).build();
			      	ComputerMapper computerMapper = ComputerMapper.getInstance();
			      	//CompanyMapper companyMapper = CompanyMapper.getInstance();
				      switch(action) {
				      	
				      	case 3:
				      		getServiceFactory().getComputerService().createNewComputer(computerMapper.computerDtoToComputer(computerDto.build()));
				      		break;
				      	case 4:
				      		getServiceFactory().getComputerService().deleteComputer(computerDto.build().getId());
				      		break;
				      		
				      	case 5:
				      		getServiceFactory().getComputerService().updateComputer(computerMapper.computerDtoToComputer(computerDto.build()));
				      		break;
				      	//case 6:
				      	//	getServiceFactory().getComputerService().deleteCompany(companyMapper.convertCompanyDtoToCompany(company));
				      		
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

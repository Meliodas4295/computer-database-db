package com.excilys.training.web.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.excilys.training.persistence.DAOFactory;
import com.excilys.training.persistence.impl.CompanyDAOImpl;
import com.excilys.training.persistence.impl.ComputerDAOImpl;
import com.excilys.training.service.AbstractService;
import com.excilys.training.service.ServiceFactory;
import com.excilys.training.service.impl.CompanyServiceImpl;
import com.excilys.training.service.impl.ComputerServiceImpl;
import com.excilys.training.web.servlet.AbstractServlet;

public class DependencyInjectionListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
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
		AbstractServlet.setServiceFactory(serviceFactory);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

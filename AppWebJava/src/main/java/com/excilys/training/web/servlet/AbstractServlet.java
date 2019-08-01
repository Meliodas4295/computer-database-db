package com.excilys.training.web.servlet;

import com.excilys.training.service.ServiceFactory;

public abstract class AbstractServlet {
	private static ServiceFactory serviceFactory;

	protected static ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public static void setServiceFactory(ServiceFactory serviceFactory) {
		AbstractServlet.serviceFactory = serviceFactory;
	}

}

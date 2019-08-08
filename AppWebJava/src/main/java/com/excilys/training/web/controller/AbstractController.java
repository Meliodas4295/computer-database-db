package com.excilys.training.web.controller;

import com.excilys.training.service.ServiceFactory;

public abstract class AbstractController {
	private static ServiceFactory serviceFactory;

	protected static ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public static void setServiceFactory(ServiceFactory serviceFactory) {
		AbstractController.serviceFactory = serviceFactory;
	}

	
}

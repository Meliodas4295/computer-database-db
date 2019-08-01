package com.excilys.training.web.ui;

import com.excilys.training.service.ServiceFactory;

public abstract class AbstractUi {
	private static ServiceFactory serviceFactory;

	protected static ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public static void setServiceFactory(ServiceFactory serviceFactory) {
		AbstractUi.serviceFactory = serviceFactory;
	}

}

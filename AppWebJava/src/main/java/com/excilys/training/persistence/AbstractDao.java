package com.excilys.training.persistence;

import javax.sql.DataSource;

public abstract class AbstractDao {
	
	private static DataSource dataSource;

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		AbstractDao.dataSource = dataSource;
	}


}

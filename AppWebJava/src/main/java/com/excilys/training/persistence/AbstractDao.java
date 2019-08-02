package com.excilys.training.persistence;

import javax.sql.DataSource;

public abstract class AbstractDao {
	
	private DataSource dataSource;

	protected DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

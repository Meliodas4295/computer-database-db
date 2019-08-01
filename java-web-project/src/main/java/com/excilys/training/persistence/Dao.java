package com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.excilys.training.jdbc.ConnectionMySQL;

public abstract class Dao<T> {
	
	public Connection connect;
	
	
	public Dao() throws SQLException{
		super();
		this.connect = ConnectionMySQL.getInstance();
	}

	public abstract T find(int id);
	
	public abstract List<T> displayPagination(int limit, int offset);
	
	public abstract List<T> displayAll();
	
	public abstract T create(T obj);
	
	public abstract void delete(int id);
	
	public abstract T update(T obj);
	
	
}

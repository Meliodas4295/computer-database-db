package main.java.com.excilys.training.persistence;

import java.sql.Connection;

public abstract class Dao<T> {
	Connection conn;
	
	public abstract T display(int id);
	
	public abstract void displayAll();
	
	public abstract void create(T obj);
	
	public abstract void delete(T obj);
	
	public abstract void update(T obj, String column, String newValue);

	public Dao(Connection conn) {
		super();
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
}

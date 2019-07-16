package main.java.com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.java.com.excilys.training.model.Company;
import main.java.com.excilys.training.model.Computer;

public abstract class Dao<T> {
	Connection conn;
	private final String SQL_FIND_ALL = "SELECT * FROM computer";
	private final String SQL_FIND_BY_ID = "SELECT * FROM computer WHERE id = ? ";
	private final String SQL_CREATE = "INSERT INTO computer (id, name, introduced,discontinued,company_id) VALUES (?,?,?,?,?)";
	private final String SQL_DELETE = "DELETE FROM computer WHERE id = ?";
	private final String SQL_UPDATE = "UPDATE computer SET name = ?, introduced = ?,discontinued = ?,company_id = ? WHERE id = ? ";
	
	public abstract T display(int id);
	
	public abstract StringBuffer displayAll();
	
	public abstract void create(T obj);
	
	public abstract void delete(T obj);
	
	public abstract void update(T obj, String id, String name, String introduced, String discontinued, String company_id);
	
	public List<Computer> computers(){
		List<Computer> c = new ArrayList<Computer>();
		ResultSet résultats = null;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(SQL_FIND_ALL);
			while(résultats.next()) {
				Computer computer= null;
				if(Integer.valueOf(résultats.getInt("company_id"))!=0) {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
				}
				else {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, null);
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, null, null);
					}
					else {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
				}
				c.add(computer);
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
		
	}
	
	public List<Company> companies(){
		List<Company> c = new ArrayList<Company>();
		ResultSet résultats = null;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(SQL_FIND_ALL);
			while(résultats.next()) {
				Company company = new Company(résultats.getInt("id"), résultats.getString("name"));
				c.add(company);
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
	}
	

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

package com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.excilys.training.model.Computer;

public class ComputerDao extends Dao<Computer>{
	
	
	private static ComputerDao instance;
	private final String SQL_FIND_ALL = "SELECT * FROM computer";
	private final String SQL_FIND_ALL_PAGINATION = "SELECT * FROM computer LIMIT ? OFFSET ?";
	private final String SQL_FIND_BY_ID = "SELECT * FROM computer WHERE id = ? ";
	private final String SQL_CREATE = "INSERT INTO computer (name, introduced,discontinued,company_id) VALUES (?,?,?,?)";
	private final String SQL_DELETE = "DELETE FROM computer WHERE id = ?";
	private final String SQL_UPDATE = "UPDATE computer SET name = ?, introduced = ?,discontinued = ?,company_id = ? WHERE id = ? ";
	
	public static ComputerDao getInstance() {
	    if (instance == null) {
	      instance = new ComputerDao();
	    }
	    return instance;
	  }
	public Computer find(int id) {
		// TODO Auto-generated method stub
		Computer c = new Computer();
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_BY_ID);
			stmt.setInt(1, id);
			résultats = stmt.executeQuery();
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				if(Integer.valueOf(résultats.getInt("company_id"))!=0) {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						c = new Computer(id, résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), null, null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
				}
				else {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						c = new Computer(id, résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, null);
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), null, null, null);
					}
					else {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
				}
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
	}

	public Computer create(Computer obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = connect.prepareStatement(SQL_CREATE);
			stmt.setString(1, obj.getName());
			if(obj.getIntroduced()==null) {
				stmt.setTimestamp(2, null);
			}
			else {
				stmt.setTimestamp(2, Timestamp.valueOf(obj.getIntroduced().minusHours(2)));
			}
			if(obj.getDiscontinued()==null) {
				stmt.setTimestamp(3, null);
			}
			else {
				stmt.setTimestamp(3, Timestamp.valueOf(obj.getDiscontinued().minusHours(2)));
			}
			if(obj.getCompany_id()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(4, obj.getCompany_id());
			}
			stmt.executeUpdate();
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return obj;
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	public Computer update(Computer obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_UPDATE);
			stmt.setInt(5, obj.getId());
			stmt.setString(1, obj.getName());
			if(obj.getIntroduced()==null) {
				stmt.setTimestamp(2, null);
			}
			else {
				stmt.setTimestamp(2, Timestamp.valueOf(obj.getIntroduced().minusHours(2)));
			}
			if(obj.getDiscontinued()==null) {
				stmt.setTimestamp(3, null);
			}
			else {
				stmt.setTimestamp(3, Timestamp.valueOf(obj.getDiscontinued().minusHours(2)));
			}
			if(obj.getCompany_id()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(4, obj.getCompany_id());
			}
			stmt.executeUpdate();
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return obj;
		
	}
	public List<Computer> displayAll(){
		List<Computer> c = new ArrayList<Computer>();
		ResultSet résultats = null;
		try {
			Statement stmt = this.connect.createStatement();
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
	public List<Computer> displayPagination(int limit, int offset) {
		List<Computer> c = new ArrayList<Computer>();
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_ALL_PAGINATION);
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			résultats = stmt.executeQuery();
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
		return c;// TODO Auto-generated method stub
	}


}

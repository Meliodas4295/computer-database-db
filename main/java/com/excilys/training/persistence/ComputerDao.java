package main.java.com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.java.com.excilys.training.model.Computer;

public class ComputerDao extends Dao<Computer>{
	
	private static ComputerDao instance;
	private final String SQL_FIND_ALL = "SELECT * FROM computer";
	private final String SQL_FIND_BY_ID = "SELECT * FROM computer WHERE id = ? ";
	private final String SQL_CREATE = "INSERT INTO computer (id, name, introduced,discontinued,company_id) VALUES (?,?,?,?,?)";
	private final String SQL_DELETE = "DELETE FROM computer WHERE id = ?";
	private final String SQL_UPDATE = "UPDATE computer SET name = ?, introduced = ?,discontinued = ?,company_id = ? WHERE id = ? ";
	public ComputerDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Computer display(int id) {
		// TODO Auto-generated method stub
		Computer c = null;
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.getConn().prepareStatement(SQL_FIND_BY_ID);
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
				//for(int i = 1;i<=nbCols;i++) {
				//	System.out.print(résultats.getString(i) + " ");
				//}
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
	}

	@Override
	public StringBuffer displayAll() {
		// TODO Auto-generated method stub
		StringBuffer da = new StringBuffer("");
		ResultSet résultats = null;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(SQL_FIND_ALL);
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				for(int i = 1;i<=nbCols;i++) {
					da.append(résultats.getString(i) + " ");
				}
			da.append("\n");
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return da;
		
		
	}

	@Override
	public void create(Computer obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.getConn().prepareStatement(SQL_CREATE);
			stmt.setInt(1, obj.getId());
			stmt.setString(2, obj.getName());
			if(obj.getIntroduced()==null) {
				stmt.setTimestamp(3, null);
			}
			else {
				stmt.setTimestamp(3, Timestamp.valueOf(obj.getIntroduced().minusHours(2)));
			}
			if(obj.getDiscontinued()==null) {
				stmt.setTimestamp(4, null);
			}
			else {
				stmt.setTimestamp(4, Timestamp.valueOf(obj.getDiscontinued().minusHours(2)));
			}
			if(obj.getCompany_id()==null) {
				stmt.setNull(5, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(5, obj.getCompany_id());
			}
			int nbMaj = stmt.executeUpdate();
			//System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	@Override
	public void delete(Computer obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.getConn().prepareStatement(SQL_DELETE);
			stmt.setInt(1, obj.getId());
			int nbMaj = stmt.executeUpdate();
			//System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	@Override
	public void update(Computer obj, String id, String name, String introduced, String discontinued, String company_id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.getConn().prepareStatement(SQL_UPDATE);
			stmt.setString(5, id);
			stmt.setString(1, name);
			stmt.setString(2, introduced);
			stmt.setString(3, discontinued);
			stmt.setString(4, company_id);
			int nbMaj = stmt.executeUpdate();
			//System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

}

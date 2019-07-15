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
	
	public List<Computer> computers(){
		List<Computer> c = new ArrayList<Computer>();
		ResultSet résultats = null;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(SQL_FIND_ALL);
			while(résultats.next()) {
				Computer computer= null;
				if(résultats.getTimestamp(3)==null && résultats.getTimestamp(4)!=null) {
					computer =  new Computer(résultats.getInt(1), résultats.getString(2), null, Timestamp.valueOf(résultats.getString(4)).toLocalDateTime(), résultats.getInt(5));
				}
				else if(résultats.getTimestamp(3)!=null && résultats.getTimestamp(4)==null) {
					computer =  new Computer(résultats.getInt(1), résultats.getString(2), Timestamp.valueOf(résultats.getString(3)).toLocalDateTime(), null, résultats.getInt(5));
				}
				else if(résultats.getTimestamp(3)==null && résultats.getTimestamp(4)==null) {
					computer =  new Computer(résultats.getInt(1), résultats.getString(2), null, null, résultats.getInt(5));
				}
				else {
					computer =  new Computer(résultats.getInt(1), résultats.getString(2), Timestamp.valueOf(résultats.getString(3)).toLocalDateTime(), Timestamp.valueOf(résultats.getString(4)).toLocalDateTime(), résultats.getInt(5));
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
				c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), résultats.getInt("company_id"));
				for(int i = 1;i<=nbCols;i++) {
					System.out.print(résultats.getString(i) + " ");
				}
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		ResultSet résultats = null;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(SQL_FIND_ALL);
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				for(int i = 1;i<=nbCols;i++) {
					System.out.print(résultats.getString(i) + " ");
				}
			System.out.println("");
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
		
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
			System.out.println("nb mise a jour = "+nbMaj);
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
			System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	@Override
	public void update(Computer obj, String column, String newValue) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.getConn().prepareStatement(SQL_UPDATE);
			stmt.setString(1, obj.getName());
			if(obj.getIntroduced()==null) {
				stmt.setTimestamp(2, null);
			}
			else {
				stmt.setTimestamp(2, Timestamp.valueOf(obj.getIntroduced()));
			}
			if(obj.getDiscontinued()==null) {
				stmt.setTimestamp(3, Timestamp.valueOf(obj.getDiscontinued()));
			}
			else {
				stmt.setInt(4, obj.getCompany_id());
			}
			if(obj.getCompany_id()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(5, obj.getId());
			}
			int nbMaj = stmt.executeUpdate();
			System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

}

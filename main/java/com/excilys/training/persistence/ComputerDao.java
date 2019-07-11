package main.java.com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.com.excilys.training.model.Computer;

public class ComputerDao extends Dao<Computer>{

	public ComputerDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Computer display(int id) {
		// TODO Auto-generated method stub
		Computer c = null;
		ResultSet résultats = null;
		String requete = "SELECT * FROM computer WHERE id = "+id;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(requete);
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				c = new Computer(id, résultats.getString("name"), résultats.getDate("introduced"), résultats.getDate("discontinued"), résultats.getInt("company_id"));
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
		String requete = "SELECT * FROM computer";
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(requete);
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
		String requete = "INSERT INTO computer VALUES ("+obj.getId()+",'"+obj.getName()+"',"+obj.getIntroduced()+","+obj.getDiscontinued()+","+obj.getCompany_id()+")";
		try {
			Statement stmt = this.getConn().createStatement();
			int nbMaj = stmt.executeUpdate(requete);
			System.out.print("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	@Override
	public void delete(Computer obj) {
		// TODO Auto-generated method stub
		String requete = "DELETE FROM computer WHERE id = "+obj.getId();
		try {
			Statement stmt = this.getConn().createStatement();
			int nbMaj = stmt.executeUpdate(requete);
			System.out.print("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	@Override
	public void update(Computer obj, String column, String newValue) {
		// TODO Auto-generated method stub
		String requete = "UPDATE computer SET "+column+"="+newValue+" WHERE id = "+obj.getId();
		try {
			Statement stmt = this.getConn().createStatement();
			int nbMaj = stmt.executeUpdate(requete);
			System.out.print("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

}

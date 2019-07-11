package main.java.com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.com.excilys.training.model.Company;

public class CompanyDao extends Dao<Company>{

	public CompanyDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Company display(int id) {
		// TODO Auto-generated method stub
		Company c = null;
		ResultSet résultats = null;
		String requete = "SELECT * FROM company WHERE id = "+id;
		try {
			Statement stmt = this.getConn().createStatement();
			résultats = stmt.executeQuery(requete);
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				c = new Company(id, résultats.getString("name"));
				for(int i = 1;i<=nbCols;i++) {
					System.out.print(résultats.getString(i) + "\n");
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
		String requete = "SELECT * FROM company";
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
	public void create(Company obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Company obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Company obj, String column, String newValue) {
		// TODO Auto-generated method stub
		
	}

}

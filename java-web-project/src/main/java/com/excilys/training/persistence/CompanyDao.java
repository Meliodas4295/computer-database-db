package com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.training.model.Company;

public class CompanyDao extends Dao<Company>{
	
	private static CompanyDao instance;
	private final String SQL_FIND_ALL = "SELECT * FROM company";
	private final String SQL_FIND_ALL_PAGINATION = "SELECT * FROM company LIMIT ? OFFSET ?";
	private final String SQL_FIND_BY_ID = "SELECT * FROM company WHERE id = ? ";

	public static CompanyDao getInstance() {
	    if (instance == null) {
	      instance = new CompanyDao();
	    }
	    return instance;
	  }

	public Company find(int id) {
		// TODO Auto-generated method stub
		Company c= new Company();
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_BY_ID);
			stmt.setInt(1, id);
			résultats = stmt.executeQuery();
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				c = new Company(id, résultats.getString("name"));
				//for(int i = 1;i<=nbCols;i++) {
				//	System.out.print(résultats.getString(i) + "\n");
				//}
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
	}

	

	public Company create(Company obj) {
		return obj;
		// TODO Auto-generated method stub
		
	}

	public void delete(Company obj) {
		// TODO Auto-generated method stub
		
	}

	public Company update(Company obj) {
		return obj;
		// TODO Auto-generated method stub
		
	}
	public List<Company> displayAll(){
		List<Company> c = new ArrayList<Company>();
		ResultSet résultats = null;
		try {
			Statement stmt = this.connect.createStatement();
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
	
	public List<Company> displayPagination(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

}

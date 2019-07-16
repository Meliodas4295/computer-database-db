package main.java.com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.com.excilys.training.model.Company;

public class CompanyDao extends Dao<Company>{
	
	private final String SQL_FIND_ALL = "SELECT * FROM company";
	private final String SQL_FIND_BY_ID = "SELECT * FROM company WHERE id = ? ";

	public CompanyDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Company display(int id) {
		// TODO Auto-generated method stub
		Company c=null;
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.getConn().prepareStatement(SQL_FIND_BY_ID);
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

	@Override
	public StringBuffer displayAll() {
		StringBuffer da = new StringBuffer("");
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
	public void create(Company obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Company obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Company obj, String id, String name, String introduced, String discontinued, String company_id) {
		// TODO Auto-generated method stub
		
	}

}

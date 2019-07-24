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
	public CompanyDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instance de la classe CompanyDao.
	 */
	private static CompanyDao instance;
	/**
	 * Requête SQL permettant de sélectionner tout les éléments de la table company.
	 */
	private final String SQL_FIND_ALL = "SELECT * FROM company";
	/**
	 * Requête SQL permettant de sélectionner des éléments compris entre deux valeurs de la table company.
	 */
	private final String SQL_FIND_ALL_PAGINATION = "SELECT * FROM company LIMIT ? OFFSET ?";
	/**
	 * Requête SQL permettant de sélectionner un élément la table company.
	 */
	private final String SQL_FIND_BY_ID = "SELECT * FROM company WHERE id = ? ";
	/**
	 * 
	 * @return l'instance de la classe CompanyDao.
	 * Si l'instance est null, créer une nouvelle instance.
	 * @throws SQLException 
	 */
	public static CompanyDao getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new CompanyDao();
	    }
	    return instance;
	  }
	
	/**
	 * Permet de trouver une Company dans la base de données.
	 * @param id
	 * @return la Company trouver.
	 */
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

	
	/**
	 * Permet de créer une nouvelle company dans la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company créer.
	 */
	public Company create(Company obj) {
		return obj;
		// TODO Auto-generated method stub
		
	}
	/**
	 * Permet d'effacer une Company de la base de données.
	 * (PS: Classe non implémenter)
	 * @param id
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Permet de modifier une Company de la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company modifier.
	 */
	public Company update(Company obj) {
		return obj;
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Permet de visualiser les Company de la base de données.
	 * @return liste des Company de la base de données.
	 */
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
	
	/**
	 * Permet de visualiser les Company paginer de la base de données.
	 * (PS: Classe non implémenter)
	 * @param limit (int) nombre de valeur dans la page paginée. 
	 * @param offset (int) valeur de départ de la pagination.
	 * @return la liste des Company paginée.
	 */
	public List<Company> displayPagination(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

}

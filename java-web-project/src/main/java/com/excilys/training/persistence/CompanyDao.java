package com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.training.jdbc.ConnectionMySQL;
import com.excilys.training.model.Company;
import com.excilys.training.model.Company.CompanyBuilder;

<<<<<<< HEAD
<<<<<<< HEAD
public class CompanyDao{
	private Connection connect;
	private ComputerDao computerDao;
	
	private CompanyDao() throws SQLException {
		super();
		this.connect = ConnectionMySQL.getInstance();
		this.computerDao = ComputerDao.getInstance();
=======
=======
>>>>>>> develop
public class CompanyDao extends Dao<Company>{
	public CompanyDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	}

	/**
	 * Instance de la classe CompanyDao.
	 */
	private static CompanyDao instance;
<<<<<<< HEAD
<<<<<<< HEAD
	
	private static final String SQL_DELETE = "DELETE FROM company WHERE id = ?";
	/**
	 * Requête SQL permettant de sélectionner tout les éléments de la table company.
	 */
	private static final String SQL_FIND_ALL = "SELECT id, name FROM company";
	/**
	 * Requête SQL permettant de sélectionner des éléments compris entre deux valeurs de la table company.
	 */
	private static final String SQL_FIND_ALL_PAGINATION = "SELECT id, name FROM company LIMIT ? OFFSET ?";
	/**
	 * Requête SQL permettant de sélectionner un élément la table company.
	 */
	private static final String SQL_FIND_BY_ID = "SELECT id, name FROM company WHERE id = ? ";
=======
=======
>>>>>>> develop
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
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
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
		CompanyBuilder company= new Company.CompanyBuilder(id);
		ResultSet resultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_BY_ID);
			stmt.setInt(1, id);
			resultats = stmt.executeQuery();
			while(resultats.next()) {
				company.name(resultats.getString("name"));
			}
			resultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return company.build();
	}

	
	/**
	 * Permet de créer une nouvelle company dans la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company créer.
	 */
	public Company create(Company obj) {
		return obj;
		
	}
	/**
	 * Permet d'effacer une Company de la base de données.
<<<<<<< HEAD
<<<<<<< HEAD
	 * @param id
	 */
	public void delete(Company company) {
		try {
			this.computerDao.deleteByCompany(company);
			PreparedStatement stmt = this.connect.prepareStatement(SQL_DELETE);
			stmt.setInt(1, company.getId());
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
=======
=======
>>>>>>> develop
	 * (PS: Classe non implémenter)
	 * @param id
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		
>>>>>>> develop
	}
	/**
	 * Permet de modifier une Company de la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company modifier.
	 */
	public Company update(Company obj) {
		return obj;
		
	}
	
	/**
	 * Permet de visualiser les Company de la base de données.
	 * @return liste des Company de la base de données.
	 */
	public List<Company> displayAll(){
		List<Company> companyList = new ArrayList<Company>();
		ResultSet resultats = null;
		try {
			Statement stmt = this.connect.createStatement();
			resultats = stmt.executeQuery(SQL_FIND_ALL);
			while(resultats.next()) {
				CompanyBuilder company = new Company.CompanyBuilder(resultats.getInt("id")).name(resultats.getString("name"));
				companyList.add(company.build());
			}
			resultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return companyList;
	}
	
	/**
	 * Permet de visualiser les Company paginer de la base de données.
	 * (PS: Classe non implémenter)
	 * @param limit (int) nombre de valeur dans la page paginée. 
	 * @param offset (int) valeur de départ de la pagination.
	 * @return la liste des Company paginée.
	 */
	public List<Company> displayPagination(int limit, int offset) {
		return null;
	}
	

}

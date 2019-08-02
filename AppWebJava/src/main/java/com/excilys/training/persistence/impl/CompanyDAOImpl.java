package com.excilys.training.persistence.impl;

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
import com.excilys.training.persistence.AbstractDao;
import com.excilys.training.persistence.contract.CompanyDAO;
import com.excilys.training.persistence.contract.ComputerDAO;
import com.excilys.training.persistence.impl.CompanyDAOImpl;
import com.excilys.training.persistence.impl.ComputerDAOImpl;

public class CompanyDAOImpl extends AbstractDao implements CompanyDAO{
	private ComputerDAO computerDao;

	/**
	 * Instance de la classe CompanyDao.
	 */
	private static CompanyDAOImpl instance;
	
	private CompanyDAOImpl() throws SQLException {
		super();
		this.computerDao = ComputerDAOImpl.getInstance();
	}
	
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
	/**
	 * 
	 * @return l'instance de la classe CompanyDao.
	 * Si l'instance est null, créer une nouvelle instance.
	 * @throws SQLException 
	 */
	public static CompanyDAOImpl getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new CompanyDAOImpl();
	    }
	    return instance;
	  }
	
	/**
	 * Permet de trouver une Company dans la base de données.
	 * @param id
	 * @return la Company trouver.
	 * @throws SQLException 
	 */
	@Override
	public Company find(int id) throws SQLException {
		CompanyBuilder company= new Company.CompanyBuilder(id);
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_FIND_BY_ID);
		try {
			stmt.setInt(1, id);
			ResultSet resultats = stmt.executeQuery();
			while(resultats.next()) {
				company.name(resultats.getString("name"));
			}
			resultats.close();
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		finally {
			stmt.close();
			connection.close();
		}
		return company.build();
	}

	
	/**
	 * Permet de créer une nouvelle company dans la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company créer.
	 */
	@Override
	public Company create(Company obj) {
		return obj;
		
	}
	/**
	 * Permet d'effacer une Company de la base de données.
	 * @param id
	 * @throws SQLException 
	 */
	@Override
	public void delete(Company company) throws SQLException {
		this.computerDao.deleteByCompany(company);
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_DELETE);
		try {
			stmt.setInt(1, company.getId());
			stmt.executeUpdate();
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		finally {
			stmt.close();
			connection.close();
			
		}
	}
	/**
	 * Permet de modifier une Company de la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company modifier.
	 */
	@Override
	public Company update(Company obj) {
		return obj;
		
	}
	
	/**
	 * Permet de visualiser les Company de la base de données.
	 * @return liste des Company de la base de données.
	 * @throws SQLException 
	 */
	@Override
	public List<Company> displayAll() throws SQLException{
		List<Company> companyList = new ArrayList<Company>();
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		Statement stmt = connection.createStatement();
		try {
			ResultSet resultats = stmt.executeQuery(SQL_FIND_ALL);
			while(resultats.next()) {
				CompanyBuilder company = new Company.CompanyBuilder(resultats.getInt("id")).name(resultats.getString("name"));
				companyList.add(company.build());
			}
			resultats.close();
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		finally {
			stmt.close();
			connection.close();
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
	@Override
	public List<Company> displayPagination(int limit, int offset) {
		return null;
	}
	

}

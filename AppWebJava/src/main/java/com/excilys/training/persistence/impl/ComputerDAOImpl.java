package com.excilys.training.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.model.Computer.ComputerBuilder;
import com.excilys.training.persistence.AbstractDao;
import com.excilys.training.persistence.contract.ComputerDAO;
import com.excilys.training.persistence.impl.ComputerDAOImpl;

public class ComputerDAOImpl extends AbstractDao implements ComputerDAO{
	

	private ComputerDAOImpl() throws SQLException {
		super();
	}

	private final static Logger logger = LoggerFactory.getLogger(ComputerDAOImpl.class);
	/**
	 * Instance de la classe ComputerDao.
	 */
	private static ComputerDAO instance;
	/**
	 * Requête permettant de supprimer les Computer en fonction de la Company. 
	 */
	private static final String SQL_DELETE_COMPUTER_WHERE_COMPANY_ID = "DELETE FROM  computer  WHERE  company_id  = ?";
	/**
	 * Requête SQL permettant de sélectionner tout les éléments de la table computer.
	 */
	private static final String SQL_FIND_ALL = "SELECT computer.id, computer.name, introduced, discontinued, company_id, company.name FROM computer LEFT JOIN company ON computer.company_id = company.id";
	/**
	 * Requête SQL permettant de sélectionner des éléments compris entre deux valeurs de la table computer.
	 */
	private static final String SQL_FIND_ALL_PAGINATION = "SELECT computer.id, computer.name, introduced, discontinued, company_id, company.name FROM computer LEFT JOIN company ON computer.company_id = company.id LIMIT ? OFFSET ?";
	/**
	 * Requête SQL permettant de sélectionner un élément la table computer.
	 */
	private static final String SQL_FIND_BY_ID = "SELECT id, name, introduced, discontinued, company_id FROM computer WHERE id = ? ";
	
	
	/**
	 * Requête SQL permettant de créer un élément la table computer.
	 */
	private static final String SQL_CREATE = "INSERT INTO computer (name, introduced,discontinued,company_id) VALUES (?,?,?,?)";
	/**
	 * Requête SQL permettant de supprimer un élément la table computer.
	 */
	private static final String SQL_DELETE = "DELETE FROM computer WHERE id = ?";
	/**
	 * Requête SQL permettant de modifier un élément la table computer.
	 */
	private static final String SQL_UPDATE = "UPDATE computer SET name = ?, introduced = ?,discontinued = ?,company_id = ? WHERE id = ? ";
	
	
	/**
	 * Requête permettant de récupérer les élements selon leurs noms de manière ascendante.
	 */
	private static final String SQL_PAGE_NAME_ASC = "SELECT  computer.id , computer.name , introduced , discontinued , company_id , company.name  FROM `computer` LEFT JOIN company ON computer.company_id = company.id WHERE computer.name LIKE ? OR company.name LIKE ? ORDER BY ISNULL(computer.name), computer.name ASC limit ? offset ?";
	/**
	 * Requête permettant de récupérer les élements selon leurs noms de manière descendante.
	 */
	private static final String SQL_PAGE_NAME_DESC = "SELECT  computer.id , computer.name , introduced , discontinued , company_id , company.name   FROM `computer` LEFT JOIN company ON computer.company_id = company.id WHERE computer.name LIKE ? OR company.name LIKE ? ORDER BY ISNULL(computer.name), computer.name DESC limit ? offset ?";
	/**
	 * Requête permettant de récupérer les élements selon leurs dates d'introductions.
	 */
	private static final String SQL_PAGE_INTRODUCED = "SELECT  computer.id , computer.name , introduced , discontinued , company_id , company.name   FROM `computer` LEFT JOIN company ON computer.company_id = company.id WHERE computer.name LIKE ? OR company.name LIKE ? ORDER BY ISNULL(computer.introduced), computer.introduced ASC limit ? offset ?";
	/**
	 * Requête permettant de récupérer les élements selon leurs dates d'arrêt.
	 */
	private static final String SQL_PAGE_DISCONTINUED = "SELECT  computer.id , computer.name , introduced , discontinued , company_id , company.name   FROM `computer` LEFT JOIN company ON computer.company_id = company.id WHERE computer.name LIKE ? OR company.name LIKE ? ORDER BY ISNULL(computer.discontinued), computer.discontinued ASC limit ? offset ?";
	/**
	 * Requête permettant de récupérer les élements selon leurs leurs Company.
	 */
	private static final String SQL_PAGE_COMPANY = "SELECT  computer.id , computer.name , introduced , discontinued , company_id , company.name   FROM `computer` LEFT JOIN company ON computer.company_id = company.id WHERE computer.name LIKE ? OR company.name LIKE ? ORDER BY ISNULL(company.name), company.name ASC limit ? offset ?";
	/**
	 * 
	 * @return l'instance de la classe ComputerDao.
	 * Si l'instance est null, créer une nouvelle instance.
	 * @throws SQLException 
	 */
	public static ComputerDAO getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new ComputerDAOImpl();
	    }
	    return instance;
	  }
	
	@Override
	public void deleteByCompany(Company company) throws SQLException {
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_COMPUTER_WHERE_COMPANY_ID);
		try {
			stmt.setInt(1, company.getId());
			stmt.executeUpdate();
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
	}
	
	/**
	 * Permet de trouver un Computer dans la base de données.
	 * @param id
	 * @return le Computer trouver.
	 * @throws SQLException 
	 */
	@Override
	public Computer find(int id) throws SQLException {
		ComputerBuilder computer= new Computer.ComputerBuilder();
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_FIND_BY_ID);
		try {
			stmt.setInt(1, id);
			ResultSet resultats = stmt.executeQuery();
			while(resultats.next()) {
				String name = resultats.getString("name");
				LocalDateTime introduced = resultats.getTimestamp("introduced")!=null?resultats.getTimestamp("introduced").toLocalDateTime():null;
				LocalDateTime discontinued = resultats.getTimestamp("discontinued")!=null?resultats.getTimestamp("discontinued").toLocalDateTime():null;
				Company companyId = resultats.getInt("company_id")!=0?new Company.CompanyBuilder(resultats.getInt("company_id")).name(resultats.getString("company.name")).build():null;
				computer.id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
		
			}
			resultats.close();
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		return computer.build()!=null?computer.build():new Computer.ComputerBuilder().id(0).name("").introduced(null).discontinued(null).companyId(null).build();
	}

	/**
	 * Permet de créer un nouveau Computer dans la base de données.
	 * @param obj (Computer)
	 * @return le Computer créer.
	 * @throws SQLException 
	 */
	@Override
	public Computer create(Computer obj) throws SQLException {
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_CREATE);
		try {
			stmt.setString(1, obj.getName());
			stmt.setTimestamp(2, obj.getIntroduced()!=null?Timestamp.valueOf(obj.getIntroduced().minusHours(2)):null);
			stmt.setTimestamp(3, obj.getDiscontinued()!=null?Timestamp.valueOf(obj.getDiscontinued().minusHours(2)):null);
			if(obj.getCompanyId()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(4, obj.getCompanyId().getId());
			}
			stmt.executeUpdate();
			connection.commit();
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				connection.rollback();
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		return obj;
		
	}

	/**
	 * Permet d'effacer une Computer de la base de données.
	 * @param id
	 * @throws SQLException 
	 */
	@Override
	public void delete(int id) throws SQLException {
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_DELETE);
		try {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		
	}

	/**
	 * Permet de modifier une Computer de la base de données.
	 * @param obj (Computer)
	 * @return la Computer modifier.
	 * @throws SQLException 
	 */
	@Override
	public Computer update(Computer obj) throws SQLException {
		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE);
		try {
			stmt.setInt(5, obj.getId());
			stmt.setString(1, obj.getName());
			stmt.setTimestamp(2, obj.getIntroduced()!=null?Timestamp.valueOf(obj.getIntroduced().minusHours(2)):null);
			stmt.setTimestamp(3, obj.getDiscontinued()!=null?Timestamp.valueOf(obj.getDiscontinued().minusHours(2)):null);
			if(obj.getCompanyId()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(4, obj.getCompanyId().getId());
			}
			stmt.executeUpdate();
			connection.commit();
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				connection.rollback();
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		return obj;
		
	}
	
	/**
	 * Permet de visualiser les Computer de la base de données.
	 * @return liste des Computer de la base de données.
	 * @throws SQLException 
	 */
	@Override
	public List<Computer> displayAll() throws SQLException{
		List<Computer> computerList = new ArrayList<Computer>();
		Connection connection = getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		try {
			ResultSet resultats = stmt.executeQuery(SQL_FIND_ALL);
			while(resultats.next()) {
				int id = resultats.getInt("id");
				String name = resultats.getString("name");
				LocalDateTime introduced = resultats.getTimestamp("introduced")!=null?resultats.getTimestamp("introduced").toLocalDateTime():null;
				LocalDateTime discontinued = resultats.getTimestamp("discontinued")!=null?resultats.getTimestamp("discontinued").toLocalDateTime():null;
				Company companyId = resultats.getInt("company_id")!=0?new Company.CompanyBuilder(resultats.getInt("company_id")).name(resultats.getString("company.name")).build():null;
				ComputerBuilder computer= new Computer.ComputerBuilder().id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
				computerList.add(computer.build());
			}
			resultats.close();
			} catch (SQLException e) {
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		return computerList;
		
	}
	
	/**
	 * Permet de visualiser les Computer paginer de la base de données.
	 * @param limit (int) nombre de valeur dans la page paginée. 
	 * @param offset (int) valeur de départ de la pagination.
	 * @return la liste des Computer paginée.
	 * @throws SQLException 
	 */
	@Override
	public List<Computer> displayPagination(int limit, int offset) throws SQLException {
		List<Computer> computerList = new ArrayList<Computer>();
		Connection connection = getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement(SQL_FIND_ALL_PAGINATION);
		try {
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			ResultSet resultats = stmt.executeQuery();
			while(resultats.next()) {
				int id = resultats.getInt("id");
				String name = resultats.getString("name");
				LocalDateTime introduced = resultats.getTimestamp("introduced")!=null?resultats.getTimestamp("introduced").toLocalDateTime():null;
				LocalDateTime discontinued = resultats.getTimestamp("discontinued")!=null?resultats.getTimestamp("discontinued").toLocalDateTime():null;
				Company companyId = resultats.getInt("company_id")!=0?new Company.CompanyBuilder(resultats.getInt("company_id")).name(resultats.getString("company.name")).build():null;
				ComputerBuilder computer= new Computer.ComputerBuilder().id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
				computerList.add(computer.build());
			}
			resultats.close();
			} catch (SQLException e) {
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		return computerList;
	}
	
	public List<Computer> SearchByNameAsc(String searchByName, String searchByCompany, int limit, int offset) throws SQLException {
		List<Computer> computerList = new ArrayList<Computer>();
		Connection connection = getDataSource().getConnection();
		PreparedStatement stmt = connection.prepareStatement(SQL_PAGE_NAME_ASC);
		try {
			stmt.setString(1, '%'+searchByName+'%');
			stmt.setString(2, '%'+searchByCompany+'%');
			stmt.setInt(3, limit);
			stmt.setInt(4, offset);
			ResultSet resultats = stmt.executeQuery();
			while(resultats.next()) {
				int id = resultats.getInt("id");
				String name = resultats.getString("name");
				LocalDateTime introduced = resultats.getTimestamp("introduced")!=null?resultats.getTimestamp("introduced").toLocalDateTime():null;
				LocalDateTime discontinued = resultats.getTimestamp("discontinued")!=null?resultats.getTimestamp("discontinued").toLocalDateTime():null;
				Company companyId = resultats.getInt("company_id")!=0?new Company.CompanyBuilder(resultats.getInt("company_id")).name(resultats.getString("company.name")).build():null;
				ComputerBuilder computer= new Computer.ComputerBuilder().id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
				computerList.add(computer.build());
			}
			resultats.close();
			} catch (SQLException e) {
				logger.error("Votre requête SQL est incorrect");
			}
		finally {
			stmt.close();
			connection.close();
		}
		return computerList;
	}
	
	


}

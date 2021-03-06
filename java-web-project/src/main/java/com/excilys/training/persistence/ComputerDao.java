package com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.excilys.training.jdbc.ConnectionMySQL;
import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.model.Computer.ComputerBuilder;

public class ComputerDao{
	

	private Connection connect;
	
	private ComputerDao() throws SQLException {
		super();
		this.connect = ConnectionMySQL.getInstance();
	public ComputerDao() throws SQLException {
		super();

	public ComputerDao() throws SQLException {
		super();

	public ComputerDao() throws SQLException {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * Instance de la classe ComputerDao.
	 */
	private static ComputerDao instance;
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

	 * Requête SQL permettant de sélectionner tout les éléments de la table computer.
	 */
	private final String SQL_FIND_ALL = "SELECT * FROM computer LEFT JOIN company ON computer.company_id=company.id";
	/**
	 * Requête SQL permettant de sélectionner des éléments compris entre deux valeurs de la table computer.
	 */

	
	private static ComputerDao instance;
	private final String SQL_FIND_ALL = "SELECT * FROM computer";

	private static ComputerDao instance;
	/**
	 * Requête SQL permettant de sélectionner tout les éléments de la table computer.
	 */
	private final String SQL_FIND_ALL = "SELECT * FROM computer LEFT JOIN company ON computer.company_id=company.id";
	/**
	 * Requête SQL permettant de sélectionner des éléments compris entre deux valeurs de la table computer.
	 */
	private final String SQL_FIND_ALL_PAGINATION = "SELECT * FROM computer LIMIT ? OFFSET ?";
	/**
	 * Requête SQL permettant de sélectionner un élément la table computer.
	 */
	private final String SQL_FIND_BY_ID = "SELECT * FROM computer WHERE id = ? ";
	/**
	 * Requête SQL permettant de créer un élément la table computer.
	 */
	private final String SQL_CREATE = "INSERT INTO computer (name, introduced,discontinued,company_id) VALUES (?,?,?,?)";
	/**
	 * Requête SQL permettant de supprimer un élément la table computer.
	 */
	private final String SQL_DELETE = "DELETE FROM computer WHERE id = ?";
	/**
	 * Requête SQL permettant de modifier un élément la table computer.
	 */
	private final String SQL_UPDATE = "UPDATE computer SET name = ?, introduced = ?,discontinued = ?,company_id = ? WHERE id = ? ";
	

	/**
	/**
	 * 
	 * @return l'instance de la classe ComputerDao.
	 * Si l'instance est null, créer une nouvelle instance.
	 * @throws SQLException 
	 */
	public static ComputerDao getInstance() throws SQLException {

	public static ComputerDao getInstance() {

	    if (instance == null) {
	      instance = new ComputerDao();
	    }
	    return instance;
	  }

	public void deleteByCompany(Company company) {
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_DELETE_COMPUTER_WHERE_COMPANY_ID);
			stmt.setInt(1, company.getId());
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	/**
	 * Permet de trouver un Computer dans la base de données.
	 * @param id
	 * @return le Computer trouver.
	 */


	public Computer find(int id) {
		ComputerBuilder computer= new Computer.ComputerBuilder();
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_BY_ID);
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return computer.build();
	}


	/**
	 * Permet de créer un nouveau Computer dans la base de données.
	 * @param obj (Computer)

	 * @return le Computer créer.

	 * @return la Computer créer.

	 * @return la Computer créer.

	 */

	/**
	 * Permet de créer un nouveau Computer dans la base de données.
	 * @param obj (Computer)
	 * @return la Computer créer.
	 */

	public Computer create(Computer obj) {
		try {
			PreparedStatement stmt = connect.prepareStatement(SQL_CREATE);
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
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return obj;
		
	}

	/**
	 * Permet d'effacer une Computer de la base de données.
	 * @param id
	 */
	public void delete(int id) {
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * Permet de modifier une Computer de la base de données.
	 * @param obj (Computer)
	 * @return la Computer modifier.
	 */
	public Computer update(Computer obj) {
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_UPDATE);
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
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return obj;
		
	}
	
	/**
	 * Permet de visualiser les Computer de la base de données.
	 * @return liste des Computer de la base de données.
	 */
	public List<Computer> displayAll(){
		List<Computer> computerList = new ArrayList<Computer>();
		try {
			Statement stmt = this.connect.createStatement();
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
				e.printStackTrace();
			}
		return computerList;
		
	}
	
	/**
	 * Permet de visualiser les Computer paginer de la base de données.
	 * @param limit (int) nombre de valeur dans la page paginée. 
	 * @param offset (int) valeur de départ de la pagination.
	 * @return la liste des Computer paginée.
	 */
	public List<Computer> displayPagination(int limit, int offset) {
		List<Computer> computerList = new ArrayList<Computer>();
		ResultSet resultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_ALL_PAGINATION);
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			resultats = stmt.executeQuery();
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
				e.printStackTrace();
			}
		return computerList;
	}


}

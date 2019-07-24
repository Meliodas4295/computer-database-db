package com.excilys.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.excilys.training.model.Computer;

public class ComputerDao extends Dao<Computer>{
	
	public ComputerDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instance de la classe ComputerDao.
	 */
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
	 * 
	 * @return l'instance de la classe ComputerDao.
	 * Si l'instance est null, créer une nouvelle instance.
	 * @throws SQLException 
	 */
	public static ComputerDao getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new ComputerDao();
	    }
	    return instance;
	  }
	
	/**
	 * Permet de trouver un Computer dans la base de données.
	 * @param id
	 * @return le Computer trouver.
	 */
	public Computer find(int id) {
		// TODO Auto-generated method stub
		Computer c = new Computer();
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_BY_ID);
			stmt.setInt(1, id);
			résultats = stmt.executeQuery();
			ResultSetMetaData rsmd;
			rsmd = résultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while(résultats.next()) {
				if(Integer.valueOf(résultats.getInt("company_id"))!=0) {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						c = new Computer(id, résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), null, null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
				}
				else {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						c = new Computer(id, résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, null);
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						c = new Computer(id, résultats.getString("name"), null, null, null);
					}
					else {
						c = new Computer(id, résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
				}
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;
	}

	/**
	 * Permet de créer un nouveau Computer dans la base de données.
	 * @param obj (Computer)
	 * @return la Computer créer.
	 */
	public Computer create(Computer obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = connect.prepareStatement(SQL_CREATE);
			stmt.setString(1, obj.getName());
			if(obj.getIntroduced()==null) {
				stmt.setTimestamp(2, null);
			}
			else {
				stmt.setTimestamp(2, Timestamp.valueOf(obj.getIntroduced().minusHours(2)));
			}
			if(obj.getDiscontinued()==null) {
				stmt.setTimestamp(3, null);
			}
			else {
				stmt.setTimestamp(3, Timestamp.valueOf(obj.getDiscontinued().minusHours(2)));
			}
			if(obj.getCompany_id()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(4, obj.getCompany_id());
			}
			stmt.executeUpdate();
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return obj;
		
	}

	/**
	 * Permet d'effacer une Computer de la base de données.
	 * @param id
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		
	}

	/**
	 * Permet de modifier une Computer de la base de données.
	 * @param obj (Computer)
	 * @return la Computer modifier.
	 */
	public Computer update(Computer obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_UPDATE);
			stmt.setInt(5, obj.getId());
			stmt.setString(1, obj.getName());
			if(obj.getIntroduced()==null) {
				stmt.setTimestamp(2, null);
			}
			else {
				stmt.setTimestamp(2, Timestamp.valueOf(obj.getIntroduced().minusHours(2)));
			}
			if(obj.getDiscontinued()==null) {
				stmt.setTimestamp(3, null);
			}
			else {
				stmt.setTimestamp(3, Timestamp.valueOf(obj.getDiscontinued().minusHours(2)));
			}
			if(obj.getCompany_id()==null) {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}
			else {
				stmt.setInt(4, obj.getCompany_id());
			}
			stmt.executeUpdate();
			obj = this.find(obj.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return obj;
		
	}
	
	/**
	 * Permet de visualiser les Computer de la base de données.
	 * @return liste des Computer de la base de données.
	 */
	public List<Computer> displayAll(){
		List<Computer> c = new ArrayList<Computer>();
		ResultSet résultats = null;
		try {
			Statement stmt = this.connect.createStatement();
			résultats = stmt.executeQuery(SQL_FIND_ALL);
			while(résultats.next()) {
				Computer computer= null;
				if(Integer.valueOf(résultats.getInt("company_id"))!=0) {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
				}
				else {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, null);
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, null, null);
					}
					else {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
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
	
	/**
	 * Permet de visualiser les Computer paginer de la base de données.
	 * @param limit (int) nombre de valeur dans la page paginée. 
	 * @param offset (int) valeur de départ de la pagination.
	 * @return la liste des Computer paginée.
	 */
	public List<Computer> displayPagination(int limit, int offset) {
		List<Computer> c = new ArrayList<Computer>();
		ResultSet résultats = null;
		try {
			PreparedStatement stmt = this.connect.prepareStatement(SQL_FIND_ALL_PAGINATION);
			stmt.setInt(1, limit);
			stmt.setInt(2, offset);
			résultats = stmt.executeQuery();
			while(résultats.next()) {
				Computer computer= null;
				if(Integer.valueOf(résultats.getInt("company_id"))!=0) {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, null, Integer.valueOf(résultats.getInt("company_id")));
					}
					else {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), Integer.valueOf(résultats.getInt("company_id")));
					}
				}
				else {
					if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")!=null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
					else if(résultats.getTimestamp("introduced")!=null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), null, null);
					}
					else if(résultats.getTimestamp("introduced")==null && résultats.getTimestamp("discontinued")==null) {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), null, null, null);
					}
					else {
						computer = new Computer(résultats.getInt("id"), résultats.getString("name"), résultats.getTimestamp("introduced").toLocalDateTime(), résultats.getTimestamp("discontinued").toLocalDateTime(), null);
					}
				}
				c.add(computer);
			}
			résultats.close();
			} catch (SQLException e) {
				e.printStackTrace();
			//traitement de l'exception
			}
		return c;// TODO Auto-generated method stub
	}


}

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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameterValue;

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
	private static final String SQL_FIND_BY_ID = "SELECT  computer.id , computer.name , introduced , discontinued , company_id , company.name  FROM  computer LEFT JOIN company ON computer.company_id = company.id WHERE  computer.id  = ?";
	
	private static final String SQL_COUNT_ALL = "SELECT COUNT(*) FROM computer ";
	
	
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
		Object[] vParams = {
	            new SqlParameterValue(Types.BIGINT, company.getId()),
	        };

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	        vJdbcTemplate.update(SQL_DELETE_COMPUTER_WHERE_COMPANY_ID, vParams);
	}
	
	/**
	 * Permet de trouver un Computer dans la base de données.
	 * @param id
	 * @return le Computer trouver.
	 * @throws SQLException 
	 */
	@Override
	public Computer find(int id) throws SQLException {
		Object[] vParams = {
	            new SqlParameterValue(Types.INTEGER, id),
	        };

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	        Computer vFindComputer = vJdbcTemplate.queryForObject(SQL_FIND_BY_ID, vParams, Computer.class);
	        return vFindComputer;
	}

	/**
	 * Permet de créer un nouveau Computer dans la base de données.
	 * @param obj (Computer)
	 * @return le Computer créer.
	 * @throws SQLException 
	 */
	@Override
	public void create(Computer obj) throws SQLException {
		Object[] vParams = {
	            new SqlParameterValue(Types.VARCHAR, obj.getName()),
	            new SqlParameterValue(Types.TIMESTAMP, obj.getIntroduced()!=null?Timestamp.valueOf(obj.getIntroduced().minusHours(2)):null),
	            new SqlParameterValue(Types.TIMESTAMP, obj.getDiscontinued()!=null?Timestamp.valueOf(obj.getDiscontinued().minusHours(2)):null),
	            new SqlParameterValue(Types.BIGINT, obj.getCompanyId().getId())
	            
	        };

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	        vJdbcTemplate.update(SQL_CREATE, vParams);
		
	}

	/**
	 * Permet d'effacer une Computer de la base de données.
	 * @param id
	 * @throws SQLException 
	 */
	@Override
	public void delete(int id) throws SQLException {
		Object[] vParams = {
	            new SqlParameterValue(Types.BIGINT, id),
	        };

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	        vJdbcTemplate.update(SQL_DELETE, vParams);
		
	}

	/**
	 * Permet de modifier une Computer de la base de données.
	 * @param obj (Computer)
	 * @return la Computer modifier.
	 * @throws SQLException 
	 */
	@Override
	public void update(Computer obj) throws SQLException {
		
		Object[] vParams = {
	            new SqlParameterValue(Types.VARCHAR, obj.getName()),
	            new SqlParameterValue(Types.TIMESTAMP, obj.getIntroduced()!=null?Timestamp.valueOf(obj.getIntroduced().minusHours(2)):null),
	            new SqlParameterValue(Types.TIMESTAMP, obj.getDiscontinued()!=null?Timestamp.valueOf(obj.getDiscontinued().minusHours(2)):null),
	            new SqlParameterValue(Types.BIGINT, obj.getCompanyId().getId()),
	            new SqlParameterValue(Types.BIGINT, obj.getId())
	            
	        };

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	        vJdbcTemplate.update(SQL_UPDATE, vParams);
		
	}
	
	public int countAll() throws SQLException{
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		int countComputers = vJdbcTemplate.queryForObject(SQL_COUNT_ALL, Integer.class);
		
		return countComputers;
	}
	
	/**
	 * Permet de visualiser les Computer de la base de données.
	 * @return liste des Computer de la base de données.
	 * @throws SQLException 
	 */
	@Override
	public List<Computer> displayAll() throws SQLException{
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Computer> vRowMapper = new RowMapper<Computer>() {
            public Computer mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                ComputerBuilder vComputer = new Computer.ComputerBuilder();
                int id = pRS.getInt("id");
			String name = pRS.getString("name");
			LocalDateTime introduced = pRS.getTimestamp("introduced")!=null?pRS.getTimestamp("introduced").toLocalDateTime():null;
			LocalDateTime discontinued = pRS.getTimestamp("discontinued")!=null?pRS.getTimestamp("discontinued").toLocalDateTime():null;
			Company companyId = pRS.getInt("company_id")!=0?new Company.CompanyBuilder(pRS.getInt("company_id")).name(pRS.getString("company.name")).build():null;
			vComputer.id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
                return vComputer.build();
            }
        };

        List<Computer> vListComputer = vJdbcTemplate.query(SQL_FIND_ALL, vRowMapper);

        return vListComputer;
		
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
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Computer> vRowMapper = new RowMapper<Computer>() {
            public Computer mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                ComputerBuilder vComputer = new Computer.ComputerBuilder();
                int id = pRS.getInt("id");
                String name = pRS.getString("name");
                LocalDateTime introduced = pRS.getTimestamp("introduced")!=null?pRS.getTimestamp("introduced").toLocalDateTime():null;
                LocalDateTime discontinued = pRS.getTimestamp("discontinued")!=null?pRS.getTimestamp("discontinued").toLocalDateTime():null;
                Company companyId = pRS.getInt("company_id")!=0?new Company.CompanyBuilder(pRS.getInt("company_id")).name(pRS.getString("company.name")).build():null;
                vComputer.id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
                return vComputer.build();
            }
        };

        List<Computer> vListComputerPagination = vJdbcTemplate.query(SQL_FIND_ALL_PAGINATION, vRowMapper, limit, offset);

        return vListComputerPagination!=null?vListComputerPagination:new ArrayList<Computer>();
	}
	
	public List<Computer> searchByNameAsc(String searchByName, String searchByCompany, int limit, int offset) throws SQLException {
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Computer> vRowMapper = new RowMapper<Computer>() {
            public Computer mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                ComputerBuilder vComputer = new Computer.ComputerBuilder();
                int id = pRS.getInt("id");
                String name = pRS.getString("name");
                LocalDateTime introduced = pRS.getTimestamp("introduced")!=null?pRS.getTimestamp("introduced").toLocalDateTime():null;
                LocalDateTime discontinued = pRS.getTimestamp("discontinued")!=null?pRS.getTimestamp("discontinued").toLocalDateTime():null;
                Company companyId = pRS.getInt("company_id")!=0?new Company.CompanyBuilder(pRS.getInt("company_id")).name(pRS.getString("company.name")).build():null;
                vComputer.id(id).name(name).introduced(introduced).discontinued(discontinued).companyId(companyId);
                return vComputer.build();
            }
        };

        List<Computer> vListComputerSearchByName = vJdbcTemplate.query(SQL_PAGE_NAME_ASC, vRowMapper, '%'+searchByName+'%','%'+searchByCompany+'%', limit, offset);

        return vListComputerSearchByName;
	}
	
	


}

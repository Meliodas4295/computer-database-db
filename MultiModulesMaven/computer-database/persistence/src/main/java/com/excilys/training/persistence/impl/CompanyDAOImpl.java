package com.excilys.training.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameterValue;

import com.excilys.training.core.Company;
import com.excilys.training.core.Computer;
import com.excilys.training.core.Company.CompanyBuilder;
import com.excilys.training.core.Computer.ComputerBuilder;
import com.excilys.training.persistence.AbstractDao;
import com.excilys.training.persistence.contract.CompanyDAO;
import com.excilys.training.persistence.contract.ComputerDAO;
import com.excilys.training.persistence.impl.CompanyDAOImpl;
import com.excilys.training.persistence.impl.ComputerDAOImpl;

public class CompanyDAOImpl extends AbstractDao implements CompanyDAO{
	private ComputerDAO computerDao;
	private final static Logger logger = LoggerFactory.getLogger(CompanyDAOImpl.class);
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
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Company> cQuery = criteriaBuilder.createQuery(Company.class);
		Root<Company> companyRoot = cQuery.from(Company.class);

		cQuery.select(criteriaBuilder.construct(Company.class, companyRoot.get("id"), companyRoot.get("name"), companyRoot.get("dateIntroduced"),
				companyRoot.get("dateDiscontinued"), companyRoot.get("company"))).where(criteriaBuilder.equal(companyRoot.get("id"), id));
		Company company = session.createQuery(cQuery).getSingleResult();
		tx.commit();
		session.close();
		return company;
	}

	
	/**
	 * Permet de créer une nouvelle company dans la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company créer.
	 */
	@Override
	public void create(Company obj) {}
	/**
	 * Permet d'effacer une Company de la base de données.
	 * @param id
	 * @throws SQLException 
	 */
	@Override
	public void delete(Company company) throws SQLException {
		Session session = getSessionFactory().openSession();
		session.delete(company);
		session.close();
	}
	/**
	 * Permet de modifier une Company de la base de données.
	 * (PS: Classe non implémenter)
	 * @param obj (Company)
	 * @return la Company modifier.
	 */
	@Override
	public void update(Company obj) {}
	
	/**
	 * Permet de visualiser les Company de la base de données.
	 * @return liste des Company de la base de données.
	 * @throws SQLException 
	 */
	@Override
	public List<Company> displayAll() throws SQLException{
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaQuery<Company> query = getEntityManager().getCriteriaBuilder().createQuery(Company.class);
		Root<Company> product = query.from(Company.class);
		query.select(product);
		List<Company> companies = session.createQuery(query)
		         .getResultList();
		tx.commit();
		session.close();
		return companies;
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
		return new ArrayList<Company>();
	}
	

}

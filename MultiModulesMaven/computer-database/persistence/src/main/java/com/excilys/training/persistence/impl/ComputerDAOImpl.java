package com.excilys.training.persistence.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.excilys.training.core.Company;
import com.excilys.training.core.Computer;
import com.excilys.training.core.Computer.ComputerBuilder;
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
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Computer> criteriaDelete = criteriaBuilder.createCriteriaDelete(Computer.class);
        Root<Computer> computerRoot = criteriaDelete.from(Computer.class);

        criteriaDelete.where(criteriaBuilder.equal(computerRoot.get("company"), company));
        tx.commit();
		session.close();
	}
	
	/**
	 * Permet de trouver un Computer dans la base de données.
	 * @param id
	 * @return le Computer trouver.
	 * @throws SQLException 
	 */
	@Override
	public Computer find(int id) throws SQLException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Computer> cQuery = criteriaBuilder.createQuery(Computer.class);
		Root<Computer> computerRoot = cQuery.from(Computer.class);

		cQuery.select(criteriaBuilder.construct(Computer.class, computerRoot.get("id"), computerRoot.get("name"), computerRoot.get("dateIntroduced"),
				computerRoot.get("dateDiscontinued"), computerRoot.get("company"))).where(criteriaBuilder.equal(computerRoot.get("id"), id));
		Computer computer = session.createQuery(cQuery).getSingleResult();
		tx.commit();
		return computer;
	}

	/**
	 * Permet de créer un nouveau Computer dans la base de données.
	 * @param obj (Computer)
	 * @return le Computer créer.
	 * @throws SQLException 
	 */
	@Override
	public void create(Computer obj) throws SQLException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		ComputerBuilder computer = new Computer.ComputerBuilder().id(obj.getId()).name(obj.getName()).introduced(obj.getIntroduced()).discontinued(obj.getDiscontinued()).companyId(obj.getCompanyId()); 
		session.save(computer.build());
		tx.commit();
		session.close();
	}

	/**
	 * Permet d'effacer une Computer de la base de données.
	 * @param id
	 * @throws SQLException 
	 */
	@Override
	public void delete(int id) throws SQLException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		ComputerBuilder computer = new Computer.ComputerBuilder().id(id);
		session.delete(computer.build());
		tx.commit();
		session.close();
		
	}

	/**
	 * Permet de modifier une Computer de la base de données.
	 * @param obj (Computer)
	 * @return la Computer modifier.
	 * @throws SQLException 
	 */
	@Override
	public void update(Computer obj) throws SQLException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(obj);
        tx.commit();
        session.close();
		
	}
	
	public Long countAll() throws SQLException{
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
	    criteria.select(builder.count(criteria.from(Computer.class)));
	    TypedQuery<Long> query = session.createQuery(criteria);
	    Long count = query.getSingleResult();
	    tx.commit();
	    session.close();
	    return count;
	}
	
	/**
	 * Permet de visualiser les Computer de la base de données.
	 * @return liste des Computer de la base de données.
	 * @throws SQLException 
	 */
	@Override
	public List<Computer> displayAll() throws SQLException{
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaQuery<Computer> query = session.getCriteriaBuilder().createQuery(Computer.class);
		Root<Computer> product = query.from(Computer.class);
		query.select(product);
		List<Computer> computers =session.createQuery(query)
		         .getResultList(); 
		tx.commit();
		session.close();
		return computers;
		
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
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaQuery<Computer> query = session.getCriteriaBuilder().createQuery(Computer.class);
		Root<Computer> product = query.from(Computer.class);
		query.select(product);
		List<Computer> computersPagination = session.createQuery(query)
		         .setFirstResult(offset) // offset
		         .setMaxResults(limit) // limit
		         .getResultList();
		tx.commit();
		session.close();
		return computersPagination;
	}
	
	public List<Computer> searchByNameAsc(String searchByName, String searchByCompany, int limit, int offset) throws SQLException {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Computer> criteriaQuery = criteriaBuilder.createQuery(Computer.class);
		Root<Computer> computerRoot = criteriaQuery.from(Computer.class);
		
		criteriaQuery.select(computerRoot).orderBy(criteriaBuilder.asc(computerRoot.get("name"))).where(criteriaBuilder.like(computerRoot.<String>get("name"), "%"+searchByName+"%"));
		List<Computer> searchComputer = session.createQuery(criteriaQuery).setFirstResult(offset).setMaxResults(limit).getResultList();
		tx.commit();
		session.close();
		return searchComputer;
	}
	
	


}

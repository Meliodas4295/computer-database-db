package com.excilys.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.model.Company;
import com.excilys.training.persistence.CompanyDao;

public class CompanyDaoTest extends TestCase {
	private CompanyDao companyDao;
	
	@Before
	protected void setUp() throws Exception {
		companyDao = CompanyDao.getInstance();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		companyDao = null;
		super.tearDown();
	}

	@Test
	public void testDisplayAll() {
		List<Company> th = new ArrayList<Company>();
		th.add(new Company.CompanyBuilder(30).name("Sanyo").build());
		List<Company> pr = companyDao.displayAll();
		assertTrue(pr.contains(th.get(0)));
	}

	@Test
	public void testCompanyDao() {
		assertTrue(companyDao.equals(companyDao));
		
	}

	@Test
	public void testDisplayInt() {
		Company companyTh = new Company.CompanyBuilder(30).name("Sanyo").build();
		Company companyPr = companyDao.find(30);
		assertTrue(companyTh.equals(companyPr));
	}

	@Test
	public void testCreateCompany() {
		assertTrue(true);
	}

	@Test
	public void testDeleteCompany() {
		assertTrue(true);
	}

	@Test
	public void testUpdateCompanyStringString() {
		assertTrue(true);
	}

}

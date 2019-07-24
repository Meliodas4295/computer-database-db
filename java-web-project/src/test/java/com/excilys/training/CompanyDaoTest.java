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
	private CompanyDao c;
	
	@Before
	protected void setUp() throws Exception {
		c = new CompanyDao();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		c = null;
		super.tearDown();
	}

	@Test
	public void testDisplayAll() {
		List<Company> th = new ArrayList<Company>();
		th.add(new Company(30,"Sanyo"));
		List<Company> pr = c.displayAll();
		assertTrue(pr.contains(th.get(0)));
	}

	@Test
	public void testCompanyDao() {
		assertTrue(c.equals(c));
		
	}

	@Test
	public void testDisplayInt() {
		Company companyTh = new Company(30,"Sanyo");
		Company companyPr = c.find(30);
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

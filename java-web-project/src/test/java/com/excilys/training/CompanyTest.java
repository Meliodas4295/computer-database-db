package com.excilys.training;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.model.Company;

public class CompanyTest extends TestCase {
	
	private Company company;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		company = new Company.CompanyBuilder(30).name("Sanyo").build();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		company = null;
	}

	@Test
	public void testCompany() {
		assertNotNull("L'instance n'est pas créée", company);
	}

	@Test
	public void testGetId() {
		int resultatth = 30;
		int resultatpr = company.getId();
		assertEquals(resultatth, resultatpr);
	}

	@Test
	public void testGetName() {
		assertEquals("Le nom est incorrect", "Sanyo", company.getName());
	}

	@Test
	public void testToString() {
		assertEquals("Le nom est incorrect", "Company [getId()=30, getName()=Sanyo]", company.toString());
	}

}

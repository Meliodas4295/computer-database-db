package com.excilys.training;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.model.Company;

public class CompanyTest extends TestCase {
	
	private Company c;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		c = new Company(30,"Sanyo");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		c = null;
	}

	@Test
	public void testCompany() {
		assertNotNull("L'instance n'est pas créée", c);
	}

	@Test
	public void testGetId() {
		int resultatth = 30;
		int resultatpr = c.getId();
		assertEquals(resultatth, resultatpr);
	}

	@Test
	public void testSetId() {
		c.setId(40);
		assertEquals(40 ,c.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("Le nom est incorrect", "Sanyo", c.getName());
	}

	@Test
	public void testSetName() {
		c.setName("Lego");
		assertEquals("Le nom est incorrect", "Lego", c.getName());
	}

	@Test
	public void testToString() {
		assertEquals("Le nom est incorrect", "Company [getId()=30, getName()=Sanyo]", c.toString());
	}

}

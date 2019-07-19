package main.java.com.excilys.training.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.java.com.excilys.training.web.controller.dto.CompanyDto;

public class CompanyDtoTest extends TestCase {
	
	private CompanyDto c;

	@Before
	protected void setUp() throws Exception {
		c = new CompanyDto(30,"Sanyo");
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		c = null;
		super.tearDown();
	}

	@Test
	public void testCompanyDto() {
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

}

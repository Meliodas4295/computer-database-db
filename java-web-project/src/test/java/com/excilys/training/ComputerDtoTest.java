package com.excilys.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.web.controller.dto.ComputerDto;

public class ComputerDtoTest extends TestCase {
	
	private ComputerDto c;

	@Before
	protected void setUp() throws Exception {
		c = new ComputerDto(507, "English Electric DEUCE", "NULL","NULL", "NULL");
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		c = null;
		super.tearDown();
	}

	@Test
	public void testComputerDto() {
		assertNotNull("L'instance n'est pas créée", c);
	}

	@Test
	public void testGetId() {
		assertEquals(507, c.getId());
	}

	@Test
	public void testSetId() {
		c.setId(600);
		assertEquals(600 ,c.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("Le nom est incorrect", "English Electric DEUCE", c.getName());
	}

	@Test
	public void testSetName() {
		c.setName("Kentucky Linux Athlon Testbed");
		assertEquals("Le nom est incorrect", "Kentucky Linux Athlon Testbed", c.getName());
	}

	@Test
	public void testGetIntroduced() {
		assertEquals("Le nom est incorrect", "NULL", c.getIntroduced());
	}

	@Test
	public void testSetIntroduced() {
		c.setIntroduced("2018-12-11 17:30");
		assertEquals("Le nom est incorrect", "2018-12-11 17:30", c.getIntroduced());
	}

	@Test
	public void testGetDiscontinued() {
		assertEquals("Le nom est incorrect", "NULL", c.getDiscontinued());
	}

	@Test
	public void testSetDiscontinued() {
		String dateTime = "2018-12-11 17:30";
        c.setDiscontinued(dateTime);
		assertEquals("Le nom est incorrect", dateTime, c.getDiscontinued());
	}

	@Test
	public void testGetCompany_id() {
		assertEquals("Le nom est incorrect", "NULL", c.getCompany_id());
	}

	@Test
	public void testSetCompany_id() {
		c.setCompany_id("12");
		assertEquals("Le nom est incorrect", "12", c.getCompany_id());
	}

}

package com.excilys.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.model.Computer;

public class ComputerTest extends TestCase {
	
	private Computer c;

	@Before
	protected void setUp() throws Exception {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		c = new Computer(507, "English Electric DEUCE", introduced,discontinued, companyId);
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		c = null;
		super.tearDown();
	}

	@Test
	public void testComputer() {
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
		LocalDateTime newIntroduced = null;
		assertEquals("Le nom est incorrect", newIntroduced, c.getIntroduced());
	}

	@Test
	public void testSetIntroduced() {
		String dateTime = "2018-12-11 17:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(dateTime, formatter);
        c.setIntroduced(formatDateTime);
		assertEquals("Le nom est incorrect", formatDateTime, c.getIntroduced());
	}

	@Test
	public void testGetDiscontinued() {
		LocalDateTime newDiscontinued = null;
		assertEquals("Le nom est incorrect", newDiscontinued, c.getDiscontinued());
	}

	@Test
	public void testSetDiscontinued() {
		String dateTime = "2018-12-11 17:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(dateTime, formatter);
        c.setDiscontinued(formatDateTime);
		assertEquals("Le nom est incorrect", formatDateTime, c.getDiscontinued());
	}

	@Test
	public void testGetCompany_id() {
		Integer i = null;
		assertEquals("Le nom est incorrect", i, c.getCompany_id());
	}

	@Test
	public void testSetCompany_id() {
		Integer i = 12;
		c.setCompany_id(i);
		assertEquals("Le nom est incorrect", i, c.getCompany_id());
	}

	@Test
	public void testToString() {
		assertEquals("Computer [getId()=507, getName()=English Electric DEUCE, getIntroduced()=null, getDiscontinued()=null, getCompany_id()=null]", c.toString());
	}

}

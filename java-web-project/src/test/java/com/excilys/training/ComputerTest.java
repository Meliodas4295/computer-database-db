package com.excilys.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;

public class ComputerTest extends TestCase {
	
	private Computer computer;

	@Before
	protected void setUp() throws Exception {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Company companyId = null;
		computer = new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		computer = null;
		super.tearDown();
	}

	@Test
	public void testComputer() {
		assertNotNull("L'instance n'est pas créée", computer);
	}

	@Test
	public void testGetId() {
		assertEquals(507, computer.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("Le nom est incorrect", "English Electric DEUCE", computer.getName());
	}

	@Test
	public void testGetIntroduced() {
		LocalDateTime newIntroduced = null;
		assertEquals("Le nom est incorrect", newIntroduced, computer.getIntroduced());
	}

	@Test
	public void testGetDiscontinued() {
		LocalDateTime newDiscontinued = null;
		assertEquals("Le nom est incorrect", newDiscontinued, computer.getDiscontinued());
	}


	@Test
	public void testGetCompanyId() {
		Company i = null;
		assertEquals("Le nom est incorrect", i, computer.getCompanyId());
	}


	@Test
	public void testToString() {
		assertEquals("Computer [id=507, name=English Electric DEUCE, introduced=null, discontinued=null, companyId=null]", computer.toString());
	}
}

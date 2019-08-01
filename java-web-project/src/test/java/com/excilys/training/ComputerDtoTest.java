package com.excilys.training;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.web.controller.dto.ComputerDto;

public class ComputerDtoTest extends TestCase {
	
	private ComputerDto computerDto;

	@Before
	protected void setUp() throws Exception {
		computerDto = new ComputerDto.ComputerDtoBuilder("English Electric DEUCE", "NULL","NULL", "NULL").id(507).build();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		computerDto = null;
		super.tearDown();
	}

	@Test
	public void testComputerDto() {
		assertNotNull("L'instance n'est pas créée", computerDto);
	}

	@Test
	public void testGetId() {
		assertEquals(507, computerDto.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("Le nom est incorrect", "English Electric DEUCE", computerDto.getName());
	}

	@Test
	public void testGetIntroduced() {
		assertEquals("Le nom est incorrect", "NULL", computerDto.getIntroduced());
	}

	@Test
	public void testGetDiscontinued() {
		assertEquals("Le nom est incorrect", "NULL", computerDto.getDiscontinued());
	}

	@Test
	public void testGetCompanyId() {
		assertEquals("Le nom est incorrect", "NULL", computerDto.getCompanyId());
	}

}

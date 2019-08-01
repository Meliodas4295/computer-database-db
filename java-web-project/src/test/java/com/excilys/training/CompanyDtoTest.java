package com.excilys.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.web.controller.dto.CompanyDto;

public class CompanyDtoTest extends TestCase {
	
	private CompanyDto companyDto;

	@Before
	protected void setUp() throws Exception {
		companyDto = new CompanyDto.CompanyDtoBuilder(30).name("Sanyo").build();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		companyDto = null;
		super.tearDown();
	}

	@Test
	public void testCompanyDto() {
		assertNotNull("L'instance n'est pas créée", companyDto);
	}

	@Test
	public void testGetId() {
		int resultatth = 30;
		int resultatpr = companyDto.getId();
		assertEquals(resultatth, resultatpr);
	}


	@Test
	public void testGetName() {
		assertEquals("Le nom est incorrect", "Sanyo", companyDto.getName());
	}


}

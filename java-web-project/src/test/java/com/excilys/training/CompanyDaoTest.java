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
		th.add(new Company(30,"Sanyo"));
		List<Company> pr = c.displayAll();

		th.add(new Company(30,"Sanyo"));
		List<Company> pr = c.displayAll();
		assertTrue(pr.contains(th.get(0)));

		StringBuffer th = new StringBuffer( "1 Apple Inc. \n" + 
				"2 Thinking Machines \n" + 
				"3 RCA \n" + 
				"4 Netronics \n" + 
				"5 Tandy Corporation \n" + 
				"6 Commodore International \n" + 
				"7 MOS Technology \n" + 
				"8 Micro Instrumentation and Telemetry Systems \n" + 
				"9 IMS Associates, Inc. \n" + 
				"10 Digital Equipment Corporation \n" + 
				"11 Lincoln Laboratory \n" + 
				"12 Moore School of Electrical Engineering \n" + 
				"13 IBM \n" + 
				"14 Amiga Corporation \n" + 
				"15 Canon \n" + 
				"16 Nokia \n" + 
				"17 Sony \n" + 
				"18 OQO \n" + 
				"19 NeXT \n" + 
				"20 Atari \n" + 
				"22 Acorn computer \n" + 
				"23 Timex Sinclair \n" + 
				"24 Nintendo \n" + 
				"25 Sinclair Research Ltd \n" + 
				"26 Xerox \n" + 
				"27 Hewlett-Packard \n" + 
				"28 Zemmix \n" + 
				"29 ACVS \n" + 
				"30 Sanyo \n" + 
				"31 Cray \n" + 
				"32 Evans & Sutherland \n" + 
				"33 E.S.R. Inc. \n" + 
				"34 OMRON \n" + 
				"35 BBN Technologies \n" + 
				"36 Lenovo Group \n" + 
				"37 ASUS \n" + 
				"38 Amstrad \n" + 
				"39 Sun Microsystems \n" + 
				"40 Texas Instruments \n" + 
				"41 HTC Corporation \n" + 
				"42 Research In Motion \n" + 
				"43 Samsung Electronics \n");
		List<Company> pr = c.displayAll();
		assertEquals(th.toString(), pr.toString());
		List<Company> th = new ArrayList<Company>();
		th.add(new Company(30,"Sanyo"));
		List<Company> pr = c.displayAll();
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

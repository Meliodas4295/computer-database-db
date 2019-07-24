package com.excilys.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import com.excilys.training.model.Computer;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.persistence.ComputerDao;

public class ComputerDaoTest extends TestCase {
	private ComputerDao c;
	@Before
	protected void setUp() throws Exception {
		c = new ComputerDao();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		c = null;
		super.tearDown();
	}

	@Test
	public void testDisplayAll() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		List<Computer> th = new ArrayList<Computer>();
		th.add(new Computer(507,"English Electric DEUCE", introduced,discontinued, companyId));
		List<Computer> pr = c.displayAll();
		assertTrue(pr.contains(th.get(0)));
	}

	@Test
	public void testComputerDao() {
		assertNotNull("L'instance n'est pas créée", c);
	}

	@Test
	public void testDisplayInt() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer(507,"English Electric DEUCE", introduced,discontinued, companyId);
		Computer computerPr = c.find(507);
		assertEquals(computerTh, computerPr);
	}

	@Test
	public void testCreateComputer() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer("CX", introduced,discontinued, companyId);
		List<Computer> firstList = c.displayAll();
		c.create(computerTh);
		List<Computer> listc = c.displayAll();
		assertTrue(listc.size()>firstList.size());
	}

	@Test
	public void testDeleteComputer() {
		List<Computer> computer = c.displayAll();
		Computer newComputer = computer.get(computer.size()-1);
		c.delete(newComputer.getId());
		List<Computer> listc = c.displayAll();
		assertFalse(listc.contains(newComputer));
	}

	@Test
	public void testUpdateComputerStringString() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Integer companyId = null;
		Computer computerTh = new Computer(507,"English Electric DEUCE", introduced,discontinued, companyId);
		c.update(computerTh);
		List<Computer> listc = c.displayAll();
		assertTrue(listc.contains(computerTh));
	}

}

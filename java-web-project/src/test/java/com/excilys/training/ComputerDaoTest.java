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

import com.excilys.training.model.Company;
import com.excilys.training.model.Computer;
import com.excilys.training.persistence.CompanyDao;
import com.excilys.training.persistence.ComputerDao;

public class ComputerDaoTest extends TestCase {
	private ComputerDao computerDao;
	@Before
	protected void setUp() throws Exception {
		computerDao = ComputerDao.getInstance();
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		computerDao = null;
		super.tearDown();
	}

	@Test
	public void testDisplayAll() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Company companyId = null;
		List<Computer> listComputreTh = new ArrayList<Computer>();
		listComputreTh.add(new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build());
		List<Computer> listComputrePr = computerDao.displayAll();
		assertTrue(listComputrePr.contains(listComputreTh.get(0)));
	}

	@Test
	public void testComputerDao() {
		assertNotNull("L'instance n'est pas créée", computerDao);
	}

	@Test
	public void testDisplayInt() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Company companyId = null;
		Computer computerTh = new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build();
		Computer computerPr = computerDao.find(507);
		System.out.println(computerTh);
		System.out.print(computerPr);
		assertTrue(computerTh.equals(computerPr));
	}

	@Test
	public void testCreateComputer() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Company companyId = null;
		Computer computerTh = new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build();
		List<Computer> firstList = computerDao.displayAll();
		computerDao.create(computerTh);
		List<Computer> listc = computerDao.displayAll();
		assertTrue(listc.size()>firstList.size());
	}
	
	@Test
	public void testDeleteComputer() {
		List<Computer> computer = computerDao.displayAll();
		Computer newComputer = computer.get(computer.size()-1);
		computerDao.delete(newComputer.getId());
		List<Computer> listc = computerDao.displayAll();
		assertFalse(listc.contains(newComputer));
	}

	@Test
	public void testUpdateComputerStringString() {
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		Company companyId = null;
		Computer computerTh = new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build();
		computerDao.update(computerTh);
		List<Computer> listc = computerDao.displayAll();
		assertTrue(listc.contains(computerTh));
	}

}

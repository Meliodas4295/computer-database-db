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
<<<<<<< HEAD
		Company companyId = null;
		List<Computer> listComputreTh = new ArrayList<Computer>();
		listComputreTh.add(new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build());
		List<Computer> listComputrePr = computerDao.displayAll();
		assertTrue(listComputrePr.contains(listComputreTh.get(0)));
=======
		Integer companyId = null;
		List<Computer> th = new ArrayList<Computer>();
		th.add(new Computer(507,"English Electric DEUCE", introduced,discontinued, companyId));
		List<Computer> pr = c.displayAll();
		assertTrue(pr.contains(th.get(0)));
>>>>>>> develop
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
<<<<<<< HEAD
		Company companyId = null;
		Computer computerTh = new Computer.ComputerBuilder().id(507).name("English Electric DEUCE").introduced(introduced).discontinued(discontinued).companyId(companyId).build();
		List<Computer> firstList = computerDao.displayAll();
		computerDao.create(computerTh);
		List<Computer> listc = computerDao.displayAll();
=======
		Integer companyId = null;
		Computer computerTh = new Computer("CX", introduced,discontinued, companyId);
		List<Computer> firstList = c.displayAll();
		c.create(computerTh);
		List<Computer> listc = c.displayAll();
>>>>>>> develop
		assertTrue(listc.size()>firstList.size());
	}
	
	@Test
	public void testDeleteComputer() {
<<<<<<< HEAD
		List<Computer> computer = computerDao.displayAll();
		Computer newComputer = computer.get(computer.size()-1);
		computerDao.delete(newComputer.getId());
		List<Computer> listc = computerDao.displayAll();
=======
		List<Computer> computer = c.displayAll();
		Computer newComputer = computer.get(computer.size()-1);
		c.delete(newComputer.getId());
		List<Computer> listc = c.displayAll();
>>>>>>> develop
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

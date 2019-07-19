package com.excilys.training;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompanyDaoTest.class, CompanyDtoTest.class, CompanyTest.class, ComputerDaoTest.class,
		ComputerDtoTest.class, ComputerTest.class })
public class AllTests {

}

package com.qa.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseClass.baseCLassDecleration;
import com.qa.pageObjects.homePage;
import com.qa.pageObjects.openNewAccount;

public class TcopenNewAcc extends baseCLassDecleration{
	openNewAccount np;
	homePage hp;
	
	public TcopenNewAcc() {
		super();
	}
@BeforeClass(alwaysRun = true)
	public void launch() {
		setup();
		hp=new homePage();
		np=new openNewAccount();
		hp.login();
		hp.cona();
	}
	
@Test(priority = 1)
public void htitle() {
	 String ti=hp.title();
	 assertEquals(ti, "ParaBank | Open Account");
}
	@Test(priority = 2)
	public void add() {
		np.nacc();
	}
	@Test(priority = 3)
	public void otitle() {
		 String ti=np.vt();
		 assertEquals(ti, "Account Opened!");
	}
	@Test(priority = 4)
	public void aoc() {
		np.ao();
	}
	@AfterClass(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}

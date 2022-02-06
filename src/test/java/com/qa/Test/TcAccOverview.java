package com.qa.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseClass.baseCLassDecleration;
import com.qa.pageObjects.accountsOverview;
import com.qa.pageObjects.homePage;
import com.qa.pageObjects.openNewAccount;

public class TcAccOverview extends baseCLassDecleration{
//	openNewAccount np;
	homePage hp;
	accountsOverview aoo;
	public TcAccOverview() {
		super();
	}
@BeforeClass(alwaysRun = true)
	public void launch() {
		setup();
		hp=new homePage();
//		np=new openNewAccount();
		aoo=new accountsOverview();
		hp.login();
	}
	
@Test(priority = 1)
public void htitle() {
	 String ti=aoo.title();
	 assertEquals(ti, "ParaBank | Accounts Overview");
}
	@Test(priority = 2)
	public void add() {
		aoo.ca1();
	}
	@Test(priority = 3)
	public void aotitle() {
		 String ti=aoo.vt();
		 assertEquals(ti, "Account Details");
	}
	
	@AfterClass(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}

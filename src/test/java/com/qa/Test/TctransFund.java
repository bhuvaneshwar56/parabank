package com.qa.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseClass.baseCLassDecleration;
import com.qa.pageObjects.TransferFunds;
import com.qa.pageObjects.accountsOverview;
import com.qa.pageObjects.homePage;

public class TctransFund  extends baseCLassDecleration{
//	openNewAccount np;
	homePage hp;
//	accountsOverview aoo;
	TransferFunds tp;
	
	
	public TctransFund() {
		super();
	}
@BeforeClass(alwaysRun = true)
	public void launch() {
		setup();
		hp=new homePage();
//		np=new openNewAccount();
	//	aoo=new accountsOverview();
		tp=new TransferFunds();
		hp.login();
	}
	
@Test(priority = 4,groups = {"smoke" ,"regression","sanity"})
public void htitle() {
	 String ti=tp.title();
	 assertEquals(ti, "ParaBank | Transfer Funds");
}
	@Test(priority = 2,groups = {"smoke"})
	public void t1() throws InterruptedException {
		tp.ta1();
	}
	@Test(priority = 3,groups = {"smoke"})
	public void aotitle() {
		 String ti=tp.vt();
		 assertEquals(ti, "Transfer Complete!");
	}
	
	@AfterClass(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}

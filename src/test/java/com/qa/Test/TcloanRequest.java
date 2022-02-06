package com.qa.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseClass.baseCLassDecleration;
import com.qa.pageObjects.TransferFunds;
import com.qa.pageObjects.homePage;
import com.qa.pageObjects.loanRequest;


public class TcloanRequest extends baseCLassDecleration{
	//	openNewAccount np;
	homePage hp;
//	accountsOverview aoo;
	TransferFunds tp;
	loanRequest lp;
	
	
	
	public TcloanRequest() {
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
		lp=new loanRequest();
		
	}
	
@Test(priority = 3,groups = {"smoke" ,"regression","sanity"})
public void htitle() {
	 String ti=lp.title();
	 assertEquals(ti, "ParaBank | Loan Request");
}
	@Test(priority = 1,groups = {"smoke" ,"regression","sanity"})
	public void t1() throws InterruptedException {
		lp.ta1();
	}
	@Test(priority = 2,groups = {"smoke" ,"regression","sanity"})
	public void aotitle() {
		 String ti=lp.vt();
		 assertEquals(ti, "Congratulations, your loan has been approved.");
	}
	
	@AfterClass(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}




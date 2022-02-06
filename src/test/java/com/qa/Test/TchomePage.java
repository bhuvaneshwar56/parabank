package com.qa.Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.baseClass.baseCLassDecleration;
import com.qa.pageObjects.homePage;

public class TchomePage extends baseCLassDecleration {
	homePage hp;

	public TchomePage() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void launch() {
		setup();
		hp = new homePage();
	}

	@Test(priority = 1, groups = {"smoke" ,"regression","sanity"}) 
	public void htitle() {
		String ti = hp.title();
		assertEquals(ti, "ParaBank | Welcome | Online Banking");
	}

	@Test(priority = 2, groups = { "smoke" ,"regression"})
	public void log() {
		hp.login();
	}

	@Test(priority = 4, groups = { "smoke","regression" })
	public void ltitle() {
		String ti = hp.title();
		assertEquals(ti, "ParaBank | Open Account");
	}

	@Test(priority = 3, groups = { "smoke","regression" })
	public void con() {
		hp.cona();
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driver.quit();
	}
}

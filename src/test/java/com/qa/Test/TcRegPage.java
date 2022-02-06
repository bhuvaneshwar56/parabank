package com.qa.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


import com.qa.baseClass.baseCLassDecleration;
import com.qa.pageObjects.homePage;
import com.qa.pageObjects.registerPage;
import com.qa.utilities.readDataExcel;

@Ignore
public class TcRegPage extends baseCLassDecleration {
	registerPage rp;
	homePage hp;
	
	//constructor
	public TcRegPage() {
		super();//invoke baseclass contstructor
	}
	@BeforeClass
	public void launch() {
		setup();
		rp=new registerPage();
		hp=new homePage();
		
	}
	
	@Test(priority = 1,dataProvider="dataToRead")
	public void regFill(String f,String l,String ad,String c,String s,String pi,String ph,String sn,String u,String pas,String cp)
	{
		rp.fillRegister(f, l, ad, c, s, pi, ph, sn, u, pas, cp);
		
	}
	
	@Test(priority = 2)
	public void ver() {
		String s=rp.regVerify();
		Assert.assertEquals(s, "Welcome ab");
	}
	
	@DataProvider
	public Object[][] dataToRead() throws EncryptedDocumentException, IOException, InvalidFormatException
	  { 
	    Object data[][] =readDataExcel.getTestData("register");
	    return data; 
	    }
	@AfterClass
	public void close() {
		driver.quit();
	}

}

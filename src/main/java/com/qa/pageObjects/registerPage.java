package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.baseCLassDecleration;

public class registerPage extends baseCLassDecleration{
	
	public registerPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement reg;
	
	@FindBy(id = "customer.firstName")
	WebElement fn;
	
	@FindBy(id = "customer.lastName")
	WebElement ln;
	@FindBy(id = "customer.address.street")
	WebElement adr;
	@FindBy(id = "customer.address.city")
	WebElement city;
	@FindBy(id = "customer.address.state")
	WebElement state;
	@FindBy(id = "customer.address.zipCode")
	WebElement pin;

	@FindBy(id = "customer.phoneNumber")
	WebElement phn;

	@FindBy(id = "customer.ssn")
	WebElement ssn;

	

	@FindBy(id = "customer.username")
	WebElement un;

	@FindBy(id = "customer.password")
	WebElement pass;
	@FindBy(id = "repeatedPassword")
	WebElement cpass;
	
	@FindBy(xpath = "//input[@value='Register']")
	WebElement regBtn;
	
	@FindBy(xpath = "//*[text()='Welcome abc']")
	WebElement afterRegVerify;
	//actions
	public homePage fillRegister(String f,String l,String ad,String c,String s,String pi,String ph,String sn,String u,String pas,String cp) {
		reg.click();
		fn.sendKeys(f);
		ln.sendKeys(l);
		adr.sendKeys(ad);
		city.sendKeys(c);
		state.sendKeys(s);
		pin.sendKeys(pi);
		phn.sendKeys(ph);
		ssn.sendKeys(sn);
		un.sendKeys(u);
		pass.sendKeys(pas);
		cpass.sendKeys(cp);	
		regBtn.click();
		return new homePage();
	}
	public String regVerify() {
		return afterRegVerify.getText();
		 
	}
	

	

}

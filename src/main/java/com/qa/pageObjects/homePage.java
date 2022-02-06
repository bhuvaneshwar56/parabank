package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.baseCLassDecleration;

public class homePage extends  baseCLassDecleration{
	
	public homePage()  {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement  un     ;

	@FindBy(xpath = "//input[@name='password']")
	WebElement  pass     ;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement  login     ;
	@FindBy(xpath = "//a[text()='Open New Account']")
	WebElement  ona; 
	//actions
	public String title() {
		return driver.getTitle();		
	}
	public void login() {
		un.sendKeys(prop.getProperty("user"));
		pass.sendKeys(prop.getProperty("password"));
		login.click();
		
		
	}
	public openNewAccount cona() {
		
		ona.click();
		return new openNewAccount();
	}
	
}


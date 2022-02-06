package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.baseClass.baseCLassDecleration;

public class openNewAccount extends baseCLassDecleration {
	
	public openNewAccount() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//select[@id='type']")
	WebElement  typebtn     ;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	WebElement  acctype     ;

	@FindBy(xpath = "//input[@value='Open New Account']")
	WebElement  ona     ;
	@FindBy(xpath = "//h1[text()='Account Opened!']")
	WebElement  verifyText; 
	@FindBy(xpath = "//a[text()='Accounts Overview']")
	WebElement  ao;
	//actions
	public String title() {
		return driver.getTitle();		
	}
	public void nacc() {
//		typebtn.click();
		Select tb=new Select(typebtn);
		tb.selectByVisibleText("SAVINGS");
		
		Select tb1=new Select(acctype);
	//	tb1.selectByIndex(0);
	tb1.selectByVisibleText("14565");
		//tb1.selectByIndex(2);
		ona.click();		
		
		
		
	}
	public String vt() {
		return verifyText.getText();
	}
	
	public accountsOverview ao() {
		ao.click();
		return new accountsOverview();
	}
}

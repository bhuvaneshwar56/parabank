package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.baseCLassDecleration;

 
public class TransferFunds extends baseCLassDecleration {
	public TransferFunds() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[text()='Transfer Funds'] ")
	WebElement  a1     ;
	@FindBy(xpath = "//input[@id='amount']   ")
	WebElement  a2     ;
	@FindBy(xpath = "//input[@value='Transfer']  ")
	WebElement  a3  ;
	  
		@FindBy(xpath = "//h1[text()='Transfer Complete!']")
	WebElement  verifyText; 
	
	//actions
	public String title() {
		return driver.getTitle();		
	}
	public void ta1() throws InterruptedException {
		a1.click();
		Thread.sleep(2000);
			a2.sendKeys("555");
		a3.click();
		Thread.sleep(2000);
	}
	public String vt() {
		return verifyText.getText();
	}
}


package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseClass.baseCLassDecleration;

public class loanRequest extends baseCLassDecleration {
	public loanRequest() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[text()='Request Loan'] ")
	WebElement  a1     ;
	@FindBy(xpath = "//input[@id='amount']   ")
	WebElement  a2     ;
	@FindBy(xpath = "//input[@id='downPayment']  ")
	WebElement  a3  ;
	
	@FindBy(xpath = "//input[@value='Apply Now'] ")
	WebElement  a4  ;
		@FindBy(xpath = "//p[text()='Congratulations, your loan has been approved.'] ")
	WebElement  verifyText; 
	
	//actions
	public String title() {
		return driver.getTitle();		
	}
	public void ta1() throws InterruptedException {
		a1.click();
		
			a2.sendKeys("555");
		a3.sendKeys("222");
		Thread.sleep(2000);
		a4.click();
	}
	public String vt() {
		return verifyText.getText();
	}
}


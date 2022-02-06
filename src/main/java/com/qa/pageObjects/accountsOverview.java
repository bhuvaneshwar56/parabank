package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.baseClass.baseCLassDecleration;

public class accountsOverview extends baseCLassDecleration {
	
	public accountsOverview() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[text()='14565']  ")
	WebElement  a1     ;

		@FindBy(xpath = "//h1[text()='Account Details']")
	WebElement  verifyText; 
	
	//actions
	public String title() {
		return driver.getTitle();		
	}
	public void ca1() {
		a1.click();
	}
	public String vt() {
		return verifyText.getText();
	}
}

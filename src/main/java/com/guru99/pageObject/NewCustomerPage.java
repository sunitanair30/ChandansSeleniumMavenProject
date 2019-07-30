package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	public NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "name")
	public WebElement txtCustomerName; 
}

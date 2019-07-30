package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "New Customer")
	public WebElement newCustomerLink;
	
	@FindBy(linkText = "Edit Customer")
	public WebElement editCustomerLink;
	
	@FindBy(linkText = "New Account")
	public WebElement newAccountLink;
}

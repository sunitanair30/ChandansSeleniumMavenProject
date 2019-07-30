package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "uid")
	public WebElement txtUserId; 
	
	@FindBy(name = "password")
	public WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	public WebElement btnLogin;
	
	@FindBy(name="btnReset")
	public WebElement btnReset;
	
}

package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.factory.DriverFactory;

public class FirstTestNGDemo {
	WebDriver driver=null;
	
	@BeforeTest
	public void setUp() {
		driver=DriverFactory.getDriver("chrome");
	}
	
  @Test
  public void openURL() {
		String url="http://www.demo.guru99.com/V4/index.php";
		driver.get(url);
		Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
  }
  @Test(dependsOnMethods = "openURL")
  public void canTestUnSuccessfulLogin() {
		driver.findElement(By.name("uid")).sendKeys("abc");
		driver.findElement(By.name("password")).sendKeys("abd");
		driver.findElement(By.name("btnLogin")).click();
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(),"User or Password is not valid");
		alert.accept();
  } 
  @Test(dependsOnMethods = "canTestUnSuccessfulLogin")
  public void canTestSuccessfulLogin() {
	  	driver.findElement(By.name("uid")).sendKeys("mgr123");
		driver.findElement(By.name("password")).sendKeys("mgr!23");
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
  }
  @Test(dependsOnMethods = "canTestSuccessfulLogin")
  public void canTestNewCustomerLink() {
	  driver.findElement(By.linkText("New Customer")).click();
	  Assert.assertEquals("Guru99 Bank New Customer Entry Page", driver.getTitle());
  }
  
  @AfterTest
  public void closeBrowser() {
	  driver.quit();
  }
}

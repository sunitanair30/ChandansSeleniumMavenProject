package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.factory.DriverFactory;

public class GoogleTestCases {
	
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  	driver=DriverFactory.getDriver("ie");
  }
  
  @Test
  public void openGoogleURL() {
	  driver.get("http://www.google.co.in");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
  @Test(dependsOnMethods = "openGoogleURL")
  public void searchText() {
	  driver.findElement(By.name("q")).sendKeys("studyautomation.com");
	  //driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("studyautomation.com");
	  driver.findElement(By.name("btnK")).submit();
	  Assert.assertEquals(driver.getTitle(), "studyautomation.com - Google Search");
  }
  @Test(dependsOnMethods = "searchText")
  public void clickOnFirstLink() {
	  //driver.findElement(By.partialLinkText("Study Automation")).click();
	  driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a")).click();
	  Assert.assertEquals(driver.getTitle(), "Selenium Online Training | Sonarqube Training |Study Automation");
  }
  @Test
  public void test() {
	  Assert.assertTrue(true);
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

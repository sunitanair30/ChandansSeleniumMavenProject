package com.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver getDriver(String browser) {
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandan/Desktop\\browserDriver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Chandan/Desktop\\browserDriver\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandan/Desktop\\browserDriver\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandan/Desktop\\browserDriver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		}
		
		return driver;
	}
	
}

package com.guru99.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestRunner {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandan/Desktop\\browserDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url="http://www.demo.guru99.com/V4/index.php";
		driver.get(url);
		
		LoginPage login=new LoginPage(driver);
		login.txtUserId.sendKeys("mgr123");
		login.txtPassword.sendKeys("mgr!23");
		login.btnLogin.click();
		
		HomePage home=new HomePage(driver);
		home.newCustomerLink.click();
		
		NewCustomerPage customer=new NewCustomerPage(driver);
		customer.txtCustomerName.sendKeys("Chandan");
		System.out.println(driver.getTitle());
	}
	public void launchApp() {
		
	}

}

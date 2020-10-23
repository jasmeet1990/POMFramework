package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hubspot.pages.LoginPage;

public class BaseTest {

	
	public WebDriver driver;
	public BasePage basePage;
	public LoginPage loginPage;
	public Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.init_driver("chrome");
		loginPage = new LoginPage(driver);
		prop = basePage.init_prop();
	}
	
	
//	@AfterTest	
//	public void tearDown() {
//		driver.quit();
//	}
}

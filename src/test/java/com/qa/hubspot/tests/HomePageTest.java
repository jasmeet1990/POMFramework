package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;	
	HomePage homePage;
	LoginPage loginPage;
	Properties prop;
	
	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		driver = basePage.init_driver("chrome");
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		prop = basePage.init_prop();
		homePage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority =1)
	public void verifyLoggedInUserIdTest() {
		String LoggedInId = homePage.getLoggedInUserEmail();
		System.out.println("Logged In User Id is "+LoggedInId);
		Assert.assertEquals(LoggedInId, "jasmeetchadha1990@gmail.com","Logged In user Id is not matched");
	}

	@Test(priority =2)
	public void verifyLoggedInUserEmailTest() {
		String LoggedInEmail = homePage.getLoggedInUserEmail();
		System.out.println("Logged In User email is "+LoggedInEmail);
		Assert.assertEquals(LoggedInEmail, "jasmeetchadha1990@gmail.com","Logged In user email is not matched");
	}
	
//	@AfterTest	
//	public void tearDown() {
//		driver.quit();
//	}
}

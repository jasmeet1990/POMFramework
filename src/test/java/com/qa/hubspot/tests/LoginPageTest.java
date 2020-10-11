package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest {
 
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.init_driver("chrome");
		loginPage = new LoginPage(driver);
		prop = basePage.init_prop();
	}
	
	@Test(priority =2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("LoginPage title is "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"LoginPage title is not matched");
		
	}
	
	@Test(priority =1)
	public void verifysignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink(),"SignUp link is not displayed");
	}
	
	@Test(priority =3)
	public void verifydoLoginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterTest	
	public void tearDown() {
		driver.quit();
	}
}

package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;

public class HomePageTest extends BaseTest{

	HomePage homePage;
	
		@BeforeClass
	public void homeSetUp() {
		homePage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@Test(priority =1)
	public void verifyLoggedInUserIdTest() {
		String LoggedInId = homePage.getLoggedInUserEmail();
		System.out.println("Logged In User Id is "+LoggedInId);
		Assert.assertEquals(LoggedInId, "jasmeetchadha1990@gmail.com","Logged In user Id is not matched");
	}

//	@Test(priority =2)
//	public void verifyLoggedInUserEmailTest() {
//		String LoggedInEmail = homePage.getLoggedInUserEmail();
//		System.out.println("Logged In User email is "+LoggedInEmail);
//		Assert.assertEquals(LoggedInEmail, "jasmeetchadha1990@gmail.com","Logged In user email is not matched");
//	}
	
}

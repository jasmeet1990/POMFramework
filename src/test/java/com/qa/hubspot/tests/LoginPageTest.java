package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

//@Listeners(ExtentReportListener.class)

public class LoginPageTest extends BaseTest{
 
	
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
	
	
}

package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage{

private WebDriver driver;

	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton	= By.id("loginBtn");
	By SignUpLink = By.linkText("Sign up");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementUtil.WaitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 5);
	}
	public boolean verifySignUpLink() {
		//return driver.findElement(SignUpLink).isDisplayed();
		return elementUtil.doIsDisplayed(SignUpLink);
	}
	
	public HomePage doLogin(String username,String password) {

		
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);
		
		return new HomePage(driver);
	}
}

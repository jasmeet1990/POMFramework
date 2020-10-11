package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

	By homePageHeader = By.xpath("//*[@data-key='app.header.title']");
	By downarrow = By.xpath("(//*[@class='nav-icon arrow-down-icon'])[9]");
	By LoggedInEmail = By.xpath("//div[@class='user-info-email']");
	By LoggedInId = By.xpath("//*[@class='user-info-name']");

	public WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoggedInUserId() {
		driver.findElement(downarrow).click();
		return driver.findElement(LoggedInId).getText();
	}

	public String getLoggedInUserEmail() {
		driver.findElement(downarrow).click();
		return driver.findElement(LoggedInEmail).getText();

	}
}

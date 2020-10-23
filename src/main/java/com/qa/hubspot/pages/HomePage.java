package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	By homePageHeader = By.xpath("//*[@data-key='app.header.title']");
	By downarrow = By.xpath("(//*[@class='nav-icon arrow-down-icon'])[9]");
	By LoggedInEmail = By.xpath("//div[@class='user-info-email']");
	By LoggedInId = By.xpath("//*[@class='user-info-name']");
	
	By ContactsPrimary =By.id("nav-primary-contacts-branch");
	By ContactsSecondary = By.id("nav-secondary-contacts");

	public WebDriver driver;
	LoginPage loginPage;
	BasePage basePage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getLoggedInUserId() {
		elementUtil.WaitForElementPresent(LoggedInId, 5);
		elementUtil.doClick(downarrow);
		if(elementUtil.doIsDisplayed(LoggedInId)) 
		return elementUtil.doGetText(LoggedInId);
		else
			return null;
	}

	public String getLoggedInUserEmail() {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(downarrow).click();
		return driver.findElement(LoggedInEmail).getText();

	}
	
	//Click on Contacts from Home Page
	
	public ContactsPage GoToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		//elementUtil.WaitForElementTobeVisible(ContactsPrimary, 8);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClickActions(ContactsPrimary);
		elementUtil.doClick(ContactsSecondary);
	}
}

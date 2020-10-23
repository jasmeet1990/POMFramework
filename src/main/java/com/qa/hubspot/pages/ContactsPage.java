package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	private WebDriver driver;

	By CreateContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//textarea[@data-field='jobtitle']");
	By createContactSecondary = By.xpath("(//span[text()='Create contact'])[2]");
	By ContactsHeader = By.xpath("//span[@class='private-dropdown__item__label']");
	
	By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=1]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getContactsPageHeader() {
		return elementUtil.doGetText(ContactsHeader);
	}

	public String getContactsPageTitle() {
		return elementUtil.WaitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 5);

	}

	public void doCreateContact(String email, String firstname, String lastname, String jobtitle) {
		elementUtil.ClickWhenReady(CreateContactPrimary, 11);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstname);
		elementUtil.doSendKeys(this.lastName, lastname);
		elementUtil.WaitForElementTobeVisible(jobTitle, 5);
		elementUtil.doSendKeys(this.jobTitle, jobtitle);
		elementUtil.doClickActions(createContactSecondary);
		elementUtil.doClickActions(contactsBackLink);
		
		
	}
}

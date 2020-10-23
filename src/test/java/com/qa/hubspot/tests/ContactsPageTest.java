package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	ContactsPage contactsPage;
	HomePage homePage;
	
	
	@BeforeClass
	public void ContactsSetUp() {
		homePage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.GoToContactsPage();
	} 
	
	@Test(priority=1)
	public void verifyContactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeader();
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER,"Contacts Page Header is not matched");
	}
	
	@Test(priority=2)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE,"Contacts Page Title is not matched");
	}
	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data =ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}
	
	@Test(priority=3,dataProvider = "getContactsTestData")
	public void verifyCreateContactsTest(String email,String firstName,String lastName,String jobTitle) {
		contactsPage.doCreateContact(email,firstName,lastName,jobTitle);
	}
	
}

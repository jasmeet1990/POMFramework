package com.qa.hubspot.utils;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;
	JavaScriptUtils jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtils(this.driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			System.out.println("locator is" + locator);
			element = driver.findElement(locator);
			if(prop.getProperty("highlight").equalsIgnoreCase("yes")){
			jsUtil.flash(element);
			}
			System.out.println("WebElement is created successfully" + locator);
		} catch (Exception e) {
			System.out.println("Some exception got created with this locator" + locator);
		}
		return element;
	}
	
	public List<WebElement> doGetElements(By locator) {
		List<WebElement> options = driver.findElements(locator);
		return options;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
		public String doGetText(By locator) {
			return getElement(locator).getText();
			
		}

	

	// ******************************DropDownUtils***************************//

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public ArrayList<String> doGetDropDownOptions(By locator) {
		ArrayList<String> ar = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();
		for (int i = 0; i < OptionsList.size(); i++) {
			String text = OptionsList.get(i).getText();
			ar.add(text);
			// System.out.println(text);
		}
		return ar;
	}

	public int doDropDownOptionsSize(By locator) {
		return doGetDropDownOptions(locator).size();
	}

	public void doSelectDropDownValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();
		for (int i = 0; i < OptionsList.size(); i++) {
			String text = OptionsList.get(i).getText();
			System.out.println(text);
			if (text.equals(value)) {
				OptionsList.get(i).click();
				break;
			}
		}
	}
		
	public void doDropDownWithoutSelectClass(By locator,String value) {
		List<WebElement>optionsList = doGetElements(locator);
		for(int i=0;i<optionsList.size();i++) {
			String text = optionsList.get(i).getText();
			if(text.equals(value)) {
				optionsList.get(i).click();
				break;
			}
		}
	}
	
	
	//*****************************Actions Class Utils******************************//
		public void doDragAndDrop(By source,By target) {
			Actions action = new Actions(driver);
			WebElement sourceEle = getElement(source);
			WebElement targetEle = getElement(target);
			action.dragAndDrop(sourceEle, targetEle).build().perform();
			
		}
		
		public void doDragAndDropMove(By source,By target) {
			Actions action = new Actions(driver);
			WebElement sourceEle = getElement(source);
			WebElement targetEle = getElement(target);
			action.clickAndHold(sourceEle).moveToElement(targetEle).build().perform();
		}
		
		public  void doClickActions(By locator) {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		}
		
		public void doSendKeysActions(By locator,String value) {
			Actions action = new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		}
		
		//**************************Wait Utils*************************************//
		
		public List<WebElement> visibilityofAllElements(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		
		
		public WebElement WaitForElementPresent(By locator,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element;
		}
		
		
		public WebElement WaitForElementTobeVisible(By locator,int timeout) {
			WebElement element = getElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element;
		}
	
		public WebElement WaitForElementToBeClickable(By locator,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			return element;
		}
		
		
		public boolean WaitForUrl(String url,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.urlContains(url));
			
		}
		
		public Alert WaitForAlert(int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			return alert;
		}
		
		//ClickWhenReady
		
		public void ClickWhenReady(By locator,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
		
		public String WaitForTitleToBePresent(String title,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.titleContains(title));
			return driver.getTitle();
		}

		
}


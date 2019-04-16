package com.crm.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: md islam')]")
	WebElement userNamelable;

	@FindBy(linkText="//a[contains(text(),'Contacts')]")
	WebElement contactlink;
	@FindBy(linkText="//a[contains(text(),'New Deal')]")
	WebElement newdeallink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyNameTitle() {
		return userNamelable.isDisplayed();

	}
	public DealsPage clickdealslink() {
	dealslink.click();
	return new DealsPage();
	}
	public void newdealslink() {
		Actions action= new Actions(driver);
		action.moveToElement(dealslink).build().perform();
		newdeallink.click();
		
	}
	public ContactPage clickContactLink() {
	
		contactlink.click();
		// it return contact landing page we can say contact page
		return new ContactPage();
	}
	
	
	public void newcontactlink() {
		Actions action= new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		newcontactlink.click();
		
		
	}
	
}

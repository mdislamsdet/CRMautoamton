package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class ContactPage extends TestBase{
	
	
	@FindBy(id="first_name")
	WebElement ftname;
	@FindBy(id="surname")
	WebElement ltname;
	@FindBy(xpath="//input[@value='Save' and type='submit']")
	WebElement save;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlevel;
	public ContactPage() {
		PageFactory.initElements(driver, this);
		
	}
	public boolean verifycontactlevel() {
		return contactlevel.isDisplayed();
	}
	public void createnewcontact(String title,String fname, String lname) {
		Select s= new Select(driver.findElement(By.name("title")));
		s.deselectByVisibleText(title);
		ftname.sendKeys(fname);
		ltname.sendKeys(lname);
		save.click();
	}

}

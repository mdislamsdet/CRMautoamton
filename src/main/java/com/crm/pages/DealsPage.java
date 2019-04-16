package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class DealsPage extends TestBase{
	
	

	@FindBy(id="title")
	WebElement title;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@value='Save' and type='submit']")
	WebElement save;
	public DealsPage () {
		PageFactory.initElements(driver, this);
		
	}
	public void verifydeallink(String tit, String comp) {
		title.sendKeys(tit);
		company.sendKeys(comp);
		save.click();
		
	}

}

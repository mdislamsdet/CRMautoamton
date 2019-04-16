package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//page factory 
		@FindBy(name="username")
		WebElement userName;
		
		@FindBy(name="password")
		WebElement password;
		
		
		@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
		WebElement loginButton;

		@FindBy(xpath="//*[@id=\"intercom-container\"]/div/div/div[2]/svg")
		WebElement iconButton;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		
		}
		//action
		public String logopageTitle() {
			return driver.getTitle();
		}
		
		
		public HomePage login(String userid, String pass){
			
			
			userName.sendKeys(userid);
			password.sendKeys(pass);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loginButton.click();
			
			return new HomePage();
			
		}
		
		
		

}

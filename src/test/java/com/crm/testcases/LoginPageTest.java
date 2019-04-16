package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	HomePage homepage;

	LoginPage loginpage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		loginpage = new LoginPage();

	}

	

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.logopageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}


	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		homepage= loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}



}

package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utiles.TestUtiles;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtiles testutiles;
	ContactPage contactPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(){
		intialization();
		testutiles = new TestUtiles();
		//contactPage = new ContactPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyHomepageTitleTest() {
		String title = homepage.verifyHomePageTitle();

		Assert.assertEquals(title, "CRMPRO", "let me know if is not pass");
	}

	@Test(priority=2)
	public void verifyNameTest() {
		testutiles.swtchtoframe();
		Assert.assertTrue(homepage.verifyNameTitle());
	}

	@Test(priority=3)
	public void clickContactLinkTest() {
		testutiles.swtchtoframe();
		homepage.clickContactLink();

	}
	@Test(priority=4)
	public void clickdealslinkTest() {
		testutiles.swtchtoframe();
		homepage.clickdealslink();
	}

	@AfterMethod
	public void tearDowen() {
		driver.quit();
	}

}

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

public class ContactPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtiles testutiles;
	ContactPage contactPage;
	
	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	// for work contactpage we need to login first bcoz contact link is avableable
	// on homepage
	public void setUp(){
		intialization();
		testutiles = new TestUtiles();
		contactPage = new ContactPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
		testutiles.swtchtoframe();
		contactPage = homepage.clickContactLink();

	}
	
	@Test
	public void verifycontactLevelTest() {
		Assert.assertTrue(contactPage.verifycontactlevel(),"contact level is missing");
	}
	@Test
	public void veryfynewcontactlink() {
		homepage.newcontactlink();
		contactPage.createnewcontact("Mr.","md", "islam");
	}
	
	
	
	
	@AfterMethod 
	public void tearDown() {
		//driver.quit();
	}

}

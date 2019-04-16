package com.crm.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.base.TestBase;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utiles.TestUtiles;

public class DealPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtiles testutiles;
	// ContactPage contactPage;
	DealsPage dealspage;

	public DealPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		dealspage = new DealsPage();
		testutiles = new TestUtiles();
		// contactPage = new ContactPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("userid"), prop.getProperty("password"));
		testutiles.swtchtoframe();
		dealspage=homepage.clickdealslink();
	}

	@Test
	public void verifynewdeallink() {
		homepage.newdealslink();
		dealspage.verifydeallink("md", "google");
	}

	@AfterMethod
	public void tearDowen() {
		driver.quit();
	}

}

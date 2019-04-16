package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.utiles.TestUtiles;

public class TestBase {

	public static WebDriver driver;

	WebDriverEventListener elementlistner;

	public static Properties prop;
	public static FileInputStream fi = null;

	public TestBase() {

		prop = new Properties();

		try {
			fi = new FileInputStream(
					"C:/EclipseWork space/CRMautomation/src/main/java/com/crm/confiq/confiq.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.geckodriver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtiles.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtiles.page_implict_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}

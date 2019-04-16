package com.crm.extentreportListener;

public class CrmR {
	
	import com.crm.pages.HomePage;
	import com.crm.util.WebDriverHelper;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import org.openqa.selenium.OutputType;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.*;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class TestBase {

	    protected WebDriver driver;
	    protected HomePage homePage;

	    public ExtentReports extent;
	    public ExtentTest extentTest;

	    @BeforeSuite
	    public void beforeSuite(){
	        System.out.println("Suite test started");
	    }

	    @BeforeSuite
	    public void afterSuite(){
	        System.out.println("Suite test ended");
	    }

	    @BeforeTest
	    public void beforeEveryTest(){
	        System.out.println("Testing started");
	    }

	    @BeforeTest
	    public void afterEveryTest(){
	        System.out.println("Testing ended");
	    }


	    @BeforeClass
	    public void setExtent(){
	        //extent = new ExtentReports(System.getProperty("user.dir") + "/Test-Output/extentReport.html", true) ;
	        extent = new ExtentReports(System.getProperty("user.dir") + "/Extent Report/extentReport.html", true) ;
	        extent.addSystemInfo("Envionment"," QA");
	    }

	    @AfterClass
	    public void endReport(){
	        extent.flush();
	        extent.close();
	    }


	    public static String getSreenshot(WebDriver driver, String screenshotName) throws IOException {
	       String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);

	        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
	                + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        return destination;

	    }

	    @BeforeMethod
	    public void setUp() throws InterruptedException {
	        driver = WebDriverHelper.createDriver();
	        homePage = new HomePage(driver);
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {

	        if(result.getStatus()== ITestResult.FAILURE){
	            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in the extent report
	            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add erro/exception in the extent report
	            String screenshotPath  = TestBase.getSreenshot(driver, result.getName()); // call the screenshot mehtod by using class name and store in a variable
	            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));// to attache screenshot in the extend report
	        }
	        else if ( result.getStatus() == ITestResult.SKIP) {
	            extentTest.log(LogStatus.FAIL, "TEST CASE SKIPED IS " + result.getName());
	        }
	        else if(result.getStatus()==ITestResult.SUCCESS){
	            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

	        }
	        extent.endTest(extentTest); // ending the test and ends current test and prepare to create html report

	        WebDriverHelper.closeDriver(driver);
	    }
	
	

}

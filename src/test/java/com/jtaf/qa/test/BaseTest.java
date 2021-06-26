package com.jtaf.qa.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jtaf.qa.pages.BasePage;
import com.jtaf.qa.pages.Page;
import com.jtaf.qa.utilities.FileReaderUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



/**
 * 
 * @author Jaga
 *
 */
public class BaseTest extends FileReaderUtility {

	public static WebDriver driver;
	public static Page page;
	public static ExtentReports extent;
	public static ExtentTest test;

	Logger log = getLogger(BaseTest.class);

	String browser = null;

	@Before
	public void before() throws IOException {

		try {
			loadPropertyFile();
			log.info("======================== [ Property File Load Successful ] ========================");
			setUpTest(FileReaderUtility.getTestData("browser.chrome"));
		} catch (Exception ex) {
			log.info("Exception occured while invoke browser and captured : " + "\n" + ex);
			Assert.assertFalse(true);
		}
	}

	// @BeforeMethod
	// @Parameters(value = { "browser" })
	public WebDriver setUpTest(String browser) {
		if (System.getProperty("os.name").contains(getTestData("operating.system"))) {
			if (browser.equalsIgnoreCase(getTestData("browser.chrome"))) {
				System.setProperty("webdriver.chrome.driver", getTestData("chrome.driver"));
				log.info(
						"======================== [ Launching " + browser + " Browser] ==============================");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("browser.firefox")) {
				System.setProperty("webdriver.chrome.driver", getTestData("firefox.driver"));
				log.info(
						"======================== [ Launching " + browser + " Browser] ==============================");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				log.info("No Browser Is Defined In XML File");
			}
			driver.get(getTestData("app.url"));
			page = new BasePage(driver);
		} else {
			log.info("======================== [ The Operating System Is Not WINDOWS ] ==================");
			Assert.fail();
		}
		return driver;
	}

	@After
	public void after(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				try {
					log.info("FAILED ***** : " + scenario.getName());
					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/jpeg","");
				} catch (Exception ex) {
					log.info("Exception occured while capture screenshot : " + ex);
				}
			} else {
				try {
					log.info("PASSED ***** : " + scenario.getName());
					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.attach(screenshot, "image/jpeg","");
				} catch (Exception ex) {
					log.info("Exception occured while capture screenshot : " + ex);
				}
			}
//			if (driver == null) {
//				return;
//			}
			//driver.close();
			
		} catch (Exception ex) {
			log.info("Error occured while close of after invocation" + "\n" + ex);
		}
	}

	public void launchApplication() {
		try {
			driver.get(getTestData("app.url"));
			page = new BasePage(driver);
			log.info("The Goibibo site is launched succesfully");
		} catch (Exception ex) {
			log.info("Error occured while launch of application" + "\n" + ex);
		}
	}

	// @BeforeSuite
	// public void init() throws IOException {
	// loadPropertyFile();
	// log.info("======================== [ Property File Load Successful ]
	// ========================");
	// }

	// @AfterMethod
	// public void tearDown() {
	// driver.close();
	// }
	//
	// @AfterSuite
	// public void exit() {
	// driver.quit();
	// }

}

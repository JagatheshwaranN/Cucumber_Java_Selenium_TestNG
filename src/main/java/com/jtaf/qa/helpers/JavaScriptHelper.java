package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jtaf.qa.utilities.LoggerUtility;
import com.jtaf.qa.base.WebPage;
import com.jtaf.qa.pages.BasePage;

/**
 * 
 * @author Jaga
 *
 */
public class JavaScriptHelper extends BasePage implements WebPage {

	private static Logger log = LoggerUtility.getLog(JavaScriptHelper.class);

	JavascriptExecutor executor;

	public JavaScriptHelper(WebDriver driver) {
		super(driver);
	}

	@Override
	public void elementClick(WebElement element) {
		try {
			executor = (JavascriptExecutor) getDriver();
			executor.executeScript("arguments[0].click();", element);
			log.info("The element is clicked by javascript");
		} catch (Exception ex) {
			log.info("Error occured while click on element by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	@Override
	public void enterText(WebElement element, String text) {
		try {
			executor = (JavascriptExecutor) getDriver();
			executor.executeScript("arguments[0].value='" + text + "';", element);
			log.info("The text " + text + " is entered into an element by javascript");
		} catch (Exception ex) {
			log.info("Error occured while enter text into an element by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public Object executeScript(String script) {
		try {
			log.info("The script is : " + script);
		} catch (Exception ex) {
			log.info("Error occured while execute script by javascript" + "\n" + ex);
			Assert.fail();
		}
		executor = (JavascriptExecutor) getDriver();
		return executor.executeAsyncScript(script);

	}

	public Object executeScript(String script, Object... arguments) {
		try {
			log.info("The Script is : " + script);
		} catch (Exception ex) {
			log.info("Error occured while execute script by javascript" + "\n" + ex);
			Assert.fail();
		}
		executor = (JavascriptExecutor) getDriver();
		return executor.executeAsyncScript(script, arguments);
	}

	public void scrollToElement(WebElement element) {
		try {
			executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
					element.getLocation().y);
			log.info("The control is scrolled to an element by javascript");
		} catch (Exception ex) {
			log.info("Error occured while scroll to an element by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void scrollToElementAndClick(WebElement element) {
		try {
			scrollToElement(element);
			element.click();
			log.info("The control is scrolled to an element and clicked by javascript");
		} catch (Exception ex) {
			log.info("Error occured while scroll to an element and click by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			executeScript("arguments[0].scrollIntoView()", element);
			log.info("The control is scrolled into the view of an element by javascript");
		} catch (Exception ex) {
			log.info("Error occured while scroll into view of an element by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void scrollIntoViewAndClick(WebElement element) {
		try {
			scrollIntoView(element);
			element.click();
			log.info("The control is scrolled into the view of an element and clicked by javascript");
		} catch (Exception ex) {
			log.info("Error occured while scroll into view of an element and click by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void scrollUpVertical() {
		try {
			executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			log.info("The page is scrolled up vertically to the top by javscript");
		} catch (Exception ex) {
			log.info("Error occured while page scroll up vertically by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void scrollDownVertical() {
		try {
			executeScript("window.scrollTo(0, document.body.scrollHeight)");
			log.info("The page is scrolled down vertically to the bottom by javascript");
		} catch (Exception ex) {
			log.info("Error occured while page scroll down vertically by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void ScrolUpByPixel(String pixel) {
		try {
			executeScript("window.scrollBy(0, -'" + pixel + "')");
			log.info("The page is scrolled up by pixel by javascript");
		} catch (Exception ex) {
			log.info("Error occured while page scroll up by pixel by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void ScrolDownByPixel(String pixel) {
		try {
			executeScript("window.scrollBy(0, '" + pixel + "')");
			log.info("The page is scrolled down by pixel by javascript");
		} catch (Exception ex) {
			log.info("Error occured while page scroll down by pixel by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

	public void zoomInByPercentage(String percent) {
		try {
			executeScript("document.body.style.zoom='" + percent + "'");
			log.info("The page is Zoom in by percent on the page by javascript");
		} catch (Exception ex) {
			log.info("Error occured while page zoom in by percent by javascript" + "\n" + ex);
			Assert.fail();
		}
	}

}

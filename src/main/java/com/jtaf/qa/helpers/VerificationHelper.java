package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jtaf.qa.base.BaseTest;
import com.jtaf.qa.utilities.LoggerUtility;

/**
 * 
 * @author Jaga
 *
 */
public class VerificationHelper extends BaseTest {

	private static Logger log = LoggerUtility.getLog(VerificationHelper.class);

	public boolean verifyElementPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
			log.info("The element is present on the page");
		} catch (Exception ex) {
			log.info("Error occured while check for presence of an element" + "\n" + ex);
			Assert.fail();
		}
		return isDisplayed;
	}

	public boolean verifyTextEquals(WebElement element, String text) {
		boolean flag = false;
		try {
			String actualText = element.getText();
			if (actualText.equals(text)) {
				log.info("The element text and given text is equal");
				return flag = true;
			} else {
				return flag;
			}
		} catch (Exception ex) {
			log.info("Error occured while check an element text" + "\n" + ex);
			Assert.fail();
		}
		return flag;
	}

	public String readTextValueFromElement(WebElement element) {
		boolean displayed = false;
		String text = null;
		try {
			displayed = isDisplayed(element);
			if (!displayed)
				return null;
			text = element.getText();
			log.info("The element text is : " + text);
		} catch (Exception ex) {
			log.info("Error occured while read value of an element" + "\n" + ex);
			Assert.fail();
		}
		return text;
	}

	public String readValueFromInput(WebElement element) {
		String value = null;
		try {
			if (!isDisplayed(element))
				return null;
			value = element.getAttribute("value");
			log.info("The element text is : " + value);
		} catch (Exception ex) {
			log.info("Error occured while read text of an element" + "\n" + ex);
			Assert.fail();
		}
		return value;
	}

	public boolean isDisplayed(WebElement element) {
		boolean flag = false;
		try {
			element.isDisplayed();
			flag = true;
			log.info("The element is displayed on the page");
		} catch (Exception ex) {
			log.info("Error occured while check for display of an element" + "\n" + ex);
			Assert.fail();
		}
		return flag;
	}

}

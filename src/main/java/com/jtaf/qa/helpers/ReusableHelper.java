package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jtaf.qa.base.BaseTest;
import com.jtaf.qa.utilities.LoggerUtility;
import com.jtaf.qa.base.WebPage;

public class ReusableHelper extends BaseTest implements WebPage {

	private static Logger log = LoggerUtility.getLog(ReusableHelper.class);

	@Override
	public void elementClick(WebElement element) {
		try {
			if (element.isEnabled()) {
				element.click();
				log.info("The element is clicked");
			}
		} catch (Exception ex) {
			log.info("Error occured click on an element" + "\n" + ex);
			Assert.fail();
		}
	}

	@Override
	public void enterText(WebElement element, String text) {
		try {
			if (element.isEnabled()) {
				element.sendKeys(text);
				log.info("The text " + text + " is entered into an element");
			}
		} catch (Exception ex) {
			log.info("Error occured while enter text into an element" + "\n" + ex);
			Assert.fail();
		}
	}

}

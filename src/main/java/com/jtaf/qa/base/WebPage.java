package com.jtaf.qa.base;

import org.openqa.selenium.WebElement;

public interface WebPage {

	public void elementClick(WebElement element);

	public void enterText(WebElement element, String text);

}

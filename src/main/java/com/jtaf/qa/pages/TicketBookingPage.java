package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Jaga
 *
 */
public class TicketBookingPage extends BasePage {

	private By priceSort = By.xpath("//div[@class='SortOptionsstyles__SortOption-tji0t1-3 ivjAsX']");
	private By priceList = By.xpath("(//div[contains(@class,'srp-card-uistyles__Price-sc-3flq99-17')])[1]");
	private By bookButton = By.xpath(
			"(//div[contains(@class,'srp-card-uistyles__CardRight')]//button[contains(@class,'srp-card-uistyles__BookButton')])[1]");

	Logger log = getLogger(TicketBookingPage.class);

	public TicketBookingPage(WebDriver driver) {
		super(driver);
	}

	public String getTicketBookingPageTitle() {
		return getPageTitle();
	}

	public WebElement getPriceSort() {
		return getElement(priceSort);
	}

	public WebElement getPriceList() {
		return getElement(priceList);
	}

	public WebElement getBookButton() {
		return getElement(bookButton);
	}

	public TicketDetailsPage bookTicket() {
		try {
			log.info("Ticket booking execution start");
			// getPriceSort().click();
			// getPriceList()
			getBookButton().click();
			log.info("Ticket booking execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(TicketDetailsPage.class);
	}

}

package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Jaga
 *
 */
public class TicketDetailsPage extends BasePage {

	private By ticketDetailsHeader = By.xpath("//div[contains(@class,'flight-detailstyles__TicketDtlBox')]");
	private By ticketDetailsFlightName = By.xpath("//div[contains(@class,'common-elementsstyles__Wid13')]//span[1]");
	private By ticketDetailsTravelClass = By.xpath("//div[contains(@class,'common-elementsstyles__Wid13')]//span[2]");
	private By ticketDetailsFromPlace = By
			.xpath("(//div[contains(@class,'common-elementsstyles__Wid31')]//span[contains(@class,'padR5')])[1]");
	private By ticketDetailsToPlace = By
			.xpath("(//div[contains(@class,'common-elementsstyles__Wid31')]//span[contains(@class,'padR5')])[2]");

	Logger log = getLogger(TicketDetailsPage.class);

	public TicketDetailsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(ticketDetailsHeader);
	}

	public String getTicketDetailsPageTitle() {
		return getPageTitle();
	}

	public String getTicketDetailsHeader() {
		return getPageHeader(ticketDetailsHeader);
	}

	public WebElement getTicketDetailsFlightName() {
		return getElement(ticketDetailsFlightName);
	}

	public WebElement getTicketDetailsTravelClass() {
		return getElement(ticketDetailsTravelClass);
	}

	public WebElement getTicketDetailsFromPlace() {
		return getElement(ticketDetailsFromPlace);
	}

	public WebElement getTicketDetailsToPlace() {
		return getElement(ticketDetailsToPlace);
	}

	public void verifyTicketDetails() {
		try {
			log.info("Verify ticket details execution start");
			getTicketDetailsFlightName().isDisplayed();
			getTicketDetailsTravelClass().isDisplayed();
			getTicketDetailsFromPlace().isDisplayed();
			getTicketDetailsToPlace().isDisplayed();
			log.info("Verify ticket details execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

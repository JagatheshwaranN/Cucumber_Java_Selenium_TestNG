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
public class HomePage extends BasePage {

	private By homePageHeader = By.xpath("//h1[text()='Domestic and International Flights']");
	private By oneWayTrip = By
			.xpath("//div[contains(@class,'fltSwitchOpt')]//span[@id='oneway' and @class='curPointFlt switchAct']");
	private By fromLocation = By.xpath("//input[@id='gosuggest_inputSrc']");
	private By fromLocationSuggestion = By.xpath(
			"//ul[@id='react-autosuggest-1']//li//div[@class='mainTxt clearfix']//span[text()='Chennai, India']");
	private By toLocation = By.xpath("//input[@id='gosuggest_inputDest']");
	private By toLocationSuggestion = By.xpath(
			"//ul[@id='react-autosuggest-1']//li//div[@class='mainTxt clearfix']//span[text()='Bengaluru, India']");
	private By depatureDate = By.xpath("//input[@id='departureCalendar']");
	private By travelSelection = By.xpath("//div[@id='pax_link_common']");
	private By travelSelectionPassenger = By.xpath("//button[@id='adultPaxPlus']");
	private By travelSelectionClass = By.xpath("//select[@class='custSelect width100 whiteBg padTB5']");
	private By searchButton = By.xpath("//button[contains(@class,'orange') and @value='Search']");

	Logger log = getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(homePageHeader);
	}

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageHeader(homePageHeader);
	}

	public WebElement getOneWayTrip() {
		return getElement(oneWayTrip);
	}

	public WebElement getFromLocation() {
		return getElement(fromLocation);
	}

	public WebElement getFromLocationSuggestion() {
		return getElement(fromLocationSuggestion);
	}

	public WebElement getToLocation() {
		return getElement(toLocation);
	}

	public WebElement getToLocationSuggestion() {
		return getElement(toLocationSuggestion);
	}

	public WebElement getDepatureDate() {
		return getElement(depatureDate);
	}

	public WebElement getTravelSelection() {
		return getElement(travelSelection);
	}

	public WebElement getTravelSelectionPassenger() {
		return getElement(travelSelectionPassenger);
	}

	public WebElement getTravelSelectionClass() {
		return getElement(travelSelectionClass);
	}

	public WebElement getSearchButton() {
		return getElement(searchButton);
	}

	public TicketBookingPage enterTravelDetails(String fromLocation, String toLocation, String travelClass) {
		try {
			log.info("Home page execution start");
			getFromLocation().sendKeys(fromLocation);
			getFromLocationSuggestion().click();
			getToLocation().sendKeys(toLocation);
			getToLocationSuggestion().click();
			getDepatureDate().sendKeys("Sun, 20 Jun");
			getTravelSelection().click();
			getTravelSelectionPassenger().click();
			dropDownHelper.selectByValue(getTravelSelectionClass(), travelClass);
			getSearchButton().click();			
			log.info("Home page execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(TicketBookingPage.class);
	}
}

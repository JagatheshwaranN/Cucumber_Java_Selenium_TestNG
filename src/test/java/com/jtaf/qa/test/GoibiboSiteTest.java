package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.Page;
import com.jtaf.qa.pages.TicketBookingPage;
import com.jtaf.qa.pages.TicketDetailsPage;
import com.jtaf.qa.utilities.FileReaderUtility;

public class GoibiboSiteTest {

	// Logger log = getLogger(GoibiboSiteTest.class);

	public void verifyHomePageTitle() {
		String title = BaseTest.page.getInstance(HomePage.class).getHomePageTitle();
		Assert.assertEquals(title, FileReaderUtility.getTestData("home.page.title"));
	}

	public void verifyEnterBookingDetails(String form, String to, String month, String day, String travelClass) {
		TicketBookingPage ticketBookingPage = BaseTest.page.getInstance(HomePage.class).enterTravelDetails(
				FileReaderUtility.getTestData(form), FileReaderUtility.getTestData(to),
				FileReaderUtility.getTestData(month), FileReaderUtility.getTestData(day),
				FileReaderUtility.getTestData(travelClass));
		String ticketBookingPageTitle = ticketBookingPage.getTicketBookingPageTitle();
		Assert.assertEquals(ticketBookingPageTitle, FileReaderUtility.getTestData("ticket.booking.page.title"));
	}

	public void verifyTicketBookingTitle() {
		String title = BaseTest.page.getInstance(TicketBookingPage.class).getTicketBookingPageTitle();
		Assert.assertEquals(title, FileReaderUtility.getTestData("ticket.booking.page.title"));
	}

	public void verifyBookTicket() {
		TicketDetailsPage ticketDetailsPage = BaseTest.page.getInstance(TicketBookingPage.class).bookTicket();
		String ticketDetailsPageHeader = ticketDetailsPage.getTicketDetailsHeader();
		Assert.assertEquals(ticketDetailsPageHeader, FileReaderUtility.getTestData("ticket.details.page.header"));
	}

	public void verifyTicketDetailsHeader() {
		String ticketDetailsPageHeader = BaseTest.page.getInstance(TicketDetailsPage.class).getTicketDetailsHeader();
		Assert.assertEquals(ticketDetailsPageHeader, FileReaderUtility.getTestData("ticket.details.page.header"));
	}

	public void verifyTicketDetails() {
		BaseTest.page.getInstance(TicketDetailsPage.class).verifyTicketDetails();
	}

}

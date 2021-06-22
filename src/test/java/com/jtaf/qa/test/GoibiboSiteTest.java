package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.TicketBookingPage;
import com.jtaf.qa.pages.TicketDetailsPage;

public class GoibiboSiteTest extends BaseTest {

	Logger log = getLogger(GoibiboSiteTest.class);

	public void verifyHomePageTitle() {
		String title = page.getInstance(HomePage.class).getHomePageTitle();
		Assert.assertEquals(title, getTestData("home.page.title"));
	}

	public void verifyEnterBookingDetails(String form, String to, String month, String day, String travelClass) {
		TicketBookingPage ticketBookingPage = page.getInstance(HomePage.class).enterTravelDetails(getTestData(form),
				getTestData(to), getTestData(month), getTestData(day), getTestData(travelClass));
		String ticketBookingPageTitle = ticketBookingPage.getTicketBookingPageTitle();
		Assert.assertEquals(ticketBookingPageTitle, getTestData("ticket.booking.page.title"));
	}

	public void verifyTicketBookingTitle() {
		String title = page.getInstance(TicketBookingPage.class).getTicketBookingPageTitle();
		Assert.assertEquals(title, getTestData("ticket.booking.page.title"));
	}

	public void verifyBookTicket() {
		TicketDetailsPage ticketDetailsPage = page.getInstance(TicketBookingPage.class).bookTicket();
		String ticketDetailsPageHeader = ticketDetailsPage.getTicketDetailsHeader();
		Assert.assertEquals(ticketDetailsPageHeader, getTestData("ticket.details.page.header"));
	}
	
	public void verifyTicketDetailsHeader() {
		String ticketDetailsPageHeader = page.getInstance(TicketDetailsPage.class).getTicketDetailsHeader();
		Assert.assertEquals(ticketDetailsPageHeader, getTestData("ticket.details.page.header"));
	}

	public void verifyTicketDetails() {
		page.getInstance(TicketDetailsPage.class).verifyTicketDetails();
	}
	
}

package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.TicketBookingPage;
import com.jtaf.qa.pages.TicketDetailsPage;

/**
 * 
 * @author Jaga
 *
 */
public class TicketBookingPageTest extends BaseTest {

	Logger log = getLogger(TicketBookingPageTest.class);

	@Test(priority = 2)
	public void verifyTicketBookingPageTest() {
		try {
			log.info("Customer search page test execution start");
//			String title = page.getInstance(TicketBookingPage.class).getTicketBookingPageTitle();
//			Assert.assertEquals(title, getTestData("ticket.booking.page.title"));
			
			// Temp check code
			TicketBookingPage ticketBookingPage = page.getInstance(HomePage.class).enterTravelDetails(
					getTestData("from.location"), getTestData("to.location"), getTestData("travel.class"),
					getTestData("travel.month"), getTestData("travel.day"));
			String ticketBookingPageTitle = ticketBookingPage.getTicketBookingPageTitle();
			Assert.assertEquals(ticketBookingPageTitle, getTestData("ticket.booking.page.title"));
			Thread.sleep(10000);
			TicketDetailsPage ticketDetailsPage = page.getInstance(TicketBookingPage.class).bookTicket();
			Thread.sleep(10000);
			
			String ticketDetailsPageHeader = ticketDetailsPage.getTicketDetailsHeader();
			Assert.assertEquals(ticketDetailsPageHeader, getTestData("ticket.details.page.header"));
			
			log.info("Customer search page test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

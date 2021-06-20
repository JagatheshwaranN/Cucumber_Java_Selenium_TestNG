package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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
			String title = page.getInstance(TicketBookingPage.class).getTicketBookingPageTitle();
			Assert.assertEquals(title, getTestData("ticket.booking.page.title"));
			TicketDetailsPage ticketDetailsPage = page.getInstance(TicketBookingPage.class).bookTicket();
			String ticketDetailsPageHeader = ticketDetailsPage.getTicketDetailsHeader();
			Assert.assertEquals(ticketDetailsPageHeader, getTestData("ticket.details.page.header"));
			log.info("Customer search page test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

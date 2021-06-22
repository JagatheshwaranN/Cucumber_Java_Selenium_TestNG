package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.TicketBookingPage;

/**
 * 
 * @author Jaga
 *
 */
public class HomePageTest extends BaseTest {

	Logger log = getLogger(HomePageTest.class);

	@Test(priority = 1)
	public void verifyHomePageTest() {
		try {
			log.info("Home page test execution start");
			String title = page.getInstance(HomePage.class).getHomePageTitle();
			Assert.assertEquals(title, getTestData("home.page.title"));
			String header = page.getInstance(HomePage.class).getHomePageHeader();
			Assert.assertEquals(header, getTestData("home.page.header"));
			TicketBookingPage ticketBookingPage = page.getInstance(HomePage.class).enterTravelDetails(
					getTestData("from.location"), getTestData("to.location"), getTestData("travel.class"),
					getTestData("travel.month"), getTestData("travel.day"));
			String ticketBookingPageTitle = ticketBookingPage.getTicketBookingPageTitle();
			Assert.assertEquals(ticketBookingPageTitle, getTestData("ticket.booking.page.title"));
			log.info("Home page test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

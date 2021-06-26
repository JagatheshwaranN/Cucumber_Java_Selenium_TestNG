package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.TicketBookingPage;
import com.jtaf.qa.pages.TicketDetailsPage;
import com.jtaf.qa.utilities.ExcelReaderUtility;

/**
 * 
 * @author Jaga
 *
 */
public class TicketDetailsPageTest {

//	Logger log = getLogger(TicketDetailsPage.class);
//	ExcelReaderUtility excelReader = new ExcelReaderUtility();
//
//	@Test(priority = 3)
//	public void verifyTicketDetailsTest() {
//		try {
//			log.info("Login to application test execution start");
//
//			// Temp check code
//			TicketBookingPage ticketBookingPage = page.getInstance(HomePage.class).enterTravelDetails(
//					getTestData("from.location"), getTestData("to.location"), getTestData("travel.class"),
//					getTestData("travel.month"), getTestData("travel.day"));
//			String ticketBookingPageTitle = ticketBookingPage.getTicketBookingPageTitle();
//			Assert.assertEquals(ticketBookingPageTitle, getTestData("ticket.booking.page.title"));
//			Thread.sleep(10000);
//			TicketDetailsPage ticketDetailsPage = page.getInstance(TicketBookingPage.class).bookTicket();
//			Thread.sleep(10000);
//
//			ticketDetailsPage = new TicketDetailsPage(driver);
//			String ticketDetailsPageHeader = ticketDetailsPage.getTicketDetailsHeader();
//			Assert.assertEquals(ticketDetailsPageHeader, getTestData("ticket.details.page.header"));
//			ticketDetailsPage.verifyTicketDetails();
//			log.info("Login to application test execution end");
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

}

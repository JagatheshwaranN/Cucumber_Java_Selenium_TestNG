package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.TicketDetailsPage;
import com.jtaf.qa.utilities.ExcelReaderUtility;

/**
 * 
 * @author Jaga
 *
 */
public class TicketDetailsPageTest extends BaseTest {

	Logger log = getLogger(TicketDetailsPage.class);
	ExcelReaderUtility excelReader = new ExcelReaderUtility();

	@Test(priority = 3)
	public void verifyTicketDetailsTest() {
		try {
			log.info("Login to application test execution start");
			TicketDetailsPage ticketDetailsPage = new TicketDetailsPage(driver);
			String ticketDetailsPageHeader = ticketDetailsPage.getTicketDetailsHeader();
			Assert.assertEquals(ticketDetailsPageHeader, getTestData("ticket.details.page.header"));
			ticketDetailsPage.verifyTicketDetails();
			log.info("Login to application test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

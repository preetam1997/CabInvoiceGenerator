package cabinvoicegenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
	InvoiceService invoiceService = null;

	@Before
	public void initialize() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceandTnme_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId,rides);
		InvoiceSummary summary =  invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
		assertEquals(expectedInvoiceSummary, summary);
	}

	
}

package cabinvoicegenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {

	@Before
	public void initialize() {
		System.out.println("Welcome to cab invoice generator test");
	}

	@Test
	public void givenDistanceandTnme_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(25, fare, 0.0);
	}
	
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
}

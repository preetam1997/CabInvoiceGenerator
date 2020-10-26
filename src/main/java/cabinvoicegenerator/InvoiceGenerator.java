package cabinvoicegenerator;

public class InvoiceGenerator {

	private static final double MINIMUN_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUN_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		else
			return totalFare;
	}

	public double calculateFare(Ride[] rides) {
		double totalfare = 0;
		for (Ride ride : rides) {
			totalfare += this.calculateFare(ride.distance, ride.time);
		}
		return totalfare;
	}

}

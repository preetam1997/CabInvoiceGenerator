package cabinvoicegenerator;

public class InvoiceService {

	private static final double MINIMUN_COST_PER_KILOMETER = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;

	private static final double PREMIUM_MINIMUN_COST_PER_KILOMETER = 15;
	private static final int PREMIUM_COST_PER_TIME = 2;
	private static final double PREMIUM_MINIMUM_FARE = 20;

	private RideRepository rideRpository = null;

	public InvoiceService() {
		this.rideRpository = new RideRepository();
	}

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUN_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		else
			return totalFare;
	}

	public double calculatePremiumFare(double distance, int time) {
		double totalFare = distance * PREMIUM_MINIMUN_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
		if (totalFare < PREMIUM_MINIMUM_FARE)
			return PREMIUM_MINIMUM_FARE;
		else
			return totalFare;
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {

			totalFare += this.calculateFare(ride.distance, ride.time);
		}

		return new InvoiceSummary(rides.length, totalFare);
	}

	public InvoiceSummary calculateGenericFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			if (ride.type.equals("Normal")) {
				totalFare += this.calculateFare(ride.distance, ride.time);
			} else if (ride.type.equals("Premium")) {
				totalFare += this.calculatePremiumFare(ride.distance, ride.time);
			}
		}

		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRpository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRpository.getRides(userId));
	}

	public InvoiceSummary getGenericInvoiceSummary(String userId) {
		return this.calculateGenericFare(rideRpository.getRides(userId));
	}

}

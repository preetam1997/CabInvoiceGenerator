package cabinvoicegenerator;

public class Ride {

	public double distance;
	public String type;
	int time;

	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	public Ride(String type, double distance, int time) {
		this.type = type;
		this.distance = distance;
		this.time = time;
	}
}

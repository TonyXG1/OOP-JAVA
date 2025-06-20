
public class Dishwasher extends Appliance{
	public Dishwasher(double wei, double bre, double wid, double hei) {
		super("Dishwasher", wei, bre, wid, hei);
	}
	
	public String action() {
		return "washes dishes";
	}
}

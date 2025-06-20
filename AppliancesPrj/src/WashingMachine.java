
public class WashingMachine extends Appliance{
	public WashingMachine(double wei, double bre, double wid, double hei) {
		super("Washingmachine", wei, bre, wid, hei);
	}
	
	public String action() {
		return "does laundry";
	}
	
}

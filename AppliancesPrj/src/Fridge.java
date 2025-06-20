
public class Fridge extends Appliance {
	public Fridge(double wei, double bre, double wid, double hei) {
		super("Refridgerator", wei, bre, wid, hei);
	}
	
	public String action() {
		return "keeps food cool";
	}
}



public abstract class Appliance {
	private String name;
	private double weight;
	private double breadth;
	private double width;
	private double height;
	
	public Appliance (String name, double wei, double bre, 
		double wid, double hei) {
		this.name = name;
		weight = wei;
		breadth = bre;
		width = wid;
		height = hei;
	}

	public final String getName() {
		return name;
	}
	public final double getWeight() {
		return weight;
	}
	public final double getBreadth() {
		return breadth;
	}
	public final double getWidth() {
		return width;
	}
	public final double getHeight() {
		return height;
	}

	public double getVolume() {
		return width*height*breadth;
	}
	
	public abstract String action();
	
	@Override
	public String toString() {
		return String.format("{Name: %s, weighs %.2f kg, has volume of %.2f m^3, %s}", name, weight, getVolume(), action());
	}
	
}

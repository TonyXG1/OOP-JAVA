package planetsProject;

public class Planet {
	private String name;
	private int number;
	private int sat;
	private double size;
	
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public int getSat() {
		return sat;
	}
	public double getSize() {
		return size;
	}
	
	public int compareTo1(Planet p) { // this.compareTo1(p) 
		//Method 1
//		if(this.size < p.size) return -1;
//		if(this.size > p.size) return 1;
//		if(this.name.length() < p.name.length()) return -1;
//		if(this.name.length() > p.name.length()) return 1;
//		if(this.number < p.number) return -1;
//		if(this.number > p.number) return 1;
//		return 0;
	
		
		//Method 2 - ne bachka pravilno
		if(this.size < p.size) return -1;
		if(this.size > p.size) return 1;
		if(this.name.length()-p.name.length()!=0) return -this.name.length()-p.name.length();
		return this.number-p.number;
	}
	
	// this.compare(p) this < p -1; this > p 1;
	public int compareTo2(Planet p) {
		return this.sat - p.sat;
	}
	
	
	
	public Planet(String name, int number, int sat, double size) {
		this.name = name;
		this.number = number;
		this.sat = sat;
		this.size = size;
	}
	
	

}

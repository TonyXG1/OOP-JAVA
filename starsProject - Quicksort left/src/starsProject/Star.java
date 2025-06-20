package starsProject;

import java.util.Scanner;

public class Star {
	private static Scanner inp = new Scanner(System.in);
	
	private String name;
	private double distance;
	private byte classification;
	private double mass;
	private String constellation;
	
	public String getName() {
		return name;
	}
	public double getDistance() {
		return distance;
	}
	public static String getClassification(byte classification) {
		switch (classification) {
		case 1: {
			return "hypergiant";
		}
		case 2: {
			return "supergiant";
		}
		case 3: {
			return "bright giant";
		}
		case 4: {
			return "giant";
		}
		case 5: {
			return "subgiant";
		}
		case 6: {
			return "dwarf";
		}
		case 7: {
			return "subdwarf";
		}
		case 8: {
			return "red dwarf";
		}
		case 9: {
			return "brown dwarf";
		}
		
		default:
			return "";
		}
	}
	
	public String getClassification() {
		return getClassification(classification);
	}
	
	public double getMass() {
		return mass;
	}
	public String getConstellation() {
		return constellation;
	}
	
	public void input() {
		System.out.print("Name: ");
		name = inp.next();
		System.out.print("Distance from it's star: ");
		String distanceinput = inp.next();
		if(distanceinput.contains(".")) { distanceinput.replace('.', ','); distance = Double.parseDouble(distanceinput);}
		else distance = Double.parseDouble(distanceinput);
		do {
			System.out.println("Classification of the star: (1=hypergiant, \n"
					+ "2=supergiant, 3=bright giant, 4=giant, 5=subgiant, 6=dwarf, \n"
					+ "7=subdwarf, 8=red dwarf, 9=brown dwarf)");
			classification = inp.nextByte();
		} while (classification < 1 || classification > 9);
		
		System.out.print("Mass: ");
		mass = inp.nextDouble();
		System.out.print("Name of star's constellation: ");
		constellation = inp.next();
	}
	
	public int cmp1(Star s) {
		if(this.distance < s.distance) return -1;
		if(this.distance > s.distance) return 1;
		return 0;
	}
	
	public int cmp2 (Star s) {
		int temp = this.constellation.compareTo(s.constellation);
		if(temp!=0) return temp;
		
		if(this.mass < s.mass) return 1;
		if(this.mass > s.mass) return -1;
		
		return 0;
	}
	
	public Star(String name, double distance, byte classification, double mass, String constellation) {
		this.name = name;
		this.distance = distance;
		this.classification = classification; 
		this.mass = mass;
		this.constellation = constellation;
	}
	
	public Star() {
		this("", 0, (byte)0, 0, "");
	}
	
	@Override
	public String toString() {
		return String.format("%s, %.2f light years, %s, %.2f star masses, %s", 
				name, distance, getClassification(), mass, constellation);
	}

}

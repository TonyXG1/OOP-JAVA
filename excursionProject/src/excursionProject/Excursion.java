package excursionProject;

public class Excursion {
	private String destination;
	private int date;
	private int duration;
	private double price;
	
	private static boolean isCorrect(int date) {
		//dd.mm.yyyy 01012020
		int d, m, y;
		d = date / 1000000;
		m = (date % 1000000) / 10000;
		y = date % 10000;
		if(d<=0 || d > 31) return false;
		if(m<=0 || m > 12) return false;
		if(y<0) return false;
		
		if(m==2||m==4||m==6||m==9||m==11 && d==31) return false;
		if(m==2 && d==30) return false;
		if(m==2 && d==29 && !leapYear(y)) return false;
			
		return true;
		
	}
	
	private static boolean leapYear(int y) {
		if(y%400 == 0) return true;
		if(y%100 == 0) return false;
		return y%4 == 0;
	}

	private boolean isCorrect() {
		if(destination.length() == 0 || destination.isBlank()) return false;
		if (price < 0) return false;
		if (duration <= 0) return false;
		if (!isCorrect(date)) return false;
		
		return true;
	}

	public Excursion(String destination) {
		this.destination = destination;
		date = duration = 0;
		price = -1;
	}
	
	public Excursion(String destination, int date, int duration, double price) {
		this.destination = destination;
		this.date = date;
		this.duration = duration;
		this.price = price;
	}

	private String formDate(int date) {
		int d, m, y;
		if(!isCorrect(date)) return "Incorrect!";
		d = date / 1000000;
		m = (date % 1000000) / 10000;
		y = date % 10000;
		
		return String.format("%02d.%02d.%d", d,m,y);
	}
	
	
	@Override
	public String toString() {
		if(!isCorrect()) {
			return "Incorrect data";
		}
		
		return String.format("Excursion [%s, %s, %d days, %.2f]", destination, formDate(date), duration, price);
	}
	
	
	
}

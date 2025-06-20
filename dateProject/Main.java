package dateProject;

public class Main {

	public static void main(String[] args) {
		Date d1 = new Date(31,12,2019);
		System.out.println(d1);
		Date d2 = new Date(31,12,2020);
		//System.out.println(d1.compareTo(d2));
		
		System.out.println(d1.nextDate());
		System.out.println(d1.daysBetween(d2));
		
//		System.out.println(d.setMonth(10));
//		System.out.println(d.isLeapYear());
		
	}

}

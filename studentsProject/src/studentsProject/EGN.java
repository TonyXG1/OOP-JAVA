package studentsProject;

import java.util.Iterator;

public class EGN { // 0650157620
	private long data;
	
	public boolean isCorrect() {
		//Purvite 6 cifri - sushtinska data
		
		if(data >= 10000000000L) return false;
		byte [] digits = new byte[10];
		long d = data;
		for(int i=9 ;i >= 0; i--) {
			digits[i] = (byte) (d%10);
			d /= 10;
		}
		int year = digits[1] + digits[0]*10;
		int month = digits[3] + digits[2]*10;
		int day = digits[5] + digits[4]*10;
		
		if(month > 40) {
			month -=40;
			year +=2000;
		}
		else year+=1900;
		
		if(day>31 || day<=0) return false;
		if(month > 12 || month <= 0) return false;
		if((month==2||month==4||month == 6||
			month==9||month==11) && day==31) return false;
		if(month==2 && day==30) return false;
		if(month==2 && day==29 && year%4!=0 && year!=1900) return false;
		
		int sum = 0;
		for(int i = 8; i>=0;i--) {
			sum = 2*sum+digits[i];
		}
		sum*=2;
		sum = (sum%11)%10;
		return sum == digits[9];
	}
	
	public char getSex() {
		if(!isCorrect()) return '?';
		int s = (int) ((data/10)%2);
		if(s==0) return 'm';
		else return 'f';
	}
	
	public String birthDate() {
		if(!isCorrect()) return "Incorrect";
		int year = (int)(data / 100000000);
		int month = (int)(data / 1000000) %100;
		int day = (int)(data / 10000) %100;
		
		if(month > 40) {
			month -=40;
			year +=2000;
		}
		else year+=1900;
		
		return String.format("%02d.%02d.%d",day, month, year);
	}
	
	public EGN (String s) {
		try {
			data = Long.parseLong(s);
		} catch (Exception e) {
			System.out.println("Incorrect data");
		}
	}
	
	@Override
	public String toString() {
		return String.format("≈√Õ: %010d", data);
	}
	
	public EGN (long d) {
		data = d;
	}
}

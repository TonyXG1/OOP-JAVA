package dateProject;

public class Date {
	private byte day;
	private byte month;
	private short year;
	
	
	public Date() {
		day = -1;
		month = -1;
		year = -1;
	}
	
	public Date(int d, int m, int y) {
		day = (byte)d;
		month = (byte)m;
		year = (short)y;
	}
	
	public byte getDay() {
		if(!isCorrect()) return -1;
		return day;
	}

	public byte getMonth() {
		if(!isCorrect()) return -1;
		return month;
	}

	public short getYear() {
		if(!isCorrect()) return -1;
		return year;
	}
	
	public boolean setDay(int d) {
		Date newDate = new Date(d, this.month, this.year);
		if(!newDate.isCorrect()) return false;
		this.day = (byte)d;
		return true;
	}
	
	public boolean setMonth(int m) {
		Date newDate = new Date(this.day, m, this.year);
		if(!newDate.isCorrect()) return false;
		this.month = (byte)m;
		return true;
	}
	
	public boolean setYear(int y) {
		Date newDate = new Date(this.day, this.month, y);
		if(!newDate.isCorrect()) return false;
		this.year = (short)y;
		return true;
	}

	public boolean isCorrect() {
		if(day<1 || day>31) return false;
		if(month < 1 || month>12) return false;
		//if(year<0) return false;
		
		if((month==2||month==4||month==6||month==9||month==11) && day == 31) return false;
		if(month==2 && day == 30) return false;
		if(month==2 && day==29 && !leapYear(year)) return false;
		
		return true;	
	}
	
	private boolean leapYear(int y) {
		y = (int)this.year;
		if(y%400 == 0) return true;
		if(y%100 == 0) return false;
		return y%4==0;
	}
	
	public boolean isLeapYear() {
		return leapYear((int)(this.year));
	}
	
	//TODO Kude da slaga nekorektni dati
	public int /*year.*/compareTo(Date d) {
		
		if(this.year - d.year < 0) return -1;
		if(this.year - d.year > 0) return 1;
		
		if(this.month - d.month < 0) return -1;
		if(this.month - d.month > 0) return 1;
		
		if(this.day - d.day < 0) return -1;
		if(this.day - d.day > 0) return 1;
		
		//if(!isCorrect() || !d.isCorrect()) return 2;
		
		return 0;
	}
	
	public Date nextDate() {
		int februaryDays = isLeapYear() ? 29 : 28;

		if(day < 30 && month!=2) {return new Date(++day,month,year);}
		if(((month==1||month==3||month==5||month==7||month==8||month==10||month==12) && day == 30)) {return new Date(++day,month,year);}
		if(day == februaryDays - 1)	{return new Date(++day,month,year);}
		
		if(month!=12) {return new Date(1,++month,year);}
		return new Date (1,1,++year);
		
	}
	
	private int daysInaMonth(int m, int y) {
		if((m==1||m==3||m==5||m==7||m==8||m==10||m==12)) return 31;
		if(m!=2) return 30;
		if(leapYear(y)) return 29;
		return 28;
	}
	
	public int daysBetween(Date d) {
		Date first = this;
		Date second = d;
		
		if(first.year > second.year) {
			Date temp = first;
			first = second;
			second = temp;
		}
		//23.2.2005 - first
		//07.10.2006 - second
		
		int remainderDays = (daysInaMonth(first.month, first.year) - first.day) + second.day;
		
		for(int i = first.month; i <= 12; i++) {
			remainderDays += daysInaMonth(i, first.year);
		}
		for(int i = second.month; i >= 1; i--) {
			remainderDays += daysInaMonth(i, second.year);
		}
		
		for(int i = first.year; i < second.year; i++) {
			if(leapYear(i)) remainderDays+=366;
			else remainderDays += 365;
		}
		
		return remainderDays;
	}
	
	
	@Override
	public String toString() {
		if(!isCorrect()) return "Incorrect";
		return String.format("%02d.%02d.%d", day, month, year);
	}
	
}

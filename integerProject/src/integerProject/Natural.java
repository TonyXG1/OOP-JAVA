package integerProject;

public class Natural extends DigRow{
	public Natural () {
		super("1");
	}
	
	public Natural(String s) {
		super(s);
	}
	
	@Override
	public void setValue(String value) {
		super.setValue(value);
		if(!isCorrect()) return;
		if(value.equals("") || leadZeroCount()!=0) {
			super.setValue("?");
		}
	}
	
	public Natural Add(Natural n) {
		if(!(n.isCorrect() || isCorrect())) return new Natural("");
		String s1 = this.getValue(), s2 = n.getValue(), s="";
		
		int i = s1.length()-1;
		int j = s2.length()-1;
		int c = 0, d;
		for(; i>=0 || j>=0; i--, j--) {
			d = c;
			if(i >= 0) d+=s1.charAt(i) - '0';
			if(j >= 0) d+=s2.charAt(j) - '0';
			if(d >= 10) {
				d-=10;
				c = 1;
			} 
			else c = 0;
			s = d + s;
		}
		if(c!=0) s=1+s; 
		return new Natural(s);
	}
	
	
	
}


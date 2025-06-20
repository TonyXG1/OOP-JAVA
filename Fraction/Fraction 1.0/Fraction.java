package fraction;

public class Fraction {
	private long num, den;
	
	
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public long getDen() {
		return den;
	}
	public void setDen(long den) {
		if(den == 0) {System.out.println("You can't divide ny zero"); return;}
		this.den = den;
	}
	
	private long gcd() { //Greatest Common Divider
		long n = num<0?-num:num;
		long d = den;
		
		long t = n;
		if(d>t) {
			n=d;
			d=t;
		}
		do {
			t = n%d;
			if(t==0) return d;
			n=d;
			d=t;
			
		} while (true);
	}
	
	private void normalize() {
		if(den == 0) return;
		if(num == 0) {den = 1; return;}
		if(den < 0) { num*=-1; den*=-1;}
		long d = gcd();
		num/=d;
		den/=d;
	}
	
	public Fraction add(Fraction fr) {
		return new Fraction(this.num*fr.den+this.den*fr.num,this.den*fr.den);
	}
	
	@Override
	public String toString() {
		if(den == 0) return "NaN";
		if(den==1) return ""+num;
		return String.format("%d / %d", num, den);
		
	}
	
	public Fraction() {
		num = 0;
		den = 1;
	}
	public Fraction(long num, long den) {
		this.num = num;
		this.den = den;
		normalize();
	}
	
	
}

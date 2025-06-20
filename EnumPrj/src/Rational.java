import java.util.Objects;

public class Rational implements Enumerable<Rational>{
	long num, den;
	
	private long gcd() {
		long a = num;
		long b = den;
		long t;
		
		if(a<b) {
			t = a;
			a = b;
			b = t;
		}
		
		do {
			t = a%b;
			if(t==0) return b;
			a=b;
			b=t;
			
		} while (true);
	}
	
	public Rational() {
		num = 0;
		den = 0;
	}
	
	public Rational(long num, long den) {
		this.num = num;
		this.den = den;
	}
	public Rational(Rational r) {
		this(r.num, r.den);
	}
	
	public Rational nextRat() {
		Rational r = new Rational(this);
		do {
			r.num++;
			if(r.num == r.den) {
				return new Rational(1, r.den+1);
			}
			if(r.gcd()==1) return r;
		} while (true);
	}
	
	@Override
	public int hashCode() {
		long t = gcd();
		
		return (int) (num/t + den/t); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational r = (Rational) obj;
		return num*r.den == den*r.num;
	}
	@Override
	public long f() {
		if(this.equals(new Rational(0,1))) return 1;
		if(this.equals(new Rational(1,1))) return 2;
		Rational r = new Rational(1, 2);
		long n = 3;
		while(!r.equals(this)) {
			r = r.nextRat();
			n++;
		}
		return n;
	}
	@Override
	public Rational g(long n) throws IllegalArgumentException {
		if(n <= 0) throw new IllegalArgumentException();
		if(n==1) return new Rational(0,1);
		if(n==2) return new Rational(1,1);
		Rational r = new Rational(1,2);
		for(int i = 3; i<n; i++) {
			r = r.nextRat();
		}
		return r;
	}
	
	@Override
	public String toString() {
		return this.num + "/" + this.den;
	}
}

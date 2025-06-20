import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Even e = new Even(1000);
		System.out.println(e.g(e.f()));
		System.out.println(e.g(1000));
		
		Int i = new Int();
		for (int j = 1; j <= 10; j++) {
			
			System.out.println(j + " -> " + i.g(j));
		}
		
		Rational r = new Rational(1, 2);
		System.out.println(r.g(7));
		System.out.println(r.f());
	}

}

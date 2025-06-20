package fraction;
import java.util.Iterator;
import java.util.Random;
public class Main {

	public static Random r = new Random(); 		//Random Object
	public static int rnd(int low, int high) {
		return low + r.nextInt(high-low+1);
	}
	
	public static void sort(Fraction [] f) { //Bubble sort s do while
		boolean b;
		int d = f.length-2;
		do {
			b = false;
			for(int i = 0; i <= d; i++) {
				if(f[i].compareTo(f[i+1]) > 0) {
					Fraction t = f[i];
					f[i] = f[i+1];
					f[i+1] = t;
					b = true;
				}
			}
			d--;
		} while (b);
	}
	
	public static void main(String[] args) {
		Fraction [] a = new Fraction[10000];
		
		for(int i = 0 ; i < a.length; i++) {
			long num = rnd(-100, 100);
			long den = rnd(-100, 100);
			a[i] = new Fraction(num, den);
			//System.out.print(a[i] + " ");
		}
		System.out.println();
		sort(a);
		for(int i = 0 ; i < a.length; i++) {
			if(i%50 == 0) System.out.println();
			System.out.print(a[i] + " ");
		}
		
		
	}

}

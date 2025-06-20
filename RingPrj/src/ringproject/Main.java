package ringproject;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		Ring<Integer> r = new Ring<>();
		try {
			System.out.println(r);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		r.add(2);
		r.add(23);
		r.add(2);
		System.out.println(r);
		r.add(123);
		System.out.println(r);
		
	}

}

package genericTest;

class Swappable <T>{
	private T first;
	private T second;
	
	public void swap() {
		T temp = first;
		first = second;
		second  = temp;
	}


	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
	
	public Swappable() {
		first = null;
		second = null;
	}
	
	public Swappable(T a, T b) {
		first = a;
		second = b;
	}
	
	@Override
	public String toString() {
		return "Swappable [first=" + first + ", second=" + second + "]";
	}
	
}

public class Test {

	public static void main(String[] args) {
		String a = "mama", b= "shoko";
		Swappable <String> s = new Swappable <String> (a, b)  ;		
		s.swap();
		System.out.println(s);
		
		Swappable <Point> s1 = new Swappable <> (new Point(1,2), new Point(2, -5));
		s1.swap();
		System.out.println(s1);
		
	}

}

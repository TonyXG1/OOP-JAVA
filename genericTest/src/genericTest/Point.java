package genericTest;

public class Point {
	private int x, y;
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	@Override
	public String toString() {
		return "(x = " + x + "; y = " + y + ")";
	}
	
	
}

package triangleProject;

public class Main {

	public static void main(String[] args) {
		Triangle triangle = new Triangle(3,4,5);
		Triangle incorrectTriangle = new Triangle (3,0,5);
		System.out.println(triangle.getVertex(2));
		System.out.println(triangle); 
		System.out.println(triangle.perimeter());
		System.out.println(triangle.area());
		System.out.println(triangle.height('C'));
		System.out.println(triangle.bisector('C'));
		System.out.println(triangle.median('B'));
		System.out.println(triangle.inRadius());
		System.out.println(triangle.outRadius());
		
		System.out.println(incorrectTriangle.getVertex(2));
		System.out.println(incorrectTriangle); 
		System.out.println(incorrectTriangle.perimeter());
		System.out.println(incorrectTriangle.area());
		System.out.println(incorrectTriangle.height('C'));
		System.out.println(incorrectTriangle.bisector('C'));
		System.out.println(incorrectTriangle.median('B'));
		System.out.println(incorrectTriangle.inRadius());
		System.out.println(incorrectTriangle.outRadius());
	}

}

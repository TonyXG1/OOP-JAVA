package triangleProject;

public class Triangle {

	private double [] side = new double [3];
	private char [] vertex = new char [3];
	
	public Triangle (double a, double b , double c, char A, char B, char C) {
		side[0] = a;
		side[1] = b;
		side[2] = c;
		
		vertex[0] = A;
		vertex[1] = B;
		vertex[2] = C;
	}
	
	public Triangle(double a, double b, double c) {
		side[0] = a;
		side[1] = b;
		side[2] = c;
		
		vertex[0] = 'A';
		vertex[1] = 'B';
		vertex[2] = 'C';
	}
	
	public Triangle() {
		side[0] = 0;
	}
	
	public boolean isCorrect() {
		
		double a = side[0];
		double b = side[1];
		double c = side[2];
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return false;
		}
		
		for (int i = 0; i < 3; i++) {
			if(side[i] + side[(i+2)%3] <= side[(i+1)%3]) return false;
		}
		
		for(int i= 0 ; i < 3; i++) {
			if(vertex[i] < 'A' || vertex[i] > 'Z') return false;
		}
		
		if(vertex[0] == vertex[1]) return false;
		if(vertex[0] == vertex[2]) return false;
		if(vertex[1] == vertex[2]) return false;
		
		return true;
	}

	public double getSide(int n) {
		if(!isCorrect()) return 0;
		return side[n];
	}
	
	public void setSide(int n, double newValue) {
		if(n < 0 || n > 2) return;
		side[n] = newValue;	
	}

	public char getVertex(int n) {
		if(!isCorrect()) return '?';
		return vertex[n];
	}
	
	public void setVertex(int n, char newValue) {
		if(n < 0 || n > 2) return;
		vertex[n] = newValue;	
	}
	
	public double perimeter() {
		if(!isCorrect()) return 0;
		double p = side[0] + side[1] + side[2];
		return p;
	}
	
	public double area() {
		if(!isCorrect()) return 0;
		double p = (side[0] + side[1] + side[2]) / 2;
		double s = p;
		for(int i = 0; i<3; i++) s *= (p - side[i]);
		s = Math.sqrt(s);
		return s;
	}
	
	public double height(char v) {
		double s = 0;
		for(int i = 0; i < 3; i++) {
			if(v == vertex[i]) {
				s = side[(i+1)%3];
				break;
			}
		}
		if (!isCorrect()) return 0;
		return (2*area()) / s;
	}
	
	public double median(char v) {
		double s = 0;
		double a = 0;
		double b = 0;
		
		for (int i = 0; i < 3; i++) {
			if(v == vertex[i]) {
				s = side[(i+1)%3];
				a = side[i];
				b = side[(i+2)%3];
				break;
			}
		}
		if (!isCorrect()) return 0;
		
		double m = Math.sqrt((2*a*a+2*b*b-s*s) / 4);
		return m;
	}
	
	public double bisector(char v) {
		double a = 0, b = 0, c = 0;
		for (int i = 0; i<3; i++) {
			if(v == vertex[i]) {
				a = side[i];
				b = side[(i+2)%3];
				c = side[(i+1)%3];
			}
		}
		if(a == 0) return 0;
		
		double proportion = a / b;
		double m,n;
		m = c / (proportion+1);
		n = c - m;
		
		return Math.sqrt(a*b - m*n);
	}
	public double inRadius() {
		if (!isCorrect()) return 0;
		double p = perimeter()/2;
		return area() / p;
	}
	
	public double outRadius() {
		double a = side[0], b = side[1], c = side[2];
		if (!isCorrect()) return 0;
		return (a*b*c) / 4*area();
	}
	
	@Override
	public String toString() {
		String s = "" + vertex[0] + vertex[1] + vertex[2];
		if(!isCorrect()) return "Incorrect triangle";
		return String.format("\u0394 %s (%1.2f, %1.2f, %1.2f)", s, side[0], side[1], side[2]);
		
	}
}

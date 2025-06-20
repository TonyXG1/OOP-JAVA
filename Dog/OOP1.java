package main;
import java.util.Scanner;
public class OOP1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Dog Bobson = new Dog("Bobson", 0, 6, 1.50, 23.4, 55);
		System.out.println("My dog name is " + Bobson.getName());
		Bobson.setName(sc.next());
		System.out.println(Bobson.getName());
		System.out.println(Bobson);
	}

}

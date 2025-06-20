package planetsProject;
import java.io.File;
import java.util.Scanner;
public class Planets_in {

	public static void swap(Planet [] arr, int i, int j) {
		Planet t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void selectionSort(int crit, Planet [] arr) {
		for(int i = 0; i<arr.length-1; i++) {
			int k = i;
			for(int j = i+1; j<arr.length; j++) {
				switch (crit) {
				case 1: if(arr[j].compareTo1(arr[k])>0) k = j;
					break;
				
				case 2: if(arr[j].compareTo2(arr[k])>0) k = j;
					break;
				}
			}
			swap(arr, i, k);
		}
	}

	public static void show(Planet[]arr, String s) {
		for(int i=0, j=0; i<arr.length; i++) {
			if(arr[i].getName().indexOf(s) >= 0) {
				System.out.printf("%d. %s\n", ++j, arr[i].getName());
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner inp;
		Planet [] planets;
		File f;
		int n, number, sat;
		double size;
		String name;
		
		try {
			f = new File("PLANETS.IN");
			inp = new Scanner(f);
		} catch (Exception e) {
			System.out.println("File not found");
			return;
		}
		
		n = inp.nextInt();
		planets = new Planet[n];
		inp.nextLine();
		for(int i = 0; i < n; i++) {
			name = inp.nextLine();
			number = inp.nextInt();
			sat = inp.nextInt();
			size = inp.nextDouble();
			inp.nextLine();
			planets[i] = new Planet(name, number, sat, size);	
		}
		
		selectionSort(1, planets);
		show(planets, "");
		String s = inp.next();
		System.out.println("Planet name should contain: " + s);
		inp.close();
		selectionSort(2, planets);
		show(planets, s);
		
	}

}

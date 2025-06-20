package starsProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
	
	private static Star [] array;
	private static Scanner inp = new Scanner(System.in);
	public static void main(String[] args) {
		
		
 		System.out.print("Number of stars: ");
 		int n = inp.nextInt();
 		array = new Star[n];
 		for(int i = 0; i < n; i++) {
 			System.out.println("Star #" + (i+1) + ":");
 			Star curStar = new Star();
 			curStar.input();
 			array[i] = curStar;
 			//System.out.println(curStar);
 		}
 		inp.close();
		
		//TODO QuickSort - 2,3
 		
 		
 		//ZAD 4
 		ArrayList<String> constsNames = new ArrayList<>();
 		Map<String, Double> consts = new HashMap<>();
 		Map<String, Integer> dividers = new HashMap<>();
 		
 		consts.put(array[0].getConstellation(), array[0].getMass());
 		constsNames.add(array[0].getConstellation());
 		
 		dividers.put(array[0].getConstellation(), 1);
 		
 		for(int i = 1; i < n; i++) {
 			if(!consts.containsKey(array[i].getConstellation())) {
 				consts.put(array[i].getConstellation(), array[i].getMass());
 				constsNames.add(array[i].getConstellation());
 				
 				dividers.put(array[i].getConstellation(), 1);
 			}
 			else {
 				double oldValue = consts.get(array[i].getConstellation());
 				int dividerOldValue = dividers.get(array[i].getConstellation());
 				consts.put(array[i].getConstellation(), oldValue + array[i].getMass());
 				dividers.put(array[i].getConstellation(), ++dividerOldValue);
 			}
 		}
 		ArrayList<Double> values = new ArrayList<>(consts.values());
 		ArrayList<Integer> divs = new ArrayList<>(dividers.values());
 		
 		Map<String, Double> averages = new HashMap<>();
 		
 		for(int i = 0; i < consts.size(); i++) {
 			averages.put(constsNames.get(i), values.get(i) / divs.get(i));
 		}
 		System.out.println(averages);
		
		
	}

}

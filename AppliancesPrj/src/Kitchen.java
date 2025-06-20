import java.util.Scanner;

public class Kitchen {
	static Scanner inp = new Scanner(System.in);
	private Appliance[] app;
	
	public Kitchen() {
		int n;
		do {
			System.out.println("How many appliances: ");
			n = inp.nextInt();
		}
		while(n<=0);
		
		app = new Appliance[n];
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Appliance #" + i);
			System.out.print("Appliance type (1: dishwasher, 2: refrigerator, 3:washing machine) :");
			int type = inp.nextInt();
			
			System.out.println("- weight: ");
			double weight = inp.nextDouble();
			System.out.println("- breadth: ");
			double breadth = inp.nextDouble();
			System.out.println("- width: ");
			double width = inp.nextDouble();
			System.out.println("- height: ");
			double height = inp.nextDouble();
			
			switch (type) {
				case 1: {
					app[i-1] = new Dishwasher(weight, breadth, width, height);
				}
				break;
			
				case 2: {
					app[i-1] = new Fridge(weight, breadth, width, height);
				}
				break;
			
				case 3: {
					app[i-1] = new WashingMachine(weight, breadth, width, height);
				}
				break;
			
				default:{
					i--;
					continue;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i=0; i<app.length; i++) {
			s += app[i].toString() + "\n";
		}
		
		return s;
	}
}

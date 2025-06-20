package catalogProject;
import java.util.Scanner;
import java.io.File;
public class Main {

	private static Catalog [] mainCatalog = new Catalog [100];
	private static Scanner inp = new Scanner(System.in);
	
	public static void selectionSort(Catalog[]arr) {
		for(int i = 0; i < arr.length-1; i++) {
			int m = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j].compareTo(arr[m]) < 0) m = j;
			}
			
			Catalog temp = arr[i];
			arr[i] = arr[m];
			arr[m] =temp;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		//File f = new File("Input");

		//ZAD 1 - Input
		
		int N, M;
		String s;
		try {
			//Scanner inp = new Scanner(f);
			
			do {
				System.out.print("Catalog count: ");
				N = inp.nextInt();
			} while (N <= 0 || N > 100);
			inp.nextLine();
			
			mainCatalog = new Catalog[N];
			
			for (int i = 0; i < N; i++) {
				boolean exists;
				do {
					exists = false;
					System.out.println("Catalog #" + (i+1));
					s = inp.next();
					
					for (int j = 0; j < i; j++) {
						exists = mainCatalog[j].getName().equals(s);
						if(exists) break;
					} 
					
					if(exists) continue;
					mainCatalog[i] = new Catalog(s); //!
					//c.input(true, inp);
					
					System.out.println("Files count:");
					M = inp.nextInt();
					for(int j = 0; j < M; j++) {
						System.out.println("File #" + (j+1) + ":");
						String file = inp.next();					
						mainCatalog[i].addFile(file, j);
					}
					
				} while (exists);
			}
			
			//inp.close();
			for (int i = 0; i < mainCatalog.length; i++) {
				//System.out.println("Catalog #" + (i+1));
				System.out.println(mainCatalog[i]);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("File not found");
		}
		
		//ZAD 2
		for(int i = 0; i< mainCatalog.length; i++) mainCatalog[i].bubbleSort1();
		selectionSort(mainCatalog);
		for (int i = 0; i < mainCatalog.length; i++) System.out.println(mainCatalog[i]);
	
		//ZAD 3
		System.out.println("Catalog to search: ");
		String searchName = inp.next();
		
		for(int i = 0; i < mainCatalog.length; i++) {
			if(mainCatalog[i].getName().equals(searchName)) {
				Catalog c = mainCatalog[i];
				int count = c.getFileCount();
				if(count<2) break;
				
				boolean found = false;
				for(int j = 0; j < count-1; j++) {
					for(int k = j+1; k < count; k++) {
						if(c.getFileName(j).equals(c.getFileName(k))) {System.out.println("Yes"); found = true; break;}
					}
				}
				if(found == false) System.out.println("No");
				break;
			}
		}
		
		//ZAD 4
		System.out.println("Enter file name to search:");
		String fileName = inp.next();
		
		for(int i = 0; i < mainCatalog.length; i++) {
			for(int j = 0; j < mainCatalog[i].getFileCount(); j++) {
				if(mainCatalog[i].getFileName(j).equals(fileName)) System.out.println(mainCatalog[i].getName());
			}
		}
		
		

	}

}

package catalogProject;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;

public class Catalog {
	private int count = 0;
	private String [] files;
	private String name;
	//private String fullName;
	/*
	 * public void input(boolean stdinp, Scanner inp) {
	 * 
	 * if (stdinp) { if (stdinp) System.out.print("Catalog name: "); name =
	 * inp.next();
	 * 
	 * if (stdinp) System.out.print("Files count: "); //Kontrol na broq na filovete
	 * moje da se napravi count = inp.nextInt(); files = new String[count];
	 * inp.nextLine();
	 * 
	 * for(int i = 0; i < count; i++) { if (stdinp) System.out.print("File #" +
	 * (i+1) + ": "); files[i] = inp.nextLine(); } } }
	 */

	public String getName() {
		return name;
	}
	
	public String getFileName(int n) {
		if(n<0 || n >= count) return "";
		int p = files[n].indexOf('.');
		if (p<0) return files[n];
		return files[n].substring(0, p);
	}
	
	public String getFileExtension(int n) {
		if(n<0 || n >= count) return "";
		int p = files[n].indexOf('.');
		if (p<0) return "";
		return files[n].substring(p+1);
	}
	
	public String getFile(int n) {
		if(n<0 || n >= count) return "";
		return files[n];
	}
	
	public int getFileCount() {
		return count;
	}
	
	public void addFile(String file, int i) {
		files[i] = file;
		count++;
	}
	
	private int compareToinArray(int i, int j) {
		if(getFileName(i).compareTo(getFileName(j)) != 0) return getFileName(i).compareTo(getFileName(j));
			return -getFileName(i).compareTo(getFileName(j));
	}
	
	public int compareTo(Catalog c) {
		return name.compareTo(c.name);
	}
	
	public void bubbleSort1() {
		for(int i = 0; i < count-1; i++) {
			for(int j = 1; j < count-i-1; j++) {
				int comparison = getFileName(j).compareTo(getFileName(j+1));
				if(comparison > 0){
					String temp = files[j];
					files[j] = files[j+1];
					files[j+1] = temp;
				}
				else if (comparison == 0){
					if(getFileExtension(i).compareTo(getFileExtension(i+1)) > 0) {
						String temp = files[j];
						files[j] = files[j+1];
						files[j+1] = temp;
					}
				}
			}
		}
	}
	
	public void bubbleSort2() {
		int r = count - 1;
		boolean swapped;
		do {
			swapped = false;
			
			for(int i = 0 ; i < r; i++) {
				int comparison = getFileName(i).compareTo(getFileName(i+1));
				if(comparison > 0){
					String temp = files[i];
					files[i] = files[i+1];
					files[i+1] = temp;
					swapped = true;
				}
				else if (comparison == 0){
					if(getFileExtension(i).compareTo(getFileExtension(i+1)) > 0) {
						String temp = files[i];
						files[i] = files[i+1];
						files[i+1] = temp;
						swapped = true;
					}
				}
			}
			r--;
		} while (swapped);
		
	}
	
	public Catalog (String name) {
		this.name = name;
		files = new String[20];
	}
	
//	public Catalog (String name, int num) {
//		this.name = name;
//		count = num;
//		files = new String[num];
//	}
	
	@Override
	public String toString() {
		String s = name + "\n";
		for (int i = 0; i < count; i++) {
			s += files[i] + "\n";
		}
		return s;
	}
}

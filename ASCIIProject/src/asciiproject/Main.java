package asciiproject;

public class Main {

	public static void main(String[] args) {
//		Character c = new Character('A');
//		Character c1 = new Character('z');
//		System.out.println((int)c.getVal());
//		System.out.println((int)c1.getVal());
		
		
		Alphabetical a = new Alphabetical('I');
		System.out.println(a);
		System.out.println(a.lCase());
		
		a.repeat(23); 
		a.uCase().repeat(23);
	}

}

package genericTest;

public class MainDynArr {

	public static void main(String[] args) {
		DynArr <Integer> arr = new DynArr <> ();
		arr.add(3);
		for(int i = 0; i<10; i++) {
			arr.add(2);
		}
		System.out.println(arr.getCount());
		arr.remove();
		System.out.println(arr.getCount());
		arr.get(0);
		arr.set(5, 5);
		System.out.println(arr);
	}

}

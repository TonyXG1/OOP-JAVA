package linkedList;

public class Main {

	public static void main(String[] args) {
		List <Integer> L = new List<>();
//		L.push_front(2);
//		L.push_front(6);
//		L.push_front(3);
//		System.out.println(L);
		
		for (int i = 1; i <= 10; i++) {
			L.push_back(i);
		}
		
		L.push_back(1);
		
		for (int i = 1; i <= 10; i++) {
			L.pop_back();
			System.out.println(L);
		}
		System.out.println(L.pop_back());
		//System.out.println(L.pop_back());
		
	}

}
 
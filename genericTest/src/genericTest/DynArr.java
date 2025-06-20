package genericTest;

import java.util.Iterator;

public class DynArr <T>{
	private final int enlarge = 16;
	private Object [] arr;
	private int count;
	
	 /* 
	 * Konstruktor
	 * Dobavqne na element(add)
	 * Premahvane na posledniq element(remLast)
	 * getters & setters:
	 * getCount()
	 * get(nomer na elementa)
	 * set(nomer na elementa, nova stoinost)
	 * toString {el0, el1, ..., elPosleden}
	 */
	
	public DynArr() {
		count = 0;
		arr = new Object [enlarge];
	}
	
	public void add(T el) {
		if(count >= arr.length) {
			Object[] t = new Object[arr.length+enlarge];
			for (int i = 0; i < arr.length; i++) {
				t[i] = arr[i];
			}
			arr = t;
		} 
			try {
				arr[count++] = el;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	public void remove() {
		if(count <= 0) return;
		count--;
	}
	
	public boolean removeCheck() {
		if(count<=0) return false;
		count--;
		return true;
	}
	
	public int getCount() {
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int n) {
		return (T) arr[n];
	}
	
	public void set(int n, T value) {
		try {
			arr[n] = value;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		if(count <= 0) return "[ ]";
		String s = "[";
		for(int i = 0; i < count-1; i++) {
			s = s + arr[i] + ", ";
		}
		
		s=s + arr[count-1] + "]";
		return s;
	}
	
}

package DynArr;

public class Stack1 <T>{
	private DynArray<T>arr = new DynArray<>();
	private int stackPtr = -1;
	
	public void push(T el) {
		arr.add(el);
		stackPtr++;
	}
	
	public T pop() throws IllegalStateException{
		if(stackPtr<0) throw new IllegalStateException();
		T lastEl = arr.get(stackPtr);
		arr.removeLast();
		stackPtr--;
		return lastEl;
	}
	
	public T top() throws IllegalStateException{
		if(stackPtr<0) throw new IllegalStateException();
		return arr.get(stackPtr);
	}
	
	public void swap() throws IllegalStateException{
		if(stackPtr<1) throw new IllegalStateException();
		T last = arr.get(stackPtr);
		T previous = arr.get(stackPtr-1);
		arr.set(stackPtr, previous);
		arr.set(stackPtr-1, last);
	}
	
	@Override
	public String toString() {
		String s = "{";
		try {
			for(int i = 0; i<arr.getCount()-1; i++) {
				s = s + arr.get(i) + ", ";
			}
			s += "" + arr.get(stackPtr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		s+= "}";
		return s;
	}
	
	
	
}

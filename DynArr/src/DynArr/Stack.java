package DynArr;

/*
 * Stack (Last in first out) - LIFO
 * push
 * pop
 * top
 * swap
 * reverse - TODO
 */

public class Stack <T> extends DynArray{
	//private DynArray<T> data;
	private int stackPtr;
	
	public Stack() {
		//data = new DynArray<>();
		stackPtr = -1;
	}
	
	public void push (T el) {
		add(el);
		stackPtr++;
	}
	
	public T pop () throws IllegalStateException{
		if(stackPtr < 0) throw new IllegalStateException();
		T lastElement = (T) get(stackPtr); 
		removeLast();
		stackPtr--;
		return lastElement;
	}
	
	public T top () throws IllegalStateException{
		if(stackPtr < 0) throw new IllegalStateException();
		return (T) get(stackPtr);
	}
	
	public void swap() throws IllegalStateException {
		if(stackPtr < 1) throw new IllegalStateException();
		
		T last = pop();
		T previous = pop();
		push(last);
		push(previous);
	}
	
	@Override
	public String toString() {
		String s = "{";
		try {
			for(int i = 0; i<getCount()-1; i++) {
				s = s + get(i) + ", ";
			}
			s += get(getCount()-1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		s+= "}";
		return s;
	}
}

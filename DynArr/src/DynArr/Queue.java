package DynArr;

public class Queue <T> extends DynArray<T>{
	/*
	 * FIFO
	 * add
	 * get
	 * first
	 */
	private DynArray<T> arr = new DynArray<>();
	private int queuePtr;
	
	public Queue () {
		queuePtr = -1;
	}
	
	@Override
	public void add(T el) {
		arr.add(el);
		queuePtr++;
	}
	
	public T get() throws IllegalStateException{
		if(queuePtr<0) throw new IllegalStateException();
		T firstEl = arr.get(0);
		DynArray <T>newArr = new DynArray<T>();
		for(int i=1;i<arr.getCount();i++){
			newArr.add(arr.get(i));
		}
		queuePtr--;
		arr = newArr;
		return firstEl;
	}
	
	public T first() throws IllegalStateException{
		if(queuePtr<0) throw new IllegalStateException();
		return arr.get(0);
	}
	
	@Override
	public String toString() {
		return arr.toString();
	}
}

package linkedList;

public class List <T>{
	private Node<T> first;
	
	public List() {
		first = null;
	}
	
	public List(T v) {
		first = new Node<T>(v);
	}
	
	public void push_front(T v) {
		if(isEmpty()) first = new Node<T>(v);
		else first = first.push_front(v);
	}
	
	public boolean isEmpty() {
		if(first == null) return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T getData() throws NullPointerException {
		if(isEmpty()) throw new NullPointerException("Empty");
		return (T) first.getData();
	}
	
	public T pop_front() throws NullPointerException {
		if(isEmpty()) throw new NullPointerException("Empty");
		T result = first.getData();
		first = first.pop_front();
		return result;
	}
	
	
	public void push_back(T v) {
		if(isEmpty()) first = new Node<T>(v);
		else first.push_back(v, first);
		
	}
	
	public T pop_back() throws NullPointerException{
		try {
			if(first == null) throw new NullPointerException("Empty");
			if(first.getLink() == null) {
				return (T) pop_front();
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return first.pop_back(first);
	}
	
	
	@Override
	public String toString() {
		if(isEmpty()) return "{}";
		return first.toString();
	}
	
	
//	@Override
//	public String toString() {
//		String s = "{ ";
//		if(isEmpty()) return s + " }";
//		Node<T> t = first.link;
//		
//		try {
//			do {
//				s+=t.getData() + " ";
//				t = t.link;
//			}
//			while (true);	
//		} catch (Exception e) {
//			s+="}";
//			return s;
//		}
//	
//		
//	}
	
}

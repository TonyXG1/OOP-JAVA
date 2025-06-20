package doublylist;

public class DoublyLinkedList <T>{
	@SuppressWarnings("hiding")
	public class Node <T>{
		private T v;
		private Node<T> next;
		private Node<T> prev;
		
		public Node (T v){
			this.v = v;
			next = null;
			prev = null;
		}
		
		public Node (T v, Node<T> next, Node<T> prev) {
			this.v = v;
			this.next = next;
			this.prev = prev;
		}
		
		public T getData() {
			return v;
		}
		
		public Node<T> getPrev() {
			return prev;
		}
		
		public Node<T> getNext(){
			return next;
		}
		
		public void setPrev(Node<T> n) {
			prev = n;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
		
		@Override
		public String toString() {
			 Node<T> t = this;
			 //6 <- 5 -> null
			  
			 //TODO
			 String s = "";
			 
			 if(prev == null) s = "null";
			 else s = "" + prev.v;
			 
			 s += " <- " + t.v + " -> ";
			 
			 if(next == null) s += "null";
			 else s += next.v;
			
			 return s;
		}
	}
	
	/*
	 * 
	public void pushFront(T d)
	public void pushBack(T d)
	public T popFront() throws NullPointerException
	public T popBack() throws NullPointerException
	public void insert(T d,Node<T> p)
	public T remove(Node<T> p) throws NullPointerException
	public void reverse()
	public void swap(Node<T> p, Node<T> q) 
             throws NullPointerException
	 * *
	 */
	
	
	private Node<T> first;
	private Node<T> last;
	
	public DoublyLinkedList () {
		first = null;
		last = null;
	}
	
	public DoublyLinkedList(T v) {
		first = last = new Node<T> (v);
	}
	
	public Node<T> getFirst() throws NullPointerException{
		return first;
	}
	
	public Node<T> getLast() throws NullPointerException{
		return last;
	}
	
	public void push_front(T v) {
		Node<T> n = new Node<T>(v);
		if(first == null) {
			first = last = n;
			return;
		}
		n.setNext(first);
		first.setPrev(n);
		first=n;
	}
	
	public void push_back(T v) {
		Node<T> n = new Node<T>(v);
		
		if(first == null) {
			first = last = n;
			return;
		}
		
		n.setPrev(last);
		last.setNext(n);
		last = n;
	}
	
	public T pop_front() throws NullPointerException {
		if(first == null) throw new NullPointerException("Empty list");
		T popped = first.v;
		first = first.next;
		if(first == null) {
			last = null;
			return popped;
		}
		
		first.prev = null;
		return popped;
	}
	
	public T pop_back() throws NullPointerException {
		if(last == null) throw new NullPointerException("Empty list");
		T popped = last.v;
		last = last.prev;
		if(last == null) {
			first = null;
			return popped;
		}
		last.next = null;
		return popped;
	}
	
	private void insert(T v, Node<T> p) throws NullPointerException {
		Node <T> temp = new Node<T>(v);
		if(p == null) {push_back(v); return;}
		if(p == first) {push_front(v); return;}
		temp.setNext(p);
		temp.prev = p.prev;
		p.prev.next = temp;
		p.prev = temp;
	}
	
	public void insert(T v, int p) throws NullPointerException {
		Node<T> t = first; 
		while(p!=0 && t != null) {
			t = t.next;
			p--;
		}
		insert(v, t);
	}
	
	public void insertAfter(T v, T after) throws IllegalArgumentException {
		int n = 0;
		Node<T> t = first;
			while(t != null && !t.getData().equals(after)) {
				t = t.next;
				n++;
				if(t==null) throw new IllegalArgumentException("Element not found");
			}

			insert(v, n+1);

	}
	
	public void insertBefore(T v, T before) throws IllegalArgumentException{
		int n = 0;
		Node<T> t = first;
			while(t != null && !t.getData().equals(before)) {
				t = t.next;
				n++;
				if(t==null) throw new IllegalArgumentException("Element not found");
			}

			insert(v, n);
	}
	
	public void deleteAtIndex (int p)	throws NullPointerException{
		Node<T> current = first;
		
		for(int i = 0; i<p; i++) {
			current = current.next;
		}
		
		if(current == null) throw new NullPointerException();
		
		if(current == first) {
			pop_front();
			return;
		}
		
		if(current == last) {
			pop_back();
			return;
		}
		
		current.prev.next = current.next;
		current.next.prev = current.prev;
	}
	
	public void deleteFirst(T v) throws NullPointerException{
		Node<T> current = first;
		
		while(current.getData() != v && current != null) {
			current = current.next;
		}
		
		if(current == null) throw new NullPointerException("Element does not contain in the list");
		
		if(current == first) {
			pop_front();
			return;
		}
		
		if(current == last) {
			pop_back();
			return;
		}
		
		current.prev.next = current.next;
		current.next.prev = current.prev;
	}
	
	public void deleteLast(T v) throws NullPointerException{
		Node<T> current = last;
		
		while(current.getData() != v && current != null) {
			current = current.prev;
		}
		
		if(current == null) throw new NullPointerException("Element does not contain in the list");
		
		if(current == first) {
			pop_front();
			return;
		}
		
		if(current == last) {
			pop_back();
			return;
		}
		
		current.prev.next = current.next;
		current.next.prev = current.prev;
	}
	
	public void reverse() {
		DoublyLinkedList<T> result = new DoublyLinkedList<T>();
		Node<T> temp = first;
		
		if(first.next == null) return;
		
		while(temp != null) {
			result.push_front(temp.v);
			temp = temp.next;
		}
		if(result == null) throw new NullPointerException("Empty list");
		else first = result.first;
	}
	
	public void swap(Node <T> a, Node<T> b) throws IllegalArgumentException {
		if(a == null || b == null) throw new IllegalArgumentException();
		if(a==b) return;
		
	}
	
	@Override
	public String toString() {
		Node<T> t = first;		
		String s = "{";
		try {
			while(t.next!=null) {
				s += t.v + ", ";
				t = t.next;
			}
		} catch (Exception e) {
			return "{}";
		}
		
		s += t.v + "}";
		return s;
		
	}
	
	public String fullToString() {
		Node<T> t = first;
		String s = "{";
		
		if(t==null) return "{}";
		
			while(t.next!=null) {
				s += t.toString() + " | ";
				t = t.next;
			}
				
		s+= t.toString() + "}";
		return s;
	}
	
}

package ringproject;

public class Ring<T> {
	public class Node {
		private T data;
		private Node next;

		public Node(T d) {
			data = d;
		}
	}

	private Node start;

	public Ring() {
		start = null;
	}

	public Ring(T data) {
		start = new Node(data);
		start.next = start;
	}

	public void add (T data) {
		if(start == null) {start = new Node(data); start.next = start; return;}
		Node temp = start;
		start = new Node(data);
		start.next = temp;
	}

	@Override
	public String toString() throws NullPointerException {
		Ring<T> temp = this;
		
		if (temp.start == null)
			throw new NullPointerException("Empty ring");
		String s = "{";
		
		while (temp.start.next != temp.start) {
			s += temp.start.data + ", ";
			temp.start = temp.start.next;
		}

		return s + temp.start.data + "}";
	}

}

package linkedList;

public class Node <T> {
	private T value;
	public Node<T> link;
	
	public Node (T val) {
		value = val;
		link = null;
	}
	
	private Node (T val, Node<T> link) {
		value = val;
		this.link = link;
	}
	
	public Node<T> push_front(T v) {
		return new Node<T>(v , this);
	}
	
	public Node<T> pop_front(){
		return link;
	}
	
	
	public void push_back(T v, Node<T> first){
		Node<T> newNode = new Node <T> (v);
		Node<T> list = first;
		
		while(list.link != null) {
			list = list.link;
		}
		
		list.link = newNode;
		
	}
	
	public T pop_back(Node<T> first) throws NullPointerException{
		//Node<T> list = first;
		if(first == null) throw new NullPointerException();
		//if(first.link == null) return first.getData();
		while(first.link.link != null) {
			first = first.link;
		}
		T last = first.link.value;
		first.link = null;
		return last;
	}
	
	public Node<T> getLink(){
		return link;
	}
	
	public T getData() {
		return value;
	}
	
	@Override
	 public String toString(){
	  String s="{ ";
	  Node<T> t=this;//"Ходещата" променлива
	  //Обхождане на списъка
	  while (t!=null){
	   s+=t.value.toString()+" ";
	   t=t.link;
	  }
	  s+="}";
	  return s;
	}
}

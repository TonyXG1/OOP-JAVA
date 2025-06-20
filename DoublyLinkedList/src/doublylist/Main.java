package doublylist;

import javax.swing.text.DefaultStyledDocument;

import doublylist.DoublyLinkedList.Node;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> d = new DoublyLinkedList<>();
		
		for(int i = 1; i<=10; i++) {
			d.push_front(i);
		}
		
		System.out.println(d.getFirst());
		
		System.out.println(d);
		
		d.insertAfter(12, 5);
		System.out.println(d);
		
		d.insertBefore(69, 10);
		System.out.println(d);
		
		d.deleteAtIndex(0);
		System.out.println(d);
		d.push_back(5);
		d.push_back(4);
		d.push_front(5);
		System.out.println(d);
		d.deleteFirst(5);
		System.out.println(d);
		
		d.deleteLast(4);
		System.out.println(d);
		
		
		d.reverse();
		System.out.println(d);
		System.out.println(d.fullToString());
		
		
	}

}

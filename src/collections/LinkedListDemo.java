package collections;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<Character> list = new LinkedList<>();
		
		list.add('A');
		list.add('B');
		list.add('D');
		list.add('E');
		System.out.println(list);
		
		list.add(2, 'C');
		System.out.println(list);
		
		list.removeFirst();
		list.removeLast();
		System.out.println(list);
		
		list.add('F');
		list.add('F');
		list.remove(0);
		list.removeLastOccurrence('F');
		System.out.println(list);

	}

}

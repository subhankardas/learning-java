package basics.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Usage of Iterable class to iterate over a list.
 * Usage of stream collect and Collectors to convert
 * stream back to list.
 */
public class IterableDemo {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(65);
		list.add(45);
		list.add(36);
		list.add(67);
		list.add(90);
		list.add(55);
		
		// Iterate over the iterable of the list
		Iterable<Integer> iterable = list;
		iterable.forEach(i -> System.out.print(i + "   "));
		
		// Map stream of int to char, then collect back to list of chars
		List<Character> chars = list.stream().map(i -> (char)i.intValue()).collect(Collectors.toList());
		
		System.out.println();
		chars.forEach(ch -> System.out.println(ch));
		
	}
	
}

package basics.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

	/**
	 * Filtering lists using Predicate with removeIf,
	 * stream filter and iterator. 
	 */
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		
		intList.add(12);
		intList.add(35);
		intList.add(67);
		intList.add(89);
		
		stringList.add("Jack");
		stringList.add("BOB");
		stringList.add("Mary");
		stringList.add("Bob");
		stringList.add("Alice");
		
		System.out.println(intList);
		System.out.println(stringList);
		System.out.println("---------------------------");
		
		// Declaring predicates
		Predicate<Integer> predicate1 = i -> (i <= 35);
		Predicate<String> predicate2 = str -> (str.equalsIgnoreCase("Bob"));
		
		testListOnPredicate(intList, predicate1);
		testListOnPredicate(stringList, predicate2);
		
		filterListOnPredicate(intList, predicate1);
		filterListOnPredicate(stringList, predicate2);
		
		iterateListOnPredicate(intList, predicate1);
		iterateListOnPredicate(stringList, predicate2);
	}
	
	public static <T> void testListOnPredicate(List<T> list, Predicate<T> pred) {
		list.removeIf(item -> pred.test(item));
		System.out.println("Remove If: " + list);
	}

	public static <T> void filterListOnPredicate(List<T> list, Predicate<T> pred) {
		list = list.stream().filter(pred.negate()).collect(Collectors.toList());
		System.out.println("Stream Filter: " + list);
	}
	
	public static <T> void iterateListOnPredicate(List<T> list, Predicate<T> pred) {
		Iterator<T> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			T t = iterator.next();
			if (pred.test(t)) {
				iterator.remove();
			}
		}
		
		System.out.println("Iterator: " + list);
	}
	
}

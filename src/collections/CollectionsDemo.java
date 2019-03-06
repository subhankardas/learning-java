package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		list1.add(12);
		list1.add(34);
		list1.add(56);
		list1.add(78);
		list1.add(90);
		list1.add(56);
		list1.add(56);
		
		list2.add(11);
		list2.add(22);
		list2.add(33);
		list2.add(44);
		list2.add(55);

		System.out.println("Frequency : " + Collections.frequency(list1, 56));
		System.out.println("Disjoint  : " + Collections.disjoint(list1, list2) + "(no common elements)");
		System.out.println();

		System.out.println(list1 + " ->");
		Collections.rotate(list1, 2);
		System.out.println("-> " + list1);
		System.out.println();

		Comparator<Integer> comparator = Collections.reverseOrder(new ListComparator());
		Collections.sort(list2, comparator);
		System.out.println("Reverse Sorted : " + list2);

		Collections.shuffle(list2);
		System.out.println("Shuffled       : " + list2);
		
	}

}

class ListComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer obj1, Integer obj2) {
		return obj1 - obj2;
	}

}

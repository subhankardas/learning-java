package basics.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Subhankar");
		list.add("Rajdeep");
		list.add("Ayan");
		list.add("Samit");

		// Create stream from list
		Stream<String> stream = list.stream();
		Iterator<String> iterator = stream.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "    ");
		}

		// Match all stream values with predicate
		Stream<Integer> intStream = Stream.of(12, 34, 21, 45, 28, 76);
		boolean match1 = intStream.allMatch(i -> i > 10);

		System.out.println();
		System.out.println("All elements great than 10 : " + match1);

		// Stream from an array
		double[] arr = { 12.3, 34.32, 37.43, 98, 23.4, 57 };
		Arrays.stream(arr).forEach(d -> System.out.print(d + "   "));

		System.out.println();
		System.out.println("Stream length: " + Arrays.stream(arr).count());

		// Handle error on already operated / closed stream
		try {
			System.out.println(stream.count());
		} catch (IllegalStateException er) {
			System.out.println("ERROR: " + er.getMessage().toUpperCase());
		}

	}

}

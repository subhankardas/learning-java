package basics.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * In the latest versions of Java, Arrays.sort method and Collection.sort() uses
 * Timsort. It by default sorts in ascending order. To sort array or list in
 * descending order Collections.reverseOrder() is used.
 */
public class Sorting {

	public static void main(String[] args) {

		int[] nums = { 13, 7, 6, 45, 21, 9, 101, 102 };
		int[] noms = { 13, 7, 6, 45, 21, 9, 101, 102 };
		String[] names = { "Sumit V", "Ranjan K", "Sudhir D", "Abbas M", "Kalyan P" };
		List<String> nms = new ArrayList<>(Arrays.asList(names));

		// 1. Sorting primitive type arrays - Arrays sort
		Arrays.sort(nums);
		Arrays.sort(names);

		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(names));

		// 2. Sorting of collections - Collections sort
		Collections.sort(nms);

		System.out.println(nms);

		// 3. Sorting in reverse order
		Collections.sort(nms, Collections.reverseOrder());

		System.out.println(nms);

		// 4. Sort only sub-array
		Arrays.sort(noms, 0, 3);

		System.out.println(Arrays.toString(noms));

	}

}

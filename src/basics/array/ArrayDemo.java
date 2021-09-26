package basics.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDemo {

	public static void main(String[] args) {

		int[] arr = { 12, 78, 43, 24, 57, 90, 63 };

		// Convert array to list
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(list.getClass().getSimpleName() + ": " + list + "\n");

		// Binary search, works only after sort else negative, O(log N)
		Arrays.sort(arr);
		int key = Arrays.binarySearch(arr, 43);
		System.out.println("Binary Search found at index: " + key + "\n");

		// Compare
		int comp = Arrays.compare(new int[5], arr);
		System.out.println("Compare result 1: " + comp); // -1 = new int[5] < arr

		comp = Arrays.compare(arr, arr);
		System.out.println("Compare result 2:  " + comp); // 0 = arr == arr

		comp = Arrays.compare(arr, new int[5]);
		System.out.println("Compare result 3:  " + comp); // 1 = arr > new int[5]

		// Copy array to new array
		int newarr[] = Arrays.copyOf(arr, 10);
		System.out.println("\nCopy array to new array: " + Arrays.toString(newarr));
		System.out
				.println("Original array hash: " + arr.hashCode() + "     New array hash: " + newarr.hashCode() + "\n");

		// Copy array from and to a range
		int[] somearr = Arrays.copyOfRange(arr, 2, 5);
		System.out.println("Range copy of array: " + Arrays.toString(somearr) + "\n");

		// Equals compare
		int[] arr1 = Arrays.copyOf(arr, arr.length);
		System.out.println("Equals: " + Arrays.equals(arr, arr1)); // TRUE
		System.out.println("Equals: " + Arrays.equals(arr, newarr) + "\n"); // FALSE

		// Fill all spaces with a specific element
		Arrays.fill(newarr, 2);
		System.out.println("Filled array: " + Arrays.toString(newarr) + "\n");

		// Find the index of first mismatch between arrays
		int misindex = Arrays.mismatch(arr, arr);
		System.out.println("Mismatch at index: " + misindex);
		misindex = Arrays.mismatch(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 4, 5 });
		System.out.println("Mismatch at index:  " + misindex + "\n");

		// Parallel sort - Dual-Pivot Quicksort - O(N log N)
		int psortarr[] = new int[] { 7, 3, 8, 1, 4, 6, 0 };
		Arrays.parallelSort(psortarr, 0, 4);
		System.out.println("Parallel sort on range: " + Arrays.toString(psortarr) + "\n");

		// Arrays sort - Dual-Pivot Quicksort
		Arrays.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr) + "\n");

	}

}

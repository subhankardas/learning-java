package basics.array;

import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		
		int[] arr = { 12, 78, 43, 24, 57, 90, 63 };

		// Arrays sort
		Arrays.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
		System.out.println("----------------------------");

		// Binary search
		int key = Arrays.binarySearch(arr, 43);
		System.out.println("Binary Search Found @ Index: " + key);
		
	}

}

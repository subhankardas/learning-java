package basics.array;

import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		
		int[] arr = {12, 78, 43, 24, 57, 90, 63 };
		
		// Arrays sort
		Arrays.sort(arr);
		System.out.print("Sorted array: ");
		for(int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("--------------------------------");
		
		// Binary search
		int key = Arrays.binarySearch(arr, 24);
		System.out.println(key);
	}
	
}

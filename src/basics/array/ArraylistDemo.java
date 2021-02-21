package basics.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraylistDemo {

	public static void main(String[] args) {
		
		int[] arr = (int[]) Array.newInstance(int.class, 5);
		List<Integer> list = new ArrayList<>();
		
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Length: " + arr.length);
		System.out.println("List : " + list);
		System.out.println("Length: " + list.size());
		
		int[] oldRef = arr;			// Old reference
		arr = new int[6];			// Create new reference
		int[] newRef = arr; 		// Copy new reference

		System.out.println("----------------------------");
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Length: " + arr.length);
		
		System.out.println("Old reference match: " + (oldRef == arr));
		System.out.println("New reference match: " + (newRef == arr));
		
	}

}

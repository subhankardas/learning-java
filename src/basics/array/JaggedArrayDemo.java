package basics.array;

/**
 * Demo for usage of jagged array.
 * Jagged Array: 2D Array with varying no. of columns in
 * each row. 
 */
public class JaggedArrayDemo {

	public static void main(String[] args) {
		
		final int ROWS = 4;
		int count = 7;
		
		int arr[][] = new int[ROWS][];

		arr[0] = new int[3];
		arr[1] = new int[1];
		arr[2] = new int[2];
		arr[3] = new int[1];

		// Populate the array
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = count;
				count--;
			}
		}
		
		// Display the array elements
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		
	}

}

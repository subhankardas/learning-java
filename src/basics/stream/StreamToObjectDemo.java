package basics.stream;

import java.util.stream.Stream;

/**
 * Mapping a stream of objects to stream of
 * different objects derived from original stream. 
 */
public class StreamToObjectDemo {

	public static void main(String[] args) {

		Stream<Integer> stream = Stream.of(10, 26, 37, 45, 52);
		stream.mapToInt(i -> (i * 2)).forEach(i -> {
			System.out.print(i + " ");
		});
		
		System.out.println();
		System.out.println("---------------------------");
		
		Stream<Test> testStream = Stream.of(new Test(23), new Test(36), new Test(52));
		testStream.map(test -> new Test(test.getVal() + 2)).forEach(test -> {
			System.out.print(test.getVal() + " ");
		});
	}

}

class Test {
	private int val;
	
	public Test(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
	
	public void showVal() {
		System.out.println(val);
	}
}

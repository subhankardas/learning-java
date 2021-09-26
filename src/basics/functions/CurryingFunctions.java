package basics.functions;

import java.util.function.Function;

public class CurryingFunctions {

	public static void main(String[] args) {

		Function<Integer, Function<Integer, Integer>> add = num1 -> num2 -> num1 + num2;
		Function<Integer, Function<Integer, Integer>> subtract = num1 -> num2 -> num1 - num2;

		// Currying functions to apply the operands
		int result1 = add.apply(12).apply(13);
		int result2 = subtract.apply(13).apply(10);

		System.out.println("Result 1 = " + result1);
		System.out.println("Result 2 = " + result2);

	}

}

package basics.misc;

/**
 * JDK 7 onwards it allows us to write numeric literals using the underscore
 * character. Numeric literals are broken to enhance the readability.
 * 
 * Java 9 has made changes in features of java language and eliminating
 * underscore from legal name is a major change made by Oracle.
 */
public class UnderscoreInLiterals {

	public static void main(String[] args) {

		// int _ = 10; // _ is a keyword from Java 9 onwards, cannot be identifier

		int salary = 1_00_00_000;
		System.out.println("Salary	:" + salary);

		long balance = 1_00_00_000;
		System.out.println("Balance :" + balance);

		float bill = 2.10_001F;
		System.out.println("Bill	:" + bill);

		double sum = 2.10_12_001;
		System.out.println("Sum	:" + sum);

	}

}

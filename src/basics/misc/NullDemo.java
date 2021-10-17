package basics.misc;

public class NullDemo {

	static byte byt;
	static int num;
	static float flt;
	static boolean bool;

	static String str;
	static Person person;

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {

		// int numm; // Local variables need to be initialized before use

		// 1. Null is case sensitive
		String str1 = null; // OK
		// String str2 = NULL; // Compile-time Error : Can't find symbol 'NULL'

		// Primitive data type defaults
		System.out.println(byt); // 0
		System.out.println(num); // 0
		System.out.println(flt); // 0.0
		System.out.println(bool); // false

		// 2. Any reference variable in Java has default value null
		System.out.println(str); // null
		System.out.println(person); // null

		// 3. Null is a special value, which can be assigned, type cast to any reference

		// int numm = null; // Not possible for primitive types
		// int numm = (Integer) null; // Null pointer exception

		Object obj = null;
		Integer num1 = null;
		Integer num2 = (Integer) null;

		System.out.println(obj); // null
		System.out.println(num1); // null
		System.out.println(num2); // null

		// 4. Autoboxing and unboxing
		Integer num3 = null; // Autoboxing
		// int num4 = num3; // Unboxing null = Null pointer exception

		// 5. Instance of - null does not refer to any object
		Integer num4 = null;
		Integer num5 = 10;

		System.out.println(num4 instanceof Integer); // FALSE - Reference of null
		System.out.println(num5 instanceof Integer); // TRUE - Reference of integer

		// 6. Static vs non static methods
		NullDemo demo = null;
		demo.staticMethod(); // OK - Can be called using null reference
		// demo.nonStaticMethod(); // Cannot call non static methods - null pointer

		// 7. Comparing null value
		System.out.println(null == null); // TRUE
		System.out.println(null != null); // FALSE

	}

	public void nonStaticMethod() {
		System.out.println("Non-static method() called.");
	}

	public static void staticMethod() {
		System.out.println("Static method() called.");
	}

}

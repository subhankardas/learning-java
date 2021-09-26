package basics.string;

/**
 * Java String Pool — the special memory region where Strings are stored by the
 * JVM.
 * 
 * 1. Thanks to the immutability of Strings in Java, the JVM can optimize the
 * amount of memory allocated for them by storing only one copy of each literal
 * String in the pool. This process is called interning. This is always
 * preferred as its more optimized.
 * 
 * 2. When we create a String via the new operator, the Java compiler will
 * create a new object and store it in the heap space reserved for the JVM.
 * Every String created like this will point to a different memory region with
 * its own address.
 * 
 * 3. Before Java 7, the JVM placed the Java String Pool in the PermGen space,
 * which has a fixed size — it can't be expanded at runtime and is not eligible
 * for garbage collection.
 * 
 * The risk of interning Strings in the PermGen (instead of the Heap) is that we
 * can get an OutOfMemory error from the JVM if we intern too many Strings.
 * 
 * From Java 7 onwards, the Java String Pool is stored in the Heap space, which
 * is garbage collected by the JVM. The advantage of this approach is the
 * reduced risk of OutOfMemory error because unreferenced Strings will be
 * removed from the pool, thereby releasing memory.
 */
public class StringDemo {

	public static void main(String args[]) {

		// 1. String new string literal
		String str1 = "SOME TEXT";
		System.out.println(str1);

		// 2. Create new string object
		String str2 = new String("NEW STRING");
		System.out.println(str2);

		// 3. Create string from byte[] i.e ASCII values
		byte[] data = { 65, 66, 67, 88, 89, 90 };
		String str3 = new String(data);
		System.out.println(str3);

		// 4. Create string from char[]
		char[] chars = { 'H', 'E', 'Y' };
		String str4 = new String(chars);
		System.out.println(str4);

		// 5. Create string from string buffer
		String str5 = new String(new StringBuffer("STR BUFF TEXT"));
		System.out.println(str5);

		// 6. Create string from string builder
		String str6 = new String(new StringBuilder("STR BUILD TEXT"));
		System.out.println(str6);

		System.out.println("---------------------------");

		// Interning - Only one reference exists in string pool and reference is shared
		String const1 = "SOME TEXT";
		String const2 = "SOME TEXT";
		System.out.println(const1 == const2); // TRUE - same reference - interned constant

		String const3 = "SAME TEXT";
		String const4 = new String("SAME TEXT");
		System.out.println(const3 == const4); // FALSE - new() always creates new object

		String const5 = new String("SAME TEXT");
		String const6 = new String("SAME TEXT");
		System.out.println(const5 == const6); // FALSE - new() always creates new object

		// Manual interning
		String const7 = "TEXT";
		String const8 = new String("TEXT").intern();
		System.out.println(const7 == const8); // TRUE - manually interned

	}

}

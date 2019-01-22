package basics.string;

public class StringBufferDemo {

	public static void main(String args[]) {
		StringBuffer str = new StringBuffer();
		int lastCapacity = 0;
		
		/**
		 * String buffer is a thread safe implementation and can be
		 * used in multi-threaded applications. 
		 * By default capacity increases by 2 x prev. capacity + 2
		 */
		System.out.println("Initial length: " + str.length());
		System.out.println("Initial capacity: " + str.capacity());
		System.out.println("Increase capacity by: " + (str.capacity() - lastCapacity));
		lastCapacity = str.capacity();
		System.out.println("----------------------------------");
		
		str.append("Hello World! ");
		
		System.out.println("Value: " + str);
		System.out.println("Length: " + str.length());
		System.out.println("Capacity: " + str.capacity());
		System.out.println("Increase capacity by: " + (str.capacity() - lastCapacity));
		
		lastCapacity = str.capacity();
		System.out.println("----------------------------------");
		
		str.append("Greetings ");
		
		System.out.println("Value: " + str);
		System.out.println("Length: " + str.length());
		System.out.println("Capacity: " + str.capacity());
		System.out.println("Increase capacity by: " + (str.capacity() - lastCapacity));
		lastCapacity = str.capacity();
		System.out.println("----------------------------------");
		
		str.append("fellow developers");
		
		System.out.println("Value: " + str);
		System.out.println("Length: " + str.length());
		System.out.println("Capacity: " + str.capacity());
		System.out.println("Increase capacity by: " + (str.capacity() - lastCapacity));
		lastCapacity = str.capacity();
		System.out.println("----------------------------------");
		
	}
	
}

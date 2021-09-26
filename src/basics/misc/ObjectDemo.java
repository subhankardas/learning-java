package basics.misc;

import java.lang.reflect.InvocationTargetException;

/**
 * A class is a user defined blueprint or prototype from which objects are
 * created. It represents the set of properties or methods that are common to
 * all objects of one type.
 * 
 * Demonstrates the object class, static blocks, instance initializer block and
 * cloneable interface.
 * 
 * When we allocate the object using new(), the object is allocated on Heap,
 * otherwise on Stack if not global or static. So the object is always allocated
 * memory on heap.
 */
public class ObjectDemo {

	public static void main(String args[])
			throws CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// 1. Object creation using new keyword
		Product product1 = new Product(123, 456, "Spices");

		// 2. Object creation using reflection API
		Product product2 = Product.class.getConstructor(int.class, int.class, String.class).newInstance(123, 890,
				"Rice");

		// 3. Object creation using clone() method
		Product product3 = (Product) product2.clone();

		// Hash codes will be same as hashCode() returns ID, which is same
		System.out.println("------------------------------");
		System.out.println("Hash code product 1: " + product1); // basics.misc.Product@7b
		System.out.println("Hash code product 2: " + product2); // basics.misc.Product@7b
		System.out.println("Hash code product 3: " + product3); // basics.misc.Product@7b

		System.out.println("------------------------------");
		System.out.println(product1.equals(product1)); // Same reference - true
		System.out.println(product1.equals(product2)); // Custom implementation for equals - true
		System.out.println(product1.equals("product2")); // Not of similar type - false
		System.out.println("------------------------------");

		product1 = null; // Reference nullified
		System.gc();

		System.out.println(product3.name); // Rice - product3 points to product2 reference

		System.out.println(product3.getClass()); // basics.misc.Product
	}

}

class Product implements Cloneable {

	int id;
	int price;
	String name;

	// Static block
	static {
		System.out.println("Static block called only once and first of all");
	}

	// Instance initializer block
	{
		System.out.println("Instance initializer block is called next and before constructor");
	}

	public Product(int id, int price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;

		System.out.println("Constructor called for " + name);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		// Reference is same
		if (this == obj) {
			System.out.print("Same reference - ");
			return true;
		}

		// Not of same type
		if (!(obj instanceof Product)) {
			System.out.print("Not of similar type - ");
			return false;
		}

		// Custom implementation for equals
		System.out.print("Custom implementation for equals - ");
		Product product = (Product) obj;
		return (id == product.id);
	}

	@Override
	protected void finalize() {
		System.out.println("Called before " + this.name + " is garbage collected!");
	}

}

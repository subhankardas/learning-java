package basics;

/**
 * Demonstrates the object class, static blocks,
 * instance initializer block and cloneable interface.
 */
public class ObjectDemo {

	public static void main(String args[]) throws CloneNotSupportedException {
		Product product1 = new Product(123, 456, "Spices");
		Product product2 = new Product(123, 890, "Rice");
		
		Product product3 = (Product) product2.clone();
		
		System.out.println("------------------------------");
		System.out.println("Hash code product 1: " + product1);
		System.out.println("Hash code product 2: " + product2);
		
		System.out.println("------------------------------");
		System.out.println(product1.equals(product1));
		System.out.println(product1.equals(product2));
		System.out.println(product1.equals("product2"));
		System.out.println("------------------------------");
		
		product1 = null; // Reference nullified
		System.gc();
		
		System.out.println(product3.name);
		System.out.println(product3.getClass());
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
			System.out.println("Same reference");
			return true;
		}
		
		// Not of same type
		if (!(obj instanceof Product)) {
			System.out.println("Not of similiar type");
			return false;
		}
		
		// Custom implementation for equals
		System.out.println("Custom impl for equals");
		Product product = (Product) obj;
		return (id == product.id);
	}
	
	@Override
	protected void finalize() {
		System.out.println("Called before " + this.name + " is garbage collected!");
	}
	
}

package basics.inheritance;

/**
 * Bounded parameters: Restricting the generic type class
 * to accept the parameter for a specific type only. Other
 * type of parameter will throw compile time error.
 */
public class BoundedParam {

	public static void main(String[] args) {
		B var = new B(10);
		Driver<B> driver = new Driver<>(var);
		
		System.out.println("Value=" + driver.doValue());
		System.out.println("Square value= " + driver.doSquare());
	}

}

class Driver<T extends B> {
	T obj;
	
	public Driver(T obj) {
		this.obj = obj;
	}
	
	public int doValue() {
		return obj.getValue();
	}
	
	public int doSquare() {
		return obj.getSquare();
	}
}

class A {
	public int value;
	
	public int getValue() {
		return this.value;
	}
}

class B extends A {
	B(int value) {
		this.value = value;
	}

	public int getSquare() {
		return getValue() * getValue();
	}
}
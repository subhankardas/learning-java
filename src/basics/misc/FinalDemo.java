package basics.misc;

public class FinalDemo {

	final static int CONSTANT = 10;

	// Blank final variable, only initialize in constructor
	final int NEW_VALUE;

	// Static blank final variable, only initialize in static block
	static final int STATIC_FINAL;

	static {
		STATIC_FINAL = 2;
	}

	public FinalDemo() {
		// 1. Final variables can be assigned only in constructor if unassigned
		NEW_VALUE = 12;
	}

	public static void update() {
//		CONSTANT = 12;  // 1. Cannot update final, once assigned a value can never be changed
	}

	class Home {
		// 2. Final methods cannot be overridden in child class
		final void login() {
			System.out.println("Login user!");
		}
	}

	// 3. Final classes cannot be inherited
	final class Garden {

	}

}

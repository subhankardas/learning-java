package basics.inheritance;

public class InheritanceDemo {

	public static void main(String[] args) {
		Derived derived = new Derived();
		System.out.println("------------------------------");

		Base base = new Derived();
		System.out.println("------------------------------");

		base = new Derived(101);

		System.out.println("------------------------------");
		Base base1 = new Base();

		System.out.println("------------------------------");
		base.calc(20); // Calls derived's calc()
		base1.calc(30); // Calls base's calc()

		derived.value(12);
		derived.extra();

		// base.extra(); // Not available for Base class
	}

}

class Base {
	Base() {
		System.out.println("Base constructor called.");
	}

	Base(int x) {
		System.out.println("Base constructor: " + x);
	}

	public void calc(int x) {
		System.out.println("Base calc(): " + x);
	}

	// Cannot be overridden
	final void value(int x) {
		System.out.println("Base value(): " + x);
	}

	// Not visible outside base class
	@SuppressWarnings("unused")
	private void privateMethod() {
		System.out.println("Base private func()");
	}
}

class Derived extends Base {
	Derived() {
		System.out.println("Derived constructor called.");
	}

	Derived(int x) {
		super(x); // Explicitly required to call super class constructor
		System.out.println("Derived constructor: " + x);
	}

	@Override
	public void calc(int x) {
		System.out.println("Derived calc(): " + x);
	}

	// Can't override final method of base class
	// @Override
	// final void value(int x) {
	// System.out.println("Base value(): " + x);
	// }

	public void extra() {
		System.out.println("Derived extra func()");
	}
}
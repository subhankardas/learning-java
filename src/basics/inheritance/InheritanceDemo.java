package basics.inheritance;

/**
 * Inheritance the mechanism in Java by which one class is allowed to inherit
 * the features(fields and methods) of another class.
 * 
 * Reusability: Inheritance supports the concept of “reusability”, i.e. when we
 * want to create a new class and there is already a class that includes some of
 * the code that we want, we can derive our new class from the existing class.
 * By doing this, we are reusing the fields and methods of the existing class.
 * 
 * 1. Except Object class, which has no superclass, every class has one and only
 * one direct superclass (single inheritance). In the absence of any other
 * explicit superclass, every class is implicitly a subclass of the Object
 * class.
 * 
 * 2. A superclass can have any number of subclasses. But a subclass can have
 * only one superclass. This is because Java does not support multiple
 * inheritances with classes.
 * 
 * 3. A subclass inherits all the members (fields, methods, and nested classes)
 * from its superclass. Constructors are not members, so they are not inherited
 * by subclasses, but the constructor of the superclass can be invoked from the
 * subclass.
 * 
 * 4. A subclass does not inherit the private members of its parent class.
 * However, if the superclass has public or protected methods(like getters and
 * setters) for accessing its private fields, these can also be used by the
 * subclass.
 */
public class InheritanceDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		Derived derived = new Derived();
		System.out.println("------------------------------");

		Base baseDerived = new Derived();
		System.out.println("------------------------------");

		baseDerived = new Derived(101);
		System.out.println("------------------------------");

		Base base = new Base();
		System.out.println("------------------------------");

		baseDerived.calc(20); // Calls derived's calc()
		base.calc(30); // Calls base's calc()

		derived.value(12); // Base value()
		derived.extra(); // Derived extra()

		// base.extra(); // Not available for Base class

		// Static method calls are always refers to instance class not object

		baseDerived.print(); // Calls base print(), even though refers derived object
		derived.print(); // Calls derived print(), refers to derived object

		System.out.println("------------------------------");
		System.out.println(base instanceof Base); // TRUE
		System.out.println(base instanceof Derived); // FALSE

		System.out.println(derived instanceof Base); // TRUE
		System.out.println(derived instanceof Derived); // TRUE

		System.out.println(baseDerived instanceof Base); // TRUE
		System.out.println(baseDerived instanceof Derived); // TRUE

	}

}

class Base {

	Base() {
		System.out.println("Base constructor called.");
	}

	Base(int x) {
		System.out.println("Base constructor: " + x);
	}

	// 1. Can be overridden
	public void calc(int x) {
		System.out.println("Base calc(): " + x);
	}

	// 2. Cannot be overridden due to FINAL
	final void value(int x) {
		System.out.println("Base value(): " + x);
	}

	// 3. Not visible outside base class as it is PRIVATE
	@SuppressWarnings("unused")
	private void privateMethod() {
		System.out.println("Base private func()");
	}

	// 4. Method hiding using STATIC methods which are not polymorphic
	public static void print() {
		System.out.println("Base print() func");
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

	// Overriding base calc() by new implementation
	@Override
	public void calc(int x) {
		System.out.println("Derived calc(): " + x);
	}

	// Can't override final method of base class
	// @Override
	// final void value(int x) {
	// System.out.println("Base value(): " + x);
	// }

	public static void print() {
		System.out.println("Derived print() func");
	}

	public void extra() {
		System.out.println("Derived extra func()");
	}
	
}
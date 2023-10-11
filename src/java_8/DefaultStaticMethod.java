package java_8;

/**
 * Before Java 8, interfaces could have only public abstract methods. It was not
 * possible to add new functionality to the existing interface without forcing
 * all implementing classes to create an implementation of the new methods, nor
 * was it possible to create interface methods with an implementation.
 * 
 * Starting with Java 8, interfaces can have static and default methods that,
 * despite being declared in an interface, have a defined behavior.
 */

/* BEFORE JAVA 8 */
interface Hello {
    String sayHello(String name); // Public abstract method

    // void newMethod(); // ADDING NEW METHOD, WILL BREAK ALL IMPLEMENTING CLASSES
    // UNTIL ITS IMPLEMENTED IN ALL CLASSES.
}

class HelloImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}

/* AFTER JAVA 8 */
interface HelloJ8 {
    String sayHello(String name);

    // These are accessible through the instance of the implementing class and can
    // be overridden.
    default void newMethod() {
        System.out.println("New method called!");
    }

    // Available only through and inside of an interface. It can’t be overridden by
    // an implementing class.
    static int staticMethod() {
        System.out.println("Static method called!");
        return 10;
    }
}

class HelloJ8Impl implements HelloJ8 {
    @Override
    public String sayHello(String name) {
        return "Hey " + name;
    }

    @Override
    public void newMethod() {
        System.out.println("New method2 called!");
    }
}

public class DefaultStaticMethod {

    public static void main(String[] args) {
        HelloJ8 helloJ8 = new HelloJ8Impl();

        helloJ8.newMethod(); // Default method needs to be called through an instance.

        HelloJ8.staticMethod(); // Static method can be called directly.
//      helloJ8.staticMethod(); // Static method cannot be called through an instance.
    }

}

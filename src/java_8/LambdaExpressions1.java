package java_8;

/**
 * Lambda expressions basically express instances of functional interfaces (An
 * interface with a single abstract method is called a functional interface).
 * Lambda Expressions in Java are the same as lambda functions which are the
 * short block of code that accepts input as parameters and returns a resultant
 * value.
 */

/** Functional interface. Interface with a single abstract method. */
@FunctionalInterface // This is optional but ensures that the interface is functional always.
interface Hello {
    String sayHello(String name); // Abstract method

    default String sayBye(String name) { // Non-abstract method
        return "Bye " + name;
    }

    // String sayHi(String name); // Not allowed because of @FunctionalInterface
}

public class LambdaExpressions1 {

    static String sayHi(String name) {
        return "Hi " + name;
    }

    public static void main(String[] args) {
        // Traditional anonymous inner class
        Hello tHello = new Hello() {
            @Override
            public String sayHello(String name) {
                return "Hello " + name;
            }
        };
        System.out.println(tHello.sayHello("Joe!"));

        // Equivalent lambda expressions
        Hello lHello = (name) -> "Hey " + name;
        System.out.println(lHello.sayHello("Jacky!"));

        Hello nHello = (param) -> sayHi(param);
        System.out.println(nHello.sayHello("Johnny!"));
    }

}
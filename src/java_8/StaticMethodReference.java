package java_8;

import java.util.concurrent.Callable;

interface Worker {
    static void work() { // Static method
        System.out.println("Working...");
    }
}

@FunctionalInterface
interface FuncInterface {
    void func(); // Functional method
}

public class StaticMethodReference {

    static void funcImpl() { // Static method 1
        System.out.println("Hello from func!");
    }

    static Integer funcImplInt() { // Static method 2
        return 123;
    }

    public static void main(String[] args) throws Exception {
        new Thread(Worker::work).start(); // Using static method reference

        // Defined a functional interface and referring a static method to it's
        // functional method.
        FuncInterface obj = StaticMethodReference::funcImpl;
        obj.func();

        // Implement the runnable functional interface
        Runnable methRef = StaticMethodReference::funcImpl;
        methRef.run();

        // Implement the callable functional interface
        Callable<Integer> methRef1 = StaticMethodReference::funcImplInt;
        System.out.println(methRef1.call());
    }

}

package java_9;

interface MyInterface {
    private void privMeth() { // Private method inside interface
        System.out.println("Private method called!");
    }

    default void defMeth() {
        privMeth();
    }
}

class MyClass implements MyInterface {

}

public class PrivateMethodInterface {

    public static void main(String[] args) {
        MyInterface obj = new MyClass();
        obj.defMeth();
    }

}

## New Features in Java 8

1. Stream API: The stream functionality – java.util.stream – which contains classes for processing sequences of elements.
2. Lambda expressions: Lambda expressions allow you to define inline, anonymous functions. They are often used to implement functional interfaces.
3. Functional Interfaces: Functional interfaces have exactly one abstract method and can be used with lambda expressions.
4. Interface Default and Static Methods:
    1. Default methods: These are accessible through the instance of the implementing class and can be overridden. Interfaces can have concrete methods with default implementations.
    2. Static methods: Available only through and inside of an interface. It can’t be overridden by an implementing class.
5. Method references: The reference to a static method holds the syntax *ContainingClass::methodName*.
6. Optional: Optional is a container that may or may not contain a non-null value. It helps prevent null pointer exceptions.
7. Functional Interfaces in java.util.function Package: Java 8 introduced several functional interfaces in the java.util.function package, such as Predicate, Function, Consumer, and Supplier.
8. New Date and Time API: Java 8 introduced a modern date and time API in the java.time package.
9. Default Methods for Sorting in Collections: The List, Set, and Map interfaces got default methods for sorting elements.
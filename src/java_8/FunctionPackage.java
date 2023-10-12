package java_8;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Functional Interfaces in java.util.function Package:
 * Java 8 introduced several functional interfaces in the java.util.function
 * package, such as Predicate, Function, Consumer, and Supplier.
 */
public class FunctionPackage {

    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0; // Func interface with one parameter boolean value
        System.out.println(isEven.test(3)); // false
        System.out.println(isEven.test(4)); // true

        Function<Integer, Integer> square = n -> n * n; // Func interface with one input and output value
        System.out.println(square.apply(3)); // 9
        System.out.println(square.apply(4)); // 16

        Consumer<Integer> print = i -> System.out.print(i + ", "); // Func interface with one input and no output value
        Arrays.asList(1, 2, 3).forEach(print);
        print.accept(4);

        Supplier<Long> gen = () -> System.currentTimeMillis(); // Func interface with no input and output value
        System.out.println("\n" + gen.get());
    }

}

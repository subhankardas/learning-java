package java_8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemo2 {

    public static void main(String[] args) {
        reference();
    }

    /*
     * 2. Stream Pipeline - We can instantiate a stream, and have an accessible
     * reference to it, as long as only intermediate operations are called.
     * Executing a terminal operation makes a stream inaccessible.
     */
    public static void reference() {
        Stream<String> stream = Stream.of("A", "B", "C").filter(s -> s.contains("B"));
        Optional<String> anyElem = stream.findAny(); // THIS IS A TERMINAL OPERATION - closes the stream

        // Stream cannot be referenced after it is closed
        // Optional<String> firstElem = stream.findFirst(); // THROWS EXCEPTION

        // This kind of behavior is logical. We designed streams to apply a finite
        // sequence of operations to the source of elements in a functional style, not
        // to store elements.

        // NOW LET'S MAKE ABOVE CODE WORK!
        List<String> list = Stream.of("A", "B", "C").filter(s -> s.contains("B")).collect(Collectors.toList());
        Optional<String> anyElem1 = list.stream().findAny();
        Optional<String> firstElem = list.stream().findFirst();

        // Stream Pipeline - To perform a sequence of operations over the elements of
        // the data source and aggregate their results, we need three parts: the source,
        // intermediate operation(s) and a terminal operation.
        // We can only use one terminal operation per stream.

        long size = Arrays.asList(0, null, 1, 3, 2).stream() // open stream from source
                .skip(1) // apply intermediate operations
                .filter(i -> i != null)
                .map(i -> i + 1).sorted()
                .count(); // apply terminal operation

        // Lazy Invocation - Intermediate operations are not executed until it is
        // necessary for the terminal operation execution.

        Stream.of(1, 2, 3, 4).filter(i -> {
            System.out.println("filter invoked"); // here we assume that filter is invoked 4 times but the filter is
                                                  // never invoked, since there is no terminal operation
            return i % 2 == 0;
        });

        size = Stream.of(1, 2, 3, 4)
                .filter(i -> {
                    System.out.println("filter invoked"); // invoked 4 times
                    return i % 2 == 0;
                })
                .map(i -> {
                    System.out.println("map invoked"); // invoked 2 times
                    return i * 2;
                }).count(); // terminal operation
    }

}

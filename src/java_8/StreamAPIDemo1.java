package java_8;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Java streams represent a pipeline through which data will flow and the
 * functions to operate on the data. A pipeline in this instance consists of a
 * stream source, followed by zero or more intermediate operations, and a
 * terminal operation.
 * 
 * Java streams enable functional-style operations on streams of elements. A
 * stream is an abstraction (interface) of a non-mutable collection of functions
 * applied in some order to the data.
 * 
 * A stream is not a collection where you can store elements.
 */
public class StreamAPIDemo1 {

    public static void main(String[] args) {
        creation();

    }

    /*
     * 1. Stream creation - ways to create a stream instance of different sources.
     * Once created, the instance will not modify its source, therefore allowing the
     * creation of multiple instances from a single source.
     */
    public static void creation() {
        // 1. Empty stream, no elements(len=0), avoids null(empty != null)
        Stream<String> emptyStream = Stream.empty();

        // 2. Using Stream of() method - create a stream interface from array as source
        String[] strarr = new String[] { "A", "B", "C", "D", "E" };
        Stream<String> streamOfArr = Stream.of(strarr);

        // 3. Using stream() method - create a stream interface from array with range
        Stream<String> arrsStream = Arrays.stream(strarr, 1, 3);

        // 4. Stream from collection - stream() is added to the Collection interface
        Collection<Integer> coll = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> intStream = coll.stream();

        // 5. Using builder
        Stream<String> builderStream = Stream.<String>builder().add("A").add("B").add("C").build();

        // 6. Using generate() - method accepts a Supplier<T> for element generation
        Stream<String> generateStream = Stream.generate(() -> "element").limit(5);

        // 7. Using iterate() - creates a stream from an initial value
        Stream<Integer> iteratedStream = Stream.iterate(40, n -> n + 2).limit(3);

        // 8. Stream of primitives
        IntStream intStream1 = IntStream.range(1, 5); // 5 is not inclusive
        LongStream longStream = LongStream.rangeClosed(1, 5); // 5 is inclusive
    }

}
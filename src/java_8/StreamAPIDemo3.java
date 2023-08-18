package java_8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIDemo3 {

    public static void main(String[] args) {
        reduction();
    }

    /**
     * Stream Reduction - Customize a Stream's reduction mechanism apart from the
     * predefined implementations of the Stream interface like count(), max(),
     * min(), and sum().
     */
    public static void reduction() {
        // 1. reduce() method
        int res = Stream.of(1, 2, 3)
                .reduce(0, // identity = default value for empty stream
                        (a, b) -> a + b, // accumulator = logic to aggregate elements
                        (a, b) -> { // combiner = logic to combine results from different threads
                            System.out.println("combiner called"); // hence not called for non-parallel stream
                            return a + b;
                        });

        res = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(0, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner called"); // combiner called for parallel stream
                    return a + b;
                });

        // 2. collect() method
        List<String> fruits = Arrays.asList("Mango", "Orange", "Apple").stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        double avg = IntStream.rangeClosed(1, 5).boxed()
                .collect(Collectors.averagingInt(Integer::intValue)); // collect average of int stream

        List<Product> list = Arrays.asList(new Product("p1", 10), new Product("p2", 20), new Product("p3", 10));
        int sum = list.stream()
                .collect(Collectors.summingInt(Product::getPrice)); // collect sum of int stream

        IntSummaryStatistics stat = list.stream()
                .collect(Collectors.summarizingInt(Product::getPrice)); // collect statistics of stream
        System.out.println(stat + "     Max: " + stat.getMax());

        Map<Integer, List<Product>> grouped = list.stream()
                .collect(Collectors.groupingBy(Product::getPrice)); // collect to group by elements of stream
        System.out.println(grouped);

        Map<Boolean, List<Product>> partitioned = list.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 10)); // collect to partitioned by predicate
        System.out.println(partitioned);

        // 3. Custom collector implementation
        Collector<Product, ?, Map<String, String>> collectToProductMap = Collector.of(
                () -> new HashMap<>(), // identity
                (m, p) -> m.put(p.getName(), p.getPrice() + "-" + p.getName()), // accumulator
                (m1, m2) -> { // combiner
                    m1.putAll(m2);
                    return m1;
                });

        Map<String, String> prodMap = list.stream()
                .collect(collectToProductMap); // collect using custom collector
        System.out.println(prodMap);
    }

}

class Product {
    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{product:" + name + ", price:" + price + "}";
    }
}
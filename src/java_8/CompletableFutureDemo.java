package java_8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Future interface was added in Java 5 to serve as a result of an
 * asynchronous computation, but it did not have any methods to combine the
 * steps involved in computations or handle possible errors.
 * 
 * Java 8 introduced the CompletableFuture class. Along with the Future
 * interface, it also implemented the CompletionStage interface. This interface
 * defines the contract for an asynchronous computation step that we can combine
 * with other steps.
 * 
 * Future is a blocking API, whereas CompletableFuture is non-blocking. With a
 * Future object, you must call the get() method to retrieve the result, but
 * this method blocks until the result is available. In contrast, with a
 * CompletableFuture object, you can use various non-blocking methods to
 * retrieve the result, such as thenApply(), thenAccept(), or join().
 */
public class CompletableFutureDemo {

    // 1. Using CompletableFuture as a simple Future.
    // Return a Future instance using CompletableFuture.
    public static Future<Integer> square(int num) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        Thread.sleep(300l); // Simulate some processing
        future.complete(num * num);

        return future;
    }

    // 2. If we already know the result of a computation.
    // completedFuture() returns result of the computation.
    public static String getResult() throws InterruptedException, ExecutionException {
        Future<String> future;

        Thread.sleep(300l); // Simulate some processing
        future = CompletableFuture.completedFuture("Hello World!");

        return future.get();
    }

    // 3. Using CompletableFuture with chaining of asynchronous processes.
    // The thenAccept method receives a Consumer and passes it the result of the
    // computation.
    public static Future<String> asyncProcessApply() {
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> "Hi, ");
        CompletableFuture<String> step2 = step1.thenApply(result -> result + "there! "); // Apply function with the
                                                                                         // results from step1
        CompletableFuture<String> step3 = step2.thenApply(result -> result + "John."); // Apply function with the
                                                                                       // results from step2
        return step3;
    }

    // 4. If we don’t need to return a value down the Future chain, we can use
    // thenAccept method. The thenAccept method receives a Consumer and passes it
    // the result of the computation.
    public static void asyncProcessAccept() throws InterruptedException, ExecutionException {
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> "Nice to ");
        CompletableFuture<String> step2 = step1.thenApply(result -> result + "meet you.");

        step2.thenAccept(result -> { // Accept function with the results from step2, pass the result to the Future
                                     // chain for further processing
            System.out.println(result); // Cannot return result from thenAccept
        });

        CompletableFuture<String> step3 = step2.thenApply(res -> res + " John."); // Again apply the result from step2
        System.out.println(step3.get());
    }

    // 5. Using CompletableFuture with chaining of asynchronous processes.
    // Both thenApply(map) and thenCompose (flatMap) methods receive a function and
    // apply it to the computation result, but the thenCompose (flatMap) method
    // receives a function that returns another object of the same type.
    // Use thenApply if we need to transform the result, use thenCompose if we want
    // to flatten and return a Future with the result directly, rather than a nested
    // future as we observed in thenApply().
    public static void asyncProcessCompose() throws InterruptedException, ExecutionException {
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> "I am ");
        CompletableFuture<Integer> step2 = step1
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> (result + "John.").length()));

        System.out.println(step2.get());
    }

    // 6. If we want to execute two independent Futures and do something with their
    // results, we can use the thenCombine method that accepts a Future and a
    // Function with two arguments to process both results.
    public static void combineFutures() throws InterruptedException, ExecutionException {
        CompletableFuture<String> step1 = CompletableFuture.supplyAsync(() -> " a string.");
        CompletableFuture<String> step2 = step1.thenCombine(CompletableFuture.supplyAsync(() -> "This is"),
                (result1, result2) -> result2 + result1); // Combine function with the results from step1 and step2

        System.out.println(step2.get());
    }

    // 7. Combine multiple futures in parallel, and return the combined results.
    public static void processMultipleFuturesParallel() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Task 1 result";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "Task 2 result";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "Task 3 result";
        });

        // Combine all futures [The limitation of this method is that it does not return
        // the combined results of all Futures]
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.get();

        System.out.println("Task1 done: " + future1.isDone() + " Task2 done: " + future2.isDone() + " Task3 done: "
                + future3.isDone());

        // Combine all futures in parallel, and return the combined results using join
        // and streams to collect the results.
        String results = Stream.of(future1, future2, future3)
                .map(future -> future.join())
                .collect(Collectors.joining("------"));
        System.out.println(results);
    }

    public static void main(String[] args) throws Exception {
        Future<Integer> future = square(3);
        System.out.println(future.get());

        System.out.println(getResult());
        System.out.println(asyncProcessApply().get());
        asyncProcessAccept();
        asyncProcessCompose();
        combineFutures();
        processMultipleFuturesParallel();
    }

}

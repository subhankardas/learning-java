package executor_service;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleFutureDemo {

    // 1. Create an ExecutorService instance (with a single thread).
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    // 2. Return a Future instance from a Callable implementation.
    public static Future<String> square(int num) {
        return executor.submit(() -> { // Implement call method using lambda
            Thread.sleep(1000l);
            return "Result: " + (num * num);
        });
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // -------- CREATE AND CONSUME A FUTURE TASK -------- //
        Future<String> futureResult1 = square(3);
        while (!futureResult1.isDone()) {
            System.out.println("Waiting for square task to process...");
            Thread.sleep(300);
        }
        String result1 = futureResult1.get();
        System.out.println(result1);

        // -------- CANCEL A FUTURE TASK -------- //
        Future<String> futureResult2 = square(4);
        futureResult2.cancel(true);

        try { // To get result of cancelled task
            futureResult2.get(); // Will throw CancellationException
        } catch (CancellationException e) {
            System.out.println("CancellationException");
        }

        // -------- SHUTDOWN THE EXECUTOR -------- //
        executor.shutdown();
    }

}

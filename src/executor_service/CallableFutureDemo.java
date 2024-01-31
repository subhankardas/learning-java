package executor_service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// --- 1. Create a Callable implementation --- //
class MyTask implements Callable<Integer> {

    private String input;

    public MyTask(String input) {
        this.input = input;
    }

    @Override
    public Integer call() throws Exception {
        // Simulate a long-running task with random delay
        Thread.sleep((long) (Math.random() * 2000 + 500));
        System.out.println("Task completed in thread: " + Thread.currentThread().getName() + " for input: " + input);
        return Integer.valueOf(input.length());
    }

}

public class CallableFutureDemo {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 2. Create instances of tasks
        MyTask task1 = new MyTask("Hello");
        MyTask task2 = new MyTask("Hi");
        MyTask task3 = new MyTask("World!!");

        // 3. Submit tasks to executor
        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);
        Future<Integer> result3 = executor.submit(task3);

        // 4. Wait for results
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

        // 5. Shutdown executor service
        executor.shutdown();
    }

}

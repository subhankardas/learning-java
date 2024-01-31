package executor_service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// --- 1. Create a Runnable implementation --- //
class MyTaskRunnable implements Runnable {

    private String input;

    public MyTaskRunnable(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("Task completed in thread: " + Thread.currentThread().getName() + " for input: " + input);
        System.out.println(Integer.valueOf(input.length()));
    }

}

public class RunnableFutureDemo {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 2. Create instances of tasks
        Runnable task1 = new MyTaskRunnable("Hello");
        Runnable task2 = new MyTaskRunnable("Hi");
        Runnable task3 = new MyTaskRunnable("World!!");

        Runnable task4 = () -> { // Using lambda to implement Runnable interface
            System.out.println("Task completed in thread: " + Thread.currentThread().getName());
            System.out.println("This is a new task!");
        };

        // 3. Submit tasks to executor service
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);

        // 4. Shutdown executor service
        executor.shutdown();
    }

}

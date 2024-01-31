package executor_service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 * In this example we use ExecutorService to run demo functionalities like
 * invokeAny, invokeAll and execute for different tasks.
 */
public class ExecutorServiceDemo {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // 1. Create a collection of callable tasks
        Set<Callable<String>> tasks = new HashSet<>();
        tasks.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(100l); // Simulate a slow running task
                return "Task 1";
            }
        });
        tasks.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2"; // Simulate a fast running task
            }
        });

        // ----- DEMONSTRATE EXECUTOR SERVICE FUNCTIONS ----- //

        String result = executor.invokeAny(tasks); // [1] INVOKE ALL TASKS, RETURNS FIRST COMPLETED WITHOUT EXCEPTION,
                                                   // OTHERS RUNNING TASKS ARE CANCELLED
        System.out.println("Any result = " + result);

        List<Future<String>> results = executor.invokeAll(tasks); // [2] INVOKE ALL TASKS, RETURNS WHEN ALL TASKS ARE
                                                                  // COMPLETED SUCCESSFULLY OR WITH EXCEPTION
        for (Future<String> future : results) {
            System.out.println("All result = " + future.get());
        }

        executor.execute(new Runnable() { // [3] EXECUTE A TASK IN A SEPARATE THREAD AS PER THE CONFIGURED EXECUTOR
                                          // SERVICE. THIS ONLY ACCEPTS A SINGLE RUNNABLE TASK.
            public void run() {
                System.out.println("Execute    = Task 3");
            }
        });

        executor.shutdown();
    }

}

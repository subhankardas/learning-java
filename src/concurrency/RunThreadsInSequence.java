package concurrency;

/**
 * Run threads in sequence in Java - Can we run multiple threads in a sequence?
 * 
 * How to ensure that threads run in sequence is a very popular Java
 * multi-threading interview question. Though it doesn’t make much sense
 * practically to do that as you use threads so that processing can be done by
 * many threads simultaneously.
 * 
 * join() method is used when you want to wait for the thread to finish. Its
 * general form is–
 * 
 * public final void join() throws InterruptedException
 * 
 * This method waits until the thread on which it is called terminates.
 */
public class RunThreadsInSequence {

	public static void main(String[] args) throws InterruptedException {

		Thread th1 = new Thread(new RTISThread1());
		Thread th2 = new Thread(new RTISThread2());

		th1.start();
		th1.join();

		th2.start();
		th2.join();

	}

}

class RTISThread1 implements Runnable {

	@Override
	public void run() {
		for (int idx = 1; idx <= 5; idx++) {
			System.out.println("Inside TH 1 > ----- TASK 1");
		}
		System.out.println("TASK 1 ENDED!");
	}

}

class RTISThread2 implements Runnable {

	@Override
	public void run() {
		for (int idx = 1; idx <= 10; idx++) {
			System.out.println("Inside TH 2 > ------------ TASK 2");
		}
		System.out.println("TASK 2 ENDED!");
	}

}
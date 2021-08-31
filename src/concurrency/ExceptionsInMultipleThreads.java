package concurrency;

/**
 * Using exceptions in a multithreaded program - Can an exception thrown in one
 * thread be caught inside another thread?
 * 
 * The current exception-handling implementation is safe for multithreading;
 * exceptions in one thread do not interfere with exceptions in other threads.
 * However, you cannot use exceptions to communicate across threads; an
 * exception thrown from one thread cannot be caught in another.
 */
public class ExceptionsInMultipleThreads {

	public static void main(String[] args) {

		Thread th1 = new Thread(new EIMTThread1());
		Thread th2 = new Thread(new EIMTThread2());

		th1.start();
		th2.start();

	}

}

class EIMTThread1 implements Runnable {

	int[] ar;

	public EIMTThread1() {
		ar = new int[10];
	}

	@Override
	public void run() {
		// THIS LOOP WILL THROWN AN INDEX OUT OF BOUNDS EXPECTION
		for (int idx = 0; idx <= ar.length; idx++) {
			ar[idx] = idx * idx;
			System.out.println("Inside TH 1 = " + ar[idx]);
		}
	}

}

class EIMTThread2 implements Runnable {

	int[] ar;

	public EIMTThread2() {
		ar = new int[50];
	}

	@Override
	public void run() {
		try {
			// THIS LOOP WILL RUN FINE, NO EXCEPTION THROWN
			for (int idx = 0; idx < ar.length; idx++) {
				ar[idx] = idx * idx;
				System.out.println("Inside TH 2 = " + ar[idx]);
			}
		}
		// TRYING TO CATCH THREAD 1 EXCEPTION HERE, BUT WOULD NOT BE ABLE TO CATCH
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("GOT EXCEPTION IN THREAD 2");
		}
	}

}
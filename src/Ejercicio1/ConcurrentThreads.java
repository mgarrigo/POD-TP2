package Ejercicio1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
	Execute no asegura que el procesador corra los procesos en orden. Por lo tanto las posibles salidas son:
	AB12
	A1B2
	1AB2
	12AB
 */

public class ConcurrentThreads {
	public static class T1 implements Runnable {
		@Override
		public void run() {
			System.out.print("A");
			System.out.print("B");
		}
	}

	public static class T2 implements Runnable {
		@Override
		public void run() {
			System.out.print("1");
			System.out.print("2");
		}
	}

	public static void main(final String[] args) {
		final ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(new T1());
		pool.execute(new T2());
	}
}
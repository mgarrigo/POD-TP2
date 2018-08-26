package Ejercicio3;

import java.util.Random;

public class SafeStackMain {

	public static class Producer implements Runnable {

		private SafeStack stack;
		private Random random;

		public Producer(SafeStack stack) {
			this.stack = stack;
			this.random = new Random();
		}

		@Override
		public void run() {
			while(true) {
				try {
					this.stack.push(random.nextInt());
				} catch (IllegalStateException e) {

				}
			}
		}
	}


	public static class Consumer implements Runnable {

		private SafeStack stack;

		public Consumer(SafeStack stack) {
			this.stack = stack;
		}

		@Override
		public void run() {
			while(true) {
				try {
					this.stack.pop();
				} catch (IllegalStateException e) {

				}
			}
		}
	}

	public static void main(String[] args) {
		SafeStack stack = new SafeStack();

		new Thread(new Producer(stack)).start();
		new Thread(new Producer(stack)).start();
		new Thread(new Consumer(stack)).start();

	}
}

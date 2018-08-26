package Ejercicio3;

import java.util.Random;

public class Main {

	public static class Producer implements Runnable {

		private Stack stack;
		private Random random;

		public Producer(Stack stack) {
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

		private Stack stack;

		public Consumer(Stack stack) {
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
		Stack stack = new Stack();

		new Thread(new Producer(stack)).start();
		new Thread(new Producer(stack)).start();
		new Thread(new Consumer(stack)).start();

	}
}

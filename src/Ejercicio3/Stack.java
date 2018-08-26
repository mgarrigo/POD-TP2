package Ejercicio3;

public class Stack {
	private static final int MAX_SIZE = 10;
	private int top = 0;
	private final int[] values = new int[MAX_SIZE];

	public void push(final int n) {
		if (top == MAX_SIZE) {
			throw new IllegalStateException("stack full");
		}
		values[top++] = n;
	}

	public int pop() {
		if (top == 0) {
			throw new IllegalStateException("stack empty");
		}
		return values[--top];
	}
}


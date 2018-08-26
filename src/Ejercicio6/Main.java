package Ejercicio6;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		String directory = "C:\\Users\\Mariano\\Documents\\Programacion de Objetos Distribuidos";
		ExecutorService pool = Executors.newCachedThreadPool();

		File folder = new File(directory);
		if (!folder.isDirectory()) throw new IllegalArgumentException();

		List<Future<Integer>> counters = new LinkedList<>();

		for (File file: folder.listFiles()) {
			counters.add(pool.submit(new FileLinesReader(file)));
		}

		pool.shutdown();
		pool.awaitTermination(10, TimeUnit.MINUTES);

		int lines = 0;

		for (Future<Integer> future: counters) {
			try {
				lines += future.get();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Lines= " + lines);
	}
}

package Ejercicio6;

import java.io.*;
import java.util.concurrent.Callable;

public class FileLinesReader implements Callable<Integer> {

	File file;

	public FileLinesReader(File file) {
		this.file = file;
	}

	@Override
	public Integer call() throws IOException {
		if (file.isDirectory()) return 0;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		return lines;
	}
}

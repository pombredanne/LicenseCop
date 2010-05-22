package com.techtangents;

import com.ephox.epipes.core.Pipe;

import java.io.*;

public class WholeFileReader extends Pipe<File, String> {
	public void consume(File file) {
		produce(edgeRead(file));
	}

	private String edgeRead(File file) {
		try {
			return read(file);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String read(File file) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader r = new BufferedReader(new FileReader(file));
		String s;
		while((s = r.readLine()) != null) {
			sb.append(s);
			sb.append("\n");
		}
		r.close();
		return sb.toString();
	}
}

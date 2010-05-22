package com.techtangents.licensecop.alien;

import com.ephox.epipes.core.Pipe;
import com.techtangents.licensecop.core.FileAndContents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// FIX: split up - reading a whole file is one thing. Packaging up in a FileAndContents is another.
public class WholeFileReader extends Pipe<File, FileAndContents> {
	public void consume(File file) {
        String contents = edgeRead(file);
        produce(new FileAndContents(file, contents));
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

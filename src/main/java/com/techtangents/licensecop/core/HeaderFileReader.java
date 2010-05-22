package com.techtangents.licensecop.core;

import com.techtangents.licensecop.Namespace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HeaderFileReader {
    public String read() {
        InputStream stream = Namespace.class.getResourceAsStream("header.txt");
        return edgeRead(stream);
    }

    private String edgeRead(InputStream stream) {
        try {
            return read(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        reader.close();
        return sb.toString();
    }
}

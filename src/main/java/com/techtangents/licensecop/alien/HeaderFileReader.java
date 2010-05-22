package com.techtangents.licensecop.alien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// FIX: dupe with wholefilereader
public class HeaderFileReader {
    public String read(File headerFile) {
        return edgeRead(headerFile);
    }

    private String edgeRead(File f) {
        try {
            return readIt(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readIt(File f) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
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

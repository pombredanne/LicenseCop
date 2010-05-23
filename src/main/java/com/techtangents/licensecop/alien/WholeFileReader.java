package com.techtangents.licensecop.alien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WholeFileReader {
    
    // FIX: edge
    public String read(File file) {
        try {
            return doRead(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    String doRead(File file) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new FileReader(file));
        String s;
        while ((s = r.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        r.close();
        return sb.toString();
    }
}
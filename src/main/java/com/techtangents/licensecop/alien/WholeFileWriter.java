package com.techtangents.licensecop.alien;

import com.ephox.epipes.core.Consumer;
import com.techtangents.licensecop.core.FileAndContents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WholeFileWriter implements Consumer<FileAndContents> {
    public void consume(FileAndContents fileAndContents) {
        File file = fileAndContents.getFile();
        String contents = fileAndContents.getContents();        
        // FIX: edge
        try {
            FileWriter w = new FileWriter(file);
            w.write(contents);
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

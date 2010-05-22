package com.techtangents.licensecop.alien;

import com.ephox.epipes.core.EPipes;
import com.ephox.epipes.core.Pipe;
import com.ephox.epipes.files.ListFiles;

import java.io.File;

public class RecursiveListFiles extends Pipe<File, File> {
    public void consume(File file) {
        if (file.getName().startsWith(".")) return;

        if (file.isFile()) {
            produce(file);
        } else if (file.isDirectory()) {
            EPipes.pipe(file, new ListFiles(), new RecursiveListFiles(), pipeOutput());
        }
    }
}

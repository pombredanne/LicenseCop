package com.techtangents.licensecop.alien;

import com.ephox.epipes.core.EPipes;
import com.ephox.epipes.core.Pipe;
import com.ephox.epipes.files.ListFiles;

import java.io.File;

public class RecursiveListFiles extends Pipe<File, File> {
    public void consume(File file) {
        if (!file.isDirectory()) throw new IllegalArgumentException(file + " is not a folder");
        EPipes.pipe(file, new ListFiles(), "isFile", pipeOutput());
        EPipes.pipe(file, new ListFiles(), "isFolder", new RecursiveListFiles(), pipeOutput());
    }
}

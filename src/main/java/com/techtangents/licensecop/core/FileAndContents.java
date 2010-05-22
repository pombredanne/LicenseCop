package com.techtangents.licensecop.core;

import java.io.File;

public class FileAndContents {
    private final File file;
    private final String contents;

    public FileAndContents(File file, String contents) {
        this.file = file;
        this.contents = contents;
    }

    public File getFile() {
        return file;
    }

    public String getContents() {
        return contents;
    }
}

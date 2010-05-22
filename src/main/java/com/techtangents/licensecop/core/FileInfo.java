package com.techtangents.licensecop.core;

import java.io.File;

public class FileInfo {
    private final String header;
    private final String body;
    private final File file;

    public FileInfo(String header, String body, File file) {
        this.header = header;
        this.body = body;
        this.file = file;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public File getFile() {
        return file;
    }
}

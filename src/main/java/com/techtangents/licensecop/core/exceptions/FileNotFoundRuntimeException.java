package com.techtangents.licensecop.core.exceptions;

// FIX: use or lose
public class FileNotFoundRuntimeException extends RuntimeException {
    public FileNotFoundRuntimeException(String name) {
        super("File not found: " + name);
    }
    public FileNotFoundRuntimeException(Class clarse, String name) {
        super("File not found: " + clarse.getPackage().getName() + ":" + name);
    }
}

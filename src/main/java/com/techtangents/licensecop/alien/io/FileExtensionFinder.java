package com.techtangents.licensecop.alien.io;

import java.io.File;

public class FileExtensionFinder {
    public String getExtension(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf(".");
        if (lastDot == -1) return "";
        return name.substring(lastDot + 1);
    }
}
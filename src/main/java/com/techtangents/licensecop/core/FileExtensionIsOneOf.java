package com.techtangents.licensecop.core;

import com.ephox.epipes.bool.predicates.Predicate;

import java.io.File;

public class FileExtensionIsOneOf implements Predicate<File> {
    private final String[] extensions;

    public FileExtensionIsOneOf(String... extensions) {
        this.extensions = extensions;
    }

    public boolean accept(File file) {
        return contains(extensions, getExtension(file));
    }

    // FIX: sideways
    private String getExtension(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf(".");
        if (lastDot == -1) return "";
        return name.substring(lastDot);
    }

    // FIX: sideways
    private boolean contains(Object[] a, Object x) {
        for (Object o : a) if (o.equals(x)) return true;
        return false;

    }
}

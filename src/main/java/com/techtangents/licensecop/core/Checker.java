package com.techtangents.licensecop.core;

import com.ephox.epipes.bool.predicates.Predicate;

public class Checker implements Predicate<FileInfo> {
    public boolean accept(FileInfo fileInfo) {
        // FIX: check if file is already ok - only accept files that need fixing
        return true;
    }
}

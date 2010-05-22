/*
Copyright 2010 Dylan Just

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.techtangents.licensecop.core;

import com.ephox.epipes.bool.predicates.Predicate;

import java.io.File;

public class FileExtensionIsOneOf implements Predicate<File> {
    private final String[] extensions;

    public FileExtensionIsOneOf(String... extensions) {
        this.extensions = extensions;
    }

    public boolean accept(File file) {
        String x = getExtension(file);
        return contains(extensions, x);
    }

    // FIX: sideways
    private String getExtension(File file) {
        String name = file.getName();
        int lastDot = name.lastIndexOf(".");
        if (lastDot == -1) return "";
        return name.substring(lastDot + 1);
    }

    // FIX: sideways
    private boolean contains(Object[] a, Object x) {
        for (Object o : a) if (o.equals(x)) return true;
        return false;

    }
}

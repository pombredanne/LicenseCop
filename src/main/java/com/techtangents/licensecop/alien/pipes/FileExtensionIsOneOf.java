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

package com.techtangents.licensecop.alien.pipes;

import com.ephox.epipes.bool.predicates.Predicate;
import com.techtangents.arraymangler.bits.ArrayContains;
import com.techtangents.arraymangler.bits.DefaultArrayContains;
import com.techtangents.licensecop.alien.io.FileExtensionFinder;

import java.io.File;

// FIX: Should be part of EPipes
public class FileExtensionIsOneOf implements Predicate<File> {
    
    private final String[] extensions;
    private final FileExtensionFinder fileExtensionFinder = new FileExtensionFinder();
    private final ArrayContains arrays = new DefaultArrayContains();
    
    public FileExtensionIsOneOf(String... extensions) {
        this.extensions = extensions;
    }

    public boolean accept(File file) {
        String x = fileExtensionFinder.getExtension(file);
        return arrays.contains(extensions, x);
    }
}
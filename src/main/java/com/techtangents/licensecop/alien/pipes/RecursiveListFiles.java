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
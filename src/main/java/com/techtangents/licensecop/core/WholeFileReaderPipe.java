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

import com.ephox.epipes.core.Pipe;
import com.techtangents.licensecop.alien.WholeFileReader;
import com.techtangents.licensecop.core.FileAndContents;

import java.io.File;

// FIX: split up - reading a whole file is one thing. Packaging up in a FileAndContents is another.
public class WholeFileReaderPipe extends Pipe<File, FileAndContents> {
    private final WholeFileReader readifier = new WholeFileReader();

    public void consume(File file) {
        String contents = readifier.read(file);
        produce(new FileAndContents(file, contents));
	}
}
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

package com.techtangents.licensecop.api;

import com.ephox.epipes.core.EPipes;
import com.techtangents.licensecop.alien.pipes.FileExtensionIsOneOf;
import com.techtangents.licensecop.alien.pipes.RecursiveListFiles;
import com.techtangents.licensecop.core.filetypes.FileTypes;
import com.techtangents.licensecop.core.headerfile.HeaderFileReader;
import com.techtangents.licensecop.core.pipes.FileSplitter;
import com.techtangents.licensecop.core.pipes.Reassembler;
import com.techtangents.licensecop.core.pipes.WholeFileReaderPipe;
import com.techtangents.licensecop.core.pipes.WholeFileWriterPipe;

import java.io.File;

public class LicenseCop {

    private final FileTypes types = new FileTypes();
    private final HeaderFileReader headerFileReader = new HeaderFileReader();

    // FIX: EPipes is spitting out lots of rubbish output - fix it and re-integrate.
    public void go(String path) {
        File folder = new File(path);
        String header = headerFileReader.read(path);

        EPipes.pipe(folder,
                new RecursiveListFiles(),
                "isFile",
                new FileExtensionIsOneOf(types.supportedTypes()),
                new WholeFileReaderPipe(),
                new FileSplitter(),
                new Reassembler(header),
                new WholeFileWriterPipe());
	}
}
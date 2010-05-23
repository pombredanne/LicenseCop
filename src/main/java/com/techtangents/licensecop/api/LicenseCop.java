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
import com.techtangents.licensecop.alien.io.WholeFileReader;
import com.techtangents.licensecop.alien.pipes.FileExtensionIsOneOf;
import com.techtangents.licensecop.alien.pipes.RecursiveListFiles;
import com.techtangents.licensecop.core.data.HardCoded;
import com.techtangents.licensecop.core.filetypes.FileTypes;
import com.techtangents.licensecop.core.pipes.FileSplitter;
import com.techtangents.licensecop.core.pipes.Reassembler;
import com.techtangents.licensecop.core.pipes.WholeFileReaderPipe;
import com.techtangents.licensecop.core.pipes.WholeFileWriterPipe;

import java.io.File;
import java.util.Calendar;

public class LicenseCop {

    private final WholeFileReader reader = new WholeFileReader();
    private final FileTypes types = new FileTypes();

    public void go(String path) {
        File folder = new File(path);
        File headerFile = new File(path, HardCoded.HEADER_PATH);
        String templateHeader = reader.read(headerFile);
        String header = templateReplace(templateHeader);

        EPipes.pipe(folder,
                new RecursiveListFiles(),
                "isFile",
                new FileExtensionIsOneOf(types.supportedTypes()),
                new WholeFileReaderPipe(),
                new FileSplitter(),
                new Reassembler(header),
                new WholeFileWriterPipe());
	}

    private String templateReplace(String header) {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        header = header.replace("${year}", year.toString());
        return header;
    }
}
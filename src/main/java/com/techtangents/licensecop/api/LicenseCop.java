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
import com.techtangents.licensecop.alien.RecursiveListFiles;
import com.techtangents.licensecop.alien.WholeFileReader;
import com.techtangents.licensecop.alien.WholeFileWriterPipe;
import com.techtangents.licensecop.core.pipes.Checker;
import com.techtangents.licensecop.core.pipes.FileExtensionIsOneOf;
import com.techtangents.licensecop.core.pipes.FileSplitter;
import com.techtangents.licensecop.core.pipes.HardCoded;
import com.techtangents.licensecop.core.pipes.Reassembler;
import com.techtangents.licensecop.core.pipes.WholeFileReaderPipe;

import java.io.File;
import java.util.Calendar;

public class LicenseCop {

    private final WholeFileReader reader = new WholeFileReader();

    public void go(String folder) {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        File folderFile = new File(folder);

        String header = reader.read(new File(folder, HardCoded.HEADER_PATH));

        header = header.replace("${year}", year.toString());

        EPipes.pipe(folderFile,
                new RecursiveListFiles(),
                "isFile",
                new FileExtensionIsOneOf("java", "js"),
                new WholeFileReaderPipe(),
                new FileSplitter(),
                new Checker(),
                new Reassembler(header),
                new WholeFileWriterPipe());
	}
}
package com.techtangents.licensecop.api;

import com.ephox.epipes.core.EPipes;
import com.techtangents.licensecop.core.Checker;
import com.techtangents.licensecop.core.FileExtensionIsOneOf;
import com.techtangents.licensecop.core.FileSplitter;
import com.techtangents.licensecop.core.HeaderFileReader;
import com.techtangents.licensecop.core.Reassembler;
import com.techtangents.licensecop.core.WholeFileReader;
import com.techtangents.licensecop.core.WholeFileWriter;
import com.techtangents.licensecop.alien.RecursiveListFiles;

public class LicenseCop {

    private final HeaderFileReader headerFile = new HeaderFileReader();

	public void check(String folder, String copyright) {
        String header = copyright + headerFile.read();
        EPipes.pipe(folder,
                new RecursiveListFiles(),
                "isFile",
                new FileExtensionIsOneOf("java", "js"),
                new WholeFileReader(),
                new FileSplitter(),
                new Checker(),
                new Reassembler(header),
                new WholeFileWriter());
	}
}

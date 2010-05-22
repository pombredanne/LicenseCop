package com.techtangents.licensecop.api;

import com.ephox.epipes.core.EPipes;
import com.techtangents.licensecop.alien.HeaderFileReader;
import com.techtangents.licensecop.alien.RecursiveListFiles;
import com.techtangents.licensecop.alien.WholeFileWriter;
import com.techtangents.licensecop.core.Checker;
import com.techtangents.licensecop.core.FileExtensionIsOneOf;
import com.techtangents.licensecop.core.FileSplitter;
import com.techtangents.licensecop.core.Reassembler;
import com.techtangents.licensecop.alien.WholeFileReader;

import java.io.File;
import java.util.Calendar;

public class LicenseCop {

    private final HeaderFileReader headerFile = new HeaderFileReader();

	public void check(String folder) {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        File folderFile = new File(folder);

        String header = headerFile.read(new File(folder, "header.txt"));

        header = header.replace("${year}", year.toString());

        EPipes.pipe(folderFile,
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

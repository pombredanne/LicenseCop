package com.techtangents.licensecop.core.headerfile;

import com.techtangents.licensecop.alien.io.WholeFileReader;
import com.techtangents.licensecop.core.data.HardCoded;

import java.io.File;

public class HeaderFileReader {
    private final WholeFileReader reader = new WholeFileReader();
    private final TemplateReplace templateReplace = new TemplateReplace();

    public String read(String path) {
        File headerFile = new File(path, HardCoded.HEADER_PATH);
        String templateHeader = reader.read(headerFile);
        return templateReplace.templateReplace(templateHeader);
    }
}
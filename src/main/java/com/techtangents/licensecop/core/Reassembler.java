package com.techtangents.licensecop.core;

import com.ephox.epipes.core.Pipe;

public class Reassembler extends Pipe<FileInfo, FileAndContents> {
    private final String header;

    public Reassembler(String header) {
        this.header = header;
    }

    public void consume(FileInfo fileInfo) {
        // FIX: dupe
        // FIX: deal with different file types
        String startComment = "/*";
        String endComment = "*/";

        String fullContents = startComment + "\n" + header + endComment + "\n" + fileInfo.getBody();
        FileAndContents fac = new FileAndContents(fileInfo.getFile(), fullContents);
        produce(fac);
        
    }
}

package com.techtangents.licensecop.core;

import com.ephox.epipes.core.Mapper;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSplitter extends Mapper<FileAndContents, FileInfo> {

    public FileInfo map(FileAndContents fc) {
        File file = fc.getFile();
        String trimmed = fc.getContents().trim();

        // FIX: map these to file extensions
        String startComment = "/*";
        String endComment = "*/";

        Pattern p = makePattern(startComment, endComment);
        Matcher m = p.matcher(trimmed);
        if (m.matches() && m.groupCount() == 2) {
            String header = m.group(1).trim();
            String body = m.group(2).trim();
            return new FileInfo(header, body, file);
        } else {
            return new FileInfo("", trimmed, file);
        }
    }

    private Pattern makePattern(String startComment, String endComment) {
        return Pattern.compile(
                "^(" +
                Pattern.quote(startComment)
                + ".*?"
                + Pattern.quote(endComment) +
                ")" +
                "(.*)$",
                Pattern.DOTALL);
    }
}

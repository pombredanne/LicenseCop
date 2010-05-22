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
            String body = m.group(2).trim() + "\n";
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

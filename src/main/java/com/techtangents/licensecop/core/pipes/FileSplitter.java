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

package com.techtangents.licensecop.core.pipes;

import com.ephox.epipes.core.Mapper;
import com.techtangents.licensecop.alien.io.FileExtensionFinder;
import com.techtangents.licensecop.core.filetypes.FileTypeInfo;
import com.techtangents.licensecop.core.filetypes.FileTypes;
import com.techtangents.licensecop.core.types.FileAndContents;
import com.techtangents.licensecop.core.types.FileInfo;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSplitter extends Mapper<FileAndContents, FileInfo> {

    private final FileTypes types = new FileTypes();
    private final FileExtensionFinder extensions = new FileExtensionFinder();

    public FileInfo map(FileAndContents fc) {
        File file = fc.getFile();
        String trimmed = fc.getContents().trim();

        // FIX: we're calculating the extension twice
        String x = extensions.getExtension(file);
        FileTypeInfo typeInfo = types.info(x);

        String startComment = typeInfo.getStartComment();
        String endComment = typeInfo.getEndComment();

        Pattern p = makePattern(startComment, endComment);
        return tearApart(file, trimmed, typeInfo, p);
    }

    private FileInfo tearApart(File file, String trimmed, FileTypeInfo typeInfo, Pattern p) {
        Matcher m = p.matcher(trimmed);
        if (m.matches() && m.groupCount() == 2) {
            String header = m.group(1).trim();
            String body = m.group(2);
            return new FileInfo(header, body, file, typeInfo);
        } else {
            return new FileInfo("", trimmed, file, typeInfo);
        }
    }

    private Pattern makePattern(String startComment, String endComment) {
        return Pattern.compile(
                "^(" +
                Pattern.quote(startComment)
                + ".*?"
                + Pattern.quote(endComment) +
                "[\r\n ]*)" +
                "(.*)$",
                Pattern.DOTALL);
    }
}
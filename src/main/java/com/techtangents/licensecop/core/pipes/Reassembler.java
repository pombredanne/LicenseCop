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

import com.ephox.epipes.core.Pipe;
import com.techtangents.licensecop.core.types.FileAndContents;
import com.techtangents.licensecop.core.types.FileInfo;

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

        String fullContents = startComment + "\n" + header + endComment + "\n\n" + fileInfo.getBody();
        FileAndContents fac = new FileAndContents(fileInfo.getFile(), fullContents);
        produce(fac);
        
    }
}
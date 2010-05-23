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
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

package com.techtangents.licensecop.alien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// FIX: dupe with wholefilereader
public class HeaderFileReader {
    public String read(File headerFile) {
        return edgeRead(headerFile);
    }

    private String edgeRead(File f) {
        try {
            return readIt(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readIt(File f) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
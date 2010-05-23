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

public class WholeFileReader {
    
    // FIX: edge
    public String read(File file) {
        try {
            return doRead(file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    String doRead(File file) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new FileReader(file));
        String s;
        while ((s = r.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        r.close();
        return sb.toString();
    }
}
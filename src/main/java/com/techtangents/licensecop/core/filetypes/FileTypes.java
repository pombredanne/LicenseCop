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

package com.techtangents.licensecop.core.filetypes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileTypes {

    private Map<String, FileTypeInfo> types = new HashMap<String, FileTypeInfo>();
    {
        types.put("java", new FileTypeInfo("/*", "*/"));
        types.put("js", new FileTypeInfo("/*", "*/"));
    }

    public FileTypeInfo info(String type) {
        return types.get(type);
    }

    public boolean isSupported(String type) {
        return types.containsKey(type);
    }

    public String[] supportedTypes() {
        Set<String> set = types.keySet();
        return set.toArray(new String[set.size()]);
    }
}
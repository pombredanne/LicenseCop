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

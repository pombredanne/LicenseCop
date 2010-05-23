package com.techtangents.licensecop.core.filetypes;

public class FileTypeInfo {
    private final String startComment;
    private final String endComment;

    public FileTypeInfo(String startComment, String endComment) {
        this.startComment = startComment;
        this.endComment = endComment;
    }

    public String getStartComment() {
        return startComment;
    }

    public String getEndComment() {
        return endComment;
    }
}

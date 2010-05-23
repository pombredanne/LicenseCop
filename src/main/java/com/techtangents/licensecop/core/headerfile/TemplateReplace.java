package com.techtangents.licensecop.core.headerfile;

import java.util.Calendar;

public class TemplateReplace {
    public String templateReplace(String header) {
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        header = header.replace("${year}", year.toString());
        return header;
    }
}
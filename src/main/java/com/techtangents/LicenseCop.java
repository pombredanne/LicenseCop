package com.techtangents;

import com.ephox.epipes.core.EPipes;
import com.ephox.epipes.files.ListFiles;

public class LicenseCop {

	public void check(String folder) {
		EPipes.pipe(folder, new ListFiles(), new WholeFileReader(), new FileSplitter(), new Checker(), new Reassembler());
	}
}

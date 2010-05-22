package com.techtangents.licensecop.api;

public class Main {
	private static final LicenseCop cop = new LicenseCop();

	public static void main(String[] args) {
		String folder = args[0];
        cop.check(folder);
	}
}

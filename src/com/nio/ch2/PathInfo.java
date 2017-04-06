package com.nio.ch2;

import java.io.File;
import java.io.IOException;

public class PathInfo {

	public static void main(String[] args) throws IOException {
		// pwd
		System.getProperty("user.dir", "");

		// List the available filesystem roots.
		File.listRoots();

		
		// 2.1
		System.out.println("usage: java PathInfo path");
		File file = new File("d:\\a.txt");
//		File file = new File("d:\\a.txt");
		System.out.println("Absolute path = " + file.getAbsolutePath());
		System.out.println("Canoic path = " + file.getCanonicalPath());
		System.out.println("Name = " + file.getAbsolutePath());
		System.out.println("Parent = " + file.getParent());
		System.out.println("Path = " + file.getPath());
		System.out.println("Is absolute = " + file.isAbsolute());
	}

}

package com.nio.ch12;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

// 12-3
public class RootDirectoryDemo {

	public static void main(String[] args) {
		FileSystem fsDefault = FileSystems.getDefault();
		Path path = fsDefault.getPath("a", "b", "c");
		System.out.println(path);
		System.out.printf("Absolute: %b%n", path.isAbsolute());
		System.out.printf("To Absolute: %s%n", path.toAbsolutePath());
		System.out.printf("Root: %s%n", path.getRoot());
		System.out.println();

		for (Path root : fsDefault.getRootDirectories()) {
			path = fsDefault.getPath(root.toString(), "a", "b", "c");
			System.out.println(path);
			System.out.printf("Absolute: %b%n", path.isAbsolute());
			System.out.printf("Root: %s%n", path.getRoot());
		}
	}

}

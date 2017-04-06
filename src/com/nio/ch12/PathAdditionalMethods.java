package com.nio.ch12;

import java.nio.file.Path;
import java.nio.file.Paths;

// 12-6
public class PathAdditionalMethods {

	public static final void main(String[] args) {

		Path path1 = Paths.get("a", "b", "c");
		Path path2 = Paths.get("a", "b", "c", "d");

		System.out.printf("path1:%s%n", path1.toString());
		System.out.printf("path2:%s%n", path2.toString());
		System.out.printf("path1.equals(path2):%b%n", path1.equals(path2));
		System.out.printf("path1.equals(path2.subpath(0,3)):%b%n", path1.equals(path2.subpath(0, 3)));

		System.out.printf("path1.compareTo(path2):%d%n", path1.compareTo(path2));
		System.out.printf("path1.startsWith(\"x\"):%d%n", path1.startsWith("x"));

	}

}

package com.nio.ch2;

import java.io.File;

public class Permissions {

	public static void main(String[] args) {
		File file = new File("/Volumes/HD/workspace/NIO/src/com/nio/ch2/Permissions.java");

		System.out.println("Checking permissions for the file");
		System.out.println("Execute = " + file.canExecute());
		System.out.println("Read = " + file.canRead());
		System.out.println("Write = " + file.canWrite());
	}

}

package com.nio.ch2;

import java.io.File;
import java.util.Date;

public class FileDirectoryInfo {

	public static void main(String[] args) {
        File file = new File("e:\\traces2.txt");
        System.out.println("About " + file +":");
        System.out.println("Exists = " + file.exists());
        System.out.println("Is Directory = " + file.isDirectory());
        System.out.println("Is file = " + file.isFile());
        System.out.println("Is hidden = " + file.isHidden());
        System.out.println("Last modified = " + new Date(file.lastModified()));
        System.out.println("Length = " + file.length());
	}

}

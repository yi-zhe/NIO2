package com.nio.ch2;

import java.io.File;
import java.io.FilenameFilter;

public class Dir {

	public static void main(String[] args) {
        File file = new File("E:\\");
        FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
        };
        
        String[] names = file.list(filter);
        for(String name : names) {
        	System.out.println(name);
        }
	}

}

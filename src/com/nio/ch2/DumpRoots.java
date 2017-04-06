package com.nio.ch2;

import java.io.File;

public class DumpRoots {

	public static void main(String[] args) {
       File[] roots = File.listRoots();
       for(File root : roots) {
    	   System.out.println(root.getAbsolutePath());
       }
	}

}

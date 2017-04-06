package com.nio.ch2;

import java.io.File;

public class TempFileDemo {

	public static void main(String[] args) {
        System.out.println("System temp dir is :" + System.getProperty("java.io.tmpdir"));
        File temp = new File("text", ".txt");
        System.out.println(temp);
        temp.deleteOnExit();
	}

}

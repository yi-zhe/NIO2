package com.nio.ch5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import util.HClosable;

public class FileWriterFileReaderDemo {

	public static final String MSG = "Text message";
	
	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("temp");
			fw.write(MSG, 0, MSG.length());

			
			fr = new FileReader("temp");
			char[] buf = new char[MSG.length()];
			fr.read(buf, 0, MSG.length());
			// something goes wrong here, try it on Windows
			System.out.println(buf);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			HClosable.close(fr);
			HClosable.close(fw);
		}
	}

}

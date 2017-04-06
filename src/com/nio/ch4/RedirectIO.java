package com.nio.ch4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectIO {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("/Volumes/HD/workspace/NIO/a.txt"));
		System.setOut(new PrintStream("/Volumes/HD/workspace/NIO/b.txt"));
		System.setErr(new PrintStream("/Volumes/HD/workspace/NIO/c.txt"));

		int ch;
		while ((ch = System.in.read()) != -1) {
			System.out.print((char) ch);
		}
		System.err.println("Redirected error output");
	}

}

package com.nio.ch5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import util.HClosable;

public class BufferedReaderBufferedWriterDemo {

	static String[] lines = { "1", "2", "3", "4" };

	public static void main(String[] args) {

		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			bw = new BufferedWriter(new FileWriter("tmp"));
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}

			// 必须先关闭 否则下面的BufferedReaader读不出来
			HClosable.close(bw);
			br = new BufferedReader(new FileReader("tmp"));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			HClosable.close(br);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

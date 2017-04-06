package com.nio.ch4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Scramble {

	public static void main(String[] args) {
		FileInputStream fis = null;
		ScrambledOutputStream sos = null;

		try {
			fis = new FileInputStream("/Volumes/HD/workspace/a.txt");
			FileOutputStream fos = new FileOutputStream("/Volumes/HD/workspace/b.txt");

			sos = new ScrambledOutputStream(fos, makeMap());

			int b;
			while ((b = fis.read()) != -1) {
				sos.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (sos != null) {
				try {
					sos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static int[] makeMap() {

		int[] map = new int[256];
		for (int i = 0; i < map.length; i++) {
			map[i] = i;
		}

		Random r = new Random(0);
		for (int i = 0; i < map.length; i++) {
			int n = r.nextInt(map.length);
			int temp = map[i];
			map[i] = map[n];
			map[n] = temp;
		}

		return map;
	}

}

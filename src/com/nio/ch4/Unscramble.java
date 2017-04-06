package com.nio.ch4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Unscramble {

	public static void main(String[] args) {
        ScrambledInputStream sis = null;
        FileOutputStream fos = null;
        
        try {
        	FileInputStream fis = new FileInputStream("/Volumes/HD/workspace/b.txt");;
        	sis = new ScrambledInputStream(fis, makeMap());
        	fos = new FileOutputStream("/Volumes/HD/workspace/c.txt");

        	int b;
        	while((b = sis.read()) != -1) {
        		fos.write(b);
        	}
        } catch(IOException e) {
        	e.printStackTrace();
        } finally {
        	if(sis!=null) {
        		try {
					sis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	
        	if(fos!=null) {
        		try {
					fos.close();
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

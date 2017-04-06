package com.nio.ch4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamsDemo {

	private static final String FILENAME = "values.dat";

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fos = new FileOutputStream(FILENAME);
			dos = new DataOutputStream(fos);
			dos.writeInt(1995);
			dos.writeUTF("Saving this string is modified UTF-8 format!");
			dos.writeFloat(1.0F);
			
			fis = new FileInputStream(FILENAME);
			dis = new DataInputStream(fis);
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			System.out.println(dis.readFloat());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

package com.nio.ch7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("temp", "rw");
		FileChannel fc = raf.getChannel();
		long pos;
		System.out.println("Position = " + (pos = fc.position()));
		System.out.println("Size: " + fc.size());
		String msg = "This is a test message.";
		ByteBuffer buffer = ByteBuffer.allocateDirect(msg.length()  * 2);
		buffer.asCharBuffer().put(msg);
		fc.write(buffer);
		fc.force(true);
		System.out.println("Position = " + (pos = fc.position()));
		System.out.println("Size: " + fc.size());
		buffer.clear();
		fc.position(0);
		fc.read(buffer);
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print(buffer.getChar());
		}
	}

}

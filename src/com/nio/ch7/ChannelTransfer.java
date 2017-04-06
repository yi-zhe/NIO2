package com.nio.ch7;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelTransfer {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("x.dat");
		FileChannel inChannel = fis.getChannel();
		WritableByteChannel outChannel = Channels.newChannel(System.out);
		inChannel.transferTo(0, inChannel.size(), outChannel);
		fis.close();
		inChannel.close();
	}

}

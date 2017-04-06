package com.nio.ch8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class SelectorClient {

	static int DEFAULT_PORT = 9999;
	static ByteBuffer bb = ByteBuffer.allocate(8);

	public static void main(String[] args) throws IOException {

		SocketChannel sc = SocketChannel.open();
		InetSocketAddress addr = new InetSocketAddress("localhost", DEFAULT_PORT);

		sc.connect(addr);

		while (sc.read(bb) != -1) {
			bb.flip();
			System.out.println(new Date(bb.getLong()));
			bb.clear();
		}

		sc.close();
	}

}

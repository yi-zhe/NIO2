package com.nio.ch7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("Starting server...");
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(9999));
		ssc.configureBlocking(false);
		String msg = "Local address:" + ssc.socket().getLocalSocketAddress();
		ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
		while (true) {
			System.out.print(".");
			SocketChannel sc = ssc.accept();
			if (sc != null) {
				System.out.println();
				System.out.println("Received connection from" + sc.socket().getRemoteSocketAddress());
				buffer.rewind();
				sc.write(buffer);
				sc.close();
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

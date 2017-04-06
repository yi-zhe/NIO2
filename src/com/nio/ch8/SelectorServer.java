package com.nio.ch8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorServer {

	static int DEFAULT_PORT = 9999;
	static ByteBuffer bb = ByteBuffer.allocate(8);

	public static void main(String[] args) throws IOException {

		System.out.println("Server starting listening on port:" + DEFAULT_PORT);

		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ServerSocket ss = ssc.socket();
		ss.bind(new InetSocketAddress(DEFAULT_PORT));
		ssc.configureBlocking(false);
		ssc.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			int n = selector.select();
			if (n == 0)
				continue;

			Iterator<SelectionKey> it = selector.selectedKeys().iterator();

			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();
				if (key.isAcceptable()) {
					SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();

					if (sc == null)
						continue;

					System.out.println("Receive connection");
					bb.clear();
					bb.putLong(System.currentTimeMillis());
					bb.flip();
					System.out.println("Writing current time");
					while (bb.hasRemaining()) {
						sc.write(bb);
					}
					sc.close();
				}
				it.remove();
			}
		}

	}

}

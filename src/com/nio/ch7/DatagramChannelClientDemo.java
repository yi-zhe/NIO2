package com.nio.ch7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClientDemo {
	
	static int PORT = 9999;

	public static void main(String[] args) throws IOException {

		DatagramChannel dcClient = DatagramChannel.open();
		ByteBuffer symbol = ByteBuffer.wrap("MSFT".getBytes());
		ByteBuffer response = ByteBuffer.allocate(16);
		
		InetSocketAddress sa = new InetSocketAddress("localhost", PORT);
		dcClient.send(symbol, sa);
		System.out.println("Receiving datagram from " + dcClient.receive(response));
		System.out.println("Open price " + response.getFloat(0));
		System.out.println("Low price " + response.getFloat(4));
		System.out.println("Hight price " + response.getFloat(8));
		System.out.println("Close price " + response.getFloat(12));
	}

}

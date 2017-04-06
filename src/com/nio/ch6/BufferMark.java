package com.nio.ch6;

import java.nio.ByteBuffer;

public class BufferMark {

	// 使用reset后可以回到之前mark的位置
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(7);
		buffer.put((byte) 10).put((byte) 20).put((byte) 30).put((byte) 40);
		
		buffer.limit(4);
		buffer.position(1).mark().position(3);
		System.out.println(buffer.get());
		buffer.reset();
		while(buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}
	}

}

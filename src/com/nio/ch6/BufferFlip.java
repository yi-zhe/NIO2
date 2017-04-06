package com.nio.ch6;

import java.nio.CharBuffer;

public class BufferFlip {

	// buffer.flip = buffer.limit(buffer.position()).position(0)
	// flip 将limit设置为buffer的position, 并将position置为0
	// rewind is similar to flip 但不处理limit 
	public static void main(String[] args) {
		String[] poem = { "Roses are red", "Violets are blue", "Sugar is sweet", "And so are you" };

		CharBuffer buffer = CharBuffer.allocate(50);

		for (int i = 0; i < poem.length; i++) {
			for (int j = 0; j < poem[i].length(); j++) {
				buffer.put(poem[i].charAt(j));
			}
			
			// flip the buffer so that its conents can be read
			buffer.flip();
			
			//drain the buffer
			while(buffer.hasRemaining()) {
				System.out.print(buffer.get());
			}
			
			buffer.clear();
			
			System.out.println();
		}
	}

}

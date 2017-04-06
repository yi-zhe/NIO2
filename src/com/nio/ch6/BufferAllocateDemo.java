package com.nio.ch6;

import java.nio.ByteBuffer;

public class BufferAllocateDemo {

	public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        if(buffer.hasArray()) {
        	System.out.println("buffer array : " + buffer.array());
        	System.out.println("buffer array offset : " + buffer.arrayOffset());
        	System.out.println("Capacity : " + buffer.capacity());
        	System.out.println("Limit: " + buffer.limit());
        	System.out.println("Position: " + buffer.position());
        	System.out.println("Remaining: " + buffer.remaining());
        }
        
        byte[] bytes = new byte[200];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes, 10, 50);
        if(buffer.hasArray()) {
        	System.out.println("buffer array : " + buffer2.array());
        	System.out.println("buffer array offset : " + buffer2.arrayOffset());
        	System.out.println("Capacity : " + buffer2.capacity());
        	System.out.println("Limit: " + buffer2.limit());
        	System.out.println("Position: " + buffer2.position());
        	System.out.println("Remaining: " + buffer2.remaining());
        }
	}

}

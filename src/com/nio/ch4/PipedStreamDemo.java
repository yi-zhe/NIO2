package com.nio.ch4;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

	final static int LIMIT = 10;

	public static void main(String[] args) throws IOException {
		final PipedOutputStream pos = new PipedOutputStream();
		final PipedInputStream pis = new PipedInputStream(pos);

		Runnable senderTask = () -> {
			try {
				for (int i = 0; i < LIMIT; i++)
					pos.write((byte) (Math.random() * 256));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable receiverTask = () -> {
			try {
				int b;
				while ((b = pis.read()) != -1)
					System.out.println(b);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					pis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(senderTask).start();
		new Thread(receiverTask).start();
	}

}

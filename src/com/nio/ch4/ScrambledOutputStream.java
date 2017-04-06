package com.nio.ch4;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ScrambledOutputStream extends FilterOutputStream {

	private int[] map;
	
	
	public ScrambledOutputStream(OutputStream out, int[] map) {
		super(out);
		this.map = map;
	}
	
	@Override
	public void write(int b) throws IOException {
		out.write(map[b]);
	}

}

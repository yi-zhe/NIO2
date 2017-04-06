package com.nio.ch3;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PartsDB {

	public static final int PNUMLEN = 20;
	public static final int DESCLEN = 30;
	public static final int OUANLEN = 4;
	public static final int COSTLEN = 4;

	public static final int RECLEN = 2 * PNUMLEN + 2 * DESCLEN + OUANLEN + COSTLEN;

	public RandomAccessFile raf;

	public PartsDB(String path) throws IOException {
		raf = new RandomAccessFile(path, "rw");
	}

	public void append(String partnum, String partdesc, int qty, int ucost) throws IOException {
		raf.seek(raf.length());
		write(partnum, partdesc, qty, ucost);
	}

	public void write(String partnum, String partdesc, int qty, int ucost) throws IOException {
		StringBuilder builder = new StringBuilder(partnum);
		if (builder.length() > PNUMLEN) {
			builder.setLength(PNUMLEN);
		} else if (builder.length() < PNUMLEN) {
			int length = PNUMLEN - builder.length();
			for (int i = 0; i < length; i++) {
				builder.append(" ");
			}
		}

		raf.writeChars(builder.toString());

		builder = new StringBuilder(partdesc);
		if (builder.length() > DESCLEN) {
			builder.setLength(DESCLEN);
		} else if (builder.length() < DESCLEN) {
			int length = DESCLEN - builder.length();
			for (int i = 0; i < length; i++) {
				builder.append(" ");
			}
		}
		raf.writeChars(builder.toString());
		raf.writeInt(qty);
		raf.writeInt(ucost);
	}

	public void update(int recno, String partnum, String partdesc, int qty, int ucost) throws IOException {
		if (recno < 0 || recno >= numRecs()) {
			throw new IllegalArgumentException("Out of range");
		}
		raf.seek(recno * RECLEN);
		write(partnum, partdesc, qty, ucost);
	}

	public void close() {
		try {
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int numRecs() throws IOException {
		return (int) raf.length() / RECLEN;
	}

	public Part select(int recno) throws IOException {
		if (recno < 0 || recno >= numRecs()) {
			throw new IllegalArgumentException("Out of range");
		}
		raf.seek(recno * RECLEN);
		return read();
	}

	public Part read() throws IOException {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < PNUMLEN; i++) {
			builder.append(raf.readChar());
		}
		String partnum = builder.toString().trim();

		builder.setLength(0);
		for (int i = 0; i < DESCLEN; i++) {
			builder.append(raf.readChar());
		}
		String partdesc = builder.toString().trim();

		int qty = raf.readInt();
		int ucost = raf.readInt();

		return new Part(partnum, partdesc, qty, ucost);
	}

	public static class Part {
		private String partnum;
		private String desc;
		private int qty;
		private int ucost;

		public Part(String partnum, String desc, int qty, int ucost) {
			this.partnum = partnum;
			this.desc = desc;
			this.qty = qty;
			this.ucost = ucost;
		}

		public String getPartnum() {
			return partnum;
		}

		public void setPartnum(String partnum) {
			this.partnum = partnum;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public int getUnitCost() {
			return ucost;
		}

		public void setUnitCost(int ucost) {
			this.ucost = ucost;
		}

		public String toString() {
			return "partnum: " + partnum + " partdesc: " + desc + " qty:" + qty + " ucost:" + ucost;
		}
	}

	public static void main(String[] args) {
		PartsDB pdb = null;
		try {
			pdb = new PartsDB("parts.db");
			
			if(pdb.numRecs() == 0) {
				pdb.append("1-9009-3323-4x", "Wiper Blade Micro Edge", 30, 2468);
				System.out.println(pdb.select(0).toString());
				pdb.update(0, "1-9009-3323-4x", "Wiper Blade Micro Edge", 31, 2469);
				System.out.println(pdb.select(0).toString());
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(pdb != null) {
				pdb.close();
			}
		}
	}

}

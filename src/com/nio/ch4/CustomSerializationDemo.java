package com.nio.ch4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomSerializationDemo {

	static class Employee {
		private String name;

		Employee(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	static class SerEmployee implements Serializable {

		private static final long serialVersionUID = 6580983473288495359L;

		private Employee emp;
		private String name;

		SerEmployee(String name) {
			this.name = name;
			emp = new Employee(name);
		}

		private void writeObject(ObjectOutputStream oos) throws IOException {
			oos.writeUTF(name);
		}

		public void readObject(ObjectInputStream ois) throws IOException {
			name = ois.readUTF();
			emp = new Employee(name);
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
        	oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        	SerEmployee se = new SerEmployee("John Doe");
        	System.out.println(se);
        	oos.writeObject(se);
        	
        	ois = new ObjectInputStream(new FileInputStream("employee.dat"));
        	se = (SerEmployee) ois.readObject();
        	oos.writeObject(se);
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	if(oos != null) {
        		try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(ois!=null) {
        		try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
	}

}

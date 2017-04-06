package com.nio.ch4;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableDemo {
	
	private static final String FILENAME = "employee.dat";

	static class Employee implements Externalizable {
		
		private String name;
		private int age;
		
		public Employee() {
			System.out.println("Employee() called");
		}
		
		public Employee(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			System.out.println("writeExternal() called");
			out.writeUTF(name);
			out.writeInt(age);
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			System.out.println("readExternal() called");
			name = in.readUTF();
			age = in.readInt();
		}
		
	}
	
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			FileOutputStream fos = new FileOutputStream(FILENAME);
			oos = new ObjectOutputStream(fos);
			Employee emp = new Employee("John Doe", 36);
			oos.writeObject(emp);

			FileInputStream fis = new FileInputStream(FILENAME);
			ois = new ObjectInputStream(fis);
			emp = (Employee) ois.readObject();
			System.out.println(emp.getName());
			System.out.println(emp.getAge());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


}

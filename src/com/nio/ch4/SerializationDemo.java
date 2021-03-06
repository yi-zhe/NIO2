package com.nio.ch4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	private static final String FILENAME = "employee.dat";

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

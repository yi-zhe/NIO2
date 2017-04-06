package com.nio.ch11;

import java.util.Formatter;
import java.util.Locale;

import com.nio.ch4.Employee;

public class FormatterDemo {

	public static void main(String[] args) {
        Formatter formatter = new Formatter();
        
        formatter.format("%d", 123);
        System.out.println(formatter.toString());
        formatter.format("%x", 123);
        System.out.println(formatter.toString());
        formatter.format("%c", 'X');
        System.out.println(formatter.toString());
        formatter.format("%f", 0.1);
        System.out.println(formatter.toString());
        formatter.format("%s%n", "Hello world");
        System.out.println(formatter.toString());
        formatter.format("%10.2f", 98.375);
        System.out.println(formatter.toString());
        formatter.format("%05d", 123);
        System.out.println(formatter.toString());
        formatter.format("%1$d %1$d", 123);
        System.out.println(formatter.toString());
        formatter.format("%d %d", 123, 123);
        System.out.println(formatter.toString());
        
        System.out.printf("%04X%n", 478);
        System.out.printf("Current date: %1$tb %1$te, %1$tY%n", System.currentTimeMillis());
        
        formatter.close();
        
        
        Employee emp = new Employee("Jonh Doe", 1000);
        System.out.printf("[%s]%n", emp);
        System.out.printf(Locale.FRENCH, "[%s]%n", emp);
        System.out.printf("[%S]%n", emp);
        System.out.printf("[%10.3s]%n", emp);
        System.out.printf("[%-10.3s]%n", emp);
        System.out.printf("[%#s]%n", emp);
	}

}

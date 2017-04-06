package com.nio.ch4;

import java.io.Serializable;
import java.util.Formattable;
import java.util.FormattableFlags;
import java.util.Formatter;
import java.util.Locale;

public class Employee implements Serializable, Formattable {

	private static final long serialVersionUID = 5052102879753105640L;

	private String name;
	private int age;

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

	public String toString() {
		return name + " " + age;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		StringBuilder builder = new StringBuilder();
		String output = this.name;
		if (formatter.locale().equals(Locale.FRENCH) && name.equals("John Doe"))
			output = "Jean Dupont";

		output += ": " + age;

		if (FormattableFlags.UPPERCASE == (flags & FormattableFlags.UPPERCASE))
			output = output.toUpperCase();

		boolean alternate = (flags & FormattableFlags.ALTERNATE) == FormattableFlags.ALTERNATE;
		alternate |= (precision >= 0 && precision < 8);

		if (alternate) {
			output = "" + age;
		}

		if (precision == -1 || output.length() <= precision) {
			builder.append(output);
		} else {
			builder.append(output.substring(0, precision - 1)).append("*");
		}

		int len = builder.length();

		if (len < width) {
			boolean leftJustified = (flags & FormattableFlags.LEFT_JUSTIFY) == FormattableFlags.LEFT_JUSTIFY;

			for (int i = 0; i < width - len; i++) {
				if (leftJustified) {
					builder.append(' ');
				} else {
					builder.insert(0, ' ');
				}
			}
		}
		
		formatter.format(builder.toString());

	}
}

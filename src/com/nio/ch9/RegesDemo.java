package com.nio.ch9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegesDemo {

	public static void main(String[] args) {

		String regex = "ox";
		String input = "ox";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);

		while (m.find()) {
			System.out
					.println("Located [" + m.group() + "] starting at " + m.start() + " and ending at " + (m.end() - 1));
		}

	}

}

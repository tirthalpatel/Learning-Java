package com.tirthal.learning.langfeatures;

// Project Coin Feature - Strings in Switch

/*
 * In the Switch Statement,
 *
 * In Java 6 and before - the values for the cases could only be constants of type byte, char, short, int (or, technically, their reference-type equivalents Byte, Character, Short, Integer) or enum constants.
 *
 * With Java 7 - the specification has been extended to allow for the String type to be used as well. Also the Java compiler generates generally more efficient bytecode from switch statements that use String objects than from chained if-then-else statements.
 */

/**
 * Test class for syntax of Strings in Switch
 *
 * @author tirthalp
 *
 */
public class StringsInSwitch_TestDrive {

	public static void main(String[] args) {
		printLanguageType("Groovy");

		// The comparison of String objects in switch statements is case sensitive
		printLanguageType("groovy");

		// Throw a NullPointerException, if the variable language resolves to null
		printLanguageType(null);
	}

	public static void printLanguageType(String language) {
		System.out.print("Language '" + language + "' is: ");

		// --- Java 7 and later - String type is allowed in cases.
		switch(language) {
			case "Java":
			case "Scala":
				System.out.println("Static");
				break;

			case "Groovy":
				System.out.println("Dynamic");
				break;

			default:
				System.out.println("Unknown");
		}
	}
}

package com.tirthal.learning.langfeatures;

// Project Coin Feature - Enhanced syntax for Numeric Literals

/*
 * In Java 7, binary literals syntax improves performance. Also binary literals and underscore in numeric literals offers better readability.
 *
 * Binary Literals - The integral types (byte, short, int, and long) can also be expressed using the binary number system.
 * To specify a binary literal, add the prefix 0b or 0B to the number.
 *
 * Underscores in Numeric Literals - Any number of underscore characters (_) can appear anywhere between digits in a numerical literal.
 * This feature enables you, for example, to separate groups of digits in numeric literals, which can improve the readability of your code.
 */

/**
 * Test class for improved syntax for numeric literals
 *
 * @author tirthalp
 *
 */
public class ImprovedSyntaxOfLiterals_TestDrive {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// ------------------- Binary Literals Syntax ----------------

		// In order to use Binary Numbers as Integral types

		// --- Prior to Java 7
		int anInt1 = Integer.parseInt("1000", 2);	// By specifying radix in parseInt method
		System.out.println("1000 = " + anInt1);

		// --- In Java 7 and later
		int anInt2 = 0B1000;						// Prefix 0B denotes that the it is binary number
		System.out.println("0B1000 = " + anInt2);

		// ------------------- Underscores in Numeric Literals -------

		// --- Prior to Java 7
		int hundredMillion = 100000000;
		System.out.println("Hundred Million = " + hundredMillion);

		// --- In Java 7 and later
		int hundredMillionButMoreReadable = 100_000_000;
		System.out.println("Hundred Million = " + hundredMillionButMoreReadable);

		// Few rules of underscore in literals

		int n1 = 10_____10;		// consecutive underscores are legal

		double d1 = 100_000.00d;	// underscore can be used in other numeric types too

		int n2 = 0B1001_0001;	// underscore can be used with binary literal syntax

		double d2 = 1000_000.000_000D; // underscore can be used after the decimal point

		// int n3 = _10; 	// illegal - cannot start a literal with an underscore
		// int n4 = 10_;	// illegal - cannot end a literal with an underscore
		// double d3 = 100-_000._00D;	// illegal - cannot use a literal before or after a decimal point
	}
}

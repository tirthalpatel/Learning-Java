package com.tirthal.learning.tips;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Effective Java Tips (See Also: "Effective Java 3rd Edition Book by Joshua Bloch - Chapter 7"):
 * 
 * (1) Prefer lambdas over anonymous classes to create instances of functional interfaces
 * 
 * (2) Prefer method references to lambdas, where they are shorter and clearer
 * 
 * The primary advantage of lambdas over anonymous classes is that they are more succinct.
 * 
 * Java provides a way to generate function objects even more succinct than lambdas using "method references (::)".
 * Where method references are shorter and clearer, use them; where they aren’t, stick with lambdas.
 * 
 * @author tirthalp
 */
public class EffectiveJavaTip00 {

	// Prior to Java 8 way - Anonymous class instance as a function object - obsolete!
	public static void sortDemo1(List<String> words) {

		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
	}

	// --------------------------------------------------------------------
	// Tip: Prefer lambdas over anonymous classes to create instances of functional interfaces
	// --------------------------------------------------------------------

	// Java 8 way - Lambda expression as function object (replaces anonymous class)
	public static void sortDemo2(List<String> words) {

		Collections.sort(words, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));

		// --------------------------------------------------------------------
		// Tip: Omit the types of all lambda parameters (e.g. String) unless their presence makes your program clearer
		// --------------------------------------------------------------------
		// Thanks to type inference ability of java compiler
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
	}

	// --------------------------------------------------------------------
	// Tip: Prefer method references to lambdas, where they are shorter and clearer
	// --------------------------------------------------------------------

	// Java 8 way - Generate function objects even more succinct using method references (::)
	public static void sortDemo3(List<String> words) {

		Collections.sort(words, Comparator.comparingInt(String::length));	
	}
	
	// Java 8 way - Make still shorter code by taking advantage of the sort method added to the List interface
	public static void sortDemo4(List<String> words) {		
		
		words.sort(Comparator.comparingInt(String::length));
	}
}

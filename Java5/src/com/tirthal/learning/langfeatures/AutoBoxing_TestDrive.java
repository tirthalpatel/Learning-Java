package com.tirthal.learning.langfeatures;

import java.util.Map;
import java.util.TreeMap;

//---------------------------------------
//--- STEP 00 - WHAT IS AUTOBOXING AND UNBOXING? 
//---------------------------------------

///*
// * Java 1.5 - Language feature - Autoboxing and unboxing = This facility eliminates the drudgery of manual conversion between primitive types (such as
// * int) and wrapper types (such as Integer).
// * 
// * --- Caution --- (1) Use them only when there is an “impedance mismatch” between reference types and primitives, for example, when you have to put
// * numerical values into a collection. (2) Unnecessary Object creation due to Autoboxing in Java - It is not appropriate to use autoboxing and
// * unboxing for scientific computing, or other performance-sensitive numerical code. An Integer is not a substitute for an int; autoboxing and
// * unboxing blur the distinction between primitive types and reference types, but they do not eliminate it. One of the danger of autoboxing is throw
// * away object which gets created if autoboxing occurs in a loop. (3) Unnecessary objects and GC overhead - Last but not least is cost associate on
// * autoboxing and unboxing. Since autoboxing creates unnecessary object and if that goes beyond a limit usually outside the range of cached value it
// * can potentially slow your program by frequently causing garbage collection.
// */

//---------------------------------------
//--- STEP 01 - UNDERSTAND AUTOBOXING AND UNBOXING BY EXAMPLE 
//---------------------------------------

/**
 * Test class for autoboxing and unboxing feature
 * 
 * @author tirthalp
 * 
 */
public class AutoBoxing_TestDrive {

	public static void main(String[] args) {

		// ------ Prior to Java 1.5
		Integer iObj1 = Integer.valueOf(3);
		int i1 = iObj1.intValue();
		System.out.println(i1);
		
		// ------ In Java 1.5
		Integer iObj2 = 3; // autoboxing
		int i2 = iObj2; // unboxing
		System.out.println(i2);

		// Prints a frequency table of the words on the command line
		if (args == null || args.length == 0) {
			args = new String[]{"This", "is", "test", "arguments", "becuase", "supplied", "argumenet", "is", "null"};
		}

		Map<String, Integer> words = new TreeMap<String, Integer>();

		for (String s : args) { // Use of enhanced for loop
			int frequence = (words.get(s) == null ? 0 : words.get(s)); // unboxing
			words.put(s, (frequence == 0 ? 1 : frequence + 1)); // autoboxing
		}

		System.out.println(words);
	}

}

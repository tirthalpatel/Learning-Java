package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;
import java.util.Iterator;

//---------------------------------------
//--- STEP 00 - WHAT WAS THE NEED OF ADDING GENERICS IN JAVA 5? 
//---------------------------------------

///**
// * Prior to java 5, the issue of type-safety is not fully addressed, which is one of the key requirement of introducing Generics in Java 5.
// */

//---------------------------------------
//--- STEP 01 - UNDERSTAND PROBLEM OF TYPE-SAFETY IN COLLECTIONS PRIOR TO JAVA 5 BY EXAMPLE? 
// (A02_WithGeneric CLASS OF THIS PACKAGE DEMONSTRATES HOW GENERIC SOLVES THIS PROBLEM)
//---------------------------------------

/**
 * 
 * Test class
 * 
 * @author tirthalp
 * 
 */
public class A01_WithoutGeneric {
	/*
	 * Java is a strongly typed language. When programming with Java, at compile time, you expect to know if you pass a wrong type of parameter to a
	 * method. For example - if you uncomment below line, you will get compile time error "Type mismatch: cannot convert from String to Integer".
	 * Because String is not of type Integer.
	 */
	// Integer i = new String("abc");

	/*
	 * Unfortunately when Java was introduced, this was not carried through fully into the Collections library. Hence there are high chances of
	 * getting runtime error instead of compile time error, if type-safety is not appropriately handled by the developer as demonstrated further.
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// It is expected to be populated integer values in the list
		// Anything other than integer value in the list will product runtime ClassCastException in main()
		// Ideally Java should guarantee type-safety in collection too, which is provided by introducing Generic feature in Java 5
		populateNumbers(list);

		int total = 0;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			// Only integer values are expected here
			// To fix runtime exception, comment line as mentioned in populateNumbers() function
			total += ((Integer) (iter.next())).intValue();
		}

		System.out.println(total);
	}

	/*
	 * In collection type-safety was not guaranteed prior to Java 5 as shown in this function.
	 */
	private static void populateNumbers(ArrayList list) {
		// Only integer values are expected to populate given list
		list.add(new Integer(1));
		list.add(new Integer(2));
		// If accidently String is added in the list, then it would throw runtime exception - java.lang.ClassCastException: java.lang.String
		list.add("Hello World"); // Remove or comment this line to fix runtime exception
	}
}

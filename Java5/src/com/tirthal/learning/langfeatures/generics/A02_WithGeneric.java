package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;

//---------------------------------------
//--- STEP 00 - WHAT WAS THE NEED OF ADDING GENERICS IN JAVA 5? 
//---------------------------------------

///**
// * Prior to java 5, the issue of type-safety is not fully addressed, which is one of the key requirement of introducing Generics in Java 5.
// */

//---------------------------------------
//--- STEP 01 - UNDERSTAND HOW GENERIC TYPE-SAFETY WOULD SOLVE PROBLEM IN JAVA 5 COMPARE TO PROBLEM EXPLAINED IN A01_WithoutGeneric CLASS OF THIS PACKAGE? 
//---------------------------------------

/**
 * 
 * Test class to demonstrate how generic helps the developers to by ensuring type-safety in collections at compile-time instead of runtime
 * 
 * @author tirthalp
 * 
 */
public class A02_WithGeneric {

	public static void main(String[] args) {
		// Usage of ArrayList<Integer> instead of the ArrayList will provide type-safety at compile time
		// ArrayList<Integer> = The list can only accept Integer type values
		ArrayList<Integer> list = new ArrayList<Integer>();
		populateNumbers(list);

		// The another advantage is usage of enhanced for loop and casting is not required by developer
		int total = 0;
		for (Integer val : list) {
			total = total + val;
		}

		System.out.println(total);
	}

	private static void populateNumbers(ArrayList<Integer> list) {
		list.add(new Integer(1));
		list.add(new Integer(2));
		// Now if accidently String is added in the list, then it would give compile time error instead of runtime -
		// The method add(Integer) in the type ArrayList<Integer> is not applicable for the arguments (String)
		// list.add("Hello World"); // Uncomment this line to see compile time error
	}
}

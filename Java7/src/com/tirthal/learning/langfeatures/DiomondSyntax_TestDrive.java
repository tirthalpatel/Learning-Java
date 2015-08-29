package com.tirthal.learning.langfeatures;

import java.util.HashMap;
import java.util.Map;

//Project Coin Feature - Improved Type Inference for Generic Instance Creation, so-called Diamond Syntax

/*
 * You can replace the type arguments required to invoke the constructor of a generic class with an empty set of type parameters (<>) as long as the compiler can infer the type arguments from the context.
 * This pair of angle brackets is informally called the diamond.
 *
 * Note that the diamond often works in method calls; however, it is suggested that you use the diamond primarily for variable declarations.
 */

/**
 * Test class for syntax of improved type inference for generic instance creation
 *
 * @author tirthalp
 *
 */
public class DiomondSyntax_TestDrive {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// --- Prior to Java 7
		Map<Integer, Map<String, String>> usersLists1 =	new HashMap<Integer, Map<String, String>>();

		// --- In Java 7 and later
		Map<Integer, Map<String, String>> usersLists2 = new HashMap<>(); // you can substitute the parameterized type of the constructor with an empty set of type parameters (<>)

		/*
		 * Note that to take advantage of automatic type inference during generic class instantiation, you must specify the diamond.
		 * Otherwise the compiler generates an unchecked conversion warning because the HashMap() constructor refers to the HashMap raw type, not the Map<Integer, Map<String, String>> type:
		 */
		Map<Integer, Map<String, String>> usersLists3 = new HashMap(); // unchecked conversion warning
	}

}

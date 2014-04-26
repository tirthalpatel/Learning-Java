package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Test class for generic method demo
 * 
 * @author tirthalp
 * 
 */
public class A07_GenericMethods {

	// ---------------------------------------
	// --- STEP 00 - HOW TO WRITE PARAMETERIZED GENERIC METHODS?
	// ---------------------------------------

	/**
	 * This method copies alternate elements from the "in" collection to the "out" collection.
	 * 
	 * The <T> in front of the void indicates that the method is a generic method with <T> being the parameterized type.
	 * 
	 * @param in input collection type
	 * @param out output collection type
	 */
	public static <T> void filter(Collection<T> in, Collection<T> out) {
		boolean flag = true;

		for (T obj : in) {
			if (flag) {
				out.add(obj);
			}
			flag = !flag;
		}
	}

	// ---------------------------------------
	// --- STEP 01 - HOW TO USE THE GENERIC METHOD?
	// ---------------------------------------

	public static void main(String[] args) {
		// Prepare input list of numbers
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);

		// Create empty list for output
		List<Integer> output = new ArrayList<Integer>();

		// Call generic methods and print output
		filter(input, output);
		System.out.println(output);

		// ---------------------------------------
		// --- STEP 02 - SEE THE BENEFIT OF GENERIC
		// ---------------------------------------

		// Create empty list with different output type
		List<Double> wrongOutput = new ArrayList<Double>();

		// Call generic methods with mismatch types
		/*
		 * This will give compile time error - The method filter(Collection<T>, Collection<T>) in the type A07_GenericMethods is not applicable
		 * for the arguments (List<Integer>, List<Double>)
		 */
		// filter(input, wrongOutput); // uncomment this line to see compile time error

		// ---------------------------------------
		// --- STEP 03 - WHAT IF, IT IS ACCESSED WITH RAW TYPE
		// ---------------------------------------

		// Raw type of output list
		ArrayList rawOutput = new ArrayList();
		rawOutput.add("hello"); // Added String in output list
		filter(input, rawOutput);
		System.out.println(rawOutput); // Output is mixed of integers and String

		// Can you guess, what's wrong?
		// Well, we lost power of Generics. Because below will give runtime error - java.lang.ClassCastException: java.lang.String
		Integer i = (Integer) rawOutput.get(0);
		System.out.println("This line will not be executed due to runtime error in previous line- " + i);
	}

}

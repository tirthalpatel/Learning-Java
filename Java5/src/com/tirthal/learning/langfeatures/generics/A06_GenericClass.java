package com.tirthal.learning.langfeatures.generics;

//---------------------------------------
//--- STEP 00 - HOW TO WRITE GENERIC CLASS? 
//---------------------------------------

/**
 * This class represents a pair of values of some generic type E.
 * 
 * It is possible to write own Generic Java classes. Generics is not restricted to the predefined classes in the Java API's.
 * 
 * @author tirthalp
 * 
 * @param <E> as per suggested naming conventions the letter E is used for collection elements
 */
class Pair<E> {
	private E obj1;
	private E obj2;

	public Pair(E element1, E element2) {
		obj1 = element1;
		obj2 = element2;
	}

	public E getFirstObject() {
		return obj1;
	}
	public E getSecondObject() {
		return obj2;
	}
}

// ---------------------------------------
// --- STEP 01 - HOW TO USE GENERIC CLASS?
// ---------------------------------------

/**
 * 
 * Test class to show correct usage of custom Generic class
 * 
 * @author tirthalp
 * 
 */
public class A06_GenericClass {

	public static void main(String[] args) {

		// ------------------------- Correct Usage
		Pair<String> sPair = new Pair<String>(new String("Amitabh"), new String("Jaya"));
		System.out.println("First Object = " + sPair.getFirstObject() + " : Second Object = " + sPair.getSecondObject());

		// ------------------------- Access Generics in Non-Generic way, which is allowed for backward compatibility
		/*
		 * Each generic class also has a non-generic form so it can be accessed from a non-generic code. This allows for backward compatibility with
		 * existing code or code that has not been ported to use Generics. While this compatibility has a certain advantage, this feature can lead to
		 * some confusion and also type-safety issues.
		 * 
		 * You will see warning message - Pair is a raw type. References to generic type Pair<E> should be parameterized
		 */
		Pair<Integer> mixedPair = new Pair<Integer>(new Integer(1), new Integer(2));
		System.out.println(mixedPair.getFirstObject());

		// ---------------------------------------
		// --- STEP 02 - SEE THE BENEFIT OF GENERIC
		// ---------------------------------------

		// ------------------------- Wrong Usage - types that mismatch will give compile time error

		// The constructor Pair<Double>(Integer, Double) is undefined
		// Pair<Double> wrongPair = new Pair<Double>(new Integer(1), new Double(2.2)); // uncomment this line to see compile time error

		// Type mismatch: cannot convert from Pair<Integer> to Pair<Object>
		// Pair<Object> wrongPair = new Pair<Integer>(new Integer(1), new Integer(2)); // uncomment this line to see compile time error
	}

}

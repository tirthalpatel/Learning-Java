package com.tirthal.learning.langfeatures;

import java.util.ArrayList;
import java.util.List;

//Project Coin Feature - Improved Compiler Warnings and Errors When Using Non-Reifiable Formal Parameters with Varargs Methods

/*
 * In Java SE 5 and 6, it is the responsibility of the programmer who calls a varargs method that has a non-reifiable varargs formal parameter to determine whether heap pollution would occur.
 * However, if this programmer did not write such a method, he or she cannot easily determine this.
 *
 * In Java SE 7, it is the responsibility of the programmer who writes these kinds of varargs methods to ensure that they properly handle the varargs formal parameter and ensure heap pollution does not occur.
 */

/**
 * Test class for syntax of improved compiler warnings and errors while varargs combines with generics in a method signature
 *
 * @see http://docs.oracle.com/javase/7/docs/technotes/guides/language/non-reifiable-varargs.html
 * @author tirthalp
 *
 */
public class SimplifiedVarargsMethodInvocation_TestDrive {
	public static void main(String[] args) {

		List<String> stringListA = new ArrayList<String>();
		List<String> stringListB = new ArrayList<String>();
		VarargsDemoArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
		VarargsDemoArrayBuilder.addToList(stringListA, "Ten", "Eleven", "Twelve");
		List<List<String>> listOfStringLists = new ArrayList<List<String>>();

		// --- In Java 5 and 6 - Compiler generates warning "Type safety: Potential heap pollution" warning when the method is called. In Java 7, this compiler warning is moved to where the method is implemented.
		VarargsDemoArrayBuilder.addToList(listOfStringLists, stringListA, stringListB);

		VarargsDemoArrayBuilder.addToList2(listOfStringLists, stringListA, stringListB);

		VarargsDemoArrayBuilder.addToList3(listOfStringLists, stringListA, stringListB);

	}
}

/*
 * The Java compiler generates the following warnings for this example:
 * 		addToList:
 * 			At the method's declaration: [unchecked] Possible heap pollution from parameterized vararg type T
 * 			When the method is called: [unchecked]	unchecked generic array creation for varargs parameter of type List<String>[]
 * 		addToList2: When the method is called (no warning is generated at the method's declaration): [unchecked] unchecked generic array creation for varargs parameter of type List<String>[]
 * 		addToList3: No warnings are generated either at the method's declaration or when it is called.
 */
class VarargsDemoArrayBuilder {

	// --- In Java 7 and later - Compiler generates warning "Type safety: Potential heap pollution via varargs parameter l" where method is implemented
	public static <T> void addToList(List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}

	@SuppressWarnings({"unchecked", "varargs"})
	// By annotating the method wit @SuppressWarnings("varargs"), it does not suppress warnings generated from the method's call site.
	public static <T> void addToList2(List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}

	@SafeVarargs
	// By annotating the method with @SafeVarargs, the developer essentially asserts that the method doesn’t perform any unsafe operations. In this case, the compiler will suppress the warning.
	public static <T> void addToList3(List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}

}
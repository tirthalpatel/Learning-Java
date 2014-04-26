package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents unchecked warnings by compiler.
 * 
 * The Java compiler will warn you if it can’t verify type-safety. You would see this if you mix generic and non-generic code (which is not a good
 * idea). Developing applications while leaving these kinds of warnings unattended is a risk. It is better to treat warnings as errors.
 * 
 * @author tirthalp
 * 
 */
public class A11_UncheckedWarnings {

	// This accepts a traditional Collection as parameter
	public static void foo1(Collection c) { // WARNING - Collection is a raw type. References to generic type Collection<E> should be parameterized
	}

	public static void foo2(Collection<Integer> c) {
	}

	public static void main(String[] args) {
		Collection<Integer> coll = new ArrayList<Integer>();
		foo1(coll);

		ArrayList lst = new ArrayList(); // WARNING - ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized

		// Sending an object of the traditional ArrayList to method foo2() which accepts Generic verion of Collections
		foo2(lst); // WARNING - Type safety: The expression of type ArrayList needs unchecked conversion to conform to Collection<Integer>
	}

}

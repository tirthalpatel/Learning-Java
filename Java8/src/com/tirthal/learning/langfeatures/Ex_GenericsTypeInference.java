package com.tirthal.learning.langfeatures;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This is example class to demo syntax of improved type inference in Generics in Java 8.
 * 
 * <p>
 * Type inference is a Java compiler's ability to look at each method invocation and corresponding declaration to
 * determine the type argument (or arguments) that make the invocation applicable.
 * 
 * <p>
 * Java 5 introduced Generics followed by Type Inference using diamon operator in Java 7. Further, Java 8 has improved
 * type inference in Generics for target type.
 * 
 * @author tirthalp
 *
 */
public class Ex_GenericsTypeInference {

	public static void main(String[] args) {

		// Java 5 - Generic
		Map<String, String> c1 = new HashMap<String, String>();
		count(c1);

		// Java 7 - Syntax improvement using diamond operator
		Map<String, String> c2 = new HashMap<>();
		count(c2);

		// Java 7 - will give compile time error for below
		// Java 8 - It is now possible to infer the generic types from method signatures when passing a constructor as
		// the parameter of a method.
		count(new HashMap<>()); // Java 8 - Improved type inference

		// ---- Another example
		count(Collections.<String, String> emptyMap()); // Java 7 way
		count(Collections.emptyMap()); // Java 8 way - improved type inference for target type

	}

	// Method that takes a Map<String, String> as parameter
	public static void count(Map<String, String> cache) {
		System.out.println("Total size of cache: " + cache.size());
	}
}
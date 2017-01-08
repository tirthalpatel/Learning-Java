package com.tirthal.learning.libfeatures.java.other;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Demo code of StringJoiner class in Java 8
 * 
 * @author tirthalp
 */
public class StringJoinerDemo {

	// Problem statement: Want to construct a String like {Blue:Red:Yellow:Black:White}
	
	public static void main(String[] args) {		

		// Java 7 or Prior approach - use String, StringBuffer or StringBuilder
		final StringBuilder sb = new StringBuilder();
		System.out.println("Empty: " + sb.toString());
		
		sb.append("{").append("one").append(":").append("two").append(":").append("three").append("}");
		
		System.out.println(sb.toString() + "\n");
		
		// The Java 8 way
		final StringJoiner sj = new StringJoiner(":", "{", "}");
		System.out.println("Empty: " + sj.toString());
		
		sj.setEmptyValue("zero");	
		System.out.println("By setting empty value: " + sj.toString());
		
		sj.add("one").add("two").add("three");
		System.out.println(sj.toString() + "\n");
		
		// A StringJoiner may be employed to create formatted output from a Stream using Collectors.joining(CharSequence)
		String commaSeperatedEvenNumber = IntStream.range(1, 21)
												   .filter(n -> n%2==0)
												   .mapToObj(n -> n+"")
												   .collect(Collectors.joining(","));
		
		System.out.println(commaSeperatedEvenNumber);
	}

}

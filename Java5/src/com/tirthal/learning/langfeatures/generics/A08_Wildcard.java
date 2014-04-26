package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//---------------------------------------
//--- HOW TO USE WILDCARD IN GENERIC?
//---------------------------------------

/* 
 * <?> - "?" denotes any unknown type. It can represent any Type at in code for. Use this wild card if you are not sure about Type. 
 * 
 * For example, if you want to have a ArrayList which can work with any type than declare it as  "ArrayList<?> unknownList" and 
 * it can be assigned to any type of ArrayList.
 */

/**
 * Test class to demo the use of wildcard <?> in Generic
 * 
 * @author tirthalp
 * 
 */
public class A08_Wildcard {

	/**
	 * This method prints the provided list
	 * 
	 * @param l any type of list
	 */
	public static void printList(List<?> l) {
		System.out.println(l);
	}

	public static void main(String[] args) {

		// ------------- Any type of list is allowed as an argument of printList() method

		// Integer list
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);

		printList(l1);

		// String list
		List<String> l2 = new LinkedList<String>();
		l2.add("abc");
		l2.add("xyz");

		printList(l2);

		// ------------- Anything other than list as an argument of printList() method will give compile time error
		String s = new String("Hello World");
		// Error - The method printList(List<?>) in the type A08_Wildcard is not applicable for the arguments (String)
		// printList(s); // --- uncomment this line to see compile time error
		
		Set<String> s1 = new HashSet<String>();
		s1.add("abc");
		// Error - The method printList(List<?>) in the type A08_Wildcard is not applicable for the arguments (Set<String>)
		// printList(s1); // --- uncomment this line to see compile time error
	}

}

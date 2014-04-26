package com.tirthal.learning.langfeatures.generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//---------------------------------------
//--- STEP 00 - HOW TO USE GENERIC WITH JAVA'S SET INTERFACE? 
//---------------------------------------

/**
 * Test class to demonstrate type-safety using Generic Set
 * 
 * @author tirthalp
 */
public class A04_GenericSet {

	public static void main(String[] args) {
		// ---------------------------------------
		// --- STEP 01 - HOW TO ENSURE, SET INSTANCE CAN ONLY ACCEPT STRING TYPE INSTANCES
		// ---------------------------------------
		Set<String> colorNames = new HashSet<String>();

		// ---------------------------------------
		// --- STEP 02 - WHAT IS BENEFIT OF USING GENERIC IN SET?
		// ---------------------------------------
		colorNames.add("Red");
		colorNames.add("Blue");
		/*
		 * If you try to add integer into the set, then it will give compile time error because of type-safety achieved by Generics - The method
		 * add(String) in the type Set<String> is not applicable for the arguments (Integer)
		 */
		// colorNames.add(new Integer(123)); // uncomment this line to see compile time error

		// ---------------------------------------
		// --- STEP 03 - HOW EASY IS IT TO INTERATE GENERIC SET USING ENHANCED FOR LOOP?
		// ---------------------------------------
		/*
		 * Notice how a String variable is declared inside the parantheses of the for-loop. For each iteration (each element in the Set) this
		 * variable contains the current element (current String).
		 */
		for (String color : colorNames) {
			System.out.println(color);
		}
		
		 /*
	     * Prior to Java 5 without Generic, it requires below code to iterate
	     */
		Iterator<String> iterator = colorNames.iterator();
		while(iterator.hasNext()){
		  String str = iterator.next();
		  System.out.println(str);
		}
	}

}

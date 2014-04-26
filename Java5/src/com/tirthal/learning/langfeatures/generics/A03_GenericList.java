package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//---------------------------------------
//--- STEP 00 - HOW TO USE GENERIC WITH JAVA'S LIST INTERFACE? 
//---------------------------------------

/**
 * Test class to demonstrate type-safety using Generic List
 * 
 * @author tirthalp
 */
public class A03_GenericList {

	public static void main(String[] args) {
		// ---------------------------------------
		// --- STEP 01 - HOW TO ENSURE, LIST INSTANCE CAN ONLY ACCEPT STRING TYPE INSTANCES
		// ---------------------------------------
		List<String> colorNames = new ArrayList<String>();

		// ---------------------------------------
		// --- STEP 02 - WHAT IS BENEFIT OF USING GENERIC IN LIST?
		// ---------------------------------------
		colorNames.add("Red");
		colorNames.add("Blue");
		/*
		 * If you try to add integer into the list, then it will give compile time error because of type-safety achieved by Generics - The method
		 * add(String) in the type List<String> is not applicable for the arguments (Integer)
		 */
		// colorNames.add(new Integer(123)); // uncomment this line to see compile time error

		// The compiler knows that this List can only contain String instances, so casts are not necessary
		String redColor = colorNames.get(0);
		System.out.println(redColor);

		// ---------------------------------------
		// --- STEP 03 - HOW EASY IS IT TO INTERATE GENERIC LIST USING ENHANCED FOR LOOP?
		// ---------------------------------------
		/*
		 * Notice how a String variable is declared inside the parantheses of the for-loop. For each iteration (each element in the List) this
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

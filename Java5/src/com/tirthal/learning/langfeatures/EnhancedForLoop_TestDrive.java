package com.tirthal.learning.langfeatures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//---------------------------------------
//--- STEP 00 - WHAT IS ENHANCED FOR LOOP? 
//---------------------------------------

///*
// * Java 1.5 - Language feature - Enhanced for loop = This new language construct eliminates the drudgery and error-proneness of iterators and index
// * variables when iterating over collections and arrays
// * 
// * --- Caution --- Enhanced for loop cannot be used for the program needs access to the iterator in order to remove the current element. The for-each
// * loop hides the iterator, so you cannot call remove. Therefore, the for-each loop is not usable for filtering. Similarly it is not usable for loops
// * where you need to replace elements in a list or array as you traverse it.
// */

//---------------------------------------
//--- STEP 01 - UNDERSTAND ENHANCED FOR LOOP BY EXAMPLE 
//---------------------------------------

/**
 * Test class for enhanced for loop feature
 * 
 * @author tirthalp
 */
public class EnhancedForLoop_TestDrive {
	public static void main(String args[]) {

		List<String> list = new ArrayList<String>();

		list.add(new String("Test 1"));
		list.add("Test 2");
		list.add(new StringBuffer("Test 3").toString());

		// ------ Prior to Java 1.5
		System.out.println("--- Prior to Java 1.5 - Use iterator");
		for (Iterator str = list.iterator(); str.hasNext();) {
			System.out.println(str.next());
			str.remove(); // Iterator allows to remove current element
		}

		// All elements are removed, so adding elements again in list
		list.add(new String("Test 1 added again"));
		list.add("Test 2 added again");
		list.add(new StringBuffer("Test 3 added again").toString());

		// ------ In Java 1.5
		System.out.println("--- Java 1.5 - Enhanced for-each loop");
		for (String str : list) {
			System.out.println(str);
			// str.remove(); // Enhanced for-each loop doesn't allow remove
		}
	}
}

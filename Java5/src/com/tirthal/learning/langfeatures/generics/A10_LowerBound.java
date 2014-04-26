package com.tirthal.learning.langfeatures.generics;

import java.util.ArrayList;
import java.util.List;

//---------------------------------------
//--- USAGE OF LOWER BOUND IN GENERIC?
//---------------------------------------

// <? super T> - It will allow T and super classes of T, and T represents lower bound 

/**
 * Test class for demo of lower bounds in Generic
 * 
 * @author tirthalp
 * 
 */
public class A10_LowerBound {

	public static void main(String[] args) {

		// ---- List<? super Integer> can hold List<Integer> or List<Number>
		List<? super Integer> numberList = new ArrayList<Number>();
		numberList = new ArrayList<Integer>();

		// Compile Error - Type mismatch: cannot convert from ArrayList<Float> to List<? super Integer>
		// numberList = new ArrayList<Float>(); // uncomment this line to see error
	}

}

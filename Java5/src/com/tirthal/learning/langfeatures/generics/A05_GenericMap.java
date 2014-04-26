package com.tirthal.learning.langfeatures.generics;

import java.util.HashMap;
import java.util.Map;

//---------------------------------------
//--- STEP 00 - HOW TO USE GENERIC WITH JAVA'S MAP INTERFACE? 
//---------------------------------------

/**
 * Test class to demonstrate type-safety using Generic Map
 * 
 * @author tirthalp
 */
public class A05_GenericMap {

	public static void main(String[] args) {

		// ---------------------------------------
		// --- STEP 01 - HOW TO ENSURE, MAP CAN ONLY ACCEPT INTEGER IN KEYS & STRING IN VALUES
		// ---------------------------------------
		Map<Integer, String> colors = new HashMap<Integer, String>();

		// ---------------------------------------
		// --- STEP 02 - ACCESSING MAP
		// ---------------------------------------
		colors.put(01, "Red");
		colors.put(02, "Blue");
		colors.put(03, "Black");

		/*
		 * If you try to add wrong type of key, then it will give compile time error - The method put(Integer, String) in the type Map<Integer,String>
		 * is not applicable for the arguments (String, String)
		 */
		// colors.put("C01", "White"); // Uncomment this line to see compile time error

		// ---------------------------------------
		// --- STEP 03 - ITERATING GENERIC MAP USING ENHANCED FOR LOOP
		// ---------------------------------------

		for (Integer c : colors.keySet()) {
			System.out.println("Key = " + c + " & Value = " + colors.get(c));
		}

		for (String str : colors.values()) {
			System.out.println("Color = " + str);
		}
	}
}

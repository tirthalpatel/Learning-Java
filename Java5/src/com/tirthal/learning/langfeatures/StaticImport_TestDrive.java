package com.tirthal.learning.langfeatures;

//---------------------------------------
//--- STEP 01 - HOW TO IMPORT STATIC MEMBERS? 
//---------------------------------------

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;


//If you import two static fields with same name explicitly e.g. Integer.MAX_VALUE and Long.MAX_VALUE then Java will throw compile time error.
// import static java.lang.Long.MAX_VALUE;

//But if other static modifier is not imported explicitly e.g. you have imported java.lang.Long.*, MAX_VALUE will refer to Integer.MAX_VALUE.
import static java.lang.Long.*;

//---------------------------------------
//--- STEP 00 - WHAT IS STATIC IMPORT? 
//---------------------------------------

///*
// * Java 1.5 - Language feature - Static imports = This facility lets you avoid qualifying static members with class names without the shortcomings of
// * the "Constant Interface antipattern."
// */

//---------------------------------------
//--- STEP 02 - HOW TO USE STATIC MEMBERS, IF STATIC IMPORT IS DONE AS SHOWN IN STEP 01? 
//---------------------------------------

/**
 * Test class for static imports feature. Also read comments in import statements.
 * 
 * @author tirthalp
 * 
 */
public class StaticImport_TestDrive {

	public static void main(String[] args) {
		// ------ Prior to Java 1.5 - without Static import        
		System.out.println("Maximum value of int variable in Java without " + "static import : " + Integer.MAX_VALUE);
		System.out.println("Minimum value of int variable in Java without " + "static import : " + Integer.MIN_VALUE);

		// ------ In Java 1.5 - using static import
		System.out.println("Maximum value of int variable using " + "static import : " + MAX_VALUE);
		System.out.println("Minimum value of int variable using " + "static import : " + MIN_VALUE);
	}
}

package com.tirthal.learning.tips;

import java.util.function.Supplier;

/**
 * Effective Java Tips (See Also: "Effective Java 3rd Edition Book by Joshua Bloch - Chapter 7"):
 * 
 * (1) While writing more constructors and methods that take function objects as parameters in Java 8, should favor 
 * the use of standard functional interfaces over custom-built one.
 * 
 * (2) In case of custom functional interface, annotate it with the @FunctionalInterface annotation.
 * 
 * When should write own custom functional interface? consider writing a purpose-built functional interface in 
 * preference to using a standard one if you need a functional interface that shares one or more of the following 
 * characteristics (e.g. {@link java.util.Comparator}): 
 * 	- It will be commonly used and could benefit from a descriptive name. 
 * 	- It has a strong contract associated with it. 
 * 	- It would benefit from custom default methods.
 * 
 * @author tirthalp
 */
public class EffectiveJavaTip02 {

	/*
	 * Strategy pattern to generate password - should consider custom-built functional interface or Java 8 provided standard one?
	 */
	
	// Unnecessary custom PasswordGenerator functional interface; rather can use a standard one
	
	public static String generatePassword(PasswordGenerator passwordGenerator) {
		return passwordGenerator.generate();
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	// Tip: Favor the use of standard functional interfaces (e.g. Supplier in Java 8) over custom-built one (e.g. PasswordGenerator)
	// -------------------------------------------------------------------------------------------------------------------
	
	public static String generatePassword(Supplier<String> passwordGenerator) {
		return passwordGenerator.get();
	}	
}

//--------------------------------------------------------------------------------------------------
// Tip: In case of custom functional interface, annotate it with the @FunctionalInterface annotation
// -------------------------------------------------------------------------------------------------
@FunctionalInterface
interface PasswordGenerator {
	
	String generate(); 
	
	/*
	 * If you have more than one method in this interface, then @FunctionalInterface would inform compiler to throw
	 * compile time error. Uncomment below line and see.
	 */	
	//String generate(int length);
}
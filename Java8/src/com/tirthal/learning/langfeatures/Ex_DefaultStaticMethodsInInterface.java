package com.tirthal.learning.langfeatures;

import java.util.Date;

/*
 * ------------------- PURPOSE OF DEFAULT AND STATIC METHODS IN INTERFACE DECLARATION? -----------------------------
 * Default methods enable you to add new functionality to the interfaces of your libraries and ensure binary
 * compatibility with code written for older versions of those interfaces. In addition to default methods, you can
 * define static methods in interfaces which makes it easier for you to organize helper methods in your libraries; 
 * you can keep static methods specific to an interface in the same interface rather than in a separate class.
 * For more detail, see @ http://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html
 */

/**
 * This example program focuses to explain two new concepts - default and static methods, which are added in Java 8
 * interface declarations.
 * 
 * @author tirthalp
 *
 */
public class Ex_DefaultStaticMethodsInInterface {

	public static void main(String[] args) {

		// Calling static method of Interface
		Printer.displayCurrentDate();

		// Call default method of interface using implementation class instance
		Printer simple = new SimplePrinter();
		simple.healthStatus();

		// Call overridden default interface method using implementation class instance
		Printer color = new ColorPrinter();
		color.healthStatus();
	}

}

//Below interface and implementation classes providing syntax demo of default and static methods in Java 8 interfaces!

/*
 * In below code, just imagine that Printer interface having only abstract print() method and is implemented by
 * implementation classes.
 * 
 * Now you need to add new functionality to show status of printer's health, but you also wish to ensure backward
 * compatibility for older versions. So now using "default" keyword, you can provide default method implementation in
 * interface itself and all the implementers will inherit it by default (with a possibility to override this default
 * implementation if needed). For example, healthStatus() is added to interface as default method.
 * 
 * Important Note 1 --- When you "extend" an interface that contains a default method, you can do the following in child
 * interface: (1) Not mention the default method at all, which lets your extended interface inherit the default method.
 * (2) Redeclare the default method, which makes it abstract. (3) Redefine the default method, which overrides it.
 * 
 * Important Note 2 --- In the case of a class implementing multiple interfaces with the same default method signature,
 * the compiler will throw an error to prevent the diamond problem.
 */

interface Printer {

	// The abstract method which implementation classes has to implement
	void print();

	// --- Now interface can have default method implementation and static methods in Java 8 ---

	// Declare default methods with "default" keyword and provide implementation which are implicitly public
	// All implementors will inherit it by default
	default void healthStatus() {
		System.out.println("Default method in interface --- Printer health is OK!");
	}

	// Declare static methods with "static" keyword like we do in classes which are implicitly public
	// Relevant utility or helper methods can be provided as part of interface itself using static methods
	static void displayCurrentDate() {
		System.out.println("Static method in interface --- Date: " + new Date().toString());
	}

}

class SimplePrinter implements Printer {

	@Override
	public void print() {
		System.out.println("Printing only black and white pages...");
	}
}

class ColorPrinter implements Printer {

	@Override
	public void print() {
		System.out.println("Printing color pages...");
	}

	// Overriding the default interface provided behavior
	public void healthStatus() {
		System.out.println("Overriding default method of interface --- Color Printer health is verified using special instructions and it is OK!");
	}
}
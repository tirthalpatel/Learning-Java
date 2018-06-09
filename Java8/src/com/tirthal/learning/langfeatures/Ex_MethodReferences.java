package com.tirthal.learning.langfeatures;

import java.util.Arrays;

/**
 * This is example class to demo syntax of using method references in Java 8
 * 
 * <p>Method references (::) - provide the useful syntax to refer directly to exiting methods or constructors of Java
 * classes or objects (instances). With conjunction of Lambdas expressions, method references make the language
 * constructs look compact and concise, leaving off boilerplate.
 * 
 * @author tirthalp
 *
 */
public class Ex_MethodReferences {

	public static void main(String[] args) {
		String[] stringArray = { "Robert", "Barbara", "Mary", "Michael", "John", "Patricia", "James", "Linda" };
		
		// IMPORTANT NOTE: The target type of method references (::) expression must be a functional interface		
		
		System.out.println("******************* Static method reference syntax = Class::staticMethod");
		Runnable r = Foo::exStaticMethod;
		r.run();
		// equivalent to:
		r = () -> Foo.exStaticMethod();
		r.run();
		// equivalent to:
		r = new Runnable() {
			@Override
			public void run() {
				Foo.exStaticMethod();
			}
		};
		r.run();
		
		System.out.println("******************* Instance method reference syntax = instance::instanceMethod");
		Foo f = new Foo();
		r = f::exInstanceMethod;
		r.run();
		// equivalent to:
		r = () -> f.exInstanceMethod();
		r.run();

		// Another example for instance method having two arguments
		class ComparisonProvider {
			public int dontCompare(String a, String b) {
				return 1;
			}
		}
		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		/*
		 * The method reference myComparisonProvider::dontCompare invokes the dontCompare() that is part of the object
		 * myComparisonProvider. The JRE infers the method type arguments, which in this case are (String, String).
		 */
		Arrays.sort(stringArray, myComparisonProvider::dontCompare);
		// equivalent to
		Arrays.sort(stringArray, (String a, String b) -> myComparisonProvider.dontCompare(a, b));
		
		System.out.println(Arrays.toString(stringArray));

		
		System.out.println("******************* Reference to a method of arbitrary instance syntax = Class::instanceMethod");
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		// equivalent to
		Arrays.sort(stringArray, (String a, String b) -> a.compareToIgnoreCase(b));

		System.out.println(Arrays.toString(stringArray));

		
		System.out.println("******************* Constructor reference syntax = Class::new");
		r = Foo::new;
		r.run();
		// equivalent to:
		r = () -> new Foo();
		r.run();
	}
}

/**
 * Sample Foo class
 * 
 * @author tirthalp
 *
 */
class Foo {
	// Constructor
	Foo() {
		System.out.println("Hi, I am constructor");
	}

	// Static method
	public static void exStaticMethod() {
		System.out.println("Hi, I am static method");
	}

	// Instance method
	public void exInstanceMethod() {
		System.out.println("Hi, I am instance method");
	}
}
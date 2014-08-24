package com.tirthal.learning.langfeatures.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The demo syntaxes of different ways to write lambda expression
 * 
 * @author tirthalp
 */
public class Ex02_LambdaSyntaxes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// --------------------
		// --- Option 1: The simplest way when only single line of code in body
		FileFilter javaFilter = (File file) -> file.getName().endsWith(".java");
		
		// How to use lambda expression?
		File dir = new File("D:\\x-temp\\"); // configure some folder path having java and other files
		File[] javaFiles = dir.listFiles(javaFilter); // pass "javaFilter" (lambda/function) as an argument
		// for each pathname in pathname array
        for(File file:javaFiles)
        {           
           System.out.println(file);
        }
		
		
		// --------------------
		// --- Option 2: When having more than one line of code in body
		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello World");
			}
		};
		
		// How to use lambda expression?
		Thread t = new Thread(r); // pass "r" (lambda/function) as an argument
		t.start();

		// --------------------
		// --- Option 3: When having more than one argument
		Comparator<String> c = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
		// Most of time parameter types can be omitted, so above line becomes
		c = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		
		// How to use lambda expression?
		List<String> fruits = Arrays.asList("banana", "orange", "apple", "mango");
		Collections.sort(fruits, c); // pass "c" (lambda/function) as an argument
		// Because of java 8 collection framework enhancements and new java.util.function package, lambda in forEach works like magic
		fruits.forEach(e -> System.out.println(e));
	}

}

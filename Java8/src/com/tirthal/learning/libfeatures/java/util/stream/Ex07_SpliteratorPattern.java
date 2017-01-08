package com.tirthal.learning.libfeatures.java.util.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Example code to understand Spliterator Pattern
 * 
 * <p>
 * The Spliterator is a new interface in Java 8, on which a Stream is built and that models the access to the data for a
 * Stream. It is an object for traversing and partitioning elements of a source. The source of elements covered by a
 * Spliterator could be, for example, an array, a Collection, an IO channel, or a generator function. <br/><br/>
 * 
 * A stream is divided in two things: (1) An object to access the data, this is the Spliterator - it is meant to be
 * overriden to suit our needs (2) An object to handle the processing of the data, this is the ReferencedPipeline - it
 * is a very complex object, we do not need to override it <br/><br/>
 * 
 * Example of Spliterator implementation, See {@link java.util.ArrayList#spliterator()}
 * </p>
 * 
 * @see https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html
 * @author tirthalp
 */
public class Ex07_SpliteratorPattern {

	/*
	 * Problem statement: Ex06_Books.txt contains each book data in five lines, so how to traverse and partition
	 * elements of such a source.
	 * 
	 * Solution approach: Write a custom Spliterator
	 */
	
	public static void main(String[] args) {
		
		// ---> Set up to read source file
		Path inputSource = Paths.get("src\\com\\tirthal\\learning\\libfeatures\\java\\util\\stream\\Ex07_Books.txt");		
		
		try (Stream<String> lines = Files.lines(inputSource);) {
			// lines.forEach(System.out::println);
			
			// ---> Implementation and usage of custom Spliterator
			Spliterator<String> lineSpliterator = lines.spliterator();
			
			Spliterator<Ex07_Book> bookSpliterator = new Ex07_BookSpliterator(lineSpliterator);			
			Stream<Ex07_Book> books = StreamSupport.stream(bookSpliterator, false); // false = not supporting parallel stream
			
			System.out.println("****** Which books having price less than 1000 INR?");
			books.peek(book -> System.out.println("\n" + book))
				 .filter(book -> book.getPrice() < 1000)
				 .forEach(book -> System.out.println(" ---> PRICE is LESS THAN 1000"));
			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
}

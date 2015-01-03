package com.xtra_ref.transforming_code_to_java_8.exercise_4.after;

import static java.util.stream.Collectors.joining;

import java.io.File;
import java.util.stream.Stream;

public class Sample {
	public static void main(String[] args) {
		File aDirectory = new File(".");

		// Java 8 code transformation - read files in current directory
		System.out.println(Stream.of(aDirectory.listFiles())				// stream of list of files in current directory
											   .map(File::getName)			// map name of file for each element in the stream
											   .collect(joining(", ")));	// join each element of map using comma and return the reduced result 
		// Java 8 code transformation - read files in current directory
	}
}
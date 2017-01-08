package com.tirthal.learning.libfeatures.java.other;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demo code of I/O enhancements in Java 8
 * 
 * @author tirthalp
 */
public class IOEnhancementsDemo {

	public static void main(String[] args) {		
		
		// Java 7: use of Path and try with resources
		Path rootPath = Paths.get(".");
		
		// List of directories at 1st level
		try(Stream<Path> paths = Files.list(rootPath)) { // list() - added in Java 8
			String directories = paths.filter(p -> p.toFile().isDirectory())
									 .map(p -> p.getFileName().toString())
									 .collect(Collectors.joining(","));
			System.out.println("List of directories at 1st level:" + directories + "\n");
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		// List of directories unto 3 levels
		try(Stream<Path> paths = Files.walk(rootPath, 3)) { // walk() - added in Java 8
			String directories = paths.filter(p -> p.toFile().isDirectory())
									 .map(p -> p.getFileName().toString())
									 .collect(Collectors.joining(","));
			System.out.println("List of directories upto 3 levels:" + directories + "\n");
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		// README file: which all lines having length greater than 30
		Path readmeFilePath = Paths.get(".", "README.md");		
		try(Stream<String> lines = Files.lines(readmeFilePath, Charset.defaultCharset())) { // lines() - added in Java 8
			lines.filter(line -> line.length() > 30)
				 .forEach(System.out::println);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}

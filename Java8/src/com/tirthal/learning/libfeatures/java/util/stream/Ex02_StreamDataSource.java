package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Example code to understand Stream Data Source
 * 
 * Streams can be obtained in a number of ways. Some examples include: (1) From a Collection via the stream() and
 * parallelStream() methods; (2) From an array via Arrays.stream(Object[]); (3) From static factory methods on the
 * stream classes, such as Stream.of(Object[]), IntStream.range(int, int) or Stream.iterate(Object, UnaryOperator); (4)
 * The lines of a file can be obtained from BufferedReader.lines(); (4) Streams of file paths can be obtained from
 * methods in Files; (5) Streams of random numbers can be obtained from Random.ints(); (6) Numerous other stream-bearing
 * methods in the JDK, including BitSet.stream(), Pattern.splitAsStream(java.lang.CharSequence), and JarFile.stream().
 * 
 * @author tirthalp
 */
public class Ex02_StreamDataSource {

	public static void main(String[] args) {
		
		// From a Collection via the stream() and parallelStream() methods		
		List<String> colorsList = Arrays.asList("red", "blue", "black");		
		colorsList.stream().forEach(e -> System.out.println("Color:" + e));
		colorsList.parallelStream().forEach(e -> System.out.println("Color:" + e));
		
		// From an array via Arrays.stream(Object[])
		Arrays.stream(new String[] {"apple", "orange", "banana"}).forEach(e -> System.out.println("Fruit:" + e));		
		
		// From static factory methods on the stream classes
		Stream.of("english", "french", "hindi").forEach(e -> System.out.println("Language:" + e));
		
		IntStream.range(1, 6).forEach(e -> System.out.println("Number:" + e));				
	}

}

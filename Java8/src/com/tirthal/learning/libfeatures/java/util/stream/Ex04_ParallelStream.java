package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example code to understand parallel streams
 * 
 * <p>
 * Do you want to leverage the computing power of multicore CPUs, specifically for efficiently processing large amounts
 * of data? Go for parallel streams...
 * </p>
 * 
 * <p>
 * In practice, it's better off not enabling parallel processing unless expecting the data source to contain a very
 * large set of items that will be processed. That’s because there is overhead associated with multithreading and
 * there’s a threshold below which that overhead will exceed the performance gain from using multiple threads. In other
 * words, if parallelStream() is used with a small set of data, there’s a good chance that performance will actually be
 * worse than if it has used the single-threaded stream() equivalent. For larger sets of data, though, it may be
 * worthwhile to take advantage of parallel stream support. In fact, this is arguably a bigger advantage of the Streams
 * API than the elimination of boilerplate code: it allows Java applications to easily provide better support for “big
 * data” applications than would be possible otherwise. (Reference: Page 92 of Java 8 Pro Programming 3rd Edition Book)
 * 
 * All in all, use parallel streams, when (1) problem on hand is actually parallelizable (2) willing to spend lot more
 * resources to get faster answer (3) data size or task computation is bit enough to get benefit in performance.
 * </p>
 * 
 * @author tirthalp
 */
public class Ex04_ParallelStream {

	public static void main(String[] args) {
		
		// Just assume, here data source containing a very large set of data to be processed
		List<String> words = Arrays.asList("apple", "red", "bike", "book", "phone", "laptop", "hello", "age", "bottle", "...");
		
		// Just use parallelStream() instead of stream() to leverage the computing power of multicore CPUs
		List<String> filteredDecoratedWords = words.parallelStream().
				filter(e -> (e.startsWith("a") || e.startsWith("b"))).	// need word starting with "a" or "b"
				filter(e -> (e.endsWith("e"))).							// need word ending with "e"
				sorted().												// sort filtered words
				map(e -> "*"+e+"*").									// decorate each word with * as prefix and suffix
				collect(Collectors.toList());			
		
		System.out.println(filteredDecoratedWords);
	}

}

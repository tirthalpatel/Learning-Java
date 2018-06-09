package com.tirthal.learning.libfeatures.java.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example code to understand parallel streams
 * 
 * <p>
 * Do you want to leverage the computing power of multicore CPUs, specifically for efficiently processing large amounts
 * of data pipelines? Go for parallel streams...
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
 * resources to get faster answer (3) data size or task computation is big enough to get benefit in performance.
 * </p>
 * 
 * @author tirthalp
 */
public class Ex04_ParallelStream {

	/* 
	 * Important Tips:
	 *  
	 * (1) Use parallel streams with Stateless operations (filter, map...)
	 * 		- Stateful operations (limit, skip, sort and distinct) should not be used in parallel, b'cas it will kill performance! 
	 * 		- How to find Stateful operations? It's written in the Javadoc
	 * 
	 * (2) Parallel reductions: use collectors instead of reduce(), b'cas it will handle parallelism and thread-safety
	 */
	public static void main(String[] args) {
		
		// ---------------------------------------
		// ----------> How to use parallel stream?
		// ---------------------------------------
		
		createParallelStream();				
		
		// -----------------------------------------------------
		// ----------> See how parallel reduction can go wrong?
		// -----------------------------------------------------

		tryThreadSafetyIssueInParallelStream();
		
		// ---------------------------------------------
		// ----------> Be aware, Multithread != Parallel
		// ----------------------------------------------	
		/*
		 * Be aware, Multithread != Parallel
		 * 		- Multithread ---> one process = one thread, so many processes at the same time [Challenges: race condition, thread synchronization, variable visibility]
		 * 		- Parallel ---> one process = many thread, to go faster [Challenges: algorithm, data distribution among the CPU cores]
		 * 
		 * Tools for Parallel Processing in the JDK?
		 * 		- Java 6 and before: None! (complex coding by developer)
		 * 		- Java 7: The fork/join framework
		 * 		- A 3rd party API: parallel arrays (Java 6 compatible)
		 * 		- Java 8: Parallel streams (built on top of the fork/join pattern)
		 * 
		 * How to tune pool of threads for Parallelism?
		 *  	- By default, the Fork/Join takes all available CPUs
		 * 		- It uses a pool of threads: the common fork / join pool
		 * 		- Can control this pool: System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		 */
	}
	
	private static void createParallelStream() {
		// Just assume, here data source containing a very large set of data to be processed
		List<String> words = Arrays.asList("apple", "red", "bike", "book", "phone", "laptop", "hello", "age", "bottle", "...");
		
		// Just use parallelStream() instead of stream() to leverage the computing power of multicore CPUs
		
		// Pattern 1: Using parallelStream()
		List<String> filteredDecoratedWords1 = words.parallelStream()
													.unordered()											// set the ORDERED bit to 0
													.filter(e -> (e.startsWith("a") || e.startsWith("b")))	// need word starting with "a" or "b"
													.filter(e -> (e.endsWith("e")))							// need word ending with "e"													
													.map(e -> "*"+e+"*")									// decorate each word with * as prefix and suffix
													.peek(e -> System.out.println(e + " is processed in thread: " + Thread.currentThread().getName()))
													.collect(Collectors.toList());			
		
		System.out.println(filteredDecoratedWords1);
		System.out.println("===========");
		
		// Pattern 2: Using parallel() on an existing stream
		List<String> filteredDecoratedWords2 = words.stream()													
													.parallel()													
													.unordered()											// set the ORDERED bit to 0
													.filter(e -> (e.startsWith("a") || e.startsWith("b")))	// need word starting with "a" or "b"
													.filter(e -> (e.endsWith("e")))							// need word ending with "e"													
													.map(e -> "*"+e+"*")									// decorate each word with * as prefix and suffix													
													.peek(e -> System.out.println(e + " is processed in thread: " + Thread.currentThread().getName()))
													.collect(Collectors.toList());			
		
		System.out.println(filteredDecoratedWords2);		
		System.out.println("===========");
	}		

	private static void tryThreadSafetyIssueInParallelStream() {
		List<String> strings = new ArrayList<>();
		
		// Below runs on single thread, so no issue even if ArrayList is not thread-safe
		Stream.iterate("+", s -> s + "+")
			  .limit(500)
			  .forEach(strings::add);
		System.out.println("Correct size="+strings.size()); // Expected outcome = 500		
		
		// Below runs concurrently on multiple threads, so highly likely to get wrong results, b'cas ArrayList is not thread-safe
		strings.clear();
		Stream.iterate("+", s -> s + "+")
			  .parallel()
			  .limit(500)
			  .forEach(strings::add);
		System.out.println("May get unexpected result with parallel, bcas ArrayList is not thread-safe="+strings.size()); // Expected outcome = 500				
		
		// How about using concurrent Thread-safe list? - Correct result, but not performance efficient approach
		strings = new CopyOnWriteArrayList<>();
		Stream.iterate("+", s -> s + "+")
			  .parallel()
			  .limit(500)
			  .forEach(strings::add);
		System.out.println("Correct size="+strings.size()); // Expected outcome = 500	
		
		// Suggested approach = Usage of Collector pattern
		strings = Stream.iterate("+", s -> s + "+")
						.parallel()
						.limit(500)
						.collect(Collectors.toList());
		System.out.println("Correct size="+strings.size()); // Expected outcome = 500
		
		/*
		 * Well, in above code, output is as expected with usage of parallel stream. What about performance?
		 * 
		 * REMEMBER -
		 * 
		 * (1) Parallelizing a pipeline is unlikely to increase its performance if the source is from Stream.iterate, or
		 * the intermediate stateful operations (e.g. limit) is used. In fact, stateful intermediary operations (limit,
		 * skip, sort...) should not be used in parallel, b'cas it may even kill performance in some cases.
		 * 
		 * (2) Not only can parallelizing a stream lead to poor performance, including liveness failures; it can lead to
		 * incorrect results and unpredictable behavior (safety failures). Safety failures may result from parallelizing
		 * a pipeline that uses mappers, filters, and other programmer-supplied function objects that fail to adhere to
		 * their specifications.
		 */
		
		System.out.println("===========");
	}
}
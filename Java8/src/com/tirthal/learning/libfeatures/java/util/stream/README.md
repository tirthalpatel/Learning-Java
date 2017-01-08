# Package java.util.stream

Classes to support functional-style operations on streams of elements, such as map-reduce transformations on collections. For example:

     int sum = widgets.stream()
                      .filter(b -> b.getColor() == RED)
                      .mapToInt(b -> b.getWeight())
                      .sum();

## Description

* What is Stream in Java?	
	- An object on which one can define operations, i.e. map, filter, reduce
	- An object that does not hold any data, rather it pulls data it processes from a source
	- An object that should not change the data it processes (compiler/jvm does not enforce for this, but this guideline must be followed for any custom stream implementation)	
	- An object optimized from the algorithm point of view, and able to process data in parallel
	- Actually not a physical object with data unlike list or set, rather just an abstraction containing bunch of functions (non mutating pipeline)

* The Streams API in Java 8 supports a different type of iteration where you simply define the set of items to be processed, the operation(s) to be performed on each item, and where the output of those operations is to be stored. A “stream” consists of three parts.
	- Data source: As its name implies, this part of the stream defines where the data comes from, such as a List or other object representing a collection.
	- Intermediate operations: These are the operations to be performed on the data, such as filtering or transformation operations.
	- Terminal operation: This describes what to do with the processed data, as well as	determines when (or if) to stop processing the data. Only one terminal operation can be specified per stream.

* Tips
	- For functional programming, should not modify state
	- Avoid loops in streams
	- Be careful with parallel streams, For example, use parallel streams with Stateless operations (filter, map...) and don't use with Stateful operations (limit, skip, sort...)

## Sample Code

* [Understanding Stream by Hello World](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex01_StreamHelloWorld.java)
* [Understanding Stream Data Source](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex02_StreamDataSource.java)
* [Understanding Intermediary and Terminal Operations on a Stream](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex03_IntermediaryVsTerminalOp.java)
* [Fundamentals of Parallel Stream](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex04_ParallelStream.java)
* [Usage of Collector as a special type of Reduction](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex05_CollectorUsage.java)
* [Tip: Avoid loops](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex06_TipAvoidLoops.java)
* [Understanding Spliterator Pattern](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream/Ex07_SpliteratorPattern.java)

## Further References

* http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
* http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
* http://docs.oracle.com/javase/tutorial/collections/streams/index.html
# Java 8
This project contains sample code (along with easy to understand comments) to learn new features and enhancements in Java 8.

Related post is [here](http://tirthalpatel.blogspot.in/2015/08/java8-highlights-of-new-features-and-enhancements.html)


## How to use?

Just import this project in Eclipse Luna (or any other version supporting Java 8) as an "Existing Maven Project". If require, do necessary configuration to fix build path errors (e.g. setup JRE 1.8 Libraries).

## New Language Features

* [Lambda Expressions/Closures](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/langfeatures/lambda) : specifically supporting the ability to define and pass method (or function) references within application code
* [Default and Static Methods in Interfaces](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_DefaultStaticMethodsInInterface.java)
* [Method References](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_MethodReferences.java)
* [Improved Type Inference in Generics](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_GenericsTypeInference.java)
* Type Annotations : see [reference-1](https://docs.oracle.com/javase/tutorial/java/annotations/type_annotations.html), [reference-2](https://blogs.oracle.com/java-platform-group/entry/java_8_s_new_type)
* Repeating Annotations : see [reference-1](https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html)

## New Features in Java libraries

* Collection framework enhancements with Functional interfaces and Stream API	
	- [java.util.function](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function) : A new package that contains general purpose functional interfaces that provide target types for lambda expressions and method references	
	- [java.util.stream](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream) : A new package that contains classes to support functional-style operations on streams of elements, such as map-reduce transformations on collections
	- [collection framework enhancements](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/util/cf) : The Java Collections Framework has been updated to support lambda expressions, streams, and aggregate operations	
* [Concurrency Enhancements](https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/changes8.html): New classes and interfaces in java.util.concurrent; New methods in java.util.concurrent.ConcurrentHashMap; New classes in java.util.concurrent.atomic.
* [The Date-Time API](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/time) : New set of java.time packages that provide a comprehensive date-time model [see](http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html)
* [Nashorn](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/nashorn) : A JavaScript Engine on the JVM
* Other Bits and Pieces
	- [Optional](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/other/OptionalDemo.java) : A container object which may or may not contain a non-null value
	- [StringJoiner](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/other/StringJoinerDemo.java) : Used to construct a sequence of characters separated by a delimiter and optionally starting with a supplied prefix and ending with a supplied suffix
	- [I/O Enhancements](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/java/other/IOEnhancementsDemo.java) : New methods added (like list, walk, lines) in java.nio.file.Files to return Stream of elements

## New Features in Java compiler

* [Method Parameter Reflection via "-parameter" option](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_MethodParameterReflection.java)
* [Compact Profiles via "-profile" option](http://docs.oracle.com/javase/8/docs/technotes/guides/compactprofiles/) : Enable reduced memory footprint for applications that do not require the entire Java platform

## Practice Code

* [Comparison of before Java 8 vs. from Java 8 way of coding](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/exercises/cmp)

## Effective Java Tips and Unit Test Code

* [Effective Java Tips](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/tips)
* [JUnit Implementation](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/test/com/tirthal/learning/tips)

## References

* [Java 8 Features Tutorial – The Ultimate Guide by Andrey Redko](http://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html)
* [What's New in JDK 8 - Oracle Release Notes](http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)
* [Miscellaneous Java 8 Tutorials / Sample Code References authored by Experts](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/xtra_ref)


## Disclaimer

The code snippet are mainly targeted for learning purpose, and not focused for producing production code quality.
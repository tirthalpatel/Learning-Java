# Java 8
This project contains sample code (along with easy to understand comments) to learn new features and enhancements in Java 8.

Related post is [here](http://tirthalpatel.blogspot.in/2015/08/java8-highlights-of-new-features-and-enhancements.html)


## How to use?

Just import this project in Eclipse Luna (or any other version supporting Java 8) as an existing project, do necessary configuration to fix build path errors (e.g. setup JRE 1.8 Libraries).


## New Language Features
* [Lambda Expressions/Closures](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/langfeatures/lambda)
* [Default and Static Methods in Interfaces](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_DefaultStaticMethodsInInterface.java)
* [Method References](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_MethodReferences.java)
* [Improved Type Inference in Generics](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_GenericsTypeInference.java)
* Type Annotations : see [reference-1](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_TypeAnnotations.java), [reference-2](https://blogs.oracle.com/java-platform-group/entry/java_8_s_new_type)
* Repeating Annotations : see [reference-1](https://docs.oracle.com/javase/tutorial/java/annotations/repeating.html)


## New Features in Java compiler
* [Method Parameter Reflection via "-parameter" option](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/langfeatures/Ex_MethodParameterReflection.java)
* [Compact Profiles via "-profile" option](http://docs.oracle.com/javase/8/docs/technotes/guides/compactprofiles/) - Enable reduced memory footprint for applications that do not require the entire Java platform


## New Features in Java libraries
* Collection framework enhancements & Stream API
	- [java.util.stream](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/util/stream): A new package that contains the majority of interfaces and classes that provide functionality to streams and aggregate operations
	- [java.util.function](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/java/util/function): A new package that contains general purpose functional interfaces that provide target types for lambda expressions and method references
* Date and Time API
* [Nashorn JavaScript Engine](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/tirthal/learning/libfeatures/nashorn)
* Other Bits and Pieces
	- Java FX 8


## References:
* [Java 8 Features Tutorial – The Ultimate Guide by Andrey Redko](http://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html)
* [What's New in JDK 8 - Oracle Release Notes](http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)
* [Miscellaneous Java 8 Tutorials / Sample Code References authored by Experts](https://github.com/tirthalpatel/Learning-Java/tree/master/Java8/src/com/xtra_ref)


## Disclaimer:
The code snippet are mainly targeted for learning purpose, and not focused for producing production code quality.
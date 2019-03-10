# Java 11

This project contains sample code (along with easy to understand comments) to learn new features and enhancements in Java 11.

__Java 11 GA release date__: September 25th 2018

## How to use?

Just import this project in Intellij / Eclipse as an "Existing Maven Project". If require, do necessary configuration to fix build path errors (e.g. JDK 11).

## New Language Features

* [JEP 323: Local-Variable Syntax for Lambda Parameters](https://github.com/tirthalpatel/Learning-Java/blob/master/Java11/src/main/java/com/tirthal/learning/langfeatures/LocalVar4Lambda.java) - The reserved type name var can now be used when declaring the formal parameters of a lambda expression

## New Features or Enhancements in Java libraries

* [New HttpClient API](https://github.com/tirthalpatel/Learning-Java/blob/master/Java11/src/main/java/com/tirthal/learning/libfeatures/NewHttpClientApiDemo.java) - Replacement for java.net.HttpURLConnection
* [New methods in java.lang.String](https://github.com/tirthalpatel/Learning-Java/blob/master/Java11/src/main/java/com/tirthal/learning/libfeatures/NewMethodsInStringDemo.java) - Added new methods isBlank, repeat, strip, etc. 
* [JDK 10.0.2 to 11 API Change Report](https://gunnarmorling.github.io/jdk-api-diff/jdk10-jdk11-api-diff.html)

## Odds and ends

* JEP 330: Launch Single-File Source-Code Programs 
    * [Eliminates the need to compile a single-file application](https://github.com/tirthalpatel/Learning-Java/blob/master/Java11/src/main/java/com/tirthal/learning/misc/launcher/ListFiles.java) - Run directly without compiling the code, e.g. `java ListFiles.java .`
    * [Offers ‘--source 11’ option to run a single-file application which has file name without java extension](https://github.com/tirthalpatel/Learning-Java/blob/master/Java11/src/main/java/com/tirthal/learning/misc/launcher/listfiles2) - Run it using `java --source 11 listfiles1 .`
    * [Provides ‘shebang - #!’ support to run a single-file application as a script](https://github.com/tirthalpatel/Learning-Java/blob/master/Java11/src/main/java/com/tirthal/learning/misc/launcher/listfiles2) - Run it using `.listfiles2 .`
* Deprecations and Removals 
    * [Removed The Java EE and CORBA Modules](https://openjdk.java.net/jeps/320)
    * [JavaFX moved out of JDK](https://wiki.openjdk.java.net/display/OpenJFX/Main) - JavaFX is part of Oracle JDK 8, 9 and 10; however, Java 11 no longer bundled it and rather it's separate download now from OpenJFX
    * Removed: Applets, Java Web Start
    * Removed: Java Mission Control (was shipped in JDK 7, 8, 9, and 10, is no longer included with the Oracle JDK, and rather now a separate download)
    * Deprecated: Nashorn (rather consider Graal.js)
    * For more detail, [see](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html#Removed) 
* [JEP 181: Nest-Based Access Control](https://openjdk.java.net/jeps/181) - JVM introduces nests, an access-control context that aligns with the existing notion of nested types in the Java programming language
* Performance improvements
    * [JEP 318: Epsilon: A No-Op Garbage Collector (Experimental)](https://openjdk.java.net/jeps/318) - Useful for apps with predictable, bounded memory usage; Short-lived programs; Performance testing
    * [JEP 331 Low-Overhead Heap Profiling](http://openjdk.java.net/jeps/331) - Provide a low-overhead way of sampling Java heap allocations, and can give information about both live and dead Java objects
    * [JEP 333: ZGC: A Scalable Low-Latency Garbage Collector (Experimental)](https://openjdk.java.net/jeps/333) - Having pause time under 10ms, No pause time increase with heap size increase; Scale to multi-terabyte heaps    
* Security improvement - [JEP 332: Transport Layer Security (TLS) 1.3](https://openjdk.java.net/jeps/332) - Legacy algorithms pruned; Implemented TLS 1.3 (not all of TLS 1.3 implemented)
* [Differences between Oracle JDK and OpenJDK](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html#Diffs)

## References

* [Download JDK 11](https://jdk.java.net/11/)
* [JDK 11 Release Notes](https://www.oracle.com/technetwork/java/javase/11-relnote-issues-5012449.html)
* [90 New Features and APIs in JDK 11](https://dzone.com/articles/90-new-features-and-apis-in-jdk-11)

## Disclaimer

The code snippet are mainly targeted for learning purpose, and not focused for producing production code quality.
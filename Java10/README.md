# Java 10

This project contains sample code (along with easy to understand comments) to learn new features and enhancements in Java 10.

Related post is [here](https://tirthalpatel.blogspot.com/2019/05/java9-10-11-highlights-of-new-features-and-enhancements.html)

__Java 10 release date__: March 2018

## How to use?

Just import this project in Intellij / Eclipse as an "Existing Maven Project". If require, do necessary configuration to fix build path errors (e.g. JDK 10).

## New Java Release Schedule

* Traditional Java Release Cadence (till Java 9) = Big, feature-driven releases (e.g. Lambda and Stream in Java 8, Modular System in Java 9) => Frequent delays in planned release dates
* __Time-based Java Release Cadence__ (After Java 9) = A new feature release every six months and LTS (long term support) release every 3 years (e.g. Java 11 LTS release planned in Sep-2018, Java 17 LTS to be released in Sep-2021,...)
* See [JEP 322: Time-Based Release Versioning](https://openjdk.java.net/jeps/322)

## New Language Features

* [Local-variable Type Inference](https://github.com/tirthalpatel/Learning-Java/blob/master/Java10/src/main/java/com/tirthal/learning/langfeatures/LocalVarTypeInferenceDemo.java) - Support type inference to declarations of local variables with initializers ([see](https://openjdk.java.net/jeps/286))

## Enhancements in Java libraries

*  [Optional.orElseThrow() Method](https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8140281) - A new method orElseThrow has been added to the Optional class
* [APIs for Creating Unmodifiable Collections](https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8177290) - Several new APIs have been added that facilitate the creation of unmodifiable collections (the List.copyOf, Set.copyOf, and Map.copyOf methods create new collection instances from existing instances. New methods toUnmodifiableList, toUnmodifiableSet, and toUnmodifiableMap have been added to the Collectors class in the Stream package. These allow the elements of a Stream to be collected into an unmodifiable collection.)

## Odds and ends

* Performance improvements
    * [JEP 307: Parallel Full GC for G1](https://openjdk.java.net/jeps/307) - To improve G1 worst-case latencies by making the full GC parallel (Java 9 has serial full GC, but Java 10 has Parallel Full GC for G1GC)
    * [JEP 310: Application Class-Data Sharing](https://openjdk.java.net/jeps/310) - To improve VM start-up time and reduce memory footprint by shared lib of class metadata (specifically useful with multiple VMs running same code, or repeated executions)
* [Oracle's Root CA program to be ported to OpenJDK](https://openjdk.java.net/jeps/319) - To provide a default set of root Certification Authority (CA) certificates in the JDK
* [Removed the Native-Header Generation Tool (javah)](https://openjdk.java.net/jeps/313) - Use `javac -h <dir>` instead of javah
* [Hashed Passwords for Out-of-the-Box JMX Agent](https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-5016517) - The clear passwords present in the jmxremote.password file are now being over-written with their SHA3-512 hash by the JMX agent
* Improved container awareness - Java now detects container (Linux and Docker only) 
* Oracle's Goal: Convergence of Oracle & OpenJDK codebases to open source its commercial features (e.g. Java Flight Recorder and Java Mission Control) in OpenJDK

## References

* [Download JDK 10](https://jdk.java.net/10/)
* [JDK 10 Features](https://openjdk.java.net/projects/jdk/10/)
* [Release Notes for JDK 10 and JDK 10 Update Releases](https://www.oracle.com/technetwork/java/javase/10all-relnotes-4108743.html)
* [What's New in JDK 10 - New Features and Enhancements](https://www.oracle.com/technetwork/java/javase/10-relnote-issues-4108729.html)
* [109 New Features in JDK 10](https://www.azul.com/109-new-features-in-jdk-10/)

## Disclaimer

The code snippet are mainly targeted for learning purpose, and not focused for producing production code quality.
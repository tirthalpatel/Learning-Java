# Jigsaw Project

Introduces a new kind of Java programing component, the module, which is a named, self-describing collection of code and data.

* Modular JDK
* Modular Java Source Code 
* Modular Run-time Images 
* Encapsulate Java Internal APIs 
* Java Platform Module System

## Quick Remarks

* The JDK 9 itself has been divided into a set of modules. It does NOT contain JRE, rather JRE is separated into a separate distribution folder. JDK 9 contains a new folder “jmods” instead of "jre". 

* It removes "rt.jar" and "tools.jar" from the Java runtime image.

* All JDK Modules starts with “jdk.#”. All Java SE Specifications Modules starts with “java.#”

* Java 9 Module System has a “java.base” module. It’s default module for all JDK Modules and User-Defined Modules.
  
* There are four types of modules in the new module system:
    * System Modules – These are the modules listed when we run the list-modules command above. They include the Java SE and JDK modules.
    * Application Modules – These modules are what we usually want to build when we decide to use Modules. They are named and defined in the compiled module-info.class file included in the assembled JAR.
    * Automatic Modules – We can include unofficial modules by adding existing JAR files to the module path. The name of the module will be derived from the name of the JAR. Automatic modules will have full read access to every other module loaded by the path.
    * Unnamed Module – When a class or JAR is loaded onto the classpath, but not the module path, it’s automatically added to the unnamed module. It’s a catch-all module to maintain backward compatibility with previously-written Java code.
    
* Try below commands:
    * Display list of all system modules (i.e. the Java SE and JDK modules): `java --list-modules`
    * Display list of java se specifications modules: `java --list-modules | grep "java\."`
    * Describe specific module: `java --describe-module <module-name>` (e.g. `java --describe-module java.sql`)
    
* Like Java 8 or prior applications have Packages as a Top level components, Java 9 or later applications have Module as Top Level components. Java 9 Module contains the these main components: (1) One Module (2) Module Name (3) Module Descriptor (i.e. module-info.java) (4) Set of Packages (5) Set of Types and Resources.

* Introduces the modular JAR file, which is a JAR file with a module-info.class file in its root directory. However, usage of such module system is optional while building a java application. If we use, there can be only one module per JAR file.

* Related tools
    * Introduces a new optional phase, link time, which is in-between compile time and run time, during which a set of modules can be assembled and optimized into a custom runtime image; see the [jlink tool](https://docs.oracle.com/javase/9/tools/jlink.htm)
    * Adds options to the tools javac, jlink, and java where you can specify module paths, which locate definitions of modules (e.g. "--add-exports" and "--add-modules").
    * Introduces the JMOD format, which is a packaging format similar to JAR except it can include native code and configuration files; see the [jmod tool](https://docs.oracle.com/javase/9/tools/jmod.htm).
    * Run the command "jdeps -jdkinternals" to determine if your code uses internal JDK APIs.

## Sample code

* HelloWorld Modules [(1)](https://github.com/tirthalpatel/Learning-Java/tree/master/Java9/modules.com.hello) and [(2)](https://github.com/tirthalpatel/Learning-Java/tree/master/Java9/modules.com.hello.client)
    * See respective "module-info.java"
    * Run "HelloWorldClient" in "modules.com.hello.client" module using IDE (e.g. Intellij -> Ctrl+Shift+F10)

* Java Platform Module System : Migration Concerns for Encapsulated Types - see "EncapsulatedTypeMigrationDemo.java" for "--illegal-access=permit" and "--add-exports" options usage.
    * EncapsulatedTypeMigrationDemo.java: Search for "UNCOMMENT BELOW LINE" and uncomment those 2 lines   
    * Run JDK 8 compiled code with Java 9: `cd <xxx>\Java9\src\main\java` ---> `java --illegal-access=permit com.tirthal.learning.langfeatures.jigsaw.EncapsulatedTypeMigrationDemo` (also try with `--illegal-access=deny` to see the exception)
    * Compile with JDK 9: `cd <xxx>\Java9\src\main\java\com\tirthal\learning\langfeatures\jigsaw` ---> `javac --add-exports java.base/sun.security.x509=ALL-UNNAMED EncapsulatedTypeMigrationDemo.java` 
    * Run with Java 9:  `cd <xxx>\Java9\src\main\java` ---> `java --add-exports java.base/sun.security.x509=ALL-UNNAMED com.tirthal.learning.langfeatures.jigsaw.EncapsulatedTypeMigrationDemo`    
    * How to determine, if the code uses internal JDK APIs or not: `cd <xxx>\Java9\src\main\java\com\tirthal\learning\langfeatures\jigsaw` ---> `jdeps.exe -jdkinternals EncapsulatedTypeMigrationDemo.class`

* Java Platform Module System : Migration Concerns for Non-default Modules - see "NonDefaultModuleMigrationDemo.java" for "--add-modules" option usage.
    * NonDefaultModuleMigrationDemo.java: Search for "UNCOMMENT BELOW LINE" and uncomment those 2 lines   
    * Compile with JDK 9 (without --add-modules option): `cd <xxx>\Java9\src\main\java\com\tirthal\learning\langfeatures\jigsaw` ---> `javac NonDefaultModuleMigrationDemo.java` : Gives "error: package javax.xml.bind does not exist"
    * Compile with JDK 9(with --add-modules option): `javac --add-modules java.xml.bind NonDefaultModuleMigrationDemo.java` | `javac --add-modules java.se.ee NonDefaultModuleMigrationDemo.java`
    * Run with Java 9:  `cd <xxx>\Java9\src\main\java` ---> `java --add-modules java.xml.bind com.tirthal.learning.langfeatures.jigsaw.NonDefaultModuleMigrationDemo` | `java --add-modules java.se.ee com.tirthal.learning.langfeatures.jigsaw.NonDefaultModuleMigrationDemo`
    * How to determine, if the code uses internal JDK APIs or not: `cd <xxx>\Java9\src\main\java\com\tirthal\learning\langfeatures\jigsaw` ---> `jdeps.exe -jdkinternals NonDefaultModuleMigrationDemo.class`


## Also Refer

For more detail, see 

* [Project Jigsaw](http://openjdk.java.net/projects/jigsaw/)
* [Project Jigsaw: Module System Quick-Start Guide](http://openjdk.java.net/projects/jigsaw/quick-start)
* [JDK 9 Platform Modules Diagram](https://res.infoq.com/presentations/java9-jigsaw/en/slides/sl19.jpg) 
* [Modular Development with JDK 9](https://blogs.oracle.com/java/modular-development)
* [A Guide to Java 9 Modularity](https://www.baeldung.com/java-9-modularity)
* [Java SE 9: Develop and Test HelloWorld Module With Eclipse And IntelliJ IDEA IDEs](https://www.journaldev.com/13630/javase9-helloworld-module-ides-part4)
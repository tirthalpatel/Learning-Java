# Nashorn = A JavaScript Engine on the JVM

* Java 6 : added JSR-223 spec to support multiple scripting languages (e.g. JavaScript, Groovy..)

* Java 7 : JDKs shipped with a JavaScript scripting engine based on Mozilla Rhino

* Java 8 : Replaced JavaScript Engine “Mozilla Rhino” with a new engine called “Oracle Nashorn” to offer better runtime performance

## Invoking Nashorn from the Command Line

- jjs = The Nashorn REPL (Read, Evaluate, Print Loop)
- It is located in $Java_HOME/bin.
- jjs allows to interactively type in and execute Java and JavaScript via shell. 
- Open command prompt & just type "jjs". Now just try Nashorn REPL, i.e.,

		jjs> 'Hello world!'.length()
		12
		jjs> var s = new java.lang.String("Hello World!");
		jjs> s.length()
		12
		jjs> s.toUpperCase()
		HELLO WORLD!

## Invoking Java Methods from Javascript

- Run [hello2.js](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/nashorn/hello2.js) (i.e., D:\Learning-Java\Java8> jjs -classpath "bin" src\com\tirthal\learning\libfeatures\nashorn\hello2.js) & see its code

## Invoking Javascript Functions from Java

- Run [Hello.java](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/nashorn/Hello.java) & see its code

## Launching a JavaFX Application through Nashorn

- Run [helloJavaFX.js](https://github.com/tirthalpatel/Learning-Java/blob/master/Java8/src/com/tirthal/learning/libfeatures/nashorn/helloJavaFX.js) using "jjs -fx" (i.e., D:\Learning-Java\Java8> jjs -fx src\com\tirthal\learning\libfeatures\nashorn\helloJavaFX.js) & see its code

## Nashorn and Shell Scripting

- Enable shell scripting extensions in Nashorn using the [jjs command with the -scripting option](https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/nashorn/shell.html).

## Also Read
 
- https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/nashorn/toc.html
- http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
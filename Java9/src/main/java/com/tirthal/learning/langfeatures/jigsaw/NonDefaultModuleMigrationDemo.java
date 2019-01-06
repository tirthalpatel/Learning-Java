package com.tirthal.learning.langfeatures.jigsaw;

// UNCOMMENT BELOW LINE
//import javax.xml.bind.DatatypeConverter;

/**
 * What could be migration concern of Java 8 to Java 9 code for Non-default Modules?
 * <p>
 * The Modular JDK 9 offers non-default modules too (e.g. java.xml.bind)
 * <p>
 * If Java 8 code uses such non-default modules of JDK 9, then how would it offer backward compatibility (without the need of code change) when migrating code from Java 8 to Java 9?
 * <p>
 * Well, need to use "--add-modules" option with javac and java in such case.
 */
public class NonDefaultModuleMigrationDemo {

    public static void main(String[] args) {

        // UNCOMMENT BELOW LINE
        //DatatypeConverter.parseBase64Binary("blahblahblah");
        System.out.println("NonDefaultModuleMigrationDemo executed successfully");
    }
}

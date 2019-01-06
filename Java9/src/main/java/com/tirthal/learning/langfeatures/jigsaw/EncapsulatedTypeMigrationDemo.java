package com.tirthal.learning.langfeatures.jigsaw;

// UNCOMMENT BELOW LINE
//import sun.security.x509.X500Name;
import java.io.IOException;

/**
 * What could be migration concern of Java 8 to Java 9 code for Encapsulated Types?
 * <p>
 * The Modular JDK 9 offers default modules (e.g. java.base), which has (1) Public (i.e. exported) and (2) Private (i.e. encapsulated) APIs.
 * <p>
 * The public APIs of JDK 9 default modules is accessible in Java 8 code, when migrating from Java 8 to Java 9.
 * <p>
 * However, in case of the private APIs (e.g. sun.security.x509.x500Name) of JDK 9 default modules, it throws exception, when migrating from Java 8 to Java 9.
 * <p>
 * How does Java 9 offers backward compatibility without the need of code change?
 * (1) use of "--illegal-access=permit" option: If class is compiled with JDK 8 and executing on Java 9. This option is to be removed in future java release.
 * (2) use of "--add-exports java.base/sun.security.x509=ALL-UNNAMED": If class is compiled as well as executed with JDK 9: This is RECOMMENDED approach.
 */
public class EncapsulatedTypeMigrationDemo {

    public static void main(String[] args) throws IOException {

        // UNCOMMENT BELOW LINE
        //X500Name name = new X500Name("CN=user");
        System.out.println("EncapsulatedTypeMigrationDemo executed successfully");
    }
}

package com.tirthal.learning.langfeatures.mpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Java 9 – Try-With-Resources Syntax Enhancements
 *
 * Try-With-Resources statement : Introduced in Java 7 to avoid the redundant code that we had to write for exception handling,
 * however, it didn't allow the resources to be declared outside of the statement block (scope).
 *
 * Java 9 - allows to declare the resource outside of the Try-With-Resource block.
 */
public class TryWithResourceDemo {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("README.md");

        // ------------
        // Problem with the Try-With-Resources in Java 7 - It didn't allow the resources to be declared outside of the statement block (scope)
        // ------------

        try(FileInputStream fisDuplicate = fis) { // Java 7 – Resource declared outside – duplicate resource as workaround
            // Logic here
            fisDuplicate.read();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // ------------
        // Java 9 – Try-With-Resources Enhancements
        // ------------

        try(fis) { // Java 9 allows to declare the resource outside of the Try-With-Resource block
            // Logic here
            fis.read();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}

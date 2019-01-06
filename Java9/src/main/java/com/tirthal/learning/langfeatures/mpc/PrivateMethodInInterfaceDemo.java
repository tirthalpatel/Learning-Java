package com.tirthal.learning.langfeatures.mpc;

/**
 * Java 9 - Adds support for private interface methods
 *
 * Java 8 - Allowed to create default and static methods in Interface with the intention of having
 * new methods added to the interfaces without breaking the classes that already implemented those interfaces
 *
 * Java 9 - Introduced private methods in interfaces to remove the redundancy by sharing the common code of
 * multiple default methods through private methods.
 */
public interface PrivateMethodInInterfaceDemo {

    // Java 9 - Introduced private methods in interfaces to remove the duplicate code in default methods
    private void print() {
        System.out.println("Some duplicate code of default methods");
    }

    default void foo() {
        // System.out.println("Some duplicate code of default methods");

        print();
    }

    default void bar() {
        // System.out.println("Some duplicate code of default methods");

        print();
    }

    // Java 9 - Introduced private methods in interfaces to remove the duplicate code in static methods
    private static void printStatic() {
        System.out.println("Some duplicate code of static methods");
    }

    static void fooStatic() {
        // System.out.println("Some duplicate code of static methods");

        printStatic();
    }

    static void barStatic() {
        // System.out.println("Some duplicate code of static methods");

        printStatic();
    }
}

package com.tirthal.learning.langfeatures.mpc;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 9 – Anonymous Inner classes and Diamond Operator Syntax Improvement
 */
public class DiamondWithAnonymousClassDemo {

    //---------------
    // Before Java 7
    //---------------
    List<String> beforeJava7List = new ArrayList<String>();

    //---------------
    // Java 7
    //---------------
    List<String> inJava7List = new ArrayList<>();

    // However, had problem with the diamond operator while working with Anonymous Inner classes
    ArrayList<String> inJava7Annonymous = new ArrayList<String>() { // Cannot use just '<>' with anonymous inner classes
        @Override
        public boolean add(String s) {
            return super.add(s);
        };
    };

    //---------------
    // Java 9 - Anonymous Inner classes and Diamond Operator Syntax Improvement
    //---------------

    ArrayList<String> inJava9Annonymous = new ArrayList<>() { // Can use just '<>' with anonymous inner classes
        @Override
        public boolean add(String s) {
            return super.add(s);
        };
    };
}

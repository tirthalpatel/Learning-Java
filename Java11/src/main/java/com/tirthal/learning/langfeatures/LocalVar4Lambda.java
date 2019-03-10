package com.tirthal.learning.langfeatures;

import java.lang.annotation.Documented;
import java.util.Arrays;
import java.util.List;

/**
 * The reserved type name var can now be used when declaring the formal parameters of a lambda expression.
 */
public class LocalVar4Lambda {

    public static void main(String[] args) {

        List<String> countries = Arrays.asList("India", "China", "Australia");

        // Prior to Java 10 - compiler does type inference for local variable anyway
        countries.stream()
                .map(s -> s.toUpperCase())  // var can't be used to declare "s" within lambda
                .forEach(System.out::println);

        // In Java 11
        countries.stream()
                .map((var s) -> s.toUpperCase())  // var can now be used when declaring the formal parameters of a lambda expression
                .forEach(System.out::println);


        // Compiler infers type anyway, so why added var support for this special case?
        // B'cas usage "var" enables us to add an annotation to the Lambda parameter, for example, @Nullable / @Nonnull

        /*
        countries.stream()
                .map((@Nullable var s) -> s.toUpperCase())
                .forEach(System.out::println);
        */

        // If var is used for any formal parameter of a lambda expression,
        // then it must be used for all formal parameters of that lambda expression

        // (String a, String b) -> a.concat(b)  // Valid syntax
        // (a, b) -> a.concat(b)                // Valid syntax
        // (var a, var b) -> a.concat(b)        // Valid syntax
        // (var a, b) -> a.concat(b)            // Invalid syntax
        // (var a, String b) -> a.concat(b)     // Invalid syntax

    }


}

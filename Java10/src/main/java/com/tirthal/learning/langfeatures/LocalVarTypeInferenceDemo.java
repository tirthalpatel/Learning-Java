package com.tirthal.learning.langfeatures;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Demo code snippet for "var" usage in Java 10 for Local-Variable Type Inference
 */
public class LocalVarTypeInferenceDemo {

    public static void main(String[] args) {

        // Local-Variable Type Inference does NOT make Java a dynamic language, rather type is still there and it's now only inferred by compiler

        // ---------------------
        // Usage of "var" for Local-Variable Type Inference
        // ----------------------

        // Prior to Java 10 - Traditional Java code
        LocalDate localDate = LocalDate.of(1981, Month.AUGUST, 06);
        Period period = localDate.until(LocalDate.now());
        System.out.printf("My age is: %s years \n", period.getYears());

        // Java 10 way of Local-variable type inference
        var myBirthDate = LocalDate.of(1981, Month.AUGUST, 06);
        var myAgePeriod = myBirthDate.until(LocalDate.now());
        System.out.printf("My age is: %s years \n", myAgePeriod.getYears());

        // Wow, code looks clean and more readable

        // While using "var", always focus on variable names instead of Type
        // As a developer - No need to repeat type which is already known on right side, rather just give meaningful variable names

        var ageList = new ArrayList<Integer>();

        var result = ageList.stream().filter(n -> n > 25).max(Math::max); // Such chaining code is hard to understand and debug

        // Instead of above single chaining line, should try to refactor in more logical steps with meaningful variable names
        var adultsAgeStream = ageList.stream().filter(age -> age > 25);
        var maxAge = adultsAgeStream.max(Math::max).orElse(0);

        // -----------------
        // Limitation of Type Inference
        // -----------------

        // (1) Lambdas must have an explicit target type

        // Uncomment below lines to see compile time error
        // var isStrSizeFive = s -> s.length() == 5;   // Invalid, b'cas compiler doesn't know type to infer
        // var isStrSizeFive = (String s) -> s.length() == 5;   // Still Invalid, b'cas compiler doesn't know this belongs to which Functional Interface!

        Predicate<String> isStrSizeFive = s -> s.length() == 5; // Valid, b'cas compiler knows this is String type of Predicate

        // (2) Usage with Diamond operator

        var colorsList1 = new ArrayList<>(); // Valid syntax, but compiler doesn't know type and infers to ArrayList<Object>
        var colorsList2 = new ArrayList<String>(); // Recommended to declare type explicitly

        // (3) Array initializer is not allowed

        int[] nums1 = {1, 2, 3}; // Array initializer syntax

        // Uncomment below line to see compile time error
        // var nums2 = {1, 2, 3}; // Invalid, b'cas array initializer is not allowed
        var num3 = new int[]{1, 2, 3}; // Valid

        // (4) Be cautious while using "var" with non-denotable types

        // Assigning null can not infer type
        // var abc = null; // Invalid

        var mixedList = List.of(1, 4, "Tirthal"); // Valid syntax - Surprisingly this will infer to "List<? extends Serializable & Comparable<..>>"

        // (5) Only for Local Type Inference

        // Usage of "var" is NOT applicable for Method parameters, Return Types, Fields and Catch blocks
    }

    // Uncomment below line to see compile time error
    // var invalidTypeInference = "This won't work";
}

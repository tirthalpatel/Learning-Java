package com.tirthal.learning.langfeatures.mpc;

import java.util.Arrays;
import java.util.List;

/**
 * Java 7 introduced the @SafeVarargs annotation to suppress the unsafe operation warnings that arises
 * when a method is having varargs (variable number of arguments). The @SafeVarargs annotation can only
 * be used with methods (final or static methods or constructors) that cannot be overriden because
 * an overriding method can still perform unsafe operation on their varargs (variable number of arguments)
 *
 * Java 9 extended the use of @SafeVarargs annotation, it can now used with private methods as well.
 * This is because private methods cannot be overridden. Earlier this annotation was limited to the final
 * or static methods, or constructors but now it can be used with private methods.
 */
public class SafeVarargsDemo {

    public static void main(String[] args) {

        List<String> colors = List.of("Red", "Blue, Green");

        SafeVarargsDemo obj = new SafeVarargsDemo();
        obj.printWithoutSafeVarargs(colors);

        obj.printWithSafeVarargs(colors);
    }

    // Shows warnings at compile time: "Type safety: Potential heap pollution via varargs parameter names"
    private void printWithoutSafeVarargs(List... colors) {
        Arrays.stream(colors).forEach(System.out::println);
    }

    // --------------
    // Java 9 extended the use of @SafeVarargs annotation for primate methods
    // --------------
    @SafeVarargs
    private void printWithSafeVarargs(List... colors) {
        Arrays.stream(colors).forEach(System.out::println);
    }
}

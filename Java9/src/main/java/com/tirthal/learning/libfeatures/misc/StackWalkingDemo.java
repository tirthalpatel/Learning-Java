package com.tirthal.learning.libfeatures.misc;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demo of new stack inspection API
 */
public class StackWalkingDemo {

    public static void main(String... args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        method4();
    }

    public static void method4() {
        StackWalker walker = StackWalker.getInstance();

        walker.forEach(System.out::println);

        // The walk method opens a sequential stream of StackFrames for the current thread and then applies the given function to walk the StackFrame stream
        List<Integer> lines = walker.walk(stackStream ->
                stackStream.filter(f -> f.getMethodName().startsWith("m"))
                           .map(StackWalker.StackFrame::getLineNumber)
                           .collect(Collectors.toList())
        );

        lines.forEach(System.out::println);
    }
}

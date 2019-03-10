package com.tirthal.learning.misc.launcher;

import java.nio.file.*;

/**
 * To run single-file source-code program,
 *
 * Prior to Java 11, it's two step process: (1) Compile: `javac ListFiles.java .` (2) Run: `java ListFiles .`
 *
 * Java 11, it's single step now to run directly (without the need of compiling code): `java ListFiles.java .`
 */
public class ListFiles {

    public static void main(String[] args) throws Exception {
        Files.walk(Paths.get(args[0]))
                .forEach(System.out::println);
    }
}

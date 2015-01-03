package com.xtra_ref.transforming_code_to_java_8.exercise_4.before;

import java.util.*;
import java.io.*;

public class Sample {
	public static void main(String[] args) {
		File aDirectory = new File(".");

		// -------- Prior to Java 8 way - read files in current directory
		List<String> filesInDir = new ArrayList<>();
		for (File child : aDirectory.listFiles()) {
			filesInDir.add(child.getName());
		}

		for (int i = 0; i < filesInDir.size(); i++) {
			System.out.print(filesInDir.get(i));
			if (i != filesInDir.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
		// -------- Prior to Java 8 way - read files in current directory
	}
}
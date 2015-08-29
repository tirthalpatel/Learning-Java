package com.tirthal.learning.langfeatures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Project Coin Feature - Try With Resources Statement

/*
 * The try-with-resources statement is a try statement that declares one or more resources. A resource is as an object that must be closed after the program is finished with it.
 * The try-with-resources statement ensures that each resource is closed at the end of the statement.
 *
 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.
 * The old Closable interface introduced in Java 5, which also has the same method that now extends from AutoClosable, implying that all Closable classes are automatically Auto-Closable.
 * Those classes automatically become resources that can be created in the try statement. The slight difference in AutoClosable and Closable is that unlike Closable.close(), AutoClosable.close()
 * is not supposed to be idempotent, which means that calling it twice can have side effects. The second difference is that since exceptions thrown from AutoClosable. close() are suppressed,
 * AutoClosable.close() should not throw exceptions which can cause problems when suppressed, like the InterruptedException.
 *
 * A try-with-resources statement can have catch and finally blocks just like an ordinary try statement. In a try-with-resources statement, any catch or finally block is run after the resources declared have been closed.
 */

/**
 * Test class for syntax for resource management
 *
 * @author tirthalp
 *
 */
@SuppressWarnings("unused")
public class TryWithResources_TestDrive {

	// --- Prior to Java 7
	private static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
		/*
		 * You can use a finally block to ensure that a resource is closed regardless of whether the try statement completes normally or abruptly.
		 * The following example uses a finally block instead of a try-with-resources statement:
		 */
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	// --- In Java 7 or later
	private static String readFirstLineFromFile(String path) throws IOException {

		/*
		 * The resource declared in the try-with-resources statement is a BufferedReader. The declaration statement appears within parentheses immediately after the try keyword.
		 * The class BufferedReader, in Java SE 7 and later, implements the interface java.lang.AutoCloseable. Because the BufferedReader instance is declared in a try-with-resource statement,
		 * it will be closed regardless of whether the try statement completes normally or abruptly (as a result of the method BufferedReader.readLine throwing an IOException).
		 */
		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
			return br.readLine();
		}
	}

}

package com.tirthal.learning.tips;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Effective Java Tip (<a href="http://blog.agiledeveloper.com/2015/06/lambdas-are-glue-code.html">See Also</a>):
 * 
 * Always better to move Lambda's in-line logic into separate method / Lambda expressions should be glue code (Unlike
 * methods and classes, lambdas lack names and documentation; if a computation isn’t self-explanatory, or exceeds a few
 * lines, don’t put it in a lambda. One line is ideal for a lambda, and three lines is a reasonable maximum.)
 * 
 * @author tirthalp
 */
public class EffectiveJavaTip01 {

	// Example of BiFunction - Take List of String and Integer number, return another List String
	public static BiFunction<List<String>, Integer, List<String>> strBooster = (strList, echoFactor) -> {

		Objects.requireNonNull(strList);
		Objects.requireNonNull(echoFactor);

		// -----------------------------------------------------------------------
		// Tip: Always better to move Lambda's in-line logic into separate method
		// -----------------------------------------------------------------------

		List<String> l = strList.stream().map(s -> repeater(s, echoFactor)).collect(Collectors.toList());

		// Replaced below clumsy commented code with above clean code

		/*List<String> l = strList.stream().map(s -> {
												StringBuffer sb = new StringBuffer();
												for (int i = 1; i <= echoFactor; i++)
													sb.append(s + " ");
												return sb.toString();
										   })
										   .collect(Collectors.toList());*/

		return l;
	};

	// Repeat each String from input List by given number of times
	private static String repeater(String input, Integer count) {

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= count; i++)
			sb.append(input + " ");
		return sb.toString();
	}
}

package com.tirthal.learning.tips;

import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.function.Supplier;

import org.junit.Test;

public class EffectiveJavaTip02Test {

	@Test
	public void should_GeneratePassword_When_UsingPasswordGeneratorFunctionalInterface() {
		
		// Arrange
		PasswordGenerator simplePasswordGenerator = () -> "p@"+UUID.randomUUID().toString();
		String expectedPrefix = "p@";
		
		// Act
		String actual = EffectiveJavaTip02.generatePassword(simplePasswordGenerator);
		
		//Assert		
		assertTrue(actual.startsWith(expectedPrefix));
	}
	
	@Test
	public void should_GeneratePassword_When_UsingSupplierFunctionalInterface() {
		
		// Arrange
		Supplier<String> complexPasswordGenerator = () -> "p@super"+UUID.randomUUID().toString()+"$secret@";
		String expectedPrefix = "p@super";
		String expectedPostfix = "$secret@";
		
		// Act
		String actual = EffectiveJavaTip02.generatePassword(complexPasswordGenerator);
		
		//Assert		
		assertTrue(actual.startsWith(expectedPrefix));
		assertTrue(actual.endsWith(expectedPostfix));
	}
}
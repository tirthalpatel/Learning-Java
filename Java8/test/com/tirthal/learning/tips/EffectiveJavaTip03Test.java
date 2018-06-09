package com.tirthal.learning.tips;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class EffectiveJavaTip03Test {

	@Test
	public void should_DoSumOfMapValues_When_NonNullMapIsGiven() {
		
		// Arrange
		Map<String, Integer> exMap = createSampleMapData();
		int expected = 236;
		
		// Act
		int actual = EffectiveJavaTip03.doSumOfMapValues(exMap);
		
		//Assert		
		assertEquals(expected, actual);
	}
	
	@Test
	public void should_FindLongestLineLength_When_NonNullFileIsGiven() {
		
		// Arrange
		int expected = 104;
		
		// Act
		int actual = 0;
		try {
			actual = EffectiveJavaTip03.findLongestLineLength(MAVEN_POM_FILE);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void should_FindLongestLine_When_NonNullFileIsGiven() {
		
		// Arrange
		String expected = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
		
		// Act
		String actual = "";
		try {
			actual = EffectiveJavaTip03.findLongestLine(MAVEN_POM_FILE);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		//Assert
		assertEquals(expected, actual);
	}
		
	private static Map<String, Integer> createSampleMapData() {

		Map<String, Integer> exMap = new HashMap<>();
		exMap.put("key1", 10);
		exMap.put("key2", 5);
		exMap.put("key3", 145);
		exMap.put("key4", 22);
		exMap.put("key5", 54);

		return exMap;
	}
	
	private static final File MAVEN_POM_FILE = Paths.get(".\\pom.xml").toFile();
}
package com.tirthal.learning.tips;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.tirthal.learning.tips.EffectiveJavaTip01.strBooster;
import static org.junit.Assert.*;

public class EffectiveJavaTip01Test {

    @Test
    public void should_RepeatStringInListByEchofactory_When_BothInputParamsAreNonNull() {

    	// Arrange
        List<String> inputStrList = Arrays.asList("Hi", "Hello", "Ola");
        List<String> expected = Arrays.asList("Hi Hi Hi ", "Hello Hello Hello ", "Ola Ola Ola ");
        
        // Act
        List<String> actual = strBooster.apply(inputStrList, 3);

        // Assert        
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowNullPointerException_When_BothNullValues() {
        strBooster.apply(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowNullPointerException_When_StringListIsNull() {
        strBooster.apply(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void should_ThrowNullPointerException_When_EchofactoryIsNull() {
        strBooster.apply(Arrays.asList("Hi", "Hello", "Ola"), null);
    }
}
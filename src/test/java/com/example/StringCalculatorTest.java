package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator("delimeter","numbers");
    @Test
    void whenAStringHaveNothingThanIGetBack0() {
        var result = stringCalculator.add("");

        assertEquals(0, result);
    }
    @Test
    void mathIsEasy3Plus5Is8() {
        assertThat(stringCalculator.add("3,5")).isEqualTo(8);
    }

    @Test
    void worksWithfourNumbersAndGetTheCorrectSum() {
        assertThat(stringCalculator.add("7,6,3,1")).isEqualTo(17);
    }

    @Test
    void shouldWorkWithANewLine() {
        assertThat(stringCalculator.add("9\n5")).isEqualTo(14);
    }

    @Test
    void splitMoreThanTwoNumbersAndReturnSum() {
        assertThat(stringCalculator.add("3,2\n5")).isEqualTo(10);
    }

    @Test
    void usesDelimiterSpec(){
        assertThat(stringCalculator.add("//;\n1;2")).isEqualTo(3);
        assertThat(stringCalculator.add("//.\n2.3.1")).isEqualTo(6);
    }


    @Test
    void IfANegativeNumberIsPresentThrowAException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {stringCalculator.add("-3,-4");
        });
        String expected = "All numbers that are negative are not allowed: -3,-4";
        String result = exception.getMessage();

        assertThat(result).isEqualTo(expected);
    }
    @Test
    void trowsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {stringCalculator.add("1,-3,2,-4");});
        String expected = "All numbers that are negative are not allowed: -3,-4";
        String result = exception.getMessage();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void mapsNumberAbove1000ToLastTreeDigits(){
        assertThat(stringCalculator.add("1002")).isEqualTo(2);
    }
    @Test
    void acceptDelimiterOfArbitraryLength(){
        assertThat(stringCalculator.add("//[***]\n1***2***3")).isEqualTo(6);

}
    @Test
    void acceptsMultipleDelimiters(){
        assertThat(stringCalculator.add("//[-][;]\n1-2;3")).isEqualTo(6);
        assertThat(stringCalculator.add("//[--][...]\n2--3...4")).isEqualTo(9);
    }


}

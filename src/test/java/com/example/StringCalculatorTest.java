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
    }


}
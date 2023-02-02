package com.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
    private String delimiter;
    private String numbers;

    public StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    private  int sum() {
        ensureNoNegativeNumbers();
        return getNumber().sum();
    }

    private void ensureNoNegativeNumbers() {
        String negativeNumbersSequence = getNumber().filter(n ->n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if (!negativeNumbersSequence.isEmpty()){
            throw new IllegalArgumentException("All numbers that are negative are not allowed: "
                    +negativeNumbersSequence);
        }
    }

    private IntStream getNumber() {
        if (numbers.isEmpty()){
            return IntStream.empty();
        }else {
            return Stream.of(numbers.split(delimiter))
                    .mapToInt(Integer::parseInt)
                    .map(n-> n % 1000);
        }
    }

    public int add(String ManyNumbers) {
        if (ManyNumbers.isEmpty())
            return 0;

        return parseInput(ManyNumbers).sum();
    }
    private static StringCalculator parseInput(String ManyNumbers) {

        if (ManyNumbers.startsWith("//")){
            String[] parts = ManyNumbers.split("\n",2);
            return new StringCalculator(parts[0].substring(2), parts[1]);
        }
        else {
            return new StringCalculator(",|\n", ManyNumbers);
        }
    }
}

package com.example;


import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
    private final String delimiter;
    private final String numbers;

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
            String[] headerAndNumberSequence = ManyNumbers.split("\n",2);
            String delimiter = parseDelimiter(headerAndNumberSequence[0]);
            return new StringCalculator(delimiter, headerAndNumberSequence[1]);
        }
        else {
            return new StringCalculator(",|\n", ManyNumbers);
        }
    }

    private static String parseDelimiter(String header) {
        String delimiter = header.substring(2);
        if (delimiter.startsWith("[")){

            delimiter = delimiter.substring(1,delimiter.length()-1);
        }
        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}

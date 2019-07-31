package com.thoughtworks.collection;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return IntStream.rangeClosed(leftBorder, rightBorder).filter(element -> element % 2 == 0).sum() +
                IntStream.rangeClosed(rightBorder, leftBorder).filter(element -> element % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return IntStream.rangeClosed(leftBorder, rightBorder).filter(element -> element % 2 == 1).sum() +
                IntStream.rangeClosed(rightBorder, leftBorder).filter(element -> element % 2 == 1).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(element -> element * 3 + 2).reduce((a, b) -> a + b).orElse(-1);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(element -> element % 2 == 0 ? element : element * 3 + 2)
                .collect(toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(isOdd())
                .map(element -> element * 3 + 5)
                .reduce((a, b) -> a + b).orElse(-1);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(isEven())
                .sorted()
                .collect(Collectors.toList());
        long count = evenList.size();
        return evenList.stream()
                .skip((count - 1) / 2).limit(2 - count % 2)
                .mapToDouble(Integer::doubleValue)
                .average().orElse(Double.NaN);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(isEven())
                .mapToDouble(Integer::doubleValue)
                .average().orElse(Double.NaN);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(isEven())
                .anyMatch(element -> element.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(isEven())
                .distinct().collect(toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        return Stream.concat(arrayList.stream().filter(isEven()),
                arrayList.stream().filter(isOdd()).sorted(reverseOrder())).collect(toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size() - 1).boxed()
                .map(index -> (arrayList.get(index) + arrayList.get(index + 1)) * 3)
                .collect(Collectors.toList());
    }

    private Predicate<Integer> isEven() {
        return element -> element % 2 == 0;
    }

    private Predicate<Integer> isOdd() {
        return element -> element % 2 == 1;
    }
}

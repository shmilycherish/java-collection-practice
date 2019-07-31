package com.thoughtworks.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return Stream.concat(
                IntStream.rangeClosed(left, right).boxed(),
                IntStream.rangeClosed(right, left).boxed().sorted(Collections.reverseOrder()))
                .collect(toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return Stream.concat(
                IntStream.rangeClosed(left, right).boxed().filter(element -> element % 2 == 0),
                IntStream.rangeClosed(right, left).boxed().filter(element -> element % 2 == 0).sorted(Collections.reverseOrder()))
                .collect(toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return stream(array).boxed().filter(element -> element % 2 == 0).collect(toList());
    }

    public int popLastElment(int[] array) {
        List<Integer> collect = stream(array).boxed().collect(toList());
        Collections.reverse(collect);
        return collect.stream().findFirst().orElse(-1);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = stream(firstArray).boxed().collect(toList());
        List<Integer> secondList = stream(secondArray).boxed().collect(toList());
        firstList.retainAll(secondList);
        return firstList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        return Stream.concat(stream(firstArray), stream(secondArray)).distinct().collect(toList());
    }
}

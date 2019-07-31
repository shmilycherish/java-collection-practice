package com.thoughtworks.collection;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int divideStep = random.nextInt(3);
        return IntStream.range(0, number).boxed()
                .sorted(reverseOrder())
                .filter(element -> (number - element) % divideStep == 0)
                .collect(toList());
    }
}

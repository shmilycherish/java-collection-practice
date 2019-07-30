package com.thoughtworks.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Integer::compareTo).orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().min(Integer::compareTo).orElse(0);
    }

    public double getAverage() {
        return arrayList.stream().mapToDouble(i -> i).average().orElse(0);
    }

    public double getMedian() {
        return getMiddlePositionNumber();
    }

    public double getOrderedMedian() {
        Collections.sort(arrayList);
        return getMiddlePositionNumber();
    }

    private double getMiddlePositionNumber() {
        if (arrayList.size() % 2 == 0) {
            int medianFirst = arrayList.size() / 2;
            return (double)(arrayList.get(medianFirst) + arrayList.get(medianFirst - 1)) / 2;
        } else {
            return arrayList.get(arrayList.size() / 2);
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(element -> element % 2 == 0).findFirst().orElse(0);
    }

    public int getIndexOfFirstEven() {
        return IntStream.range(0, arrayList.size()).filter(index -> arrayList.get(index) % 2 == 0)
                .findFirst().orElse(-1);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.containsAll(arrayList) && arrayList.containsAll(this.arrayList);
    }


    public int getLastOdd() {
        return arrayList.stream().filter(element -> element % 2 == 1)
                .reduce((result, next) -> next).orElse(-1);
    }

    public int getIndexOfLastOdd() {
        return IntStream.range(0, arrayList.size()).filter(element -> element % 2 == 1)
                .reduce((result, next) -> next).orElse(-1);
    }
}

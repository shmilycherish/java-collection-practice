package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(element -> element * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(element -> letters[element - 1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(element -> {
            String result = "";
            int temp  = element;
            do {
              result = getUnit(temp) + result;
              temp = adjustNumber(temp);
            } while (getLettersIndex(temp) > 0);
            return result;
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }

    private String getUnit(int element) {
        return getLettersIndex(element) == 0 ? "z" : letters[getLettersIndex(element) - 1];
    }

    private int getLettersIndex(int element) {
        return element % letters.length;
    }

    private int adjustNumber(int left) {
        return getLettersIndex(left) == 0 ? left / letters.length - 1 : left / letters.length;
    }
}
